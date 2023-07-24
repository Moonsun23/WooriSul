package hanjan.yeji.boot.woorisul.controller;

import hanjan.yeji.boot.woorisul.service.BreweryService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brewery")
@RequiredArgsConstructor
public class BreweryController {

    final BreweryService bsrv;

    Logger logger= LogManager.getLogger(BreweryController.class);


    @GetMapping("/list/{cpg}")
    public String list(Model m, @PathVariable Integer cpg){
        logger.info("brewery/list 호출!");

        m.addAttribute("brs", bsrv.readBrewery(cpg));
        m.addAttribute("cpg", cpg);
        m.addAttribute("cntpg", bsrv.countBrewery());

        if(cpg > (int)m.getAttribute("cntpg"))  {
            return "redirect:/brewery/list/1";
        }

        return "brewery/list";
    }

    @GetMapping("/view/{bno}")
    public String view(Model m, @PathVariable String bno){
        logger.info("brewery/view 호출!");
        m.addAttribute("br", bsrv.readOneBrewery(bno));

        return "brewery/view";
    }



}
