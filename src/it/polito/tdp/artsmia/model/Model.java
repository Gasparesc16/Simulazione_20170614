package it.polito.tdp.artsmia.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.DirectedGraph;
import org.jgrapht.Graphs;
import org.jgrapht.alg.KosarajuStrongConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;

import it.polito.tdp.artsmia.db.ArtsmiaDAO;

public class Model {
	
	private List<Integer> anni;
	
	private List<Exhibitions> mostre;
	Map<Integer, Exhibitions> mappaMostre;
	
	private DirectedGraph<Exhibitions,DefaultEdge> grafo;
	private ArtsmiaDAO dao;
	
	
	public Model() {
		
		dao = new ArtsmiaDAO();
		mappaMostre = new HashMap<Integer,Exhibitions>();
		
	}
	
	
	
	
	public List<Integer> getTuttiAnni() {
		
		if(this.anni == null){
			
			this.anni = dao.getTuttiAnni();
			
		}


		return anni;
	}

	/**
	 * @return the mostre
	 */
	public List<Exhibitions> getMostre(Integer anno) {
		
		if(this.mostre == null)
			this.mostre = dao.getMostre(mappaMostre,anno);
		
		
		return mostre;
	}




	public void creaGrafo(Integer anno) {
		
		this.grafo = new SimpleDirectedGraph<Exhibitions, DefaultEdge>(DefaultEdge.class);
		
		Graphs.addAllVertices(grafo, this.getMostre(anno));
		
		for(Exhibitions e1: grafo.vertexSet()){
			
			for(Exhibitions e2: grafo.vertexSet()){
				
				if(!e1.equals(e2)){
					
					if(e2.getBegin() > e1.getBegin() && e2.getBegin() < e1.getEnd())
						grafo.addEdge(e1, e2);
				}
					
			}
			
			
		}
		
	}
	
	
	public boolean isStronglyConnected() {
		KosarajuStrongConnectivityInspector<Exhibitions, DefaultEdge> ksci = new KosarajuStrongConnectivityInspector<Exhibitions, DefaultEdge>(grafo);
		return ksci.isStronglyConnected();
	}




	public String getMaxOpere(Integer anno) {
		
		return dao.getMaxOpere(mappaMostre,anno);
	}
	
	
	

}
