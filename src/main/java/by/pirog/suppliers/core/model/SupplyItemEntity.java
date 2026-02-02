package by.pirog.suppliers.core.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(schema = "storage", name = "t_supply_item")
public class SupplyItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "c_supply")
    private SupplyEntity supply;

    @ManyToOne
    @JoinColumn(name = "c_supplier_price")
    private SupplierPriceEntity supplierPrice;

    @Column(name = "c_weight_per_kg")
    private BigDecimal weightPerKg;
}
