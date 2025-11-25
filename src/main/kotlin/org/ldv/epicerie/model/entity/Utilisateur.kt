package org.ldv.epicerie.model.entity

import jakarta.persistence.*

@Entity
class Utilisateur(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id_utilisateur: Long? = null,
    var nom_utilisateur: String,
    var prenom_utilisateur: String,
    var mdp_utilisateur: String,
    var email_utilisateur: String,

    //relation to Commande
    @OneToMany(mappedBy = "utilisateur",cascade = [CascadeType.ALL], orphanRemoval = true)
    var commandes: MutableList<Commande> = mutableListOf(),

    //relation to Role
    @ManyToOne
    @JoinColumn(name = "role_fkid")
    var role: Role? = null,

    //relation to Commentaire
    @OneToMany(mappedBy = "utilisateur",cascade = [CascadeType.ALL], orphanRemoval = true)
    var commentaires: MutableList<Commentaire> = mutableListOf(),

    ) {
}