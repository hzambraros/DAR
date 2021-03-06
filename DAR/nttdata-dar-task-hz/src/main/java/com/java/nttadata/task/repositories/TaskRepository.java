package com.java.nttadata.task.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.nttadata.task.models.Tasks;

@Repository
public interface TaskRepository extends CrudRepository<Tasks,Long>  {
	public abstract Optional<Tasks> findById(Long id);
}
