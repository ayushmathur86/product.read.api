package com.adidas.products.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adidas.products.model.Product;
import com.adidas.products.repository.ProductRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/products")
@Api(value="adidasstore", description="Operations pertaining to products in Online Store")
public class ProductController {

    @Autowired
    ProductRepository repository;

    /**
     * Endpoint to retrieve all products from database with pagination.
     * Example usage: http://localhost:8080/products?page=0&size=10
     * 
     * @param pageable instance of Pageable for page and size.
     * @return Paged response of Product.
     */
    @ApiOperation(value = "View a list of available products",response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping (produces = "application/json")
    public Page<Product> findAllproducts(Pageable pageable) {
        return repository.findAll(pageable);
    }

    /**
     * Endpoint to retrieve Product with specified Id.
     * @param id the id of the product to be retrieved.
     * @return Product as ResponseEntity with header information.
     */
    @ApiOperation(value = "Search a product with an ID",response = Product.class)
    @GetMapping(value = "/product/{id}", produces = "application/json")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Optional<Product> entity = repository.findById(id);
        Product product = null;
        if (entity.isPresent()) {
            product = entity.get();
        }
        return new ResponseEntity<>(product, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * Endpoint to verify if the product is available in the database.
     * @param id the id of the product to verify.
     * @return true as ResponseEntity with header information if product is present.
     */
    @ApiOperation(value = "Check if a product with an ID exist in store",response = Boolean.class)
    @GetMapping(value = "/exists/{id}", produces = "application/json")
    public ResponseEntity<Boolean> ifProductAvailable(@PathVariable String id) {
        boolean isPresent = repository.existsById(id);
        return new ResponseEntity<>(isPresent, new HttpHeaders(), HttpStatus.OK);
    }
}
