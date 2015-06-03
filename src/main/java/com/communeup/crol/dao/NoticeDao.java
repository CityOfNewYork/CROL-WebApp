package com.communeup.crol.dao;

import java.util.List;

import com.communeup.crol.domain.Notice;

/**
 * Notice CRUD Operations
 * 
 * @author rtempalli
 *
 */
public interface NoticeDao {

	Notice getNotice(String noticeId);

	void saveNotice(Notice notice);

	void deleteNotice(Notice notice);

	void deleteNotice(String noticeId);

	List<Notice> getNoticeAfter(String timestamp);

}
