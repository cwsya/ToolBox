package org.cwsya.toolBox.scan;

import java.io.File;

/**
 * 树节点的处理方法 - 函数时接口
 * @author cws
 */
@FunctionalInterface
public interface PluginUtilTreeFun {
    /**
     * 树节点的自定义处理方法,返回需要递归的对象,用来给一些同样是树结构但类型不同或逻辑不同的场景使用
     * @param file 待处理的文件或文件夹
     * @param isFile 是否是文件
     * @param obj 自定义参数
     * @return 返回处理过后的obj或者新的obj
     */
    Object run(File file, Boolean isFile, Object obj);
}
