package com.notes.model;

import java.util.List;

public class Notes {
	
	private String userName;
	private List<NotesContent> noteContents;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<NotesContent> getNoteContents() {
		return noteContents;
	}
	public void setNoteContents(List<NotesContent> noteContents) {
		this.noteContents = noteContents;
	}

}
