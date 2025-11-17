package org.ldv.epicerie.model.entity

import jakarta.persistence.*

@Entity
class QuantiteCommande (
    @EmbeddedId
    var quantiteId: QuantiteCommande_Id? = null,
    var quantite: Long,



    @MapsId("produitId")
    @ManyToOne
    @JoinColumn(name = "produit_id")
    var produit: Produit? = null,


    @MapsId("commandeId")
    @ManyToOne
    @JoinColumn(name = "commande_id")
    var commande: Commande? = null
) {
}
