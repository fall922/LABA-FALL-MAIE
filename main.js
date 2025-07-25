import entity.Patient;
import service.RendezVousService;
import view.VuePatient;

public class Main {
    public static void main(String[] args) {
        Patient patient = new Patient(1, "Laba", "laba@email.com");
        RendezVousService service = new RendezVousService();
        VuePatient vue = new VuePatient(service, patient);
        vue.afficherMenu();
    }
}
