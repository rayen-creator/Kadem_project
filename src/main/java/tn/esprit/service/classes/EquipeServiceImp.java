package tn.esprit.service.classes;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Persistance.entities.DetailEquipe;
import tn.esprit.Persistance.entities.Equipe;
import tn.esprit.Persistance.entities.Etudiant;
import tn.esprit.Persistance.repositories.EquipeRepository;
import tn.esprit.Persistance.repositories.EtudiantRepository;
import tn.esprit.service.interfaces.EquipeService;
@Slf4j
@Service
public class EquipeServiceImp implements EquipeService {

	@Autowired
	EquipeRepository equipeRep;

	@Override
	public Equipe afficherEquipe(int id) {
		Equipe equipe =(Equipe) equipeRep.findById(id).get();
		log.info("Equipe :"+ equipe);

		return equipe;
	}

	@Override
	public int ajouterEquipe(Equipe e) {
		equipeRep.save(e);
		log.info(e +"Ajouter avec succee ");
		return e.getIdEquipe();
	}

	@Override
	public Equipe mettreAjourEquipe(Equipe e) {
		Equipe equipe = equipeRep.findById(e.getIdEquipe()).orElse(null);
		if (equipe != null)
			equipeRep.save(e);
			log.info("updatedEquipe"+e.getIdEquipe());
		return e;
	}

	@Override
	public void supprimerEquipe(int id) {
		equipeRep.deleteById(id);
		log.info("EquipeDeleted"+id);
	}

	@Override
	public List<Equipe> chercherEquipes() {
		List<Equipe> equipes=equipeRep.findAll();
		for (Equipe equipe :equipes){
			log.info("equipe :"+equipes);
		}
		return equipes;
	}


}
