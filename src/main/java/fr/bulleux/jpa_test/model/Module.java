package fr.bulleux.jpa_test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Module")
public class Module {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id_module;


    @Column(name = "nom")
    private String nom;

    @Column(name = "connaissance")
    private String connaissance;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_rf")
    private ReferentielFormation rf;



}
