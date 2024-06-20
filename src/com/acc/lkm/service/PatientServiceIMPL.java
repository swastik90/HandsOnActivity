package com.acc.lkm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.lkm.businessBean.Login;
import com.acc.lkm.businessBean.PatientBean;
import com.acc.lkm.dao.PatientDao;
import com.acc.lkm.exceptions.InvalidUpdateOpExc;

@Service
public class PatientServiceIMPL implements PatientService {
	
	@Autowired
	PatientDao patientDao;

	@Override
	public Integer addPatient(PatientBean patientBean) throws Exception{
		return patientDao.addPatient(patientBean);
	}

	@Override
	public PatientBean getPatientById(Integer id) throws Exception{
		PatientBean pBean = patientDao.getPatientById(id);
		if(pBean==null) {
			throw new  InvalidUpdateOpExc();
		}
		return pBean;
	}

	@Override
	public List<PatientBean> getAllUserDetails() throws Exception{
		return patientDao.getAllUserDetails();
	}

	@Override
	public PatientBean updatePatient(PatientBean patientBean) throws Exception{
		return patientDao.updatePatient(patientBean);
	}

	@Override
	public boolean validate(Login login) throws Exception {
		return patientDao.validate(login);
	}

}
