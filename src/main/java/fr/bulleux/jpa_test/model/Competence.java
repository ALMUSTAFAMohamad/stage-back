package fr.bulleux.jpa_test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Competence" )
public class Competence {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id_competence;

    @Column(name = "nom")
    private String nom;

    @Column(name = "obligatoire")
    private boolean obligatoire;

    @Column(name = "validee")
    private boolean validee;

    @ManyToOne
    @JoinColumn(name = "id_activite")
    private Activite activite;

    @OneToOne
    @JoinColumn(name = "id_user_apprenti")
    private User apprenti;

    @OneToOne
    @JoinColumn(name = "id_user_formateur")
    private User formateur;

}
