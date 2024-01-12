package ma.ehei.gi4.gsproduit;

public class Produit {



    /**
     * The unique identifier for the product.
     */
    private Long id;

    /**
     * The name of the product.
     */
    private String nom;

    /**
     * The price of the product.
     */
    private double prix;

    /**
     * The quantity of the product.
     */
    private int quantite;

    /**
     * Default constructor for the Produit class.
     * Initializes an empty instance of the Produit class.
     */
    public Produit() {
    }

    /**
     * Constructs a new Produit with the specified parameters.
     *
     * @param id       The unique identifier for the product.
     * @param nom      The name of the product.
     * @param prix     The price of the product.
     * @param quantite The quantity of the product.
     */
    public Produit(final Long id, final String nom, final double prix, final int quantite) {
        this.setId(id);
        this.setNom(nom);
        this.prix = prix;
        this.quantite = quantite;
    }
    //ToString 
    @Override
	final public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + ", quantite=" + quantite + "]";
	}
    
    // Getters and setters follow a consistent order
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(final String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(final double prix) {
       if (prix < 0) {
            throw new IllegalArgumentException("Prix cannot be negative.");
        }
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        if (quantite < 0) {
            throw new IllegalArgumentException("Quantite cannot be negative.");
        }
        this.quantite = quantite;
    }

	

}
