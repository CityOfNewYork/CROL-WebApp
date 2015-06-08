package com.communeup.crol.to;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.gson.annotations.SerializedName;

/**
 * Input Json
 *
 */
@JsonInclude(Include.NON_NULL)
@XmlRootElement(name = "notice")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CrolInput {

	@Override
	public String toString() {
		return "SpecialCaseReasonDescription  : "
				+ specialCaseReasonDescription + ", RequestID : " + requestId
				+ ", StartDate : " + startDate + ", EndDate : " + endDate;
	}

	@SerializedName("Pin")
	private String pin;

	@SerializedName("Email")
	private String email;

	@SerializedName("DueDate")
	private String dueDate;

	@SerializedName("StartDate")
	private String startDate;

	@SerializedName("OtherInfo")
	private String otherInfo;

	@SerializedName("AgencyName")
	private String agencyName;

	@SerializedName("ShortTitle")
	private String shortTitle;

	@SerializedName("SectionName")
	private String sectionName;

	@SerializedName("ContactName")
	private String contactName;

	@SerializedName("ContactPhone")
	private String contactPhone;

	@SerializedName("PhoneRequested")
	private String phoneRequested;

	@SerializedName("AgencyDivision")
	private String agencyDivision;

	@SerializedName("AddressToRequest")
	private String addressToRequest;

	@SerializedName("CategoryDescription")
	private String categoryDescription;

	@SerializedName("AdditionalDescription")
	private String additionalDescription;

	@SerializedName("TypeOfNoticeDescription")
	private String typeOfNoticeDescription;

	@SerializedName("SelectionMethodDescription")
	private String selectionMethodDescription;

	@SerializedName("SpecialCaseReasonDescription")
	private String specialCaseReasonDescription;

	@SerializedName("SectionId")
	private Long sectionId;

	@SerializedName("AgencyCode")
	private String agencyCode;

	@SerializedName("CategoryCode")
	private Long categoryCode;

	@SerializedName("TypeOfNoticeCode")
	private Long typeOfNoticeCode;

	@SerializedName("SelectionMethodCode")
	private Long selectionMethodCode;

	@SerializedName("SpecialCaseReasonCode")
	private Long specialCaseReasonCode;

	@SerializedName("EndDate")
	private String endDate;

	@SerializedName("Printout")
	private String printout;

	@SerializedName("RequestId")
	private String requestId;

	@SerializedName("VendorName")
	private String vendorName;

	@SerializedName("ContactFax")
	private String contactFax;

	@SerializedName("RequestedBy")
	private String requestedBy;

	@SerializedName("VendorAddress")
	private String vendorAddress;

	@SerializedName("ContractAmount")
	private String contractAmount;

	@SerializedName("AddressToSubmit")
	private String addressToSubmit;

	@SerializedName("ConfirmationNumber")
	private String confirmationNumber;

	public String getSpecialCaseReasonDescription() {
		return specialCaseReasonDescription;
	}

	public void setSpecialCaseReasonDescription(
			String SpecialCaseReasonDescription) {
		this.specialCaseReasonDescription = SpecialCaseReasonDescription;
	}

	public String getShortTitle() {
		return shortTitle;
	}

	public void setShortTitle(String ShortTitle) {
		this.shortTitle = ShortTitle;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String SectionName) {
		this.sectionName = SectionName;
	}

	public String getPhoneRequested() {
		return phoneRequested;
	}

	public void setPhoneRequested(String PhoneRequested) {
		this.phoneRequested = PhoneRequested;
	}

	public String getSpecialCaseReasonCode() {
		return (specialCaseReasonCode == null) ? "" : specialCaseReasonCode.toString();
	}

	public void setSpecialCaseReasonCode(Long SpecialCaseReasonCode) {
		this.specialCaseReasonCode = SpecialCaseReasonCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String Email) {
		this.email = Email;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String StartDate) {
		this.startDate = StartDate;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String ContactPhone) {
		this.contactPhone = ContactPhone;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String AgencyName) {
		this.agencyName = AgencyName;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String Pin) {
		this.pin = Pin;
	}

	public String getTypeOfNoticeDescription() {
		return typeOfNoticeDescription;
	}

	public void setTypeOfNoticeDescription(String TypeOfNoticeDescription) {
		this.typeOfNoticeDescription = TypeOfNoticeDescription;
	}

	public String getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(String AgencyCode) {
		this.agencyCode = AgencyCode;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public String getTypeOfNoticeCode() {
		return (typeOfNoticeCode == null) ? "" : typeOfNoticeCode.toString();
	}

	public void setTypeOfNoticeCode(Long TypeOfNoticeCode) {
		this.typeOfNoticeCode = TypeOfNoticeCode;
	}

	public String getAdditionalDescription() {
		return additionalDescription;
	}

	public void setAdditionalDescription(String AdditionalDescription) {
		this.additionalDescription = AdditionalDescription;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String CategoryDescription) {
		this.categoryDescription = CategoryDescription;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String ContactName) {
		this.contactName = ContactName;
	}

	public String getSelectionMethodDescription() {
		return selectionMethodDescription;
	}

	public void setSelectionMethodDescription(String SelectionMethodDescription) {
		this.selectionMethodDescription = SelectionMethodDescription;
	}

	public String getAddressToRequest() {
		return addressToRequest;
	}

	public void setAddressToRequest(String AddressToRequest) {
		this.addressToRequest = AddressToRequest;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getAgencyDivision() {
		return agencyDivision;
	}

	public void setAgencyDivision(String AgencyDivision) {
		this.agencyDivision = AgencyDivision;
	}

	public String getSectionId() {
		return (sectionId == null) ? "" : sectionId.toString();
	}

	public void setSectionId(Long SectionId) {
		this.sectionId = SectionId;
	}

	public String getAddressToSubmit() {
		return addressToSubmit;
	}

	public void setAddressToSubmit(String AddressToSubmit) {
		this.addressToSubmit = AddressToSubmit;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String EndDate) {
		this.endDate = EndDate;
	}

	public String getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(String RequestedBy) {
		this.requestedBy = RequestedBy;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String VendorName) {
		this.vendorName = VendorName;
	}

	public String getContactFax() {
		return contactFax;
	}

	public void setContactFax(String ContactFax) {
		this.contactFax = ContactFax;
	}

	public String getContractAmount() {
		return contractAmount;
	}

	public void setContractAmount(String ContractAmount) {
		this.contractAmount = ContractAmount;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String VendorAddress) {
		this.vendorAddress = VendorAddress;
	}

	public String getPrintout() {
		return printout;
	}

	public void setPrintout(String Printout) {
		this.printout = Printout;
	}

	public String getSelectionMethodCode() {
		return (selectionMethodCode == null) ? "" : selectionMethodCode.toString();
	}

	public void setSelectionMethodCode(Long SelectionMethodCode) {
		this.selectionMethodCode = SelectionMethodCode;
	}

	public String getCategoryCode() {
		return (categoryCode == null) ? "" : categoryCode.toString();
	}

	public void setCategoryCode(Long CategoryCode) {
		this.categoryCode = CategoryCode;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestID(String RequestId) {
		this.requestId = RequestId;
	}

	public String getConfirmationNumber() {
		return confirmationNumber;
	}

	public void setConfirmationNumber(String ConfirmationNumber) {
		this.confirmationNumber = ConfirmationNumber;
	}

	public Object getNoticeType() {
		if (typeOfNoticeCode == 1 || typeOfNoticeCode == 3) {
			return "Tender";
		} else if (typeOfNoticeCode == 2 || typeOfNoticeCode == 4) {
			return "Award";
		} else if (typeOfNoticeCode == 11) {
			return "PublicHearing";
		}

		return "Other";
	}

}
