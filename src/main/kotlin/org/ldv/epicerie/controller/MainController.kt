package org.ldv.epicerie.controller

import org.springframework.security.core.Authentication
import org.springframework.ui.Model
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class MainController (){


    /**
     * Méthode permettant d'afficher la page d'accueil de l'application.
     * @return le chemin vers le template a partir du dossier ressources/templates (on ne marque pas le .html)
     */
    @GetMapping("/Ecommerce_Lepicerie")
    fun home():String{
        return "index"
    }


    @GetMapping("/Ecommerce_Lepicerie/login")
    fun login(@RequestParam error: Boolean?, model: Model): String {
        // Ajoute un attribut "error" au modèle si la requête contient une erreur
        model.addAttribute("error", error == true)
        return "pagesVisiteur/login"
    }


    @GetMapping("/Ecommerce_Lepicerie/profil")
    fun profile(authentication: Authentication): String {

        // Récupération des rôles (authorities) de l’utilisateur connecté
        val roles = authentication.authorities.map { it.authority }

        // Si l'utilisateur est admin → redirection
        if ("ROLE_ADMIN" in roles) {
            return "redirect:/Ecommerce_Lepicerie/admin/dashboard"
        }

        // Sinon → on affiche la page profile
        return "pagesClient/profile"
    }



}
