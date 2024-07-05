package fr.bulleux.jpa_test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Post" )
public class Post {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id_post;

    @Column(name = "contenu")
    private String contenu;

    @Column(name = "avecImage")
    private boolean avecImage;

    @Column(name = "avecVideo")
    private boolean avecVideo;

    @ManyToOne
    @JoinColumn(name = "id_competence")
    private Competence competence;

    @OneToOne
    @JoinColumn(name = "id_user_apprenti")
    private User apprenti;

    @OneToOne
    @JoinColumn(name = "id_user_posteur")
    private User posteur;

}
