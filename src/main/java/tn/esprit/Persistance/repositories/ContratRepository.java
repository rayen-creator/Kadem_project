package tn.esprit.Persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Persistance.entities.Contrat;

@Repository
public interface ContratRepository extends JpaRepository<Contrat,Integer> {
}
