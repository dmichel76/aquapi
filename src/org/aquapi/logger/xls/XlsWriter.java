package org.aquapi.logger.xls;

import java.io.File;
import java.io.IOException;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.Number;
import org.apache.commons.io.FileUtils;

/**
 * XLS file writer/editor
 */
public class XlsWriter
{
    private static String TMP_FILE_NAME = "temp.xls";
    private static String DEFAULT_SHEET_NAME = "default";

    private File file;

    public XlsWriter(File file)
    {
        this.file = file;
    }

    public WritableWorkbook create() throws IOException, WriteException
    {
        WorkbookSettings wbSettings = new WorkbookSettings();
        WritableWorkbook workbook = Workbook.createWorkbook(this.file, wbSettings);

        workbook.createSheet(DEFAULT_SHEET_NAME, 0);
        workbook.write();
        workbook.close();

        return workbook;
    }

    public void editValue(String sheetName, int row, int column, double val) throws IOException, WriteException, BiffException
    {
        Workbook workbook = Workbook.getWorkbook(this.file);
        File tmp = new File(this.file.getParent(), TMP_FILE_NAME);
        WritableWorkbook copy = Workbook.createWorkbook(tmp, workbook);

        WritableSheet sh = copy.getSheet(sheetName);
        Number n = new Number(column, row, val);
        sh.addCell(n);

        copy.write();
        copy.close();
        workbook.close();

        FileUtils.copyFile(tmp, this.file);
        FileUtils.deleteQuietly(tmp);
    }

}
