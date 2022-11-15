package mio68.lab.tryit.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Index {
    private String name;
    private List<String> zones;

    public Index(String name) {
        this.name = name;
    }

    public Index(Instance instance) {
        this.name = instance.getIndexName();
        if (instance.getZone() != null) {
            zones = new ArrayList<>();
            zones.add(instance.getZone());
        }
    }

    public void add(Instance instance) {
        if (instance.getZone() != null) {
            if (zones == null) {
                zones = new ArrayList<>();
            }
            zones.add(instance.getZone());
        }
    }

    public Index merge(Index other) {
        if (!name.equals(other.name)) {
            throw new IllegalArgumentException();
        }

        Index merge = new Index(name);
        if (zones != null && zones.size() != 0) {
            merge.zones = new ArrayList<>(zones);
        }

        if (other.zones != null && other.zones.size() != 0) {
            if (merge.zones == null) {
                merge.zones = new ArrayList<>(other.zones);
            } else {
                merge.zones.addAll(other.zones);
            }
        }

        return merge;
    }
}
