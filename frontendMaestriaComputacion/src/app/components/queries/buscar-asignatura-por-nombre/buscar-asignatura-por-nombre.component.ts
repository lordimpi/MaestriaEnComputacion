import { Component } from '@angular/core';
import { QueriesService } from 'src/app/services/queries.services';
import Swal from 'sweetalert2';
import { Asignatura } from '../../asignatura/modelos/Asignatura';

@Component({
  selector: 'app-buscar-asignatura-por-nombre',
  templateUrl: './buscar-asignatura-por-nombre.component.html',
  styleUrls: ['./buscar-asignatura-por-nombre.component.css']
})
export class BuscarAsignaturaPorNombreComponent {

  public nombre!: string;
  public asignaturas:Asignatura[] = [];
  showAsignatura: boolean = false;

  constructor(private servicio: QueriesService) {}

  buscarAsignaturasPorNombre() {
    //suscribirse al metodo enviando la info pertinente
    this.servicio.likeName(this.nombre).subscribe(
      //manipula el resultado en el primer argumento del suscribe
      (result)=>{
        //el resultado lo asignamos a nuestro array
        this.asignaturas = result;
        //si no hay nada en la lista, reportar
        if(this.asignaturas.length < 1){
          Swal.fire({
            icon: 'error',
            title: 'Sin datos',
            text: `no se han encontrado las asignaturas con el patron: ${this.nombre}`
          });
        }else{
          //si todo esta bien, habilita la bandera para mostrar la informacion en una ventana emergente
          this.showAsignatura = true;
        }
      },
      //en el segundo argumento del suscribe, captura erroes si los hay
      (error)=>{
        //limpia tu array
        this.asignaturas=[];
        //reporta el error
        Swal.fire({
          icon: 'error',
          title: 'error',
          text: 'se ha presentado un error en el sistema',
        })
      }
    );
  }
}
