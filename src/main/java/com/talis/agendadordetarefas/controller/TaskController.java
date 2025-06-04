package com.talis.agendadordetarefas.controller;

import com.talis.agendadordetarefas.model.TaskItem;
import com.talis.agendadordetarefas.model.TaskStatus;
import com.talis.agendadordetarefas.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
@CrossOrigin(origins = "*")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<TaskItem> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/status/{status}")
    public List<TaskItem> listarPorStatus(@PathVariable TaskStatus status) {
        return service.listarPorStatus(status);
    }

    @PostMapping
    public TaskItem criar(@RequestBody TaskItem tarefa) {
        return service.criar(tarefa);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Void> atualizarStatus(@PathVariable int id, @RequestBody TaskStatus status) {
        if (service.atualizarStatus(id, status)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id) {
        if (service.remover(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
