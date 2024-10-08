# Prueba William Castaño

Este documento describe el funcionamiento de un sistema de gestión de transacciones que incluye la apertura y cancelación de fondos. A continuación, se detallan los procesos y la configuración necesaria para implementar el sistema.

## Descripción del Sistema

En una **transacción de apertura**, se deduce el monto del usuario, validando que cumpla con el monto mínimo del fondo, que el usuario tenga los recursos suficientes, y que tanto el fondo como el usuario sean válidos. En caso de que se realice una **transacción de cancelación**, se suma el monto al usuario siempre que exista una transacción de apertura correspondiente.

## Configuración de la Base de Datos

Este proyecto utiliza una base de datos PostgreSQL. Para configurarla, es necesario tener un servidor PostgreSQL en funcionamiento con las siguientes credenciales:

- **Nombre de usuario:** postgres
- **Contraseña:** admin
- **Puerto:** 5432
- **Nombre de base de datos:** ssf

Alternativamente, puedes modificar las credenciales en `src/main/resources/application.properties`.

## Transacciones

### Crear Transacción

- **Método:** POST
- **URL:** `http://localhost:8080/transaction`
- **Cuerpo:**
  ```json
  {
    "monto": int,
    "tipo": "apertura" | "cancelacion",
    "usuario": {
      "id": int 
    },
    "fondo": {
      "id": int
    }
  }
  ```
  ### Listar Transacciones
  - **Método:** GET
  - **URL:** `http://localhost:8080/transaction`
 
  ### Buscar Transaccion por id
  - **Método:** GET
  - **URL:** `http://localhost:8080/transaction/{id}`
  

  ## Usuarios
  ### Crear Usuario
  - **Método:** POST
  - **URL:** `http://localhost:8080/user`
  - **Cuerpo:**
  ```json
  {
    "nombres": String,
     "telefono": String,
     "correo": String,
     "monto": int
   }
  ```
  ### Listar Usuarios
  - **Método:** GET
  - **URL:** `http://localhost:8080/user`
 
  ### Buscar Usuario por id
  - **Método:** GET
  - **URL:** `http://localhost:8080/user/{id}`
  
