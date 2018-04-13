package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginDataBase;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginEditTool;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginEnglish;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginJEnvirnment;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginJapanese;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginLanguage;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginOperatSys;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginWork;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginjLanguage;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginworkStr;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginOccupation;

public class JNTCIPersonalInfoInitBLogic2 implements BLogic<JNTCIPersonalInfoLoginInput> {

	 /**
     * QueryDAO绺诧拷
     * Spring绺猴将绻у尰锝婄恭锝ょ節锝崇恭锝圭恭锝跨節锝崇恭锝归�婊擄拷绺鸿紨锝岄毆锝灣澹癸紗绻у緦锝嬬覆锟�     */
    private QueryDAO queryDao = null;

    private static String photoPath = "images/defaultHeadPortrait.jpg";
	private String uploadPath = this.getClass().getClassLoader().getResource("").getPath() + "../../images/photo/";

    /**
     * 閫嬶交楠讲铚冿溅閫咃拷锝掗櫐寰屸墽绺诧拷
     */
    public BLogicResult execute(JNTCIPersonalInfoLoginInput param) {

        BLogicResult result = new BLogicResult();

        String jn_card = param.getJn_Card();

        if(jn_card != null && !("".equals(jn_card.trim()) )){
        	//鍙栧緱涓汉鍩烘湰淇℃伅
        	JNTCIPersonalInfoLoginOutput personalInfoLoginOutput = queryDao.executeForObject("selectUpdatePersonalInfo2", param, JNTCIPersonalInfoLoginOutput.class);
        	JNTCIPersonalInfoLoginOutput personalInfoLoginOutput2 =  queryDao.executeForObject("selectUpdatePersonalInfo3", param, JNTCIPersonalInfoLoginOutput.class);
        	personalInfoLoginOutput.setLeader(personalInfoLoginOutput2.getLeader());
        	personalInfoLoginOutput.setDeptPerson(personalInfoLoginOutput2.getDeptPerson());
        	personalInfoLoginOutput.setCount("");
        	 String shebao = personalInfoLoginOutput.getSYAHO_JIKAN();
             if(null == shebao || "".equals(shebao) ){}//以下对查询出的社保时间进行判断，如果不为空的话按空格进行分割。
             else{String[] shebaoshijian = shebao.split(" ");
             personalInfoLoginOutput.setSYAHO_JIKAN(shebaoshijian[0]);}


        	String workStr = personalInfoLoginOutput.getWork_Experience();

        	JNTCIPersonalInfoLoginworkStr ff = null;

        	List<JNTCIPersonalInfoLoginworkStr> workStrList = new ArrayList<JNTCIPersonalInfoLoginworkStr>();


			if (workStr != null) {

				String[] rowsString = workStr.split(",");

				for (int i = 0; i < rowsString.length; i++) {
					String[] InputString = rowsString[i].split(":");
					if(InputString.length>1){
					ff = new JNTCIPersonalInfoLoginworkStr();
					ff.setWork_Experience(InputString[0].trim());
					ff.setWork_time(InputString[1].trim());
					workStrList.add(ff);
					}
				}

			} else {
				ff = new JNTCIPersonalInfoLoginworkStr();
				ff.setWork_Experience("PG");
				ff.setWork_time("0");
				workStrList.add(ff);
			}



        	List<JNTCIPersonalInfoLoginOccupation> occupation = queryDao.executeForObjectList("selectUpdatePersonalInfoOccupation",param );
        	if(occupation == null || occupation.size() == 0 ){
        		JNTCIPersonalInfoLoginOccupation personInfoOccupation = new JNTCIPersonalInfoLoginOccupation();
        		personInfoOccupation.setWinning_date("");
        		personInfoOccupation.setWining_certificate("");
        		occupation.add(personInfoOccupation);
        	}
        	List<JNTCIPersonalInfoLoginLanguage> language = queryDao.executeForObjectList("selectUpdatePersonalInfoLanguage",param );
        	if(language == null || language.size() == 0 ){
        		JNTCIPersonalInfoLoginLanguage personInfoLanguage = new JNTCIPersonalInfoLoginLanguage();
        		personInfoLanguage.setYy_language("");
        		personInfoLanguage.setYy_level("");
        		personInfoLanguage.setYy_year("");
        		language.add(personInfoLanguage);
        	}

        	List<JNTCIPersonalInfoLoginJEnvirnment> jEnvirnment = queryDao.executeForObjectList("selectUpdatePersonalInfojEnvirnment",param );
        	if(jEnvirnment == null || jEnvirnment.size() == 0 ){
        		JNTCIPersonalInfoLoginJEnvirnment personInfojEnvirnment = new JNTCIPersonalInfoLoginJEnvirnment();
        		personInfojEnvirnment.setJhj_Envirnment("");
        		personInfojEnvirnment.setJhj_level("");
        		personInfojEnvirnment.setJhj_year("");
        		jEnvirnment.add(personInfojEnvirnment);
        	}

        	List<JNTCIPersonalInfoLoginjLanguage> jLanguage = queryDao.executeForObjectList("selectUpdatePersonalInfojLanguage",param );
        	if(jLanguage == null || jLanguage.size() == 0 ){
        		JNTCIPersonalInfoLoginjLanguage personInfojLanguage = new JNTCIPersonalInfoLoginjLanguage();
        		personInfojLanguage.setJyy_language("");
        		personInfojLanguage.setJyy_level("");
        		personInfojLanguage.setJyy_year("");
        		jLanguage.add(personInfojLanguage);
        	}
        	List<JNTCIPersonalInfoLoginEditTool> editTool = queryDao.executeForObjectList("selectUpdatePersonalInfoEditTool",param );
        	if(editTool == null || editTool.size() == 0 ){
        		JNTCIPersonalInfoLoginEditTool personInfoEditTool = new JNTCIPersonalInfoLoginEditTool();
        		personInfoEditTool.setTl_tool("");
        		personInfoEditTool.setTl_level("");
        		personInfoEditTool.setTl_year("");
        		editTool.add(personInfoEditTool);
        	}
        	List<JNTCIPersonalInfoLoginDataBase> dataBase = queryDao.executeForObjectList("selectUpdatePersonalInfoDataBase",param );
        	if(dataBase == null || dataBase.size() == 0 ){
        		JNTCIPersonalInfoLoginDataBase personInfoDataBase = new JNTCIPersonalInfoLoginDataBase();
        		personInfoDataBase.setDb_datebase("");
        		personInfoDataBase.setDb_level("");
        		personInfoDataBase.setDb_year("");
        		dataBase.add(personInfoDataBase);
        	}
        	List<JNTCIPersonalInfoLoginOperatSys> operatSys = queryDao.executeForObjectList("selectUpdatePersonalInfoOperatSys",param );
        	if(operatSys == null || operatSys.size() == 0 ){
        		JNTCIPersonalInfoLoginOperatSys personInfoOperatSys = new JNTCIPersonalInfoLoginOperatSys();
        		personInfoOperatSys.setOs_operatsys("");
        		personInfoOperatSys.setOs_level("");
        		personInfoOperatSys.setOs_year("");
        		operatSys.add(personInfoOperatSys);
        	}

        	List<JNTCIPersonalInfoLoginWork> workList = queryDao.executeForObjectList("selectUpdatePersonalInfoWork", param);
        	if(workList == null || workList.size() == 0 ){
        		JNTCIPersonalInfoLoginWork personInfoworkList = new JNTCIPersonalInfoLoginWork();
        		personInfoworkList.setOrder_no(1);
        		workList.add(personInfoworkList);
        	}

        	for (int i = 0; i < workList.size(); i++) {
        		workList.get(i).setOrder_no(i + 1);
            }

			JNTCIPersonalInfoLoginJapanese japanese = queryDao
					.executeForObject("selectUpdatePersonalInfojapanese",
							param, JNTCIPersonalInfoLoginJapanese.class);

			if (japanese != null ) {
				String jap_level = japanese.getJap_level();

				String japStr = japanese.getJap_skill();

				String[] jap_skill = null;

				if (japStr != null) {
					if (japStr.indexOf("-") > 0) {
						jap_skill = japStr.split("-");

					} else {
						jap_skill = japStr.split("");
					}
				}
				personalInfoLoginOutput.setJap_level(jap_level);
				personalInfoLoginOutput.setJap_skill(jap_skill);
			}
			JNTCIPersonalInfoLoginEnglish english = queryDao.executeForObject(
					"selectUpdatePersonalInfoenglish", param,
					JNTCIPersonalInfoLoginEnglish.class);

			if (english != null) {
				String eng_level = english.getEng_level();

				String engStr = english.getEng_skill();

				String[] eng_skill = null;

				if (engStr != null) {
					if (engStr.indexOf(",") > 0) {
						eng_skill = engStr.split(",");

					} else {
						eng_skill = engStr.split("");
					}
				}

				personalInfoLoginOutput.setEng_level(eng_level);
				personalInfoLoginOutput.setEng_skill(eng_skill);
			}
			personalInfoLoginOutput.setJn_Card(jn_card);
        	personalInfoLoginOutput.setWorkList(workList);
        	personalInfoLoginOutput.setWorkStr(workStrList);
        	personalInfoLoginOutput.setOccupation(occupation);
        	personalInfoLoginOutput.setLanguage(language);
        	personalInfoLoginOutput.setjEnvirnment(jEnvirnment);
        	personalInfoLoginOutput.setjLanguage(jLanguage);
        	personalInfoLoginOutput.setEditTool(editTool);
        	personalInfoLoginOutput.setDataBase(dataBase);
        	personalInfoLoginOutput.setOperatSys(operatSys);

        	personalInfoLoginOutput.setButton_name("淇");
        	personalInfoLoginOutput.setDisable(true);
        	personalInfoLoginOutput.setJudge_flg(1);


        	if(personalInfoLoginOutput.getPhoto_Path() != null && !"".equals(personalInfoLoginOutput.getPhoto_Path().trim())){
            	personalInfoLoginOutput.setPhoto_Path(showPhoto(personalInfoLoginOutput.getPhoto_Path()));
        	}else{
            	personalInfoLoginOutput.setPhoto_Path(photoPath);
        	}

        	result.setResultObject(personalInfoLoginOutput);
        	result.setResultString("update");
            return result;

        }else{
        	//鐧婚尣
        	JNTCIPersonalInfoLoginOutput personalInfoLoginOutput = new JNTCIPersonalInfoLoginOutput();
        	personalInfoLoginOutput.setButton_name("鐧婚尣");
        	personalInfoLoginOutput.setDisable(false);
        	personalInfoLoginOutput.setJudge_flg(0);
        	personalInfoLoginOutput.setSex("1");
        	personalInfoLoginOutput.setMarital_Status("1");
        	personalInfoLoginOutput.setPassport("1");
        	personalInfoLoginOutput.setVisa("1");
        	personalInfoLoginOutput.setPhoto_Path(photoPath);
        	personalInfoLoginOutput.setCount("");
        	result.setResultObject(personalInfoLoginOutput);
        	result.setResultString("create");
            return result;
        }

    }


    /**
     * QueryDAO绻у畾锝江铻冲９鈽嗙恭涔濓拷
     * @param queryDAO
     */
    public void setQueryDAO(QueryDAO queryDao) {
        this.queryDao = queryDao;
    }


    private String showPhoto(String photoName) {
        try {
            File file = new File(uploadPath + photoName);
            if(file.exists()){
            	return "images/photo/" + photoName + "?id=" + new Date();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return photoPath;
    }


}
