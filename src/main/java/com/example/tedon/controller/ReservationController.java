package com.example.tedon.controller;


import com.example.tedon.dtoReservation.ReservationResponse;
import com.example.tedon.dtoReservation.ReservationResquest;
import com.example.tedon.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reservation")
@AllArgsConstructor
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

//la recherche
    @PostMapping("/create")

    public ReservationResponse create(@RequestBody ReservationResquest reservationResquest){
        return reservationService.create(reservationResquest);

    }
//    public ResponseEntity<ReservationResponse>create(@RequestBody ReservationResquest reservationResquest){
//
//        return new ResponseEntity<>(reservationService.create(reservationResquest), HttpStatus.CREATED);
//   }

    @GetMapping("/get")
    public List<ReservationResponse> getReservation(){
        return reservationService.getAllReservation();

    }
    @GetMapping("/{id}")
    public ResponseEntity<ReservationResponse> getReservationById(@PathVariable Long id){
        return reservationService.getReservationById(id).map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")

    public ReservationResponse update(@PathVariable Long id,@RequestBody ReservationResquest reservationResquest){
        return reservationService.updateById(id,reservationResquest);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Void>deleteAgent(@PathVariable Long id){
        reservationService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
