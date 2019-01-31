package com.json;

import org.json.JSONObject;

/**
 * @author jzx
 * @date 2019/01/30 16:19
 * @Description:
 */
public class Main {
    public static void main(String[] strings){
       JSONObject response= new JSONObject("{'ret_code':-1,'err_msg':'message type error!'}");
       System.out.println(response.getInt("ret_code"));
    }
}
