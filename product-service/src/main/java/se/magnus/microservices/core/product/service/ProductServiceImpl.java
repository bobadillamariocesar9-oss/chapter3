package se.magnus.microservices.core.product.service;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import se.magnus.microservices.util.exceptions.InvalidInputException;
import se.magnus.microservices.util.exceptions.NotFoundException;
import se.magnus.microservices.api.core.product.Product;
import se.magnus.microservices.api.core.product.ProductService;

@RestController
public class ProductServiceImpl implements ProductService {
    // --- AGREGAMOS ESTO PARA PROBAR ---
    @GetMapping("/ping")
    public String ping() {
        return "¡El controlador está vivo!";
    }


    @Override
    public Mono<Product> getProduct(@PathVariable("productId") int productId) {

        if (productId < 1) {
            try {
                throw new InvalidInputException("ID inválido: " + productId);
            } catch (InvalidInputException e) {
                throw new RuntimeException(e);
            }
        }

        if (productId == 13) {
            try {
                throw new NotFoundException("No se encontró ningún producto para el ID: " + productId);
            } catch (NotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        return Mono.just(new Product(productId, "Nombre de prueba: " + productId, 123));
    }
}
