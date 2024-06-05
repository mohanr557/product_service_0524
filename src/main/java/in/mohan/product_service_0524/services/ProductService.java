package in.mohan.product_service_0524.services;

import in.mohan.product_service_0524.dtos.FakeStoreDto;
import in.mohan.product_service_0524.dtos.ProductResponseDto;
import in.mohan.product_service_0524.exceptions.ProductNotFoundException;
import in.mohan.product_service_0524.models.Product;

import java.util.List;

public interface ProductService {

    public Product getSingleProduct(int productId) throws ProductNotFoundException;
    public List<Product> getAllProducts();
    public Product addProduct(
            String title,
            String description,
            String imageUrl,
            String category,
            double price);
}
