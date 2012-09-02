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

import com.team.fitness.dto.Customer;

/**
 * @author Kiran Kumar Poosa
 *
 */

@Repository
public class CustomerDao {

	private static final Logger logger = Logger.getLogger(CustomerDao.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public void save(Customer entity) {
		logger.info("saving Customer instance");
		try {
			entityManager.persist(entity);
			logger.info("save successful");
		} catch (RuntimeException re) {
			logger.error("save failed", re);
			throw re;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public void delete(Customer entity) {
		logger.info("deleting Customer instance");
		try {
			entity = entityManager.getReference(Customer.class,
					entity.getCustomerId());
			entityManager.remove(entity);
			logger.info("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public Customer update(Customer entity) {
		logger.info("updating Customer instance");
		try {
			Customer result = entityManager.merge(entity);
			logger.info("update successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	public Customer findById(Integer id) {
		logger.info("finding Customer instance with id: " + id);
		try {
			Customer instance = entityManager.find(Customer.class, id);
			return instance;
		} catch (RuntimeException re) {
			logger.error("find failed",re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Customer> findByProperty(String propertyName, final Object value,
			final int... rowStartIdxAndCount) {
    logger.info("finding Customer instance with property: "+ propertyName + ", value: " + value);
		try {
			String queryString;
			queryString = "select model from Customer model where model."
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
	public List<Customer> findAll(final int... rowStartIdxAndCount) {
		logger.info("finding all Customer instances");
		try {
			final String queryString = "select model from Customer model";
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
