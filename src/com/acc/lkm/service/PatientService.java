package com.acc.lkm.service;

import java.util.List;

import com.acc.lkm.businessBean.Login;
import com.acc.lkm.businessBean.PatientBean;

public interface PatientService {
	
	public Integer addPatient(PatientBean patientBean)throws Exception;
	public PatientBean getPatientById(Integer id) throws Exception;
	public List<PatientBean> getAllUserDetails()throws Exception;
	public PatientBean updatePatient(PatientBean patientBean)throws Exception;
	public boolean validate(Login login) throws Exception;

}
