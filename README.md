# Turismo API

API REST desarrollada con Spring Boot y MongoDB (Atlas) para gestionar información turística de la ciudad de Málaga.Esta aplicación permite gestionar recursos principales como Hoteles, Reservas, Puntos de Interés (POIs) y Reseñas, ofreciendo operaciones de lectura y escritura (con autenticación para operaciones sensibles).

---

## Tecnologías Utilizadas

- **Spring Boot 3.4.3**: Framework para el desarrollo rápido de aplicaciones Java.
- **Spring Data MongoDB**: Acceso a datos utilizando MongoDB Atlas.
- **Spring Security**: Seguridad básica para proteger los endpoints de escritura.
- **Thymeleaf**: Motor de plantillas (opcional para vistas).
- **Lombok**: Reducción de código boilerplate (generación automática de getters, setters, constructores, etc.).
- **Java 21**

---

## Configuración

### `application.properties`

Configura la conexión a MongoDB Atlas y define el nombre de la base de datos:

```properties
spring.application.name=turismo
spring.data.mongodb.uri=mongodb+srv://${MONGO_USER}:${MONGO_PASSWORD}@cluster0.sq2rg.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0
spring.data.mongodb.database=tourism
```

**Nota:** Define las variables de entorno `MONGO_USER` y `MONGO_PASSWORD` con tus credenciales.

### Seguridad

Las operaciones de escritura (`POST`, `PUT`, `DELETE`) requieren autenticación básica.

**Credenciales de ejemplo:**

- **Usuario:** `admin`
- **Contraseña:** `password`

---

## Recursos y Endpoints

### 1. Hoteles

#### Obtener todos los hoteles

```http
GET http://localhost:8080/hoteles
```

#### Obtener un hotel por ID

```http
GET http://localhost:8080/hoteles/{id}
```

#### Crear un hotel (Protegido)

```http
POST http://localhost:8080/hoteles
Authorization: Basic YWRtaW46cGFzc3dvcmQ=
Content-Type: application/json

{
  "nombre": "Hotel Vista Mar",
  "direccion": "Avenida del Mediterráneo, 45, Málaga",
  "descripcion": "Hotel con vistas al mar y excelente servicio",
  "calificacion": 4.6
}
```

#### Actualizar un hotel (Protegido)

```http
PUT http://localhost:8080/hoteles/{id}
Authorization: Basic YWRtaW46cGFzc3dvcmQ=
Content-Type: application/json

{
  "nombre": "Hotel Malagueta Renovado",
  "direccion": "Calle del Litoral, 15, Málaga",
  "descripcion": "Hotel con renovaciones y nuevas instalaciones",
  "calificacion": 4.7
}
```

---

### 2. Reservas

#### Crear una reserva (Protegido)

```http
POST http://localhost:8080/reservas
Authorization: Basic YWRtaW46cGFzc3dvcmQ=
Content-Type: application/json

{
  "nombreHuesped": "Juan Pérez",
  "fechaEntrada": "2023-07-01",
  "fechaSalida": "2023-07-05",
  "hotelId": "h1"
}
```

---

### 3. Puntos de Interés (POIs)

#### Obtener todos los POIs

```http
GET http://localhost:8080/pois
```

#### Obtener un POI por ID

```http
GET http://localhost:8080/pois/{id}
```

#### Obtener POIs cercanos a una ubicación

```http
GET http://localhost:8080/pois/near?lat={lat}&lon={lon}
```

#### Crear un POI (Protegido)

```http
POST http://localhost:8080/pois
Authorization: Basic YWRtaW46cGFzc3dvcmQ=
Content-Type: application/json

{
  "nombre": "Museo de Arte Moderno",
  "descripcion": "Exposición de arte contemporáneo",
  "latitud": 36.7205,
  "longitud": -4.4210,
  "categoria": "Museo"
}
```

#### Obtener todas las categorías de POIs

```http
GET http://localhost:8080/pois/categorias
```

---

### 4. Reseñas

#### Obtener todas las reseñas

```http
GET http://localhost:8080/resenas
```

#### Obtener una reseña por ID

```http
GET http://localhost:8080/resenas/{id}
```

#### Crear una reseña (Protegido)

```http
POST http://localhost:8080/resenas
Authorization: Basic YWRtaW46cGFzc3dvcmQ=
Content-Type: application/json

{
  "autor": "Carlos Martínez",
  "comentario": "Excelente servicio y ambiente acogedor.",
  "calificacion": 4,
  "poiId": "p1"
}
```

#### Actualizar una reseña (Protegido)

```http
PUT http://localhost:8080/resenas/{id}
Authorization: Basic YWRtaW46cGFzc3dvcmQ=
Content-Type: application/json

{
  "autor": "Luis García",
  "comentario": "Actualización: mejor atención de lo esperado.",
  "calificacion": 5,
  "poiId": "p1"
}
```

#### Eliminar una reseña (Protegido)

```http
DELETE http://localhost:8080/resenas/{id}
Authorization: Basic YWRtaW46cGFzc3dvcmQ=
```

---

## Ejecución

Para compilar y ejecutar la aplicación:

### Construir el proyecto con Maven:

```bash
mvn clean package
```

### Ejecutar la aplicación:

```bash
mvn spring-boot:run
```

La aplicación se iniciará en el puerto `8080`.

---

## Notas Adicionales

### Autenticación

Las operaciones de escritura (`POST`, `PUT`, `DELETE`) están protegidas mediante autenticación básica. Asegúrate de incluir la cabecera `Authorization` con las credenciales correctas en tus peticiones.

### MongoDB Atlas

La conexión a la base de datos se realiza mediante MongoDB Atlas. Verifica que las variables de entorno `MONGO_USER` y `MONGO_PASSWORD` estén configuradas correctamente.

### Pruebas

Puedes utilizar herramientas como `cURL`, `Postman` o el cliente HTTP integrado en `IntelliJ IDEA` para probar los diferentes endpoints.

---

© 2025 Turismo API. Todos los derechos reservados.
