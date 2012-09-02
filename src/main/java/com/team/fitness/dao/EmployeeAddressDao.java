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

import com.team.fitness.dto.EmployeeAddress;

/**
 * @author Kiran Kumar Poosa
 *
 */

@Repository
public class EmployeeAddressDao {
	private static final Logger logger = Logger.getLogger(EmployeeAddressDao.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public void save(EmployeeAddress entity) {
		logger.info("saving EmployeeAddress instance");
		try {
			entityManager.persist(entity);
			logger.info("save successful");
		} catch (RuntimeException re) {
			logger.error("save failed", re);
			throw re;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public void delete(EmployeeAddress entity) {
		logger.info("deleting EmployeeAddress instance");
		try {
			entity = entityManager.getReference(EmployeeAddress.class,
					entity.getEmployeeAddressId());
			entityManager.remove(entity);
			logger.info("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public EmployeeAddress update(EmployeeAddress entity) {
		logger.info("updating EmployeeAddress instance");
		try {
			EmployeeAddress result = entityManager.merge(entity);
			logger.info("update successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	public EmployeeAddress findById(Integer id) {
		logger.info("finding EmployeeAddress instance with id: " + id);
		try {
			EmployeeAddress instance = entityManager.find(EmployeeAddress.class, id);
			return instance;
		} catch (RuntimeException re) {
			logger.error("find failed",re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<EmployeeAddress> findByProperty(String propertyName, final Object value,
			final int... rowStartIdxAndCount) {
    logger.info("finding EmployeeAddress instance with property: "+ propertyName + ", value: " + value);
		try {
			String queryString;
			queryString = "select model from EmployeeAddress model where model."
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
	public List<EmployeeAddress> findAll(final int... rowStartIdxAndCount) {
		logger.info("finding all EmployeeAddress instances");
		try {
			final String queryString = "select model from EmployeeAddress model";
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
