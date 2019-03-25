package mrjason.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: MrJason
 * Date: 2019-03-22
 * Time: 20:58
 */

@Controller
public class Helloworld {

    @RequestMapping("/hello")
    @ResponseBody()
    public Map<String,Object> Hello(){
        Map<String,Object> map  = new HashMap<>();
        map.put("msg","Hello");
        return map;
    }
}
