package tn.esprit.tpfoyer.control

import lombok.AllArgsConstructor
import org.springframework.web.bind.annotation.*
import tn.esprit.tpfoyer.entity.Chambre
import tn.esprit.tpfoyer.entity.TypeChambre
import tn.esprit.tpfoyer.service.IChambreService

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
class ChambreRestController {
    var chambreService: IChambreService? = null

    @get:GetMapping("/retrieve-all-chambres")
    val chambres: List<Chambre>
        // http://localhost:8089/tpfoyer/chambre/retrieve-all-chambres
        get() {
            val listChambres = chambreService!!.retrieveAllChambres()
            return listChambres
        }


    @GetMapping("/retrieve-chambre/{chambre-id}")
    fun retrieveChambre(@PathVariable("chambre-id") chId: Long?): Chambre {
        val chambre = chambreService!!.retrieveChambre(chId)
        return chambre
    }

    // http://localhost:8089/tpfoyer/chambre/add-chambre
    @PostMapping("/add-chambre")
    fun addChambre(@RequestBody c: Chambre?): Chambre {
        val chambre = chambreService!!.addChambre(c)
        return chambre
    }

    // http://localhost:8089/tpfoyer/chambre/remove-chambre/{chambre-id}
    @DeleteMapping("/remove-chambre/{chambre-id}")
    fun removeChambre(@PathVariable("chambre-id") chId: Long?) {
        chambreService!!.removeChambre(chId)
    }

    // http://localhost:8089/tpfoyer/chambre/modify-chambre
    @PutMapping("/modify-chambre")
    fun modifyChambre(@RequestBody c: Chambre?): Chambre {
        val chambre = chambreService!!.modifyChambre(c)
        return chambre
    }


    @GetMapping("/trouver-chambres-selon-typ/{tc}")
    fun trouverChSelonTC(@PathVariable("tc") tc: TypeChambre?): List<Chambre> {
        return chambreService!!.recupererChambresSelonTyp(tc)
    }


    // http://localhost:8089/tpfoyer/chambre/retrieve-chambre/8
    @GetMapping("/trouver-chambre-selon-etudiant/{cin}")
    fun trouverChSelonEt(@PathVariable("cin") cin: Long): Chambre {
        val chambre = chambreService!!.trouverchambreSelonEtudiant(cin)
        return chambre
    }
}
