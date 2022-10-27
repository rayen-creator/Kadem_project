package tn.esprit.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.service.interfaces.EtudiantService;
import tn.esprit.Persistance.entities.Etudiant;;

@RestController
@RequestMapping("/controllerEtudiant")
public class EtudiantController {

    @Autowired
    EtudiantService etudserv;



    @GetMapping("/DisplayStudents")
    public List<Etudiant> DisplayStudents() {
        return etudserv.chercherEtudiants();
    }

    @GetMapping("/DisplayEtudiantById/{id}")
    public Etudiant displayEtudiantByID(@PathVariable("id") int id) {

        return etudserv.afficherEtudiant(id);
    }

    @PostMapping("/AddEtudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        return etudserv.ajouterEtudiant(e);
    }

    @PutMapping("/UpdateEtudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        return etudserv.mettreAjourEtudiant(e);
    }

    @DeleteMapping("/deleteEtudiant/{id}")
    public void deleteEudiant(@PathVariable("id") int id) {
        etudserv.supprimerEtudiant(id);
    }
}
