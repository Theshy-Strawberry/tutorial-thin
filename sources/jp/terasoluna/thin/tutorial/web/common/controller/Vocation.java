package jp.terasoluna.thin.tutorial.web.common.controller;

import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIVocationVo;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIparam;

public class Vocation {
	public static double getOverCountAf(JNTCIVocationVo vacation,
			double overcountbf, String ym) {
		double overCountAf = 0;
		double holidays = 0;
		String[] time = ym.split("/");
		int num = Integer.parseInt(time[1]);
		switch (num) {
		case 1:
			holidays = vacation.getJanuary();
			break;
		case 2:
			holidays = vacation.getFebruary();
			break;
		case 3:
			holidays = vacation.getMarch();
			break;
		case 4:
			holidays = vacation.getApril();
			break;
		case 5:
			holidays = vacation.getMay();
			break;
		case 6:
			holidays = vacation.getJune();
			break;
		case 7:
			holidays = vacation.getJuly();
			break;
		case 8:
			holidays = vacation.getAugust();
			break;
		case 9:
			holidays = vacation.getSeptember();
			break;
		case 10:
			holidays = vacation.getOctorber();
			break;
		case 11:
			holidays = vacation.getNovember();
			break;
		case 12:
			holidays = vacation.getDecember();
			break;
		}
		if (overcountbf > holidays) {
			overCountAf = overcountbf - holidays;
		}
		return overCountAf;
	}

	public static JNTCIparam getHolidaysAf(JNTCIVocationVo vacation, String ym) {
		JNTCIparam result = new JNTCIparam();
		double holidays = 0;
		String[] time = ym.split("/");
		int num = Integer.parseInt(time[1]);
		switch (num) {
		case 1:
			holidays = vacation.getJanuary();
			result.setHolidays(holidays);
			result.setMonth(1);
			break;
		case 2:
			holidays = vacation.getFebruary();
			result.setHolidays(holidays);
			result.setMonth(2);
			break;
		case 3:
			holidays = vacation.getMarch();
			result.setHolidays(holidays);
			result.setMonth(3);
			break;
		case 4:
			holidays = vacation.getApril();
			result.setHolidays(holidays);
			result.setMonth(4);
			break;
		case 5:
			holidays = vacation.getMay();
			result.setHolidays(holidays);
			result.setMonth(5);
			break;
		case 6:
			holidays = vacation.getJune();
			result.setHolidays(holidays);
			result.setMonth(6);
			break;
		case 7:
			holidays = vacation.getJuly();
			result.setHolidays(holidays);
			result.setMonth(7);
			break;
		case 8:
			holidays = vacation.getAugust();
			result.setHolidays(holidays);
			result.setMonth(8);
			break;
		case 9:
			holidays = vacation.getSeptember();
			result.setHolidays(holidays);
			result.setMonth(9);
			break;
		case 10:
			holidays = vacation.getOctorber();
			result.setHolidays(holidays);
			result.setMonth(10);
			break;
		case 11:
			holidays = vacation.getNovember();
			result.setHolidays(holidays);
			result.setMonth(11);
			break;
		case 12:
			holidays = vacation.getDecember();
			result.setHolidays(holidays);
			result.setMonth(12);
			break;
		}
		return result;
	}

	public static JNTCIVocationVo getUpdateVaction(JNTCIVocationVo vocation, int month,
			double holCount, double remain_days) {
		vocation.setRemain_days(remain_days);
		switch (month) {
		case 1:
			vocation.setJanuary(holCount);
			break;
		case 2:
			vocation.setFebruary(holCount);
			break;
		case 3:
			vocation.setMarch(holCount);
			break;
		case 4:
			vocation.setApril(holCount);
			break;
		case 5:
			vocation.setMay(holCount);
			break;
		case 6:
			vocation.setJune(holCount);
			break;
		case 7:
			vocation.setJuly(holCount);
			break;
		case 8:
			vocation.setAugust(holCount);
			break;
		case 9:
			vocation.setSeptember(holCount);
			break;
		case 10:
			vocation.setOctorber(holCount);
			break;
		case 11:
			vocation.setNovember(holCount);
			break;
		case 12:
			vocation.setDecember(holCount);
			break;
		}
		return vocation;
	}
}
