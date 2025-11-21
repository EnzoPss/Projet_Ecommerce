package org.ldv.epicerie.controller.admincontroller

import ch.qos.logback.core.model.Model
import org.ldv.epicerie.model.dao.CategorieDAO
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AdminController {
    @GetMapping("/Ecommerce_Lepicerie/admin")
    fun accueil():String{
        return "pagesAdmin/dashboard"
    }

}