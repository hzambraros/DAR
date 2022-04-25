import { TaskListComponent } from './task-list/task-list.component';
import { Component, ViewChild } from '@angular/core';
import { TasksService } from './service/tasks.service'; 
import {Task} from './model/task';
import { ResourceLoader } from '@angular/compiler';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'dar-todo-list-front';
  tasks:Task[]=[];
  constructor(private tasksService: TasksService){}

  @ViewChild(TaskListComponent) taskListComponent : TaskListComponent | undefined;

  displayStyle = "none";
   OpenNewTask():void{
    this.displayStyle = "block";
  }
  closePopup() {
    this.displayStyle = "none";
    this.taskListComponent?.getTasks();
  }
  add(description: string, status: string):void{
    description= description.trim();
    status= status.trim();
    if (!description) {
      if(!status){
        return ;
      }
      return;
    }

    this.tasksService.addNewTask({description,status} as Task ).subscribe(task=>{this.tasks.push(task)});
  }
}
