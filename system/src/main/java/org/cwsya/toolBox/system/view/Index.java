package org.cwsya.toolBox.system.view;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import org.cwsya.toolBox.scan.PluginUtil;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.io.File;
import java.util.Map;

/**
 * @author cws
 * 首页
 */
public class Index {
    /**
     * 初始化页面
     */
    public void view(){
        JFrame jFrame = new JFrame();
        jFrame.setBounds(200,200,500,500);
            jFrame.setLayout(new BorderLayout());
        JPanel jpTree = new JPanel();


        JTree nav = new JTree(PluginUtil.fileTreeToTreeNode(new File("F:\\备份\\u")));
        nav.setRootVisible(false);
        jpTree.add(nav);
        jFrame.add(jpTree,BorderLayout.WEST);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void hdaoij(Object object, DefaultMutableTreeNode treeNode){
        if (object instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) object;
            for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof String) {
                    treeNode.add(new DefaultMutableTreeNode(entry.getKey()));
                } else {
                    DefaultMutableTreeNode newChild = new DefaultMutableTreeNode(entry.getKey());
                    treeNode.add(newChild);
                    hdaoij(value,newChild);
                }
            }
        }
        if(object instanceof JSONArray) {
            JSONArray jsonArray = (JSONArray) object;
            for (Object o : jsonArray) {
                hdaoij(o,treeNode);
            }
        }
    }
}
