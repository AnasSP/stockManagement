package org.xproce.produitexample.metier;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.xproce.produitexample.dao.entities.Produit;

public interface ProduitService {
    Page<Produit> getAllProduits(Pageable pageable);
    Page<Produit> searchProduits(String keyword, Pageable pageable);
    Produit getProduitById(Long id);
    Produit saveProduit(Produit produit);
    void deleteProduit(Long id);
} 