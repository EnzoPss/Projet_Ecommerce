package org.ldv.epicerie.controller.admincontroller

import org.springframework.ui.Model
import org.ldv.epicerie.model.dao.CategorieDAO
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AdminCategorieController(

    val categorieDAO: CategorieDAO

) {

    @GetMapping("/Ecommerce_Lepicerie/admin/categorie")
    fun index(model: Model):String {
        val categories = categorieDAO.findAll()
        model.addAttribute("categories", categories)
        return "pagesAdmin/categorie/indexCategorie"
    }

}