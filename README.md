# SpringBoot_Controller-Service-DAO
This is my private project, developed for self learning purpose
Feel free to leave me comments on discussion board. :)
( current status: try and error with springboot & keycloak)
( pending to direct user to keycloak login when having no jwt token)
( pending to build another sql example for stored procedures with springboot)
# Service
## Springboot
    Maven Project (Java)
    SpringBoot 3.2.5
    Java: 21
    Dependencies:
        Lombok
        MySQL Driver
        Spring Data JPA
        Spring Web
    ports: 
        internal: 8080
        external: 8000
    mysql:
        account: springboot
        password: admin

Swagger url: http://localhost:8000/swagger-ui/index.html
## mysql
    admin account: mysql
    admin password: admin
    mysql:8.0
    ports:
        internal:3306
        external:33306

## keycloak
    access http://localhost:4000 and login with admin:admin

    Realm:backend
        roles:admin
            springboot:admin 

    ports:
        internal:4000
        external:4000

    protected for:
        springboot (pending)

# docker command
Docker command: docker compose -f compose.yaml up --build
