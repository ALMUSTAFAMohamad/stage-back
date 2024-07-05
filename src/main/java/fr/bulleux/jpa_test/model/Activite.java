package fr.bulleux.jpa_test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Activite")
public class Activite {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id_activite;


    @Column(name = "nom")
    private String nom;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_rt")
    private ReferentielTitre rt;

    
}
