package com.example.demo.controller;


import com.example.demo.model.Auditorium;
import com.example.demo.model.Client.Client;
import com.example.demo.model.MovieProjection;
import com.example.demo.model.PaymentType;
import com.example.demo.model.Reservation.Reservations;
import com.example.demo.model.Seat.Seat;
import com.example.demo.repository.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/reserve")
public class ReserveController {


    private final SeatRepository seatRepository;
    private final AuditoriumRepository auditoriumRepository;
    private final PaymentTypeRepository paymentTypeRepository;
    private final MovieProjectionRepository movieProjectionRepository;
    private final ClientRepository clientRepository;
    private final ReservationsRepository reservationsRepository;

    public ReserveController(SeatRepository seatRepository, AuditoriumRepository auditoriumRepository, PaymentTypeRepository paymentTypeRepository, MovieProjectionRepository movieProjectionRepository, ClientRepository clientRepository, ReservationsRepository reservationsRepository) {
        this.seatRepository = seatRepository;
        this.auditoriumRepository = auditoriumRepository;
        this.paymentTypeRepository = paymentTypeRepository;
        this.movieProjectionRepository = movieProjectionRepository;
        this.clientRepository = clientRepository;
        this.reservationsRepository = reservationsRepository;
    }
//    @PreAuthorize("hasRole('ROLE_EMPLOYEE')" +
//           " || hasRole('Client')" )
    @RequestMapping("/projection")
    public String viewReservationDetail(@RequestParam(value = "projection_id", required = false) Integer projection_id, Model model) {
        List<Seat> seats11 = seatRepository.SelectionByProjection(projection_id);
        List<Seat> seatsAll = seatRepository.selectFreeSeatsByProjection(projection_id);
        List<Auditorium> auditoriums = auditoriumRepository.SelectAuditoriumsByProjection(projection_id);
        List<PaymentType> paymentType = paymentTypeRepository.findAll();
        List<MovieProjection> projections = movieProjectionRepository.findProjectionsById(projection_id);
        List<Client> client = clientRepository.findAll();
        List<Reservations> reservations = reservationsRepository.findAll();
        model.addAttribute("projection_id",projection_id);
        model.addAttribute("seatsAll",seatsAll);
        model.addAttribute("projections",projections);
        model.addAttribute("paymentType", paymentType);
        model.addAttribute("auditorium",auditoriums);
        model.addAttribute("seats11",seats11);
        model.addAttribute("client",client);
        model.addAttribute("reservation",reservations);

        return "reserve";
    }
//    @PreAuthorize("hasRole('ROLE_EMPLOYEE')" +
//            " && hasRole('Client')" )
    @PostMapping("/projection/add")
    public String addReservation(
            @RequestParam(value = "auditorium_id", required = false) Integer auditorium_id, Model model,
            @RequestParam(value = "payment_type_id", required = false) Integer payment_type_id,
            @RequestParam(value = "seat_id", required = false) Integer seat_id,
            @RequestParam(value = "projection_id", required = false) Integer projection_id,
            @RequestParam(value = "user_id", required = false) Integer user_id
    ){

        PaymentType paymentType1337 = paymentTypeRepository.findById(payment_type_id).get();
        Seat seat = seatRepository.findSeatAuditorium(seat_id,auditorium_id).get();
        MovieProjection movieProjection = movieProjectionRepository.findById(projection_id).get();
        Client client = clientRepository.findClient(user_id).get();
        Reservations reservations = new Reservations();
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        //////////ID-FUNCTION/////////////
        List<Reservations> reservationsList = reservationsRepository.findAll();
        Integer myID = reservationsList.size()+2;
        reservations.setReservation_id(myID);
        //////////ID-FUNCTION//////////////
        reservations.setReservation_date(localDateTime);
        reservations.setPaymentType(paymentType1337);
        reservations.setSeat(seat);
        reservations.setClient(client);
        reservations.setMovieProjection(movieProjection);
        this.reservationsRepository.save(reservations);
        return "redirect:/movies";
    }


}
