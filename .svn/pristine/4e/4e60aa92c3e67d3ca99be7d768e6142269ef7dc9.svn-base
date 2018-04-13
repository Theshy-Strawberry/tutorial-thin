package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.ArrayList;
import java.util.List;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIBusinessApplicationInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIBusinessApplicationOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIBussness;

public class JNTCIBusinessBLogic implements
		BLogic<JNTCIBusinessApplicationInput> {

	public BLogicResult execute(JNTCIBusinessApplicationInput param) {

		BLogicResult result = new BLogicResult();

		List<JNTCIBussness> deptList = new ArrayList<JNTCIBussness>();
		JNTCIBussness arg2 = new JNTCIBussness();

		arg2.setLabel("選択...");
		arg2.setValue("0");
		JNTCIBussness arg0 = new JNTCIBussness();

		arg0.setLabel("日本事業部");
		arg0.setValue("1");
		JNTCIBussness arg1 = new JNTCIBussness();
		arg1.setLabel("国内事業部");
		arg1.setValue("2");

		deptList.add(arg2);
		deptList.add(arg0);
		deptList.add(arg1);
		JNTCIBusinessApplicationOutput output = new JNTCIBusinessApplicationOutput();
		output.setDeptList(deptList);
		result.setResultObject(output);
		result.setResultString("success");

		return result;
	}

}
