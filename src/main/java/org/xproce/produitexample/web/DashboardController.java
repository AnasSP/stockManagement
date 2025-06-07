package org.xproce.produitexample.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.xproce.produitexample.dao.entities.Produit;
import org.xproce.produitexample.metier.ProduitService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DashboardController {

    @Autowired
    private ProduitService produitService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<Produit> allProducts = produitService.getAllProduits(PageRequest.of(0, 10)).getContent();

        long totalProducts = allProducts.size();

        double totalValue = allProducts.stream()
                .mapToDouble(p -> p.getPrice() * p.getStock())
                .sum();

        List<Produit> lowStockProducts = allProducts.stream()
                .filter(p -> p.getStock() < 10)
                .collect(Collectors.toList());

        model.addAttribute("totalProducts", totalProducts);
        model.addAttribute("totalValue", totalValue);
        model.addAttribute("lowStockCount", lowStockProducts.size());
        model.addAttribute("lowStockProducts", lowStockProducts);
        
        return "dashboard";
    }
} 