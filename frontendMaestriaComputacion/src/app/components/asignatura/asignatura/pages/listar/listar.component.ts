import { Component, OnInit } from '@angular/core';
import { AsignaturaService } from 'src/app/services/asignatura.service';
import Swal from 'sweetalert2';
import { Asignatura } from '../../models/Asignatura';
import { Curso } from '../../models/Curso';
import { Docente } from '../../models/Docente';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css'],
})
export class ListarComponent implements OnInit {
  asignaturas: Asignatura[];
  showDocentes: boolean;
  showCursos: boolean;
  docentes: Docente[];
  cursos: Curso[];

  constructor(private asignaturaService: AsignaturaService) {
    this.asignaturas = [];
    this.showDocentes = false;
    this.showCursos = false;
    this.docentes = [];
    this.cursos = [];
  }
  ngOnInit(): void {
    this.asignaturaService.getAll().subscribe(
      (result) => {
        this.asignaturas = result;
        if (this.asignaturas.length < 1) {
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'No hay Asignaturas registrados',
            footer: '<a href="">Why do I have this issue?</a>',
          });
        }
      },
      (error) => {
        this.asignaturas = [];
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Something went wrong!',
          footer: '<a href="">Why do I have this issue?</a>',
        });
      },
      () => {}
    );
  }

  seeDocentes(docentes: Docente[]) {
    this.showDocentes = true;
    this.docentes = docentes;
  }
  seeCursos(cursos: Curso[]) {
    this.showCursos = true;
    this.cursos = cursos;
  }

  isThereDocentes(docentes: Docente[]) {
    return docentes.length > 0 ? true : false;
  }

  deleteAsignatura(id: number) {}
}
