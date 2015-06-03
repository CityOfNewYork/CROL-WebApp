package com.communeup.service;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.communeup.crol.dao.NoticeDao;
import com.communeup.crol.dao.NoticeDaoImpl;
import com.communeup.crol.domain.Notice;
import com.communeup.crol.to.CrolInput;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class CrolService {

	private NoticeDao noticeDao = new NoticeDaoImpl();

	public Notice fetch( String noticeId ) {
		return noticeDao.getNotice(noticeId);
	}

	public void parseAndSave(CrolInput noticeInput) {
		// Parser Calls go here ...
		String output = createFreemarkerOutputFromInput(noticeInput);
		System.out.println(output);
		noticeDao.saveNotice(createNotice(noticeInput, output));
	}

	/**
	 * 
	 * @param jsonPayload
	 */
	private String createFreemarkerOutputFromInput(CrolInput input) {
		Configuration config = new Configuration();

		try {
			config.setDirectoryForTemplateLoading(new File( "/home/ubuntu/crol-interface/src"));
			Template template = config.getTemplate("template.ftl");

			Map<String, Object> data = new HashMap<String, Object>();
			data.put("RequestID", input.getRequestId());
			data.put("ShortTitle", input.getShortTitle());
			data.put("AdditionalDescription", input.getAdditionalDescription());
			data.put("SectionID", input.getSectionId());
			data.put("SectionName", input.getSectionName());
			data.put("AgencyName", input.getAgencyName());
			data.put("AgencyCode", input.getAgencyCode());
			data.put("StartDate", input.getStartDate());
			data.put("OtherInfo", input.getOtherInfo());
			data.put("Printout", input.getPrintout());
			data.put("EndDate", input.getEndDate());

			data.put("Email", "");
			data.put("DueDate", "");
			data.put("OtherInfo", "");
			data.put("ContactFax", "");
			data.put("ContactName", "");
			data.put("ContactPhone", "");
			data.put("ContractAmount", "");
			data.put("AddressToSubmit", "");
			data.put("CategoryDescription", "");
			data.put("SelectionMethodCode", "");
			data.put("SpecialCaseReasonCode", "");
			data.put("SpecialCaseReasonDescription", "");
			data.put("TypeOfNoticeCode", input.getTypeOfNoticeCode());

//			// Console output
//			Writer out = new OutputStreamWriter(System.out);
//			template.process(data, out);
//			out.flush();

			StringWriter writer = new StringWriter();
			template.process(data, writer);
			writer.flush();

			return writer.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}

		return null;
	}

	private Notice createNotice(CrolInput noticeInput, String output) {
		Notice notice = new Notice();

		notice.setNoticeId(noticeInput.getRequestId());
		notice.setNoticeText(output);

		return notice;
	}

	public void parseAndUpdate(CrolInput noticeInput) {
		String output = createFreemarkerOutputFromInput(noticeInput);
		System.out.println(output);
		noticeDao.deleteNotice(createNotice(noticeInput, output));
	}

	public void delete(String noticeId) {
		noticeDao.deleteNotice(noticeId);
	}

	public List<Notice> fetchAfter(String timestamp) {
		System.out.println("Query by latest timestamp in service : " + timestamp);
		return noticeDao.getNoticeAfter(timestamp);
	}

}
