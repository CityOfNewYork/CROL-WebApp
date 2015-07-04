package com.communeup.service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.amazonaws.util.json.JSONArray;
import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;
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

	private ParserService parserService = new ParserService();

	public Notice fetch( String noticeId ) {
		return noticeDao.getNotice(noticeId);
	}

	public void parseAndSave(CrolInput noticeInput) {
		String parserOutput = parserService.parseInput(noticeInput.getNoticeType(), noticeInput);

		String output = createFreemarkerOutputFromInput(noticeInput, parserOutput);

		if (isJSONValid(output)) {
			noticeDao.saveNotice(createNotice(noticeInput, output), noticeInput);
		} else {
			System.out.println("Json doesn't validate ... \n" + output);
		}
	}

	/**
	 * 
	 * @param jsonPayload
	 */
	private String createFreemarkerOutputFromInput(CrolInput input, String parserOutput) {
		try {
            String ftlPath = new java.io.File("/").getCanonicalPath();
            ftlPath += "template.ftl";

            Configuration config = new Configuration();
            config.setClassForTemplateLoading(CrolService.class, "");
            Template template = config.getTemplate(ftlPath);

			Map<String, Object> data = new HashMap<String, Object>();

			data.put("PIN", checkNullString(input.getPin()));
			data.put("Email", checkNullString(input.getEmail()));
			data.put("EndDate", checkNullString(input.getEndDate()));
			data.put("DueDate", checkNullString(input.getDueDate()));
			data.put("Printout", checkNullString(input.getPrintout()));
			data.put("StartDate", checkNullString(input.getStartDate()));
			data.put("OtherInfo", checkNullString(input.getOtherInfo()));
			data.put("RequestID", checkNullString(input.getRequestId()));
			data.put("SectionID", checkNullString(input.getSectionId()));
			data.put("OtherInfo", checkNullString(input.getOtherInfo()));
			data.put("ContactFax", checkNullString(input.getContactFax()));
			data.put("ShortTitle", checkNullString(input.getShortTitle()));
			data.put("AgencyName", checkNullString(input.getAgencyName()));
			data.put("AgencyCode", checkNullString(input.getAgencyCode()));
			data.put("VendorName", checkNullString(input.getVendorName()));
			data.put("SectionName", checkNullString(input.getSectionName()));
			data.put("ContactName", checkNullString(input.getContactName()));
			data.put("ContactPhone", checkNullString(input.getContactPhone()));
			data.put("VendorAddress", checkNullString(input.getVendorAddress()));
			data.put("ContractAmount", checkNullString(input.getContractAmount()));
			data.put("AddressToSubmit", checkNullString(input.getAddressToSubmit()));
			data.put("TypeOfNoticeCode", checkNullString(input.getTypeOfNoticeCode()));
			data.put("CategoryDescription", checkNullString(input.getCategoryDescription()));
			data.put("SelectionMethodCode", checkNullString(input.getSelectionMethodCode()));
			data.put("AdditionalDescription", checkNullString(input.getAdditionalDescription()));
			data.put("SpecialCaseReasonCode", checkNullString(input.getSpecialCaseReasonCode()));
			data.put("SelectionMethodDescription", checkNullString(input.getSelectionMethodDescription()));
			data.put("SpecialCaseReasonDescription", checkNullString(input.getSpecialCaseReasonDescription()));

			data.put("ParserOutput", parserOutput);

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

	private Object checkNullString(String string) {
		return (string == null) ? "" : string;
	}

	private Notice createNotice(CrolInput noticeInput, String output) {
		Notice notice = new Notice();

		notice.setNoticeId(noticeInput.getRequestId());
		notice.setNoticeText(output);

		return notice;
	}

	public void parseAndUpdate(CrolInput noticeInput) {
		String parserOutput = parserService.parseInput(noticeInput.getNoticeType(), noticeInput);

		String output = createFreemarkerOutputFromInput(noticeInput, parserOutput);

		System.out.println(output);

		noticeDao.deleteNotice(createNotice(noticeInput, output));
	}

	public void delete(String noticeId) {
		noticeDao.deleteNotice(noticeId);
	}

	public List<Notice> fetchAfter(String timestamp) {
		return noticeDao.getNoticeAfter(timestamp);
	}

	public static boolean isJSONValid(String test) {
		try {
			new JSONObject(test);
		} catch (JSONException ex) {
			try {
				new JSONArray(test);
			} catch (JSONException ex1) {
				return false;
			}
		}
		return true;
	}

}
