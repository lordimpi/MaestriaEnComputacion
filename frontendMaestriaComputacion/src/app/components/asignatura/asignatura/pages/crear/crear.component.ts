import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { AsignaturaService } from 'src/app/services/asignatura.service';
import Swal from 'sweetalert2';
import { Asignatura } from '../../models/Asignatura';
import { Curso } from '../../models/Curso';
import { Docente } from '../../models/Docente';

@Component({
  selector: 'app-crear',
  templateUrl: './crear.component.html',
  styleUrls: ['./crear.component.css'],
})
export class CrearComponent implements OnInit {
  errors: string[];
  validate: boolean;
  asignaturaForm: any;
  cursoForm: any;
  cursos: Curso[];
  docentes: Docente[];
  displayAddCursos: boolean;
  displayAddDocentes: boolean;

  constructor(
    private fb: FormBuilder,
    private asignaturaService: AsignaturaService
  ) {
    this.errors = [];
    this.cursos = [];
    this.docentes = [
      {
        id: null,
        noId: '1061',
        tipoIdentificacion: 'cc',
        nombres: 'Daniel',
        apellidos: 'Mejia',
        universidad: 'UniAndes',
        tipoDocente: 'Planta',
        salario: 30000000.0,
        asignaturas: [],
      },
    ];
    //= [];
    this.validate = true;
    this.displayAddCursos = false;
    this.displayAddDocentes = false;
  }

  ngOnInit(): void {
    this.setValidations(this.validate);
  }

  add() {
    console.log('Enviando...');
    const asignatura: Asignatura = {
      nombre: this.asignaturaForm.value.name,
      cursos: this.cursos,
      docentes: this.docentes,
    };
    console.log(JSON.stringify(asignatura));
    this.asignaturaService.saveAsignatura(asignatura).subscribe(
      (result) => {
        Swal.fire(
          'Buen trabajo!',
          'Se ha guardado la asignatura exitosamente',
          'success'
        );
        this.ngOnInit();
      },
      (error) => {
        if (error.status == 400) {
          const map = new Map(Object.entries(error.error));
          const vector = Array.from(map.values());
          this.errors = vector as string[];
        }
      },
      () => {
        this.ngOnInit();
      }
    );
  }

  addCurso() {
    const curso = {
      nombre: this.cursoForm.value?.name,
      periodo: this.cursoForm.value?.period,
    };
    this.cursos.push(curso);
    this.displayAddCursos = false;
    this.cursoForm.reset();
  }
  showAddCurso() {
    this.displayAddCursos = true;
  }

  showAddDocente() {
    this.displayAddDocentes = true;
  }

  setValidations(validate: boolean) {
    this.validate = !validate;
    if (validate) {
      this.asignaturaForm = this.fb.group({
        name: [
          '',
          [
            Validators.required,
            Validators.minLength(5),
            Validators.pattern('[A-Za-z á-ú]*'),
            Validators.maxLength(25),
          ],
        ],
      });
      this.cursoForm = this.fb.group({
        name: [
          '',
          [
            Validators.required,
            Validators.minLength(5),
            Validators.pattern('[A-Za-z á-ú]*'),
            Validators.maxLength(25),
          ],
        ],
        period: ['', [Validators.required, Validators.pattern('[1-2]')]],
      });
    } else {
      this.asignaturaForm = this.fb.group({
        name: [''],
      });
      this.cursoForm = this.fb.group({
        name: [''],
        period: [''],
      });
    }
  }
}
