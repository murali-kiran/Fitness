/**
 * 
 */
package com.team.fitness.sample;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.team.fitness.dao.GenderDao;
import com.team.fitness.dto.Gender;

/**
 * @author Kiran Kumar Poosa
 *
 */
public class Sample {

	final static Logger logger=Logger.getLogger(Sample.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try{

			logger.info("Creating Spring container .....");
			ClassPathXmlApplicationContext applicationContext=new  ClassPathXmlApplicationContext("applicationContext.xml");
			
			logger.info("Getting GenderDao from container .....");
			GenderDao genderDao=applicationContext.getBean(GenderDao.class);

			Gender gender1=new Gender();

			gender1.setGenderName("Female"); 

			logger.info("saving gender female .....");
			genderDao.save(gender1); // check in gender table whether female is inserted or not

			Gender gender2=new Gender();

			gender2.setGenderName("Male");

			logger.info("saving gender male .....");
			genderDao.save(gender2); // check in gender table whether male is inserted or not

			logger.info("Getting gender list from database .....");
			List<Gender> genderList=genderDao.findAll();

			for (Gender gender : genderList) {
				logger.info("Gender id is "+gender.getGenderId()+" and Gender name is "+gender.getGenderName());
			}

		}catch (Exception e) {
			logger.error("Exception caught : ",e);
		}
	}

}
