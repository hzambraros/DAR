import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {MessagesService} from '../service/messages.service';
import {Task} from '../model/task';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  private taskUrl='https://api-manag-tasks.azure-api.net';
  constructor(private http: HttpClient,
    private messageService: MessagesService) { }

    getTasks(): Observable<Task[]> {
      return this.http.get<Task[]>(this.taskUrl.concat('/tasks/listAll'));
    }
}
