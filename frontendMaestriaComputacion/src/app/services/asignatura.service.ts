import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable, catchError, throwError } from 'rxjs';
import Swal from 'sweetalert2';
import { Asignatura } from '../components/asignatura/asignatura/models/Asignatura';

@Injectable({
  providedIn: 'root',
})
export class AsignaturaService {
  api = 'http://localhost:8081/api/asignaturas';
  constructor(private http: HttpClient) {}

  getAll(): Observable<Asignatura[]> {
    return this.http.get(this.api).pipe(map((res) => res as Asignatura[]));
  }

  saveAsignatura(asignatura: Asignatura): Observable<Asignatura> {
    return this.http.post<Asignatura>(this.api, asignatura).pipe(
      catchError((error) => {
        if (error.status == 400) {
          return throwError(error);
        }
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: error.error.mensaje,
          footer: '<a href="">Why do I have this issue?</a>',
        });
        return throwError(error);
      })
    );
  }
  deleteAsignatura(id: number): Observable<any> {
    return this.http.delete(`${this.api}/${id}`);
  }
}
