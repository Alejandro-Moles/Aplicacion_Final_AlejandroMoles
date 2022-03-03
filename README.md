# Aplicacion_Final_AlejandroMoles
La aplicacion es una interfaz que consta de cuatro botones, cada uno hace una accion diferente, que al pulsarlo se abrira una ventana modal para realizar la accion que cada uno tiene asignado.

--GESTION DE ARTICULOS:
	Esta ventana se encarga de gestionar todo aquello relacionado con los articulos, tendra un menu con tres botones, añadir, borra, y modificar, cada uno se encarga de realizar esos tres
	tipos de acciones en la tabla de articulos en la base de datos. Para añadir se tendran que rellenar los campos que aparecen en el panel de la izquierda. Para borra se tendra que 
	selecionar en la tabla de la derecha una fila para borrar, y para modificar, se selecionara una fila para modificar y se pondran los nuevos datos en el panel de la izquierda.
	Este ventana tambien contara con un filtrador, que consistira en un combobox en el cual se selcciona la columna por la que se quiere filtrar y un textfield donde se realizara la 
	busqueda. el filtro sera un lo que en sql se conoces como un Like.La tabla de la derecha es donde se visualizaran los articulos que hay disponibles.


--GESTION DE CLIENTES:
	Esta ventana tiene lo mismo que la anterior pero con especto a la tabla de Clientes, es decir, la tabla en vez de tener los articulos, tendran los clientes, y asi con todo.
	Tambien contara con un filtro el cual funciona de la misma manera que el de la ventana anterior.


--GESTION DE FACTURAS:
	Esta ventana contara con lo mismo que las dos anteriores, añadiendole tambien dos paneles mas, uno para exportar a xml o a json y el otro para exportar una factura de xml.
	Al pulsar la fia de unacabecera de factura, preguntara si quieres ver las lineas de factura asociadas a esa cabecera de factura, si se selcciona que no, se te marcaran en la parte de
	los datos todos los datos que hay de esa cabecera de factura seleccionada en la tabla. Si en cambio se le da a q si, se abrira un nuevo Dialog, el cual contiene todos las lineas de
	facturas relacionadas a esa cabecera seleccionada.

		--LINEA DE FACTURAS:
			Esta ventana cuenta con los botones de modificar, eliminar y añadir que tienen las otras ventanas, tambien tiene el filtro que funciona de la misma manera. Cuando se
			añada una linea de factura, el stock de articulos se modificara, y si se intenta añadir una linea con un producto en el que no hay mas stocks, dara un error. En el 
			campo de cantidad, se mostrar por un texto la cantidad de stock para ese articulo. Tambien en el campo de precio no se podra escribir nada, si no que se calculara 
			automaticamente teniendo en cuenta la cantidad de los productos por el precio del mismo.
			Al crear una linea, eliminarla o modificarla se le aplicaran los cambios al stock y a la tabla de facturas_tot. La cual creo un registro al crearse una factura cab

	Para exportar la factura, primero se tendra que selccionar una factura, para luego pulsar el boton y seleccionar un directorio donde se guardaran e fichero que se exportara, del tipo 
	que se ha seleccionado en el combobox. Antes de eso se abrira un dialog preguntando el nombre, el cual se tendra que poner , por defecto tendra puesto el de Facturas.
	Para generar una oferta, lo primero que se tendra que hacer sera seleccionar una factura, despues pulsar al boton, el cual abrira una ventana para seleccionar un archivo, en el que se
	encuentra las lineas de facturas que quiere importar en la factura seleccionada, el archivo tendra que ser xml. Una vez seleccionado se añadiran a la factura seleccionasa las lineas 
	de facturas que se encuentran es ese archivo.


--ESTADISTICAS DE CLIENTES:
	En esta ventana, habra un panel para seleccionar dos dni de clientes y dos fechas, estos datos seran un intervalo de entre ellos mismos los cuales se mandaran a un procedimiento
	almacenado en la base de datos al pulsar el boton de generar estadisticas, el cual generara las estadisticas y las metera en la tabla, la cual se mostrar en la tabla de la derecha
	la ventana tambien contara con el filtro que tiene las demas ventanas.

Todo el funcionamiento interno del programa esta explicado en el codigo del mismo.
Tanto como la creacion de la base de datos como la creacion del procedimiento almacenado, estan en distintos ficheros con extension .sql
Trabajo realizado por Alejandro Moles Hurtado. 
 
