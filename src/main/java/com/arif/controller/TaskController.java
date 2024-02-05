package com.arif.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.arif.model.Task;
import com.arif.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Task createTask(@RequestBody Task task) {
		return taskService.addTask(task);
	}

	@GetMapping
	public List<Task> getTasks() {
		return taskService.findAllTask();
	}

	@GetMapping("/{taskId}")
	public Task getTaskById(@PathVariable String taskId) {
		return taskService.getTaskByTaskId(taskId);
	}

	@GetMapping("/severity/{severity}")
	public List<Task> findTaskUsingSeverity(@PathVariable int severity) {
		return taskService.getTaskBySeverity(severity);
	}

	@GetMapping("/assignee/{assignee}")
	public List<Task> getTaskByAssignee(@PathVariable String assignee) {
		return taskService.getTaskByAssignee(assignee);
	}

	@PutMapping
	public Task modifiedTask(@RequestBody Task task) {
		return taskService.updateTask(task);
	}

	@DeleteMapping("/{taskId}")
	public String deleteTaskById(@PathVariable String taskId) {
		return taskService.deleteTask(taskId);
	}
}
