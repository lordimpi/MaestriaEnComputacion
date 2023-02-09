import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, map, catchError, throwError} from 'rxjs';
import { Estudiante } from '../components/estudiante/modelos/Estudiante';
import Swal from 'sweetalert2';


@Injectable({
  providedIn: 'root'
})
export class EstudianteService {
  private api = 'http://localhost:8081/api/estudiantes'
  private httpHeaders = new HttpHeaders({'Content-Type':'application/json'});
  constructor( private http: HttpClient) { }

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
}
