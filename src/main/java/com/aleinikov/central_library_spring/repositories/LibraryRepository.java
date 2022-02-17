package com.aleinikov.central_library_spring.repositories;

import com.aleinikov.central_library_spring.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
}
