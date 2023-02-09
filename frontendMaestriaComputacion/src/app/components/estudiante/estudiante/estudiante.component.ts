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
  delete(estudiante: Estudiante): void {
    Swal.fire({
      title: 'Estas seguro?',
      showDenyButton: true,
      showCancelButton: true,
      confirmButtonText: `Si,eliminar`,
      denyButtonText: `No, cancelar`,
    }).then((result) => {
      /* Read more about isConfirmed, isDenied below */
      if (result.isConfirmed) {
        this.servicio.delete(estudiante.id).subscribe(
          response => {
            this.estudiantes = this.estudiantes.filter(cli => cli != estudiante)
            Swal.fire('Estudiante eliminado!',
              `Estudiante ${estudiante.nombres} eliminado con éxito`, 'success')
          }
        )
      } else if (result.isDenied) {
        Swal.fire('Cancelada eliminación', '', 'info')
      }
    })
  }
}
