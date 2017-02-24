package com.orca.algorithm;

import com.orca.utils.TestSetup;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Unit tests for ORCA
 *
 * @author Kanth Kumar Dayanand
 */
public class OrcaTest extends TestSetup {

    private Orca orca = new Orca();

    @Test
    public void orca_4NodeGraphlet_100NodeGraph_Test() throws IOException {
        String path = getResourcePath("/test_graphs/example.in");

        try{
            orca.init(4, path);
        } catch (Exception e){
            Assert.fail(e.getMessage());
        }

        long[ ][ ] vector = orca.count();

        List<String> actualResult = Arrays.stream(vector)
                .map(longs -> Arrays.stream(longs).boxed().map(String::valueOf).collect(Collectors.joining(" ")))
                .collect(Collectors.toList());

        List<String> expectedResult = IOUtils.readLines(getResourceStream("/signature_vector/example_4node.out"),
                Charset.defaultCharset());

        Assert.assertTrue(expectedResult.equals(actualResult));
    }

    @Test
    public void orca_4NodeGraphlet_1kNodeGraph_Test() throws IOException {
        String path = getResourcePath("/test_graphs/p_05.in");

        try{
            orca.init(4, path);
        } catch (Exception e){
            Assert.fail(e.getMessage());
        }

        long[ ][ ] vector = orca.count();

        List<String> actualResult = Arrays.stream(vector)
                .map(longs -> Arrays.stream(longs).boxed().map(String::valueOf).collect(Collectors.joining(" ")))
                .collect(Collectors.toList());

        List<String> expectedResult = IOUtils.readLines(getResourceStream("/signature_vector/p_05_4node.out"),
                Charset.defaultCharset());

        Assert.assertTrue(expectedResult.equals(actualResult));
    }

    @Test
    public void orca_4NodeGraphlet_10kNodeGraph_Test() throws IOException {
        String path = getResourcePath("/test_graphs/graph_10k_60k.in");

        try{
            orca.init(4, path);
        } catch (Exception e){
            Assert.fail(e.getMessage());
        }

        long[ ][ ] vector = orca.count();

        List<String> actualResult = Arrays.stream(vector)
                .map(longs -> Arrays.stream(longs).boxed().map(String::valueOf).collect(Collectors.joining(" ")))
                .collect(Collectors.toList());

        List<String> expectedResult = IOUtils.readLines(getResourceStream("/signature_vector/graph_10k_60k_4node.out"),
                Charset.defaultCharset());

        Assert.assertTrue(expectedResult.equals(actualResult));
    }

    @Test
    public void orca_5NodeGraphlet_100NodeGraph_Test() throws IOException {
        String path = getResourcePath("/test_graphs/example.in");

        try{
            orca.init(5, path);
        } catch (Exception e){
            Assert.fail(e.getMessage());
        }

        long[ ][ ] vector = orca.count();

        List<String> actualResult = Arrays.stream(vector)
                .map(longs -> Arrays.stream(longs).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                .collect(Collectors.toList());

        List<String> expectedResult = IOUtils.readLines(getResourceStream("/signature_vector/example_5node.out"),
                Charset.defaultCharset());

        Assert.assertTrue(expectedResult.equals(actualResult));
    }

    @Test
    public void orca_5NodeGraphlet_1kNodeGraph_Test() throws IOException {
        String path = getResourcePath("/test_graphs/graph_1k_6k.in");

        try{
            orca.init(5, path);
        } catch (Exception e){
            Assert.fail(e.getMessage());
        }

        long[ ][ ] vector = orca.count();

        List<String> actualResult = Arrays.stream(vector)
                .map(longs -> Arrays.stream(longs).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                .collect(Collectors.toList());

        List<String> expectedResult = IOUtils.readLines(getResourceStream("/signature_vector/graph_1k_6k_5node.out"),
                Charset.defaultCharset());

        Assert.assertTrue(expectedResult.equals(actualResult));
    }

    @Test
    public void orca_5NodeGraphlet_10kNodeGraph_Test() throws IOException {
        String path = getResourcePath("/test_graphs/graph_10k_20k.in");

        try{
            orca.init(5, path);
        } catch (Exception e){
            Assert.fail(e.getMessage());
        }

        long[ ][ ] vector = orca.count();

        List<String> actualResult = Arrays.stream(vector)
                .map(longs -> Arrays.stream(longs).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                .collect(Collectors.toList());

        List<String> expectedResult = IOUtils.readLines(getResourceStream("/signature_vector/graph_10k_20k_5node.out"),
                Charset.defaultCharset());

        Assert.assertTrue(expectedResult.equals(actualResult));
    }

    private InputStream getResourceStream(String file){
        return OrcaTest.class.getResourceAsStream(file);
    }

    private String getResourcePath(String file){
        return OrcaTest.class.getResource(file).getPath();
    }
}
