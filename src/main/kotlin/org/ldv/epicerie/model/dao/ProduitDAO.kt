import org.ldv.epicerie.model.entity.Produit
import org.springframework.data.jpa.repository.JpaRepository

interface ProduitDAO : JpaRepository<Produit, Long> {
}
