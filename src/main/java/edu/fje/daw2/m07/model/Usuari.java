package edu.fje.daw2.m07.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Classe entitat que repreenta a un usuari
 * @author sergi.grau@fje.edu
 * @version 1.0 08.04.21
 */
@Entity
public class Usuari {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String cognom;
    private String email;

    public Usuari() {}

    public Usuari(String nom, String cognom, String email) {
        this.nom = nom;
        this.cognom = cognom;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String firstName) {

        this.nom = firstName;
    }

    public String getCognom() {

        return cognom;
    }

    public void setCognom(String lastName) {

        this.cognom = lastName;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuari usuari = (Usuari) o;
        return Objects.equals(id, usuari.id) &&
                Objects.equals(nom, usuari.nom) &&
                Objects.equals(cognom, usuari.cognom) &&
                Objects.equals(email, usuari.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, cognom, email);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Usuari{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", cognom='").append(cognom).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}