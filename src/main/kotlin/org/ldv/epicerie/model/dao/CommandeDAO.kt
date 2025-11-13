import org.ldv.epicerie.model.entity.Commande
import org.springframework.data.jpa.repository.JpaRepository

interface CommandeDAO : JpaRepository<Commande, Long> {
}
