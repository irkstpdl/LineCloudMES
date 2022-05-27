package com.lc.plugin.internal.dependencymanager;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.DirectedGraph;
import org.jgrapht.alg.CycleDetector;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lc.plugin.api.Plugin;
import com.lc.plugin.api.PluginAccessor;
import com.lc.plugin.api.PluginDependencyInformation;
import com.lc.plugin.api.PluginDependencyResult;
import com.lc.plugin.internal.api.PluginDependencyManager;
import com.lc.plugin.internal.api.PluginDependencyResultImpl;

public class DefaultPluginDependencyManager {
}
