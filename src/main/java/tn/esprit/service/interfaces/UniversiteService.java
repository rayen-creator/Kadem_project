package tn.esprit.service.interfaces;

import tn.esprit.Persistance.entities.Universite;

import java.util.List;

public interface UniversiteService {

    public Universite afficherUniversite(int id);

    public int ajouterUniversite(Universite e);

    public Universite mettreAjourUniversite(Universite u);

    public void supprimerUniversite(int id);

    public List<Universite> chercherUniversites();
}
