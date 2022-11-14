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

        Contrat contrat =(Contrat) contratRepo.findById(id).get();
        log.info("contrat :"+ contrat);

        return contrat;    }

    @Override
    public int ajouterContrat(Contrat c) {
        contratRepo.save(c);
        log.info(c+"Ajouter avec succee ");
        return c.getIdContrat();
    }

    @Override
    public Contrat mettreAjourContrat(Contrat c) {
        Contrat contrat = contratRepo.findById(c.getIdContrat()).get();
        contratRepo.save(contrat);
        log.info("Mise à jour réussie:"+contrat );
        return (contrat);

    }

    @Override
    public void supprimerContrat(int id) {
        contratRepo.deleteById(id);
        log.info("supprimé :"+id );
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
