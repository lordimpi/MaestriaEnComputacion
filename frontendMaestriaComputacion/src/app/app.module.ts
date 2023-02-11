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
import { CrearComponent } from './components/asignatura/asignatura/pages/crear/crear.component';
import { TabViewModule } from 'primeng/tabview';
import { ToggleButtonModule } from 'primeng/togglebutton';
import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { DialogModule } from 'primeng/dialog';
import { ListarComponent } from './components/asignatura/asignatura/pages/listar/listar.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    EstudianteComponent,
    AsignaturaComponent,
    CursoComponent,
    DocenteComponent,
    FormularioComponent,
    CrearComponent,
    ListarComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    BrowserAnimationsModule,
    HttpClientModule,
    TabMenuModule,
    TabViewModule,
    ToggleButtonModule,
    TableModule,
    ButtonModule,
    DialogModule,
    NgbModule,
    DialogModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
