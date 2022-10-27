package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Persistance.entities.Departement;
import tn.esprit.service.interfaces.DepartementService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/controllerDepartement")
public class DepartementController {
    @Autowired
    DepartementService departService;


    @GetMapping("/DisplayDepartements")
    public List<Departement> DisplayDepartement() {
        return departService.chercherDepartement();
    }

    @GetMapping("/DisplayDepartementById")
    public Departement displayDepartementByID(@PathParam("id") int id) {

        return departService.afficherDepartement(id);
    }

    @PostMapping("/AddDepartement")
    public Departement addDepartement(@RequestBody Departement e) {
        return departService.ajouterDepartement(e);
    }

    @PutMapping("/UpdateDepartement")
    public Departement updateDepartement(@RequestBody Departement e) {
        return departService.mettreAjourDepartement(e);
    }

    @DeleteMapping("/deleteDepartement/{idDepartement}")
    public void deleteDepartement(@PathVariable("idDepartement") int id) {
        departService.supprimerDepartement(id);
    }

}
