package jp.terasoluna.thin.tutorial.web.common.controller;

import jp.terasoluna.fw.dao.UpdateDAO;

/*删除表TT_MEETING_REMARK中过期的数据*/
public class DeleteMeetiongRemark {

	private UpdateDAO updateDAO;

	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	public void deleteMeetingRemark(){
		int number = updateDAO.execute("deleteMeetiongRemark", null);
		System.out.println(number);
	}

}
