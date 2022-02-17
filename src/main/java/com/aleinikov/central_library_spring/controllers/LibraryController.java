package com.aleinikov.central_library_spring.controllers;

import com.aleinikov.central_library_spring.dto.LibraryDTO;
import com.aleinikov.central_library_spring.entities.Library;
import com.aleinikov.central_library_spring.services.LibraryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/library")
    public List<LibraryDTO> findAll() {
        return libraryService.findAll();
    }

    @GetMapping("/library/{id}")
    public LibraryDTO findAllById(@PathVariable Long id) {
        return libraryService.findById(id);
    }

    @PostMapping("/library")
    public LibraryDTO addNewLibrary(@RequestBody Library library) {
        return libraryService.saveLibrary(library);
    }

    @PutMapping("/library/{id}")
    public LibraryDTO updateLibrary(@RequestBody Library library, @PathVariable Long id) {
        return libraryService.update(library,id);
    }

    @DeleteMapping("/library/{id}")
    public ResponseEntity<?> deleteLibrary(@PathVariable Long id) {
        libraryService.deleteLibrary(id);
        return new ResponseEntity<>("Library with ID =" + id + " was deleted", HttpStatus.NO_CONTENT);
    }
}
