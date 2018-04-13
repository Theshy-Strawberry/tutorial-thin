package jp.terasoluna.thin.tutorial.web.transcosmos.dto;

public class LoginOutput {

	/** USERID */
	private String userId ;
	/** USERNAME */
    private String userName = null;
    /** FLAG */
    private String flag = null;
    /** FLAGNAME */
    private String flagName = null;

    private String sendTo = null;

    private String password = null;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getFlagName() {
		return flagName;
	}

	public void setFlagName(String flagName) {
		this.flagName = flagName;
	}

	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
