import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AsignaturaComponent } from './components/asignatura/asignatura/asignatura.component';
import { CursoComponent } from './components/curso/curso/curso.component';
import { DocenteComponent } from './components/docente/docente/docente.component';
import { EstudianteComponent } from './components/estudiante/estudiante/estudiante.component';

const routes: Routes = [
  { path: 'estudiante', component: EstudianteComponent },
  { path: 'curso', component: CursoComponent },
  { path: 'docente', component: DocenteComponent },
  { path: 'asignatura', component: AsignaturaComponent },
  { path: '**', component: EstudianteComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
