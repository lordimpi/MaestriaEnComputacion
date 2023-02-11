import { Component } from '@angular/core';
import { QueriesService } from 'src/app/services/queries.services';
import Swal from 'sweetalert2';
import { Estudiante } from '../../estudiante/modelos/Estudiante';

@Component({
  selector: 'app-buscar-estudiante-num-identificacion',
  templateUrl: './buscar-estudiante-num-identificacion.component.html',
  styleUrls: ['./buscar-estudiante-num-identificacion.component.css']
})
export class BuscarEstudianteNumIdentificacionComponent {
  public numIdentificacion!: string;
  public tipoIdentificacion!: string;
  public estudiante:Estudiante = new Estudiante();

  constructor(private servicio: QueriesService) {}

  buscarEstudianteNumTipo(){
    this.servicio.buscarEstudiantePorNumeroyTipo(this.numIdentificacion, this.tipoIdentificacion)
    .subscribe((result) => {
      this.estudiante = result.estudianteResponse.estudiantes[0]||null;
      console.log(this.estudiante);
      if(this.estudiante == null){
        Swal.fire({
          icon: 'error',
          title: 'Sin datos',
          text: 'No se encuentran estudiantes registrados'
        })
      }
    },
    (error)=>{
      this.estudiante = new Estudiante();
      Swal.fire({
        icon: 'error',
        title: 'error',
        text: 'Se ha presentado un problema en el sistema'
      });
    })
  }
}
