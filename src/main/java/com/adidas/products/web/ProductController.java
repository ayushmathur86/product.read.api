package com.adidas.products.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.adidas.products.model.Product;
import com.adidas.products.repository.ProductRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    /**
     * Endpoint to retrieve all products from database with pagination.
     * Example usage: http://localhost:8080/products?page=0&size=10
     *
     * @param pageable instance of Pageable for page and size.
     * @return Paged response of Product.
     */
    @Operation(summary = "View a list of available products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")
    })
    @GetMapping(produces = "application/json")
    public Page<Product> findAllProducts(Pageable pageable) {
        return repository.findAll(pageable);
    }

    /**
     * Endpoint to retrieve Product with specified Id.
     *
     * @param id the id of the product to be retrieved.
     * @return Product as ResponseEntity with header information.
     */
    @Operation(summary = "Search a product with an ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved product"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Optional<Product> entity = repository.findById(id);
        return entity
                .map(product -> ResponseEntity.ok(product))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    /**
     * Endpoint to verify if the product is available in the database.
     *
     * @param id the id of the product to verify.
     * @return true as ResponseEntity if product is present.
     */
    @Operation(summary = "Check if a product with an ID exists in the store")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully checked product existence")
    })
    @GetMapping(value = "/exists/{id}", produces = "application/json")
    public ResponseEntity<Boolean> ifProductAvailable(@PathVariable String id) {
        boolean isPresent = repository.existsById(id);
        return ResponseEntity.ok(isPresent);
    }

    /**
     * Create multiple new products.
     * Accepts a JSON array with full product details including metaData, pricingInformation, and productDescription.
     */


    @Operation(summary = "Create multiple products", description = "Add multiple products with metadata, pricing, and descriptions. IDs are auto-generated if not provided.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Products created successfully",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Product.class)))),
            @ApiResponse(responseCode = "409", description = "One or more products already exist with the given IDs")
    })
    @PostMapping(value = "/bulk", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> createProducts(@RequestBody List<Product> products) {
        products.forEach(p -> {
            if (p.getId() == null || p.getId().trim().isEmpty()) {
                p.setId(UUID.randomUUID().toString());
            }
        });

        List<String> existingIds = products.stream()
                .map(Product::getId)
                .filter(repository::existsById)
                .collect(Collectors.toList());

        if (!existingIds.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Products with these IDs already exist: " + existingIds);
        }

        List<Product> savedProducts = new ArrayList<>();
        repository.saveAll(products).forEach(savedProducts::add);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedProducts);
    }

}
