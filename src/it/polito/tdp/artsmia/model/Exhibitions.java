package it.polito.tdp.artsmia.model;

public class Exhibitions {
	
	private int exhibition_id;
	private String exhibition_department;
	private String exhibition_title;
	private int begin;
	private int end;
	
	
	public Exhibitions(int exhibition_id) {
		
		this.exhibition_id = exhibition_id;
	}
	
	
	public Exhibitions(int exhibition_id, String exhibition_department, String exhibition_title, int begin, int end) {
	
		this.exhibition_id = exhibition_id;
		this.exhibition_department = exhibition_department;
		this.exhibition_title = exhibition_title;
		this.begin = begin;
		this.end = end;
	}


	/**
	 * @return the exhibition_id
	 */
	public int getExhibition_id() {
		return exhibition_id;
	}


	/**
	 * @return the exhibition_department
	 */
	public String getExhibition_department() {
		return exhibition_department;
	}


	/**
	 * @return the exhibition_title
	 */
	public String getExhibition_title() {
		return exhibition_title;
	}


	/**
	 * @return the begin
	 */
	public int getBegin() {
		return begin;
	}


	/**
	 * @return the end
	 */
	public int getEnd() {
		return end;
	}


	/**
	 * @param exhibition_id the exhibition_id to set
	 */
	public void setExhibition_id(int exhibition_id) {
		this.exhibition_id = exhibition_id;
	}


	/**
	 * @param exhibition_department the exhibition_department to set
	 */
	public void setExhibition_department(String exhibition_department) {
		this.exhibition_department = exhibition_department;
	}


	/**
	 * @param exhibition_title the exhibition_title to set
	 */
	public void setExhibition_title(String exhibition_title) {
		this.exhibition_title = exhibition_title;
	}


	/**
	 * @param begin the begin to set
	 */
	public void setBegin(int begin) {
		this.begin = begin;
	}


	/**
	 * @param end the end to set
	 */
	public void setEnd(int end) {
		this.end = end;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + exhibition_id;
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exhibitions other = (Exhibitions) obj;
		if (exhibition_id != other.exhibition_id)
			return false;
		return true;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format( "%s" + "[" + "%s" + "-" + "%s" + "]",exhibition_title, begin, end);
	}
	
	
	
	
	
	

}
