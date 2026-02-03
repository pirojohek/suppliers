package by.pirog.suppliers.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(schema = "storage", name = "t_supplier_product_price")
public class SupplierPriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "c_supplier")
    private SupplierEntity supplier;

    @ManyToOne
    @JoinColumn(name = "c_product")
    private ProductEntity product;

    @Column(name = "c_price")
    private BigDecimal price;

    @Column(name = "c_date_from")
    private LocalDate dateFrom;

    @Column(name = "c_date_to")
    private LocalDate dateTo;
}
