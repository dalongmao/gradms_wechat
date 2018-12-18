package top.lionstudio.form;


import java.util.List;


public class DoctorAnswerProclaimForm  {
	private String stuId;
	// 加入了一个普通电话的字段，与原来的对应有区别
	// 原来存手机号现存固定电话
	private String stuPhone;
	// 加入新变量存手机号
	private String stuMobile;

	private String whetherCheck;
	// 由原来的变量 int planCount 改为如下两个变量
	// 分别存储校内和校外的委员数目，与之做了相应改变的还有他们
	// get() set()
	private Integer planCountI;// 答辩委员会的人数

	private Integer planCountE;// 答辩委员会中博导人数
	private Integer planCountO;// 校外委员会成员
	private String thesisTopic;

	private String tutorName;
	private Integer tutorId;

	private String answerTime;

	private String answerPlace;

	private String stuCollege;

	private String stuMajor;

	private String stuName;

	private String stuType;

	private String stuNum;

	private String stuMajorName;

	private Integer stuMajorId;

	private String researchWay;

	private String memberId1;// 主席
	private String memberId2;
	private String commitMemberIdentity1;

	private String commitMemberIdentity2;

	private String commitMemberTitle1;

	private String commitMemberTitle2;

	private String isDoctorTutor1;

	private String isDoctorTutor2;

	private String belongUnit1;

	private String belongUnit2;

	private String commitMemberName1;

	private String commitMemberName2;

	private String commitMemberIdentity;

	private String isDoctorTutor;

	private String commitMemberTitle;

	private String belongUnit;

	private String commitMemberName;
	private Integer memberId;

	private String[] memberId_;
	private String[] commitMemberName_;

	private String[] commitMemberIdentity_;

	private String[] isDoctorTutor_;

	private String[] commitMemberTitle_;

	private String[] belongUnit_;
	private Integer[] personId_;
	private String title;

	private List majorList;

	private String checkOpinion;

	private String inOutSchool1;
	private String inOutSchool2;
	private String checkState;

	private int departmentId;

	private Integer flagI;

	private Integer flagE;
	private Integer flagT;
	private Integer flagS;
	private String college;
	private String applyTime;
	private String applySubject;// 申请专业
	
	private Boolean canEdit;
	
	private String gender;
	private String birthDate;
	private String masterDoctor;
	private String bachelorGradSchool;
	private String getBachelorDateSubject;
	private String masterGradSchool;
	private String getMasterDateSubject;
	private String entrYearMon;

	private String thesisFee;

	private String grade;// 成绩
	private String courseName;
	private String thesisTitle;
	private String startEndDate;

	private String auditName;
	private String duty;
	private String isphDTutor;
	private String workUnit;
	private String rank;
	private String level;
	private String levelName;
	
	private String leader;
	private String leaderduty;
	private String IsphDTutorz;// 主席是否硕导
	private String leaderworkUnit;

	private String committeeman;
	private String cduty;
	private String IsphDTutorc;
	private String cworkUnit;

	private String auditResult;
	private String research;
	private String result;

	private String disserName;// 论文名称
	private String magazineName;// 期刊名称
	private String publishTime;// 发表时间
	private String authOrder;// 作者位次
	private String disserKind;// 论文级别
	private String embodyInfo;// 收录情况
	

	// 人员查询
	private String perName;
	private Integer personId1;
	private Integer personId2;
	private Integer personId;
	private String perNum;
	private String identity;
	private String ctitle;
	private String belong;
	private String isDoctor;
	private String inOut;

	private String formName;
	private String nameProperty;
	private String ctitleProperty;
	private String belongProperty;
	private String isDoctorProperty;
	private String inOutProperty;
	private String person;
	private String flagX;
	private String personC;

	private Integer commentInfoId;
	private String operFlag;
	private String proId;
	private Integer commentAttachId;

	public String getPersonC() {
		return personC;
	}

	public void setPersonC(String personC) {
		this.personC = personC;
	}

	public String getFlagX() {
		return flagX;
	}

	public void setFlagX(String flagX) {
		this.flagX = flagX;
	}


