package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoDetailedInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoDetailedOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginDataBase;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginEditTool;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginEnglish;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginJEnvirnment;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginJapanese;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginLanguage;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginOperatSys;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginjLanguage;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCISelectPersonalInfo;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.SelectQualificationTR;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.SelectWorkExperience;


public class JNTCIPersonalInfoDetailedBLogic implements BLogic<JNTCIPersonalInfoDetailedInput> {

    private QueryDAO queryDAO = null;

    public void setQueryDAO(QueryDAO queryDAO) {
        this.queryDAO = queryDAO;
    }

    private static String photoPath = "images/defaultHeadPortrait.jpg";
	private String uploadPath = this.getClass().getClassLoader().getResource("").getPath() + "../../images/photo/";

    public BLogicResult execute(JNTCIPersonalInfoDetailedInput param) {
        String jn_card = param.getJn_card();
        String userName = param.getUserName();
        if(userName == null){userName ="";}
        else{
        	try {
				String testpara = new String(userName.getBytes(
						"ISO-8859-1"), "utf-8");
				param.setUserName(testpara);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
        }

        String cardnum = param.getCardnum();
        if(cardnum == null){cardnum ="";}
        String entryTime_Begin =param.getEntryTime_Begin();
        if(entryTime_Begin == null){entryTime_Begin ="";}
        String entryTime_End = param.getEntryTime_End();
        if(entryTime_End == null){entryTime_End ="";}
        String department =param.getDepartment();
        if(department == null){department ="";}
        String zhuangtai=param.getZhuangtai();
        if(zhuangtai == null){zhuangtai ="";}
        String id_card = param.getId_card();
        if(id_card == null){id_card ="";}
        Integer startIndex = param.getStartIndex();
        if (param.getId_card() == null) {
            param.setId_card(param.getUserId());
        }

        JNTCIPersonalInfoLoginInput pramt = new JNTCIPersonalInfoLoginInput();
        pramt.setJn_Card(param.getId_card());
        //個人基本情報
        JNTCISelectPersonalInfo jntciSelectPersonalInfo = queryDAO.executeForObject("selectDetailedInfo", param,
                JNTCISelectPersonalInfo.class);
        String shebao = jntciSelectPersonalInfo.getSYAHO_JIKAN();
        if(null == shebao || "".equals(shebao) ){}//以下对查询出的社保时间进行判断，如果不为空的话按空格进行分割。
        else{String[] shebaoshijian = shebao.split(" ");
        jntciSelectPersonalInfo.setSYAHO_JIKAN(shebaoshijian[0]);}
        //else {}
        if(jntciSelectPersonalInfo.getPhotoPath()!=null&&!"".equals(jntciSelectPersonalInfo.getPhotoPath())){
        	  if (jntciSelectPersonalInfo.getPhotoPath() != null && !"".equals(jntciSelectPersonalInfo.getPhotoPath().trim())) {
                  jntciSelectPersonalInfo.setPhotoPath(showPhoto(jntciSelectPersonalInfo.getPhotoPath()));
              } else {
                  jntciSelectPersonalInfo.setPhotoPath(photoPath);
              }
        }


        //作業経験類型及年限
       String Work_Experience =  jntciSelectPersonalInfo.getWork_Experience();
       if(Work_Experience != null){
    	   String[] work_ExperienceArray = Work_Experience.split(",");
    	   if(work_ExperienceArray.length == 1){
    		   String[] work_Experience_Sub = work_ExperienceArray[0].split(":");
    		   if("".equals(work_Experience_Sub[1].trim()) || Double.parseDouble(work_Experience_Sub[1])==0){
    			   Work_Experience = "無.";
    		   }
    	   }
    	   Work_Experience = Work_Experience.substring(0,Work_Experience.length()-1 );
    	   jntciSelectPersonalInfo.setWork_Experience(Work_Experience);
       }

        //職業資格
        List<SelectQualificationTR> qualificationTR = queryDAO.executeForObjectList("selectQualificationTR", param);

        //仕事経験
        List<SelectWorkExperience> workExperience = queryDAO.executeForObjectList("selectWorkExperience", param);
        if(workExperience.size() == 0){
        	workExperience.add(new SelectWorkExperience());
        }

        for (int i = 0; i < workExperience.size(); i++) {
            workExperience.get(i).setOrder_no(String.valueOf(i + 1));
        }

        JNTCIPersonalInfoDetailedOutput output = new JNTCIPersonalInfoDetailedOutput();

        if (jntciSelectPersonalInfo != null) {
            output.setJntciSelectPersonalInfo(jntciSelectPersonalInfo);
            output.setQualificationTR(qualificationTR);
            output.setWorkExperience(workExperience);
            output.setStartIndex(startIndex);
            output.setZhuangtai(zhuangtai);
        }
        //xinjia
        //言语
        List<JNTCIPersonalInfoLoginLanguage> languagelist = queryDAO.executeForObjectList("selectUpdatePersonalInfoLanguage", pramt);
        //java环境
        List<JNTCIPersonalInfoLoginJEnvirnment> envirnmentlist = queryDAO.executeForObjectList("selectUpdatePersonalInfojEnvirnment", pramt);
        //java语言
        List<JNTCIPersonalInfoLoginjLanguage> jlanguagelist = queryDAO.executeForObjectList("selectUpdatePersonalInfojLanguage", pramt);
        //tool
        List<JNTCIPersonalInfoLoginEditTool> editToollist = queryDAO.executeForObjectList("selectUpdatePersonalInfoEditTool", pramt);
        //db
        List<JNTCIPersonalInfoLoginDataBase> dataBaselist = queryDAO.executeForObjectList("selectUpdatePersonalInfoDataBase", pramt);
        //os
        List<JNTCIPersonalInfoLoginOperatSys> operatSyslist = queryDAO.executeForObjectList("selectUpdatePersonalInfoOperatSys", pramt);
        //日语
        JNTCIPersonalInfoLoginJapanese japaneselist = queryDAO.executeForObject("selectUpdatePersonalInfojapanese",pramt, JNTCIPersonalInfoLoginJapanese.class);
        //英语
        JNTCIPersonalInfoLoginEnglish englishlist = queryDAO.executeForObject("selectUpdatePersonalInfoenglish",pramt, JNTCIPersonalInfoLoginEnglish.class);

        if (japaneselist != null) {
			japaneselist.setJap_skill(changge(japaneselist.getJap_skill()));
		}else{
			japaneselist = new JNTCIPersonalInfoLoginJapanese();
			japaneselist.setJap_skill("");
			japaneselist.setJap_level("");
		}
		if (englishlist != null) {
			englishlist.setEng_skill(changge(englishlist.getEng_skill()));
		}else{
			englishlist =new JNTCIPersonalInfoLoginEnglish();
			englishlist.setEng_skill("");
			englishlist.setEng_level("");
		}

        output.setLanguagelist(languagelist);
        output.setEnvirnmentlist(envirnmentlist);
        output.setJlanguagelist(jlanguagelist);
        output.setEditToollist(editToollist);
        output.setDataBaselist(dataBaselist);
        output.setOperatSyslist(operatSyslist);
        output.setJapaneselist(japaneselist);
        output.setEnglishlist(englishlist);
        output.setStartIndex(startIndex);
        output.setZhuangtai(zhuangtai);
        output.setEntryTime_Begin(entryTime_Begin);
        output.setEntryTime_End(entryTime_End);
        output.setId_card(id_card);
        output.setUserName(param.getUserName());
        output.setDepartment(department);

        BLogicResult result = new BLogicResult();
        result.setResultObject(output);
        result.setResultString("success");

        return result;
    }

    private String showPhoto(String photoName) {
        try {
            File file = new File(uploadPath + photoName);
            if(file.exists()){
            	return "images/photo/" + photoName + "?id=" + new Date();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return photoPath;
    }
public String changge(String st){
	if(st!=null){
	 String[] str = st.trim().split("-");
     String strs = "";
		for(int i=0;i<str.length;i++){
			if("4".equals(str[i])){
				strs = "業務上の会話ができる 、";
			}
			if("5".equals(str[i])){
				strs += "  書く、";
			}
			if("6".equals(str[i])){
				strs += "  読む、";
			}
			if("7".equals(str[i])){
				strs += "  技術書が読める、";
			}
			if("8".equals(str[i])){
				strs += "  ドキュメントが作成できる、";
			}
		}
		return strs;
	}
	return st;
}
}
