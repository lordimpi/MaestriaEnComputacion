import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AsignaturaComponent } from './components/asignatura/asignatura/asignatura.component';
import { CursoComponent } from './components/curso/curso/curso.component';
import { DocenteComponent } from './components/docente/docente/docente.component';
import { EstudianteComponent } from './components/estudiante/estudiante/estudiante.component';
import { QueriesComponent } from './components/queries/queries.component';
import { BuscarDocenteComponent } from './components/queries/buscar-docente/buscar-docente.component';

const routes: Routes = [
  { path: 'estudiante', component: EstudianteComponent },
  { path: 'curso', component: CursoComponent },
  { path: 'docente', component: DocenteComponent },
  { path: 'asignatura', component: AsignaturaComponent },
  { path: 'queries', component: QueriesComponent },
  { path: 'querie1', component: BuscarDocenteComponent },
  { path: '**', component: EstudianteComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
