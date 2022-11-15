package mio68.lab.tryit.model;

import lombok.Data;

@Data
public class Instance {
    private String indexName;
    private String zone;

    public Instance(String indexName, String zone) {
        this.indexName = indexName;
        this.zone = zone;
    }
}
