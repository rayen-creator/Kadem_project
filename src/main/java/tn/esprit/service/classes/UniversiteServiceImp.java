package tn.esprit.service.classes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Persistance.entities.Departement;
import tn.esprit.Persistance.entities.Etudiant;
import tn.esprit.Persistance.entities.Universite;
import tn.esprit.Persistance.entities.Universite;
import tn.esprit.Persistance.repositories.DepartementRepository;
import tn.esprit.Persistance.repositories.UniversiteRepository;
import tn.esprit.service.interfaces.DepartementService;
import tn.esprit.service.interfaces.UniversiteService;

import java.util.List;
@Slf4j
@Service
public class UniversiteServiceImp implements UniversiteService {
    @Autowired
    UniversiteRepository universiteRepo;
    @Autowired
    DepartementRepository depRepo;
    @Autowired
    DepartementService departmentService;

    @Override
    public Universite afficherUniversite(int id) {

        Universite universite =(Universite) universiteRepo.findById(id).get();
        log.info("Universite :"+ universite);

        return universite;
    }

    @Override
    public int ajouterUniversite(Universite u) {
        if (u.getDepartements()!=null){
            for(Departement e:u.getDepartements()){
                departmentService.ajouterDepartement(e);

            }}
        universiteRepo.save(u);
        log.info("Ajouter avec succee id :"+u.getIdUniv());
        return u.getIdUniv();
    }

    @Override
    public Universite mettreAjourUniversite(Universite u) {
        if(universiteRepo.findById(u.getIdUniv())!=null){
            for(Departement e:u.getDepartements()){
                if(depRepo.existsById(e.getIdDepart())){
                    depRepo.save(e);

                }
                else
                    depRepo.save(e);

            }

            log.info("Mise à jour réussie id:"+u );
            return universiteRepo.findById(u.getIdUniv()).orElse(null);

        }
        else
            return null;
//        Universite u = universiteRepo.findById(id).get();
//        universiteRepo.save(u);
//        ;
//        return (u);
    }

    @Override
    public void supprimerUniversite(int id) {
        universiteRepo.deleteById(id);
        log.info("supprimé uni id"+id);    }

    @Override
    public List<Universite> chercherUniversites() {

        List<Universite> universites=universiteRepo.findAll();
        for (Universite universite :universites){
            log.info("universite :"+universites);
        }
        return universites;
    }		 

}
