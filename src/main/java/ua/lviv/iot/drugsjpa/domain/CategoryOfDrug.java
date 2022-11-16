package ua.lviv.iot.drugsjpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CategoryOfDrug {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "required_prescription")
    private boolean requiredPrescription;
    @Basic
    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "drug_id", referencedColumnName = "id")
    private Drug drugId;
}
