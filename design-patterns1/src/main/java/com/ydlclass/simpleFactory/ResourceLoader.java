package com.ydlclass.simpleFactory;

/**
 * @author
 * @createTime 2023-05-09
 */
public class ResourceLoader {

    /**
     *
     * @param url file://   http://  classpath://  ftp://
     * @return 资源类
     */
    public Resource load(String url){

        // 1、根据url获取前缀
        String prefix = getPrefix(url);

        // 2、根据前缀处理不同的资源
        return ResourceFactory.create(prefix,url);
    }

    private String getPrefix(String url) {
        if(url == null || "".equals(url) || !url.contains(":")){
            throw new ResourceLoadException("此资源url不合法.");
        }
        String[] split = url.split(":");
        return split[0];
    }
}
