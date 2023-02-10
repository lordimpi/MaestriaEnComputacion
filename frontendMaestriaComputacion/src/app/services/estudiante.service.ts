import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, map, catchError, throwError} from 'rxjs';
import { Estudiante } from '../components/estudiante/modelos/Estudiante';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class EstudianteService {
  private api = 'http://localhost:8081/api/estudiantes'
  private httpHeaders = new HttpHeaders({'Content-Type':'application/json'});
  
  constructor( private http: HttpClient, private router:Router) { }

  getAllEstudiantes(): Observable<Estudiante[]>{
    return this.http.get(this.api).pipe(map((res) => res as Estudiante[]));
  }

  delete(id: number):Observable<Estudiante>
  {
    return this.http.delete<Estudiante>(`${this.api}/${id}`, { headers: this.httpHeaders }).pipe(
      catchError(e => {
        console.error(e.error.mensaje);
        Swal.fire(e.error.mensaje, e.error.error, 'error');
        return throwError(() => new Error(e));
      })
    );
  }

  create(estudiante:Estudiante):Observable<Estudiante>
  {
    return this.http.post<Estudiante>(this.api,estudiante,{headers:this.httpHeaders}).pipe(
      catchError(
        e=>{
            if(e.status==400){
              return throwError(e);
          }
          console.log(e.error.mensaje);
          Swal.fire('Error al crear el estudiante',e.error.mensaje,'error');
          return throwError(()=>new Error(e));
        })
    );
    
  }

  actualizar(estudiante: Estudiante): Observable<Estudiante>{
    return this.http.put<Estudiante>(`${this.api}/${estudiante.id}`, estudiante, { headers: this.httpHeaders }).pipe(
      catchError(
        e => {

          if (e.status == 400) {
            return throwError(e);
          }
          console.log(e.error.mensaje);
          return throwError(() => new Error(e));
        })
    );
  }

  getEstudiante(id:number): Observable<Estudiante> {
    console.log("el id",id)
    return this.http.get<Estudiante>(`${this.api}/${id}`).pipe(
      catchError(
        e => {
          this.router.navigate(['/']);
          console.error(e.error.mensaje);
          Swal.fire('Error al editar', "no se pudo obtener un estudiante identificado con: ´{{id}}´", 'error');
           return throwError(() => new Error(e));
      })
    );
  }
}
