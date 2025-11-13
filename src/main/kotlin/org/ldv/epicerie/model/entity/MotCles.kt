package org.ldv.epicerie.model.entity

import jakarta.persistence.*

@Entity
class MotCles(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id_motCles: Long,
    val text_motCles: String
) {
}