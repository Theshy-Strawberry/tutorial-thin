package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.common.controller.Mail;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIMeetingInquireInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIMeetingInquireOutput;

public class JNTCIMeetingOffBLogic implements BLogic<JNTCIMeetingInquireInput> {

	private QueryDAO queryDAO;

	private UpdateDAO updateDAO;

	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCIMeetingInquireInput param) {

		JNTCIMeetingInquireOutput mailForCodeOutPut = queryDAO
				.executeForObject("selectMailForCode", param,
						JNTCIMeetingInquireOutput.class);
		if (mailForCodeOutPut != null) {
			if ((!"".equals(mailForCodeOutPut.getTo_id()))
					&& mailForCodeOutPut.getTo_id() != null) {

				//String filePath = "D:/workspace/tutorial-thin/sources/";
				// 下面这个才是真正的路径，上面这个是假的
				String filePath = this.getClass().getResource("/").getFile();
				Properties props = new Properties();
				String CodeAndMailFileName = "userMail.properties";
				String mails = "";
				InputStream in = null;

				try {
					in = new FileInputStream(filePath + CodeAndMailFileName);
					props.load(in);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				String toIdstr[] = mailForCodeOutPut.getTo_id().split(";");

				for (String to : toIdstr) {
					String value = props.getProperty(to);
					mails = mails + value + ";";
				}
				String mailsArray[] = mails.split(";");
				InternetAddress sendTo[] = new InternetAddress[mailsArray.length];

				for (int i = 0; i < mailsArray.length; i++) {
					try {
						sendTo[i] = new InternetAddress(mailsArray[i]);
					} catch (AddressException e) {
						e.printStackTrace();
					}
				}
				Mail.sendAll(props.getProperty(mailForCodeOutPut.getJn_card()),
						"123456", sendTo, null, null, "会議のキャンセル通知",
						"皆さん<br>お疲れ様です。" + mailForCodeOutPut.getUser_name()
								+ "です。<br>" + mailForCodeOutPut.getStart_time()
								+ "時の会議はキャンセルにした" + "<br>以上です、よろしくお願い致します。",
						null);
			}
		}

		updateDAO.execute("deleteMTRRemark", param);

		BLogicResult result = new BLogicResult();

		result.setResultString("success");

		return result;
	}

}
