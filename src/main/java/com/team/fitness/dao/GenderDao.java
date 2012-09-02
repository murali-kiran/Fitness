/**
 * 
 */
package com.team.fitness.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.team.fitness.dto.Gender;

/**
 * @author Kiran Kumar Poosa
 *
 */

@Repository
public class GenderDao {
	private static final Logger logger = Logger.getLogger(GenderDao.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public void save(Gender entity) {
		logger.info("saving Gender instance");
		try {
			entityManager.persist(entity);
			logger.info("save successful");
		} catch (RuntimeException re) {
			logger.error("save failed", re);
			throw re;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public void delete(Gender entity) {
		logger.info("deleting Gender instance");
		try {
			entity = entityManager.getReference(Gender.class,
					entity.getGenderId());
			entityManager.remove(entity);
			logger.info("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public Gender update(Gender entity) {
		logger.info("updating Gender instance");
		try {
			Gender result = entityManager.merge(entity);
			logger.info("update successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	public Gender findById(Integer id) {
		logger.info("finding Gender instance with id: " + id);
		try {
			Gender instance = entityManager.find(Gender.class, id);
			return instance;
		} catch (RuntimeException re) {
			logger.error("find failed",re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Gender> findByProperty(String propertyName, final Object value,
			final int... rowStartIdxAndCount) {
    logger.info("finding Gender instance with property: "+ propertyName + ", value: " + value);
		try {
			String queryString;
			queryString = "select model from Gender model where model."
				    + propertyName + "= :propertyValue";
				Query query = entityManager.createQuery(queryString);
			    query.setParameter("propertyValue", value);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			logger.error("find by property name failed",re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Gender> findAll(final int... rowStartIdxAndCount) {
		logger.info("finding all Gender instances");
		try {
			final String queryString = "select model from Gender model";
			Query query = entityManager.createQuery(queryString);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			logger.error("find all failed",re);
			throw re;
		}
	}

}
