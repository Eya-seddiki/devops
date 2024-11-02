package tn.esprit.tpfoyer.control

import lombok.AllArgsConstructor
import org.springframework.web.bind.annotation.*
import tn.esprit.tpfoyer.entity.Universite
import tn.esprit.tpfoyer.service.IUniversiteService

@RestController
@AllArgsConstructor
@RequestMapping("/universite")
class UniversiteRestController {
    var universiteService: IUniversiteService? = null

    @get:GetMapping("/retrieve-all-universites")
    val universites: List<Universite>
        // http://localhost:8089/tpfoyer/universite/retrieve-all-universites
        get() {
            val listUniversites = universiteService!!.retrieveAllUniversites()
            return listUniversites
        }

    // http://localhost:8089/tpfoyer/universite/retrieve-universite/8
    @GetMapping("/retrieve-universite/{universite-id}")
    fun retrieveUniversite(@PathVariable("universite-id") uId: Long?): Universite {
        val universite = universiteService!!.retrieveUniversite(uId)
        return universite
    }

    // http://localhost:8089/tpfoyer/universite/add-universite
    @PostMapping("/add-universite")
    fun addUniversite(@RequestBody u: Universite?): Universite {
        val universite = universiteService!!.addUniversite(u)
        return universite
    }

    // http://localhost:8089/tpfoyer/universite/remove-universite/{universite-id}
    @DeleteMapping("/remove-universite/{universite-id}")
    fun removeUniversite(@PathVariable("universite-id") uId: Long?) {
        universiteService!!.removeUniversite(uId)
    }

    // http://localhost:8089/tpfoyer/universite/modify-universite
    @PutMapping("/modify-universite")
    fun modifyUniversite(@RequestBody u: Universite?): Universite {
        val universite = universiteService!!.modifyUniversite(u)
        return universite
    }
}
