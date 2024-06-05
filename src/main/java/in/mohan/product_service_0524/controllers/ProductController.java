package in.mohan.product_service_0524.controllers;

import in.mohan.product_service_0524.dtos.ProductRequestDto;
import in.mohan.product_service_0524.dtos.ProductResponseDto;
import in.mohan.product_service_0524.models.Product;
import in.mohan.product_service_0524.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products/{id}")
    public ProductResponseDto getProductDetails (@PathVariable("id") int productId){
        return productService.getSingleProduct(productId);
    }

    @PostMapping("/products")
    public ProductResponseDto createNewProduct(@RequestBody ProductRequestDto productRequestDto) {
        return productService.addProduct(
                productRequestDto.getTitle(),
                productRequestDto.getDescription(),
                productRequestDto.getImageUrl(),
                productRequestDto.getCategory(),
                productRequestDto.getPrice()
        );

    }



}
