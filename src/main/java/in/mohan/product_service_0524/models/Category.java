package in.mohan.product_service_0524.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String title;
    private String description;
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    List<Product> products;
}
