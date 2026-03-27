package se.magnus.microservices.api.core.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;
import se.magnus.microservices.util.exceptions.InvalidInputException;

public interface ProductService {

    // Fíjate que le ponemos explícitamente el nombre a la variable y a la ruta
    @GetMapping(
            value = "/product/{productId}",
            produces = "application/json"
    )
    Mono<Product> getProduct(@PathVariable("productId") int productId) throws InvalidInputException;
}
