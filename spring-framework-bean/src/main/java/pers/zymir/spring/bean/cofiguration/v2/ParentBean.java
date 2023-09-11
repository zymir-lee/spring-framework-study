package pers.zymir.spring.bean.cofiguration.v2;

public class ParentBean {
    private ChildBean childBean;

    public ParentBean(ChildBean childBean) {
        this.childBean = childBean;
    }

    // 也可以使用方法设置childBean
    public void setChildBean(ChildBean childBean) {
        this.childBean = childBean;
    }

    public void callChildBean() {
        childBean.sayHello();
    }

    public ChildBean getChildBean() {
        return childBean;
    }
}
