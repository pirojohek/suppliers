package by.pirog.suppliers.core.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(schema = "storage", name = "t_supply")
public class SupplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "c_supplier")
    private SupplierEntity supplier;

    @Column(name = "c_supply_date")
    private LocalDate supplyDate;
}
