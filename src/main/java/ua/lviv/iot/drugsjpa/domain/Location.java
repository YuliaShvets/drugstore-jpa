package ua.lviv.iot.drugsjpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Location {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "street")
    private String street;

    @OneToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department departmentId;

//    @ManyToOne
//    @JoinColumn(name="city_id", referencedColumnName = "id")
//    private City cityId;
}
