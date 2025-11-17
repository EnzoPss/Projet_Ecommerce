package org.ldv.epicerie.model.entity

import jakarta.persistence.*

@Entity
class Produit(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id_produit: Long,
    var nom_produit: String,
    var description_produit: String,
    var prix_produit: Double,

    //relation to Commentaire
    @OneToMany(mappedBy = "produit",cascade = [CascadeType.ALL], orphanRemoval = true)
    var commentaires: MutableList<Commentaire> = mutableListOf(),

    //Association to Commande
    @ManyToMany
    @JoinTable(
    name = "Produit_Commande",
    joinColumns = [JoinColumn(name = "produit_fkid")],
    inverseJoinColumns = [JoinColumn(name = "commande_fkid")]
    )
    var commandes: MutableList<Commande> = mutableListOf()
) {
}