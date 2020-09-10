package com.dhc.钉钉api操作;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dhc.钉钉api操作.net.OkHttpHelper;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.rmi.MarshalledObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Haochen.Dai
 * @date Created in 2020/6/7 19:25
 * @description
 */
public class Solution {

    private final static String CORP_ID = "dingee142412a919c640acaaa37764f94726";

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.createProcess());
    }


    //66bf11f50fe53010a3903c838c2a98e0
    //262566533621247756 liu
    //2940534200650594 yu
    //manager7327

    public String createProcess() {
        final String URL = "https://oapi.dingtalk.com/topapi/processinstance/create?access_token=" + getToken();
        String userId = "262566533621247756";
        Map<String, Object> map = new HashMap<>();
        map.put("process_code", getProcessCodeByName());
        map.put("originator_user_id", userId);
        map.put("dept_id", -1);
        map.put("approvers", "2940534200650594," + getUserIdByMobile("18258638128"));
        List<Map> list = buildFormComponents("第一次测试", "详细需求", "戴豪辰提出", "戴豪辰开发", "戴豪辰测试", "a:20200608 \n b:20200608");
        map.put("form_component_values", list);

        return getResonse(buildPostRequest(map, URL), "process_instance_id");

    }

    public List<Map> buildFormComponents(String... values) {
        List<Map> result = new ArrayList<>();

        Map<String, String> formComponent1 = new HashMap<>();
        formComponent1.put("name", "任务名称");
        formComponent1.put("value", values[0]);

        Map<String, String> formComponent2 = new HashMap<>();
        formComponent2.put("name", "需求描述");
        formComponent2.put("value", values[1]);

        Map<String, String> formComponent3 = new HashMap<>();
        formComponent3.put("name", "需求提出者");
        formComponent3.put("value", values[2]);

        Map<String, String> formComponent4 = new HashMap<>();
        formComponent4.put("name", "开发人员");
        formComponent4.put("value", values[3]);

        Map<String, String> formComponent5 = new HashMap<>();
        formComponent5.put("name", "测试人员");
        formComponent5.put("value", values[4]);

        Map<String, String> formComponent6 = new HashMap<>();
        formComponent6.put("name", "涉及服务以及最近发版情况");
        formComponent6.put("value", values[5]);

        result.add(formComponent1);
        result.add(formComponent2);
        result.add(formComponent3);
        result.add(formComponent4);
        result.add(formComponent5);
        result.add(formComponent6);
        return result;
    }

    /**
     * 通过 userid 获取部门id
     * @param userId
     * @return
     */
    public String getDeptIdByUserId(String userId) {
        final String URL = "https://oapi.dingtalk.com/user/get?access_token=" + getToken() + "&userid=" + userId;
        JSONArray deptIdArray = JSON.parseArray(getResonse(buildGetRequest(URL), "department"));
        return deptIdArray.getString(deptIdArray.size() - 1);
    }

    /**
     * 根据手机号获取user id
     * @param mobile 手机号
     * @return user id
     */
    public String getUserIdByMobile(String mobile) {
        final String URL = "https://oapi.dingtalk.com/user/get_by_mobile?access_token=" + getToken() + "&mobile=" + mobile;
        return getResonse(buildGetRequest(URL), "userid");
    }

    /**
     * 获取模板code
     * @return 获取code
     */
    public String getProcessCodeByName() {
        final String URL = "https://oapi.dingtalk.com/topapi/process/get_by_name?access_token=" + getToken();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "开发需求工单");
        return getResonse(buildPostRequest(map, URL), "process_code");
    }


    /**
     *
     * @param key
     * @return
     */
    private String getResonse(Request request, String key) {
        try {
            Response response = OkHttpHelper.execute(request);
            if (response.body() != null) {
                JSONObject jsonObject = JSONObject.parseObject(response.body().string());
                return jsonObject.getString(key);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 获取钉钉 token
     * @return 钉钉 token
     */
    public String getToken() {
        final String URL = "https://oapi.dingtalk.com/gettoken?appkey=dingkrjplaapigx9z78n&appsecret=lg7VBhjYASGK58-vkQFMGyLxy8-oPkWuG64x-JepgdqBYqYbttMZab6SmYHsw7_w";
        return getResonse(buildGetRequest(URL), "access_token");
    }


    public Request buildGetRequest(String url) {
        Request request = new Request.Builder().url(url).get().build();
        return request;
    }

    public Request buildPostRequest(Map<String, Object> mapInfo, String url) {
        RequestBody body = RequestBody.create(OkHttpHelper.APPLICATION_JSON, JSON.toJSONString(mapInfo));
        Request request = new Request.Builder().url(url).post(body).build();
        return request;
    }



}
