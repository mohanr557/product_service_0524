package in.mohan.product_service_0524.repositories.projections;

import in.mohan.product_service_0524.models.Category;

import java.math.BigDecimal;

public interface ProductProjection {
    Long getId();
    String getTitle();
    String getDescription();
    BigDecimal getPrice();
    Category getCategory();
    String getImageUrl();
}
