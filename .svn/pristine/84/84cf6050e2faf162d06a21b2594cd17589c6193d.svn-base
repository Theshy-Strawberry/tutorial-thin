package jp.terasoluna.thin.tutorial.web.common.controller;

public class Constant {

	//发件邮箱
	public static final String  sendFrom = "";
    //发件箱密码
	public static final String  sendPassword = "";
    //邮件标题
	public static final String  sendtitle = "找回内部管理システム密码";
	//999
	public static final String  MAXNO= "999";

	// 設備番号のフォーマット AAA-yyMM-000からZZZ-yyMM-999まで
		public static final String SETSUBINO_STRING = "AAA-yyMM-xxx";

		// 「AAA」を取得
		public static String getSetsubinoSub01(String setsubino) {

			String setsubino01 = setsubino.substring(0, 3);
			return setsubino01;
		}

		// 「-yyMM-」を取得
		public static String getSetsubinoSub02(String setsubino) {

			String setsubino01 = setsubino.substring(3, 9);
			return setsubino01;
		}

		// 「xxx」を取得
		public  static String getSetsubinoSub03(String setsubino) {

			String setsubino01 = setsubino.substring(9);
			return setsubino01;
		}
}
