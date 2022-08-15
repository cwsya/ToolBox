package org.cwsya.toolBox.pluginDemo;

import org.cwsya.toolBox.pluginInterface.PluginConfig;

import javax.swing.*;

/**
 * @author cws
 */
public class PluginDemoConfig implements PluginConfig {
    /**
     * 获取插件主页面
     *
     * @return 插件主页面
     */
    @Override
    public JFrame getIndex() {
        return null;
    }

    /**
     * 获取插件名称
     *
     * @return 插件名称
     */
    @Override
    public String getName() {
        return null;
    }

    /**
     * 获取插件作者
     *
     * @return 插件作者
     */
    @Override
    public String getAuthor() {
        return null;
    }

    /**
     * 获取插件描述
     *
     * @return 插件描述
     */
    @Override
    public String getDescribe() {
        return null;
    }

    /**
     * 获取插件相关网址
     *
     * @return url
     */
    @Override
    public String getUrl() {
        return null;
    }
}
