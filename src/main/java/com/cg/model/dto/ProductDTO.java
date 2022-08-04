package com.cg.model.dto;

import com.cg.model.Category;
import com.cg.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class ProductDTO implements Validator {

    private Long id;

    @NotEmpty(message = "Product name cannot be empty!!")
    private String productName;

    private CategoryDTO category;

    @Min(value = 1, message = "Minimum quantity of one product")
    @Max(value = 999, message = "Quantity cannot exceed 999 products")
    private BigDecimal quantity;

    @Min(value = 10000, message = "Minimum amount 10,000VND")
    @Max(value = 999999999, message = "Amount does not exceed 999,999,999VND")
    private BigDecimal price;

    @NotEmpty(message = "Product details cannot be left blank!!")
    private String description;

    @NotEmpty(message = "Photos cannot be blank")
    private String image;

    private Date createdAt;

    private Date updatedAt;

    public ProductDTO(Long id, String productName, Category category, BigDecimal quantity, BigDecimal price, String description, String image, Date createdAt, Date updatedAt) {
        this.id = id;
        this.productName = productName;
        this.category = category.categoryDTO();
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.image = image;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public Product toProduct() {
        return new Product()
                .setId(id)
                .setProductName(productName)
                .setCategory(category.toCategory())
                .setQuantity(quantity)
                .setPrice(price)
                .setDescription(description)
                .setImage(image);
    }




    @Override
    public boolean supports(Class<?> aClass) {
        return ProductDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
