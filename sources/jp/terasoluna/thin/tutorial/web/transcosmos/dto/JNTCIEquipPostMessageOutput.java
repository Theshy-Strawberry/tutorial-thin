package jp.terasoluna.thin.tutorial.web.transcosmos.dto;

import java.util.List;

import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEquipPostMessageVo;

public class JNTCIEquipPostMessageOutput {
    private int info_id;
    private String info_title;
    private String class_name;
    private String info_details;
    private String info_date;
    private String user_id;
    private List<JNTCIEquipPostMessageVo> postmessage;

    public List<JNTCIEquipPostMessageVo> getPostmessage() {
        return postmessage;
    }

    public void setPostmessage(List<JNTCIEquipPostMessageVo> postmessage) {
        this.postmessage = postmessage;
    }

    public String getInfo_title() {
        return info_title;
    }

    public void setInfo_title(String info_title) {
        this.info_title = info_title;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getInfo_details() {
        return info_details;
    }

    public void setInfo_details(String info_details) {
        this.info_details = info_details;
    }

    public int getInfo_id() {
        return info_id;
    }

    public void setInfo_id(int info_id) {
        this.info_id = info_id;
    }

    public String getInfo_date() {
        return info_date;
    }

    public void setInfo_date(String info_date) {
        this.info_date = info_date;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

}
