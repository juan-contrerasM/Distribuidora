La API REST para la [DISTRIBUIDORA] tiene como objetivo gestionar aspectos básicos relacionados con la administración de empleados, productos y categorías de productos. Este proyecto utiliza Java y Spring Boot, con Spring Data JPA para la persistencia de datos en PostgreSQL.

Seguridad
Se implementará autenticación básica en algunos endpoints, mientras que otros serán de acceso público.

Persistencia de datos
La gestión de la base de datos se realizará con Spring Data JPA, asegurando un manejo eficiente de la persistencia.

Consumo de API externa
El proyecto consumirá una API externa utilizando WebClient para realizar solicitudes HTTP y Gson para procesar los datos en formato JSON.

Estructura del proyecto
El proyecto sigue un diseño basado en el patrón MVC, con una clara distinción entre entidades y DTOs (Data Transfer Objects) para la transferencia de datos entre capas.

Pruebas y Validación
Se realizarán pruebas unitarias y manuales con Postman para garantizar el correcto funcionamiento de los endpoints.

Documentación
Se generará una documentación detallada de la API, incluyendo descripciones de las acciones y ejemplos de solicitudes y respuestas, además de la información sobre la base de datos y credenciales de acceso.

Configuración de la base de datos y credenciales
La API usará una base de datos PostgreSQL con los siguientes parámetros:

Nombre: Distribuidora
Usuario: postgres
Contraseña: admin
Puerto: 5432
Credenciales de seguridad:

Usuario: admin
Contraseña: admin123
Endpoints
Empleados:
POST /empleado/crearEmpleado
PUT /empleado/modificarEmpleado
PUT /empleado/editarEstado/{id} (cambio de estado: ACTIVO o INACTIVO)
GET /empleado/obtenerEmpleados
GET /empleado/obtenerEmpleado/{id}
Categorías de Producto:
POST /categoriaProducto/crearCategoria
PUT /categoriaProducto/modificarCategoria
DELETE /categoriaProducto/eliminarCategoria/{id}
Productos:
POST /producto/crearProducto
PUT /producto/modificarProducto
DELETE /producto/deleteProducto/{codigo}
PUT /producto/actualizarStock/{codigo} (cambio de stock en el cuerpo de la solicitud)
Tasa de cambio (TRM):
GET /dollar/obtenerValor
Ejecución
La API se ejecutará en un servidor local, con la URL base localhost:8080. Para usar la API, se debe ejecutar el archivo JAR con el comando: java -jar nombre_del_archivo.jar, teniendo la base de datos PostgreSQL habilitada.

Se proporcionarán ejemplos de respuestas a los endpoints mediante Postman, como crear o eliminar productos, obtener empleados y cambiar el stock, con y sin autenticación.
