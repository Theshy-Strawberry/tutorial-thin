package jp.terasoluna.thin.tutorial.web.common.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeCompare {

    /**
     * 每日实际出勤总时长
     * @param startTime
     * @param endTime
     * @return
     */
    public static double getTimeCount(String startTime, String endTime) {
        double timeCount = 0.0;
        if(startTime.compareTo(endTime) < 0){
         // 上班卡
            String[] start = startTime.split(" ");
            String startTime2 = startTime;
            if(start.length > 1){
                startTime2 = start[1];
            }
            String[] startTime3 = startTime2.split(":");
            String startTime1 = "";
            if(startTime3[1].compareTo("00") == 0){
                startTime1 = startTime3[0] + ":00:00";
            }else if(startTime3[1].compareTo("30") <= 0 && startTime3[1].compareTo("00") != 0){
                startTime1 = startTime3[0] + ":30:00";
            }else{
                startTime3[0]  = Integer.toString((Integer.parseInt(startTime3[0]) + 1));
                if(startTime3[0].length() < 2){
                    startTime3[0] = "0" + startTime3[0];
                }
                startTime1 = startTime3[0] + ":00:00";
            }

            // 下班卡
            String[] end = endTime.split(" ");
            String endTime2 = endTime;
            if(end.length > 1){
                endTime2 = end[1];
            }
            String[] endTime3 = endTime2.split(":");
            String endTime1 = "";
            if(endTime3[1].compareTo("30") < 0){
                endTime1 = endTime3[0] + ":00:00";
            }else{
                endTime1 = endTime3[0] + ":30:00";
            }

            String morning = "08:30:00";
            String midday = "12:00:00";
            String midday2 = "13:00:00";
            String afternoon = "17:30:00";


            /**
             * 5.去除8：30之前 && 去除午饭 && 去除17：30之后
             */
            // 上班卡在正式上班之前
            if (startTime1.compareTo(morning) <= 0) {
                // 下班卡在正式上班之后在午饭之前
                if (endTime1.compareTo(morning) > 0
                        && endTime1.compareTo(midday) <= 0) {
                    timeCount = timeCount(morning, endTime1);
                    // 下班卡处于午饭时间
                } else if (endTime1.compareTo(midday) > 0
                        && endTime1.compareTo(midday2) <= 0) {
                    timeCount = timeCount(morning, midday);
                    // 下班卡在午饭之后正式下班之前
                } else if (endTime1.compareTo(midday2) > 0
                        && endTime1.compareTo(afternoon) <= 0) {
                    timeCount = timeCount(morning, endTime1) - 1;
                    // 下班卡在正式下班之后
                } else if (endTime1.compareTo(afternoon) > 0) {
                    timeCount = timeCount(morning, afternoon) - 1;
                }
                // 上班卡在正式上班之后午饭之前
            } else if (startTime1.compareTo(midday) <= 0) {
                // 下班卡比午饭早
                if (endTime1.compareTo(midday) <= 0) {
                    timeCount = timeCount(startTime1, endTime1);
                    // 下班卡处于午饭时间
                } else if (endTime1.compareTo(midday) > 0
                        && endTime1.compareTo(midday2) <= 0) {
                    timeCount = timeCount(startTime1, midday);
                    // 下班卡在午饭之后正式下班之前
                } else if (endTime1.compareTo(midday2) > 0
                        && endTime1.compareTo(afternoon) <= 0) {
                    timeCount = timeCount(startTime1, endTime1) - 1;
                 // 下班卡在正式下班之后
                } else if (endTime1.compareTo(afternoon) > 0) {
                    timeCount = timeCount(startTime1, afternoon) - 1;
                }
                // 上班卡在午饭时间
            } else if (startTime1.compareTo(midday) > 0
                    && startTime1.compareTo(midday2) <= 0) {
                // 下班卡在午饭之后正式下班之前
                if (endTime1.compareTo(midday2) > 0
                        && endTime1.compareTo(afternoon) <= 0) {
                    timeCount = timeCount(midday2, endTime1);
                 // 下班卡在正式下班之后
                } else if (endTime1.compareTo(afternoon) > 0) {
                    timeCount = timeCount(midday2, afternoon);
                }
                // 上班卡在正式下班之后
            } else if (startTime1.compareTo(midday2) > 0) {
                // 下班卡在午饭之后正式下班之前
                if (endTime1.compareTo(midday2) > 0
                        && endTime1.compareTo(afternoon) <= 0) {
                    timeCount = timeCount(startTime1, endTime1);
                 // 下班卡在正式下班之后
                } else if (endTime1.compareTo(afternoon) > 0) {
                    timeCount = timeCount(startTime1, afternoon) ;
                }
            }
        }
        if(timeCount < 0){
            timeCount = 0;
        }
        return timeCount;
    }

    /**
     * 两个HH:mm:dd型的时间之差
     * @param startTime
     * @param afternoon
     * @return
     */
    public static double timeCount(String startTime, String afternoon) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String date = "2016/01/01";
        startTime = date + " " + startTime;
        afternoon = date + " " + afternoon;
        double timeCount = 0.0;
        Date aaa;
        Date bbb;
            try {
                aaa = sdf.parse(startTime);
                bbb = sdf.parse(afternoon);
                double ddd = bbb.getTime() - aaa.getTime();
                timeCount = ddd / (3600 * 1000);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        return timeCount;
    }


    /*
     *计算缺勤时间
     *
     *
     */

    public static double ComelateOrLeave_earlier(String startTime, String endTime){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String date = "2016/01/01";
        startTime = date + " " + startTime;
        endTime = date + " " + endTime;
    	double count = 0.0;
    	double Millisecond = 0.0;
    	String bzstarttime = "08:30:00";
		String bzendtime = "17:30:00";
		String Noontime = "12:00:00";
		String Afternoontime  ="13:00:00";
		bzstarttime = date + " " + bzstarttime;
		bzendtime = date + " " + bzendtime;
		Noontime = date + " " + Noontime;
		Afternoontime = date + " " + Afternoontime;
		//上班打卡时间 = 下班打卡时间
    	if(startTime.equals(endTime)){
    		count = 8;
    	}
    	//打卡在上班之前
    	if(startTime.compareTo(bzstarttime) <= 0){
    		//下班在上班之前
    		if(endTime.compareTo(bzstarttime) <= 0){
    			count = 8;
    		}
    		//下班在中午之前
    		else if(endTime.compareTo(Noontime) <= 0){
    			try {
    				Millisecond = (sdf.parse(endTime).getTime()-sdf.parse(bzstarttime).getTime());
					count =  Millisecond / (3600 * 1000);
					count = TimeCompare.dateTimeCount(count);
					count = 8-count;
				} catch (ParseException e) {
					e.printStackTrace();
				}

    		}
    		//下班在中午以后，下午之前
    		else if(endTime.compareTo(Noontime) >0 && endTime.compareTo(Afternoontime) <= 0){
    			try {
    				Millisecond = (sdf.parse(Noontime).getTime()-sdf.parse(bzstarttime).getTime());
					count = Millisecond / (3600 * 1000);
					count = TimeCompare.dateTimeCount(count);
					count = 8-count;
				} catch (ParseException e) {
					e.printStackTrace();
				}
    		}
    		//下班在下午以后
    		else if(endTime.compareTo(Afternoontime) >= 0 && endTime.compareTo(bzendtime) <= 0){
    			try {
    				Millisecond = (sdf.parse(endTime).getTime()-sdf.parse(bzstarttime).getTime());
					count =  Millisecond / (3600 * 1000)-1;
					count = TimeCompare.dateTimeCount(count);
					count = 8-count;
				} catch (ParseException e) {
					e.printStackTrace();
				}
    			//下班在下班以后
    		}else if(endTime.compareTo(bzendtime) >= 0){
    			try {
    				Millisecond = (sdf.parse(bzendtime).getTime()-sdf.parse(bzstarttime).getTime());
					count =  Millisecond / (3600 * 1000)-1;
					count = TimeCompare.dateTimeCount(count);
					count = 8-count;
				} catch (ParseException e) {
					e.printStackTrace();
				}
    		}
    		//打卡在上班以后
    	}else if(startTime.compareTo(bzstarttime) >= 0){
    		//下班在中午之前
    		if(endTime.compareTo(Noontime) <= 0){
    			try {
    				Millisecond = (sdf.parse(endTime).getTime()-sdf.parse(startTime).getTime());
					count =  Millisecond  / (3600 * 1000);
					count = TimeCompare.dateTimeCount(count);
					count = 8-count;
				} catch (ParseException e) {
					e.printStackTrace();
				}
    			//下班在中午之后，下午之前
    		}else if(endTime.compareTo(Noontime) >= 0 && endTime.compareTo(Afternoontime) <= 0 ){
    			try {
    				Millisecond = (sdf.parse(Noontime).getTime()-sdf.parse(startTime).getTime());
					count = Millisecond  / (3600 * 1000);
					count = TimeCompare.dateTimeCount(count);
					count = 8-count;
				} catch (ParseException e) {
					e.printStackTrace();
				}
    		}
    		//下班在下午以后,下班之前
    		else if(endTime.compareTo(Afternoontime) >= 0 && endTime.compareTo(bzendtime) <= 0){
    			try {
    				Millisecond = (sdf.parse(endTime).getTime()-sdf.parse(startTime).getTime());
					count = Millisecond  / (3600 * 1000)-1;
					count = TimeCompare.dateTimeCount(count);
					count = 8-count;
				} catch (ParseException e) {
					e.printStackTrace();
				}
    			//下班在下班以后
    		}else if(endTime.compareTo(bzendtime) >= 0){
			try {
				Millisecond = (sdf.parse(bzendtime).getTime()-sdf.parse(startTime).getTime());
				count = Millisecond  / (3600 * 1000)-1;
				count = TimeCompare.dateTimeCount(count);
				count = 8-count;
			} catch (ParseException e) {
				e.printStackTrace();
			}
    		}

    	}
    	//打上班卡在中午以后，下午之前
    	else if(startTime.compareTo(Noontime) >= 0 && startTime.compareTo(Afternoontime) <= 0){
    		//下班在中午以后，下午之前
    		if(endTime.compareTo(Noontime) >= 0 && endTime.compareTo(Afternoontime) <= 0){
    			count = 8;
    		}
    		//下班在下午以后，下班之前
    		else if(endTime.compareTo(Afternoontime) >= 0 && endTime.compareTo(bzendtime) <= 0){
    			try {
    				Millisecond = (sdf.parse(endTime).getTime()-sdf.parse(Afternoontime).getTime());
					count = Millisecond  / (3600 * 1000);
					count = TimeCompare.dateTimeCount(count);
					count = 8-count;
				} catch (ParseException e) {
					e.printStackTrace();
				}
    		}
    		//下班在下班之后
    		else if(endTime.compareTo(bzendtime) >= 0){
    			try {
    				Millisecond = (sdf.parse(bzendtime).getTime()-sdf.parse(Afternoontime).getTime());
					count =  Millisecond  / (3600 * 1000);
					count = TimeCompare.dateTimeCount(count);
					count = 8-count;
				} catch (ParseException e) {
					e.printStackTrace();
				}

    		}
    	}


    	//打卡在下午以后
    	else if(startTime.compareTo(Afternoontime) >= 0){
    			//下班在下班以前
    		 if(endTime.compareTo(bzendtime) <= 0){
    			try {
    				Millisecond = (sdf.parse(endTime).getTime()-sdf.parse(startTime).getTime());
					count =  Millisecond  / (3600 * 1000);
					count = TimeCompare.dateTimeCount(count);
					count = 8-count;
				} catch (ParseException e) {
					e.printStackTrace();
				}
    			//下班在下班以后
    		}else if(endTime.compareTo(bzendtime) >= 0){
			try {
				Millisecond = (sdf.parse(bzendtime).getTime()-sdf.parse(startTime).getTime());
				count = Millisecond  / (3600 * 1000);
				count = TimeCompare.dateTimeCount(count);
				count = 8-count;
			} catch (ParseException e) {
				e.printStackTrace();
			}
    		}
    		 //打卡在下班以后
    	}else if(startTime.compareTo(bzendtime) >= 0){
    		count = 8;
    	}

    	return count;
    }

    /**
     * 取得整点或半点的时长
     * @param timeCount
     * @return
     */
    public static double dateTimeCount(double timeCount){
        int tempCount = (int)timeCount;
        double count = timeCount - tempCount;
        if (count < 0.5){
            timeCount = tempCount;
        }else{
            timeCount = tempCount + 0.5;
        }
        return timeCount;
    }

    //获取当月剩余天数
    public static int getCurrentMonthDay(String StartTime) {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date start = null;
		try {
			start = sdf.parse(StartTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        Calendar a = Calendar.getInstance();
        a.setTime(start);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }
//同一天的兄弟，记住了，很重要
    public static double getAbsenceCount(String startTime, String endTime) {

        double timeCount = 0.0;
        String[] start = startTime.split(" ");
        String startTime2 = startTime;
        if(start.length > 1){
            startTime2 = start[1];
        }
        String[] end = endTime.split(" ");
        String endTime2 = endTime;
        if(end.length > 1){
            endTime2 = end[1];
        }
        if(startTime2.compareTo(endTime2) < 0){
            // 上班卡

            String[] startTime3 = startTime2.split(":");
            String startTime1 = "";
            if("11:50:00".compareTo(startTime2) <= 0 && "12:50:00".compareTo(startTime2) >= 0){
                startTime1 = "12:00:00";
            }else{
                if(startTime3[1].compareTo("30") < 0){
                    startTime1 = startTime3[0] + ":00:00";
                }else{
                    startTime1 = startTime3[0] + ":30:00";
                }
            }
            // 下班卡

            String[] endTime3 = endTime2.split(":");
            String endTime1 = "";
            if("11:50:00".compareTo(endTime2) <= 0 && "12:50:00".compareTo(endTime2) >= 0){
                endTime1 = "13:00:00";
            }
            if(endTime3[1].compareTo("00") == 0){
                endTime1 = endTime3[0] + ":00:00";
            }else if(endTime3[1].compareTo("30") <= 0 && endTime3[1].compareTo("00") != 0){
                endTime1 = endTime3[0] + ":30:00";
            }else{
                endTime3[0]  = Integer.toString((Integer.parseInt(endTime3[0]) + 1));
                if(endTime3[0].length() < 2){
                    endTime3[0] = "0" + endTime3[0];
                }
                endTime1 = endTime3[0] + ":00:00";
            }
            String morning = "08:30:00";
            String midday = "12:00:00";
            String midday2 = "13:00:00";
            String afternoon = "17:30:00";


            /**
             * 5.去除8：30之前 && 去除午饭 && 去除17：30之后
             */
            // 上班卡在正式上班之前
            if (startTime1.compareTo(morning) <= 0) {
                // 下班卡在正式上班之后在午饭之前
                if (endTime1.compareTo(morning) > 0
                        && endTime1.compareTo(midday) <= 0) {
                    timeCount = timeCount(morning, endTime1);
                    // 下班卡处于午饭时间
                } else if (endTime1.compareTo(midday) > 0
                        && endTime1.compareTo(midday2) <= 0) {
                    timeCount = timeCount(morning, midday);
                    // 下班卡在午饭之后正式下班之前
                } else if (endTime1.compareTo(midday2) > 0
                        && endTime1.compareTo(afternoon) <= 0) {
                    timeCount = timeCount(morning, endTime1) - 1;
                    // 下班卡在正式下班之后
                } else if (endTime1.compareTo(afternoon) > 0) {
                    timeCount = timeCount(morning, afternoon) - 1;
                }
                // 上班卡在正式上班之后午饭之前
            } else if (startTime1.compareTo(midday) <= 0) {
                // 下班卡比午饭早
                if (endTime1.compareTo(midday) <= 0) {
                    timeCount = timeCount(startTime1, endTime1);
                    // 下班卡处于午饭时间
                } else if (endTime1.compareTo(midday) > 0
                        && endTime1.compareTo(midday2) <= 0) {
                    timeCount = timeCount(startTime1, midday);
                    // 下班卡在午饭之后正式下班之前
                } else if (endTime1.compareTo(midday2) > 0
                        && endTime1.compareTo(afternoon) <= 0) {
                    timeCount = timeCount(startTime1, endTime1) - 1;
                 // 下班卡在正式下班之后
                } else if (endTime1.compareTo(afternoon) > 0) {
                    timeCount = timeCount(startTime1, afternoon) - 1;
                }
                // 上班卡在午饭时间
            } else if (startTime1.compareTo(midday) > 0
                    && startTime1.compareTo(midday2) <= 0) {
                // 下班卡在午饭之后正式下班之前
                if (endTime1.compareTo(midday2) > 0
                        && endTime1.compareTo(afternoon) <= 0) {
                    timeCount = timeCount(midday2, endTime1);
                 // 下班卡在正式下班之后
                } else if (endTime1.compareTo(afternoon) > 0) {
                    timeCount = timeCount(midday2, afternoon) - 1;
                }
                // 上班卡在正式下班之后
            } else if (startTime1.compareTo(midday2) > 0) {
                // 下班卡在午饭之后正式下班之前
                if (endTime1.compareTo(midday2) > 0
                        && endTime1.compareTo(afternoon) <= 0) {
                    timeCount = timeCount(startTime1, endTime1);
                 // 下班卡在正式下班之后
                } else if (endTime1.compareTo(afternoon) > 0) {
                    timeCount = timeCount(startTime1, afternoon) ;
                }
            }
        }
        if(timeCount < 0){
            timeCount = 0;
        }
        return timeCount;
    }
}


