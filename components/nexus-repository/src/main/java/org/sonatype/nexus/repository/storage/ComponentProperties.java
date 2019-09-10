package org.sonatype.nexus.repository.storage;

import java.util.LinkedHashMap;
import java.util.List;

public class ComponentProperties {
    private LinkedHashMap<String, List<String>> tag;
    private String parent;
    private String source;
    private List<String> category;
    private List<String> platform;

    public LinkedHashMap<String, List<String>> getTag() {
        return tag;
    }

    public void setTag(LinkedHashMap<String, List<String>> tag) {
        this.tag = tag;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public List<String> getPlatform() {
        return platform;
    }

    public void setPlatform(List<String> platform) {
        this.platform = platform;
    }
}
