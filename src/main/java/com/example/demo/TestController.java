package com.example.demo;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.maven.shared.invoker.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;

/**
 * @Author: 李欣桦
 * @Date: 2019/2/27 4:19 PM
 */
@RestController
@RequestMapping("/test")
@CommonsLog
public class TestController {
    @Value("${maven.home}")
    private String mavenHome;
    @GetMapping("/createPdf")
    public HashMap createPdf() {
        HashMap map = new HashMap();

        //将maven路径的权限设置为777，否则执行maven命令会报Permission Denied
        try {
            Process chmodMaven  = new ProcessBuilder("chmod", "-R", "777", mavenHome).start();
            chmodMaven.waitFor();
        } catch (Exception e) {
            log.error("Permission has error:"+e.toString());
        }

        InvocationRequest request = new DefaultInvocationRequest();
        request.setPomFile(new File("pom.xml"));
        request.setGoals(Collections.singletonList("clean test"));

        Invoker invoker = new DefaultInvoker();
        invoker.setMavenHome(new File(mavenHome));


        try {
            if (invoker.execute(request).getExitCode() == 0) {
                String pomPath = request.getPomFile().getAbsolutePath();
                String path = pomPath.substring(0,pomPath.lastIndexOf(File.separator));
                File file = new File(path +"/target/asciidoc/pdf/index.pdf");
                System.out.println(file);
                map.put("status", "Y");
                map.put("message","文件路径:"+file.getPath());
            } else {
                map.put("status", "N");
                map.put("message","生成文档失败");
            }
        } catch (MavenInvocationException e) {
            log.error("invoker request has error:"+e.toString());
        }
        return map;
    }
}
