# Cinema Reservation App

## Descripción del Proyecto
Este proyecto es una aplicación de reservas de cine que permite a los usuarios seleccionar una película, una sala y un horario para realizar una reserva de asientos. La aplicación se divide en dos partes principales:

1. **Backend**: Desarrollado en **Spring Boot**, que gestiona las películas, salas y reservas mediante una API REST.
2. **Frontend**: Desarrollado en **React**, que interactúa con el backend y permite a los usuarios realizar las reservas de manera dinámica a través de una interfaz de usuario interactiva.

### Características:
- Ver una lista de películas disponibles.
- Seleccionar una película, una sala y un asiento.
- Reservar asientos para una película en una sala y horario específicos.
- Ver las reservas realizadas.

---

## Tecnologías Utilizadas

- **Backend**: 
  - **Spring Boot**: Framework basado en Java para el desarrollo de la API REST.
  - **AWS RDS**: Base de datos PostgreSQL para almacenar la información de películas, salas y reservas.
  
- **Frontend**:
  - **React**: Biblioteca de JavaScript para construir la interfaz de usuario interactiva.
  - **Axios**: Cliente HTTP para realizar solicitudes al backend.
  - **CSS**: Para el diseño y estilo de la interfaz de usuario.

---

## Requisitos del Sistema

- **Backend** (Spring Boot):
  - **JDK 11** o superior.
  - **Maven** o **Gradle** como gestor de dependencias.
  
- **Frontend** (React):
  - **Node.js** y **npm**.

---

## Instalación y Configuración

### Backend (Spring Boot)

1. **Clonar el repositorio**:

   ```bash
   git clone [https://github.com/tu-usuario/cinema-reservation.git](https://github.com/lniet11/kata.git)
   cd cinema-reservation
2. Accede al directorio del backend y compílalo:
Si usas Maven:

bash
Copiar
cd backend
mvn clean install

O si usas Gradle:

bash
Copiar
cd backend
gradle build
3. Ejecuta la aplicación de Spring Boot:

Si usas Maven:

bash
Copiar
mvn spring-boot:run
O si usas Gradle:

bash
Copiar
gradle bootRun
Esto levantará el servidor de Spring Boot en http://localhost:8080, donde las API estarán disponibles.
-Frontend (React)
1. Accede al directorio del frontend:

bash
Copiar
cd frontend
2. Instala las dependencias de npm:

bash
Copiar
npm install
3. Ejecuta la aplicación de React:

bash
Copiar
npm start

Esto abrirá la aplicación en http://localhost:3000 en tu navegador.

Conexión entre Backend y Frontend
Asegúrate de que el backend (Spring Boot) esté corriendo antes de intentar interactuar con la aplicación frontend. React realizará las solicitudes a las API REST de Spring Boot en el puerto 8080 (por defecto).

API Endpoints:
El backend expone las siguientes API REST:

Películas (Movies)

GET /api/movies: Obtiene todas las películas.
POST /api/movies: Crea una nueva película.
GET /api/movies/{id}: Obtiene los detalles de una película por su ID.
PUT /api/movies/{id}: Actualiza los detalles de una película.
DELETE /api/movies/{id}: Elimina una película.
Salas (Rooms):
GET /api/rooms: Obtiene todas las salas.
POST /api/rooms: Crea una nueva sala.
GET /api/rooms/{id}: Obtiene los detalles de una sala por su ID.
PUT /api/rooms/{id}: Actualiza los detalles de una sala.
DELETE /api/rooms/{id}: Elimina una sala.
Reservas (Reservations):
GET /api/reservations: Obtiene todas las reservas.
POST /api/reservations: Crea una nueva reserva.
GET /api/reservations/{id}: Obtiene los detalles de una reserva por su ID.
PUT /api/reservations: Actualiza los detalles de una reserva.
DELETE /api/reservations/{id}: Elimina una reserva.

