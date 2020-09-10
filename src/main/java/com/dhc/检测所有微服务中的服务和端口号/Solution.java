package com.dhc.检测所有微服务中的服务和端口号;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ：Haochen.Dai
 * @date ：Created in 2019/12/14 13:53
 * @description：
 */
public class Solution {
    public static void main(String[] args) {
        File rootFile = new File("D:\\gitLab\\servs");
        File[] cloudFiles = rootFile.listFiles();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (File cloudFile : cloudFiles) {
            if (cloudFile.getName().startsWith("cloud")) {
                File ymlFile = new File(cloudFile.getAbsolutePath() + "\\src\\main\\resources\\application.yml");
                InputStream reader = null;
                try {
                    reader = new FileInputStream(ymlFile);
                    //yml读取配置文件,指定返回类型为Map,Map中value类型为LinkedHashMap
                    Yaml yml = new Yaml();
                    Map<String, Object> ymlMap = yml.loadAs(reader, Map.class);
                    Map<String, Object> ServerMap = (Map)ymlMap.getOrDefault("server", new HashMap<String, Object>());
                    map.put(cloudFile.getName(), (Integer) ServerMap.get("port"));
                } catch (Exception e) {
                    System.out.println(cloudFile.getAbsolutePath());
                    e.printStackTrace();
                }
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "---" + entry.getValue());

        }
    }
}
