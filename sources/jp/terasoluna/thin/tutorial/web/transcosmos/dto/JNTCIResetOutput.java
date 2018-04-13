package jp.terasoluna.thin.tutorial.web.transcosmos.dto;

public class JNTCIResetOutput {

	private String BKpageId =null;

	private String retCount = "";

	private String password = null;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRetCount() {
		return retCount;
	}

	public void setRetCount(String retCount) {
		this.retCount = retCount;
	}

	public String getBKpageId() {
		return BKpageId;
	}

	public void setBKpageId(String bKpageId) {
		BKpageId = bKpageId;
	}

}
