package views;

import java.time.LocalDateTime;
import java.util.Scanner;
import entity.Patient;
import entity.RendezVous;
import service.RendezVousService;

public class VuePatient {
    private RendezVousService service;
    private Patient patient;
    private Scanner scanner = new Scanner(System.in);

    public VuePatient(RendezVousService service, Patient patient) {
        this.service = service;
        this.patient = patient;
    }

    public void afficherMenu() {
        System.out.println("1. Demander RV");
        System.out.println("2. Consulter mes RV");
        System.out.println("3. Demander une annulation");
        String choix = scanner.nextLine();

        switch (choix) {
            case "1":
                System.out.print("Date RV (YYYY-MM-DDTHH:mm): ");
                LocalDateTime dateRV = LocalDateTime.parse(scanner.nextLine());
                System.out.print("Spécialité: ");
                String specialite = scanner.nextLine();
                System.out.print("Médecin: ");
                String medecin = scanner.nextLine();
                RendezVous rv = service.demanderRV(patient, dateRV, specialite, medecin);
                System.out.println("RV demandé avec ID #" + rv.getId());
                break;
            case "2":
                for (RendezVous r : service.suivreRV(patient)) {
                    System.out.println("ID: " + r.getId() + " | " + r.getDateRV() + " | " + r.getSpecialite()
                            + " | Statut: " + r.getStatut());
                }
                break;
            case "3":
                System.out.print("ID du RV à annuler: ");
                int rvId = Integer.parseInt(scanner.nextLine());
                System.out.println(service.demanderAnnulation(rvId, patient));
                break;
            default:
                System.out.println("Option invalide.");
        }
    }
}
