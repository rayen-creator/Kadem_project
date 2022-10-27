package tn.esprit.service.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Persistance.entities.Equipe;
import tn.esprit.Persistance.entities.Etudiant;
import tn.esprit.Persistance.repositories.EquipeRepository;
import tn.esprit.Persistance.repositories.EtudiantRepository;
import tn.esprit.service.interfaces.EquipeService;

@Service
public class EquipeServiceImp implements EquipeService {

	@Autowired
	EquipeRepository equipeRep;

	@Override
	public Equipe afficherEquipe(int id) {
		return this.equipeRep.findById(id).get();
	}

	@Override
	public Equipe ajouterEquipe(Equipe e) {
		return this.equipeRep.save(e);
	}

	@Override
	public Equipe mettreAjourEquipe(Equipe e) {
		Equipe equipe = equipeRep.findById(e.getIdEquipe()).orElse(null);
		if (equipe != null)
			equipeRep.save(e);
		return e;
	}

	@Override
	public void supprimerEquipe(int id) {
		equipeRep.deleteById(id);
	}

	@Override
	public List<Equipe> chercherEquipes() {
		return equipeRep.findAll();

	}

}
