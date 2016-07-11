package edu.jhu.icm.csvuploader.util;

import org.apache.commons.configuration2.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Maps headers to metrics.
 * Created by rliu14 on 7/11/16.
 */
@Component
public class HeaderMapping {

    private Map<String, String> metricMap;

    @Autowired
    public HeaderMapping(Configuration configurationFile) {
        metricMap = new HashMap<>();

        if (configurationFile.containsKey("mappings"));
        String[] mappings = configurationFile.getString("mappings").split(",");
        for (String s : mappings) {
            String[] pairs = s.split("=");
            metricMap.put(pairs[0], pairs[1]);
        }

    }

    public HeaderMapping(Map<String, String> metricMap) {
        this.metricMap = metricMap;
    }

    /**
     * Maps a CSV header to a metric name.
     * @param header Header to map to metric name.
     * @return Metric name defined by map, if it exists. Otherwise, the header name.
     */
    public String map(String header) {
        if (metricMap.containsKey(header)) return metricMap.get(header);
        return header;
    }

}
