package se.magnus.microservices.core.product.service;



import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeWithZoneIdSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import se.magnus.microservices.core.product.ProductService;
import se.magnus.microservices.util.exceptions.InvalidInputException;
import se.magnus.microservices.util.exceptions.NotFoundException;



@RestController
public class ProductServiceImpl implements ProductService {
    // --- AGREGAMOS ESTO PARA PROBAR ---
    @GetMapping("/ping")
    public String ping() {

        return "¡El controlador está vivo!";
    }

    @Override
    public Product getProduct(int productId) {
        return null;
    }
}




