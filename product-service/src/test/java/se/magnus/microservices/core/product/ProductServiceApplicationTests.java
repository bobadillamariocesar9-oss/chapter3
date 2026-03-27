package se.magnus.microservices.core.product;

import org.springframework.web.bind.annotation.PathVariable;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import se.magnus.microservices.api.core.product.Product;
import se.magnus.microservices.util.exceptions.InvalidInputException;
import se.magnus.microservices.util.exceptions.NotFoundException;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.MediaType.APPLICATION_JSON;

// Le decimos a Spring que levante el servidor de verdad, pero en un puerto aleatorio para que no choque con el 7001
@SpringBootTest(webEnvironment = RANDOM_PORT)
class ProductServiceApplicationTests {

    @Autowired
    private WebTestClient client; // Nuestro "Postman" automatizado

    @Test
    void getProductById() {
        int productId = 1; // Un ID normal

        client.get()
                .uri("/product/" + productId)
                .accept(APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk() // Esperamos un 200 OK
                .expectHeader().contentType(APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.productId").isEqualTo(productId); // Verificamos que el JSON traiga el ID correcto
    }

    @Test
    void getProductNotFound() {
        int productId = 13; // El ID que programamos para fallar

        client.get()
                .uri("/product/" + productId)
                .accept(APPLICATION_JSON)
                .exchange()
                .expectStatus().isNotFound() // Esperamos un 404
                .expectHeader().contentType(APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.path").isEqualTo("/product/" + productId)
                .jsonPath("$.message").isEqualTo("No se encontró ningún producto para el ID: " + productId);
    }

    @Test
    public Mono<Product> getProduct(@PathVariable("productId") int productId) {

        // ¡Este bloque es el que hace pasar la prueba!
        if (productId < 1) {
            throw new InvalidInputException("ID inválido: " + productId);
        }

        if (productId == 13) {
            throw new NotFoundException("No se encontró ningún producto para el ID: " + productId);
        }

        return Mono.just(new Product(productId, "Nombre de prueba: " + productId, 123));
    }
}
