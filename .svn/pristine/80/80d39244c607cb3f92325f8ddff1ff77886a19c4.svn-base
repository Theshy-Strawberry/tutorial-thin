package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.Date;
import java.util.List;
import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.thin.tutorial.web.common.controller.Constant;
import jp.terasoluna.thin.tutorial.web.common.controller.DateController;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquipInsertInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquipInsertOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.SelectSetsubiKataban;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.SelectSetsubiKonyuhi;

public class JNTCIEquipInsertBLogic01 implements BLogic<JNTCIEquipInsertInput> {

	/**
	 * QueryDAO Springによりインスタンス生成され設定される。
	 */
	private QueryDAO queryDAO = null;

	/**
	 * 設備種類によりDBの中で最大設備番号を検索する
	 *
	 * @return
	 */
	public BLogicResult execute(JNTCIEquipInsertInput param) {

		BLogicResult result = new BLogicResult();
		JNTCIEquipInsertOutput output = new JNTCIEquipInsertOutput();
		//設備種類
		String code=param.getSetsubi_kuben();
		List<SelectSetsubiKataban> katabanList =null;
		List<SelectSetsubiKonyuhi> konyuhiList =null;

		if(code==null){
		katabanList = queryDAO.executeForObjectList("setsubiKatabanList", param);
		konyuhiList = queryDAO.executeForObjectList("setsubiKonyuhiList", param);
		output.setSetsubi_kataban(param.getSetsubi_kataban());
		output.setSetsubiKatabanList(katabanList);
		output.setSetsubi_no(param.getSetsubi_no());
		output.setSetsubiKonyuhiList(konyuhiList);
		result.setResultObject(output);
		result.setResultString("success");
		return result;
		}
		// データベースで設備番号の最大値を得る
		String maxSetsubino = queryDAO.executeForObject("selectMaxSetsubiNo",
				param, String.class);
		 katabanList = queryDAO.executeForObjectList("setsubiKatabanList", param);
		 konyuhiList = queryDAO.executeForObjectList("setsubiKonyuhiList", param);
		 if(param.getDousa() != null){
          if( "1".equals(param.getDousa())){

        	  output.setSetsubiKatabanList(katabanList);
      		output.setSetsubiKonyuhiList(konyuhiList);
      		output.setSetsubi_kataban(param.getSetsubi_kataban());
      		output.setSetsubi_no(param.getSetsubi_no());
      		result.setResultObject(output);
      		result.setResultString("success");
      		return result;
          }
          }
		 if(katabanList.size()==0){

			 output.setSetsubiKatabanList(katabanList);
			 output.setSetsubiKonyuhiList(konyuhiList);
			result.setResultObject(output);
			BLogicMessages messages = new BLogicMessages();
			messages.add("massage", new BLogicMessage("JNTCIEquip.setsubiKataban"));
			result.setMessages(messages);
			result.setResultString("failure");
			return result;
		 }

		// システム時間を取得する
		String time = DateController.getDateToString(new Date(),
				DateController.YYMM);
		String toDate = "-" + time + "-";
		// 番号が存在しない場合
		if (maxSetsubino == null) {
			String setsubino01 = param.getSetsubi_kuben() + toDate + "001";

			output.setSetsubiKatabanList(katabanList);
			output.setSetsubiKonyuhiList(konyuhiList);
			output.setSetsubi_no(setsubino01);
			result.setResultObject(output);
			result.setResultString("success");
			return result;
		}
		// 取得した番号の切り取る
		// AAA
		String setsubino02 = Constant.getSetsubinoSub01(maxSetsubino);
		// -yyMM-
		String setsubino03 = Constant.getSetsubinoSub02(maxSetsubino);
		// xxx
		String setsunino04 = Constant.getSetsubinoSub03(maxSetsubino);

		// 取得した番号の中の年月とシステム年月が等しくない時
		if (!(setsubino03.equals(toDate))) {
			String setsubino01 = param.getSetsubi_kuben() + toDate + "001";

			output.setSetsubiKatabanList(katabanList);
			output.setSetsubiKonyuhiList(konyuhiList);
			output.setSetsubi_no(setsubino01);
			result.setResultObject(output);
			result.setResultString("success");
			return result;
		}
		// 取得した番号の後3位と999が比較
		if (setsunino04.compareTo(Constant.MAXNO) >= 0) {

			BLogicMessages messages = new BLogicMessages();
			messages.add("massage", new BLogicMessage("errors.insert.without"));
			result.setErrors(messages);
			result.setResultString("failure");
			return result;
		}
		// 取得した番号の後3位，+1
		String maxsetsubino = "";
		String added = String.valueOf(Integer.parseInt(setsunino04) + 1);
		if (added.length() == 3) {
			maxsetsubino = setsubino02 + setsubino03 + String.valueOf(added);
		} else if (added.length() == 2) {
			maxsetsubino = setsubino02 + setsubino03 + "0"
					+ String.valueOf(added);
		} else {
			maxsetsubino = setsubino02 + setsubino03 + "00"
					+ String.valueOf(added);
		}

		output.setSetsubi_no(maxsetsubino);
		output.setSetsubiKatabanList(katabanList);
		output.setSetsubiKonyuhiList(konyuhiList);
		result.setResultObject(output);
		result.setResultString("success");
		return result;

	}

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

}
