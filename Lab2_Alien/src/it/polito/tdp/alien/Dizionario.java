package it.polito.tdp.alien;

import java.util.*;

public class Dizionario {
	
	private List<WordEnhanced> dizionario = new LinkedList<WordEnhanced>();
	
	
	public void addWord(String alienWord, List<String> translations) {
		
		WordEnhanced daAggiungere = new WordEnhanced(alienWord, translations);
		
		for(WordEnhanced w: this.dizionario) {
			if(w.getAlienWord().compareTo(alienWord)==0) {
				//aggiungo una nuova traduzione
				w.setTranslationList(translations);
				return;
			}	
		}
		this.dizionario.add(daAggiungere);
	}
	
	
	public String translateWord(String alienWord) {
		for(WordEnhanced p: this.dizionario) {
			if(p.getAlienWord().compareTo(alienWord)==0)
				return p.toStringTranslationList();
		}
		return null;
	}
	
	public List<WordEnhanced> translateJollyWord(String alienJollyWord){
		List<WordEnhanced> listaParoleCompatibili = new LinkedList<WordEnhanced>();
		String splittedWord[] = alienJollyWord.split("\\?");
		for(WordEnhanced w: this.dizionario) {
			//char jollyChar = 'a';
			for(char i='a'; i<='z'; i++) {
				if((splittedWord[0]+i+splittedWord[1]).compareTo(w.getAlienWord())==0)
					listaParoleCompatibili.add(w);
				
			}
		}
		return listaParoleCompatibili;
	}
	
	public String paroleCompatibiliToString(String alienJollyWord) {
		String ret = "";
		for(WordEnhanced w : this.translateJollyWord(alienJollyWord))
			ret += w.getAlienWord() +" "+ w.toStringTranslationList()+"\n";
		return ret;
	}



}
