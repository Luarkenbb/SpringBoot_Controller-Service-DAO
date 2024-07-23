# Use the official MySQL image from Docker Hub
FROM mysql:8.0

# Set environment variables
ENV MYSQL_DATABASE=classicmodels \
    MYSQL_ROOT_PASSWORD=admin

# Copy scripts to the docker-entrypoint-initdb.d directory so they are executed upon startup
COPY ./init.sql /docker-entrypoint-initdb.d/

# Expose port 3306 to access MySQL
EXPOSE 3306