package tn.esprit.tpfoyer.control

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import lombok.AllArgsConstructor
import org.springframework.web.bind.annotation.*
import tn.esprit.tpfoyer.entity.Bloc
import tn.esprit.tpfoyer.service.IBlocService


@Tag(name = "Gestion Bloc pour l'équipe 4DS9")
@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
class BlocRestController {
    var blocService: IBlocService? = null
//managment

    @get:Operation(description = "WS de récuperation de tous les Blocs ")
    @get:GetMapping("/retrieve-all-blocs")
    val blocs: List<Bloc>
        //http://localhost:8089/tpfoyer/bloc/retrieve-all-blocs
        get() = blocService!!.retrieveAllBlocs()
    //return listBlocs;

//return
    // http://localhost:8089/tpfoyer/bloc/retrieve-bloc/8
    @GetMapping("/retrieve-bloc/{bloc-id}")
    fun retrieveBloc(@PathVariable("bloc-id") bId: Long?): Bloc {
        val bloc = blocService!!.retrieveBloc(bId)
        return bloc
    }

    // http://localhost:8089/tpfoyer/bloc/add-bloc
    @PostMapping("/add-bloc")
    fun addBloc(@RequestBody c: Bloc?): Bloc {
        val bloc = blocService!!.addBloc(c)
        return bloc
    }

    // http://localhost:8089/tpfoyer/bloc/remove-bloc/{bloc-id}
    @DeleteMapping("/remove-bloc/{bloc-id}")
    fun removeBloc(@PathVariable("bloc-id") chId: Long?) {
        blocService!!.removeBloc(chId)
    }

    // http://localhost:8089/tpfoyer/bloc/modify-bloc
    @PutMapping("/modify-bloc")
    fun modifyBloc(@RequestBody c: Bloc?): Bloc {
        val bloc = blocService!!.modifyBloc(c)
        return bloc
    }

    @get:GetMapping("/trouver-blocs-sans-foyer")
    val blocswirhoutFoyer: List<Bloc>
        get() {
            val listBlocs = blocService!!.trouverBlocsSansFoyer()
            return listBlocs
        }

    @GetMapping("/get-bloc-nb-c/{nb}/{c}")
    fun recuperBlocsParNomEtCap(
        @PathVariable("nb") nb: String?,
        @PathVariable("c") c: Long
    ): List<Bloc> {
        return blocService!!.trouverBlocsParNomEtCap(nb, c)
    }
}
