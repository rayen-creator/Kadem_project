package tn.esprit.Persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Persistance.entities.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository <Etudiant, Integer> {

	
}
