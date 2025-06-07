import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [TaskFormComponent, TaskListComponent],
  template: `
    <h1>Agenda de Tarefas</h1>
    <app-task-form (saved)="load()"></app-task-form>
    <app-task-list [tasks]="tasks" (statusChanged)="updateStatus($event)" (deleted)="delete($event)"></app-task-list>
  `
})
export class AppComponent {
  tasks: TaskItem[] = [];

  constructor(private service: TaskService) {}

  ngOnInit() {
    this.load();
  }

  load() {
    this.service.getAll().subscribe(t => this.tasks = t);
  }

  updateStatus(data: {id: number, status: string}) {
    this.service.updateStatus(data.id, data.status).subscribe(() => this.load());
  }

  delete(id: number) {
    this.service.delete(id).subscribe(() => this.load());
  }
}

import { TaskService } from './task.service';
import { TaskItem } from './task.model';
import { TaskFormComponent } from './task-form/task-form.component';
import { TaskListComponent } from './task-list/task-list.component';
