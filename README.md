# Tu CV Spring Boot

Este proyecto es una aplicación web desarrollada con Spring Boot para gestionar y mostrar información de un currículum vitae (CV).

## Características
- Visualización de información personal
- Gestión de habilidades (skills)
- Interfaz web con plantillas HTML
- API REST para el CV

## Estructura del proyecto
- `src/main/java/com/tonovarela/tu_cv_spring_boot/` - Código fuente principal
- `src/main/resources/templates/` - Plantillas HTML
- `src/main/resources/static/` - Archivos estáticos (CSS)
- `src/test/java/` - Pruebas unitarias

## Requisitos
- Java 17 o superior
- Maven 3.6+

## Configuración
1. Asegúrate de tener la variable de entorno `JAVA_HOME` configurada correctamente.
2. Clona el repositorio:
   ```sh
   git clone https://github.com/tu-usuario/tu-cv-spring-boot.git
   cd tu-cv-spring-boot
   ```
3. Compila el proyecto:
   ```sh
   ./mvnw clean install
   ```
4. Ejecuta la aplicación:
   ```sh
   ./mvnw spring-boot:run
   ```

## Uso
Accede a la aplicación en [http://localhost:8080](http://localhost:8080) después de iniciar el servidor.

## Personalización
Puedes modificar los archivos en `src/main/resources/templates/` y `src/main/resources/static/css/` para personalizar la interfaz.

## Licencia
Este proyecto está bajo la licencia MIT.

