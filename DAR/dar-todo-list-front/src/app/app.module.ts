import { environment } from './../environments/environment.prod';
import { BASE_PATH } from './service/variables';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { TaskListComponent } from './task-list/task-list.component';
import { MessagesComponent } from './messages/messages.component';
import {TasksService} from './service/tasks.service';
import { FormsModule } from '@angular/forms';
import {ApiModule} from '../app/service/api.module'
@NgModule({
  declarations: [
    AppComponent,
    TaskListComponent,
    MessagesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    ApiModule
  ],
  providers: [TasksService],
  bootstrap: [AppComponent]
})
export class AppModule { }
