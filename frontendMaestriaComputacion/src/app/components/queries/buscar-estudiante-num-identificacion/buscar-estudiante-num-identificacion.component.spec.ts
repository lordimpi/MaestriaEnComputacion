import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuscarEstudianteNumIdentificacionComponent } from './buscar-estudiante-num-identificacion.component';

describe('BuscarEstudianteNumIdentificacionComponent', () => {
  let component: BuscarEstudianteNumIdentificacionComponent;
  let fixture: ComponentFixture<BuscarEstudianteNumIdentificacionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BuscarEstudianteNumIdentificacionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BuscarEstudianteNumIdentificacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
