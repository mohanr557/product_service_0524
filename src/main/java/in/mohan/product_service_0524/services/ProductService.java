package in.mohan.product_service_0524.services;

import in.mohan.product_service_0524.dtos.FakeStoreDto;
import in.mohan.product_service_0524.dtos.ProductResponseDto;
import in.mohan.product_service_0524.models.Product;

public interface ProductService {

    public ProductResponseDto getSingleProduct(int productId);

    public ProductResponseDto addProduct(
            String title,
            String description,
            String imageUrl,
            String category,
            double price);
}
