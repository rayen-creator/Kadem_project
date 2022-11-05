package tn.esprit.service.classes;

import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Persistance.entities.Contrat;
import tn.esprit.Persistance.repositories.ContratRepository;
import tn.esprit.service.interfaces.ContratService;

import java.util.List;

@Slf4j
@Service
public class ContratServiceImp implements ContratService {
    @Autowired
    ContratRepository contratRepo;

    @Override
    public Contrat afficherContrat(int id) {

        return contratRepo.findById(id).get();
    }

    @Override
    public Contrat ajouterContrat(Contrat e) {
        return this.contratRepo.save(e);

    }

    @Override
    public Contrat mettreAjourContrat(Contrat e) {
        Contrat Contrat = contratRepo.findById(e.getIdContrat()).orElse(null);
        if(Contrat != null)
            contratRepo.save(e);
        return e;

    }

    @Override
    public void supprimerContrat(int id) {
        contratRepo.deleteById(id);
    }

    @Override
    public List<Contrat> chercherContrat() {

        List<Contrat> contrats=contratRepo.findAll();
        for (Contrat contrat:contrats){
             log.info("contrat :"+contrat);
        }
        return contrats;

    }

}
