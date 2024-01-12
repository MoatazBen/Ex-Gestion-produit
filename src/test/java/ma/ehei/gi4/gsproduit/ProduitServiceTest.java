package ma.ehei.gi4.gsproduit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ma.ehei.gi4.gsproduit.service.ProduitService;

public class ProduitServiceTest {

    public ProduitService produitService;

    @BeforeEach
    public void setUp() {
        produitService = new ProduitService();
    }

    @Test
    public void testUpdateProduit() {
        Produit existingProduit = new Produit(1L, "Produit existant", 10.0, 5);
        produitService.getProduits().add(existingProduit);

        Produit updatedProduit = new Produit(1L, "Produit mis à jour", 15.1, 3);
        produitService.updateProduit(updatedProduit);

        Produit resultProduit = produitService.readProduit(1L);

        Assertions.assertNotNull(resultProduit);
        Assertions.assertEquals(updatedProduit.getNom(), resultProduit.getNom());
        Assertions.assertEquals(updatedProduit.getPrix(), resultProduit.getPrix());
        Assertions.assertEquals(updatedProduit.getQuantite(), resultProduit.getQuantite());
    }

}
