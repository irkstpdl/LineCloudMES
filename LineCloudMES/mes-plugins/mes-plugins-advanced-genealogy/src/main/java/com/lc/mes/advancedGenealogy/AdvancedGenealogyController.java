package com.lc.mes.advancedGenealogy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AdvancedGenealogyController {

    @RequestMappting(value = "advancedGenealogy/trackingRecordReport.pdf",method = RequestMethod.GET)
    public final ModelAndView trackingRecordDetailsReportPdf(@RequestParam("id") final String id ) {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("trackingRecordPdfView");
        mav.addObject("id",id);

        return mav;
    }


}
