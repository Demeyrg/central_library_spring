package com.aleinikov.central_library_spring.dto.mapper;

import com.aleinikov.central_library_spring.dto.BookDTO;
import com.aleinikov.central_library_spring.dto.LibraryDTO;
import com.aleinikov.central_library_spring.entities.Book;
import com.aleinikov.central_library_spring.entities.Library;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LibraryDtoMapper {

    private final BookDtoMapper bookDtoMapper;

    public LibraryDtoMapper(BookDtoMapper bookDtoMapper) {
        this.bookDtoMapper = bookDtoMapper;
    }

    public LibraryDTO libraryToDto(Library library) {
        LibraryDTO libraryDTO = new LibraryDTO();
        libraryDTO.setName(library.getName());
        libraryDTO.setId(library.getId());
        for(Book book : library.returnBooksList()) {
            libraryDTO.addBook(bookDtoMapper.toDto(book));
        }
        return libraryDTO;
    }

    public Library dtoToLibrary(LibraryDTO libraryDTO) {
        Library library = new Library();
        library.setName(libraryDTO.getName());
        library.setId(libraryDTO.getId());
        for (BookDTO bookDTO : libraryDTO.getBooks()) {
            library.addBook(bookDtoMapper.dtoTo(bookDTO));
        }
        return library;
    }

    public List<LibraryDTO> libraryListToDtoLibraryList(List<Library> libraries) {
//        libraries.stream().map(this::libraryToDto).collect(Collectors.toList());
        List<LibraryDTO> librariesDTO = new ArrayList<>();
        for (Library library:libraries) {
            librariesDTO.add(libraryToDto(library));
        }
        return librariesDTO;
    }

    public List<Library> dtoLibraryListToLibraryList(List<LibraryDTO> librariesDTO) {
//        librariesDTO.stream().map(this::dtoToLibrary).collect(Collectors.toList());
        List<Library> libraries = new ArrayList<>();
        for (LibraryDTO library : librariesDTO) {
            libraries.add(dtoToLibrary(library));
        }
        return libraries;
    }
}
