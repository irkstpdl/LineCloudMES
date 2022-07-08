package com.lc.localization.internal.module;

import com.lc.localization.api.TranslationPropertiesHolder;
import com.lc.localization.internal.ConfigUtil;
import com.lc.localization.internal.TranslationModuleService;
import com.lc.plugin.api.Module;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TranslationModule extends Module implements TranslationPropertiesHolder {

    private final ApplicationContext applicationContext;

    private final TranslationModuleService translationModuleService;

    private final Set<String> basenames = new LinkedHashSet<>();

    private final String pluginIdentifier;

    private final String basename;

    private final String path;

    private final boolean hotDeploy;

    private final String sourceBasePath;

    public TranslationModule(final ApplicationContext applicationContext,
                             final TranslationModuleService translationModuleService, final ConfigUtil configUtil, final String pluginIdentifier, final String basename,
                             final String path) {
        super();
        this.applicationContext = applicationContext;
        this.translationModuleService = translationModuleService;
        this.pluginIdentifier = pluginIdentifier;
        this.basename = basename;
        this.path = path;
        this.sourceBasePath = configUtil.getSourceBasePath();
        this.hotDeploy = configUtil.isHotDeploy();
    }

    @Override
    public void enableOnStartup() {
        enable();
    }

    @Override
    public void enable() {
        translationModuleService.addTranslationModule(parseBasenames());
    }

    @Override
    public void multiTenantEnable() {

    }

    @Override
    public void multiTenantDisable() {

    }

    @Override
    public void disable() {
        translationModuleService.removeTranslationModule(basenames);
    }

    private Set<String> parseBasenames() {
        if (basename == null || "*".equals(basename)) {
            basenames.addAll(getAllFilesFromPath());

        } else if (hotDeploy) {
            basenames.add(findPluginPath(pluginIdentifier) + "/" + path + "/" + basename);

        } else {
            basenames.add("classpath:" + pluginIdentifier + "/" + path + "/" + basename);
        }

        return basenames;
    }

    @Override
    public Set<String> getParsedBasenames() {
        return basenames;
    }

    @Override
    public String getPluginIdentifier() {
        return pluginIdentifier;
    }

    private Collection<? extends String> getAllFilesFromPath() {
        Set<String> basenamesInDirectory = new LinkedHashSet<>();

        try {
            Resource[] resources = applicationContext.getResources("classpath*:" + pluginIdentifier + "/" + path + "/*.properties");
            Pattern pattern = Pattern.compile("([a-z][a-zA-Z0-9]*)\\_\\w+\\.properties");

            for (Resource resource : resources) {
                Matcher matcher = pattern.matcher(resource.getFilename());

                if (matcher.matches()) {
                    if (hotDeploy) {
                        basenamesInDirectory.add(findPluginPath(pluginIdentifier) + "/" + path + "/" + matcher.group(1));

                    } else {
                        basenamesInDirectory.add("classpath:" + pluginIdentifier + "/" + path + "/" + matcher.group(1));
                    }
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not find localization resources", e);
        }

        return basenamesInDirectory;
    }

    private String findPluginPath(String pluginIdentifier) {
        List<String> prefixes = Arrays.asList("/mes/mes-plugins/", "/mes-commercial/", "/qcadoo/");

        for (String prefix : prefixes) {
            String f = sourceBasePath + prefix;
            if (Files.isDirectory(Paths.get(f))) {
                Path dir = FileSystems.getDefault().getPath(f);
                try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
                    for (Path pluginMainDir : stream) {
                        Path file = pluginMainDir.resolve("src/main/resources/").resolve(pluginIdentifier);
                        if (Files.exists(file)) {
                            String x = file.toUri().toURL().toString();
                            return x;
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return "";
    }
}
