package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Interface.Page;
import utils.TestBase;

public class Enquiry extends TestBase implements Page
{
	
	private WebElement EnquiryID_TxtBox;
	private WebElement mobileNumber_TxtBox;
	private WebElement enquiryDate_Dt;
	
	private WebElement enquiryType_DDL;
	private WebElement firstName_TxtBox;
	private WebElement LastName_TxtBox;
	private WebElement  Email_TxtBox;
	private WebElement  AltMobileNumber_TxtBox;
	private WebElement  Gender_RdBtn;
	private WebElement  PreviousSchoolName_TxtBox;
	private WebElement  SelectCourse_RdBtn;
	private WebElement  SelectSubCourse_RdBtn;
	private WebElement  SelectGroup_RdBtn;
	private WebElement  SelectSubject_ChkBox;
	private WebElement  EstimatedFees_TxtBox;
	private WebElement  FinalFees_TxtBox;
	private WebElement  Batch_DDL;
	private WebElement  ReferredByName_TxtBox;
	private WebElement  ReferredByMobile_TxtBox;
	private WebElement  EnquiryOwner_TxtBox;
	private WebElement  Remarks_TxtBox;

	private WebElement SelectEnquiry_Btn;
	private WebElement AddNew_Btn;
	private WebElement Save_Btn;
	private WebElement Update_Btn;
	private WebElement Delete_Btn;
	
	
	public WebElement getEnquiryID_TxtBox() {
		return EnquiryID_TxtBox;
	}

	public void setEnquiryID_TxtBox(WebElement enquiryID_TxtBox) {
		EnquiryID_TxtBox = enquiryID_TxtBox;
	}

	public WebElement getMobileNumber_TxtBox() {
		return mobileNumber_TxtBox;
	}

	public void setMobileNumber_TxtBox(WebElement mobileNumber_TxtBox) {
		this.mobileNumber_TxtBox = mobileNumber_TxtBox;
	}

	public WebElement getEnquiryDate_Dt() {
		return enquiryDate_Dt;
	}

	public void setEnquiryDate_Dt(WebElement enquiryDate_Dt) {
		this.enquiryDate_Dt = enquiryDate_Dt;
	}

	public WebElement getEnquiryType_DDL() {
		return enquiryType_DDL;
	}

	public void setEnquiryType_DDL(WebElement enquiryType_DDL) {
		this.enquiryType_DDL = enquiryType_DDL;
	}

	public WebElement getFirstName_TxtBox() {
		return firstName_TxtBox;
	}

	public void setFirstName_TxtBox(WebElement firstName_TxtBox) {
		this.firstName_TxtBox = firstName_TxtBox;
	}

	public WebElement getLastName_TxtBox() {
		return LastName_TxtBox;
	}

	public void setLastName_TxtBox(WebElement lastName_TxtBox) {
		LastName_TxtBox = lastName_TxtBox;
	}

	public WebElement getEmail_TxtBox() {
		return Email_TxtBox;
	}

	public void setEmail_TxtBox(WebElement email_TxtBox) {
		Email_TxtBox = email_TxtBox;
	}

	public WebElement getAltMobileNumber_TxtBox() {
		return AltMobileNumber_TxtBox;
	}

	public void setAltMobileNumber_TxtBox(WebElement altMobileNumber_TxtBox) {
		AltMobileNumber_TxtBox = altMobileNumber_TxtBox;
	}

	public WebElement getGender_RdBtn() {
		return Gender_RdBtn;
	}

	public void setGender_RdBtn(WebElement gender_RdBtn) {
		Gender_RdBtn = gender_RdBtn;
	}

	public WebElement getPreviousSchoolName_TxtBox() {
		return PreviousSchoolName_TxtBox;
	}

	public void setPreviousSchoolName_TxtBox(WebElement previousSchoolName_TxtBox) {
		PreviousSchoolName_TxtBox = previousSchoolName_TxtBox;
	}

	public WebElement getSelectCourse_RdBtn() {
		return SelectCourse_RdBtn;
	}

	public void setSelectCourse_RdBtn(WebElement selectCourse_RdBtn) {
		SelectCourse_RdBtn = selectCourse_RdBtn;
	}

	public WebElement getSelectSubCourse_RdBtn() {
		return SelectSubCourse_RdBtn;
	}

	public void setSelectSubCourse_RdBtn(WebElement selectSubCourse_RdBtn) {
		SelectSubCourse_RdBtn = selectSubCourse_RdBtn;
	}

	public WebElement getSelectGroup_RdBtn() {
		return SelectGroup_RdBtn;
	}

	public void setSelectGroup_RdBtn(WebElement selectGroup_RdBtn) {
		SelectGroup_RdBtn = selectGroup_RdBtn;
	}

	public WebElement getSelectSubject_ChkBox() {
		return SelectSubject_ChkBox;
	}

	public void setSelectSubject_ChkBox(WebElement selectSubject_ChkBox) {
		SelectSubject_ChkBox = selectSubject_ChkBox;
	}

