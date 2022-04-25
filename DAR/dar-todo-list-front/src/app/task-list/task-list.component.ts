import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { TasksService } from '../service/tasks.service';
import {Task} from '../model/task';
import {MessagesService} from '../service/messages.service';
@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.scss']
})
export class TaskListComponent implements OnInit {

  constructor(private taskService: TasksService, private messagesService:MessagesService) { }

  selectTask?:Task;
  tasks:Task[] =[];
  @Input() task?: Task;
  ngOnInit(): void {
    this.getTasks();
  }
 
  onSelect(task: Task):void{
    this.selectTask=task;
    this.displayStyle = "block";
    this.taskService.findById(this.selectTask.id).subscribe((task: Task)=>this.tasks=this.tasks);
  }

  onSelectDelete(task: Task):void{
    this.tasks = this.tasks.filter(t=>t!==task);
    this.taskService.deleteById(task.id).subscribe();
  }


  getTasks(): void{
    this.taskService.showAllTasks().subscribe((tasks: Task[])=>this.tasks=tasks);
  }

  displayStyle = "none";
  
  closePopup() {
    this.displayStyle = "none";
  }

  modify(task: Task):void{
    if(task){
      this.taskService.modify(task).subscribe(()=> this.getTasks());
      this.closePopup();
    }
  }
}
