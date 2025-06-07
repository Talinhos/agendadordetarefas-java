import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TaskItem } from '../task.model';

@Component({
  selector: 'app-task-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './task-list.component.html'
})
export class TaskListComponent {
  @Input() tasks: TaskItem[] = [];
  @Output() statusChanged = new EventEmitter<{id: number, status: string}>();
  @Output() deleted = new EventEmitter<number>();

  changeStatus(id: number, status: string) {
    this.statusChanged.emit({id, status});
  }

  remove(id: number) {
    this.deleted.emit(id);
  }
}
