CREATE USER AD_TEMA_03_FACTURAS IDENTIFIED BY AD_TEMA_03_FACTURAS;
GRANT CONNECT, RESOURCE,DBA TO AD_TEMA_03_FACTURAS;

CREATE TABLE articulos (
referencia VARCHAR2(13) NOT NULL,
descripcion VARCHAR2(255) NOT NULL,
precio NUMBER(12, 3) NOT NULL,
porcIva NUMBER(5, 2), -- 4, 10, 21 Es el porcentaje de Iva del Producto
Stock NUMBER(12, 3) NOT NULL
);

CREATE UNIQUE INDEX articulos_idx1 ON articulos (descripcion ASC );
ALTER TABLE articulos ADD CONSTRAINT pk_articulos PRIMARY KEY ( referencia );
CREATE TABLE clientes (
dnicif VARCHAR2(13) NOT NULL,
nombrecli VARCHAR2(100) NOT NULL
);
ALTER TABLE clientes ADD CONSTRAINT pk_clientes PRIMARY KEY ( dnicif );

CREATE TABLE facturas_cab (
numfac NUMBER(10) NOT NULL,
fechafac DATE,
dnicif VARCHAR2(13) NOT NULL
);
ALTER TABLE facturas_cab ADD CONSTRAINT pk_facturas_cab PRIMARY KEY ( numfac );
ALTER TABLE facturas_cab ADD CONSTRAINT fk_facturas_cab_clientes
FOREIGN KEY ( dnicif ) REFERENCES clientes ( dnicif );

CREATE TABLE facturas_lin (
numfac NUMBER(10) NOT NULL,
lineafac NUMBER(10) NOT NULL,
referencia VARCHAR2(13) NOT NULL,
cantidad NUMBER(12, 3) NOT NULL,
precio NUMBER(12, 3) NOT NULL,
dtolinea NUMBER(5, 2) NOT NULL, -- Es el porcentaje de Descuento
Ivalinea NUMBER(5, 2) NOT NULL -- Es el Iva de la linea
);
ALTER TABLE facturas_lin ADD CONSTRAINT pk_facturas_lin PRIMARY KEY ( numfac,lineafac );
ALTER TABLE facturas_lin ADD CONSTRAINT fk_facturas_lin_articulos
FOREIGN KEY ( referencia ) REFERENCES articulos ( referencia );
ALTER TABLE facturas_lin ADD CONSTRAINT fk_facturas_lin_facturas_cab
FOREIGN KEY ( numfac ) REFERENCES facturas_cab ( numfac );

CREATE TABLE facturas_tot (
numfac NUMBER(10) NOT NULL,
baseimp NUMBER(12, 2),
imp_dto NUMBER(12, 2),
imp_iva NUMBER(12, 2),
totalfac NUMBER(12, 2)
);
ALTER TABLE facturas_tot ADD CONSTRAINT pk_facturas_tot PRIMARY KEY ( numfac );
ALTER TABLE facturas_tot ADD CONSTRAINT fk_facturas_tot_facturas_cab
FOREIGN KEY ( numfac ) REFERENCES facturas_cab ( numfac ) ON DELETE CASCADE;


CREATE TABLE estadisticas_clientes (
anio NUMBER(10) NOT NULL, -- año
mes_num NUMBER(10) NOT NULL, -- mes en numero
mes_nom VARCHAR2(13) NOT NULL, -- mes en nombre ( Enero, Febrero, ...)
dnicif VARCHAR2(13) NOT NULL,
nombrecli VARCHAR2(100) NOT NULL,
suma_base NUMBER(12, 2),
suma_dtos NUMBER(12, 2),
suma_iva NUMBER(12, 2),
suma_totales NUMBER(12, 2)
);
ALTER TABLE estadisticas_clientes ADD CONSTRAINT pk_estadisticas_clientes
PRIMARY KEY ( anio, mes_num, dnicif );
ALTER TABLE estadisticas_clientes ADD CONSTRAINT fk_estadisticas_clientes
FOREIGN KEY ( dnicif ) REFERENCES clientes ( dnicif );
COMMIT;

INSERT INTO ARTICULOS VALUES ('P01', 'AIRE ACONDICIONADO TIPO 1', 300, 21, 19);
INSERT INTO ARTICULOS VALUES ('P02', 'AIRE ACONDICIONADO TIPO 2', 500, 21, 14);
INSERT INTO ARTICULOS VALUES ('P03', 'AIRE ACONDICIONADO TIPO 3', 600, 21, 50 );
INSERT INTO ARTICULOS VALUES ('P04', 'GARANTIA 24 MESES', 50, 21, 100000);
INSERT INTO ARTICULOS VALUES ('P05', 'INSTALACION', 150, 10, 100000);
INSERT INTO ARTICULOS VALUES ('P06', 'TRANSPORTE', 20, 4, 100000);
COMMIT;
INSERT INTO CLIENTES VALUES ('C01','CLIENTE UNO');
INSERT INTO CLIENTES VALUES ('C02','CLIENTE DOS');
COMMIT;
INSERT INTO FACTURAS_CAB VALUES (1000,SYSDATE,'C01');
INSERT INTO FACTURAS_CAB VALUES (1001,SYSDATE,'C02');
INSERT INTO FACTURAS_CAB VALUES (1002,SYSDATE,'C01');
COMMIT;
INSERT INTO FACTURAS_LIN VALUES (1000, 1, 'P01', 2, 290, 10, 21);
INSERT INTO FACTURAS_LIN VALUES (1000, 2, 'P05', 1, 150, 0, 10);
COMMIT;
INSERT INTO FACTURAS_LIN VALUES (1001, 1, 'P02', 1, 500, 10, 21);
INSERT INTO FACTURAS_LIN VALUES (1001, 2, 'P05', 1, 150, 0, 10);
INSERT INTO FACTURAS_LIN VALUES (1001, 3, 'P06', 1, 20, 50, 4);
INSERT INTO FACTURAS_LIN VALUES (1001, 4, 'P04', 1, 0, 0, 21);
COMMIT;
INSERT INTO FACTURAS_LIN VALUES (1002, 1, 'P03', 1, 600, 0, 21);
COMMIT;
