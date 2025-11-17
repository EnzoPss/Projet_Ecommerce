package org.ldv.epicerie.model.dao
import org.ldv.epicerie.model.entity.Categorie
import org.springframework.data.jpa.repository.JpaRepository

interface CategorieDAO : JpaRepository<Categorie, Long> {
}
