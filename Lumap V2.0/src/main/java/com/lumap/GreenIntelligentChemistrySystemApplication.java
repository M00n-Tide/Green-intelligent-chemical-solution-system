package com.lumap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class GreenIntelligentChemistrySystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreenIntelligentChemistrySystemApplication.class, args);
        System.out.println("\n===========================================");
        System.out.println("绿色智能化学系统启动成功!");
        System.out.println("Web控制台访问地址: http://localhost:8080/h2-console");
        System.out.println("前端应用访问地址: http://localhost:8080/");
        System.out.println("===========================================\n");
    }
}