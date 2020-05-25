package com.dts.studentManager.service;

import java.util.List;

import com.dts.studentManager.dto.SinhVienDTO;
import com.dts.studentManager.entity.SinhVienEntity;
import com.dts.studentManager.form.SearchForm;

public interface SinhVienService {

	
	public List <SinhVienDTO> getSinhViens(SearchForm searchForm);
	
	public void saveSinhVien(SinhVienEntity SinhVien);
	
	public SinhVienEntity getSinhVien(int theId);
	
	public void deleteSinhVien(int theId);
	
	public List<SinhVienDTO> searchSinhVien();
	
	

}