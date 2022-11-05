package tn.esprit.service.classes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Persistance.entities.Departement;
import tn.esprit.Persistance.entities.DetailEquipe;
import tn.esprit.Persistance.entities.DetailEquipe;
import tn.esprit.Persistance.repositories.DetailEquipeRepository;
import tn.esprit.Persistance.repositories.DetailEquipeRepository;
import tn.esprit.service.interfaces.DetailEquipeService;

import java.util.List;
@Slf4j
@Service
public class DetailEquipeServiceImp implements DetailEquipeService {
    @Autowired
    DetailEquipeRepository detailEquipeRepo;
    @Override
    public DetailEquipe afficherDetailEquipe(int id) {
        return this.detailEquipeRepo.findById(id).get();
    }

    @Override
    public DetailEquipe ajouterDetailEquipe(DetailEquipe e) {
        return this.detailEquipeRepo.save(e);
    }

    @Override
    public DetailEquipe mettreAjourDetailEquipe(DetailEquipe e) {
        DetailEquipe DetailEquipe = detailEquipeRepo.findById(e.getIdDetailEquipe()).orElse(null);
        if (DetailEquipe != null)
            detailEquipeRepo.save(e);
        return e;
    }

    @Override
    public void supprimerDetailEquipe(int id) {
        detailEquipeRepo.deleteById(id);
    }

    @Override
    public List<DetailEquipe> chercherDetailEquipe() {
        List<DetailEquipe> DetailEquipes=detailEquipeRepo.findAll();
        for (DetailEquipe detailequipe :DetailEquipes){
            log.info("detailequipe :"+DetailEquipes);
        }
        return DetailEquipes;

    }
}
