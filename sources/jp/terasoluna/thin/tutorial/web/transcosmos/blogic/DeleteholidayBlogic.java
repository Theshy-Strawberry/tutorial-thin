package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.Winput;

public class DeleteholidayBlogic implements BLogic<Winput> {
    private UpdateDAO updateDAO = null;
    private QueryDAO queryDAO = null;

    public QueryDAO getQueryDAO() {
        return queryDAO;
    }

    public void setQueryDAO(QueryDAO queryDAO) {
        this.queryDAO = queryDAO;
    }

    public UpdateDAO getUpdateDAO() {
        return updateDAO;
    }

    public void setUpdateDAO(UpdateDAO updateDAO) {
        this.updateDAO = updateDAO;
    }

    public BLogicResult execute(Winput param) {
        // TODO 自動生成されたメソッド・スタブ
        BLogicResult result = new BLogicResult();
        if ("delete".equals(param.getFlag())) {
            updateDAO.execute("deleteXDay", param);
            updateDAO.execute("deleteholiday", param);
            result.setResultString("delete");
        } else {
            Winput oneholiday = queryDAO.executeForObject("getholiday", param,
                    Winput.class);
            List<Winput> holidaytimelist = queryDAO.executeForObjectList(
                    "holidaytime", param);
            Winput output = new Winput();
            output.setStartIndex(param.getStartIndex());
            output.setName1(param.getName1());
            output.setHolidaytimelist(holidaytimelist);
            output.setStartIndex(param.getStartIndex());
            int xDayCount = queryDAO.executeForObject("selectxdaycount",param,Integer.class);
    		if(xDayCount > 0){
    			output.setName(oneholiday.getName());
                output.setStartholidaydate(oneholiday.getStartholidaydate());
                output.setEndholidaydate(oneholiday.getEndholidaydate());
                result.setResultObject(output);
                result.setResultString("success");
    		}else{
    			result.setResultObject(output);
    			result.setResultString("success1");
    		}

          /*  output.setStartIndex(param.getStartIndex());
            result.setResultObject(output);
            result.setResultString("success");*/
        }
        return result;
    }
}
