package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquipListInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquipListOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEquip02equip;





public class JNTCIEquipEditorListBlogic implements BLogic<JNTCIEquipListInput> {
	private QueryDAO queryDAO = null;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCIEquipListInput param){
		JNTCIEquipListOutput output = new JNTCIEquipListOutput();

		JNTCIEquipListOutput JNTCIEquip06 = queryDAO.executeForObject(
				"getEquipeditor", param, JNTCIEquipListOutput.class);

		List<JNTCIEquip02equip> jNTCIEquip02equip = queryDAO
				.executeForObjectList("getEquipeditor2",
						param);

		JNTCIEquip02equip currentEquip02equip = new JNTCIEquip02equip();
		currentEquip02equip.setEquipID(JNTCIEquip06.getUserpg());
		jNTCIEquip02equip.add(0, currentEquip02equip);
		BLogicResult result = new BLogicResult();

        output.setUserpg(JNTCIEquip06.getUserpg());
		output.setSetsubi_kuben(JNTCIEquip06.getSetsubi_kuben());
		output.setSetsubi_kataban(JNTCIEquip06.getSetsubi_kataban());
		output.setKounyu_hiduke(JNTCIEquip06.getKounyu_hiduke());
		output.setMac_address(JNTCIEquip06.getMac_address());
		output.setSetsubi_no(JNTCIEquip06.getSetsubi_no());
		output.setTanaoroshi_hiduke(JNTCIEquip06.getTanaoroshi_hiduke());
		output.setSetsubi_kanaoroshi_no(JNTCIEquip06.getSetsubi_kanaoroshi_no());
		output.setTanaoroshi_user(JNTCIEquip06.getTanaoroshi_user());
		output.setShunyuko_no(JNTCIEquip06.getShunyuko_no());
		output.setShunyuko_date(JNTCIEquip06.getShunyuko_date());
		output.setYouto(JNTCIEquip06.getYouto());
		output.setEquipLocation(JNTCIEquip06.getEquipLocation());

		output.setStartIndex(param.getStartIndex());
		output.setCode(param.getCode());
		output.setDeptId(param.getDeptId());
		output.setUserId(param.getUserId());
		output.setSetsubiKubun(param.getSetsubiKubun());
		result.setResultObject(output);
		result.setResultString("success");

		return result;






	}

}
