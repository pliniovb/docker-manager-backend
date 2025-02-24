package com.pliniovb.docker_manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.dockerjava.api.model.Container;
import com.pliniovb.docker_manager.service.DockerService;

@RestController
@RequestMapping("/api/containers")

public class DockerContainersController {

	private final DockerService dockerService;
	
	public DockerContainersController(DockerService dockerService) {
		this.dockerService = dockerService;
	}
	
	@GetMapping("")
	public List<Container> listContainers(@RequestParam(required = false, defaultValue = "true") boolean showAll){
		return dockerService.listContainers(showAll);
	}
	
	@PostMapping("/{id}/start")
	public void startContainer(@PathVariable String id) {
		dockerService.startContainer(id);
	}
	
	@PostMapping("/{id}/stop")
	public void stopContainer(@PathVariable String id) {
		dockerService.stopContainer(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteContainer(@PathVariable String id) {
		dockerService.deleteContainer(id);
	}
	
	@PostMapping("")
	public void createContainer(@RequestParam String imageName) {
		dockerService.createContainer(imageName);
	}
	

}
