package com.example.demo.controller;

import com.example.demo.model.Client.Client;
import com.example.demo.model.Genre;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.FirmRepository;
import com.example.demo.repository.GenreRepository;
import com.example.demo.repository.ReservationsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final ReservationsRepository reservationsRepository;
    private final FirmRepository firmRepository;
    private final ClientRepository clientRepository;
    private final GenreRepository genreRepository;

    public EmployeeController(ReservationsRepository reservationsRepository, FirmRepository firmRepository, ClientRepository clientRepository, GenreRepository genreRepository) {
        this.reservationsRepository = reservationsRepository;
        this.firmRepository = firmRepository;
        this.clientRepository = clientRepository;
        this.genreRepository = genreRepository;
    }

    @GetMapping
    public String getMoviePage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        Collection<Client> clients = this.clientRepository.findByUsersStats();
        model.addAttribute("clients", clients);
        return "employee";
    }


}
