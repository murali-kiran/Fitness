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

import com.team.fitness.dto.Product;

/**
 * @author Kiran Kumar Poosa
 *
 */

@Repository
public class ProductDao {
	private static final Logger logger = Logger.getLogger(ProductDao.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public void save(Product entity) {
		logger.info("saving Product instance");
		try {
			entityManager.persist(entity);
			logger.info("save successful");
		} catch (RuntimeException re) {
			logger.error("save failed", re);
			throw re;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public void delete(Product entity) {
		logger.info("deleting Product instance");
		try {
			entity = entityManager.getReference(Product.class,
					entity.getProductId());
			entityManager.remove(entity);
			logger.info("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public Product update(Product entity) {
		logger.info("updating Product instance");
		try {
			Product result = entityManager.merge(entity);
			logger.info("update successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	public Product findById(Integer id) {
		logger.info("finding Product instance with id: " + id);
		try {
			Product instance = entityManager.find(Product.class, id);
			return instance;
		} catch (RuntimeException re) {
			logger.error("find failed",re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Product> findByProperty(String propertyName, final Object value,
			final int... rowStartIdxAndCount) {
    logger.info("finding Product instance with property: "+ propertyName + ", value: " + value);
		try {
			String queryString;
			queryString = "select model from Product model where model."
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
	public List<Product> findAll(final int... rowStartIdxAndCount) {
		logger.info("finding all Product instances");
		try {
			final String queryString = "select model from Product model";
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