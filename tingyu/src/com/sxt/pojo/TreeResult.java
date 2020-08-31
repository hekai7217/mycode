package com.sxt.pojo;
import java.util.List;
import java.util.Map;
/**
 * @author 黄药师
 * @date 2020-08-24 14:31
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   菜单树对象
 */
public class TreeResult {

    private String id;  // 菜单树 的id
    private String text;  // 菜单的显示文本

    private String state;   // 状态  父级菜单 close

    // 异步树的 自定义属性
    private Map<String,Object> attributes;

    // 节点中添加子节点
    private List<TreeResult> children;

    public List<TreeResult> getChildren() {
        return children;
    }

    public void setChildren(List<TreeResult> children) {
        this.children = children;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
