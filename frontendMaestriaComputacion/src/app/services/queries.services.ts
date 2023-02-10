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
  constructor(private http: HttpClient) {}

  buscarPorNumeroyTipo(numIdentifiacion: string,tipoIdentificacion: string
  ): Observable<Docente> {
    return this.http.get<Docente>(
        `${this.api}/buscarpornumeroytipo/${numIdentifiacion}/${tipoIdentificacion}`,
        { headers: this.httpHeaders }
      )
      .pipe(map((res) => res as Docente));
  }
}
