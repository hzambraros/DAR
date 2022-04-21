import { Component, OnInit } from '@angular/core';
import { TaskService } from '../service/task.service';
import {Task} from '../model/task';
import {MessagesService} from '../service/messages.service';
@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.scss']
})
export class TaskListComponent implements OnInit {

  constructor(private taskService: TaskService, private messagesService:MessagesService) { }

  selectTask?:Task;
  tasks:Task[] =[];
  ngOnInit(): void {
    
  }
 
  onSelect(task: Task):void{
    this.selectTask= task;
    this.messagesService.add(`Task selected id=${task.id}`);
  }

  getTasks(): void{
    this.taskService.getTasks().subscribe(tasks=>this.tasks=tasks);
  }

}
