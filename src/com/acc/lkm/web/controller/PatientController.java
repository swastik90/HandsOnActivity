package com.acc.lkm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.portlet.ModelAndView;
import javax.validation.Valid;   
import com.acc.lkm.businessBean.Login;
import com.acc.lkm.businessBean.PatientBean;
import com.acc.lkm.exceptions.InvalidUpdateOpExc;
import com.acc.lkm.service.PatientService;

@Controller
@SessionAttributes({ "patientObj", "patientObj2" })
@SuppressWarnings("unused")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@RequestMapping(value = "/LoadPatient", method = RequestMethod.GET)
	public ModelAndView loadPatient() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("CreatePatient");
		modelAndView.addObject("patientObj", new PatientBean());
		return modelAndView;

	}

	@RequestMapping(value = "/savePatient", method = RequestMethod.GET)
	public ModelAndView SaveEmployee(@ModelAttribute("patientObj") PatientBean employeeBean) throws Exception {
		int i = patientService.addPatient(employeeBean);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("CreatePatientSuccess");
		modelAndView.addObject("message", "Patient added Successfully with user id :" + i);
		return modelAndView;

	}

	// Updating Patient

	@RequestMapping(value = "/LoadUpdatePatient", method = RequestMethod.GET)
	public ModelAndView loadUpdatePatient() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("UpdatePatient");
		modelAndView.addObject("patientObj", new PatientBean());
		return modelAndView;
	}

	@RequestMapping(value = "/LoadUpdatePatient2", method = RequestMethod.POST)
	public ModelAndView loadUpdateEmployee2(@ModelAttribute("patientObj") PatientBean patientBean) throws Exception {

		PatientBean patient2 = patientService.getPatientById(patientBean.getUser_id());
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("Hi New Model data ");
		modelAndView.setViewName("UpdatePatient");
		modelAndView.addObject("patientObj2", patient2);
		return modelAndView;
	}

	@RequestMapping(value = "/UpdatePatient", method = RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute("patientObj2") PatientBean patientBean) throws Exception {
		PatientBean patient2 = patientService.updatePatient(patientBean);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("UpdatePatientSuccess");
		return modelAndView;

	}
	
	@RequestMapping(value="beflogin",method=RequestMethod.GET)
	public String showLoginForm(Model model) {
		
		model.addAttribute("login",new Login());
		return "login";
	}

	@RequestMapping(value="afterlogin",method=RequestMethod.POST)
	public String verifyLoginForm(@Valid Login login,BindingResult result) throws Exception {
		if(result.hasErrors()) {
			return "login";
		}
		if(patientService.validate(login)) {
			return "loginSuccess";
		}
		else{
			return "loginError";
		}
	}

	@ExceptionHandler(value = InvalidUpdateOpExc.class)
	public ModelAndView handleInvalidUpdateOperationException(InvalidUpdateOpExc exception) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", exception.getMessage());
		modelAndView.addObject("exception", exception);
		modelAndView.addObject("patientObj", new PatientBean());
		modelAndView.addObject("UpdatePatient");
		return modelAndView;

	}

	@ExceptionHandler(value = Exception.class)
	public ModelAndView handleAllExceptions(Exception exception) {
		ModelAndView modelAndView = new ModelAndView();
		;
		modelAndView.setViewName("GeneralizedExceptionHandlerPage");
		modelAndView.addObject("message", exception.getMessage());
		modelAndView.addObject("exception", exception);
		return modelAndView;
	}

}
