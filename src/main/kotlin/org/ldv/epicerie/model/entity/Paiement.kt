package org.ldv.epicerie.model.entity

import jakarta.persistence.*

@Entity
class Paiement(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id_paiement: Long,
    var mode_paiement: String,
    var status_paiement: String,

    @OneToOne(mappedBy = "paiement",cascade = [CascadeType.ALL], orphanRemoval = true)
    var commande: Commande? = null



) {
}