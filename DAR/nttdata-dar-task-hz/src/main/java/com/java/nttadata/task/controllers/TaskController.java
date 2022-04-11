package com.java.nttadata.task.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.java.nttadata.task.models.Tasks;
import com.java.nttadata.task.services.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	@Autowired
	TaskService taskService ;
	
	@GetMapping("/listAll")
	public ArrayList<Tasks> ShowAllTasks(){
		return taskService.showAllTasks();
	}
	
	@GetMapping("/findById/{id}")
	public Optional<Tasks> findById(@PathVariable("id")Long id)
	{
		return this.taskService.findById(id);
	}
	
	
	@GetMapping("/findByDescription/{desc}")
	public Optional<Tasks> findByDesc(@PathVariable("desc")String desc)
	{
		
		return this.taskService.findByDesc(desc);
	}
	
	@GetMapping("/findByStatus/{status}")
	public Optional<Tasks> findByStatus(@PathVariable("status")String status)
	{
		return this.taskService.findByStatus(status);
	}
	
	@PostMapping("/newTask")
	public Tasks AddNewTask(@RequestBody Tasks task) {
		return this.taskService.AddNewTask(task);
	}
	
	@PutMapping("/updateStatus/{status}")
	public Optional<Tasks> changeStatus(@PathVariable("status")String status)
	{
		return null;
	}
	
	@PutMapping("/updateStatus/{desc}")
	public Optional<Tasks> changeDesc(@PathVariable("desc")String desc)
	{
		return null;
	}
	
	@DeleteMapping("/deleteById/{id}")
	public Optional<Tasks> deleteById(@PathVariable("id")Long id) 
	{
		Boolean result = this.taskService.deleteTask(id);
		if(result) {
			return this.taskService.findById(id);
		}
		return Optional.ofNullable(null);
	}
	
	@DeleteMapping("/deleteAll")
	public ArrayList<Tasks> deleteAll()
	{
		Boolean result = this.taskService.deleteAll();
		if(result==true) 
		{
			return taskService.showAllTasks();
		}
		
		return null;
	}
	
}
