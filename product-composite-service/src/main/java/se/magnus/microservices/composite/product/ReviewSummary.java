package se.magnus.microservices.composite.product;

public record ReviewSummary(
    int reviewId,
    String author,
    String subject) {
}
