La API REST para la [DISTRIBUIDORA] tiene como objetivo principal gestionar los diferentes aspectos relacionados con la administración básica de empleados, productos y categorías de productos. Este proyecto se desarrollará utilizando Java y Spring Boot como tecnologías principales, aprovechando la potencia de Spring Data JPA para la persistencia en una base de datos PostgreSQL.

Seguridad
Para garantizar la seguridad de la API, se implementará autenticación basada en autenticación básica en ciertos endpoints, mientras que otros serán de acceso público.

Persistencia de datos
La persistencia de datos se llevará a cabo utilizando Spring Data JPA, Esto asegurará una gestión eficiente de la base de datos.

Consumo de API externa
Uno de los requisitos clave del proyecto es el consumo de una API externa para obtener y transformar datos según sea necesario. Para esto, se utilizará WebClient para realizar las solicitudes HTTP y Gson para la serialización y deserialización de datos JSON.

Estructura del proyecto
El proyecto se estructurará siguiendo las mejores prácticas de diseño y modelado, con la definición clara de entidades y DTOs (Data Transfer Objects) para la transferencia de datos entre las diferentes capas de la aplicación, usando también un patrón de diseño MVC.

Pruebas y Validación
Se llevarán a cabo algunas pruebas, incluyendo pruebas unitarias, para garantizar el correcto funcionamiento de la API. Además, se utilizará Postman para realizar pruebas manuales de los diferentes endpoints y verificar que todas las funcionalidades se comportan según lo esperado.

Documentación
Finalmente, se generará documentación detallada para la API, que incluirá pantallazos y descripciones de cada una de las acciones solicitadas. Esta documentación proporcionará una guía sobre cómo utilizar la API, incluyendo la solicitud y la respuesta de cada endpoint, así como información relevante sobre la base de datos utilizada, incluyendo nombre de usuario y contraseña.

Configuración base de datos y credenciales de los endpoints
Para la conexión a la base de datos se utiliza PostgreSQL.

Base de datos:

Nombre:Distribuidora
Usuario:postgres
Contraseña:admin
Puerto:5432
Credenciales para seguridad Spring:

Usuario:admin
Contraseña:admin123
Ver archivo de configuración PROPIEDADES

Listado de puntos finales
Puntos finales del empleado:
CORREO/empleado/crearEmpleado
PONER/empleado/modificarEmpleado
PONER/empleado/editarEstado/{id}
para editar el estado en la url debe poner el id del empleado y en el cuerpo del mensaje el estado, sea ACTIVO o INACTIVO
CONSEGUIR/empleado/obtenerEmpleados
CONSEGUIR/empleado/obtenerEmpleado/{id}
Puntos finales de Categoría de Producto:
CORREO/categoriaProducto/crearCategoria
PONER/categoriaProducto/modificarCategoria
BORRAR/categoriaProducto/eliminarCategoria/{id}
Puntos finales del producto:
CORREO/producto/crearProducto
PONER/producto/modificarProducto
BORRAR/producto/deleteProducto/{codigo}
PONER/producto/actualizarStock/{codigo}
para el stock en la url va el código del producto y en el cuerpo de la soicitud la cantidad a actualizar
Punto final del TRM:
CONSEGUIR/dollar/obtenerValor
Es importante tener en cuenta que el servidor será de forma local por lo cual al ejecutar la api quedarária como base de la url localhost:8080'el endpoint a solicitar', un ejemplo sería localhost:8080/dollar/obtenerValor.

Para hacer uso de la api basta con ejecutar el jar y tener la base de datos PostgreSQL habilitada
comando en consola para ejecutar el jar [ java -jar nombre_del_archivo.jar] Es de aclarar que debes de descargar el jar antes de y reemplazar por el nombre del archivo.
JAR PARA DESCARGAR --> Distribuidora A continuación se encuentran ejemplos de los resultados a algunos endpoints usando POSTMAN

CREAR PRODUCTO

ELIMINAR CATEGORIA

ELIMINAR PRODUCTO

CONSIGUE EMPLEADOS

CAMBIAR STOCK CON AUTENTICACION

CAMBIAR STOCK SIN AUTENTICACION

OBTENGA EL CAMBIO DE DIVISA
