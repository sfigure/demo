import java.time.DateTimeException;

/**
 * CouponUseEnum
 *
 * @author jzx
 * @date 2019/1/2 14:16
 */
public enum DayOfWeekChineseNameEnum {
    MONDAY(1, "星期一", "周一", 2),
    TUESDAY(2, "星期二", "周二", 2),
    WEDNESDAY(3, "星期三", "周三", 2),
    THURSDAY(4, "星期四", "周四", 2),
    FRIDAY(5, "星期五", "周五", 2),
    SATURDAY(6, "星期六", "周六", 1),
    SUNDAY(7, "星期日", "周日", 1);
    
    private Integer dayOfWeek;
    private String dayOfWeekName;
    private String dayOfWeekShortName;
    private Integer isWork;
    
    public String getDayOfWeekShortName() {
        return dayOfWeekShortName;
    }
    
    public String getDayOfWeekName() {
        return dayOfWeekName;
    }
    
    public Integer getDayOfWeek() {
        return dayOfWeek;
    }
    
    public Integer getIsWork() {
        return isWork;
    }
    
    private static final DayOfWeekChineseNameEnum[] ENUMS = DayOfWeekChineseNameEnum.values();
    
    DayOfWeekChineseNameEnum(int dayOfWeek, String dayOfWeekName, String dayOfWeekShortName, Integer isWork) {
        this.dayOfWeek = dayOfWeek;
        this.dayOfWeekName = dayOfWeekName;
        this.dayOfWeekShortName = dayOfWeekShortName;
        this.isWork = isWork;
    }
    
    
    public static DayOfWeekChineseNameEnum of(int dayOfWeek) {
        if (dayOfWeek < 1 || dayOfWeek > 7) {
            throw new DateTimeException("Invalid value for DayOfWeek: " + dayOfWeek);
        }
        if(dayOfWeek==1){
            dayOfWeek=7;
        }
        return ENUMS[dayOfWeek-1];
    }
    
}
