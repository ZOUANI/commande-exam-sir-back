package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produit {
   @Id @GeneratedValue(strategy= GenerationType.AUTO)
   private Long id;
   private String ref;
   private String libelle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
