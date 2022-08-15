package org.cwsya.toolBox.scan;

import java.io.File;

/**
 * 树节点处理方法中的参数过滤 - 函数式接口
 * @author cws
 */
public interface PluginUtilFileFun {
    /**
     * 函数式接口的处理方法
     * @param file 待处理的文件
     * @return 是否需要处理
     */
    Boolean run(File file);
}