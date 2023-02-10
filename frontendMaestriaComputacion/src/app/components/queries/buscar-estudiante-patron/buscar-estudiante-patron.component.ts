import { Component } from '@angular/core';
import { QueriesService } from 'src/app/services/queries.services';
import { Estudiante } from '../../estudiante/modelos/Estudiante';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-buscar-estudiante-patron',
  templateUrl: './buscar-estudiante-patron.component.html',
  styleUrls: ['./buscar-estudiante-patron.component.css']
})
export class BuscarEstudiantePatronComponent {
  //encapsulara el patron a buscar
  patron!: string;
  //almacena la respuesta que de el back si es exitosa
  estudiantes!: Estudiante[];
  //una bandera para mostrar o ocultar una ventana emergente
  showEstudiantes: boolean = false;
  //enyecta el servicio
  constructor(private servicio: QueriesService){

  }

  buscarPatron(){
    //suscribirse al metodo enviando la info pertinente
    this.servicio.buscarEstudiantePatron(this.patron).subscribe(
      //manipula el resultado en el primer argumento del suscribe
      (result)=>{
        //el resultado lo asignamos a nuestro array
        this.estudiantes = result;
        //si no hay nada en la lista, reportar
        if(this.estudiantes.length < 1){
          Swal.fire({
            icon: 'error',
            title: 'Sin datos',
            text: `no se han encontrado estudiantes con el patron: ${this.patron}`
          });
        }else{
          //si todo esta bien, habilita la bandera para mostrar la informacion en una ventana emergente
          this.showEstudiantes = true;
        }
      },
      //en el segundo argumento del suscribe, captura erroes si los hay
      (error)=>{
        //limpia tu array
        this.estudiantes=[];
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
