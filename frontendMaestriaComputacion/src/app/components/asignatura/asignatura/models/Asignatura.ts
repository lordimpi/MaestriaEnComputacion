import { Curso } from './Curso';
import { Docente } from './Docente';

export interface Asignatura {
  nombre: string;
  cursos: Curso[];
  docentes: Docente[];
}
