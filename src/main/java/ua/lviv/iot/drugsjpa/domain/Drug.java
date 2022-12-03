package ua.lviv.iot.drugsjpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Drug {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "production_date")
    private Date productionDate;
    @Basic
    @Column(name = "expiration_date")
    private Date expirationDate;
    @Basic
    @Column(name = "is_available")
    private boolean isAvailable;
    @Basic
    @Column(name = "price_in_dollars")
    private double priceInDollars;

    @ManyToOne
    @JoinColumn(name = "producer_id", referencedColumnName = "id")
    private Producer producerId;

    @ManyToOne
    @JoinColumn(name = "drugstore_id", referencedColumnName = "id")
    private Drugstore drugstoreId;

}
