package com.java.nttadata.task.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends CrudRepository <Task, Long> {
	List<Task> findByDescription(String description);
	List<Task> findByStatus(String status);
	List<Task> findByDescAStatus(String description,String status);
}
