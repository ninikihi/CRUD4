package com.dts.studentManager.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sinhvien", schema = "public")
public class SinhVienEntity  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4438993178626641652L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sinhvien_id")
    private int sinhvienid;

    @Column(name = "sinhvien_name")
    private String sinhvienname;

    @Column(name = "sinhvien_ns")
    private String sinhvienns;

    @Column(name = "sinhvien_dc")
    private String sinhviendc;
    
    @Column(name = "sinhvien_cl")
    private String sinhviencl;
    
    public SinhVienEntity() {}
    
    public SinhVienEntity(int sinhvienid, String sinhvienname, String sinhvienns,String sinhviendc,String sinhviencl) {
    	this.sinhvienid = sinhvienid;
    	this.sinhvienname = sinhvienname;
    	this.sinhvienns = sinhvienns;
    	this.sinhviendc =sinhviendc;
    	this.sinhviencl = sinhviencl;
    }

	public int getSinhvienid() {
		return sinhvienid;
	}
	public void setSinhvienid(int sinhvienid) {
		this.sinhvienid = sinhvienid;
	}
	public String getSinhvienname() {
		return sinhvienname;
	}
	public void setSinhvienname(String sinhvienname) {
		this.sinhvienname = sinhvienname;
	}
	public String getSinhvienns() {
		return sinhvienns;
	}
	public void setSinhvienns(String sinhvienns) {
		this.sinhvienns = sinhvienns;
	}
	public String getSinhviendc() {
		return sinhviendc;
	}
	public void setSinhviendc(String sinhviendc) {
		this.sinhviendc = sinhviendc;
	}
	public String getSinhviencl() {
		return sinhviencl;
	}
	public void setSinhviencl(String sinhviencl) {
		this.sinhviencl = sinhviencl;
	}
	@Override
	public String toString() {
		return "SinhVienEntity [sinhvienid=" + sinhvienid + ", sinhvienname=" + sinhvienname + ", sinhvienns="
				+ sinhvienns + ", sinhviendc=" + sinhviendc + ", sinhviencl=" + sinhviencl + "]";
	}
	
}
	
    

	