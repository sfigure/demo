
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import sun.util.resources.LocaleData;

class Test {
    public String createdAt;
    public String userId;
    Test(String createdAt,String userId){
        this.createdAt=createdAt;
        this.userId=userId;
    }
    
    @Override
    public String toString() {
        return userId.toString()+" "+createdAt;
    }
    
    public String getCreatedAt() {
        return createdAt;
    }
}
public class Main {

    static void  test(List<String> list,List<String> list1){
        System.out.println(System.identityHashCode(list));
        list=new ArrayList<>();
        System.out.println(System.identityHashCode(list));
        list.add("test1");
        list1.add("list1 test");
    }

    static Long startTimestamp = 1546272000L;

    static Long endTimeStamp = 1577808000L;


    static String getKeyFile(String filePath) throws Exception {
        try {
            URL url = new URL(filePath);
            Path p = Paths.get(url.getPath());
            String fullFileName = p.toString();
            File f = new File(fullFileName);
            if (f.exists() && !f.isDirectory()) {
                String line;
                BufferedReader bufferedReader;
                try (FileReader fileReader = new FileReader(fullFileName)) {
                    bufferedReader = new BufferedReader(fileReader);
                }
                StringBuilder fileContent = new StringBuilder();
                while ((line = bufferedReader.readLine()) != null) {
                    fileContent.append(line);
                }
                bufferedReader.close();
                return fileContent.toString();
            } else {
                String dir = p.getParent().toString();
                File dirFile = new File(dir);
                //不存在就创建目录
                dirFile.mkdirs();

                if (f.createNewFile()) {
                    System.out.println("创建配置文件错误");
                }
                try (InputStream inputStream = url.openStream()) {
                    File targetFile = new File(fullFileName);
                    byte[] buffer = new byte[inputStream.available()];
                    int readInfo = inputStream.read(buffer);
                    if (readInfo == -1) {
                        System.out.println("创建配置文件错误");
                    }
                    try (OutputStream outStream = new FileOutputStream(targetFile)) {
                        outStream.write(buffer);
                    }
                    return new String(buffer);
                }
            }

        } catch (Exception e) {
            throw new Exception("异常");
        }
    }

    private static final  String YEAR_MONTH="%04d-%02d";

    public static void main(String[] args) throws Exception{
        Long s=3610L;
        System.out.println((s/3600)+"h"+(s%3600));
//        Test2 test2=new Test2();
//        test2.get("sasa");


//        Map<String,Object> map=new HashMap<>();
//        System.out.println(map.get("aa"));

//        URL url = new URL("http://qbxc-oss.oss-cn-beijing.aliyuncs.com/qbxc/test/1/1564978036091apiclient_cert.p12");
//        getKeyFile("http://qbxc-oss.oss-cn-beijing.aliyuncs.com/qbxc/test/1/1564978036091apiclient_cert.p12");
//        String line = null;
//        FileReader fileReader = new FileReader(fullFileName);
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        StringBuilder fileContent = new StringBuilder();
//        while ((line = bufferedReader.readLine()) != null) {
//            fileContent.append(line);
//        }
//        bufferedReader.close();
//        System.out.print("内容");
//        System.out.print(fileContent.toString());

//        System.out.print(a);
//        File targetFile = new File(filename);
//        targetFile.mkdir();
//        targetFile.mkdirs();

//        InputStream inputStream = url.openStream();
//        byte[] buffer = new byte[inputStream.available()];
//        inputStream.read(buffer);
//        OutputStream outStream = new FileOutputStream(targetFile);
//        outStream.write(buffer);
//        inputStream.close();
//        outStream.close();

//
//        Optional<Timestamp> lastUpdatedAt;
//        Timestamp t=new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-01-01 00:00:00").getTime());
//        Long start=t.getTime();
//        Long end=System.currentTimeMillis();
//        System.out.println(start);
//        System.out.println(end);
//
//        Long SN=0L;
//        while (end >= start) {
//            SN=SN+1;
//            System.out.print("SN"+SN.toString());
//            end = end - 86400*1000;
//        }

//        Calendar calendar= Calendar.getInstance();
//        Long dateTimestamp=startTimestamp;
//        Date date = new Date();
//        int sn=1;
//        while (dateTimestamp<endTimeStamp){
//            date.setTime(dateTimestamp*1000);
//            calendar.setTime(date);
//            int year=calendar.get(Calendar.YEAR);
//            int month=calendar.get(Calendar.MONTH);
//            int day=calendar.get(Calendar.DATE);
//            int week=calendar.get(Calendar.DAY_OF_WEEK);
//            int week_of_year=calendar.get(Calendar.WEEK_OF_YEAR);
//            System.out.print(String.format("S:%s,S:%s,Y:%s,M:%s,D:%s,W:%s,W_OF_Y:%s\n",sn,dateTimestamp,year,month+1,day,week,week_of_year));
//
//
//            dateTimestamp=dateTimestamp+86400L;
//            sn++;
//        }
//        List<String> list=new ArrayList<>();
//        List<String> list1=new ArrayList<>();
//        System.out.println(System.identityHashCode(list));
//        test(list,list1);
//        System.out.println(list);
        
        
//        Map<String, Object> parameterMap = new HashMap<>(16);
//        String postBody="&=&===";
//        String[] parameters = postBody.toString().split("&");
//        for (String parameter : parameters) {
//            String[] parameterNameAndValue = parameter.split("=");
//            if (parameterNameAndValue.length == 0) {
//                System.out.println("错误");
//            }
//            parameterMap.put(parameterNameAndValue[0], parameterNameAndValue.length == 2 ? parameterNameAndValue[1] : "");
//        }
    
    
//       System.out.println( BigDecimal.ONE.compareTo(BigDecimal.ZERO)>=0);
//        Thread.currentThread().setName("测试进程");
//        while (true){
//            Integer [] a=new Integer[1024*1024];
//            Thread.sleep(1000L);
//        }
        
    
//        List<Integer> ret=Arrays.stream(",".split("\\,")).filter(s -> s.contains("p_"))
//                .map(s->s.substring(2,s.length()))
//                .map(s->Integer.valueOf(s))
//                .collect(Collectors.toList());
//        System.out.println(ret);
//
//        Arrays.stream("p_1,p_2,p_3,o_1".split("\\,")).filter(s -> s.contains("o_"));
     
            
            
            //        Object o="111";
//        System.out.println(String.valueOf(
//                o
//        ));
//        List<Test> tests=new ArrayList<>();
//        Test test1=new Test("2019-6-13","1");
//        tests.add(test1);
//        Test test2=new Test("2019-6-13","2");
//        tests.add(test2);
//        Test test3=new Test("2019-6-14","3");
//        tests.add(test3);
//        Test test4=new Test("2019-6-15","4");
//        tests.add(test4);
//
//        Map<String, List<Test>> res=tests.stream().collect(Collectors.groupingBy(Test::getCreatedAt,Collectors.toList()));
//        System.out.println(res);
//        res.forEach((String i, List<Test> item)->{
//            System.out.println(item);
//        });
    
    }
}
