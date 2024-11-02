package tn.esprit.tpfoyer.control

import lombok.AllArgsConstructor
import org.springframework.web.bind.annotation.*
import tn.esprit.tpfoyer.entity.Etudiant
import tn.esprit.tpfoyer.service.IEtudiantService

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
class EtudiantRestController {
    var etudiantService: IEtudiantService? = null


    @get:GetMapping("/retrieve-all-etudiants")
    val etudiants: List<Etudiant>
        get() {
            val listEtudiants = etudiantService!!.retrieveAllEtudiants()
            return listEtudiants
        }


    @GetMapping("/retrieve-etudiant-cin/{cin}")
    fun retrieveEtudiantParCin(@PathVariable("cin") cin: Long): Etudiant {
        val etudiant = etudiantService!!.recupererEtudiantParCin(cin)
        return etudiant
    }


    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    fun retrieveEtudiant(@PathVariable("etudiant-id") chId: Long?): Etudiant {
        val etudiant = etudiantService!!.retrieveEtudiant(chId)
        return etudiant
    }

    // http://localhost:8089/tpfoyer/etudiant/add-etudiant
    @PostMapping("/add-etudiant")
    fun addEtudiant(@RequestBody c: Etudiant?): Etudiant {
        val etudiant = etudiantService!!.addEtudiant(c)
        return etudiant
    }

    // http://localhost:8089/tpfoyer/etudiant/remove-etudiant/{etudiant-id}
    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    fun removeEtudiant(@PathVariable("etudiant-id") chId: Long?) {
        etudiantService!!.removeEtudiant(chId)
    }

    // http://localhost:8089/tpfoyer/etudiant/modify-etudiant
    @PutMapping("/modify-etudiant")
    fun modifyEtudiant(@RequestBody c: Etudiant?): Etudiant {
        val etudiant = etudiantService!!.modifyEtudiant(c)
        return etudiant
    }
}
