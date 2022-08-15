package org.cwsya.toolBox.scan;

import cn.hutool.json.JSONObject;

import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;

/**
 * @author cws
 */
public class PluginUtil {


    /**
     * 将一个文件夹转换成JSONObject
     * @param path 待转换的文件夹
     * @param fun 自定义需要处理的文件
     *            一般是过滤一些指定的后缀名或前缀
     * @return JSONObject
     */
    public static JSONObject fileTreeToJson(File path,PluginUtilFileFun fun){
        JSONObject jsonRoot = new JSONObject();
        fileTreeUtil(path, jsonRoot,((file, isFile, obj) -> {
            if (isFile) {
                if (fun.run(file)) {
                    ((JSONObject)obj).set(file.getName(),file.getPath());
                }
                return null;
            }else {
                JSONObject jsonObject = new JSONObject();
                ((JSONObject)obj).set(file.getName(), jsonObject);
                return jsonObject;
            }
        }));
        return jsonRoot;
    }

    /**
     * 将一个文件夹转换成JSONObject
     * @param path 待转换的文件夹
     * @return JSONObject
     */
    public static JSONObject fileTreeToJson(File path){
        return fileTreeToJson(path,file-> true);
    }

    /**
     * 将一个文件夹转换成DefaultMutableTreeNode类型的树结构
     * 用来构建swing的JTree需要的数据
     * @param path 需要转化的文件夹
     * @return DefaultMutableTreeNode类型的树结构
     */
    public static DefaultMutableTreeNode fileTreeToTreeNode(File path,PluginUtilFileFun fun){
        DefaultMutableTreeNode root = new DefaultMutableTreeNode();
        fileTreeUtil(path, root, ((file, isFile, obj) -> {
            if (isFile) {
                if (fun.run(file)){
                    ((DefaultMutableTreeNode)obj).add(new DefaultMutableTreeNode(file.getName()));
                }
                return null;
            }else {
                DefaultMutableTreeNode newChild = new DefaultMutableTreeNode(file.getName());
                ((DefaultMutableTreeNode)obj).add(newChild);
                return newChild;
            }
        }));
        return root;
    }
    /**
     * 将一个文件夹转换成DefaultMutableTreeNode类型的树结构
     * 用来构建swing的JTree需要的数据
     * @param path 需要转化的文件夹
     * @return DefaultMutableTreeNode类型的树结构
     */
    public static DefaultMutableTreeNode fileTreeToTreeNode(File path){
        return fileTreeToTreeNode(path, file -> true);
    }

    private static void fileTreeUtil(File path, Object object, PluginUtilTreeFun fun) {
        File[] fileArr=path.listFiles();
        if(fileArr!=null) {
            for(File file:fileArr) {
                if(file.isDirectory()) {
                    fileTreeUtil(file,fun.run(file,false, object),fun);
                }else {
                    fun.run(file,true, object);
                    System.out.println(file.getName());
                }
            }
        }
    }


}

