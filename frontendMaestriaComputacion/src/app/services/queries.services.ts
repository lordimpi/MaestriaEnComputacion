import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, map, catchError, throwError } from 'rxjs';
import { Estudiante } from '../components/estudiante/modelos/Estudiante';
import { Docente } from '../components/docente/modelos/Docente';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root',
})
export class QueriesService {
  private apiDocente = 'http://localhost:8081/api/docentes';
  private apiEstudiante = 'http://localhost:8081/api/estudiantes';
  private apiAsignatura = 'http://localhost:8081/api/asignaturas';
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient) { }

  //TODO: cambiar a docente
  buscarDocentePorNumeroyTipo(numIdentifiacion: string,tipoIdentificacion: string
  ): Observable<any> {
    return this.http.get(
        `${this.apiDocente}/buscarpornumeroytipo/${numIdentifiacion}/${tipoIdentificacion}`,
        { headers: this.httpHeaders }
      )
  }

  buscarEstudiantePorNumeroyTipo(numIdentifiacion: string,tipoIdentificacion: string
    ): Observable<any> {
      return this.http.get(
          `${this.apiEstudiante}/buscarpornumeroytipo/${numIdentifiacion}/${tipoIdentificacion}`,
          { headers: this.httpHeaders }
        )
    }

  /**
   * 
   * @param patron patron de busqueda para nombre o apellido
   * @returns una lista de objetos estudiantes (estos seran observables), o un error en caso de fallo
   */
  buscarEstudiantePatron(patron: string): Observable<Estudiante[]> {
    return this.http.get<Estudiante[]>(`${this.apiEstudiante}/buscarporpatron/${patron}`).pipe(
      //para este caso es una lista asi que se una un mapeo de la respuesta a una array estudiante
      //si no es una lista, no es necesario hacer esto.
      map((res) => res as Estudiante[]),
      //el segundo argumento del pipe, es un catch error, si falla el proceso hay que reportarlo
      catchError(
        e => {
          console.error(e.error.mensaje);
          Swal.fire('Error al editar', "no se pudo obtener un estudiante", 'error');
           return throwError(() => new Error(e));
      })
    );;
  }

  likeName(nombre: string): Observable<any> {
      return this.http.get(
          `${this.apiAsignatura}/likeName/${nombre}`,
          { headers: this.httpHeaders }
        )
    }
  
    existByEmail(email: string): Observable<any> {
      return this.http.get(
          `${this.apiEstudiante}/existByEmail/${email}`,
          { headers: this.httpHeaders }
        )
    }
}
