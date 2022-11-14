package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.Persistance.entities.Equipe;
import tn.esprit.service.interfaces.EquipeService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/controllerEquipe")
public class EquipeController {
	
	@Autowired
	EquipeService equipeServ;


	@GetMapping("/DisplayEquipes")
	public List<Equipe> DisplayEquipe() {
		return equipeServ.chercherEquipes();
	}

	@GetMapping("/DisplayEquipeById/{id}")
	public Equipe displayEquipeByID(@PathVariable("id") int id) {

		return equipeServ.afficherEquipe(id);
	}

	@PostMapping("/AddEquipe")
	public int addEquipe(@RequestBody Equipe e) {
		return equipeServ.ajouterEquipe(e);
	}

	@PutMapping("/UpdateEquipe")
	public Equipe updateEquipe(@RequestBody Equipe e) {
		return equipeServ.mettreAjourEquipe(e);
	}

	@DeleteMapping("/deleteEquipe/{idEquipe}")
	public void deleteEquipe(@PathVariable("idEquipe") int id) {
		equipeServ.supprimerEquipe(id);
	}

}
