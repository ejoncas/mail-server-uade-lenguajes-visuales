#Como configurar el proyecto

# Confiruacion MailServer #

Para configurar el proyecto es necesario editar el archivo config.properties en la carpeta src/.

en este archivo se encuentran las siguientes propiedades:

**mail.log.dateformat=[de dia para el log](formato.md)** mail.log.path=[a la direccion local donde se quiere guardar el LOG](path.md)
**database.jdbc=[de conexion a la base de datos](url.md)**


## Librerias ##

A continuacion se especifica por cada proyecto como deben configurarse las librerias.

### MailClientAdmin ###
Este proyecto no requiere librerias especiales, solo necesita que se especifique en su Build Path que requiere el proyecto _MailServer_.
Para Hacerlo hay que ir a propiedades del proyecto -> Build Path -> Referenced Proyects y ahí se agrega el proyecto _MailServer_.

### MailServer ###

En este proyecto algunas de las librerias necesarias estan especificadas en la carpeta _/lib_, hay que agregar todo los jars contenidos al Build Path.
Las demas librerias necesarias son Hibernate 3.5.1 y SLF4J. Estas librerias se utilizaron como _User Libraries_ por motivos de peso del proyecto.



### MailWebClient ###

AL igual que el proyecto _MailClientAdmin_ este proyecto requiere que se le asocie el proyecto _MailServer_.
Para Hacerlo hay que ir a propiedades del proyecto -> Build Path -> Referenced Proyects y ahí se agrega el proyecto _MailServer_.