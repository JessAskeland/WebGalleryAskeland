package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.ArtGalleryItem;

public class ArtGalleryItemHelper {
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleGalleryAppAskeland");

	public void insertItem(ArtGalleryItem toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ArtGalleryItem> showAllItems() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		//creates the query but does not execute it.
		TypedQuery<ArtGalleryItem> allResults = em.createQuery("Select li from ArtGalleryItem li", ArtGalleryItem.class); 
		//Selects the info
		List<ArtGalleryItem> allItems = allResults.getResultList();
		//need to close the entity manager
		em.close();
		
		return allItems;
	} 

	public void deleteItem(ArtGalleryItem toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ArtGalleryItem> typedQuery = em.createQuery("select li from ArtGalleryItem li where li.title = :selectedTitle and li.artist = :selectedArtist", ArtGalleryItem.class);
		typedQuery.setParameter("selectedTitle", toDelete.getTitle());
		typedQuery.setParameter("selectedArtist",  toDelete.getArtist());
		typedQuery.setMaxResults(1);
		ArtGalleryItem result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public ArtGalleryItem searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ArtGalleryItem foundItem = em.find(ArtGalleryItem.class, idToEdit);
		em.close();
		return foundItem;
	}
	
	public ArtGalleryItem searchForItemByTitle(char titleToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ArtGalleryItem foundItem = em.find(ArtGalleryItem.class, titleToEdit);
		em.close();
		return foundItem;
	}
	
	public ArtGalleryItem searchForItemByArtist(int artistToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ArtGalleryItem foundItem = em.find(ArtGalleryItem.class, artistToEdit);
		em.close();
		return foundItem;
	}

	public void updateTitle(ArtGalleryItem toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin(); 
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateArtist(ArtGalleryItem toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin(); 
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateMedia(ArtGalleryItem toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin(); 
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateYear(ArtGalleryItem toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin(); 
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateValue(ArtGalleryItem toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin(); 
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ArtGalleryItem> searchForTitleName(String titleName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ArtGalleryItem> typedQuery = em.createQuery("select li from ArtGalleryItem li where li.title = :selectedTitle and li.title = :selectedTitle", ArtGalleryItem.class);
		typedQuery.setParameter("selectedTitle", titleName);
		List<ArtGalleryItem> result = typedQuery.getResultList();
		em.close();
		return result;
	}
	
	public List<ArtGalleryItem> searchForItemsByArtist(String artistName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ArtGalleryItem> typedQuery = em.createQuery("select li from ArtGalleryItem li where li.artist = :selectedArtist and li.artist = :selectedArtist", ArtGalleryItem.class);
		typedQuery.setParameter("selectedArtist", artistName);
		List<ArtGalleryItem> result = typedQuery.getResultList();
		em.close();
		return result;
	}
}
