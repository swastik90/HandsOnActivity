package com.acc.lkm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.acc.lkm.businessBean.Login;
import com.acc.lkm.businessBean.PatientBean;
import com.acc.lkm.entity.PatientEntity;


public interface PatientDao {
	
	public Integer addPatient(PatientBean patientBean)throws Exception;
	public PatientBean getPatientById(Integer id)throws Exception;
	public List<PatientBean> getAllUserDetails()throws Exception;
	public PatientBean updatePatient(PatientBean patientBean)throws Exception;
	public boolean validate(Login login) throws Exception;

}
