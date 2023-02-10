import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AsignaturaComponent } from './components/asignatura/asignatura/asignatura.component';
import { CursoComponent } from './components/curso/curso/curso.component';
import { DocenteComponent } from './components/docente/docente/docente.component';
import { EstudianteComponent } from './components/estudiante/estudiante/estudiante.component';
import { FormularioComponent } from './components/estudiante/formulario/formulario.component';
import { QueriesComponent } from './components/queries/queries.component';
import { BuscarDocenteComponent } from './components/queries/buscar-docente/buscar-docente.component';
import { BuscarEstudiantePatronComponent } from './components/queries/buscar-estudiante-patron/buscar-estudiante-patron.component';
import { BuscarEstudianteNumIdentificacionComponent } from './components/queries/buscar-estudiante-num-identificacion/buscar-estudiante-num-identificacion.component';
import { BuscarAsignaturaPorNombreComponent } from './components/queries/buscar-asignatura-por-nombre/buscar-asignatura-por-nombre.component';
import { BuscarEmailComponent } from './components/queries/buscar-email/buscar-email.component';

const routes: Routes = [
  { path: 'estudiante', component: EstudianteComponent },
  { path: 'curso', component: CursoComponent },
  { path: 'docente', component: DocenteComponent },
  { path: 'asignatura', component: AsignaturaComponent },
  { path: 'estudiante/formulario', component: FormularioComponent },
  { path: 'estudiante/actualizar/:id',component: FormularioComponent},
  //poner todos los path antes de esta linea
  { path: 'queries', component: QueriesComponent },
  { path: 'querie1', component: BuscarDocenteComponent },
  { path: 'querie2', component: BuscarEstudianteNumIdentificacionComponent },
  { path: 'querie3', component: BuscarEstudiantePatronComponent },
  { path: 'querie4', component: BuscarEmailComponent },
  { path: 'querie6', component: BuscarAsignaturaPorNombreComponent},
  { path: '**', component: EstudianteComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