	public WebElement getEstimatedFees_TxtBox() {
		return EstimatedFees_TxtBox;
	}

	public void setEstimatedFees_TxtBox(WebElement estimatedFees_TxtBox) {
		EstimatedFees_TxtBox = estimatedFees_TxtBox;
	}

	public WebElement getFinalFees_TxtBox() {
		return FinalFees_TxtBox;
	}

	public void setFinalFees_TxtBox(WebElement finalFees_TxtBox) {
		FinalFees_TxtBox = finalFees_TxtBox;
	}

	public WebElement getBatch_DDL() {
		return Batch_DDL;
	}

	public void setBatch_DDL(WebElement batch_DDL) {
		Batch_DDL = batch_DDL;
	}

	public WebElement getReferredByName_TxtBox() {
		return ReferredByName_TxtBox;
	}

	public void setReferredByName_TxtBox(WebElement referredByName_TxtBox) {
		ReferredByName_TxtBox = referredByName_TxtBox;
	}

	public WebElement getReferredByMobile_TxtBox() {
		return ReferredByMobile_TxtBox;
	}

	public void setReferredByMobile_TxtBox(WebElement referredByMobile_TxtBox) {
		ReferredByMobile_TxtBox = referredByMobile_TxtBox;
	}

	public WebElement getEnquiryOwner_TxtBox() {
		return EnquiryOwner_TxtBox;
	}

	public void setEnquiryOwner_TxtBox(WebElement enquiryOwner_TxtBox) {
		EnquiryOwner_TxtBox = enquiryOwner_TxtBox;
	}

	public WebElement getRemarks_TxtBox() {
		return Remarks_TxtBox;
	}

	public void setRemarks_TxtBox(WebElement remarks_TxtBox) {
		Remarks_TxtBox = remarks_TxtBox;
	}

	public WebElement getSelectEnquiry_Btn() {
		return SelectEnquiry_Btn;
	}

	public void setSelectEnquiry_Btn(WebElement selectEnquiry_Btn) {
		SelectEnquiry_Btn = selectEnquiry_Btn;
	}

	public WebElement getAddNew_Btn() {
		return AddNew_Btn;
	}

	public void setAddNew_Btn(WebElement addNew_Btn) {
		AddNew_Btn = addNew_Btn;
	}

	public WebElement getSave_Btn() {
		return Save_Btn;
	}

	public void setSave_Btn(WebElement save_Btn) {
		Save_Btn = save_Btn;
	}

	public WebElement getUpdate_Btn() {
		return Update_Btn;
	}

	public void setUpdate_Btn(WebElement update_Btn) {
		Update_Btn = update_Btn;
	}

	public WebElement getDelete_Btn() {
		return Delete_Btn;
	}

	public void setDelete_Btn(WebElement delete_Btn) {
		Delete_Btn = delete_Btn;
	}

	public Enquiry()
	{
		EnquiryID_TxtBox = driver.findElement(By.xpath(""));
		mobileNumber_TxtBox = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_txtMobileNo']"));
		enquiryDate_Dt = driver.findElement(By.xpath(""));
		
		 enquiryType_DDL = driver.findElement(By.xpath(""));
		 firstName_TxtBox = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_txtFirstName']"));
		 LastName_TxtBox = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_txtLastName']"));
		 Email_TxtBox = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_txtemailID']"));
		 AltMobileNumber_TxtBox = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_txtemailID']"));
		 Gender_RdBtn = driver.findElement(By.xpath("//span[@id='ContentPlaceHolder1_lblGender']/../.."));
		 PreviousSchoolName_TxtBox = driver.findElement(By.xpath(""));
		 SelectCourse_RdBtn = driver.findElement(By.xpath(""));
		 SelectSubCourse_RdBtn = driver.findElement(By.xpath(""));
		 SelectGroup_RdBtn = driver.findElement(By.xpath(""));
		 SelectSubject_ChkBox = driver.findElement(By.xpath(""));
		 EstimatedFees_TxtBox = driver.findElement(By.xpath(""));
		 FinalFees_TxtBox = driver.findElement(By.xpath(""));
		 Batch_DDL = driver.findElement(By.xpath(""));
		 ReferredByName_TxtBox = driver.findElement(By.xpath(""));
		 ReferredByMobile_TxtBox = driver.findElement(By.xpath(""));
		 EnquiryOwner_TxtBox = driver.findElement(By.xpath(""));
		 Remarks_TxtBox = driver.findElement(By.xpath(""));

		SelectEnquiry_Btn = driver.findElement(By.xpath(""));
		AddNew_Btn = driver.findElement(By.xpath(""));
		Save_Btn = driver.findElement(By.xpath(""));
		Update_Btn = driver.findElement(By.xpath(""));
		Delete_Btn = driver.findElement(By.xpath(""));
	}
	
	@Override
	public boolean verifyPageTitle(String... page) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyMendatoryFields(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

}
