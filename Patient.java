package entity;

public class Patient {
    private int id;
    private String nom;
    private String email;

    public Patient(int id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Patient) {
            return this.id == ((Patient) obj).getId();
        }
        return false;
    }
}
