package poly.edu.asmjava5.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto implements Serializable {

    private Long categoryId;
    @NotEmpty
    @Length(min = 5)
    private String name;

    private Boolean isEdit = false;
}
