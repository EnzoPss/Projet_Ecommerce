package org.ldv.epicerie.model.dao
import org.ldv.epicerie.model.entity.Commentaire
import org.springframework.data.jpa.repository.JpaRepository

interface CommentaireDAO : JpaRepository<Commentaire, Long> {
}
