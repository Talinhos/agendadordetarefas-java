import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-task-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './task-form.component.html'
})
export class TaskFormComponent {
  @Output() saved = new EventEmitter<void>();

  form = this.fb.nonNullable.group({
    titulo: '',
    descricao: '',
    dataVencimento: ''
  });

  constructor(private fb: FormBuilder, private service: TaskService) {}

  submit() {
    if (this.form.valid) {
      this.service.create({
        id: 0,
        titulo: this.form.value.titulo!,
        descricao: this.form.value.descricao!,
        dataVencimento: this.form.value.dataVencimento!,
        status: 'PENDENTE'
      }).subscribe(() => {
        this.form.reset();
        this.saved.emit();
      });
    }
  }
}
