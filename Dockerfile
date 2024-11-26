FROM bitnami/java:21
MAINTAINER "cbenavides@unimagdalena.edu.co"

# Setting the main folders
ARG BUILD_DIR=/opt
ARG APP_DIR=/app

# Copying the project
COPY .mvn/ $BUILD_DIR/.mvn/
COPY src $BUILD_DIR/src/
COPY mvnw $BUILD_DIR/
COPY pom.xml $BUILD_DIR/

# Building the project
WORKDIR $BUILD_DIR
# Note: Create separate network to bridge
#       with postgres container and run this
#       container in the same network as
#       the postgres container
RUN sed -i 's/localhost\:5432/postgres\:5432/g' src/main/resources/application.properties
RUN chmod +x ./mvnw
RUN ./mvnw package
RUN cp target/*.jar $APP_DIR/app.jar

# Remove build files
#RUN rm -rf $BUILD_DIR

# Running the project
WORKDIR $APP_DIR
CMD ["-jar", "app.jar", "||", "sleep", "999999999999999"]
ENTRYPOINT ["java"]
