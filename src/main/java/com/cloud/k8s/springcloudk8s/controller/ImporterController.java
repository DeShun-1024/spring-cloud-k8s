package com.cloud.k8s.springcloudk8s.controller;


import com.cloud.k8s.springcloudk8s.spring.importer.ImportBeanDemo;
import com.cloud.k8s.springcloudk8s.spring.importer.MyEnable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@MyEnable
@RestController
@RequestMapping("/import")
public class ImporterController {

    @Autowired
    private ImportBeanDemo importBeanDemo;

    @GetMapping("/myImportSelector")
    public String myImportSelector() {
        return importBeanDemo.get();
    }
}
