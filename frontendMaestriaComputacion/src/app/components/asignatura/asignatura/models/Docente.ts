import { Asignatura } from './Asignatura';

export interface Docente {
  id: number | null;
  noId: string;
  tipoIdentificacion: string;
  nombres: string;
  apellidos: string;
  universidad: string;
  tipoDocente: string;
  salario: number;
  asignaturas: Asignatura[];
}
