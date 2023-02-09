import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable, map, catchError, throwError} from 'rxjs';
import { Estudiante } from '../components/estudiante/modelos/Estudiante';

@Injectable({
  providedIn: 'root'
})
export class EstudianteService {
  private api = 'http://localhost:8081/api/estudiantes'
  constructor( private http: HttpClient) { }

  getAllEstudiantes(): Observable<Estudiante[]>{
    return this.http.get(this.api).pipe(map((res) => res as Estudiante[]));
  }
}
