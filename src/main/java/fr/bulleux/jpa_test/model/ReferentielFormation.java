package fr.bulleux.jpa_test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Referentiel_Formation")
public class ReferentielFormation {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    //@Column(name = "id_refFormation")
    private Integer id_rf;

    @Column(name = "nom")
    private String nom;

    //@ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_titre")
    private Titre titre;

//    @OneToMany
//    @JoinColumn(name = "fk_id_rf", referencedColumnName = "id_refFormation")
//    private List<Module> modules;

}
