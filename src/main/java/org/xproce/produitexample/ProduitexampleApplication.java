package org.xproce.produitexample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.xproce.produitexample.dao.entities.Produit;
import org.xproce.produitexample.metier.ProduitManager;

@SpringBootApplication
public class ProduitexampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProduitexampleApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProduitManager produitManager) {
        return args -> {
//            produitManager.saveProduit(new Produit(null, "Computer", "High-performance computer", 999.99, 15));
//            produitManager.saveProduit(new Produit(null, "Printer", "Color printer", 299.99, 8));
//            produitManager.saveProduit(new Produit(null, "Smartphone", "Latest model smartphone", 799.99, 20));
        };
    }
}
