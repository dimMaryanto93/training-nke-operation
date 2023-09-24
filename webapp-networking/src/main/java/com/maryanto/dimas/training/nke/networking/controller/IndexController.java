package com.maryanto.dimas.training.nke.networking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model mav) {
        mav.addAttribute("user", "Dimas Maryanto");
        mav.addAttribute("tanggal", LocalDate.now().toString());
        return "index";
    }
}
