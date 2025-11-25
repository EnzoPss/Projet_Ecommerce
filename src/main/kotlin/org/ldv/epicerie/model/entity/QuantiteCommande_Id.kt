package org.ldv.epicerie.model.entity

import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
class QuantiteCommande_Id (
    var produitId: Long? = null,
    var commandeId: Long
): Serializable {
}
