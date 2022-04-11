package com.java.nttadata.task.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.java.nttadata.task.model.Task;
import com.java.nttadata.task.model.TaskRepository;

@Service
public class TaskService implements ITaskService{

	@Autowired
	private TaskRepository taskrepository;
	
	@Override
	public ArrayList<Task> getAllTasks() {
		return (ArrayList<Task>) taskrepository.findAll();
	}

	@Override
	public ArrayList<Task> getAllCompletedTasks(String status ) {
		return (ArrayList<Task>) taskrepository.findByStatus(status);
	}

	@Override
	public void addTask() {
		ArrayList<Task> tsk = new ArrayList<Task>();
		int current = (int) taskrepository.count();
		tsk.add(new Task("Description"+current,"TO-DO"));
		for(Task task : tsk) {
			taskrepository.save(task);
		}
		
	}

	@Override
	public Task updateTask(Long id, Task taskDetails) {
		Task task = taskrepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found on :: "+ id));
		
		task.setDescription(taskDetails.getDescription());
		task.setStatus(taskDetails.getStatus());
		final Task Utask = taskrepository.save(task);
		return Utask;
		
	}

	@Override
	public void deleteTask(Long id) {
		Boolean exists=taskrepository.existsById(id);
		int totalDB = (int) taskrepository.count();
		if(totalDB>0|| exists==true ) {taskrepository.deleteById(id);}
	}

	@Override
	public void deleteAll() {
		int totalDB = (int) taskrepository.count();
		if(totalDB>0) {taskrepository.deleteAll();}	
	}

}
