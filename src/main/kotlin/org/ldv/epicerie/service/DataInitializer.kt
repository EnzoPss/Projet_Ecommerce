package org.ldv.epicerie.service



import org.ldv.epicerie.model.dao.CategorieDAO
import org.ldv.epicerie.model.dao.ProduitDAO
import org.ldv.epicerie.model.dao.RoleDAO
import org.ldv.epicerie.model.dao.UtilisateurDAO
import org.ldv.epicerie.model.entity.Categorie
import org.ldv.epicerie.model.entity.Produit
import org.ldv.epicerie.model.entity.Role
import org.ldv.epicerie.model.entity.Utilisateur
import org.springframework.boot.CommandLineRunner
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class DataInitializer(
    private val categorieDAO: CategorieDAO,
    private val produitDAO: ProduitDAO,
    var roleDAO: RoleDAO,
    var utilisateurDAO: UtilisateurDAO,
    var passwordEncoder: PasswordEncoder,


) : CommandLineRunner {

    override fun run(vararg args: String?) {

        // Vérifie si la base contient déjà des données
        if (categorieDAO.count() > 0 || produitDAO.count() > 0) {
            println("ℹ️ Données déjà présentes, initialisation ignorée.")
            return
        }

        // === Roles ===
        val roleAdmin = Role(
            nom_role = "ADMIN"
        )
        val roleClient = Role(
            nom_role = "CLIENT"
        )
        roleDAO.saveAll(listOf(roleAdmin, roleClient))


        // === Utilisateurs ===
        val admin = Utilisateur(
            id_utilisateur = null,
            nom_utilisateur = "Admin",
            prenom_utilisateur = "Admin",
            email_utilisateur = "admin@admin.com",
            mdp_utilisateur = passwordEncoder.encode("admin123"), // mot de passe hashé
            role = roleAdmin
        )

        val client = Utilisateur(
            id_utilisateur = null,
            nom_utilisateur = "Client",
            prenom_utilisateur = "Client",
            email_utilisateur = "client@client.com",
            mdp_utilisateur = passwordEncoder.encode("client123"), // mot de passe hashé
            role = roleClient
        )
        utilisateurDAO.saveAll(listOf(admin, client))



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
            stock_produit = 1,
            categorie = catSpiritueux,
        )

         val ProduitVn1 = Produit(
            nom_produit = "vin n°1",
            description_produit = "numéro 1 de notre collection de vins",
            prix_produit = 29.99,
            lienImage_produit = "https://example.com/images/montre-connectee.jpg",
             stock_produit = 1,
            categorie = catVins,
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