package com.lc.mes.basic.util;

import static com.lc.mes.basic.constants.ParameterFields.ADDITIONAL_TEXT_IN_FOOTER;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.lc.localization.api.TranslationService;
import com.lc.mes.basic.CompanyService;
import com.lc.mes.basic.ParameterService;
import com.lc.model.api.Entity;
import com.lc.report.api.Footer;
import com.lc.report.api.FooterResolver;
import com.lc.report.api.pdf.PdfHelper;


public class BasicFooterResolver {
}
