# Use a specific version of the Keycloak image from quay.io
FROM quay.io/keycloak/keycloak:25.0.2

# Set environment variables
ENV KEYCLOAK_USER=admin
ENV KEYCLOAK_PASSWORD=admin

# Copy the realm configuration file
COPY ./configs/realm-config.json /opt/keycloak/data/import/realm-config.json

# Expose the Keycloak port
EXPOSE 4000

# Start Keycloak with import option
ENTRYPOINT ["/opt/keycloak/bin/kc.sh", "start-dev", "--http-port=4000", "--import-realm"]