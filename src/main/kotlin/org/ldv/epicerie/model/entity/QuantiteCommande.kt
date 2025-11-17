package org.ldv.epicerie.model.entity

import jakarta.persistence.*

@Entity
class QuantiteCommande (
    @EmbeddedId
    var quantieId: QuantiteCommande_Id? = null,
    var quantite: Long,



    @MapsId("albumId")
    @ManyToOne
    @JoinColumn(name = "album_id")
    var produits: Produit? = null,


    @MapsId("utilisateurId")
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    var commandes: Commande? = null
) {
}
