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
@Table(name = "Titre")
public class Titre{

    @Id
    @Column(name = "id_titre")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id_titre;


    @Column(name = "nom")
    private String nom;

    @Column(name = "millesime")
    private int millesime;

    @Column(name = "niveau")
    private int niveau;




    
}
