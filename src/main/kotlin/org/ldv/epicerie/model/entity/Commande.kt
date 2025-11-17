package org.ldv.epicerie.model.entity

import java.util.Date

import jakarta.persistence.*

@Entity
class Commande(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id_commande: Long,
    val date_commande: Date,
    var status_commande: String,
    var prixTotal_commande: Double,

    //relation to Utilisateur
    @ManyToOne
    @JoinColumn(name = "utilisateur_fkid")
    var utilisateur: Utilisateur? = null,

    //relation to paiement
    @OneToOne
    @JoinColumn(name = "paiement_fkid")
    var paiement: Paiement? = null,

    //Association Many to Many avec Produit
    @ManyToMany
    @JoinTable(
    name = "Commande_Produit",
    joinColumns = [JoinColumn(name = "commande_fkid")],
    inverseJoinColumns = [JoinColumn(name = "produit_fkid")]
    )
    var produits: MutableList<Produit> = mutableListOf()


) {
}