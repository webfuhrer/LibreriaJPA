package paqueteppal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Autor;
import model.Libro;

public class ClasePrincipal {
public static void main(String[] args) {
	Autor a=new Autor();
	a.setNombre("Kennedy Toole");
	a.setApellido("Perez");
	Libro l1=new Libro();
	l1.setTitulo("La conjura de los necios");
	l1.setGenero("Ni idea");
	l1.setIsbn(57215565);//Poner 22 y a ver qué pasa
	List lista_autores=new ArrayList<>();
	lista_autores.add(a);
	l1.setAutores(lista_autores);
	List lista_libros=new ArrayList();
	lista_libros.add(l1);
	a.setLibros(lista_libros);
	
	EntityManagerFactory factoria = Persistence.createEntityManagerFactory("LibreriaJPA");
	EntityManager em = factoria.createEntityManager();
	
	
	EntityTransaction transaccions=em.getTransaction();
	transaccions.begin();
	/*em.persist(a);
	em.persist(l1);*/
	Query q=em.createNamedQuery("Libro.findAll", Libro.class);
	List<Libro> libros= q.getResultList();
	for (Libro libro : libros) {
	//System.out.println("Título: "+libro.getTitulo()+"Género: "+libro.getGenero()+" ISBN: "+libro.getIsbn()+pintarAutores(libro));
	}
	
	transaccions.commit();
	
}

private static String pintarAutores(Libro libro) {
	List<Autor> autores=libro.getAutores();
	String aux="AUTORES: \n";
	for (Autor autor : autores) {
		aux+=autor.getNombre()+" "+autor.getApellido();
	}
	return aux;
			
}
}
