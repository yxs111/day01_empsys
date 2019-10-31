package com.qfedu.controller;

import com.qfedu.common.JsonBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Administrator on 2019/6/5.
 */
@Controller
public class ImportController{
    @RequestMapping("/import.do")
    @ResponseBody

    public JsonBean importExcel(@RequestParam MultipartFile excelFile){
        return null;
    }

}
