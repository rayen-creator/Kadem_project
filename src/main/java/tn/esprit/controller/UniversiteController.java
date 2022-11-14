package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Persistance.entities.Universite;
import tn.esprit.service.interfaces.UniversiteService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/controllerUniversite")
public class UniversiteController {
    
    @Autowired
    UniversiteService universiteServ;
    
    @GetMapping("/DisplayUniversite")
    public List<Universite> DisplayUniversite() {
        return universiteServ.chercherUniversites();
    }

    @GetMapping("/DisplayUniversiteById/{id}")
    public Universite displayUniversiteByID(@PathVariable("id") int id) {

        return universiteServ.afficherUniversite(id);
    }

    @PostMapping("/AddUniversite")
    public int addUniversite(@RequestBody Universite u) {
        return universiteServ.ajouterUniversite(u);
    }

    @PutMapping("/UpdateUniversite")
    public Universite updateUniversite(@RequestBody Universite u) {
        return universiteServ.mettreAjourUniversite(u);
    }

    @DeleteMapping("/deleteUniversite/{idUniversite}")
    public void deleteUniversite(@PathVariable("idUniversite") int id) {
        universiteServ.supprimerUniversite(id);
    }


}
