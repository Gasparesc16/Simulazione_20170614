package it.polito.tdp.artsmia.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.artsmia.model.ArtObject;
import it.polito.tdp.artsmia.model.Exhibitions;

public class ArtsmiaDAO {

	public List<ArtObject> listObject() {
		
		String sql = "SELECT * from objects";

		List<ArtObject> result = new ArrayList<>();

		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet res = st.executeQuery();

			while (res.next()) {
				
				result.add(new ArtObject(res.getInt("object_id"), res.getString("classification"), res.getString("continent"), 
						res.getString("country"), res.getInt("curator_approved"), res.getString("dated"), res.getString("department"), 
						res.getString("medium"), res.getString("nationality"), res.getString("object_name"), res.getInt("restricted"), 
						res.getString("rights_type"), res.getString("role"), res.getString("room"), res.getString("style"), res.getString("title")));
			}

			conn.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List<Integer> getTuttiAnni() {
		
		
		String sql = 
					"SELECT DISTINCT begin " +
					"FROM exhibitions "+
					"ORDER BY begin DESC";

		List<Integer> result = new ArrayList<>();

		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet res = st.executeQuery();

			while (res.next()) {
				
				result.add(res.getInt("begin"));
			}

			conn.close();
		
			return result;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List<Exhibitions> getMostre(Map<Integer, Exhibitions> mappaMostre, Integer anno) {
		
		String sql = 
				"SELECT * " +
				"FROM exhibitions " +
				"Where begin >= ? " +
				"ORDER BY exhibition_title ";

		List<Exhibitions> result = new ArrayList<>();

	Connection conn = DBConnect.getConnection();

	try {
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setInt(1, anno);

		ResultSet res = st.executeQuery();

		while (res.next()) {
			
			Exhibitions e = new Exhibitions( res.getInt("exhibition_id"),
					res.getString("exhibition_department"),
					res.getString("exhibition_title"),
					res.getInt("begin"),
					res.getInt("end") ) ;
			
			result.add(e);
			mappaMostre.put(e.getExhibition_id(), e);
			
		}

		conn.close();
	
		return result;
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	}

	

	public String getMaxOpere(Map<Integer, Exhibitions> mappaMostre, Integer anno) {
		
		String sql = 
				"select e.exhibition_id, exhibition_department,exhibition_title,`begin`,`end`,count(object_id) as counter "+
				"from exhibition_objects eo, exhibitions as e "+
				"where e.exhibition_id = eo.exhibition_id and begin >= ? "+
				"group by e.exhibition_id "+
				"order by counter DESC "+
				"LIMIT 1 ";
	
		String risultato = "";

	Connection conn = DBConnect.getConnection();

	try {
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setInt(1, anno);

		ResultSet res = st.executeQuery();

		if (res.next()) {
			
			int exhibitionId = res.getInt("exhibition_id");
			
			Exhibitions e = mappaMostre.get(exhibitionId);
			
			// Controllo che la mostro cercata esista
			if (e == null)
				throw new RuntimeException("Nessuna mostra trovata");
			
			
			risultato += e.getExhibition_title();
			
			
		} else {
			
			throw new RuntimeException("Nessuna mostra trovata");
			
		}

		conn.close();
	
		return risultato;
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	}


	
}
