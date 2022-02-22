package com.aleinikov.central_library_spring.services;

import com.aleinikov.central_library_spring.dto.LibraryDTO;
import com.aleinikov.central_library_spring.dto.mapper.LibraryDtoMapper;
import com.aleinikov.central_library_spring.entities.Library;
import com.aleinikov.central_library_spring.exception_hadnlers.exceptions.LibraryNotFoundException;
import com.aleinikov.central_library_spring.repositories.BookRepository;
import com.aleinikov.central_library_spring.repositories.LibraryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LibraryService {

    private final LibraryRepository libraryRepository;

    private final LibraryDtoMapper libraryDtoMapper;

    private final BookRepository bookRepository;

    public LibraryService(LibraryRepository libraryRepository,
                          LibraryDtoMapper libraryDtoMapper,
                          BookRepository bookRepository) {
        this.libraryRepository = libraryRepository;
        this.libraryDtoMapper = libraryDtoMapper;
        this.bookRepository = bookRepository;
    }

    @Transactional(readOnly = true)
    public List<LibraryDTO> findAll() {
        List<Library> libraryList = libraryRepository.findAll();
        for (Library library : libraryList) {
            library.setBooks(bookRepository.findBooksByLibrary(library));
        }
        return libraryDtoMapper.libraryListToDtoLibraryList(libraryList);
    }

    @Transactional(readOnly = true)
    public LibraryDTO findById(Long id) {
        Library library = libraryRepository.findById(id).orElseThrow(() -> new LibraryNotFoundException(id));
        return libraryDtoMapper.libraryToDto(library);
    }


    public LibraryDTO saveLibrary(Library library) {
        return libraryDtoMapper.libraryToDto(libraryRepository.save(library));
    }


    public LibraryDTO update(Library library, Long id) {
        findById(id);
        library.setId(id);
        return libraryDtoMapper.libraryToDto(library);
    }

    public void deleteLibrary(Long id) {
        Library library = libraryRepository.findById(id).orElseThrow(() -> new LibraryNotFoundException(id));
        libraryRepository.delete(library);
    }
}