package com.communeup.crol.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.bson.BasicBSONObject;
import org.bson.BsonDocument;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mongodb.DBObject;

@JsonInclude(Include.NON_NULL)
@XmlRootElement(name = "notice")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Notice extends BasicBSONObject implements DBObject, Bson {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String noticeId;
	private Date noticeDate;
	private String noticeType;
	private String noticeText;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}

	public String getNoticeText() {
		return noticeText;
	}

	public void setNoticeText(String noticeText) {
		this.noticeText = noticeText;
	}

	@Override
	public <TDocument> BsonDocument toBsonDocument(
			Class<TDocument> documentClass, CodecRegistry codecRegistry) {
		return null;
	}

	@Override
	public void markAsPartialObject() {
	}

	@Override
	public boolean isPartialObject() {
		return false;
	}

	@Override
	public String toString() {
		return "Notice Id : " + noticeId + ", Notice Type : " + noticeType
				+ ", Notice Text : " + noticeText;
	}

}
