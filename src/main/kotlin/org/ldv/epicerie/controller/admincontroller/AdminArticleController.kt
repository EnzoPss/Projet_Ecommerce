package org.ldv.epicerie.controller.admincontroller

import org.springframework.ui.Model
import org.ldv.epicerie.model.dao.ProduitDAO
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AdminArticleController (

    val produitDAO: ProduitDAO

) {

    @GetMapping("/Ecommerce_Lepicerie/admin/produits")
    fun index(model: Model):String {
        val produits = produitDAO.findAll()
        model.addAttribute("produits", produits)
        return "pagesAdmin/produit/indexProduit"
    }

}