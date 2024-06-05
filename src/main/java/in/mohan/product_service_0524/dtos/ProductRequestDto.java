package in.mohan.product_service_0524.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {
    //private int id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String category;
}
