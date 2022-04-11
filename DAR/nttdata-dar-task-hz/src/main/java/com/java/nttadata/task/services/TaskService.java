package com.java.nttadata.task.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.nttadata.task.repositories.TaskRepository;
import com.java.nttadata.task.models.Tasks;;

@Service
public class TaskService {
	@Autowired
	TaskRepository taskrepository;
	
	public ArrayList<Tasks> showAllTasks()
	{
		return (ArrayList<Tasks>)taskrepository.findAll();
	}
	
	
	public Optional<Tasks> findById(Long id)
	{
		return taskrepository.findById(id);
	}
	
	public Optional<Tasks> findByDesc(String Desc)
	{
		Tasks task = new Tasks ();
		if(task.getDescription().contentEquals(Desc)) {
			return taskrepository.findByDescription(Desc);
		}
		return null;
	}
	
	public Optional<Tasks> findByStatus(String status)
	{
		Tasks task = new Tasks ();
		if(task.getStatus().contentEquals(status)) {
			return taskrepository.findByDescription(status);
		}
		return null;
	}
	
	public Tasks AddNewTask(Tasks task)
	{
		return taskrepository.save(task);
	}
	
	public boolean deleteTask(Long id) 
	{
		if(taskrepository.existsById(id)) 
		{
			taskrepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public boolean deleteAll() 
	{
		Long count=taskrepository.count();
		if(count>0) 
		{
			taskrepository.deleteAll();
			return true;
		}
		return false;
	}
}
