package com.talis.agendadordetarefas.service;

import com.talis.agendadordetarefas.model.TaskItem;
import com.talis.agendadordetarefas.model.TaskStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final List<TaskItem> tarefas = new ArrayList<>();
    private final AtomicInteger proximoId = new AtomicInteger(1);

    public List<TaskItem> listarTodas() {
        return tarefas;
    }

    public List<TaskItem> listarPorStatus(TaskStatus status) {
        return tarefas.stream()
                .filter(tarefa -> tarefa.getStatus() == status)
                .collect(Collectors.toList());
    }

    public TaskItem criar(TaskItem tarefa) {
        tarefa.setId(proximoId.getAndIncrement());
        tarefas.add(tarefa);
        return tarefa;
    }

    public boolean atualizarStatus(int id, TaskStatus status) {
        Optional<TaskItem> tarefa = tarefas.stream().filter(t -> t.getId() == id).findFirst();
        if (tarefa.isPresent()) {
            tarefa.get().setStatus(status);
            return true;
        }
        return false;
    }

    public boolean remover(int id) {
        return tarefas.removeIf(t -> t.getId() == id);
    }
}
