package in.mohan.product_service_0524.controllers;

import in.mohan.product_service_0524.dtos.ErrorDto;
import in.mohan.product_service_0524.dtos.ProductRequestDto;
import in.mohan.product_service_0524.dtos.ProductResponseDto;
import in.mohan.product_service_0524.exceptions.ProductNotFoundException;
import in.mohan.product_service_0524.models.Product;
import in.mohan.product_service_0524.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;
    private ModelMapper modelMapper;

    public ProductController(ProductService productService,
                             ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    // e.g: localhost:8080/products/5
    @GetMapping("/products/{id}")
    public ProductResponseDto getProductDetails (@PathVariable("id") int productId)
    throws ProductNotFoundException {
        Product product =  productService.getSingleProduct(productId);
        //return modelMapper.map(product, ProductResponseDto.class);
        return convertToProductResponseDto(product);
    }

    @GetMapping("/products")
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for (Product product : products) {
            productResponseDtos.add(convertToProductResponseDto(product));
        }
        return productResponseDtos;
    }


    @PostMapping("/products")
    public ResponseEntity <ProductResponseDto> createNewProduct(@RequestBody ProductRequestDto productRequestDto) {
        Product product =  productService.addProduct(
                productRequestDto.getTitle(),
                productRequestDto.getDescription(),
                productRequestDto.getImageUrl(),
                productRequestDto.getCategory(),
                productRequestDto.getPrice()
        );
        // return convertToProductResponseDto(product);
        ProductResponseDto productResponseDto = convertToProductResponseDto(product);
        return new ResponseEntity<>(productResponseDto, HttpStatus.CREATED);
    }

    private ProductResponseDto convertToProductResponseDto(Product product) {
        String categoryTitle = product.getCategory().getTitle();
        ProductResponseDto productResponseDto = modelMapper.map(product, ProductResponseDto.class);
        productResponseDto.setCategory(categoryTitle);
        return productResponseDto;
    }

    // add exception handler

//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<ErrorDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
//        ErrorDto errorDto = new ErrorDto();
//        errorDto.setMessage(productNotFoundException.getMessage());
//        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
//    }


}
