package org.sonatype.nexus.repository.storage;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ComponentProperties {
    private LinkedHashMap<String, List<String>> tag;
    private String parent;
    private String source;
    private List<String> category;
    private List<String> platform;

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void fillInComponent(final String json, final Component component) throws IOException {
        ComponentProperties componentProperties = objectMapper.readValue(json, ComponentProperties.class);
        componentProperties.fillInComponent(component);
    }

    public static void fillInComponent(final Map<String, Object> map, final Component component) {
        if (map==null) {
            return;
        }
        LinkedHashMap<String, List<String>> tag = (LinkedHashMap<String, List<String>>) map.get("tag");
        String parent = (String) map.get("parent");
        String source = (String) map.get("source");
        List<String> category = (List<String>) map.get("category");
        List<String> platform = (List<String>) map.get("platform");

        component.tag(tag);
        component.keyword(keyword(tag));
        component.parent(parent);
        component.source(source);
        component.category(category);
        component.platform(platform);
    }

    public void fillInComponent(final Component component) {
        component.tag(tag);
        component.keyword(keyword(tag));
        component.parent(parent);
        component.source(source);
        component.category(category);
        component.platform(platform);
    }

    public static String keyword(Map<String, List<String>> tag) {
        StringBuffer keyword = new StringBuffer();
        if (tag != null) {
            for (Map.Entry<String, List<String>> entry : tag.entrySet()) {
                List<String> list = entry.getValue();
                for (String value: list) {
                    if (keyword.length() > 0) {
                        keyword.append(" ");
                    }
                    keyword.append(value);
                }
            }
        }
        return keyword.toString();
    }

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
