package com.notes.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.notes.model.Notes;
import com.notes.model.NotesContent;
import com.notes.service.NotesService;

@RestController
public class NotesController {

	@Autowired
	private NotesService notesService;
	
	@GetMapping("/notes")
	public Notes getNotesforUser() {
		return notesService.getNotesForUserName("gm293");
	}
	
	@PostMapping("/notes")
	public NotesContent addNotesContent(@RequestBody NotesContent content) {
		notesService.addContent(content);
		return content;
	}
	
	@GetMapping("/")
	public void initDB(HttpServletRequest request, HttpServletResponse response) throws IOException {
		notesService.initDB();
		response.sendRedirect("/notesApi/notes");
	}
}
