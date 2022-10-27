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

    @GetMapping("/DisplayUniversiteById")
    public Universite displayUniversiteByID(@PathParam("id") int id) {

        return universiteServ.afficherUniversite(id);
    }

    @PostMapping("/AddUniversite")
    public Universite addUniversite(@RequestBody Universite e) {
        return universiteServ.ajouterUniversite(e);
    }

    @PutMapping("/UpdateUniversite")
    public Universite updateUniversite(@RequestBody Universite e) {
        return universiteServ.mettreAjourUniversite(e);
    }

    @DeleteMapping("/deleteUniversite/{idUniversite}")
    public void deleteUniversite(@PathVariable("idUniversite") int id) {
        universiteServ.supprimerUniversite(id);
    }


}
