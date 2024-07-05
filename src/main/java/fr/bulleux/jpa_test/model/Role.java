package fr.bulleux.jpa_test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Role")
public class Role {

    @Id//
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id_role;


    @Column(name = "description")
    private String description;

}
