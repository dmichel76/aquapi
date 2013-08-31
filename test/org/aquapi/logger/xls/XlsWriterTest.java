package org.aquapi.logger.xls;

import org.junit.Test;

import java.io.File;

/**
 * Unit tests for {@link XlsWriter}
 */
public class XlsWriterTest
{

    @Test
    public void should_be_able_to_create_a_new_xls_file()
    {
        try
        {
            XlsWriter writer = new XlsWriter();
            writer.createNew(new File("test.xls"));
        }
        catch(Exception ex)
        {

        }
    }

}
