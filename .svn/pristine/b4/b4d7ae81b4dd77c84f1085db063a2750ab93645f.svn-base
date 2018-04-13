package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;


import jp.terasoluna.fw.dao.QueryDAO;

import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquipListInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.SelectListOutput;

public class JNTCIEquipListDetailBlogic  implements BLogic<JNTCIEquipListInput>{

	private QueryDAO queryDAO = null;


	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCIEquipListInput param) {
		BLogicResult result = new BLogicResult();
		SelectListOutput setsubiDetail = queryDAO.executeForObject("getSetsubiDetail", param,SelectListOutput.class);
		SelectListOutput output = new SelectListOutput();
		output.setSetsubiNo(setsubiDetail.getSetsubiNo());
		output.setSetsubiJyoutai(setsubiDetail.getSetsubiJyoutai());  //設備状態
		output.setSetsubiShurui(setsubiDetail.getSetsubiShurui()); //設備種類
		output.setSetsubiKataban(setsubiDetail.getSetsubiKataban()); //設備型番
		output.setSetsubiKonyuhi(setsubiDetail.getSetsubiKonyuhi()); //購入日
		output.setSetsubiKonYusya(setsubiDetail.getSetsubiKonYusya());//購入者
		output.setSetsubiKiKaku(setsubiDetail.getSetsubiKiKaku());//設備規格
		output.setSetsubiKubun(setsubiDetail.getSetsubiKubun());//設備区分
		output.setSetsubiMaker(setsubiDetail.getSetsubiMaker()); //設備メーカー
		output.setSetsubiTanka(setsubiDetail.getSetsubiTanka()); //単価
		output.setCpu(setsubiDetail.getCpu()); //CPU
		output.setCpuHaichi(setsubiDetail.getCpuHaichi()); //CPU配置
		output.setMemori(setsubiDetail.getMemori()); //メモリ
		output.setHardDisk(setsubiDetail.getHardDisk()); //ハードディスク
		output.setHardDiskTotal(setsubiDetail.getHardDiskTotal()); //ハードディスク総量
		output.setMac(setsubiDetail.getMac()); //MACアドレス
		result.setResultObject(output);
		 result.setResultString("detail");
		return result;
	}

}
