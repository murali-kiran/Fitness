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

import com.team.fitness.dto.CustomerStatus;

/**
 * @author Kiran Kumar Poosa
 *
 */

@Repository
public class CustomerStatusDao {
	private static final Logger logger = Logger.getLogger(CustomerStatusDao.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public void save(CustomerStatus entity) {
		logger.info("saving CustomerStatus instance");
		try {
			entityManager.persist(entity);
			logger.info("save successful");
		} catch (RuntimeException re) {
			logger.error("save failed", re);
			throw re;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public void delete(CustomerStatus entity) {
		logger.info("deleting CustomerStatus instance");
		try {
			entity = entityManager.getReference(CustomerStatus.class,
					entity.getCustomerStatusId());
			entityManager.remove(entity);
			logger.info("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public CustomerStatus update(CustomerStatus entity) {
		logger.info("updating CustomerStatus instance");
		try {
			CustomerStatus result = entityManager.merge(entity);
			logger.info("update successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	public CustomerStatus findById(Integer id) {
		logger.info("finding CustomerStatus instance with id: " + id);
		try {
			CustomerStatus instance = entityManager.find(CustomerStatus.class, id);
			return instance;
		} catch (RuntimeException re) {
			logger.error("find failed",re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<CustomerStatus> findByProperty(String propertyName, final Object value,
			final int... rowStartIdxAndCount) {
    logger.info("finding CustomerStatus instance with property: "+ propertyName + ", value: " + value);
		try {
			String queryString;
			queryString = "select model from CustomerStatus model where model."
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
	public List<CustomerStatus> findAll(final int... rowStartIdxAndCount) {
		logger.info("finding all CustomerStatus instances");
		try {
			final String queryString = "select model from CustomerStatus model";
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

