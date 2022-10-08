package com.notes.service;

import com.notes.model.Notes;
import com.notes.model.NotesContent;

public interface NotesService {
	
	public NotesContent getNotes(int userName);
	public void addContent(NotesContent note);
	public boolean deleteContent();
	public Notes getNotesForUserName(String userName);
	public void initDB();
}
