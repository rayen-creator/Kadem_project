package tn.esprit.Persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Persistance.entities.Departement;

@Repository
public interface DepartementRepository extends JpaRepository<Departement,Integer> {
}
