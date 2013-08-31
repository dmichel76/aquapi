package org.aquapi;

import java.io.File;
import org.aquapi.logger.xls.XlsWriter;

/**
 *
 */
public class AquaPi
{
    public static void main(String [] args)
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
