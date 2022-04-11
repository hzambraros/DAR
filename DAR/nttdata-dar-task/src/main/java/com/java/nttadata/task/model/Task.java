package com.java.nttadata.task.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity 
@Table(name="tasks")
public class Task {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 	@Column(name="id")
 	private long id;
 	@Column(name="description")
	private String description;
 	@Column(name="status")
	private String status;
	
	public Task() {
		super();
	}
	
	public Task(String description, String status ) {
		super();
		this.description = description;
		this.status = status;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
