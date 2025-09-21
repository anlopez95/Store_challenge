# 📚 Prompts

A continuación se muestra una lista de los promts empleados para las actividades de desarrollo de la aplicación, pues se emplearon IA's como ChatGPT, Copilot y Gemini para el desarrollo de esta aplicación.

---

- Me gustaria conocer en terminos de rendimiento cual de estos dos me permite un acceso más rapido a la infomacion, 
asi como cual me permite realizar tareas tipo CRUD de manera mucho mas agil entre el archivo json o el csv.

- Me ayudarias a generar entonces un .json con almenos 50 productos para usar como insumo en las consultas, entre electrodomesticos, 
dispositivos tecnologicos, ropa, accesorios y algunos otros que gustes, siguiendo los lineamientos de : public class ProductoDTO {
	
	private String id;
    private String titulo;
    private String descripcion;
    private PrecioDTO precio;
    private InventarioDTO inventario;
    private List<ImagenDTO> imagenes;
    private VendedorDTO vendedor;
    private List<ReseñaDTO> reseñas;
    private List<PreguntaDTO> preguntas;
} donde los otros DTOs son: public class PrecioDTO {
	private String moneda;
    private double monto;
},public class InventarioDTO {
	
	private int disponible;
    private int vendidos;

},public class ImagenDTO {
	
	private String url;
    private String textoAlternativo;

},public class VendedorDTO {
	
	private String id;
    private String nombre;
    private double reputacion;

},public class ReseñaDTO {
	
	private String usuarioId;
    private int calificacion;
    private String comentario;

},public class PreguntaDTO {
	
	private String usuarioId;
    private String pregunta;
    private String respuesta;

}	

- recuerdas el archivo productos.json que generaste, podrias sacar la info de los vendedores para dejarlo aparte en otro .json de solo vendedores

- @Autowired vs @RequiredArgsConstructor para manejo de dependencias, cual es más eficiente.


- Podrias generar pruebas unitarias con Junit+mockito para el controller y service, teniendo en cuenta que estos on los métodos del controller : 

	@GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> getProductById(@PathVariable String id) {
    	return ResponseEntity.ok(productoService.getProductById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> getAllProducts() {
        return ResponseEntity.ok(productoService.getAllProducts());
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> createProduct(@RequestBody ProductoDTO producto) throws IOException {
        return ResponseEntity.ok(productoService.createOrUpdateProduct(producto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> updateProduct(
            @PathVariable String id,
            @RequestBody ProductoDTO producto
    ) {
        producto.setId(id);
        return ResponseEntity.ok(productoService.createOrUpdateProduct(producto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) throws IOException {
    	productoService.deleteProduct(id);
        return ResponseEntity.ok("Eliminado producto " + id + " correctamente");
    }, 
	
	y estos los del service: 
	
	public ProductoDTO getProductById(String id) {
    	 ProductoDTO producto = productRepository.findById(id);
         if (producto == null) {
             throw new ProductNotFoundException("El producto con id " + id + " no existe");
         }
         return producto;
    }

    public List<ProductoDTO> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductoDTO createOrUpdateProduct(ProductoDTO producto) {
    	try {
            productRepository.save(producto);
            return producto;
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar el producto", e);
        }
    }
    
    public void deleteProduct(String id) {
    	ProductoDTO producto = productRepository.findById(id);
        if (producto == null) {
            throw new ProductNotFoundException("El producto con id " + id + " no existe");
        }
        try {
            productRepository.delete(id);
        } catch (IOException e) {
            throw new RuntimeException("Error al eliminar el producto", e);
        }
    }


- Basados en las interfaces hay alguna recomendacion para hacer estas aun más escalables de cara a que exista la posibilidad de usar BD en vez de 
arschivos .json

- ven es buena idea dejar try catch en los repositorys , no deberia manejar esa logica en los servicios, y en ese orden de ideas no deberia modificar tambien los servicios?

- Ayudame con algo, quiero usar swagger para documentar, tengo esto en mi pom:<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.5.5</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.meli</groupId>
	<artifactId>Store</artifactId>
	<version>0.0.2</version>
	<name>Store</name>
	<description>Backend para busqueda de items</description>
	<url/>
	<licenses>
		<license/>
	</licenses>
	<developers>
		<developer/>
	</developers>
	<scm>
		<connection/>
		<developerConnection/>
		<tag/>
		<url/>
	</scm>
	<properties>
		<java.version>17</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
		    <groupId>org.junit.jupiter</groupId>
		    <artifactId>junit-jupiter</artifactId>
		    <scope>test</scope>
		</dependency>
		<dependency>
		    <groupId>org.mockito</groupId>
		    <artifactId>mockito-core</artifactId>
		    <version>5.12.0</version>
		    <scope>test</scope>
		</dependency>
		<dependency>
		    <groupId>org.mockito</groupId>
		    <artifactId>mockito-junit-jupiter</artifactId>
		    <version>5.12.0</version>
		    <scope>test</scope>
		</dependency>
		<dependency>
		    <groupId>org.springdoc</groupId>
		    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
		    <version>2.2.0</version>
		</dependency>

	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<configuration>
					<annotationProcessorPaths>
						<path>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</path>
					</annotationProcessorPaths>
				</configuration>
			</plugin>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
			<plugin>
			    <groupId>org.apache.maven.plugins</groupId>
			    <artifactId>maven-surefire-plugin</artifactId>
			    <version>3.0.0</version>
			</plugin>
		</plugins>
	</build>

</project> , y al intentar hacer uso de la herramienta me sale este error: java.lang.NoSuchMethodError: 'void org.springframework.web.method.ControllerAdviceBean.<init>(java.lang.Object)'
	at org.springdoc.core.service.GenericResponseService.lambda$getGenericMapResponse$8(GenericResponseService.java:700) ~[springdoc-openapi-starter-common-2.2.0.jar:2.2.0]
	at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:196) ~[na:na]
	at java.base/java.util.Spliterators$ArraySpliterator.forEachRemaining(Spliterators.java:1024) ~[na:na]......

- Me ayudarias con algo más, quissiera para documentar implementar esto: docsify spring boot para readme y Plant UML spring boot (renderizar diagramas en docsify), me ayudarias ?

---

Estos son algunos de los prompts que emplee para apoyarme en el desarrollo de esta API, buscando usar la IA como un asistente de generación base y revisor, de igual forma, la use como solucionador de inquietudes a problemas de versiones que tuve en la ejecución del desarrollo de la prueba. 