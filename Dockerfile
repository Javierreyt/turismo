# Usa una imagen base de OpenJDK (ajusta la versión según tu JDK)
FROM openjdk:21-jdk

# Define el argumento JAR_FILE para seleccionar el archivo jar generado
ARG JAR_FILE=target/*.jar

# Copia el archivo jar en la imagen y lo renombra a app.jar
COPY ${JAR_FILE} app.jar

# Expone el puerto en el que se ejecutará la aplicación (por defecto 8080)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]
