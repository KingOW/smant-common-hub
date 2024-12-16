package com.smant.common.core.beans;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * 树形bean
 */
@NoArgsConstructor
@Data
public class TreeNode extends BaseBean {

    public TreeNode(String id) {
        this.id = id;
    }

    public TreeNode(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public TreeNode(String id, String name, String pid) {
        this.id = id;
        this.name = name;
        this.pid = pid;
    }

    public TreeNode(String id, String name, String pid, String pname) {
        this.id = id;
        this.name = name;
        this.pid = pid;
        this.pname = pname;
    }

    /**
     * 树节点id
     */
    private String id;
    private String code;
    private String name;

    /**
     * 上级节点id
     */
    private String pid;
    private String pcode;
    private String pname;

    /**
     * 子节点
     */
    private List<TreeNode> children = Lists.newArrayList();

    private String remark;

    /**
     * 属性
     */
    private Map<String, Object> props = Maps.newHashMap();

    public TreeNode IdAndName(String id, String name) {
        this.setId(id);
        this.setName(name);
        return this;
    }

    public TreeNode PIdAndPName(String pid, String pname) {
        this.setPid(pid);
        this.setPname(pname);
        return this;
    }

    public TreeNode Code(String code) {
        this.setCode(code);
        return this;
    }

    public TreeNode PCode(String pcode) {
        this.setPcode(pcode);
        return this;
    }

    public TreeNode Children(List<TreeNode> children) {
        if (children != null && children.size() > 0) {
            this.children = children;
        }
        return this;
    }

    public TreeNode AddChild(TreeNode child) {
        if (this.children == null || this.children.size() == 0) {
            this.children = Lists.newArrayList();
        }
        this.children.add(child);
        return this;
    }

    public TreeNode Props(Map<String, Object> props) {
        if (this.props == null || this.props.size() == 0) {
            this.props = Maps.newHashMap();
        }
        if (props != null && props.size() > 0) {
            this.props = props;
        }
        return this;
    }

    public TreeNode AddProp(Map<String, Object> addProps) {
        if (this.props == null || this.props.size() == 0) {
            this.props = Maps.newHashMap();
        }
        if (addProps != null && addProps.size() > 0) {
            this.props.putAll(addProps);
        }
        return this;
    }

    public TreeNode AddProp(String key, Object value) {
        if (this.props == null || this.props.size() == 0) {
            this.props = Maps.newHashMap();
        }
        this.props.put(key, value);
        return this;
    }

    public TreeNode Remark(String remark) {
        this.setRemark(remark);
        return this;
    }
}
