import { Component } from '@angular/core';
import { EstudianteService } from 'src/app/services/estudiante.service';
import { Estudiante } from '../modelos/Estudiante';
import { Telefono } from '../modelos/Telefono';
import { Direccion } from '../modelos/Direccion';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-estudiante',
  templateUrl: './estudiante.component.html',
  styleUrls: ['./estudiante.component.css']
})
export class EstudianteComponent {
  estudiantes!: Estudiante[];

  constructor(private servicio: EstudianteService){

  }

  ngOnInit(): void{
    this.servicio.getAllEstudiantes().subscribe(
      (result) => {
        this.estudiantes = result;
      }
    );
  }
}
