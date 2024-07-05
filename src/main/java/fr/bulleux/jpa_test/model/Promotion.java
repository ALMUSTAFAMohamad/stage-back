package fr.bulleux.jpa_test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Promotion")
public class Promotion {


    @Id//
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id_promotion;

    @Column(name = "nom")
    private String nom;

    @ManyToOne
    @JoinColumn(name = "id_titre")
    private Titre titre;




}
