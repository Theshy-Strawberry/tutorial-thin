package jp.terasoluna.thin.tutorial.web.transcosmos.vo;

public class JNTCIAddsignVO {
	private String JN_CARD;//卡号
	//private double kojyo_time;//扣除的时间
	 private String retroactive_status ;//审查状态
	 private String ym;//年月
	public String getJN_CARD() {
		return JN_CARD;
	}
	public void setJN_CARD(String jN_CARD) {
		JN_CARD = jN_CARD;
	}
	public String getRetroactive_status() {
		return retroactive_status;
	}
	public void setRetroactive_status(String retroactive_status) {
		this.retroactive_status = retroactive_status;
	}
	public String getYm() {
		return ym;
	}
	public void setYm(String ym) {
		this.ym = ym;
	}
}
