import { Component } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators
} from '@angular/forms';
import { throwError } from 'rxjs';
import Swal from 'sweetalert2';
import { EstudianteService } from 'src/app/services/estudiante.service';
import { Estudiante } from '../modelos/Estudiante';
import { Telefono } from '../modelos/Telefono';
import { Direccion } from '../modelos/Direccion';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent {
  public estudiante: Estudiante = new Estudiante();
  public telefono: Telefono = new Telefono();
  public direccion: Direccion = new Direccion();
  public errores: string[] = [];  
  banderaValidaciones: boolean = true;
  public cantidad=8;
  public showTelefonos: boolean= false;

  constructor(private servicio: EstudianteService, private router: Router, private rutaActiva: ActivatedRoute) {

  }
  ngOnInit():void{
    this.cargarEstudiante();
    this.telefono = this.estudiante.telefonos[0];
  }

  cargarEstudiante(){
    this.rutaActiva.params.subscribe(params => {
      let id = params['id']
      console.log("el id: ",id)
      if(id){
        this.servicio.getEstudiante(id).subscribe(
          (estudiante) => {
            this.estudiante = estudiante
            this.direccion = estudiante.objDireccion;
            this.telefono = estudiante.telefonos[0];
          }
        )
      }
    })
  }

  crearEstudiante(){
    console.log("numero telefonico",this.telefono.numero);
    this.estudiante.objDireccion = this.direccion;
    this.estudiante.telefonos = [this.telefono, this.telefono];
    this.servicio.create(this.estudiante).subscribe(
      respose => {
        this.router.navigate(["/"]);
        Swal.fire('Nuevo cliente', `Cliente creado con éxito!`, 'success');
      },
      (err: HttpErrorResponse) => {
        const map = new Map(Object.entries(err.error));
        const vector = Array.from(map.values());
        this.errores = vector as string[];
        Swal.fire('Error al crear el cliente', err.error.mensaje, 'error');
      }

    );
  }

  actualizarEstudiante(){
    this.servicio.actualizar(this.estudiante)
    .subscribe(        
      respose  => {
        this.router.navigate(['/']);
        Swal.fire('Cliente Actualizado', `Estudiante ${respose.nombres} actualizado con éxito!`, 'success');
      },
      (err: HttpErrorResponse )=> {
                const map = new Map(Object.entries(err.error));
                const vector= Array.from(map.values());
                this.errores =vector as string[];
                Swal.fire('Error al actualizar el estudiante', err.error.mensaje, 'error');
              }
    )
  }
  
  cambiarBandera(){
    if(this.banderaValidaciones){
      this.banderaValidaciones=false;
    }else{
      this.banderaValidaciones=true;
    }
  }
}
