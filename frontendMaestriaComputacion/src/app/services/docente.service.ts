import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Docente } from '../models/docente';

@Injectable({
  providedIn: 'root'
})
export class DocenteService {

  private urlEndPoint: string = 'http://localhost:8081/api/docentes';
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  getDocentes():Observable<Docente[]>{
      return this.http.get<Docente[]>(this.urlEndPoint)
  }
}
