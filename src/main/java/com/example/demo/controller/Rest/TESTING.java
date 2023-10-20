package com.example.demo.controller.Rest;




import com.example.demo.model.*;
import com.example.demo.model.Client.Client;
import com.example.demo.model.Gives.Gives;
import com.example.demo.model.Gives.GivesKey;
import com.example.demo.model.IS_.MovieGenreCombination;
import com.example.demo.model.IS_.MovieGenreKey;
import com.example.demo.model.Reservation.Reservations;
import com.example.demo.model.Seat.Seat;
import com.example.demo.model.Seat.SeatCompositeKey;
import com.example.demo.repository.*;
import com.example.demo.service.AuthService;
import com.example.demo.service.MovieProjectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


@RestController
@RequestMapping("/tests")
public class TESTING {

    private final MovieProjectionRepository movieProjectionRepository;
    private final MovieRepository movieRepository;
    private final AuthService authService;
    private final UserRepository userRepository;
    private final SeatRepository seatRepository;
    private final ClientRepository clientRepository;
    private final Works_inRepository worksInRepository;
    private final ReservationsRepository reservationsRepository;
    private final PaymentRepository paymentRepository;
    private final MovieGenreCombinationRepository movieGenreCombinationRepository;
    private final GivesRepository givesRepository;
    private final AuditoriumRepository auditoriumRepository;
    private final PaymentTypeRepository paymentTypeRepository;
    private final MovieProjectionService movieProjectionService;
    private final GenreRepository genreRepository;

    public TESTING(MovieProjectionRepository movieProjectionRepository, MovieRepository movieRepository, AuthService authService, UserRepository userRepository, SeatRepository seatRepository, ClientRepository clientRepository, Works_inRepository worksInRepository, ReservationsRepository reservation1Repository, ReservationsRepository reservationsRepository, PaymentRepository paymentRepository, MovieGenreCombinationRepository movieGenreCombinationRepository, GivesRepository givesRepository, AuditoriumRepository auditoriumRepository, PaymentTypeRepository paymentTypeRepository, MovieProjectionService movieProjectionService, GenreRepository genreRepository) {
        this.movieProjectionRepository = movieProjectionRepository;
        this.movieRepository = movieRepository;
        this.authService = authService;
        this.userRepository = userRepository;
        this.seatRepository = seatRepository;
        this.clientRepository = clientRepository;
        this.worksInRepository = worksInRepository;
        this.reservationsRepository = reservationsRepository;
        this.paymentRepository = paymentRepository;
        this.movieGenreCombinationRepository = movieGenreCombinationRepository;
        this.givesRepository = givesRepository;
        this.auditoriumRepository = auditoriumRepository;
        this.paymentTypeRepository = paymentTypeRepository;
        this.movieProjectionService = movieProjectionService;
        this.genreRepository = genreRepository;
    }

    @GetMapping
    public ResponseEntity viewQuery() {

/*
        PaymentType paymentType = this.paymentTypeRepository.findById(12365).get();
        User user = this.userRepository.findById(32423).get();
        ClientCompositeKey clientCompositeKey = new ClientCompositeKey();
        clientCompositeKey.setUser(user);
        Client client = this.clientRepository.findById(clientCompositeKey).get();
        SeatCompositeKey seatCompositeKey = new SeatCompositeKey();
        seatCompositeKey.setSeat_id(100);
        Auditorium auditorium = this.auditoriumRepository.findById(1).get();
        seatCompositeKey.setAuditorium(auditorium);
        Seat seat = seatRepository.findById(seatCompositeKey).get();
        MovieProjection movieProjection = movieProjectionService.findById(12732).get();
        Payment payment = paymentRepository.findById(163216).get();


 */
        //PaymentType paymentType =  this.paymentTypeRepository.findAllPayments().get();
        //User user = this.userRepository.findAll().get();
//
//        Seat seat123123 = new Seat();
//        GivesKey givesKey;
//        Optional<Gives> gives = givesRepository.findAllByProjectionId(12732);
//
//
//        MovieProjection projection = movieProjectionRepository.findById(12732).get();
//        Auditorium auditorium = auditoriumRepository.findById(1).get();
//
//
//        SeatCompositeKey seatCompositeKey = new SeatCompositeKey();
//        seatCompositeKey.setAuditorium(auditorium);
//        for(int i=0;i<37;i++)
//            seatCompositeKey.setSeat_id(i);
//
//        Seat seat = new Seat();
//        seat.setSeatCompositeKey(seatCompositeKey);
//
//        for(int i=0;i<auditorium.getAuditorium_capacity();i++)
//            seat.setSeat_number(i);
//
//        List<Reservations> reserve = new ArrayList<>();
//        reserve = reservationsRepository.findByProjectionId(12732);
//
//        List<Seat> seat10 = seatRepository.selectFreeSeatsByProjection(12732);
//
//        List<Auditorium> auditoriums = auditoriumRepository.SelectAuditoriumsByProjection(12732);
//
//        List<MovieProjection> projections = movieProjectionRepository.findProjectionsById(12732);
//
//
//
//        LocalDateTime localDateTime = LocalDateTime.now();
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//
//
//        List<Reservations> reservationsList = reservationsRepository.findAll();
//
//
//        List<Genre> genres1 = genreRepository.SelectTopThree();
//
//        List<Client> client223=clientRepository.findBestClient(12732);


        SeatCompositeKey seatCompositeKey = new SeatCompositeKey();

        for (int i = 1; i <= 50; i++) {
            seatCompositeKey.setSeat_id(i);
            seatCompositeKey.setAuditorium(this.auditoriumRepository.findById(1).get());
        }
        Seat seat = new Seat();
        seat.setSeatCompositeKey(seatCompositeKey);
        for (int i = 1; i <= 50; i++) {
            seat.setSeat_number(i);
        }
        return ResponseEntity.ok(seat);
    }

}
