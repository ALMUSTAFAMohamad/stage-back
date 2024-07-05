package fr.bulleux.jpa_test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Structure")
public class Structure {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id_structure;


    @Column(name = "nom")
    private String nom;

    
}
