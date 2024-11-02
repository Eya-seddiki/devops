package tn.esprit.tpfoyer.control

import lombok.AllArgsConstructor
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.*
import tn.esprit.tpfoyer.entity.Reservation
import tn.esprit.tpfoyer.service.IReservationService
import java.util.*

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
class ReservationRestController {
    var reservationService: IReservationService? = null

    @get:GetMapping("/retrieve-all-reservations")
    val reservations: List<Reservation>
        // http://localhost:8089/tpfoyer/reservation/retrieve-all-reservations
        get() {
            val listReservations = reservationService!!.retrieveAllReservations()
            return listReservations
        }

    // http://localhost:8089/tpfoyer/reservation/retrieve-reservation/8
    @GetMapping("/retrieve-reservation/{reservation-id}")
    fun retrieveReservation(@PathVariable("reservation-id") rId: String?): Reservation {
        val reservation = reservationService!!.retrieveReservation(rId)
        return reservation
    }


    @GetMapping("/retrieve-reservation-date-status/{d}/{v}")
    fun retrieveReservationParDateEtStatus(
        @PathVariable("d") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) d: Date?,
        @PathVariable("v") b: Boolean
    ): List<Reservation> {
        return reservationService!!.trouverResSelonDateEtStatus(d, b)
    }


    // http://localhost:8089/tpfoyer/reservation/add-reservation
    @PostMapping("/add-reservation")
    fun addReservation(@RequestBody r: Reservation?): Reservation {
        val reservation = reservationService!!.addReservation(r)
        return reservation
    }

    // http://localhost:8089/tpfoyer/reservation/remove-reservation/{reservation-id}
    @DeleteMapping("/remove-reservation/{reservation-id}")
    fun removeReservation(@PathVariable("reservation-id") rId: String?) {
        reservationService!!.removeReservation(rId)
    }

    // http://localhost:8089/tpfoyer/reservation/modify-reservation
    @PutMapping("/modify-reservation")
    fun modifyReservation(@RequestBody r: Reservation?): Reservation {
        val reservation = reservationService!!.modifyReservation(r)
        return reservation
    }
}
