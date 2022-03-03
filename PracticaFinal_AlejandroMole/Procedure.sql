
CREATE OR REPLACE PROCEDURE PR_ESTADISTICAS(DNI_INI VARCHAR2,DNI_FIN VARCHAR2, FECHA_INI DATE, FECHA_FIN DATE)
AS
  --Me declaro las variables que usare 
  NUM_FACTURAS NUMBER;
  XANIO NUMBER;
  XMES NUMBER;
  XCR_CLIENTE CLIENTES%ROWTYPE; --tipo de la taba clientes
  XCR_FACTURASLIN FACTURAS_LIN%ROWTYPE; --tipo de la tbal de facturas_lin
  XESTADISTICAS_CLIENTES ESTADISTICAS_CLIENTES%ROWTYPE;--tipo de la tabla de estadisticas clientes
  XFACTURAS_TOT FACTURAS_TOT%ROWTYPE; --tipo de la tabla facturas tot
  FECHA DATE;
  EXISTE NUMBER;
  
  --me creo un cursor el cual me recorrera por cada dni, de entre los dos que he mandado al procedure
  CURSOR CR_CLIENTES IS SELECT * FROM CLIENTES WHERE DNICIF BETWEEN DNI_INI AND DNI_FIN;
  --este cursor recorrera y sacara el año en numero, el mes, y la fecha en general, de la factura cab donde el dni sea el que hemos sacado del cursor anterior y que este entre
  --las dos fecha que hemos recojido por parametro
  CURSOR CR_FACTURAS IS SELECT TO_NUMBER(TO_CHAR(FECHAFAC, 'YYYY')) AS ANIO, TO_NUMBER(TO_CHAR(FECHAFAC, 'MM')) AS MES, NUMFAC, FECHAFAC
  FROM FACTURAS_CAB WHERE DNICIF = XCR_CLIENTE.DNICIF AND FECHAFAC BETWEEN FECHA_INI AND FECHA_FIN;
  
  --cursor que recorre las lineas de facturas donde el numero de factura es el que hemos sacado en el cursor anterior
  CURSOR CR_FACTURASLIN IS SELECT * FROM FACTURAS_LIN WHERE NUMFAC = NUM_FACTURAS;

BEGIN
  --Borro la tabla estadisticas clientes donde el dni esta entre los dos que se han pasado y el anio y mes estan entre las dos fecha que se han pasado
  DELETE ESTADISTICAS_CLIENTES WHERE ANIO BETWEEN TO_NUMBER(TO_CHAR(FECHA_INI, 'YYYY')) AND TO_NUMBER(TO_CHAR(FECHA_FIN, 'YYYY'))
                               AND MES_NUM BETWEEN TO_NUMBER(TO_CHAR(FECHA_INI, 'MM')) AND TO_NUMBER(TO_CHAR(FECHA_FIN, 'MM'))
                               AND DNICIF BETWEEN DNI_INI AND DNI_FIN;

  --abro el primer cursor
  OPEN CR_CLIENTES;
    LOOP
    --lo meto en una variable
      FETCH CR_CLIENTES INTO XCR_CLIENTE;
      EXIT WHEN CR_CLIENTES%NOTFOUND;
        --abro el segundo cursor
        OPEN CR_FACTURAS;
          LOOP
            --meto los datos en diferentes variables
            FETCH CR_FACTURAS INTO XANIO, XMES, NUM_FACTURAS, FECHA;
            EXIT WHEN CR_FACTURAS%NOTFOUND;
              --abro el tercer cursor
              OPEN CR_FACTURASLIN;
                LOOP
                  --meto los datos en una variable
                  FETCH CR_FACTURASLIN INTO XCR_FACTURASLIN;
                  EXIT WHEN CR_FACTURASLIN%NOTFOUND;
                    --compruebo si existe ya un registro en la tabla
                    SELECT COUNT(*) INTO EXISTE FROM ESTADISTICAS_CLIENTES WHERE ANIO = XANIO AND MES_NUM = XMES AND DNICIF = XCR_CLIENTE.DNICIF;
                    --meto los datos de facturas total donde el numero de la factura es la que hemos sacado en una variable
                    SELECT * INTO XFACTURAS_TOT FROM FACTURAS_TOT WHERE NUMFAC = XCR_FACTURASLIN.NUMFAC;
                    
                    --si no existe entonces insertamos un registro en la tabla de estadisticas
                    IF(EXISTE = 0) THEN
                      INSERT INTO ESTADISTICAS_CLIENTES VALUES(XANIO, XMES,TO_CHAR(FECHA,'MONTH'),XCR_CLIENTE.DNICIF,XCR_CLIENTE.NOMBRECLI,XCR_FACTURASLIN.PRECIO,XCR_FACTURASLIN.DTOLINEA,XCR_FACTURASLIN.IVALINEA,XFACTURAS_TOT.TOTALFAC);
                    END IF;
                    
                    --si existe entonces primero borramos los datos y luego los insertamos teniendo en cuenta los que ya habian mas lo que se les suma de las facturas linea
                    IF(EXISTE <> 0) THEN
                      SELECT * INTO XESTADISTICAS_CLIENTES FROM ESTADISTICAS_CLIENTES WHERE ANIO = XANIO AND MES_NUM = XMES AND DNICIF = XCR_CLIENTE.DNICIF;
                      DELETE ESTADISTICAS_CLIENTES WHERE ANIO = XANIO AND MES_NUM = XMES AND DNICIF = XCR_CLIENTE.DNICIF;
                      INSERT INTO ESTADISTICAS_CLIENTES VALUES(XANIO, XMES,TO_CHAR(FECHA,'MONTH'),XCR_CLIENTE.DNICIF,XCR_CLIENTE.NOMBRECLI,
                                                              (XESTADISTICAS_CLIENTES.SUMA_BASE + XCR_FACTURASLIN.PRECIO),
                                                              (XESTADISTICAS_CLIENTES.SUMA_DTOS + XCR_FACTURASLIN.DTOLINEA),
                                                              (XESTADISTICAS_CLIENTES.SUMA_IVA + XCR_FACTURASLIN.IVALINEA),
                                                              (XESTADISTICAS_CLIENTES.SUMA_TOTALES + XFACTURAS_TOT.TOTALFAC));
                    END IF;
                   
                END LOOP;
                --cerramos el tercer cursor
              CLOSE CR_FACTURASLIN;   
          END LOOP;
          --cerramos el segundo cursor
        CLOSE CR_FACTURAS;
    END LOOP;
    --cerramos el primer cursor
  CLOSE CR_CLIENTES;
  --hago un commit;
  COMMIT;
END;



