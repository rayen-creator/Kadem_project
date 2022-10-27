package tn.esprit.Persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Persistance.entities.Universite;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite,Integer> {
}
