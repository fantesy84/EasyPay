package net.fantesy84.sys.dictionary.domain;
// Generated 2016-4-26 23:25:28 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * EpSysDict generated by hbm2java
 */
@Entity
@Table(name = "EP_SYS_DICT", catalog = "EASY_PAY")
public class EpSysDict implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6322024211945886261L;
	private Integer autoId;
	private String dictCode;
	private String dictName;
	private String dictDesc;
	private Integer sort;
	private Set<EpSysDictItem> epSysDictItems = new HashSet<EpSysDictItem>(0);

	public EpSysDict() {
	}

	public EpSysDict(String dictCode, String dictName) {
		this.dictCode = dictCode;
		this.dictName = dictName;
	}

	public EpSysDict(String dictCode, String dictName, String dictDesc, Integer sort,
			Set<EpSysDictItem> epSysDictItems) {
		this.dictCode = dictCode;
		this.dictName = dictName;
		this.dictDesc = dictDesc;
		this.sort = sort;
		this.epSysDictItems = epSysDictItems;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "AUTO_ID", unique = true, nullable = false)
	public Integer getAutoId() {
		return this.autoId;
	}

	public void setAutoId(Integer autoId) {
		this.autoId = autoId;
	}

	@Column(name = "DICT_CODE", nullable = false, length = 100)
	public String getDictCode() {
		return this.dictCode;
	}

	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}

	@Column(name = "DICT_NAME", nullable = false, length = 200)
	public String getDictName() {
		return this.dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	@Column(name = "DICT_DESC", length = 800)
	public String getDictDesc() {
		return this.dictDesc;
	}

	public void setDictDesc(String dictDesc) {
		this.dictDesc = dictDesc;
	}

	@Column(name = "SORT")
	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "epSysDict")
	public Set<EpSysDictItem> getEpSysDictItems() {
		return this.epSysDictItems;
	}

	public void setEpSysDictItems(Set<EpSysDictItem> epSysDictItems) {
		this.epSysDictItems = epSysDictItems;
	}

}