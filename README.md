# tbd_emersys

----------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------GUIA DE PREPARACION----------------------------------------------------------
-----------------------------------------------------------------BACKEND----------------------------------------------------------------
------------------------------------------------------------------- Y ------------------------------------------------------------------
------------------------------------------------------------- BASE DE DATOS ------------------------------------------------------------

########################################################################################################################################
############################################################## PRECAUCION ##############################################################
########################################################################################################################################

Debido a que pueden existir conflictos con los puertos al momento de probar el proyecto, se recomienda seguir la guia para usar la parte
de backend del proyecto primero (esta parte) y LUEGO frontend, ya que la API manipula datos por medio del puerto 8080, es decir la URL
                                                             "http://localhost:8080".
Ademas, hay que tener una base de datos corriendo con el backup 'TBD_backup ver.5' que se halla en el directorio 'pgAdmin db backups'.

########################################################################################################################################
############################################################## PRECAUCION ##############################################################
########################################################################################################################################

                                                *******************************************
                                                ********PASOS PARA EJECUTAR PROYECTO*******
                                                *******************************************

******************BASE DE DATOS******************
********MONTANDO BASE DE DATOS CON  BACKUP*******

Para esta guia se utiliza pgAdmin 4 y PostgreSQL 12:

1) Ejecutar pgAdmin.
2) Una vez abierto, ingresar como administrador en caso de pedir clave.
3) Abrir la opcion de Servers de PostgreSQL que se encuentra al costado izquierdo. y crear una base de datos, es IMPORTANTE tener el nombre de
   esta base de datos creada para realizar la conexion con backend posteriormente.
4) Para la base de datos creada, hacer click derecho y seleccionar la opcion "Restore". Al hacer esto saldra una ventana para
   seleccionar el archivo de la base de datos.
5) En el campo filename, hacer click en el boton de la derecha para buscar el directorio del proyecto e ingresar a la carpeta
   'pgAdmin db backups'. En esta misma ventana, asegurarse que en la parte inferior que dice 'format' la opcion seleccionada sea 'All files',
   (en caso contrario el archivo no aparecera) y seleccionar el archivo 'TBD_backup ver.5'.
6) Asegurarse que la base de datos este conectada.

Para conectar la base de datos creada con el backend:
1) Abrir el directorio del proyecto y dirigirse a:
   src/main/java/tbd.lab/Repositories
   y hallar el archivo databaseContext
2) Modificar este archivo, poniendo el nombre de la base de datos al final de la url en la linea 11:
    "jdbc:postgresql://127.0.0.1:5432/X" (donde X es el nombre de la base de datos que desea conectar). en las partes siguientes, reemplazar los nombre de usuario de admin de pgAdmin e introduccir la clave.
    Ej de la linea para la conexion:
    return new Sql2o("jdbc:postgresql://127.0.0.1:5432/MyBaseDeDatos", "MiUsuario", "MiClave");

*****************BACKEND*****************
DESDE INTELLIJ:

1) Abrir intelliJ y seleccionar la opcion "open" para buscar el directorio que contiene el proyecto.
2) Una vez abierto el proyecto con IntelliJ, seleccionar en la barra superior la opcion "Run" de que se halla a la derecha
    de la barra de navegacion o tambien ejecutando el shortcut presionando las teclas Shift + F10.
3) Esperar a que el proyecto compile. Esto se sabra ya que en la IDE, por medio de la consola de Spring en la parte inferior,
   notificara con un mensaje diciendo "Started EmersysApplication in X seconds" (con X siendo la cantidad de segundos que demoro
   en preparar el proyecto).
4) La parte de backend del proyecto esta lista

DESDE CONSOLA:
1) abrir consola en el directorio del proyecto y ejecutar el comando 'gradlew bootRun'
2) Esperar a que el proyecto compile
3) Luego de un tiempo, deberia aparecer un mensaje diciendo "Started EmersysApplication in X seconds"
   (con X siendo la cantidad de segundos que   demoro en preparar el proyecto).
4) La parte de backend del proyeccto esta lista

AHORA HACE FALTA SEGUIR LA GUIA PARA EL FRONTEND DEL PROYECTO
Este se halla en el directorio tbd_emersys_FRONT, y seguir las instruccciones del archivo README.md
