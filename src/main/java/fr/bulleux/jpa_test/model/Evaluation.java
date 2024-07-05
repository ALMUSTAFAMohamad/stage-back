package fr.bulleux.jpa_test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Evaluation" )
public class Evaluation {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id_evaluation;

    @Column(name = "description")
    private String description;

    @Column(name = "note")
    private double note;

    @ManyToOne
    @JoinColumn(name = "id_module")
    private Module module;

    @OneToOne
    @JoinColumn(name = "id_user_apprenti")
    private User apprenti;

    @OneToOne
    @JoinColumn(name = "id_user_formateur")
    private User formateur;

}
