# SpringBootRevisit
This is my private project, developed for self learning purpose.
Feel free to leave me comments on the discussion board. :)
(pending to build another SQL example for stored procedures with Spring Boot)

# Services

## Spring Boot
- Maven Project (Java)
- Spring Boot 3.2.5
- Java: 21
- Dependencies:
  - Lombok
  - MySQL Driver
  - Spring Data JPA
  - Spring Web
- Ports:
  - Internal: 8080
  - External: 8000
- MySQL:
  - Account: springboot
  - Password: admin

Swagger URL: (http://localhost:8000/swagger-ui/index.html)

- Remarks:
  - Suggest to use Postman to test protected api in this stage (Bearer + access_token)

## MySQL
- Admin account: mysql
- Admin password: admin
- MySQL version: 8.0
- Ports:
  - Internal: 3306
  - External: 33306

## Keycloak
- Admin account: keycloak
- Admin password: admin
- Keycloak version: 24.0.2
- Ports:
  - Internal: 4000
  - External: 4000
- Realm: martin-realm
- Users:
  - Username: springboot
  - Password: admin
- Clients:
  - Client ID: martin-root
  - Secret: martin-secret
  - Web Origins:
    - (http://localhost:8000)

## RocketMQ
- Ports:
  - 9876
  - 10911
  - 10909
  - 10912

# Docker Command
To build and start the services, run the following command:
```sh
docker compose -f compose.yaml up --build
```
# Future Milestones
1. login.html --> call login api --> get token and store in sessionStorage
2. rocketMQ example
3. springboot package restructure (seperating to sub-packages)