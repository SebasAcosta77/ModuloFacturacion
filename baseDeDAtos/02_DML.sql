INSERT INTO roles (nombre_rol) VALUES ('Administrador');
INSERT INTO roles (nombre_rol) VALUES ('Empleado');

INSERT INTO usuarios (documento_usuario, nombres_usuarios, apellidos_usuario, telefono_usuario, xod_rol) VALUES ('1002696245' ,'Juan Sebastian', 'Acosta', '123445',1);

INSERT INTO acceso (documento_usuario, correo_acceso, clave_acceso) VALUES ('1002696245', 'jsacosta@jdc.edu.co', '12345');
