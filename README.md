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
   git clone https://github.com/tu-usuario/cinema-reservation.git
   cd cinema-reservation
