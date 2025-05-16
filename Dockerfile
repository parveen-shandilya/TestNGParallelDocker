FROM maven:3.9.6-eclipse-temurin-17
WORKDIR /app

# Copy source code
COPY . /app

# Set environment variable for Docker
ENV RUN_IN_DOCKER=true

# Run Maven build
RUN mvn clean install

# Set entrypoint
ENTRYPOINT ["mvn", "test"]
