package com.vit.isf.jcomponent.transaction.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Audit")

public class Auditfb {
	@Id
	String aId;
	String auditName;
	String auditData;

	/**
	 * @param aId
	 * @param auditName
	 * @param auditData
	 */
	public Auditfb(String aId, String auditName, String auditData) {
		super();
		this.aId = aId;
		this.auditName = auditName;
		this.auditData = auditData;
	}

	/**
	 * 
	 */
	public Auditfb() {
		super();
	}

	/**
	 * @return the aId
	 */
	public String getaId() {
		return aId;
	}

	/**
	 * @param aId the aId to set
	 */
	public void setaId(String aId) {
		this.aId = aId;
	}

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

	@Override
	public String toString() {
		return "Auditfb [aId=" + aId + ", auditName=" + auditName + ", auditData=" + auditData + "]";
	}

}
