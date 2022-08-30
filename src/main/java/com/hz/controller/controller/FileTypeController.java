package com.hz.controller.controller;

import com.hz.pojo.FileType;
import com.hz.pojo.filetype.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@Controller
public class FileTypeController {
    @Bean("bmp")
    public FileType bmp(){
        return new bmp();
    }

    @Bean("gif")

    public FileType gif(){
        return new gif();
    }

    @Bean(name = "jpeg")
    public FileType jpeg(){
        return new jpeg();
    }

    @Bean("jpg")
    public FileType jpg(){
        return new jpg();
    }
    @Bean("png")
    public FileType png(){
        return new png();
    }

}
