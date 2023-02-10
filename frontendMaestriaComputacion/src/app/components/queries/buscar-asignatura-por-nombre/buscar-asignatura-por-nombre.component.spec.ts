import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuscarAsignaturaPorNombreComponent } from './buscar-asignatura-por-nombre.component';

describe('BuscarAsignaturaPorNombreComponent', () => {
  let component: BuscarAsignaturaPorNombreComponent;
  let fixture: ComponentFixture<BuscarAsignaturaPorNombreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BuscarAsignaturaPorNombreComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BuscarAsignaturaPorNombreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
