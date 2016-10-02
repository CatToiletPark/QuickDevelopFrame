package com.easygo.framework.view.activity.easydrawer;

/**
 * description :
 *
 * @author by lyh on 2016/10/1 14:13.
 */

public class EasyMenu {
    //菜单标题
    private String easyMenuTitle;
    //菜单icon
    private String easyMenuIconUrl;
    //跳转的class
    private Class clas;

    public EasyMenu(String easyMenuTitle,
                    String easyMenuIconUrl,
                    Class clas) {
        this.easyMenuTitle = easyMenuTitle;
        this.easyMenuIconUrl = easyMenuIconUrl;
        this.clas = clas;
    }

    public String getEasyMenuTitle() {
        return easyMenuTitle;
    }

    public void setEasyMenuTitle(String easyMenuTitle) {
        this.easyMenuTitle = easyMenuTitle;
    }

    public String getEasyMenuIconUrl() {
        return easyMenuIconUrl;
    }

    public void setEasyMenuIconUrl(String easyMenuIconUrl) {
        this.easyMenuIconUrl = easyMenuIconUrl;
    }

    public Class getClas() {
        return clas;
    }

    public void setClas(Class clas) {
        this.clas = clas;
    }
}
