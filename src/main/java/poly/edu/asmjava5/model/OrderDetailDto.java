package poly.edu.asmjava5.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderDetailDto implements Serializable {

    private int orderDetailId;

    private int orderId;

    private Long productId;

    private int quantity;

    private double unitPrice;
}
