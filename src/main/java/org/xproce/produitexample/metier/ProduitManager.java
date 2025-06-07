package org.xproce.produitexample.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.xproce.produitexample.dao.entities.Produit;
import org.xproce.produitexample.dao.repositories.ProduitRepository;

@Service
public class ProduitManager implements ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public Page<Produit> getAllProduits(Pageable pageable) {
        return produitRepository.findAll(pageable);
    }

    @Override
    public Page<Produit> searchProduits(String keyword, Pageable pageable) {
        return produitRepository.findByTitleContaining(keyword, pageable);
    }

    @Override
    public Produit getProduitById(Long id) {
        return produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Produit saveProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }
} 