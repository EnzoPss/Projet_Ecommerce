package org.ldv.epicerie.model.entity

import jakarta.persistence.*

@Entity
class MotCles(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id_motCles: Long? = null,
    val text_motCles: String,

    //Association Many to Many avec Produit
    @ManyToMany
    @JoinTable(
    name = "MotCles_Produit",
    joinColumns = [JoinColumn(name = "motCles_fkid")],
    inverseJoinColumns = [JoinColumn(name = "produit_fkid")]
    )
    var produits: MutableList<Produit> = mutableListOf()
) {
}