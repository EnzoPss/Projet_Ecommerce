package org.ldv.epicerie.model.entity

import jakarta.persistence.*

@Entity
class Produit(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id_produit: Long?=null,
    var nom_produit: String,
    var description_produit: String,
    var prix_produit: Double,
    var lienImage_produit: String,

    //relation to Commentaire
    @OneToMany(mappedBy = "produit",cascade = [CascadeType.ALL], orphanRemoval = true)
    var commentaires: MutableList<Commentaire> = mutableListOf(),

    //Associaiton One to Many avec QuantiteCommande
    @OneToMany(mappedBy = "produit", orphanRemoval = true)
    var quantiteCommande: MutableList<QuantiteCommande> = mutableListOf(),

    //relation to Categorie
    @ManyToOne
    @JoinColumn(name = "categorie_fkid")
    open var categorie: Categorie? = null


) {


}