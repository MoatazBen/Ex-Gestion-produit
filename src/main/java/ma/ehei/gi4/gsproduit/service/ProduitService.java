package ma.ehei.gi4.gsproduit.service;
import java.util.ArrayList;
import java.util.List;

import ma.ehei.gi4.gsproduit.Produit;
/**
 * Service class for managing products.
 */
public class ProduitService {

	
    /** List to store products. */
    private List<Produit> produits = new ArrayList<>();

    /**
     * Retrieves a product by its unique identifier.
     *
     * @param id The unique identifier of the product.
     * @return The product with the specified identifier, or null if not found.
     */
    public Produit readProduit(final Long id) {
        return produits.stream()
                .filter(produit -> produit.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Updates the information of a product.
     *
     * @param produit The product to be updated.
     */
    public void updateProduit(final Produit produit) {
        Produit existingProduit = readProduit(produit.getId());
        if (existingProduit != null) {
            existingProduit.setNom(produit.getNom());
            existingProduit.setPrix(produit.getPrix());
            existingProduit.setQuantite(produit.getQuantite());
        } else {
            // Handle the case where the product to be updated does not exist
            throw new IllegalArgumentException("Product not found for update: " + produit.getId());
        }
    }
    
    

    /**
     * Deletes a product by its unique identifier.
     *
     * @param id The unique identifier of the product to be deleted.
     */
    public void deleteProduit(final Long id) {
        produits.removeIf(produit -> produit.getId().equals(id));
    }

    /**
     * Retrieves a list of all products.
     *
     * @return A list containing all products.
     */
    public List<Produit> getAllProduits() {
        return new ArrayList<>(produits);
    }

    /**
     * Adds a new product to the list.
     *
     * @param produit The product to be added.
     */
    public void addProduit(final Produit produit) {
        produits.add(produit);
    }

    /**
     * Get the list of products.
     *
     * @return The list of products.
     */
    public List<Produit> getProduits() {
        return produits;
    }

    /**
     * Set the list of products.
     *
     * @param produits The list of products.
     */
    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
}