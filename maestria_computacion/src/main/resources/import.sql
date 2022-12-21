INSERT INTO `estudiantes` (`id_persona`, `apellidos`, `no_identificacion`, `nombres`, `tipoIdentificacion`, `fechaIngreso`, `correoElectronico`) VALUES (NULL, 'Montenegro Lopez', '123455', 'Juan Carlos', 'cc', '2022-12-01','edynsonmj@unicauca.edu.co');
INSERT INTO `estudiantes` (`id_persona`, `apellidos`, `no_identificacion`, `nombres`, `tipoIdentificacion`, `fechaIngreso`) VALUES (NULL, 'Jimenez', '23256', 'edynson', 'cc', '2022-12-01');
INSERT INTO `telefonos` (`numero`, `tipo`, `id_persona`) VALUES ('2342354','movil',1);
INSERT INTO `telefonos` (`numero`, `tipo`, `id_persona`) VALUES ('2342354','fijo',2);
INSERT INTO `direcciones` (`idDireccion`, `ciudad`, `direccionResidencia`, `pais`) VALUES ('1', 'Popayan', 'calle 6 5-20', 'Colombia');
INSERT INTO `direcciones` (`idDireccion`, `ciudad`, `direccionResidencia`, `pais`) VALUES ('2', 'Popayan', 'calle 6 5-20', 'Colombia');
INSERT INTO `docentes`(`apellidos`, `no_identificacion`, `nombres`, `tipoIdentificacion`, `salario`, `tipo_docente`, `universidad`) VALUES ('Coral','1061752258','Hector','Cedula',2500000,'Planta','Unicauca')
INSERT INTO `docentes`(`apellidos`, `no_identificacion`, `nombres`, `tipoIdentificacion`, `salario`, `tipo_docente`, `universidad`) VALUES ('Acuna','1061752189','Santiago','Cedula',3500000,'Planta','Unicauca')