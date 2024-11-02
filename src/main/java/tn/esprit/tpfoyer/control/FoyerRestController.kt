package tn.esprit.tpfoyer.control

import lombok.AllArgsConstructor
import org.springframework.web.bind.annotation.*
import tn.esprit.tpfoyer.entity.Foyer
import tn.esprit.tpfoyer.service.IFoyerService

@RestController
@AllArgsConstructor
@RequestMapping("/foyer")
class FoyerRestController {
    var foyerService: IFoyerService? = null

    @get:GetMapping("/retrieve-all-foyers")
    val foyers: List<Foyer>
        // http://localhost:8089/tpfoyer/foyer/retrieve-all-foyers
        get() {
            val listFoyers = foyerService!!.retrieveAllFoyers()
            return listFoyers
        }

    // http://localhost:8089/tpfoyer/foyer/retrieve-foyer/8
    @GetMapping("/retrieve-foyer/{foyer-id}")
    fun retrieveFoyer(@PathVariable("foyer-id") fId: Long?): Foyer {
        val foyer = foyerService!!.retrieveFoyer(fId)
        return foyer
    }

    // http://localhost:8089/tpfoyer/foyer/add-foyer
    @PostMapping("/add-foyer")
    fun addFoyer(@RequestBody f: Foyer?): Foyer {
        val foyer = foyerService!!.addFoyer(f)
        return foyer
    }

    // http://localhost:8089/tpfoyer/foyer/remove-foyer/{foyer-id}
    @DeleteMapping("/remove-foyer/{foyer-id}")
    fun removeFoyer(@PathVariable("foyer-id") fId: Long?) {
        foyerService!!.removeFoyer(fId)
    }

    // http://localhost:8089/tpfoyer/foyer/modify-foyer
    @PutMapping("/modify-foyer")
    fun modifyFoyer(@RequestBody f: Foyer?): Foyer {
        val foyer = foyerService!!.modifyFoyer(f)
        return foyer
    }
}
