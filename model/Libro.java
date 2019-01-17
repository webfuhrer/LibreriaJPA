package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

import com.sun.xml.bind.v2.runtime.Name;
@Entity
@NamedQuery(name="Libro.findAll", query="SELECT t FROM Libro t")
public class Libro implements Serializable{
	@Id
	private int isbn;
	private String titulo;
	private String genero;
	@ManyToMany
	private List<Autor> autores;
	
	public Libro() {
		super();
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public List<Autor> getAutores() {
		return autores;
	}
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	

}
