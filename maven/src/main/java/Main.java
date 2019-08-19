import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jzx
 * @date 2019/07/06 17:17
 * @Description:
 */


class Holiday {
    String date;
    String desc;
    String status;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Holiday{" +
                       "date='" + date + '\'' +
                       ", desc='" + desc + '\'' +
                       ", status='" + status + '\'' +
                       '}' + "\n";
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

public class Main {

    static String body = "{\"reason\":\"Success\", \"result\":{ \"data\":{ \"year\":\"2019\", \"year-month\":\"2019-6\", \"holiday\":\"[{\\\"desc\\\":\\\"5月1日放假\\\",\\\"festival\\\":\\\"2019-5-1\\\",\\\"list\\\":[{\\\"date\\\":\\\"2019-5-1\\\",\\\"status\\\":\\\"1\\\"},{\\\"date\\\":\\\"2019-5-2\\\",\\\"status\\\":\\\"1\\\"},{\\\"date\\\":\\\"2019-5-3\\\",\\\"status\\\":\\\"1\\\"},{\\\"date\\\":\\\"2019-5-4\\\",\\\"status\\\":\\\"1\\\"},{\\\"date\\\":\\\"2019-4-28\\\",\\\"status\\\":\\\"2\\\"},{\\\"date\\\":\\\"2019-5-5\\\",\\\"status\\\":\\\"2\\\"}],\\\"list#num#\\\":6,\\\"name\\\":\\\"劳动节\\\",\\\"rest\\\":\\\"拼假建议：4月28日（周日）~4月30日（周二）请假3天，可拼8天劳动节小长假\\\"},{\\\"desc\\\":\\\"6月7日放假，与周末连休。\\\",\\\"festival\\\":\\\"2019-6-7\\\",\\\"list\\\":[{\\\"date\\\":\\\"2019-6-7\\\",\\\"status\\\":\\\"1\\\"},{\\\"date\\\":\\\"2019-6-8\\\",\\\"status\\\":\\\"1\\\"},{\\\"date\\\":\\\"2019-6-9\\\",\\\"status\\\":\\\"1\\\"}],\\\"list#num#\\\":3,\\\"name\\\":\\\"端午节\\\",\\\"rest\\\":\\\"拼假建议：2019年6月3日（周一）~2019年6月6日（周四）请假4天，可拼9天端午节小长假\\\"}]\", \"holiday_array\":[ { \"desc\":\"5月1日放假\", \"festival\":\"2019-5-1\", \"list\":[ { \"date\":\"2019-5-1\", \"status\":\"1\" }, { \"date\":\"2019-5-2\", \"status\":\"1\" }, { \"date\":\"2019-5-3\", \"status\":\"1\" }, { \"date\":\"2019-5-4\", \"status\":\"1\" }, { \"date\":\"2019-4-28\", \"status\":\"2\" }, { \"date\":\"2019-5-5\", \"status\":\"2\" } ], \"list#num#\":6, \"name\":\"劳动节\", \"rest\":\"拼假建议：4月28日（周日）~4月30日（周二）请假3天，可拼8天劳动节小长假\", \"list_num\":6 }, { \"desc\":\"6月7日放假，与周末连休。\", \"festival\":\"2019-6-7\", \"list\":[ { \"date\":\"2019-6-7\", \"status\":\"1\" }, { \"date\":\"2019-6-8\", \"status\":\"1\" }, { \"date\":\"2019-6-9\", \"status\":\"1\" } ], \"list#num#\":3, \"name\":\"端午节\", \"rest\":\"拼假建议：2019年6月3日（周一）~2019年6月6日（周四）请假4天，可拼9天端午节小长假\", \"list_num\":3 } ] } }, \"error_code\":0 }";

    
    public static void main(String[] argv) {

        System.out.print(DayOfWeekChineseNameEnum.of(1).getDayOfWeekName());
//        String dateString=String.format("%s-%02d-%s",2019,0,2);
//        System.out.print(dateString);
//
//        Map<String, Holiday> festival = new HashMap<>(16);
//        List<Map<String, Object>> holiday_array = JsonPath.read(body, "$.result.data.holiday_array");
//        holiday_array.forEach(holidayItem -> {
//            JSONArray list = (JSONArray) holidayItem.get("list");
//            String key = (String) holidayItem.get("festival");
//            Holiday holiday = new Holiday();
//            String name = (String) holidayItem.get("name");
//            holiday.setDate((String) holidayItem.get("festival"));
//            holiday.setDesc(name);
//            festival.put(key, holiday);
//            list.forEach(day -> {
//                HashMap<String, String> dayItem = (HashMap<String, String>) day;
//                Holiday holidayDay = new Holiday();
//                String holidayDayDate = (String) dayItem.get("date");
//                holidayDay.setDate(holidayDayDate);
//                if (!holidayDayDate.equals(key)) {
//                    holidayDay.setDesc(name + "放假");
//                } else {
//                    holidayDay.setDesc(name);
//                }
//                if (((String) dayItem.get("status")).equals("2")) {
//                    holidayDay.setDesc(name + "调休");
//                }
//                holidayDay.setStatus((String) dayItem.get("status"));
//                festival.put(holidayDayDate, holidayDay);
//            });
//        });
//        new ArrayList<Holiday>(festival.values());
    }
}
