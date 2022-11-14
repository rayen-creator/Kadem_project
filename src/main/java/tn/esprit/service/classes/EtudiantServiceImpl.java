package tn.esprit.service.classes;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.Persistance.entities.Equipe;
import tn.esprit.Persistance.entities.Etudiant;
import tn.esprit.Persistance.repositories.EtudiantRepository;
import tn.esprit.service.interfaces.EtudiantService;
@Slf4j
@Service
public class EtudiantServiceImpl implements EtudiantService {

	@Autowired
	EtudiantRepository etudRep;

	@Override
	public Etudiant afficherEtudiant(int id) {
		Etudiant etudiant =(Etudiant) etudRep.findById(id).get();
		log.info("Etudiant :"+ etudiant);
		return etudiant;
	}

	@Override
	public int ajouterEtudiant(Etudiant e) {
		etudRep.save(e);
		log.info(e+": Ajouter avec succee ");
		return e.getIdEtudiant();
	}

	@Override
	public Etudiant mettreAjourEtudiant(Etudiant e) {
		Etudiant etudiant = etudRep.findById(e.getIdEtudiant()).get();
		if (etudiant != null)
			etudRep.save(e);
			log.info("Mise à jour réussie id :"+e.getIdEtudiant());
		return (e);
	}

	@Override
	public void supprimerEtudiant(int id) {

		etudRep.deleteById(id);
		log.info("supprimé id :"+id );
	}

	@Override
	public List<Etudiant> chercherEtudiants() {

		List<Etudiant> etudiants= etudRep.findAll();
		for (Etudiant etudiant :etudiants){
			log.info("etudiant :"+etudiants);
		}
		return etudiants;
	}

	@Scheduled(fixedRate = 30000)
	public void fixedRateMethod() {
		System.out.println("******** Method with fixed Rate every 30 seconde**********");
	}
	@Scheduled(fixedDelay = 60000)
	public void fixedDelayMethod() {
		System.out.println( "******** Method with fixed delay every 60 seconde**********");
    }
    @Scheduled(cron = "*/60 * * * * *" )
    public void cronMethod() {
		System.out.println("**********Method with cron expression every 60 seconde**********");
    }
}
