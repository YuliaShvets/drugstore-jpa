package ua.lviv.iot.drugsjpa.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Department {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "number")
    private int number;

    @ManyToOne
    @JoinColumn(name = "drugstore_id", referencedColumnName = "id")
    private Drugstore drugstoreId;
}
