package com.java.nttadata.task.service;
import java.util.ArrayList;

import com.java.nttadata.task.model.Task;

public interface ITaskService {
	ArrayList<Task> getAllTasks();
	ArrayList<Task> getAllCompletedTasks(String status);
	void addTask();
	Task updateTask(Long id, Task taskDetails);
	void deleteTask(Long IdTaskD);
	void deleteAll();
	
}
