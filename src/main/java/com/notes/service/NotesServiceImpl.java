package com.notes.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notes.model.Notes;
import com.notes.model.NotesContent;
import com.notes.repo.H2DAO;
import com.notes.repo.NotesRepository;

@Service
public class NotesServiceImpl implements NotesService{

	@Autowired
	private NotesRepository repo;
	
	@Autowired
	private H2DAO h2DAO;
	
	@Override
	public NotesContent getNotes(int userName) {
		return repo.getById(userName);
	}

	@Override
	public Notes getNotesForUserName(String userName) {
		Notes notes = new Notes();
		List<NotesContent> notesContents = repo.findAll();
		List<NotesContent> contents = notesContents.stream().filter(e -> {
					if(e.getUserName().equalsIgnoreCase(userName))
						return true;
					else
						return false;
					}).collect(Collectors.toList());
		notes.setUserName(userName);
		notes.setNoteContents(contents);
		return notes;
	}

	@Override
	public void addContent(NotesContent note) {
		repo.save(note);
	}

	@Override
	public boolean deleteContent() {
		return false;
	}

	@Override
	public void initDB() {
		h2DAO.initDB();
	}

}
