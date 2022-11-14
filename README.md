# Taxi24 Web API

Taxi24 es una nueva startup que quiere revolucionar la industria del transporte proporcionando una
solución de marca blanca existentes. Prácticamente, construirán un conjunto de APIs que otras compañías puedan utilizar
para gestionar su flota de pasajeros. Les gustaría que les ayudaras a construir estas APIs.

## Tecnologías utilizadas:

- `Java 11`
- `Spring Boot 2.7.5`
- `JPA Hibernate`
- `PostgreSql`

## Para empezar tener pendiente:

- Instalar `Maven`.
- Instalar el `JDK11`
- Instalar `PostgreSql`

## Clonar y cambiar configuracion del proyecto.

- Clonar el proyecto `taxi24` desde la ruta https://github.com/ingasanchez/taxi24
- Actualizar el archivo `application.properties` con las credenciales de la base de datos local.

## Iniciar el proyecto.

```sh
$ cd .../taxi24
$ mvn spring-boot:run
```

## EndPoints

| EndPoint                     | Función             |
| ---------------------------- | ------------------------- |
| `GET /conductor/obtenerTodos` | Obtener todos los conductores.|
| `GET /conductor/obtenerDisponibles` | Obtener conductores disponibles  |
| `GET /conductor/obtenerConductorByDistance/{coordenada}/{distancia}` | Lista conductores disponibles para ubicacion especificada en radio de distancia  |
| `GET/conductor/{Id}`    | Obtener conductor especifico por ID   |
| `POST /viaje/crearViaje`              | Crear nueva solicitud de viaje   |
| `PUT /viaje/completarViaje/{ID}/{coordenada}`   | Completar un viaje actualizando la coordenada destino  |
| `GET /viaje/obtenerViajesActivos`               | Obtener todos los viajes activos        |
| `GET /pasajero/obtenerTodos`     | Obtener todos los pasajeros existentes |
| `GET/pasajero/{Id}`    | Obtener pasajero especifico por ID   |
| `GET /pasajero/obtenerConductoresCercanos/{coordenada}/{cantidad}`    | Obtener n conductores cercanos a la coordenada especificada        |
| `GET /factura/obtenerTodas` | Obtener el listado de facturas          |
