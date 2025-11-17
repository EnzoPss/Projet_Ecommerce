package org.ldv.epicerie.model.dao
import org.ldv.epicerie.model.entity.Utilisateur
import org.springframework.data.jpa.repository.JpaRepository

interface UtilisateurDAO : JpaRepository<Utilisateur, Long> {
}
