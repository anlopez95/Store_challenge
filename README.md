# 📚 Documentación Store API

Bienvenido a la documentación del backend de **Store**, una API inspirada en MercadoLibre para gestionar productos y vendedores, persistiendo información en archivos JSON.

---

## 1️⃣ Introducción / Overview
- API REST desarrollada con **Spring Boot 3.3.4**.  
- Arquitectura basada en **principios SOLID** y **Clean Code**.  
- Persistencia inicial en **archivos JSON**, preparada para escalar a una base de datos en el futuro.  
- Documentación con **Swagger (OpenAPI)** y **Docsify + PlantUML**.

---

## 2️⃣ Guía de instalación y ejecución

### Requisitos
- **Java 17**
- **Maven 3.9+**
- **Node.js** (opcional, si deseas servir la documentación con Docsify)

### Levantar la API
```bash
mvn spring-boot:run
```
👉 La API se levantará en: [http://localhost:8093](http://localhost:8093)

### Servir la documentación
```bash
npx docsify serve docs
```
👉 Accede en: [http://localhost:3000](http://localhost:3000)

---

## 3️⃣ Estructura del proyecto 

```
/src/main/java/com/meli/Store
  /controller     → Controladores REST (Productos y Vendedores)
  /business       → Servicios (lógica de negocio)
  /repository     → Interfaces e implementaciones JSON
  /data           → DTOs de producto, vendedor e internos
  /exceptions     → Excepciones personalizadas
/docs             → Documentación (Docsify + PlantUML)
/productos.json   → Datos de productos
/vendedores.json  → Datos de vendedores
```

---

## 4️⃣ Endpoints principales

- `/api/productos`
- `/api/vendedores`

👉 Documentados automáticamente en Swagger:  
[http://localhost:8093/swagger-ui.html](http://localhost:8093/swagger-ui.html)

---

## 5️⃣ Diagrama de Arquitectura

Diagrama de clases simplificado de la arquitectura de Store:

![Diagrama arquitectura](https://www.plantuml.com/plantuml/svg/TPDDJWCn38Nt8-KELbTbqHu1TQ2RTaD54NihuwA8D1aI1ma1TsUKJkUdCLk_vy_sYxA9Z87JsQgA3Lk2EdmamwGv1OHepgqr9wEnGJYo3wGgLRMet_6DO54VTh1yz8w3jvR2tGA-LGMWBSO8X-2Rf7cKH-cLN4ED3rFjTqP-ID4uwgpB8uLFeqbazre97eGvTOkCK6kTmS_K-cYwcxwkREEOmWarmQuVC7fkzEkWkU6on3vw9_QFijHUhYgTxBSlJ-MzkPW1HUgmMjqNUPKFa6r5V0ElhsIN5CvDvyKdNQagCHvOhtzaiXnNxvSdJABAY_pp89Fm1fiCt7JL_4N-0000)

---

## 6️⃣ Diagramas de Secuencia

### Productos
- [GET /api/productos/{id}](https://www.plantuml.com/plantuml/svg/TP3F2i8m3CRlXRv3ZegC3OyxoF0FCZnCT2ymrYY5seuk4uRuxXRjdBBjbdnyloHVafeAIyrDSKQI5C9-bqDOL3Aih15DIQOE7r8yEUEiS9s5ZPAe2Jdp1GGhE7wy6wF96gNGGZmzQ6Zk9vpHtcM93hyYUMtTfc8cnVnBTYQ7fLuwOMLgwSvh7NgHMlJGY2KOM-W5iyspuQQ9Z6FCRow7TL-AOHb5a1rWyKybgCNx_Iy0)  
- [GET /api/productos](https://www.plantuml.com/plantuml/svg/TP5D2u9048Rl2_iVvbY47tIK4CCYei0eRz51T8g5pPNTCUZVjvMMeDw6TzvdFYD3cQRwBZaZGH9Xiqx1oohXLLeLTKxASCPPPWCDiHHO4dBM1E24SFZQObMILbAYXc2mHj_tXq-e7o97IzwGbb8sifbCVrnhiT2saOvOAIFiN4yBNaLPMF9D3EITeLvxOMZHg6gL9c6_sSX-usHtFGktTmfWxlkGx606vmxdkkw5imZBulE05m00)  
- [POST /api/productos](https://www.plantuml.com/plantuml/svg/TP512eCm44NtWTnXbfOYIfT2Ys0tfOj8jGT8pIm2gGb95BnzGnknHRlAaFp_9d-cT9vRFpmL9LvwXL2pfeMC6vaPgyNGUUqeeOI7maAb9FOUAOa5f2UeFx9AzzvgfT12iGM1vA75T8ngVMxPZfArTm4sQ4VPOQ1r5hb7Pkz6X3C-9pDvmSoEmBZ4gniQxMJu-XGuZe_uRTiGfLlzHot5kic_w4l0pNp1DW-lW4EU0xl2_jTLOY_U6ta1)  
- [PUT /api/productos/{id}](https://www.plantuml.com/plantuml/svg/TP7V2e8m58Vl1tk7Ssb4A5qAXM0tqOLI-W3BdOl1ScERWaJltgY9XNgrV-VxpdvRPXqphdj8Ifnm4g6iAuYP5h4sYdUDKpP-2lwYX1BcLmPoAR1rI4cOmEu8vRSsLwqpIaeqaAw98BehFXm2eKvLiQ5apa_I6vfUDEYDZK7ci32rvduCnz6edpGZuHtdi7L5hQpmrn-ynx8UVx65ejrI_ru9Fc-o5dyAk9ZFO-C3fh1F4YWkiFsdCcpvvsVU)  
- [DELETE /api/productos/{id}](https://www.plantuml.com/plantuml/svg/dP9HIyCm4CVV2_qEnvuK6Isofpt8SAim52UwBr2Q4m-oN4ckSqFyxbxNrYfMsSn3I2x_t-L_byo2v5wgZOqZ8R48Y-mkMsUGv2KbfMTJ5S8XUIFp7aTnbElEmzmIEi4uQXSmleA7HZjd9vwjHG_JFtFzrFT9dj1lgK3DOD2YO1i-8tF-2NOQfPPjw15B3gG6zqe-apFN-wLfeDmAT0u0TnHgzw1ZW1qF6Ma3l5Yl6l186qq1ZObJxjiocU6BVkdrwlQR_6jVbUWUQWgNQQfQk81HPcb3BZVSTwP-cb4SeGtO1zt_EkOgQq-gG5uyltOdzomtN3cJxGeiXTWTLzqadO2YS62ra7gQwNpuu1y0)  

### Vendedores
- [GET /api/vendedores/{id}](https://www.plantuml.com/plantuml/svg/VP7D2i8m48JlWRp37XKfBHvxa68LAHuAMhoNPfM5c9Gq5ehuxWPfQ8NeBHdcc_tBEbiR-xXBpYnPYN3OLn3NBSKzAe526-pY9uaNPvpLZTK6saceB78sFY3Qm6KqvrfPewL40-cVg81z5d96qrE3Bk66relReH0B4ii9zZP75buxOQixSbqEZhwI4XCMyaJ1gbxPLMMWsgzfWzHyG0VwZQMmJX8eZx3wnZBt-TpY3G00)  
- [GET /api/vendedores](https://www.plantuml.com/plantuml/svg/VT4z2y8m40RWFP3_SACY_S2nIAbK4L4eQEaY3gKz9H2Jafu5_xrHMkqGtSBnFhdS9McfD7I_ISv8a4JOh7C8oaO47QeQQssmvOopiY9j89K25I5d_G6y68e-bsf5Hak91YBtBOxao1_HTA92Ywz8IocBZvnCltP8MRWTQWTiT2li-nuMNuIghNuPLy1pTjoBbXP3UPLdiQFXhr7_sF6WbWzBYs0UXf3jO0Qd4VHz_ynPOWllxtW2)  
- [POST /api/vendedores](https://www.plantuml.com/plantuml/svg/TP4_2y8m4CNtGBx3ZHMH5iU2KgYBE4HiTO_D3O7Ob4iCzDiRf84ASSgVU--NUvV6UKd-_JASUUqDmbLqFPHoqcN0KQ6oX8uppkJWBK5hD8uUELisi3l2Oz6rTlHaZK62Eek1ucdLV4ZwKoysd6NSAsQ75FI04JWGIe-2xfEAQweNYRuY9K_4dDFT3IVhT4mmHvIJ0TV6d6gNRI9OhJ8F_Hl2Aca-Q3IcGTQmhoeG5zZ-sffu-7xF1m00)  
- [PUT /api/vendedores/{id}](https://www.plantuml.com/plantuml/svg/TP712i8m38RlXRv3ZXCP6nu7oc1UnCD4D-zrpQ5Grz7MmX3VtI8hLEXERPFyN_AdjR5CszTJKcA5bGYNleE2JQ9mE7BaIgCfte9_AA643LPfQAJ0qI8bomNo0zoNuaQDLYifKKErYeBieVYy3vfZrsueIH0YxWsr4mDwwA2HMMnrFt5_XdmMMaIaeF6OKuXTSL96U1UpHndcC1QcglBa44u9dcYqjeZ8QTge5uPbLh0hIsZFiFsNrVxn-wOl)  
- [DELETE /api/vendedores/{id}](https://www.plantuml.com/plantuml/svg/dLJ1Qi904Bq7yW-39wNOIF4aHMmr1QdKqahl8Jkb0-jEsDrOfVJVkp5PenX5cyCIPjwRzsPss96nYRRvKeQ19IiH9l4iNiGG9Hb5ArG21MiqqG-9tp08WoIrh64i2PN5CAX-e3k4ZmeyPcKrIuaQ1kUhDJ3swhoZNb6AheX0YHPzl4sYKtCzoX6dFlQ66HjoFZUE_4bAF6wcegGbqeBt0RWcKpG1xciYTnlT-CXaCIy6Kf2RpBng5dbgZxmyIDdkL9h7c6R9cVDvNu7PwGwzi6JE8AiI1XB3AIM2JPcznbevuxQlTRkTbYzoiT4LaoXfBdLkEerNLNdOILz-9wNk2RbJkpb_FYJihw7Z-DKUm5slvy1m0wrOqfAKct2zHCKgmmPCRkgBQ8K1IeCrIF4_bqtbKbxPbltI_BrBlR1zubo9U9rYPedLXJttUtrmNDYINJl5CNBdzgNu0m00)  

---

## 7️⃣ Manejo de errores

- `ProductNotFoundException` - cuando un producto no existe.  
- `VendedorNotFoundException` - cuando un vendedor no existe.  
- Respuesta estándar:
```json
{
  "error": "El producto con id p99 no existe"
}
```

---

## 8️⃣ Pruebas

- Implementadas con **JUnit 5 + Mockito**.  
- Cobertura de `Service` y `Controller`.  

Ejemplo:
```java
@Test
void getProductById_existente_retornaProducto() {
    ProductoDTO producto = new ProductoDTO();
    producto.setId("p1");
    when(productRepository.findById("p1")).thenReturn(producto);

    ProductoDTO result = productService.getProductById("p1");

    assertNotNull(result);
    assertEquals("p1", result.getId());
}
```

Ejecutar:
```bash
mvn test
```
---

## 🏗️ Decisiones de Arquitectura

1. Patrón en capas (Controller → Service → Repository) 

    - Es una arquitectura clara y modular que permite separar responsabilidades. No obstante puede ser adaptada a arquitectura hexagonal (En caso de usar BD por ejemplo).

2. Persistencia en archivos JSON 

    - Los repositorios implementan interfaces que permiten persistencia en archivos .json como precondición al challenge, no obstante pueden ser implementados en una integracion con base de datos.

3. Principios SOLID aplicados

    - Se veló por la aplicación de principios SOLID como responsabilidad Única, Inversión de Dependencias y Abierto/Cerrado en el código implementado.

4. Manejo de excepciones

    - Se crearon excepciones personalizadas y la posibilidad de detener un @ControllerAdvice.

5. Documentación

    - Se empleo Swagger/OpenAPI junto a Docsify/PlantUML para poder generar la documentación.

6. Testing

    - Se realizaron las pruebas unitarias con JUnit + Mockito.

---

## 🛠️ Technology Stack – Backend

El backend de **Store API** está desarrollado con **Java 17** y **Spring Boot 3.3.4**, a continuación se listan algunas de las razones por las cuales se emplearon estas tecnologías a nivel de backend para dar cumplimiento al challenge propuesto.

### 🔹 Razones para elegir **Java**
- **Madurez y robustez**: Java es un lenguaje probado en producción durante más de dos décadas, lo que lo hace bastante fiable.  
- **Portabilidad**: Java funciona en cualquier sistema gracias a la JVM.  
- **Amplio ecosistema**: Existe una gran cantidad de librerías y frameworks para desarrollo empresarial.  
- **Orientado a objetos**: Al ser POO facilita aplicar patrones de diseño y principios SOLID.  
- **Soporte a largo plazo (LTS)**: Mantiene versiones estables y mantenidas por Oracle y la comunidad.  

### 🔹 Razones para elegir **Spring Boot**
- **Productividad**: Permite crear aplicaciones listas para producción con mínima configuración o acotando las mismas.  
- **Inyección de dependencias (IoC)**: Permite mantener un código desacoplado y testeable.  
- **Spring Data JPA / Flexibilidad de repositorios**: En este momento usando JSON como persistencia (Precondicion), pero escalable fácilmente a BD relacional o NoSQL sin cambiar la lógica de negocio.  
- **Gestión de dependencias**: Maven y el ecosistema Spring simplifican la integración.  
- **Documentación integrada**: Permite integración fluida con Swagger/OpenAPI.

### 🔹 Otros componentes del stack empleados en el codigo
- **Lombok** → Reduce el boilerplate en DTOs y entidades.  
- **JUnit 5 + Mockito** → Usado para generar pruebas unitarias.  
- **Springdoc OpenAPI** → Permite realizar la documentación automática de endpoints.  
- **Docsify + PlantUML** → Genera documentación viva, versionada y visual (que es más atractivo).  

Este grupo de tecnologias fue elegido para garantizar **escalabilidad, mantenibilidad y productividad**, ademas de ser el compendio tecnologico con el que más he tenido contacto en mi vida profesional, por lo cual lo considero idoneo para la realización de este challenge.

---

## 🤖 IA y Herramientas Modernas en el Desarrollo

Referente a las IA y las diferentes herramientas de desarrollo para mejorar la eficiencia, existen diversos puntos de vista u opiniones. No obstante, es innegable el apoyo que estas herramientas brindan al desarrollo y mejora del software.

Por ejemplo, para el desarrollo de esta API se utilizaron asistentes de IA (ChatGPT, Copilot, Gemini) para asegurar el código y barrerlo en busca de posibles violaciones de los principios SOLID, así como para reducir los errores de lógica. Adicionalmente, herramientas de documentación como Swagger/OpenAPI y Docsify + PlantUML permiten cubrir la generación de documentación relacionada con la API.

Ciertamente, en términos de eficiencia y productividad, las IA permiten mejorar estos puntos. Ahorran tiempo de codificación manual, generan código que en teoría es funcional, apoyan la revisión de errores al otorgar información relevante y son una fuente de información para resolver dudas o una guía de implementación en algunos casos.

No obstante, el juicio profesional, la pericia ingenieril, el conocimiento técnico y la experiencia en campo son los factores diferenciales que permiten sacar el máximo provecho a estas herramientas. Las IA deben verse como un apoyo y no como un generador de argumentos inequívocos, ya que también cometen errores. Por eso, siempre se debe revisar su trabajo para cumplir con nuestros objetivos y estándares, utilizando la tecnología disponible para que nuestro trabajo no solo sea más rápido, sino también más eficiente y conscientemente más robusto.
