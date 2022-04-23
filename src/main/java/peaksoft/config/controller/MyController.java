package peaksoft.config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String getAllStudent(){
        return "all_student";
    }

    @GetMapping("/hr-info")
    public String getInfoForHr(){
        return "view_hr";
    }

    @GetMapping("/manager_info")
    public String getInfoManager(){
        return "view_manager";

    }
}
