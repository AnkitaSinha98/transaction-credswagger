package com.vit.isf.jcomponent.transaction.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Audit")
public class Audit {
	@Id
	String aId;
	String auditName;
	String auditData;
	/**
	 * @return the auditName
	 */
	public String getAuditName() {
		return auditName;
	}
	/**
	 * @param auditName the auditName to set
	 */
	public void setAuditName(String auditName) {
		this.auditName = auditName;
	}
	/**
	 * @return the aId
	 */
	public String getaId() {
		return aId;
	}
	/**
	 * @param hashcode the aId to set
	 */
	public void setaId(String hashcode) {
		this.aId = hashcode;
	}
	/**
	 * @return the auditData
	 */
	public String getAuditData() {
		return auditData;
	}
	/**
	 * @param auditData the auditData to set
	 */
	public void setAuditData(String auditData) {
		this.auditData = auditData;
	}
	/**
	 * 
	 */
	public Audit() {
		super();
	}
	@Override
	public String toString() {
		return "Audit [auditName=" + auditName + ", aId=" + aId + ", auditData=" + auditData + "]";
	}
	
	
	
}
