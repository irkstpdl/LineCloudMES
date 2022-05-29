package com.lc.plugin.internal.servermanager;


import java.io.IOException;

import freemarker.log.Logger;
import org.apache.juli.logging.Log;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lc.plugin.api.PluginServerManager;
import com.lc.plugin.internal.PluginException;

@Service
public class DefaultPluginServerManager implements PluginServerManager{

    private static final Logger.LOG = LoggerFactory.getLogger(DefaultPluginServerManager.class);

    @Value("#{plugin.restartCommand}")
    private String restartCommand;

    @Override
    public void restart(){
        try {
            Process shutdownProcess = Runtime.getRuntime().exec(restartCommand);
            shutdownProcess.waitFor();

            if (Log.isDebugEnabled()) {
                LOG.debug("Shutdown exit value: " + shutdownProcess.exitValue());
            }
        } catch (IOException e) {
            throw new PluginException("Restart failed - " + e.getMessage(), e));
        } catch (IOException e) {
            throw new PluginException("Restart failed - " + e.getMessage(), e);
        }
    }

    void setRestartCommand(final String restartCommand) {
        this.restartCommand =restartCommand;
    }

}
