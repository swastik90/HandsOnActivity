package com.acc.lkm.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.acc.lkm.businessBean.Login;
import com.acc.lkm.businessBean.PatientBean;
import com.acc.lkm.entity.PatientEntity;

@Repository
@SuppressWarnings("unchecked")
@Transactional(value = "txManager")
public class PatientDaoIMPL<EmployeeBean> implements PatientDao {

	@PersistenceContext
	private EntityManager entityManager;

	public List<PatientBean> patientList;

	@PostConstruct
	public void init() {
		patientList = new ArrayList<PatientBean>();
	}

	@Override
	public Integer addPatient(PatientBean patientBean) throws Exception{

		Integer id = 0;
		PatientEntity patientEntity = convertBeanToEntity(patientBean);
		try {

			if (patientEntity != null)
				entityManager.persist(patientEntity);
			save(patientBean);
			id = patientEntity.getUser_id();

		} catch (Exception e) {
			throw e;
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}

		return id;
	}

	@Override
	public PatientBean getPatientById(Integer id) throws Exception{
		
		PatientBean patientBean = null;
		try {
			PatientEntity patientEntity = entityManager.find(PatientEntity.class, id);
			if (patientEntity != null)
				patientBean = convertEntityToBean(patientEntity);

		} catch (Exception e) {
			throw e;
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		return patientBean;
	}

	@Override
	public List<PatientBean> getAllUserDetails() throws Exception{
		return patientList;
	}

	@Override
	public PatientBean updatePatient(PatientBean patientBean) throws Exception{
		
		PatientBean pBean=null;

		try {
			PatientEntity patientEntity = entityManager.find(PatientEntity.class, patientBean.getUser_id());
			if (patientEntity != null) {
				patientEntity.setEmail(patientBean.getEmail());
				patientEntity.setPhone_number(patientBean.getPhone_number());
				entityManager.merge(patientEntity);
				pBean= convertEntityToBean(patientEntity);
				update(patientEntity);
			}

		} catch (Exception e) {
			throw e;
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}

		return pBean;
	}

	private void save(PatientBean patientBean) {
		patientList.add(patientBean);
	}

	private void update(PatientEntity patientEntity) {
		for (PatientBean e : patientList) {
			if (e.getUser_id() == patientEntity.getUser_id()) {
				e.setEmail(patientEntity.getEmail());
				e.setPhone_number(patientEntity.getPhone_number());
			}
		}
	}

	private PatientBean convertEntityToBean(PatientEntity patientEntity) {
		PatientBean patientBean = new PatientBean();
		BeanUtils.copyProperties(patientEntity, patientBean);
		return patientBean;
	}

	private PatientEntity convertBeanToEntity(PatientBean patientBean) {
		PatientEntity patientEntity = new PatientEntity();
		BeanUtils.copyProperties(patientBean, patientEntity);
		return patientEntity;
	}

	@Override
	public boolean validate(Login login) throws Exception{
		for(PatientBean p : patientList) {
			if(login.getUserId().equals(p.getUser_id()) && login.getPassword().equals(p.getPassword()) ) {
				return true;
			}
		}
		return false;
	}

}
