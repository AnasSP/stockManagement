package org.xproce.produitexample.web;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.xproce.produitexample.dao.entities.Produit;
import org.xproce.produitexample.metier.ProduitService;

@Controller
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping
    public String listProduits(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "keyword", defaultValue = "") String keyword,
            Model model) {
        
        Page<Produit> produits = produitService.searchProduits(keyword, PageRequest.of(page, size));
        
        model.addAttribute("produits", produits.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", produits.getTotalPages());
        model.addAttribute("keyword", keyword);
        
        return "produits";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("produit", new Produit());
        return "produit-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Produit produit = produitService.getProduitById(id);
        model.addAttribute("produit", produit);
        return "produit-form";
    }

    @PostMapping("/save")
    public String saveProduit(@Valid @ModelAttribute Produit produit, BindingResult result) {
        if (result.hasErrors()) {
            return "produit-form";
        }
        produitService.saveProduit(produit);
        return "redirect:/produits";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
        return "redirect:/produits";
    }
}
