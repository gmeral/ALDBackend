package org.rest.service.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.ws.rs.core.Response;

import org.rest.service.entities.MuseumEntity;
import org.rest.service.filters.JpaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractMuseumDao {
	protected Logger LOG;
	protected EntityManager em;
	protected Class<? extends MuseumEntity> entityClass;

	public EntityManager getEntityManager() {
		return em;
	}

	public AbstractMuseumDao() {
		em = JpaUtil.getEntityManager();
		entityClass = null;
		LOG = LoggerFactory.getLogger(this.getClass());
	}
	
	public MuseumEntity getEntityById(int id) {
		EntityTransaction  tx = em.getTransaction();
		MuseumEntity entity;
		try{
			tx.begin();
			entity= em.find(entityClass, id);
		} catch (RuntimeException re) {
			LOG.error("get Entity by id failed", re);
			throw re;
		}finally{
			tx.commit();
		}
		return entity;
	}
	
	public Response persistEntity(MuseumEntity entity) {
		EntityTransaction  tx = em.getTransaction();
		try{
			tx.begin();
			em.persist(entity);
			return Response.ok(entity).build();
		} catch (RuntimeException re) {
			LOG.error("add Entity failed", re);
			return Response.status(400).entity("Entity create failed!").build();
		}finally{
			tx.commit();
		}
	}
	
	public Response updateEntity(MuseumEntity aw) {
		EntityTransaction  tx = em.getTransaction();
		try{
			tx.begin();
			em.merge(aw);
			return Response.ok(aw).build();
		} catch (RuntimeException re) {
			LOG.error("update Entity failed", re);
			return Response.status(400).entity("Entity update failed!").build();
		}finally{
			tx.commit();
		}
	}
	
	public Response deleteEntity(MuseumEntity aw) {
		EntityTransaction  tx = em.getTransaction();
		try{
			tx.begin();
			em.remove(aw);
			return Response.ok(aw).build();
		} catch (RuntimeException re) {
			LOG.error("delete Entity failed", re);
			return Response.status(400).entity("Entity delete failed!").build();
		}finally{
			tx.commit();
		}
	}
	
	public Response deleteEntity(int id) {
		EntityTransaction  tx = em.getTransaction();
		try{
			tx.begin();
			MuseumEntity entity = em.find(entityClass, id);
			em.remove(entity);
			return Response.ok(entity).build();
		} catch (RuntimeException re) {
			LOG.error("delete Entity failed", re);
			return Response.status(400).entity("Entity delete failed!").build();
		}finally{
			tx.commit();
		}
	}
}
