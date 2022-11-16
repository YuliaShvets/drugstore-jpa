package ua.lviv.iot.drugsjpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class UseOfDrug {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "use_type")
    private String useType;

    @ManyToOne
    @JoinColumn(name = "drug_id", referencedColumnName = "id")
    private Drug drugId;
}
