package com.example.demo.service.ServiceImpl;

import com.example.demo.model.*;
import com.example.demo.model.Client.Client;
import com.example.demo.model.Client.ClientCompositeKey;
import com.example.demo.model.Reservation.Reservations;
import com.example.demo.model.Seat.Seat;
import com.example.demo.model.Seat.SeatCompositeKey;
import com.example.demo.repository.*;
import com.example.demo.service.MovieProjectionService;
import com.example.demo.service.ReservationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final PaymentTypeRepository paymentTypeRepository;
    private final ClientRepository clientRepository;
    private final SeatRepository seatRepository;
    private final AuditoriumRepository auditoriumRepository;
    private final UserRepository userRepository;
    private final MovieProjectionService movieProjectionService;
    private final PaymentRepository paymentRepository;
    private final ReservationsRepository reservationsRepository;
    public ReservationServiceImpl(PaymentTypeRepository paymentTypeRepository, ClientRepository clientRepository, SeatRepository seatRepository, AuditoriumRepository auditoriumRepository, UserRepository userRepository, MovieProjectionService movieProjectionService, PaymentRepository paymentRepository, ReservationsRepository reservationsRepository) {
        this.paymentTypeRepository = paymentTypeRepository;
        this.clientRepository = clientRepository;
        this.seatRepository = seatRepository;
        this.auditoriumRepository = auditoriumRepository;
        this.userRepository = userRepository;
        this.movieProjectionService = movieProjectionService;
        this.paymentRepository = paymentRepository;
        this.reservationsRepository = reservationsRepository;
    }

    @Override
    @Transactional
    public Optional<Reservations> save(
            Integer reservation_id,
            String reservation_end_date,
            Integer payment_type_id,
            Integer user_id,
            Integer seat_id,
            Integer auditorium_id,
            Integer projection_id) {

        PaymentType paymentType = this.paymentTypeRepository.findById(payment_type_id).get();


        User user = this.userRepository.findById(String.valueOf(user_id)).get();
        ClientCompositeKey clientCompositeKey = new ClientCompositeKey();
        clientCompositeKey.setUser(user);
        Client client = this.clientRepository.findById(clientCompositeKey).get();


        SeatCompositeKey seatCompositeKey = new SeatCompositeKey();
        seatCompositeKey.setSeat_id(seat_id);
        Auditorium auditorium = this.auditoriumRepository.findById(auditorium_id).get();
        seatCompositeKey.setAuditorium(auditorium);
        Seat seat = seatRepository.findById(seatCompositeKey).get();

        MovieProjection movieProjection = movieProjectionService.findById(projection_id).get();


        /*
        return Optional.of(this.reservationsRepository.save(new Reservations(reservation_id,reservation_end_date,paymentType,
                seat,client,movieProjection)));
    }

         */
        return null;
    }
    @Override
    public Optional<Reservations> findAll() {
        return this.reservationsRepository.findAllReservations();
    }
}
