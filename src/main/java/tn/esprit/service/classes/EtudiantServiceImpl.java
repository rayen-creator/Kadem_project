package tn.esprit.service.classes;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

		return this.etudRep.findById(id).get();
	}

	@Override
	public Etudiant ajouterEtudiant(Etudiant e) {
		return this.etudRep.save(e);
	//  public int 
	//etudrep.save(e)
	//return e.getIdEtudiant()
	}

	@Override
	public Etudiant mettreAjourEtudiant(Etudiant e) {
		 Etudiant Etudiant = etudRep.findById(e.getIdEtudiant()).orElse(null);
			if(Etudiant != null)
				etudRep.save(e);
	        return e;
	        // argument int id Etudiant e = etudRep.findById(id).get();
	        //etudRep.save(e)
	        // return(e);
	}

	@Override
	public void supprimerEtudiant(int id) {

		etudRep.deleteById(id);
	}

	@Override
	public List<Etudiant> chercherEtudiants() {

		List<Etudiant> etudiants= etudRep.findAll();
		for (Etudiant etudiant :etudiants){
			log.info("etudiant :"+etudiants);
		}
		return etudiants;
	}


}
