import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { HttpClientModule } from '@angular/common/http';
import { FooterComponent } from './components/footer/footer.component';

import { TabMenuModule } from 'primeng/tabmenu';
import { EstudianteComponent } from './components/estudiante/estudiante/estudiante.component';
import { AsignaturaComponent } from './components/asignatura/asignatura/asignatura.component';
import { CursoComponent } from './components/curso/curso/curso.component';
import { DocenteComponent } from './components/docente/docente/docente.component';
import { FormularioComponent } from './components/estudiante/formulario/formulario.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {DialogModule} from 'primeng/dialog';
import { QueriesComponent } from './components/queries/queries.component';
import { BuscarDocenteComponent } from './components/queries/buscar-docente/buscar-docente.component';
import { BuscarEstudiantePatronComponent } from './components/queries/buscar-estudiante-patron/buscar-estudiante-patron.component';
import { BuscarEstudianteNumIdentificacionComponent } from './components/queries/buscar-estudiante-num-identificacion/buscar-estudiante-num-identificacion.component';
import { BuscarAsignaturaPorNombreComponent } from './components/queries/buscar-asignatura-por-nombre/buscar-asignatura-por-nombre.component';
import { BuscarEmailComponent } from './components/queries/buscar-email/buscar-email.component';

@NgModule({
  declarations: [AppComponent, HeaderComponent, FooterComponent, EstudianteComponent, AsignaturaComponent, CursoComponent, DocenteComponent, FormularioComponent, QueriesComponent, BuscarDocenteComponent, BuscarEstudiantePatronComponent, BuscarEstudianteNumIdentificacionComponent, BuscarAsignaturaPorNombreComponent, BuscarEmailComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    BrowserAnimationsModule,
    HttpClientModule,
    TabMenuModule,
    NgbModule,
    DialogModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
