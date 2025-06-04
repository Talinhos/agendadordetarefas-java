package com.talis.agendadordetarefas.model;

import java.time.LocalDate;

public class TaskItem {

    private int id;
    private String titulo;
    private String descricao;
    private LocalDate dataVencimento;
    private TaskStatus status = TaskStatus.PENDENTE;

    public TaskItem() {}

    public TaskItem(int id, String titulo, String descricao, LocalDate dataVencimento, TaskStatus status) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.status = status;
    }

    // Getters e Setters:
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public LocalDate getDataVencimento() { return dataVencimento; }
    public void setDataVencimento(LocalDate dataVencimento) { this.dataVencimento = dataVencimento; }

    public TaskStatus getStatus() { return status; }
    public void setStatus(TaskStatus status) { this.status = status; }
}

