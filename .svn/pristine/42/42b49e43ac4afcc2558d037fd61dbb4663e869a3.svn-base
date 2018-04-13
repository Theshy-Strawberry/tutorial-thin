package jp.terasoluna.thin.tutorial.web.common.controller;

import java.util.List;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import jp.terasoluna.fw.dao.QueryDAO;
/*将用户Mail信息存入properties中*/
public class UserMailSetToProperties {

	private QueryDAO queryDAO = null;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}
	public void writerToProperties(){
		Properties props = new Properties();
		String userMailFileName = "userMail.properties";
		String CodeAndMailFileName ="CodeAndMail.properties";
		String filePath = "D:/workspace/tutorial-thin/sources/";
//		下面这个才是真正的路径，上面这个是假的
//		String filePath = this.getClass().getResource("/").getFile();

		List<String> list = queryDAO.executeForObjectList("selectAllUserEMail", null);
		  try {
	            OutputStream fos = new FileOutputStream(filePath + userMailFileName);
	            for(int i=0;i<list.size();i++){
	            	String[] str = list.get(i).split("=");
	            	if(str.length == 2){
	            		props.setProperty(str[0], str[1]);
	            		props.store(fos, null);
	            		fos.flush();
	            		props.clear();
	            	}
	            }
	            fos.close();
	            OutputStream os = new FileOutputStream(filePath + CodeAndMailFileName);
	            for(int i=0;i<list.size();i++){
	            	String[] str = list.get(i).split("=");
	            	if(str.length == 2){
	            		props.setProperty(str[1], str[0]);
	            		props.store(os, null);
	            		os.flush();
	            		props.clear();
	            	}
	            }
	            os.close();
	        } catch (IOException e) {
	            System.err.println("なし");
	        }

	}

}
