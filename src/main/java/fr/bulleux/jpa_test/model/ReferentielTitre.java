package fr.bulleux.jpa_test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Referentiel_Titre")
public class ReferentielTitre {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id_rt;

    @Column(name = "nom")
    private String nom;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_titre")
    private Titre titre;


}
