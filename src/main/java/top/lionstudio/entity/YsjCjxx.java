package top.lionstudio.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ysj_cjxx database table.
 * 
 */
@Entity
@Table(name="ysj_cjxx")
@NamedQuery(name="YsjCjxx.findAll", query="SELECT y FROM YsjCjxx y")
public class YsjCjxx implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int xn;

	@Column(name="` CJLRRH`")
	private String _cjlrrh;

	@Column(name="` CJLRRQ`")
	private String _cjlrrq;

	@Column(name="` CJLRSJ`")
	private String _cjlrsj;

	@Column(name="` DJLKSCJ`")
	private String _djlkscj;

	@Column(name="` FSLKSCJ`")
	private String _fslkscj;

	@Column(name="` KCCJ`")
	private String _kccj;

	@Column(name="` KCDJCJM`")
	private String _kcdjcjm;

	@Column(name="` KSFSM`")
	private String _ksfsm;

	@Column(name="` KSXSM`")
	private String _ksxsm;

	@Column(name="` KSXZM`")
	private String _ksxzm;

	@Column(name="` PSCJ`")
	private String _pscj;

	@Column(name="` RKJSGH`")
	private String _rkjsgh;

	private String cjbh;

	private String jd;

	private String jxbh;

	private String jxbmc;

	private String kch;

	private String ksrq;

	private String ksxzm;

	private String xf;

	private String xh;

	private String xqm;

	public YsjCjxx() {
	}

	public int getXn() {
		return this.xn;
	}

	public void setXn(int xn) {
		this.xn = xn;
	}

	public String get_cjlrrh() {
		return this._cjlrrh;
	}

	public void set_cjlrrh(String _cjlrrh) {
		this._cjlrrh = _cjlrrh;
	}

	public String get_cjlrrq() {
		return this._cjlrrq;
	}

	public void set_cjlrrq(String _cjlrrq) {
		this._cjlrrq = _cjlrrq;
	}

	public String get_cjlrsj() {
		return this._cjlrsj;
	}

	public void set_cjlrsj(String _cjlrsj) {
		this._cjlrsj = _cjlrsj;
	}

	public String get_djlkscj() {
		return this._djlkscj;
	}

	public void set_djlkscj(String _djlkscj) {
		this._djlkscj = _djlkscj;
	}

	public String get_fslkscj() {
		return this._fslkscj;
	}

	public void set_fslkscj(String _fslkscj) {
		this._fslkscj = _fslkscj;
	}

	public String get_kccj() {
		return this._kccj;
	}

	public void set_kccj(String _kccj) {
		this._kccj = _kccj;
	}

	public String get_kcdjcjm() {
		return this._kcdjcjm;
	}

	public void set_kcdjcjm(String _kcdjcjm) {
		this._kcdjcjm = _kcdjcjm;
	}

	public String get_ksfsm() {
		return this._ksfsm;
	}

	public void set_ksfsm(String _ksfsm) {
		this._ksfsm = _ksfsm;
	}

	public String get_ksxsm() {
		return this._ksxsm;
	}

	public void set_ksxsm(String _ksxsm) {
		this._ksxsm = _ksxsm;
	}

	public String get_ksxzm() {
		return this._ksxzm;
	}

	public void set_ksxzm(String _ksxzm) {
		this._ksxzm = _ksxzm;
	}

	public String get_pscj() {
		return this._pscj;
	}

	public void set_pscj(String _pscj) {
		this._pscj = _pscj;
	}

	public String get_rkjsgh() {
		return this._rkjsgh;
	}

	public void set_rkjsgh(String _rkjsgh) {
		this._rkjsgh = _rkjsgh;
	}

	public String getCjbh() {
		return this.cjbh;
	}

	public void setCjbh(String cjbh) {
		this.cjbh = cjbh;
	}

	public String getJd() {
		return this.jd;
	}

	public void setJd(String jd) {
		this.jd = jd;
	}

	public String getJxbh() {
		return this.jxbh;
	}

	public void setJxbh(String jxbh) {
		this.jxbh = jxbh;
	}

	public String getJxbmc() {
		return this.jxbmc;
	}

	public void setJxbmc(String jxbmc) {
		this.jxbmc = jxbmc;
	}

	public String getKch() {
		return this.kch;
	}

	public void setKch(String kch) {
		this.kch = kch;
	}

	public String getKsrq() {
		return this.ksrq;
	}

	public void setKsrq(String ksrq) {
		this.ksrq = ksrq;
	}

	public String getKsxzm() {
		return this.ksxzm;
	}

	public void setKsxzm(String ksxzm) {
		this.ksxzm = ksxzm;
	}

	public String getXf() {
		return this.xf;
	}

	public void setXf(String xf) {
		this.xf = xf;
	}

	public String getXh() {
		return this.xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public String getXqm() {
		return this.xqm;
	}

	public void setXqm(String xqm) {
		this.xqm = xqm;
	}

}