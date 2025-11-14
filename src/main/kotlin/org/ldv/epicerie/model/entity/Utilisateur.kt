package org.ldv.epicerie.model.entity

import jakarta.persistence.*

@Entity
class Utilisateur(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id_user: Long,
    var nom_user: String,
    var mdp_user: String,
    var email_user: String,
    var adresse_user: String,

    //relation to Commande
    @OneToMany(mappedBy = "utilisateur",cascade = [CascadeType.ALL], orphanRemoval = true)
    var commandes: MutableList<Commande> = mutableListOf(),

    //relation to Role
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    var role: Role? = null

) {
}