	public Integer[] getPersonId_() {
		return personId_;
	}

	public void setPersonId_(Integer[] personId_) {
		this.personId_ = personId_;
	}

	public String getInOutSchool2() {
		return inOutSchool2;
	}

	public void setInOutSchool2(String inOutSchool2) {
		this.inOutSchool2 = inOutSchool2;
	}

	public Integer getFlagE() {
		return flagE;
	}

	public void setFlagE(Integer flagE) {
		this.flagE = flagE;
	}

	public Integer getFlagT() {
		return flagT;
	}

	public void setFlagT(Integer flagT) {
		this.flagT = flagT;
	}

	public Integer getFlagS() {
		return flagS;
	}

	public void setFlagS(Integer flagS) {
		this.flagS = flagS;
	}

	public Integer getPlanCountO() {
		return planCountO;
	}

	public void setPlanCountO(Integer planCountO) {
		this.planCountO = planCountO;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public Integer getPersonId1() {
		return personId1;
	}

	public void setPersonId1(Integer personId1) {
		this.personId1 = personId1;
	}

	public Integer getPersonId2() {
		return personId2;
	}

	public void setPersonId2(Integer personId2) {
		this.personId2 = personId2;
	}

	public String getDisserName() {
		return disserName;
	}

	public void setDisserName(String disserName) {
		this.disserName = disserName;
	}

	public String getMagazineName() {
		return magazineName;
	}

	public void setMagazineName(String magazineName) {
		this.magazineName = magazineName;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public String getAuthOrder() {
		return authOrder;
	}

	public void setAuthOrder(String authOrder) {
		this.authOrder = authOrder;
	}

	public String getDisserKind() {
		return disserKind;
	}

	public void setDisserKind(String disserKind) {
		this.disserKind = disserKind;
	}

	public String getEmbodyInfo() {
		return embodyInfo;
	}

	public void setEmbodyInfo(String embodyInfo) {
		this.embodyInfo = embodyInfo;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public String getApplySubject() {
		return applySubject;
	}

	public void setApplySubject(String applySubject) {
		this.applySubject = applySubject;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getMasterDoctor() {
		return masterDoctor;
	}

	public void setMasterDoctor(String masterDoctor) {
		this.masterDoctor = masterDoctor;
	}

	public String getBachelorGradSchool() {
		return bachelorGradSchool;
	}

	public void setBachelorGradSchool(String bachelorGradSchool) {
		this.bachelorGradSchool = bachelorGradSchool;
	}

	public String getGetBachelorDateSubject() {
		return getBachelorDateSubject;
	}

	public void setGetBachelorDateSubject(String getBachelorDateSubject) {
		this.getBachelorDateSubject = getBachelorDateSubject;
	}

	public String getMasterGradSchool() {
		return masterGradSchool;
	}

	public void setMasterGradSchool(String masterGradSchool) {
		this.masterGradSchool = masterGradSchool;
	}

	public String getGetMasterDateSubject() {
		return getMasterDateSubject;
	}

	public void setGetMasterDateSubject(String getMasterDateSubject) {
		this.getMasterDateSubject = getMasterDateSubject;
	}

	public String getEntrYearMon() {
		return entrYearMon;
	}

	public void setEntrYearMon(String entrYearMon) {
		this.entrYearMon = entrYearMon;
	}

	public String getThesisFee() {
		return thesisFee;
	}

	public void setThesisFee(String thesisFee) {
		this.thesisFee = thesisFee;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getThesisTitle() {
		return thesisTitle;
	}

	public void setThesisTitle(String thesisTitle) {
		this.thesisTitle = thesisTitle;
	}

	public String getStartEndDate() {
		return startEndDate;
	}

	public void setStartEndDate(String startEndDate) {
		this.startEndDate = startEndDate;
	}

	public String getAuditName() {
		return auditName;
	}

	public void setAuditName(String auditName) {
		this.auditName = auditName;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getIsphDTutor() {
		return isphDTutor;
	}

	public void setIsphDTutor(String isphDTutor) {
		this.isphDTutor = isphDTutor;
	}

	public String getWorkUnit() {
		return workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getLeaderduty() {
		return leaderduty;
	}

	public void setLeaderduty(String leaderduty) {
		this.leaderduty = leaderduty;
	}

	public String getIsphDTutorz() {
		return IsphDTutorz;
	}

	public void setIsphDTutorz(String isphDTutorz) {
		IsphDTutorz = isphDTutorz;
	}

	public String getLeaderworkUnit() {
		return leaderworkUnit;
	}

	public void setLeaderworkUnit(String leaderworkUnit) {
		this.leaderworkUnit = leaderworkUnit;
	}

	public String getCommitteeman() {
		return committeeman;
	}

	public void setCommitteeman(String committeeman) {
		this.committeeman = committeeman;
	}

	public String getCduty() {
		return cduty;
	}

	public void setCduty(String cduty) {
		this.cduty = cduty;
	}

	public String getIsphDTutorc() {
		return IsphDTutorc;
	}

	public void setIsphDTutorc(String isphDTutorc) {
		IsphDTutorc = isphDTutorc;
	}

	public String getCworkUnit() {
		return cworkUnit;
	}

	public void setCworkUnit(String cworkUnit) {
		this.cworkUnit = cworkUnit;
	}

	public String getAuditResult() {
		return auditResult;
	}

	public void setAuditResult(String auditResult) {
		this.auditResult = auditResult;
	}

	public String getResearch() {
		return research;
	}

	public void setResearch(String research) {
		this.research = research;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public Object[] toArray(Integer index) {
		Object[] obj = new Object[7];

		obj[0] = index;
		obj[1] = stuNum;
		obj[2] = stuName;
		if (whetherCheck.equals("1")) {
			obj[3] = "审核通过";
		} else if (whetherCheck.equals("0")) {
			obj[3] = "还未审核";
		} else if (whetherCheck.endsWith("2")) {
			obj[3] = "审核未通过ͨ��";
		} else if (whetherCheck.equals("3")) {
			obj[3] = "已修改";
		} else if (whetherCheck.equals("9")) {
			obj[3] = "学院审核通过";
		} else if (whetherCheck.equals("10")) {
			obj[3] = "学院审核未通过";
		}
		obj[4] = stuMajor;
		obj[5] = stuCollege;
		obj[6] = stuPhone == null ? "" : stuPhone;

		return obj;
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getStuPhone() {
		return stuPhone;
	}

	public void setStuPhone(String stuPhone) {
		this.stuPhone = stuPhone;
	}

	public String getStuMobile() {
		return stuMobile;
	}

	public void setStuMobile(String stuMobile) {
		this.stuMobile = stuMobile;
	}

	public String getWhetherCheck() {
		return whetherCheck;
	}

	public void setWhetherCheck(String whetherCheck) {
		this.whetherCheck = whetherCheck;
	}

	public Integer getPlanCountI() {
		return planCountI;
	}

	public void setPlanCountI(Integer planCountI) {
		this.planCountI = planCountI;
	}

	public Integer getPlanCountE() {
		return planCountE;
	}

	public void setPlanCountE(Integer planCountE) {
		this.planCountE = planCountE;
	}

	public String getThesisTopic() {
		return thesisTopic;
	}

	public void setThesisTopic(String thesisTopic) {
		this.thesisTopic = thesisTopic;
	}

	public String getTutorName() {
		return tutorName;
	}

	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}

	public Integer getTutorId() {
		return tutorId;
	}

	public void setTutorId(Integer tutorId) {
		this.tutorId = tutorId;
	}

	public String getAnswerTime() {
		return answerTime;
	}

	public void setAnswerTime(String answerTime) {
		this.answerTime = answerTime;
	}

	public String getAnswerPlace() {
		return answerPlace;
	}

	public void setAnswerPlace(String answerPlace) {
		this.answerPlace = answerPlace;
	}

	public String getStuCollege() {
		return stuCollege;
	}

	public void setStuCollege(String stuCollege) {
		this.stuCollege = stuCollege;
	}

	public String getStuMajor() {
		return stuMajor;
	}

	public void setStuMajor(String stuMajor) {
		this.stuMajor = stuMajor;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuType() {
		return stuType;
	}

	public void setStuType(String stuType) {
		this.stuType = stuType;
	}

	public String getStuNum() {
		return stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	public String getStuMajorName() {
		return stuMajorName;
	}

	public void setStuMajorName(String stuMajorName) {
		this.stuMajorName = stuMajorName;
	}

	public Integer getStuMajorId() {
		return stuMajorId;
	}

	public void setStuMajorId(Integer stuMajorId) {
		this.stuMajorId = stuMajorId;
	}

	public String getResearchWay() {
		return researchWay;
	}

	public void setResearchWay(String researchWay) {
		this.researchWay = researchWay;
	}

	public String getCommitMemberIdentity1() {
		return commitMemberIdentity1;
	}

	public void setCommitMemberIdentity1(String commitMemberIdentity1) {
		this.commitMemberIdentity1 = commitMemberIdentity1;
	}

	public String getCommitMemberIdentity2() {
		return commitMemberIdentity2;
	}

	public void setCommitMemberIdentity2(String commitMemberIdentity2) {
		this.commitMemberIdentity2 = commitMemberIdentity2;
	}

	public String getCommitMemberTitle1() {
		return commitMemberTitle1;
	}

	public void setCommitMemberTitle1(String commitMemberTitle1) {
		this.commitMemberTitle1 = commitMemberTitle1;
	}

	public String getCommitMemberTitle2() {
		return commitMemberTitle2;
	}

	public void setCommitMemberTitle2(String commitMemberTitle2) {
		this.commitMemberTitle2 = commitMemberTitle2;
	}

	public String getIsDoctorTutor1() {
		return isDoctorTutor1;
	}

	public void setIsDoctorTutor1(String isDoctorTutor1) {
		this.isDoctorTutor1 = isDoctorTutor1;
	}

	public String getIsDoctorTutor2() {
		return isDoctorTutor2;
	}

	public void setIsDoctorTutor2(String isDoctorTutor2) {
		this.isDoctorTutor2 = isDoctorTutor2;
	}

	public String getBelongUnit1() {
		return belongUnit1;
	}

	public void setBelongUnit1(String belongUnit1) {
		this.belongUnit1 = belongUnit1;
	}

	public String getBelongUnit2() {
		return belongUnit2;
	}

	public void setBelongUnit2(String belongUnit2) {
		this.belongUnit2 = belongUnit2;
	}

	public String getCommitMemberName1() {
		return commitMemberName1;
	}

	public void setCommitMemberName1(String commitMemberName1) {
		this.commitMemberName1 = commitMemberName1;
	}

	public String getCommitMemberName2() {
		return commitMemberName2;
	}

	public void setCommitMemberName2(String commitMemberName2) {
		this.commitMemberName2 = commitMemberName2;
	}

	public String getCommitMemberIdentity() {
		return commitMemberIdentity;
	}

	public void setCommitMemberIdentity(String commitMemberIdentity) {
		this.commitMemberIdentity = commitMemberIdentity;
	}

	public String getIsDoctorTutor() {
		return isDoctorTutor;
	}

	public void setIsDoctorTutor(String isDoctorTutor) {
		this.isDoctorTutor = isDoctorTutor;
	}

	public String getCommitMemberTitle() {
		return commitMemberTitle;
	}

	public void setCommitMemberTitle(String commitMemberTitle) {
		this.commitMemberTitle = commitMemberTitle;
	}

	public String getBelongUnit() {
		return belongUnit;
	}

	public void setBelongUnit(String belongUnit) {
		this.belongUnit = belongUnit;
	}

	public String getCommitMemberName() {
		return commitMemberName;
	}

	public void setCommitMemberName(String commitMemberName) {
		this.commitMemberName = commitMemberName;
	}

	public String[] getCommitMemberName_() {
		return commitMemberName_;
	}

	public void setCommitMemberName_(String[] commitMemberName_) {
		this.commitMemberName_ = commitMemberName_;
	}

	public String[] getCommitMemberIdentity_() {
		return commitMemberIdentity_;
	}

	public void setCommitMemberIdentity_(String[] commitMemberIdentity_) {
		this.commitMemberIdentity_ = commitMemberIdentity_;
	}

	public String[] getIsDoctorTutor_() {
		return isDoctorTutor_;
	}

	public void setIsDoctorTutor_(String[] isDoctorTutor_) {
		this.isDoctorTutor_ = isDoctorTutor_;
	}

	public String[] getCommitMemberTitle_() {
		return commitMemberTitle_;
	}

	public void setCommitMemberTitle_(String[] commitMemberTitle_) {
		this.commitMemberTitle_ = commitMemberTitle_;
	}

	public String[] getBelongUnit_() {
		return belongUnit_;
	}

	public void setBelongUnit_(String[] belongUnit_) {
		this.belongUnit_ = belongUnit_;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List getMajorList() {
		return majorList;
	}

	public void setMajorList(List majorList) {
		this.majorList = majorList;
	}

	public String getCheckOpinion() {
		return checkOpinion;
	}

	public void setCheckOpinion(String checkOpinion) {
		this.checkOpinion = checkOpinion;
	}

	public String getInOutSchool1() {
		return inOutSchool1;
	}

	public void setInOutSchool1(String inOutSchool1) {
		this.inOutSchool1 = inOutSchool1;
	}

	public String getCheckState() {
		return checkState;
	}

	public void setCheckState(String checkState) {
		this.checkState = checkState;
	}

	public Integer getFlagI() {
		return flagI;
	}

	public void setFlagI(Integer flagI) {
		this.flagI = flagI;
	}

	public String getPerName() {
		return perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}

	public String getPerNum() {
		return perNum;
	}

	public void setPerNum(String perNum) {
		this.perNum = perNum;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getCtitle() {
		return ctitle;
	}

	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}

	public String getBelong() {
		return belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}

	public String getIsDoctor() {
		return isDoctor;
	}

	public void setIsDoctor(String isDoctor) {
		this.isDoctor = isDoctor;
	}

	public String getInOut() {
		return inOut;
	}

	public void setInOut(String inOut) {
		this.inOut = inOut;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getNameProperty() {
		return nameProperty;
	}

	public void setNameProperty(String nameProperty) {
		this.nameProperty = nameProperty;
	}

	public String getCtitleProperty() {
		return ctitleProperty;
	}

	public void setCtitleProperty(String ctitleProperty) {
		this.ctitleProperty = ctitleProperty;
	}

	public String getBelongProperty() {
		return belongProperty;
	}

	public void setBelongProperty(String belongProperty) {
		this.belongProperty = belongProperty;
	}

	public String getIsDoctorProperty() {
		return isDoctorProperty;
	}

	public void setIsDoctorProperty(String isDoctorProperty) {
		this.isDoctorProperty = isDoctorProperty;
	}

	public String getInOutProperty() {
		return inOutProperty;
	}

	public void setInOutProperty(String inOutProperty) {
		this.inOutProperty = inOutProperty;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String[] getMemberId_() {
		return memberId_;
	}

	public void setMemberId_(String[] memberId_) {
		this.memberId_ = memberId_;
	}

	public String getMemberId1() {
		return memberId1;
	}

	public void setMemberId1(String memberId1) {
		this.memberId1 = memberId1;
	}

	public String getMemberId2() {
		return memberId2;
	}

	public void setMemberId2(String memberId2) {
		this.memberId2 = memberId2;
	}

	public Integer getCommentInfoId() {
		return commentInfoId;
	}

	public void setCommentInfoId(Integer commentInfoId) {
		this.commentInfoId = commentInfoId;
	}

	public String getOperFlag() {
		return operFlag;
	}

	public void setOperFlag(String operFlag) {
		this.operFlag = operFlag;
	}

	public Boolean getCanEdit() {
		return canEdit;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public void setCanEdit(Boolean canEdit) {
		this.canEdit = canEdit;
	}

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public Integer getCommentAttachId() {
		return commentAttachId;
	}

	public void setCommentAttachId(Integer commentAttachId) {
		this.commentAttachId = commentAttachId;
	}
	
}
