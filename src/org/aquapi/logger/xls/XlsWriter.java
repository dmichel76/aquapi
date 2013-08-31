package org.aquapi.logger.xls;

import java.io.File;
import java.io.IOException;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * XLS file writer
 */
public class XlsWriter
{

    public void createNew(File file) throws IOException, WriteException
    {
        WorkbookSettings wbSettings = new WorkbookSettings();
        WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
        workbook.write();
        workbook.close();

    }

}
