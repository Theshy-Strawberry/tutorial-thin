package jp.terasoluna.thin.tutorial.web.transcosmos.vo;

public class JNTCISelectPersonalSkillInfo {

	private String classification;//区分
	private String softwarename;//ソフトウェア名
	private String sorts;//Version/種類
	private String skill_level;//レベル
	private String experienceyears;//経験年数
	private String userid;//员工id
	private int id;//id

	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public String getSoftwarename() {
		return softwarename;
	}
	public void setSoftwarename(String softwarename) {
		this.softwarename = softwarename;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getSkill_level() {
		return skill_level;
	}
	public void setSkill_level(String skill_level) {
		this.skill_level = skill_level;
	}
	public String getExperienceyears() {
		return experienceyears;
	}
	public void setExperienceyears(String experienceyears) {
		this.experienceyears = experienceyears;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSorts() {
		return sorts;
	}
	public void setSorts(String sorts) {
		this.sorts = sorts;
	}

	public JNTCISelectPersonalSkillInfo(){

	}

	public JNTCISelectPersonalSkillInfo(String classification,
			String softwarename, String sort, String userid, String level,
			String experienceyears, int id) {
		super();
		this.classification = classification;
		this.softwarename = softwarename;
		this.sorts = sort;
		this.userid = userid;
		this.skill_level = level;
		this.experienceyears = experienceyears;
		this.id = id;
	}

	@Override
	public String toString() {
		return "JNTCISelectPersonalSkillInfo [classification=" + classification
				+ ", softwarename=" + softwarename + ", sort=" + sorts
				+ ", userid=" + userid + ", level=" + skill_level
				+ ", experienceyears=" + experienceyears + ", id=" + id + "]";
	}



}
