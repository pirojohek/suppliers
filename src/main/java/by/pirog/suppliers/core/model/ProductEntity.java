package by.pirog.suppliers.core.model;

import by.pirog.suppliers.core.enums.ProductType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(schema = "storage", name = "t_product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private Long id;

    @Column(name = "c_name")
    private String name;

    @Column(name = "c_type")
    @Enumerated(EnumType.STRING)
    private ProductType type;
}
