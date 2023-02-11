import { DocenteService } from './../../../services/docente.service';
import { Docente } from './../../../models/docente';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-docente',
  templateUrl: './docente.component.html',
  styleUrls: ['./docente.component.css']
})
export class DocenteComponent implements OnInit {
  docentes:Docente[] = [];

  constructor(private docenteService:DocenteService){

  }

  ngOnInit(): void {
    this.obtenerDocentes()
  }

  obtenerDocentes(){
    this.docenteService.getDocentes().subscribe(res=>{
      console.log(res);
      this.docentes=res
    })
  }
}
