package tn.esprit.service.interfaces;


import tn.esprit.Persistance.entities.DetailEquipe;

import java.util.List;

public interface DetailEquipeService {

    public DetailEquipe afficherDetailEquipe(int id);

    public DetailEquipe ajouterDetailEquipe(DetailEquipe e);

    public DetailEquipe mettreAjourDetailEquipe(DetailEquipe e);

    public void supprimerDetailEquipe(int id);

    public List<DetailEquipe> chercherDetailEquipe();
}
