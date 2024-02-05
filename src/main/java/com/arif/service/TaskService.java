package com.arif.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arif.model.Task;
import com.arif.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public Task addTask(Task task) {
		task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
		return taskRepository.save(task);
	}

	public List<Task> findAllTask() {
		return taskRepository.findAll();
	}

	public Task getTaskByTaskId(String taskId) {
		return taskRepository.findById(taskId).get();
	}

	public List<Task> getTaskBySeverity(int severity) {

		return taskRepository.findBySeverity(severity);
	}

	public List<Task> getTaskByAssignee(String assignee) {

		return taskRepository.findByAssignee(assignee);
	}

	public Task updateTask(Task taskRequest) {
		// get the existing document from db.
		// populate new value from request to existing object/entity/document

		Task existingTask = taskRepository.findById(taskRequest.getTaskId()).get();

		existingTask.setAssignee(taskRequest.getAssignee());
		existingTask.setDescription(taskRequest.getDescription());
		existingTask.setSeverity(taskRequest.getSeverity());
		existingTask.setStoryPoint(taskRequest.getStoryPoint());

		return taskRepository.save(existingTask);
	}
	
	public String deleteTask(String taskId) {
		
		taskRepository.deleteById(taskId);
		return "Task is deleted successfullyF";
	}
}
