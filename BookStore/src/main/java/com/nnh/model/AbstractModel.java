package com.nnh.model;

import java.sql.Timestamp;
import java.util.List;

public class AbstractModel<T> {
	private Long id;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp modifiedDate;
	private Long[] ids;
	private List<T> modelList;
	private Integer cPage;
	private Integer dPage;
	private Integer tPages;
	private String type;
	private String sortName;
	private String sortBy;
	
	
	
	public Long[] getIds() {
		return ids;
	}
	public void setIds(Long[] ids) {
		this.ids = ids;
	}
	public Integer getcPage() {
		return cPage;
	}
	public void setcPage(Integer cPage) {
		this.cPage = cPage;
	}
	public Integer getdPage() {
		return dPage;
	}
	public void setdPage(Integer dPage) {
		this.dPage = dPage;
	}
	
	public Integer gettPages() {
		return tPages;
	}
	public void settPages(Integer tPages) {
		this.tPages = tPages;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Timestamp getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public List<T> getModelList() {
		return modelList;
	}
	public void setModelList(List<T> modelList) {
		this.modelList = modelList;
	}
}
