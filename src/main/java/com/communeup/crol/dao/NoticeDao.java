package com.communeup.crol.dao;

import java.util.List;

import com.communeup.crol.domain.Notice;
import com.communeup.crol.to.CrolInput;

/**
 * Notice CRUD Operations
 * 
 * @author rtempalli
 *
 */
public interface NoticeDao {

	Notice getNotice(String noticeId);

	void deleteNotice(Notice notice);

	void deleteNotice(String noticeId);

	List<Notice> getNoticeAfter(String timestamp);

	void saveNotice(Notice notice, CrolInput noticeInput);

}
