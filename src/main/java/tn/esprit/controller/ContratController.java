package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Persistance.entities.Contrat;
import tn.esprit.service.interfaces.ContratService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/controllerContrat")
public class ContratController {

    @Autowired
    ContratService contratServ;


    @GetMapping("/Displaycontrats")
    public List<Contrat> Displaycontrats() {
        return contratServ.chercherContrat();
    }

    @GetMapping("/DisplayContratById")
    public Contrat displayContratByID(@PathParam("id") int id) {

        return contratServ.afficherContrat(id);
    }

    @PostMapping("/AddContrat")
    public Contrat addContrat(@RequestBody Contrat e) {
        return contratServ.ajouterContrat(e);
    }

    @PutMapping("/UpdateContrat")
    public Contrat updateContrat(@RequestBody Contrat e) {
        return contratServ.mettreAjourContrat(e);
    }

    @DeleteMapping("/deleteContrat/{idContrat}")
    public void deleteContrat(@PathVariable("idContrat") int id) {
        contratServ.supprimerContrat(id);
    }
}
