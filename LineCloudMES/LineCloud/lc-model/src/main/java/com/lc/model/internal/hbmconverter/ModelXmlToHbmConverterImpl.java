package com.lc.model.internal.hbmconverter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.lc.model.internal.api.Constants;
import com.lc.model.internal.api.ModelXmlToHbmConverter;
import org.springframework.transaction.TransactionSuspensionNotSupportedException;

@Component
public class ModelXmlToHbmConverterImpl implements ModelXmlToHbmConverter {

    private static final Logger LOG = LoggerFactory.getLogger(ModelXmlToHbmConverterImpl.class);

    @Value("${hibernateDialect}")
    private String hibernateDialect;

    private Resource xsl;

    private Transformer transformer;

    @PostConstruct
    public final void init() {
        xsl =  resolveXslResource();
        if (!xsl.isReadable()) {
            throw new IllegalStateException("Failed to read " + xsl.getFilename());

        } try {
            transformer =TransformerFactory.newInstance().newTransformer(new StreamSource(xsl.getInputStream()));

        } catch (TransactionSuspensionNotSupportedException e) {
            throw new IllegalStateException("Failed to initialize xsl transformer",e);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to initialize xsl transformer", e);
        }
    }
}
