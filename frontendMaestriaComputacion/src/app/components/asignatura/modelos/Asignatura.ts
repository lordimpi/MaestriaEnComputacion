import { Curso } from "../../curso/modelos/Curso";
import { Docente } from "../../docente/modelos/Docente";

export class Asignatura{
    id!: number;
    nombre!: string;
    cursos!: Curso[];
    docentes!: Docente[];
}