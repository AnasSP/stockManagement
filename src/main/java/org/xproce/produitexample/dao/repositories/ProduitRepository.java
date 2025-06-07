package org.xproce.produitexample.dao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.xproce.produitexample.dao.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    Page<Produit> findByTitleContaining(String keyword, Pageable pageable);
    
    @Query("SELECT p FROM Produit p ORDER BY p.stock ASC")
    Page<Produit> findAllOrderByStockAsc(Pageable pageable);
} 