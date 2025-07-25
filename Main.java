import entity.Patient;
import service.RendezVousService;
import views.VuePatient;

public class Main {
    public static void main(String[] args) {
        // Création du patient test
        Patient patient = new Patient(1, "Laba", "laba@email.com");

        // Création du service
        RendezVousService service = new RendezVousService();

        // Création de la vue pour afficher le menu
        VuePatient vue = new VuePatient(service, patient);

        // Affichage du menu
        vue.afficherMenu();
    }
}
