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
public class AccountDto implements Serializable {

    @NotEmpty
    @Length(min = 6)
    private String username;
    @NotEmpty
    @Length(min = 6)
    private String password;

    private Boolean isEdit = false;

 
    

    
}
