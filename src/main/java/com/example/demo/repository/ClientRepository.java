package com.example.demo.repository;

import com.example.demo.model.Client.Client;
import com.example.demo.model.Client.ClientCompositeKey;
import com.example.demo.model.PaymentType;
import com.example.demo.model.Reservation.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, ClientCompositeKey> {

    @Query(value="select * from Client where user_id=?",nativeQuery = true)
    Optional<Client> findClient(Integer user_id);

    @Query(value="select * from Client ", nativeQuery = true)
    public Optional<Client> findAllClients();

    @Query(value=" select c.user_id,sum(mp.projection_price) as vkupna_potroshuvacka,u.user_name,u.user_surname from users as u\n" +
            "     join client as c on c.user_id = u.user_id\n" +
            "     join reservation as r on r.user_id = c.user_id\n" +
            "     and r.reservation_date between now() - interval '1 year' and now()\n" +
            "     join movieprojection as mp on mp.projection_id = r.projection_id\n" +
            "     where mp.projection_id = ?\n" +
            "     group by c.user_id,u.user_name,u.user_surname\n" +
            "     order by vkupna_potroshuvacka desc\n" +
            "     limit 1;;",nativeQuery = true)
    public List<Client> findBestClient(Integer projection_id);


    @Query(value="select distinct u.user_id,c.client_id, u.user_name,u.user_surname,\n" +
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
            " \torder by u.user_name",nativeQuery = true)
    List<Client> findByUsersStats();
}