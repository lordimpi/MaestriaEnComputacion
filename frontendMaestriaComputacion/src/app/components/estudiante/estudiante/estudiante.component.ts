import { Component } from '@angular/core';
import { EstudianteService } from 'src/app/services/estudiante.service';
import { Estudiante } from '../modelos/Estudiante';
import { Telefono } from '../modelos/Telefono';
import { Direccion } from '../modelos/Direccion';
import Swal from 'sweetalert2';
import { ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-estudiante',
  templateUrl: './estudiante.component.html',
  styleUrls: ['./estudiante.component.css']
})
export class EstudianteComponent {
  estudiantes!: Estudiante[];
  showDireccion: boolean = false;
  showTelefonos: boolean = false;
  auxTelefonos!: Telefono[];
  auxDireccion!: Direccion;

  constructor(private servicio: EstudianteService, private modalService: NgbModal){
    this.auxDireccion = new Direccion();
  }

  ngOnInit(): void{
    this.servicio.getAllEstudiantes().subscribe(
      (result) => {
        this.estudiantes = result;
        if(this.estudiantes.length <1){
          Swal.fire({
            icon: 'error',
            title: 'Sin datos',
            text: 'No se encuentran estudiantes registrados'
          })
        }
      },
      (error)=>{
        this.estudiantes = [];
        Swal.fire({
          icon: 'error',
          title: 'error',
          text: 'Se ha presentado un problema en el sistema'
        });
      }
    );
  }

  abrirModalTelefonos(tel: Telefono[]){
    this.auxTelefonos=tel;
    console.log("telefonos recuperados:",this.auxTelefonos.length);
    this.showTelefonos=true;
  }

  abrirModalDireccion(dir: Direccion){
    this.auxDireccion=dir;
    this.showDireccion=true;
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
