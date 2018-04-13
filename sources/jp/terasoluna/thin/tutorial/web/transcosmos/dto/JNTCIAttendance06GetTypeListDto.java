package jp.terasoluna.thin.tutorial.web.transcosmos.dto;

import java.io.Serializable;

public class JNTCIAttendance06GetTypeListDto implements Serializable {

    private static final long serialVersionUID = 161610379384156463L;
    // 補くじタイプコード
    private String cd_code = null;
    // 補くじタイプ名前
    private String kj_name = null;

    /*
     * 補くじタイプコードを取得
     */
    public String getCd_code() {
        return cd_code;
    }

    /*
     * 補くじタイプコードを設定
     */
    public void setCd_code(String cd_code) {
        this.cd_code = cd_code;
    }

    /*
     * 補くじタイプ名前を取得
     */
    public String getKj_name() {
        return kj_name;
    }

    /*
     * 補くじタイプ名前を設定
     */
    public void setKj_name(String kj_name) {
        this.kj_name = kj_name;
    }

}
