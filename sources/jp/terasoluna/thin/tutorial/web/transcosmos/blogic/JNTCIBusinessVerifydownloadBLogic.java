package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;




import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.fw.web.struts.actions.DownloadFile;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIBusinessVerify01Input;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIBusinessVerifyVo;

public class JNTCIBusinessVerifydownloadBLogic implements BLogic<JNTCIBusinessVerify01Input> {

	private QueryDAO queryDAO = null;

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}


    public BLogicResult execute(JNTCIBusinessVerify01Input param) {

    	if (param.getEvectionId() == null) {
    		param.setEvectionId(param.getUserId());
    	}

    	JNTCIBusinessVerifyVo JNTCIBusinessVerifyVo = queryDAO.executeForObject("selectdownloadInfo", param,
    			JNTCIBusinessVerifyVo.class);

    	//出差人一览信息
    	List<JNTCIBusinessVerifyVo> JNTCIBusinessVerifyVoList = queryDAO.executeForObjectList("selectdownloadInfoList", param);
    	String[] article_NAME = null;

	       String arcticStr = JNTCIBusinessVerifyVo.getArticleName();
	       if(arcticStr != null){
	       		if(arcticStr.indexOf(";")>0){
	       			article_NAME = arcticStr.split(";");
	       		}else{
	       			article_NAME = arcticStr.split("");
	       		}

	       }
	       JNTCIBusinessVerifyVo.setArticle_NAME(article_NAME);
    	//模板文件：
    	String realpath = this.getClass().getClassLoader().getResource("").getPath() + "travelManagement.xls";
    	String resultPath = "D:/" + JNTCIBusinessVerifyVo.getUserId()+"_"+JNTCIBusinessVerifyVo.getUserName()+"_テンプレート.xls";
    	try{
    		POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(realpath));
    		HSSFWorkbook wb = new HSSFWorkbook(fs);

    		HSSFSheet sheet = wb.getSheetAt(1);
    		HSSFCell cell = sheet.getRow(2).getCell(6);
    		cell.setCellValue(JNTCIBusinessVerifyVo.getEvectionReason());
    		cell = sheet.getRow(2).getCell(27);
    		cell.setCellValue(JNTCIBusinessVerifyVo.getEvectionStartTime());
    		cell = sheet.getRow(2).getCell(33);
    		cell.setCellValue(JNTCIBusinessVerifyVo.getEvectionEndTime());
    		cell = sheet.getRow(17).getCell(5);
    		cell.setCellValue(JNTCIBusinessVerifyVo.getTrafficExplain());
    		cell = sheet.getRow(17).getCell(31);
    		cell.setCellValue(JNTCIBusinessVerifyVo.getTrafficReservetPerson());
    		cell = sheet.getRow(24).getCell(5);
    		cell.setCellValue(JNTCIBusinessVerifyVo.getHotelExplain());
    		cell = sheet.getRow(24).getCell(31);
    		cell.setCellValue(JNTCIBusinessVerifyVo.getHotelReservePerson());


    		//出差人一览信息
    		if(JNTCIBusinessVerifyVoList != null){
    			//卡号
    			int index = 5;
    			for (JNTCIBusinessVerifyVo vo : JNTCIBusinessVerifyVoList) {
    				cell = sheet.getRow(index).getCell(2);
    	    		cell.setCellValue(vo.getUserId());
    				index += 1;
    			}
    			//姓名
    			index = 5;
    			for (JNTCIBusinessVerifyVo vo : JNTCIBusinessVerifyVoList) {
    				cell = sheet.getRow(index).getCell(5);
    	    		cell.setCellValue(vo.getUserName());
    				index += 1;
    			}
    			//部门
    			index = 5;
    			for (JNTCIBusinessVerifyVo vo : JNTCIBusinessVerifyVoList) {
    				cell = sheet.getRow(index).getCell(9);
    	    		cell.setCellValue(vo.getDeptId());
    				index += 1;
    			}
    			//性别
    			index = 5;
    			for (JNTCIBusinessVerifyVo vo : JNTCIBusinessVerifyVoList) {
    				cell = sheet.getRow(index).getCell(17);
    	    		cell.setCellValue(vo.getSex());
    				index += 1;
    			}
    			//职位编号
    			index = 5;
    			for (JNTCIBusinessVerifyVo vo : JNTCIBusinessVerifyVoList) {
    				cell = sheet.getRow(index).getCell(20);
    	    		cell.setCellValue(vo.getPositionId());
    				index += 1;
    			}
    			//劳动关系所属地
    			index = 5;
    			for (JNTCIBusinessVerifyVo vo : JNTCIBusinessVerifyVoList) {
    				cell = sheet.getRow(index).getCell(24);
    	    		cell.setCellValue(vo.getDependency());
    				index += 1;
    			}
    			//出差地
    			index = 5;
    			for (JNTCIBusinessVerifyVo vo : JNTCIBusinessVerifyVoList) {
    				cell = sheet.getRow(index).getCell(29);
    	    		cell.setCellValue(vo.getEvectionDestination());
    				index += 1;
    			}
    			//项目编号
    			index = 5;
    			for (JNTCIBusinessVerifyVo vo : JNTCIBusinessVerifyVoList) {
    				cell = sheet.getRow(index).getCell(33);
    	    		cell.setCellValue(vo.getProjectId());
    				index += 1;
    			}
    		}

    			//交通预订需求
        		if(JNTCIBusinessVerifyVoList != null){
        			//姓名
        			int index = 12;
        			for (JNTCIBusinessVerifyVo vo : JNTCIBusinessVerifyVoList) {
        				cell = sheet.getRow(index).getCell(2);
        	    		cell.setCellValue(vo.getUserName());
        				index += 1;
        			}

        			//身份证号
        			index = 12;
        			for (JNTCIBusinessVerifyVo vo : JNTCIBusinessVerifyVoList) {
        				cell = sheet.getRow(index).getCell(6);
        	    		cell.setCellValue(vo.getIdCard());
        				index += 1;
        			}

        			//出发时间
        			index = 12;
        			for (JNTCIBusinessVerifyVo vo : JNTCIBusinessVerifyVoList) {
        				cell = sheet.getRow(index).getCell(12);
        	    		cell.setCellValue(vo.getDepartureTime());
        				index += 1;
        			}

        			//出发地点
        			index = 12;
        			for (JNTCIBusinessVerifyVo vo : JNTCIBusinessVerifyVoList) {
        				cell = sheet.getRow(index).getCell(17);
        	    		cell.setCellValue(vo.getLeave());
        				index += 1;
        			}

        			//到达地点
        			index = 12;
        			for (JNTCIBusinessVerifyVo vo : JNTCIBusinessVerifyVoList) {
        				cell = sheet.getRow(index).getCell(21);
        	    		cell.setCellValue(vo.getReachPlace());
        				index += 1;
        			}

        			//姓名拼音
        			index = 12;
        			for (JNTCIBusinessVerifyVo vo : JNTCIBusinessVerifyVoList) {
        				cell = sheet.getRow(index).getCell(25);
        	    		cell.setCellValue(vo.getNamePinyin());
        				index += 1;
        			}

        			//护照号
        			index = 12;
        			for (JNTCIBusinessVerifyVo vo : JNTCIBusinessVerifyVoList) {
        				cell = sheet.getRow(index).getCell(30);
        	    		cell.setCellValue(vo.getPassportId());
        				index += 1;
        			}

        			//护照有效期
        			index = 12;
        			for (JNTCIBusinessVerifyVo vo : JNTCIBusinessVerifyVoList) {
        				cell = sheet.getRow(index).getCell(34);
        	    		cell.setCellValue(vo.getPassportValidity());
        				index += 1;
        			}

		}

        		//住宿预订需求
        		if(JNTCIBusinessVerifyVoList != null){
        			//住宿时间
        			int index = 21;
        			for (JNTCIBusinessVerifyVo vo : JNTCIBusinessVerifyVoList) {
        				cell = sheet.getRow(index).getCell(2);
        	    		cell.setCellValue(vo.getHotelStartTime());
        				index += 1;
        			}

        			//退宿时间
        			index = 21;
        			for (JNTCIBusinessVerifyVo vo : JNTCIBusinessVerifyVoList) {
        				cell = sheet.getRow(index).getCell(7);
        	    		cell.setCellValue(vo.getHotelEndtime());
        				index += 1;
        			}

        			//住宿地点
        			index = 21;
        			for (JNTCIBusinessVerifyVo vo : JNTCIBusinessVerifyVoList) {
        				cell = sheet.getRow(index).getCell(12);
        	    		cell.setCellValue(vo.getHotelDestination());
        				index += 1;
        			}

        			//住宿人
        			index = 21;
        			for (JNTCIBusinessVerifyVo vo : JNTCIBusinessVerifyVoList) {
        				cell = sheet.getRow(index).getCell(19);
        	    		cell.setCellValue(vo.getHotelPerson());
        				index += 1;
        			}

        			//住宿人数
        			index = 21;
        			for (JNTCIBusinessVerifyVo vo : JNTCIBusinessVerifyVoList) {
        				cell = sheet.getRow(index).getCell(35);
        	    		cell.setCellValue(vo.getHotelNumber());
        				index += 1;
        			}
        			for(JNTCIBusinessVerifyVo vo : JNTCIBusinessVerifyVoList){
        				if("A01".equals(vo.getExamineStatus())||"A06".equals(vo.getExamineStatus())||"A08".equals(vo.getExamineStatus())){
        				index = 30;
        				cell = sheet.getRow(index).getCell(2);
        				cell.setCellValue("王德鹏");
            			}
        				if("A06".equals(vo.getExamineStatus())||"A08".equals(vo.getExamineStatus())){
            				index =30;
            				cell = sheet.getRow(index).getCell(14);
            				cell.setCellValue("张栋");
            				}
        				if("A06".equals(vo.getExamineStatus())){
            				index=34;
            				cell = sheet.getRow(index).getCell(2);
            				cell.setCellValue("田東启");
        				}
        			}
        			//护照长短
        			index = 44;
        			for(JNTCIBusinessVerifyVo vo : JNTCIBusinessVerifyVoList){
        				if("0".equals(vo.getPassportLength())){
        					cell = sheet.getRow(index).getCell(27);
        					cell.setCellValue("√");
        				}else{
        					cell = sheet.getRow(index).getCell(30);
        					cell.setCellValue("√");
        			}
        		}
		}

        		//物品移交
        		if(article_NAME != null){
        		  for(int i=0;i<article_NAME.length;i++){
       	    	   String s = article_NAME[i];
       	    	   if("1".equals(s)){
       	    		cell = sheet.getRow(40).getCell(7);
            		cell.setCellValue(JNTCIBusinessVerifyVo.getRecipient());
            		cell = sheet.getRow(40).getCell(13);
            		cell.setCellValue(JNTCIBusinessVerifyVo.getTransferStartTime());
            		cell = sheet.getRow(40).getCell(17);
            		cell.setCellValue(JNTCIBusinessVerifyVo.getRecipient());
            		cell = sheet.getRow(40).getCell(23);
            		cell.setCellValue(JNTCIBusinessVerifyVo.getTransferEndTime());
       	    	}else if("2".equals(s)){
       	    		cell = sheet.getRow(41).getCell(7);
            		cell.setCellValue(JNTCIBusinessVerifyVo.getRecipient());
            		cell = sheet.getRow(41).getCell(13);
            		cell.setCellValue(JNTCIBusinessVerifyVo.getTransferStartTime());
            		cell = sheet.getRow(41).getCell(17);
            		cell.setCellValue(JNTCIBusinessVerifyVo.getRecipient());
            		cell = sheet.getRow(41).getCell(23);
            		cell.setCellValue(JNTCIBusinessVerifyVo.getTransferEndTime());
       	    	}else if("3".equals(s)){
       	    		cell = sheet.getRow(42).getCell(7);
            		cell.setCellValue(JNTCIBusinessVerifyVo.getRecipient());
            		cell = sheet.getRow(42).getCell(13);
            		cell.setCellValue(JNTCIBusinessVerifyVo.getTransferStartTime());
            		cell = sheet.getRow(42).getCell(17);
            		cell.setCellValue(JNTCIBusinessVerifyVo.getRecipient());
            		cell = sheet.getRow(42).getCell(23);
            		cell.setCellValue(JNTCIBusinessVerifyVo.getTransferEndTime());
       	    	}else if("4".equals(s)){
       	    		cell = sheet.getRow(43).getCell(7);
            		cell.setCellValue(JNTCIBusinessVerifyVo.getRecipient());
            		cell = sheet.getRow(43).getCell(13);
            		cell.setCellValue(JNTCIBusinessVerifyVo.getTransferStartTime());
            		cell = sheet.getRow(43).getCell(17);
            		cell.setCellValue(JNTCIBusinessVerifyVo.getRecipient());
            		cell = sheet.getRow(43).getCell(23);
            		cell.setCellValue(JNTCIBusinessVerifyVo.getTransferEndTime());
       	    	}else if("5".equals(s)){
       	    		cell = sheet.getRow(44).getCell(7);
            		cell.setCellValue(JNTCIBusinessVerifyVo.getRecipient());
            		cell = sheet.getRow(44).getCell(13);
            		cell.setCellValue(JNTCIBusinessVerifyVo.getTransferStartTime());
            		cell = sheet.getRow(44).getCell(17);
            		cell.setCellValue(JNTCIBusinessVerifyVo.getRecipient());
            		cell = sheet.getRow(44).getCell(23);
            		cell.setCellValue(JNTCIBusinessVerifyVo.getTransferEndTime());
       	    	}else if("6".equals(s)){
       	    		cell = sheet.getRow(45).getCell(7);
            		cell.setCellValue(JNTCIBusinessVerifyVo.getRecipient());
            		cell = sheet.getRow(45).getCell(13);
            		cell.setCellValue(JNTCIBusinessVerifyVo.getTransferStartTime());
            		cell = sheet.getRow(45).getCell(23);
            		cell.setCellValue(JNTCIBusinessVerifyVo.getTransferEndTime());
            		cell = sheet.getRow(45).getCell(17);
            		cell.setCellValue(JNTCIBusinessVerifyVo.getRecipient());
       	    	}
       	       }
        		}

        		cell = sheet.getRow(42).getCell(31);
        		cell.setCellValue(JNTCIBusinessVerifyVo.getStorAges());
    		FileOutputStream out = new FileOutputStream(resultPath);
            wb.write(out);
    		wb.close();
    		out.close();
    	}catch(Exception e){
    		e.printStackTrace();

    	}


    	BLogicResult result = new BLogicResult();
    	File file = new File(resultPath);
    	if(!file.exists()){
    		try {
    			file.createNewFile();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    	DownloadFile downloadFile = new DownloadFile(file);
    	result.setResultObject(downloadFile);
    	return result;
    }


	public void someThing(String s) {

	}

}
