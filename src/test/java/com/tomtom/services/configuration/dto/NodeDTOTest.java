/**
 * Copyright (C) 2016, TomTom International BV (http://www.tomtom.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tomtom.services.configuration.dto;

import com.tomtom.speedtools.objects.Immutables;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NodeDTOTest {
    private static final Logger LOG = LoggerFactory.getLogger(NodeDTOTest.class);

    @Test
    public void testEquals() {
        LOG.info("testEquals");
        final NodeDTO x1 = new NodeDTO("x",
                null,
                new ParameterListDTO(Immutables.listOf(new ParameterDTO("k1", "v1"), new ParameterDTO("k2", "v2"))),
                "modified",
                Immutables.listOf("a", "b", "c"),
                "include",
                "includeArray");
        final NodeDTO x2 = new NodeDTO("x",
                null,
                new ParameterListDTO(Immutables.listOf(new ParameterDTO("k1", "v1"), new ParameterDTO("k2", "v2"))),
                "modified",
                Immutables.listOf("a", "b", "c"),
                "include",
                "includeArray");
        final NodeDTO x3 = new NodeDTO("x",
                null,
                new ParameterListDTO(Immutables.listOf(new ParameterDTO("k1", "v1"), new ParameterDTO("k2", "vX"))),
                "modified",
                Immutables.listOf("a", "b", "c"),
                "include",
                "includeArray");
        Assert.assertTrue(x1.equals(x2));
        Assert.assertTrue(x2.equals(x1));
        Assert.assertFalse(x1.equals(x3));
        Assert.assertFalse(x3.equals(x1));

        Assert.assertTrue(x1.hashCode() == x2.hashCode());
        Assert.assertTrue(x2.hashCode() == x1.hashCode());
        Assert.assertFalse(x1.hashCode() == x3.hashCode());
        Assert.assertFalse(x3.hashCode() == x1.hashCode());
    }
}
