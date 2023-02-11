import { Telefono } from "./Telefono";
import { Direccion } from "./Direccion";
export class Estudiante{
    id!: number;
    noId!: string;
    tipoIdentificacion!: string;
    nombres!: string;
    apellidos!: string;
    correoElectronico!: string;
    fechaIngreso!: string;
    telefonos!: Telefono[];
    objDireccion!: Direccion;

    constructor() {
      this.telefonos = [new Telefono()];
  }

}
