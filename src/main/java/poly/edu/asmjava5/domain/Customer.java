package poly.edu.asmjava5.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customers")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    @Column(columnDefinition = "nvarchar(50) not null")
    private String name;
    @Column(columnDefinition = "nvarchar(50) not null")
    private String email;
    @Column(length = 20, nullable = false)
    private String password;
    @Column(length = 15)
    private String phone;
    @Temporal(TemporalType.DATE)
    private Date registererdDate;
    @Column(nullable = false)
    private short status;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Order> orders;
}
