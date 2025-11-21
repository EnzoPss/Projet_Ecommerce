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
    private val produitDAO: ProduitDAO,


) : CommandLineRunner {

    override fun run(vararg args: String?) {

        // Vérifie si la base contient déjà des données
        if (categorieDAO.count() > 0 || produitDAO.count() > 0) {
            println("ℹ️ Données déjà présentes, initialisation ignorée.")
            return
        }

        println("🚀 Initialisation des données...")

        // === Catégories ===

        val catSpiritueux = Categorie(nom_categorie = "Spiritueux")
        val catVins = Categorie(nom_categorie = "Vin")
        val catBieres = Categorie(nom_categorie = "Bière")

        categorieDAO.saveAll(listOf(catSpiritueux, catVins, catBieres))
        
        // === Produits ===

        val ProduitSn1 = Produit(
            nom_produit = "spirit n°1",
            description_produit = "numéro 1 de notre collection de spiritueux",
            prix_produit = 29.99,
            lienImage_produit = "https://example.com/images/montre-connectee.jpg",
            categorie = catSpiritueux
        )

         val ProduitVn1 = Produit(
            nom_produit = "vin n°1",
            description_produit = "numéro 1 de notre collection de vins",
            prix_produit = 29.99,
            lienImage_produit = "https://example.com/images/montre-connectee.jpg",
            categorie = catVins
        )


        // === Sauvegarde des Produits ===
        produitDAO.saveAll(
            listOf(
                ProduitSn1,
                ProduitVn1,

            )
        )

        println("✅ Données initiales insérées : ${categorieDAO.count()} catégories, ${produitDAO.count()} Produits.")
    }
}
//