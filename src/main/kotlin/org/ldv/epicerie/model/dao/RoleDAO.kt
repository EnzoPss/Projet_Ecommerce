package org.ldv.epicerie.model.dao
import org.ldv.epicerie.model.entity.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleDAO : JpaRepository<Role, Long> {
}
