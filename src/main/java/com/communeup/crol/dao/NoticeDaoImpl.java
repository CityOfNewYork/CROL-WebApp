package com.communeup.crol.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.communeup.crol.domain.Notice;
import com.communeup.crol.to.CrolInput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/**
 * Call Mongo DB for persistence & retrieval.
 * 
 * @author rtempalli
 *
 */
@Repository
public class NoticeDaoImpl implements NoticeDao {

//	private static final String NOTICE_SEQ_KEY = "notice";

//	@Autowired
//	private SequenceDao sequenceDao;

	@Override
	public Notice getNotice(String noticeId) {
		DBCollection noticeTable = getTable("notice");

		if (noticeTable != null) {
			BasicDBObject query = new BasicDBObject();
			query.put("noticeId", noticeId);

			DBCursor cursor = noticeTable.find(query);

			try {
				if (cursor.hasNext()) {
					DBObject object = cursor.next();

					if (object != null) {
						return dbObjectToNotice(object);
					} else {
						System.out.println("------- No Object Found");
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			System.out.println("*** Notice table not found ***");
		}

		return null;
	}

	private Notice dbObjectToNotice(DBObject object) {
		Notice notice = new Notice();

		notice.setNoticeId((String) object.get("noticeId"));
		notice.setNoticeText((String) object.get("noticeText"));
		notice.setNoticeType((String) object.get("noticeType"));

		return notice;
	}

	@Override
	public void saveNotice(Notice notice, CrolInput noticeInput) {
		try {
			DBCollection noticeTable = getTable("notice");

			if (noticeTable != null) {
				BasicDBObject document = new BasicDBObject();
				document.put("noticeId", notice.getNoticeId());
				document.put("noticeType", noticeInput.getNoticeType());		// Hard Coding for now ... just for testing
				document.put("noticeText", notice.getNoticeText());
				document.put("updatedDate", Calendar.getInstance().getTime());

				noticeTable.insert(document);
			} else {
				System.out.println("*** Notice table not found ***");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void deleteNotice(Notice notice) {
	}

	@Override
	public void deleteNotice(String noticeId) {
		DBCollection noticeTable = getTable("notice");

		if (noticeTable != null) {
			BasicDBObject document = new BasicDBObject();
			document.put("noticeId", noticeId);

			noticeTable.remove(document);
		} else {
			System.out.println("*** Notice table not found ***");
		}
	}

	@SuppressWarnings({ "resource", "deprecation", "unused" })
	private DBCollection getTable(String tableName) {
//		MongoClient mongo = new MongoClient("52.6.170.221", 27017);
		MongoClient mongo = new MongoClient("localhost", 27017);

		if (mongo != null) {
			DB db = mongo.getDB("test");
			if (db != null) {
				DBCollection table = db.getCollection(tableName);
				return table;
			} else {
				System.out.println("*** test Database Not Found ***");
			}
		} else {
			System.out.println("*** MONGO Object Failure ***");
		}

		return null;
	}

	@Override
	public List<Notice> getNoticeAfter(String timestamp) {
		List<Notice> notices = null;

		try {
			Date date = getDate(timestamp);
//		Date date = getDateFromString(timestamp);

			notices = new ArrayList<Notice>();

			DBCollection noticeTable = getTable("notice");

			if (noticeTable != null) {
				try {
					BasicDBObject query = new BasicDBObject("updatedDate", new BasicDBObject("$gte", date));

					DBCursor cursor = noticeTable.find(query);

					while (cursor.hasNext()) {
						DBObject object = cursor.next();

						if (object != null) {
							notices.add(dbObjectToNotice(object));
						} else {
							System.out.println("------- No Object Found");
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} else {
				System.out.println("*** Notice table not found ***");
			}
		} catch(Exception ex ) {
			ex.printStackTrace();
		}

		return notices;
	}

	private Date getDate(String text) throws ParseException {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		date = sdf.parse(text);
		return date;
	}

	@SuppressWarnings({ "deprecation", "unused" })
	private Date getDateFromString(String timestamp) {
		int year = Integer.parseInt(timestamp.substring(0, timestamp.indexOf("-")));
		int month = Integer.parseInt(timestamp.substring(timestamp.indexOf("-") + 1, timestamp.lastIndexOf("-")));
		int date = Integer.parseInt(timestamp.substring(timestamp.lastIndexOf("-") + 1));
		return new Date(year - 1900, month - 1, date);
	}

	public static void main1(String[] args) {
		NoticeDaoImpl dao = new NoticeDaoImpl();
//		List<Notice> notices = dao.getNoticeAfter("2014-06-03");
//		System.out.println(notices.size());
		try {
			Date date = dao.getDate("2015-06-03T04:30:08.441Z");
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
