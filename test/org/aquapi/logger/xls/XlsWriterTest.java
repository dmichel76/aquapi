package org.aquapi.logger.xls;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.fail;

/**
 * Unit tests for {@link XlsWriter}
 */
public class XlsWriterTest
{

    private static File newXlsFile;

    @BeforeClass
    public static void setUp()
    {
        newXlsFile = new File("new.xls");
    }

    @AfterClass
    public static void tearDown()
    {
        FileUtils.deleteQuietly(newXlsFile);
    }

    @Test
    public void should_be_able_to_create_a_new_xls_file() throws IOException, WriteException
    {
        XlsWriter writer = new XlsWriter(newXlsFile);
        writer.create();

        assert(newXlsFile.exists());
    }

    @Test
    public void should_be_able_to_write_to_existing_file() throws URISyntaxException, IOException, WriteException, BiffException
    {
        File existingXlsFile = new File(this.getClass().getResource("existing.xls").toURI());
        if(!existingXlsFile.exists()) fail("test data not found");

        XlsWriter writer = new XlsWriter(existingXlsFile);
        writer.editValue("Sheet1", 2, 2, 3.5);

    }

}
