/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Harm Pauw, Prowareness
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package nl.prowareness.jenkins.testgrid.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by harm on 7-2-15.
 */
public class DockerImageNameValidatorTest {
    @Test
    public void validate_withValidNames_shouldReturnTrue() {
        List<String> validNames = new ArrayList<String>();
        validNames.add("image");
        validNames.add("user/image");
        validNames.add("image:tag");
        validNames.add("user/image:tag");
        validNames.add("Image-With-Dash-And-12");

        for (String name : validNames) {
            assertTrue(DockerImageNameValidator.validate(name));
        }
    }

    @Test
    public void validate_withInvalidNames_shouldReturnFalse() {
        List<String> validNames = new ArrayList<String>();
        validNames.add("");
        validNames.add("?");
        validNames.add("\\");
        validNames.add("image with spaces");

        for (String name : validNames) {
            assertFalse(DockerImageNameValidator.validate(name));
        }
    }
}
