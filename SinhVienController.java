package com.dts.studentManager.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dts.studentManager.dto.SinhVienDTO;
import com.dts.studentManager.entity.SinhVienEntity;
import com.dts.studentManager.form.SearchForm;
import com.dts.studentManager.service.SinhVienService;

@Controller
@RequestMapping("/sinhvien")
public class SinhVienController {

    @Autowired
    private SinhVienService sinhVienService;

    // init search
    @RequestMapping(value="/list" , method = RequestMethod.GET)
    public String listSinhVien(Model theModel) {
    	SearchForm searchForm = new SearchForm();
    	searchForm.setSinhvienid(13);
    	searchForm.setSinhvienname("s");
    	
		List<SinhVienDTO> SinhViens = sinhVienService.getSinhViens(searchForm);
        theModel.addAttribute("sinhviens", SinhViens);
        return "listSinhVien";
    }

    // do search
    @RequestMapping(value = "/searchSinhVien" , method = RequestMethod.POST)
    public String searchSinhVien(SearchForm searchForm, Model theModel ,HttpServletRequest request) {
    	List<SinhVienDTO> SinhViens = sinhVienService.getSinhViens(searchForm);
        theModel.addAttribute("sinhviens", SinhViens);
        return "listSinhVien";
    }

    // init add
    @RequestMapping(value = "/add" , method = RequestMethod.GET)
    public String addSinhVien(Model theModel) {
        SinhVienEntity SinhVien = new SinhVienEntity();
        theModel.addAttribute("sinhvien", SinhVien);
        return "addSinhVien";
    }

    @RequestMapping(value = "/saveSinhVien" , method = RequestMethod.POST)
    public String saveSinhVien(@ModelAttribute("sinhvien") SinhVienEntity SinhVien) {
    	sinhVienService.saveSinhVien(SinhVien);
        return "redirect:/sinhvien/list";
    }

    @RequestMapping(value = "/updateSinhVien" , method = RequestMethod.GET)
    public String updateSinhVien(@RequestParam("sinhvienid") int theId,
        Model theModel) {
        SinhVienEntity SinhVien = sinhVienService.getSinhVien(theId);
        theModel.addAttribute("sinhvien", SinhVien);
        return "updateSinhVien";
    }

    @RequestMapping(value = "/deleteSinhVien" , method = RequestMethod.GET)
    public String deleteSinhVien(@RequestParam("sinhvienid") int theId) {
    	sinhVienService.deleteSinhVien(theId);
        return "redirect:/sinhvien/list";
    }
    
    
    
	
	  // sample
	  
	/*
	 * @RequestMapping(value="/sampleGet" , method = RequestMethod.GET) public
	 * String sampleGet(Model theModel) {
	 * 
	 * return "sample"; }
	 * 
	 * // do search
	 * 
	 * @RequestMapping(value = "/samplePost" , method = RequestMethod.POST) public
	 * String samplePost(SearchForm searchForm, Model model, HttpServletRequest
	 * request) {
	 * 
	 * String fname = request.getParameter("fname"); String lname =
	 * request.getParameter("lname");
	 * 
	 * model.addAttribute("firstName", fname); model.addAttribute("lastName",lname);
	 * 
	 * return "sample"; }
	 */
	 
}