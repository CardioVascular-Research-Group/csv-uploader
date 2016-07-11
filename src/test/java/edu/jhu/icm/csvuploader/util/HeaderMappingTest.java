package edu.jhu.icm.csvuploader.util;

import edu.jhu.icm.csvuploader.TestConfigurations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for header mapping.
 * Created by rliu14 on 7/11/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {TestConfigurations.class, HeaderMapping.class})
public class HeaderMappingTest {

    @Autowired
    private HeaderMapping mapping;

    @Test
    public void testMapping() {
        assertEquals("b", mapping.map("a"));
        assertEquals("c", mapping.map("b"));
        assertEquals("d", mapping.map("c"));
    }

}
