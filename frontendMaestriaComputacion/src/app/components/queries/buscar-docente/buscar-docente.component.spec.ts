import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuscarDocenteComponent } from './buscar-docente.component';

describe('BuscarDocenteComponent', () => {
  let component: BuscarDocenteComponent;
  let fixture: ComponentFixture<BuscarDocenteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BuscarDocenteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BuscarDocenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
