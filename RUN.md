# ▶️ Run Guide – Store API

Este documento explica cómo instalar, configurar y ejecutar el proyecto **Store API** en tu máquina local.  

---

## 🔹 1. Requisitos previos

Asegúrate de tener instalado:

- **Java 17+** → [Descargar](https://adoptium.net/)  
- **Maven 3.9+** → [Instalar](https://maven.apache.org/install.html)  
- **Git** → [Descargar](https://git-scm.com/)  
- (Opcional) **Docsify** para la documentación → `npm install -g docsify-cli`  

---

## 🔹 2. Clonar el repositorio

```bash
git clone https://github.com/anlopez95/Store_challenge.git
```

---

## 🔹 3. Configuración

1. **Archivos de datos locales**  
   El proyecto usa archivos JSON como persistencia:  

   - `productos.json`  
   - `vendedores.json`  

   Deben estar en la raíz del proyecto. Si no existen, se crearán automáticamente al guardar datos.  

2. **Configuración de puerto**  
   En `src/main/resources/application.properties`, define el puerto de ejecución:  

   ```properties
   server.port=8093
   storage.type=json
   ```

---

## 🔹 4. Compilación

Compila el proyecto con Maven:  

```bash
mvn clean install
```

---

## 🔹 5. Ejecución

Inicia la aplicación:  

```bash
mvn spring-boot:run
```

O bien ejecuta el JAR generado:  

```bash
java -jar target/Store-0.0.2.jar
```

---

## 🔹 6. Endpoints principales

Una vez iniciado, accede a los endpoints:  

- **Productos**  
  - `GET /api/productos` → lista todos los productos.  
  - `GET /api/productos/{id}` → obtiene un producto por id.  
  - `POST /api/productos` → crea un producto.  
  - `PUT /api/productos/{id}` → actualiza un producto.  
  - `DELETE /api/productos/{id}` → elimina un producto.  

- **Vendedores**  
  - `GET /api/vendedores` → lista todos los vendedores.  
  - `GET /api/vendedores/{id}` → obtiene un vendedor por id.  
  - `POST /api/vendedores` → crea un vendedor.  
  - `PUT /api/vendedores/{id}` → actualiza un vendedor.  
  - `DELETE /api/vendedores/{id}` → elimina un vendedor y sus productos asociados.  

---

## 🔹 7. Swagger API Docs

Swagger está disponible en:  

👉 [http://localhost:8093/swagger-ui.html](http://localhost:8093/swagger-ui.html)  

---

## 🔹 8. Pruebas

Ejecuta todas las pruebas unitarias con:  

```bash
mvn test
```

---

## 🔹 9. Documentación extra

La documentación extendida está en la carpeta `docs/` y se puede visualizar con Docsify:  

```bash
docsify serve docs
```

Luego abre en el navegador:  

👉 [http://localhost:3000](http://localhost:3000)  

---

✅ Con esto tu proyecto **Store API** quedará listo para ejecutarse localmente.  
