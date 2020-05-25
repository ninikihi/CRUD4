package com.dts.studentManager.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dts.studentManager.dto.SinhVienDTO;
import com.dts.studentManager.entity.SinhVienEntity;
import com.dts.studentManager.form.SearchForm;

@Repository
public class SinhVienDAOImpl implements SinhVienDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
	public List<SinhVienDTO> getSinhViens(SearchForm searchForm) {
		 Session session = sessionFactory.getCurrentSession(); 
		 
		 Integer sinhvienId = searchForm.getSinhvienid();
		 String sinhvienName = searchForm.getSinhvienname();
		 
		 String sql = 
				 "SELECT "
			 		+ "sinhvienid AS maSV,"
			 		+ "sinhvienname AS tenSV,"
			 		+ "sinhvienns AS ngaysinh,"
			 		+ "sinhviendc AS diachi,"
			 		+ "sinhviencl AS lophoc "
		 		+ " FROM SinhVienEntity "
		 		+ " WHERE "
			 		+ " sinhvienid = :sinhvienId "
			 		+ " AND sinhvienname LIKE :sinhvienName";
		 
		 
		 Query query = session.createQuery(sql);
		 
		 
		 query.setParameter("sinhvienId", sinhvienId);
		 query.setParameter("sinhvienName", "%" + sinhvienName + "%");
		 
		 
		 List<SinhVienDTO> sinhvienDTOList = query.setResultTransformer(Transformers.aliasToBean(SinhVienDTO.class)).list();
		 
			/*
			 * CriteriaBuilder cb = session.getCriteriaBuilder();
			 * javax.persistence.criteria.CriteriaQuery<SinhVienEntity> cq =
			 * cb.createQuery(SinhVienEntity.class); Root<SinhVienEntity> root =
			 * cq.from(SinhVienEntity.class); cq.select(root);
			 * 
			 * Query query = session.createQuery(cq);
			 * 
			 * query.setParameter("", "");
			 * 
			 * List<SinhVienEntity> resultList = query.getResultList();
			 */
		  
//    	Session session = sessionFactory.getCurrentSession();
//    	Criteria cr = session.createCriteria(SinhVienEntity.class);
//    		  List<SinhVienEntity> list = cr.list();
        
        return sinhvienDTOList;
    }
    @Override
    public void deleteSinhVien(int id) {
        Session session = sessionFactory.getCurrentSession();
        SinhVienEntity book = session.byId(SinhVienEntity.class).load(id);
        session.delete(book);
    }

    @Override
    public void saveSinhVien(SinhVienEntity SinhVien) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(SinhVien);
        
        
        currentSession.saveOrUpdate(SinhVien);
        currentSession.save(SinhVien);
        currentSession.update(SinhVien);
        
    }

    @Override
    public SinhVienEntity getSinhVien(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        SinhVienEntity SinhVien = currentSession.get(SinhVienEntity.class, theId);
        return SinhVien;
    }
	@Override
	public List<SinhVienDTO> searchSinhVien1 (){
		Session session =sessionFactory.getCurrentSession();
		String sql = "SELECT "
				+ "sinhvienid AS sinhvienid,"
				+ "sinhvienname AS sinhvienname,"
				+ "sinhvienns AS sinhvienns,"
				+ "sinhviendc AS sinhviendc,"
				+ "sinhviencl AS sinhviencl,"
				+ " FROM SinhVienEntity"
				+ " WHERE"
				+ "sinhvienid = :sinhvienId "
				+ "AND"
				+ "sinhvienname LIKE :sinhvienName";
		
		Query query = session.createQuery(sql);
		query.setParameter("param1", "");
		query.setParameter("param2", "%" + "s" + "%");
		
		List<SinhVienDTO> sinhvienDTOList = query.setResultTransformer(Transformers.aliasToBean(SinhVienDTO.class)).list();
		return sinhvienDTOList;
				
	}
}
