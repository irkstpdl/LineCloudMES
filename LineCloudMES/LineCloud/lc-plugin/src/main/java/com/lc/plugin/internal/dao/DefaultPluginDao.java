package com.lc.plugin.internal.dao;

import com.google.common.collect.Sets;
//import com.lc.model.beans.lcPlugin.LineCloudPluginPlugin;
import com.lc.plugin.api.Plugin;
import com.lc.plugin.internal.api.PluginDao;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class DefaultPluginDao implements PluginDao {

    private static final String L_PLUGIN = "plugin";

    @Autowired
    @Qualifier(L_PLUGIN)
    private SessionFactory sessionFactory;

    @Override
    @Transactional(L_PLUGIN)
    public void save(final LinecloudPluginPlugin plugin) {
        sessionFactory.getCurrentSession().save(plugin);
    }

    @Override
    @Transactional(L_PLUGIN)
    public void save(final Plugin plugin) {
        LinecloudPluginPlugin existingPlugin = get(plugin.getIdentifier());
        if (existingPlugin == null) {
            existingPlugin = new LinecloudPluginPlugin(plugin);
        } else {
            existingPlugin.setState(plugin.getState().toString());
            existingPlugin.setVersion(plugin.getVersion().toString());
            existingPlugin.setIsSystem(plugin.isSystemPlugin());
            existingPlugin.setGroupName(plugin.getPluginInformation() == null ? null : plugin.getPluginInformation().getGroup());
            existingPlugin.setLicense(plugin.getPluginInformation() == null ? null : plugin.getPluginInformation().getLicense());

        }
        save(existingPlugin);
    }

    @Override
    @Transactional(L_PLUGIN)
    public void delete(final LinecloudPluginPlugin plugin) {
        sessionFactory.getCurrentSession().delete(plugin);
    }

    @Override
    @Transactional(L_PLUGIN)
    public void delete(final Plugin plugin) {
        LinecloudPluginPlugin existingPlugin = get(plugin.getIdentifier());
        if (existingPlugin != null) {
            delete(existingPlugin);
        }
    }

    @Override
    @Transactional(value = L_PLUGIN, readOnly = true)
    @SuppressWarnings("unchecked")
    public Set<LinecloudPluginPlugin> list() {
        return Sets.newHashSet(sessionFactory.getCurrentSession().createCriteria(LinecloudPluginPlugin.class).list());
    }

    private LinecloudPluginPlugin get(final String identifier) {
        return (LinecloudPluginPlugin) sessionFactory.getCurrentSession().createCriteria(LinecloudPluginPlugin.class)
                .add(Restrictions.eq("identifier", identifier)).uniqueResult();
    }

    void setSessionFactory(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}