/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     26/02/2024 14:50:27                          */
/*==============================================================*/


/*==============================================================*/
/* Table: accesos                                               */
/*==============================================================*/
create table accesos (
   documento_usuario    varchar(50)          not null,
   correo_acceso        varchar(250)         not null,
   clave_acceso         varchar(500)         not null,
   constraint pk_accesos primary key (documento_usuario)
);

-- set table ownership
alter table accesos owner to user_java
;
/*==============================================================*/
/* Table: bodegas                                               */
/*==============================================================*/
create table bodegas (
   cod_bodega           serial               not null,
   nombre_bodega        varchar(250)         not null,
   ancho_bodega         decimal              not null,
   largo_bodega         decimal              not null,
   constraint pk_bodegas primary key (cod_bodega)
);

-- set table ownership
alter table bodegas owner to user_java
;
/*==============================================================*/
/* Table: categorias                                            */
/*==============================================================*/
create table categorias (
   cod_categoria        serial               not null,
   nombre_categoria     varchar(250)         not null,
   inicial_categoria    int2                 not null,
   final_categoria      int2                 not null,
   constraint pk_categorias primary key (cod_categoria)
);

-- set table ownership
alter table categorias owner to user_java
;
/*==============================================================*/
/* Table: factura                                               */
/*==============================================================*/
create table factura (
   cod_factura          serial               not null,
   cod_venta            int4                 not null,
   fecha_factura        date                 not null,
   valor_factura        decimal              not null,
   constraint pk_factura primary key (cod_factura)
);

-- set table ownership
alter table factura owner to user_java
;
/*==============================================================*/
/* Table: galpones                                              */
/*==============================================================*/
create table galpones (
   cod_galpon           serial               not null,
   gallinas_galpon      int4                 not null,
   ancho_galpon         decimal              not null,
   largo_galpon         decimal              not null,
   constraint pk_galpones primary key (cod_galpon)
);

-- set table ownership
alter table galpones owner to user_java
;
/*==============================================================*/
/* Table: insumos                                               */
/*==============================================================*/
create table insumos (
   cod_insumo           serial               not null,
   cod_inventario       int4                 null,
   valor_insumo         int4                 not null,
   cantidad_insumo      int2                 not null,
   tipo_insumo          int2                 not null,
   constraint pk_insumos primary key (cod_insumo)
);

-- set table ownership
alter table insumos owner to user_java
;
/*==============================================================*/
/* Table: inventarios                                           */
/*==============================================================*/
create table inventarios (
   cod_inventario       serial               not null,
   cod_bodega           int4                 not null,
   documento_usuario    varchar(50)          not null,
   cod_galpon           int4                 not null,
   fecha_inventario     date                 not null,
   hora_inicio_inventrario time                 not null,
   hora_fin_inventario  time                 null,
   tipo_inventario      int2                 not null,
   constraint pk_inventarios primary key (cod_inventario)
);

-- set table ownership
alter table inventarios owner to user_java
;
/*==============================================================*/
/* Table: permisos                                              */
/*==============================================================*/
create table permisos (
   cod_permiso          serial               not null,
   nombre_permiso       varchar(200)         not null,
   funcionalidad_permiso varchar(250)         not null,
   constraint pk_permisos primary key (cod_permiso)
);

-- set table ownership
alter table permisos owner to user_java
;
/*==============================================================*/
/* Table: permiso_rol                                           */
/*==============================================================*/
create table permiso_rol (
   cod_permiso          int4                 not null,
   cod_rol              int4                 not null,
   constraint pk_permiso_rol primary key (cod_permiso, cod_rol)
);

-- set table ownership
alter table permiso_rol owner to user_java
;
/*==============================================================*/
/* Table: productos                                             */
/*==============================================================*/
create table productos (
   cod_producto         serial               not null,
   cod_inventario       int4                 not null,
   cod_categoria        int4                 not null,
   cantidad_producto    int4                 not null,
   constraint pk_productos primary key (cod_producto)
);

-- set table ownership
alter table productos owner to user_java
;
/*==============================================================*/
/* Table: roles                                                 */
/*==============================================================*/
create table roles (
   cod_rol              serial               not null,
   nombre_rol           varchar(200)         not null,
   constraint pk_roles primary key (cod_rol)
);

-- set table ownership
alter table roles owner to user_java
;
/*==============================================================*/
/* Table: usuarios                                              */
/*==============================================================*/
create table usuarios (
   documento_usuario    varchar(50)          not null,
   cod_rol              int4                 not null,
   nombres_usuario      varchar(250)         not null,
   apellidos_usuario    varchar(250)         not null,
   telefono_usuario     varchar(250)         not null,
   constraint pk_usuarios primary key (documento_usuario)
);

-- set table ownership
alter table usuarios owner to user_java
;
/*==============================================================*/
/* Table: ventas                                                */
/*==============================================================*/
create table ventas (
   cod_venta            serial               not null,
   cod_bodega           int4                 null,
   cantidad_venta       int4                 not null,
   fecha_venta          date                 not null,
   constraint pk_ventas primary key (cod_venta)
);

-- set table ownership
alter table ventas owner to user_java
;
alter table accesos
   add constraint fk_accesos_ref_usuarios foreign key (documento_usuario)
      references usuarios (documento_usuario)
      on delete restrict on update cascade;

alter table factura
   add constraint fk_factura_ref_ventas foreign key (cod_venta)
      references ventas (cod_venta)
      on delete restrict on update cascade;

alter table insumos
   add constraint fk_insumos_ref_inventar foreign key (cod_inventario)
      references inventarios (cod_inventario)
      on delete restrict on update cascade;

alter table inventarios
   add constraint fk_inventar_ref_usuarios foreign key (documento_usuario)
      references usuarios (documento_usuario)
      on delete restrict on update cascade;

alter table inventarios
   add constraint fk_inventar_ref_galpones foreign key (cod_galpon)
      references galpones (cod_galpon)
      on delete restrict on update cascade;

alter table inventarios
   add constraint fk_inventar_ref_bodegas foreign key (cod_bodega)
      references bodegas (cod_bodega)
      on delete restrict on update cascade;

alter table permiso_rol
   add constraint fk_permiso__ref_permisos foreign key (cod_permiso)
      references permisos (cod_permiso)
      on delete restrict on update cascade;

alter table permiso_rol
   add constraint fk_permiso__ref_roles foreign key (cod_rol)
      references roles (cod_rol)
      on delete restrict on update cascade;

alter table productos
   add constraint fk_producto_ref_inventar foreign key (cod_inventario)
      references inventarios (cod_inventario)
      on delete restrict on update cascade;

alter table productos
   add constraint fk_producto_ref_categori foreign key (cod_categoria)
      references categorias (cod_categoria)
      on delete restrict on update cascade;

alter table usuarios
   add constraint fk_usuarios_ref_roles foreign key (cod_rol)
      references roles (cod_rol)
      on delete restrict on update cascade;

alter table ventas
   add constraint fk_ventas_ref_bodegas foreign key (cod_bodega)
      references bodegas (cod_bodega)
      on delete restrict on update cascade;

