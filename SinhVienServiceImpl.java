package com.dts.studentManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dts.studentManager.dao.SinhVienDAO;
import com.dts.studentManager.dto.SinhVienDTO;
import com.dts.studentManager.entity.SinhVienEntity;
import com.dts.studentManager.form.SearchForm;

@Service
public class SinhVienServiceImpl implements SinhVienService {

    @Autowired
    private SinhVienDAO sinhVienDAO;

    @Override
    @Transactional
	public List<SinhVienDTO> getSinhViens(SearchForm searchForm) {
        return sinhVienDAO.getSinhViens(searchForm);
    }

    @Override
    @Transactional
    public void saveSinhVien(SinhVienEntity SinhVien) {
    	sinhVienDAO.saveSinhVien(SinhVien);
    }

    @Override
    @Transactional
    public SinhVienEntity getSinhVien (int theId) {
        return sinhVienDAO.getSinhVien(theId);
    }

    @Override
    @Transactional
    public void deleteSinhVien(int theId) {
        sinhVienDAO.deleteSinhVien(theId);
    }

	@Override
	public List<SinhVienDTO> searchSinhVien() {
		return sinhVienDAO.searchSinhVien1();
	}

	

}
