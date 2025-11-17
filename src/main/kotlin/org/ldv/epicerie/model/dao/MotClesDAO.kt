package org.ldv.epicerie.model.dao
import org.ldv.epicerie.model.entity.MotCles
import org.springframework.data.jpa.repository.JpaRepository

interface MotClesDAO : JpaRepository<MotCles, Long> {
}
