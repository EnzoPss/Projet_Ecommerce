package org.ldv.epicerie.model.entity

import jakarta.persistence.*

@Entity
class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id_role: Long? = null,
    var nom_role: String,

    @OneToMany(mappedBy = "role",cascade = [CascadeType.ALL], orphanRemoval = true)
    var utilisateurs: MutableList<Utilisateur> = mutableListOf()


) {
}