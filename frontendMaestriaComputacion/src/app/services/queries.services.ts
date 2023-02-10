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
  private api = 'http://localhost:8081/api/docentes';
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient) { }

  buscarPorNumeroyTipo(numIdentifiacion: string,tipoIdentificacion: string
  ): Observable<Docente> {
    return this.http.get<Docente>(
        `${this.api}/buscarpornumeroytipo/${numIdentifiacion}/${tipoIdentificacion}`,
        { headers: this.httpHeaders }
      )
      .pipe(map((res) => res as Docente));
  }

  /**
   * 
   * @param patron patron de busqueda para nombre o apellido
   * @returns una lista de objetos estudiantes (estos seran observables), o un error en caso de fallo
   */
  buscarEstudiantePatron(patron: string): Observable<Estudiante[]> {
    return this.http.get<Estudiante[]>(`${this.api}/buscarporpatron/${patron}`).pipe(
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
}
