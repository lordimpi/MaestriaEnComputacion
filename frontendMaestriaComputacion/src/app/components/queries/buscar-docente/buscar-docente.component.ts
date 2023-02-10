import { Component } from '@angular/core';
import {Docente} from 'src/app/components/docente/modelos/Docente';
import Swal from 'sweetalert2';
import { QueriesService } from '../../../services/queries.services';

@Component({
  selector: 'app-buscar-docente',
  templateUrl: './buscar-docente.component.html',
  styleUrls: ['./buscar-docente.component.css'],
})
export class BuscarDocenteComponent {
  public numIdentificacion!: string;
  public tipoIdentificacion!: string;
  public docente:Docente = new Docente();

  constructor(private servicio: QueriesService) {}

  public buscarDocente() {
    this.servicio.buscarDocentePorNumeroyTipo(this.numIdentificacion, this.tipoIdentificacion)
    .subscribe((result) => {
      //this.docente = result;
      console.log(result);
      this.docente = result.docenteResponse.docentes[0]||null;
      console.log(this.docente);
      if(this.docente == null){
        Swal.fire({
          icon: 'error',
          title: 'Sin datos',
          text: 'No se encuentran estudiantes registrados'
        })
      }
    },
    (error)=>{
      this.docente = new Docente();
      Swal.fire({
        icon: 'error',
        title: 'error',
        text: 'Se ha presentado un problema en el sistema'
      });
    })
  }
}
