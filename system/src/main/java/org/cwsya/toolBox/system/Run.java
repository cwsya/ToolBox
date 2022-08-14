package org.cwsya.toolBox.system;

import com.formdev.flatlaf.FlatDarkLaf;
import org.cwsya.toolBox.system.view.Index;

/**
 * @author cws
 * 项目启动文件
 */
public class Run {
    public static void main(String[] args) {
        FlatDarkLaf.setup();
        new Index().view();
    }
}