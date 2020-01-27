package com.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.task.models.Task;
import com.task.repository.TaskRepository;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@GetMapping
	public List<Task> index() {
		return this.taskRepository.findAll();
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Task> get(@PathVariable("id") long id) {
		return this.taskRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Task> store(@Valid @RequestBody Task task) {
		Task taskSave = this.taskRepository.save(task);
		return ResponseEntity.created(null).body(taskSave);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Task> update(@PathVariable("id") long id, @RequestBody Task task) {
		return this.taskRepository.findById(id)
			.map(record -> {
				record.setTitle(task.getTitle());
				record.setDescription(task.getDescription());
				Task updated = this.taskRepository.save(record);
				return ResponseEntity.ok().body(updated);
			}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> destroy(@PathVariable("id") long id) {
		return this.taskRepository.findById(id)
				.map(record -> {
					this.taskRepository.delete(record);
					return ResponseEntity.ok().build();
				})
				.orElse(ResponseEntity.notFound().build());
							
	}
	
	
}
