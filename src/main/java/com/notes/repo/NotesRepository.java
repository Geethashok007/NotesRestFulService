package com.notes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notes.model.NotesContent;

@Repository
public interface NotesRepository extends JpaRepository<NotesContent, Integer> {
	
}
