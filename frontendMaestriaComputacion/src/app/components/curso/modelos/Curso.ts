import { Asignatura } from "../../asignatura/modelos/Asignatura";

export class Curso{
    id!: number;
    nombre!: string;
    periodo!: number;
    objAsignatura!: Asignatura;
}