package it.polito.tdp.artsmia.model;

import java.util.List;

import it.polito.tdp.artsmia.db.ArtsmiaDAO;

public class Model {
	
	private List<Integer> anni;
	
	private ArtsmiaDAO dao;
	
	
	public Model() {
		
		dao = new ArtsmiaDAO();
		
	}
	
	
	
	
	public List<Integer> getTuttiAnni() {
		
		if(this.anni == null){
			
			this.anni = dao.getTuttiAnni();
			
		}


		return anni;
	}

}
