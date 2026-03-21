package se.magnus.microservices.composite.product;

public record RecommendationSummary(
    int recommendationId,
    String author,
    int rate) {
}
