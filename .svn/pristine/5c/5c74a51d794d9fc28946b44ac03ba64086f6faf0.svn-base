package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.io.UnsupportedEncodingException;
import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.fw.web.taglib.TrimTag;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAddsignInfoInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAddsignInfoOut;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance06GetTypeListDto;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIAddsignInfoVo;

public class JNTCIAddsignInfoBLogic implements BLogic<JNTCIAddsignInfoInput> {
    private QueryDAO queryDAO = null;

    public void setQueryDAO(QueryDAO queryDAO) {
        this.queryDAO = queryDAO;
    }

    public BLogicResult execute(JNTCIAddsignInfoInput arg0) {
        String strIndex = arg0.getStartIndex();
        String strRow = arg0.getRow();
        String sureId_card001 = null;
        String sureId_card = arg0.getSureId_card();
        if(sureId_card != null){
         sureId_card001 = sureId_card.replace(" ", "");}
    	BLogicResult result = new BLogicResult();


    	if("aa".equals(arg0.getMark())){
        	if(arg0.getUSER_NAME_SEARCH()!=null &&!"reset".equals(arg0.getCod())){
        		try {
        			arg0.setUSER_NAME_SEARCH(new String(arg0.getUSER_NAME_SEARCH().getBytes("ISO-8859-1"),"utf-8"));
    			} catch (UnsupportedEncodingException e) {
    				e.printStackTrace();
    			}
    		}
     }else{}




        int startIndex = 0;
        int row = 10;
        if (strIndex != null) {
            startIndex = Integer.parseInt(strIndex);
        }

        if (strRow != null) {
            row = Integer.parseInt(strRow);
        }
        JNTCIAddsignInfoOut infoOut = new JNTCIAddsignInfoOut();
        String totalcount = null;
        List<JNTCIAddsignInfoVo> addsignInfoList = null;
       // List<JNTCIAddsignInfoVo> addsignInfoList1 = null;
        List<JNTCIAttendance06GetTypeListDto> attendance06SelectRecOutput = null;
        if (arg0.getUSER_NAME_SEARCH() != null
                && !"".equals(arg0.getUSER_NAME_SEARCH())) {
        	String  str=arg0.getUSER_NAME_SEARCH();
        	str=str.trim();
        	arg0.setUSER_NAME_SEARCH(str);
        }
        BLogicMessages messages = new BLogicMessages();

        if ("代宇珍".equals(arg0.getUserName())) {
        	totalcount= queryDAO.executeForObject("infoListCount1", arg0,String.class);

            if(startIndex>= Integer.parseInt(totalcount)){
            	startIndex=startIndex-10;
                if(startIndex<0){
                	startIndex=0;
                }
            }
            if("0".equals(totalcount)){
            	messages.add("message",
                       new BLogicMessage("message.null"));
            }else {
	            addsignInfoList = queryDAO.executeForObjectList("infoList1", arg0, startIndex, row);
	            infoOut.setAddsignInfoList(addsignInfoList);
            }
        }
        else  if("張棟".equals(arg0.getUserName())){
        // TODO 自動生成されたメソッド・スタブ
        	//totalcount1 = queryDAO.executeForObject("infoListCount2", arg0,String.class);
        	totalcount = queryDAO.executeForObject("infoListCount2", arg0,String.class);
        	//int  a=Integer.parseInt(totalcount1);
        	//int  b=Integer.parseInt(totalcount2);

                //totalcount=Integer.toHexString(a+b);
            if(startIndex>= Integer.parseInt(totalcount)){
            	startIndex=startIndex-10;
                if(startIndex<0){
                	startIndex=0;
                }
            }
            if("0".equals(totalcount)){
            	messages.add("message",new BLogicMessage("message.null"));
            }else {
            	addsignInfoList = queryDAO.executeForObjectList("infoList2", arg0,startIndex, row);
            	//addsignInfoList1 = queryDAO.executeForObjectList("infoList", arg0,startIndex, row);
            	//addsignInfoList1.addAll(addsignInfoList);
               infoOut.setAddsignInfoList(addsignInfoList);
            }
        }
        else if ("衣蘭凱".equals(arg0.getUserName())) {
        	totalcount = queryDAO.executeForObject("infoListCount3", arg0,String.class);
            if(startIndex>= Integer.parseInt(totalcount)){
            	startIndex=startIndex-10;
                if(startIndex<0){
                	startIndex=0;
                }
        	}
            if("0".equals(totalcount)){
            	messages.add("message",
            			new BLogicMessage("message.null"));
            }else {
            	addsignInfoList = queryDAO.executeForObjectList("infoList3", arg0,startIndex, row);
                infoOut.setAddsignInfoList(addsignInfoList);
            }
		}
        else {
            // TODO 自動生成されたメソッド・スタブ
        	totalcount = queryDAO.executeForObject("infoListCount", arg0,String.class);
            if(startIndex>= Integer.parseInt(totalcount)){
            	startIndex=startIndex-10;
                if(startIndex<0){
                	startIndex=0;
                }
        	}
            if("0".equals(totalcount)){
            	messages.add("message",
            			new BLogicMessage("message.null"));
            }else {
            	addsignInfoList = queryDAO.executeForObjectList("infoList", arg0,startIndex, row);
                infoOut.setAddsignInfoList(addsignInfoList);
            }
        }
        attendance06SelectRecOutput = queryDAO.executeForObjectList(
                "getTypeList", 1);
        infoOut.setAttendance06SelectRecOutput(attendance06SelectRecOutput);
        infoOut.setTotalCount(totalcount);
        infoOut.setJN_CARD_SEARCH(arg0.getJN_CARD_SEARCH());
        infoOut.setUSER_NAME_SEARCH(arg0.getUSER_NAME_SEARCH());
        infoOut.setRetroactive_type2(arg0.getRetroactive_type2());
        infoOut.setRetroactive_auditss_search(arg0.getRetroactive_auditss_search());
        infoOut.setRetroactive_starttime_search(arg0.getRetroactive_starttime_search());
        infoOut.setRetroactive_endtime_search(arg0.getRetroactive_endtime_search());
        infoOut.setStartIndex(arg0.getStartIndex());
        if(sureId_card != null){
             infoOut.setSureId_card(sureId_card001);
        }else{
        	 infoOut.setSureId_card(sureId_card);
        }
        result.setResultObject(infoOut);
        result.setErrors(messages);
        result.setResultString("success");
        return result;
    }

}
