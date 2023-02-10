import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuscarEstudiantePatronComponent } from './buscar-estudiante-patron.component';

describe('BuscarEstudiantePatronComponent', () => {
  let component: BuscarEstudiantePatronComponent;
  let fixture: ComponentFixture<BuscarEstudiantePatronComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BuscarEstudiantePatronComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BuscarEstudiantePatronComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
