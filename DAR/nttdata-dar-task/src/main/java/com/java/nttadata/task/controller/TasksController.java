package com.java.nttadata.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.java.nttadata.task.model.Task;
import com.java.nttadata.task.service.TaskService;

import java.util.ArrayList;
@RestController
public class TasksController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/listalltasks")
	public ArrayList<Task> getAllTasks()
	{
		return taskService.getAllTasks();
	}
	
	@GetMapping("/listcompletedtasks/{status}")
	public ArrayList<Task> getAllCompletedTasks(@PathVariable(value="status")String status)
	{
		return taskService.getAllCompletedTasks(status);
	}
	
	@PostMapping("/addnewtask")
	public void addTask() 
	{
		taskService.addTask();
	}
	
	
	@PutMapping("/updatetask/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable(value="id")Long id, @RequestBody Task taskDetails) throws ResourceNotFoundException 
	{
			return ResponseEntity.ok(taskService.updateTask(id, taskDetails));
	}
	
	
	@DeleteMapping("/deletetask/{id}")
	public void deleteTask(@PathVariable(value="id")Long id) 
	{
		taskService.deleteTask(id);
	}
	
	@DeleteMapping("/deleteall")
	public void deleteAll() 
	{
		taskService.deleteAll();
	}
	
	
	
	
	
	
	

}
