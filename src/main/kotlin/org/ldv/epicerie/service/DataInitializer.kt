package org.ldv.epicerie.service



import org.ldv.epicerie.model.dao.CategorieDAO
import org.ldv.epicerie.model.dao.ProduitDAO
import org.ldv.epicerie.model.entity.Categorie
import org.ldv.epicerie.model.entity.Produit
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataInitializer(
    private val categorieDAO: CategorieDAO,
    private val produitDAO: ProduitDAO

) : CommandLineRunner {

    override fun run(vararg args: String?) {

        // Vérifie si la base contient déjà des données
        if (categorieDAO.count() > 0 || produitDAO.count() > 0) {
            println("ℹ️ Données déjà présentes, initialisation ignorée.")
            return
        }

        println("🚀 Initialisation des données...")

        // === Catégories ===
        val catGadget = Categorie(nom_categorie = "Spiritueu")
        val catJouet = Categorie(nom_categorie = "Vin")
        val catMaison = Categorie(nom_categorie = "Bière")

        categorieDAO.saveAll(listOf(catGadget, catJouet, catMaison))

        // === Produits ===

        val ProduitMontre = Produit(
            nom_produit = "Montre connectée",
            description_produit = "Montre connectée avec capteur de fréquence cardiaque et suivi d’activité.",
            prix_produit = 79.99,
            lienImage_produit = "https://example.com/images/montre-connectee.jpg",
            categories = catGadget
        )

/*        val ProduitDrone = Produit(
            nom = "Mini drone",
            description = "Drone compact avec caméra HD et contrôle via smartphone.",
            stock = 15,
            prix = 149.99,
            lienImage = "https://example.com/images/mini-drone.jpg",
            categorie = catGadget
        )


        // === Sauvegarde des Produits ===
        produitDAO.saveAll(
            listOf(
                ProduitMontre,
                ProduitDrone

            )
        )
*/
        println("✅ Données initiales insérées : ${categorieDAO.count()} catégories, ${produitDAO.count()} Produits.")
    }
}
//