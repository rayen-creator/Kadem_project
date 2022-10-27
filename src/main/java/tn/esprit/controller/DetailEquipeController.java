package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Persistance.entities.DetailEquipe;
import tn.esprit.service.interfaces.DetailEquipeService;
import tn.esprit.service.interfaces.DetailEquipeService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/controllerDetailEquipe")
public class DetailEquipeController {

    @Autowired
    DetailEquipeService DetailEquipeServ;



    @GetMapping("/DisplayDetailEquipe")
    public List<DetailEquipe> DisplayDetailEquipe() {
        
        return DetailEquipeServ.chercherDetailEquipe();
    }

    @GetMapping("/DisplayDetailEquipeById")
    public DetailEquipe displayDetailEquipeByID(@PathParam("id") int id) {

        return DetailEquipeServ.afficherDetailEquipe(id);
    }

    @PostMapping("/AddDetailEquipe")
    public DetailEquipe addDetailEquipe(@RequestBody DetailEquipe e) {
        
        return DetailEquipeServ.ajouterDetailEquipe(e);
    }

    @PutMapping("/UpdateDetailEquipe")
    public DetailEquipe updateDetailEquipe(@RequestBody DetailEquipe e) {
        return DetailEquipeServ.mettreAjourDetailEquipe(e);
    }

    @DeleteMapping("/deleteDetailEquipe/{idDetailEquipe}")
    public void deleteDetailEquipe(@PathVariable("idDetailEquipe") int id) {
        DetailEquipeServ.supprimerDetailEquipe(id);
    }

}
