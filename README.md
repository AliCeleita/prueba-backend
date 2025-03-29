# 📦 Prueba Backend - Microservicios con Spring Boot

Este proyecto implementa una arquitectura de microservicios con **Spring Boot 3**, **RabbitMQ** para mensajería y **PostgreSQL** como base de datos.

## 🚀 Servicios

1. **order-service**: Gestiona órdenes de compra.
2. **inventory-service**: Administra inventario y productos.
3. **delivery-service**: Controla el proceso de entrega.

## 🛠️ Tecnologías

- **Java 17** + Spring Boot 3
- **Spring Data JPA** + PostgreSQL
- **Spring AMQP** (RabbitMQ)
- **Docker y Docker Compose**

## 📂 Estructura del Proyecto

```
prueba-backend/
│── order-service/
│── inventory-service/
│── delivery-service/
│── docker-compose.yml
```

## 🔧 Configuración de Base de Datos

El sistema usa **PostgreSQL**, configurado en `docker-compose.yml`:
```yaml
services:
  postgres_db:
    image: postgres:latest
    environment:
      POSTGRES_DB: ordersDb
      POSTGRES_USER: helisa
      POSTGRES_PASSWORD: 14785
    ports:
      - "5432:5432"
```

## 🐇 Configuración de RabbitMQ

En `docker-compose.yml`:
```yaml
services:
  rabbitmq:
    image: rabbitmq:3-management
    ports:
      - "5672:5672"
      - "15672:15672"
    environment:
      RABBITMQ_DEFAULT_USER: guest
      RABBITMQ_DEFAULT_PASS: guest
```

## 🖥️ Configuración de Adminer

Para administrar la base de datos PostgreSQL fácilmente, se incluye **Adminer** en `docker-compose.yml`:
```yaml
services:
  adminer:
    image: adminer
    container_name: adminer
    restart: always
    ports:
      - "9090:8080"
```

Accede a Adminer en [http://localhost:9090](http://localhost:9090), usa las credenciales:
- **Servidor**: postgres_db
- **Usuario**: helisa
- **Contraseña**: 14785
- **Base de datos**: ordersDb

## 📦 Instalación y Ejecución

1️⃣ **Clonar el repositorio**
```sh
git clone https://github.com/AliCeleita/prueba-backend.git
cd prueba-backend
```

2️⃣ **Levantar los servicios con Docker**
```sh
docker-compose up --build
```

3️⃣ **Acceder a los servicios**
- RabbitMQ UI: [http://localhost:15672](http://localhost:15672) (user: guest, pass: guest)
- Adminer: [http://localhost:9090](http://localhost:9090)

## 📜 Ver Logs de los Servicios en Docker

Para ver los logs de cada servicio en ejecución:
```sh
docker logs -f order-service
```
```sh
docker logs -f inventory-service
```
```sh
docker logs -f delivery-service
```

Para ver todos los contenedores en ejecución:
```sh
docker ps
```
---

📌 **Autor**: [Alisson Celeita](https://github.com/AliCeleita)  
📅 **Última actualización**: Marzo 2025
