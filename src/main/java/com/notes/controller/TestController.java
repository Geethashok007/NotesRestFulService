//package com.notes.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.notes.model.NotesContent;
//import com.notes.service.NotesService;
//
//@RestController
//public class TestController {
//
//	@Autowired
//	private NotesService notesService;
//	
//	@RequestMapping("/notes")
//	public NotesContent test() {
//		
//		return notesService.getNotes(1);
//	}
//	
//	@PostMapping("/notes")
//	public NotesContent addNotes(@RequestBody NotesContent note) {
//		notesService.addContent(note);
//		return note;
//	}
//}
