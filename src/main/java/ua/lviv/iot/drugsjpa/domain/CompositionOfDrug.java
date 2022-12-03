package ua.lviv.iot.drugsjpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class CompositionOfDrug {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "active_ingredients")
    private String activeIngredients;

    @OneToOne
    @JoinColumn(name = "drug_id", referencedColumnName = "id")
    private Drug drugId;
}