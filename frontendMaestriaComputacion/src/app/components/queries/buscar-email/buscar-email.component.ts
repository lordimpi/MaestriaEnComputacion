import { Component } from '@angular/core';
import { QueriesService } from 'src/app/services/queries.services';

@Component({
  selector: 'app-buscar-email',
  templateUrl: './buscar-email.component.html',
  styleUrls: ['./buscar-email.component.css']
})
export class BuscarEmailComponent {
  public correo!: string;
  public existe:boolean = false;
  public mensaje!: string;
  showCorreo: boolean = false;

  constructor(private servicio: QueriesService) {}

  buscarCorreo(){
    this.servicio.existByEmail(this.correo).subscribe(
      (result)=>{
        this.existe = result;
        if(this.existe){
          this.mensaje = "El correo existe";
        }else{
          this.mensaje = "El correo no existe";
        }
        this.showCorreo = true;
      },
      (error)=>{
        this.existe = false;
        this.mensaje = "Error en el sistema";
      }
    );
  }
}
