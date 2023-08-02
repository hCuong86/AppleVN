package poly.edu.asmjava5.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer implements Serializable {

    private int customerId;

    private String name;

    private String email;

    private String password;

    private String phone;

    private Date registererdDate;

    private short status;
}
