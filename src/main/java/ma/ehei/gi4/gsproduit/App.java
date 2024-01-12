package ma.ehei.gi4.gsproduit;

import java.util.Scanner;

import ma.ehei.gi4.gsproduit.service.ProduitService;
public class App {

    public static void main(String[] args) {
        ProduitService produitService = new ProduitService();
        Scanner scanner = new Scanner(System.in);

        int choix;
        do {
            System.out.println("Menu :");
            System.out.println("1. Ajouter un produit");
            System.out.println("2. Mettre à jour un produit");
            System.out.println("3. Supprimer un produit");
            System.out.println("4. Afficher tous les produits");
            System.out.println("5. Quitter");
            System.out.print("Entrez votre choix : ");

            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le caractère de nouvelle ligne

            switch (choix) {
                case 1:
                    // Ajouter un produit
                    System.out.print("Entrez le nom du produit : ");
                    String nomProduit = scanner.nextLine();
                    System.out.print("Entrez le prix du produit : ");
                    double prixProduit = scanner.nextDouble();
                    System.out.print("Entrez la quantité du produit : ");
                    int quantiteProduit = scanner.nextInt();

                    Produit nouveauProduit = new Produit(null, nomProduit, prixProduit, quantiteProduit);
                    produitService.addProduit(nouveauProduit);
                    System.out.println("Produit ajouté avec succès !");
                    break;

                case 2:
                    // Mettre à jour un produit
                    System.out.print("Entrez l'ID du produit à mettre à jour : ");
                    Long idMiseAJour = scanner.nextLong();
                    scanner.nextLine(); // Consommer le caractère de nouvelle ligne

                    Produit produitMiseAJour = produitService.readProduit(idMiseAJour);
                    if (produitMiseAJour != null) {
                        System.out.print("Entrez le nouveau nom du produit : ");
                        produitMiseAJour.setNom(scanner.nextLine());
                        System.out.print("Entrez le nouveau prix du produit : ");
                        produitMiseAJour.setPrix(scanner.nextDouble());
                        System.out.print("Entrez la nouvelle quantité du produit : ");
                        produitMiseAJour.setQuantite(scanner.nextInt());

                        produitService.updateProduit(produitMiseAJour);
                        System.out.println("Produit mis à jour avec succès !");
                    } else {
                        System.out.println("Produit non trouvé !");
                    }
                    break;

                case 3:
                    // Supprimer un produit
                    System.out.print("Entrez l'ID du produit à supprimer : ");
                    Long idSuppression = scanner.nextLong();
                    scanner.nextLine(); // Consommer le caractère de nouvelle ligne

                    produitService.deleteProduit(idSuppression);
                    System.out.println("Produit supprimé avec succès !");
                    break;

                case 4:
                    // Afficher tous les produits
                    System.out.println("Liste des produits :");
                    for (Produit produit : produitService.getAllProduits()) {
                        System.out.println(produit);
                    }
                    break;

                case 5:
                    // Quitter
                    System.out.println("Fermeture du programme. Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide. Veuillez entrer une option valide.");
            }

        } while (choix != 5);

        scanner.close();
    }
}