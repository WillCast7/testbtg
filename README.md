# Prueba William Castaño

En una transaccion de apertura resta el dinero, validando si cumple con el monto minimo del fondo, si el usuario cuenta con los recursos, si el fondo es valido y si el usuario es valido
En el momento en el que se crea la transaccion de cancelacion suma al monto del usuario si La transaccion de apertura existe
Este proyecto tiene una base de datos integrada, para hacer uso de ella se debe configurar un servidor de base de datos postgres con las siguientes credenciales:

username=postgres
password=admin
puerto=5432
nombre de base de datos = ssf

o en su defecto cambiar las credenciales en src/main/resources/aplication.properties

#Transacciones
   *Crear transaccion* POST - http://localhost:8080/transaction
      body:
         {
            monto: int
            tipo: String | puede serapertura o cancelacion
            usuario: {
               id: int 
               },
            fondo: {
               id: int
               }
         }
         Ejemplo:
            {
               "monto": 200000,
               "tipo": "apertura",
               "usuario": {"id": 2},
               "fondo": {"id":2}
            }
   
   *Listar transacciones paginadas* GET - http://localhost:8080/transaction?itemsPerPage=10&activePage=0
   
   *Traer Transaccion* GET - http://localhost:8080/transaction/{id}

#Usuarios
   *Listar transacciones paginadas* GET - http://localhost:8080/user?itemsPerPage=10&activePage=0
   
   *Traer uSUARIO  * GET - http://localhost:8080/transaction/{id}