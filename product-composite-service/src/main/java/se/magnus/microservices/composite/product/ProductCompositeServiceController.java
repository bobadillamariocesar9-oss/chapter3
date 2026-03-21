package se.magnus.microservices.composite.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import java.util.List;

@RestController
public class ProductCompositeServiceController {

    @GetMapping(value = "/product-composite/{productId}", produces = "application/json")
    public Mono<ProductAggregate> getProduct(@PathVariable int productId) {

        var recommendations = List.of(
                new RecommendationSummary(1, "Author 1", 5),
                new RecommendationSummary(2, "Author 2", 4),
                new RecommendationSummary(3, "Author 3", 5)
        );

        var reviews = List.of(
                new ReviewSummary(1, "Author 1", "Excellent architecture!"),
                new ReviewSummary(2, "Author 2", "Good use of Spring WebFlux"),
                new ReviewSummary(3, "Author 3", "I love it!")
        );

        var productAggregate = new ProductAggregate(
                productId,
                "Test Product",
                120,
                recommendations,
                reviews,
                "mock-address"
        );

        return Mono.just(productAggregate);
    }
}
