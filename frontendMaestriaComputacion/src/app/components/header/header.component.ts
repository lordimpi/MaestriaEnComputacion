import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  items!: MenuItem[];
  activeItem!: MenuItem;

  constructor() {}

  ngOnInit(): void {
    this.items = [
      {
        label: 'Asignatura',
        icon: 'pi pi-server',
        routerLink: 'asignatura',
      },
      {
        label: 'Curso',
        icon: 'pi pi-book',
        routerLink: 'curso',
      },
      {
        label: 'Docente',
        icon: 'pi pi-user',
        routerLink: 'docente',
      },
      {
        label: 'Estudiante',
        icon: 'pi pi-user',
        routerLink: 'estudiante',
      },
      {
        label: 'Queries',
        icon: 'pi pi-database',
        routerLink: 'queries',
      },
    ];

    this.activeItem = this.items[2];
  }
}
