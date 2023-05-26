package br.inatel.labs.labjpa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
@Transactional
public class NotaCompraService {

	@PersistenceContext
	private EntityManager em;
	
	// Nota Compra ...
	
	public NotaCompra salvar(NotaCompra nc) {
		return em.merge(nc);
	}
	
	public NotaCompra buscarNotaCompraPeloId(Long id) {
		return em.find(NotaCompra.class, id);
	}
	
	public NotaCompra buscarNotaCompraPeloIdComListaItem(Long id) {
		NotaCompra nota = em.find(NotaCompra.class,id);
		nota.getListaNotaCompraItem().size();
		return nota;
	}
	
	public List<NotaCompra> listarNotaCompra() {
		return em.createQuery("Select nc from NotaCompra nc", NotaCompra.class).getResultList();
	}
	
	// Nota Compra Item ...
	
	public NotaCompraItem salvar(NotaCompraItem nci) {
		return em.merge(nci);
	}
	
	public NotaCompraItem buscarNotaCompraItemPeloId(Long id) {
		return em.find(NotaCompraItem.class, id);
	}
	
	public List<NotaCompraItem> listarNotaCompraItem() {
		return em.createQuery("Select nci from NotaCompraItem nci", NotaCompraItem.class).getResultList();
	}
	
}
