package org.ldv.epicerie.model.dao
import org.ldv.epicerie.model.entity.Utilisateur
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UtilisateurDAO : JpaRepository<Utilisateur, Long> {


    @Query("select u from Utilisateur u where u.email_utilisateur = ?1")
    fun findByEmail(email: String): Utilisateur

}
