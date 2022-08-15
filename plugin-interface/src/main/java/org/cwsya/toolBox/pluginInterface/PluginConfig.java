package org.cwsya.toolBox.pluginInterface;

import javax.swing.*;

/**
 * 插件配置接口
 * @author cws
 */
public interface PluginConfig {
    /**
     * 获取插件主页面
     * @return 插件主页面
     */
    JFrame getIndex();

    /**
     * 获取插件名称
     * @return 插件名称
     */
    String getName();

    /**
     * 获取插件作者
     * @return 插件作者
     */
    String getAuthor();

    /**
     * 获取插件描述
     * @return 插件描述
     */
    String getDescribe();

    /**
     * 获取插件相关网址
     * @return url
     */
    String getUrl();
}
