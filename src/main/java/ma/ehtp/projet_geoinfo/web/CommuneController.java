package ma.ehtp.projet_geoinfo.web;

import lombok.AllArgsConstructor;
import ma.ehtp.projet_geoinfo.repository.CommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class CommuneController {
    @Autowired
    CommuneRepository communeRepository;
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
