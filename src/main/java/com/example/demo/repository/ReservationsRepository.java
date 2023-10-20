package com.example.demo.repository;

import com.example.demo.model.Client.Client;
import com.example.demo.model.Gives.Gives;
import com.example.demo.model.Reservation.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ReservationsRepository extends JpaRepository<Reservations, Integer> {

    @Query(value="select * from reservation",nativeQuery = true)
    Optional<Reservations> findAllReservations();

    @Query(value = "select * from reservation where projection_id=?", nativeQuery = true)
    public List<Reservations> findByProjectionId(Integer projection_id);

    @Query(value= "select * from reservation",nativeQuery = true)
    public Optional<Reservations> findAllRes();

    @Query(value="select distinct r.reservation_id,mp.projection_id,payment_type_id,auditorium_id,seat_id,reservation_date,u.user_id,c.client_id, u.user_name,u.user_surname,\n" +
            "    case when tabela.quarter=1 then tabela.broj_kupeni else 0 end as prv_kvartal_kupeni,\n" +
            "   \tcase when tabela.quarter=2 then tabela.broj_kupeni  else 0 end as vtor_kvartal_kupeni,\n" +
            "    case when tabela.quarter=3 then tabela.broj_kupeni  else 0 end as tret_kvartal_kupeni,\n" +
            "    case when tabela.quarter=4 then tabela.broj_kupeni else 0 end as cetvrt_kvartal_kupeni,\n" +
            "    -------------------------------------------------------------------------------\n" +
            "    tabela.suma as sum_quarter\n" +
            "    \n" +
            "    \n" +
            " \tfrom reservation as r\n" +
            " \tjoin client as c on c.user_id = r.user_id\n" +
            " \tjoin movieprojection as mp on mp.projection_id = r.projection_id \n" +
            " \tjoin users as u on u.user_id = c.user_id\n" +
            " \tjoin(\n" +
            " \tselect c2.user_id,extract(quarter from r2.reservation_date) as quarter,sum(mp.projection_price) as suma,\n" +
            " \tcount(r2.reservation_id) as broj_kupeni\n" +
            " \tfrom reservation as r2\n" +
            " \tjoin movieprojection as mp on mp.projection_id  = r2.projection_id\n" +
            " \tjoin client as c2 on c2.user_id = r2.user_id\n" +
            " \tgroup by 1,2\n" +
            " \t) as tabela on c.user_id = tabela.user_id\n" +
            " \torder by r.reservation_id,mp.projection_id,u.user_name",nativeQuery = true)
    List<Reservations> findByUsersStats();



}