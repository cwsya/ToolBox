package org.cwsya.toolBox.scan;

import java.io.File;
/**
 * @author cws
 */
@FunctionalInterface
public interface TreeFun {
    /**
     * @param file 待处理的文件或文件夹
     * @param isFile 是否是文件
     * @param obj 自定义参数
     * @return 返回处理过后的obj或者新的obj
     */
    Object run(File file, Boolean isFile, Object obj);
}
