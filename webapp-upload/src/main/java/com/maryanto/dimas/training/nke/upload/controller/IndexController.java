package com.maryanto.dimas.training.nke.upload.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

@Controller
public class IndexController {

    @Value("${server.upload_dir}")
    private String UPLOAD_DIRECTORY;

    @GetMapping("/")
    public String index(Model mav) {
        mav.addAttribute("user", "Dimas Maryanto");
        mav.addAttribute("tanggal", LocalDate.now().toString());
        return "index";
    }

    @PostMapping("/upload")
    public String uploadImage(Model model, @RequestParam("image") MultipartFile file)
            throws IOException {
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
        if (!Files.exists(Paths.get(UPLOAD_DIRECTORY))) {
            Files.createDirectory(Paths.get(UPLOAD_DIRECTORY));
        }
        fileNames.append(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());
        model.addAttribute("msg", "Uploaded images: " + fileNames.toString());
        return "index";
    }
}
