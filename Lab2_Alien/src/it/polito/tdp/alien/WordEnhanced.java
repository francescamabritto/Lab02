package it.polito.tdp.alien;

import java.util.*;

public class WordEnhanced {
	/*
	private String alienWord; 
	private String translation;
	boolean found = false;
	
	public WordEnhanced(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translation = translation;
		
	}
	
	
	public String getAlienWord() {
		return alienWord;
	}
	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}public String getTranslation() {
		return translation;
	}
	public void setTranslation(String translation) {
		this.translation = translation;
	}


	public boolean equals (Object obj) {
		
		return found;
	}
	
	*/
	private String alienWord; 
	private List<String> translationList;
	boolean found = false;
	
	public WordEnhanced(String alienWord, List<String> translationList) {
		this.alienWord = alienWord;
		this.translationList = new LinkedList<String>(translationList);
		
	}
	
	
	public String getAlienWord() {
		return alienWord;
	}
	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
		
	}public List<String> getTranslationList() {
		return translationList;
	}
	public String toStringTranslationList() {
		String tot = "";
		for(String s: this.translationList) {
			tot = tot + " " + s;
		}
		return tot; 
	}
	public void setTranslationList(List<String> translations) {
		this.translationList = translations;
	}
	
}
