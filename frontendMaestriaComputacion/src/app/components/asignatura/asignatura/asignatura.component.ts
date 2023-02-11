import { Component } from '@angular/core';

@Component({
  selector: 'app-asignatura',
  templateUrl: './asignatura.component.html',
  styleUrls: ['./asignatura.component.css'],
})
export class AsignaturaComponent {
  index: number;
  hiddenPages: boolean[];
  constructor() {
    this.index = 0;
    this.hiddenPages = [false, true, true];
  }
  handleChange(event: any) {
    const activeIndex = event.index;
    this.hiddenPages.map((p) => (p = true));
    this.hiddenPages[activeIndex] = false;
  }
}
