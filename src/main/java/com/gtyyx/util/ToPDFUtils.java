
package com.gtyyx.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 * 生成PDF工具类
 * 
 * @author: crj
 * @date: 2018年7月10日 下午3:43:23
 */
public class ToPDFUtils {

	public static void getPDF(HttpServletResponse res, String filePath, String fileName) throws Exception {

		if (filePath != null && !filePath.equals("")) {
			if (new File(filePath).exists()) {
				fileName = fileName + ".pdf";
				res.setHeader("content-type", "application/pdf");
				res.setContentType("application/pdf");
				// "attachment;filename="加了attachment不会直接显示而是直接下载了
				res.setHeader("Content-Disposition", "filename=" + fileName);
				byte[] bufferSize = new byte[1024];
				BufferedInputStream bis = null;
				OutputStream os = null;
				try {
					os = res.getOutputStream();
					bis = new BufferedInputStream(new FileInputStream(new File(filePath+"\\" + fileName)));
					int i = bis.read(bufferSize);
					while (i != -1) {
						os.write(bufferSize, 0, bufferSize.length);
						os.flush();
						i = bis.read(bufferSize);
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (bis != null) {
						try {
							bis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				System.out.println("show pdf success");
			}
		} else {
			System.out.println("no this pdf file");
		}
	}

	/**
	 * 
	 * @author: crj
	 * @param map
	 * @param outpath pdf存放绝对地址 
	 * @param outFileName
	 * @param isReCreate 是否重新编译jxml
	 * @return boolean
	 * @throws IOException
	 * @throws JRException
	 * @date:2018年7月10日 下午3:44:49
	 * @other jrxmlSourcePath:jxml存放绝对地址 jasperSourcePath:jasper存放地址
	 */
	public static Boolean topdf(Map<String, Object> map, String outpath, String outFileName, Boolean isReCreate)
			throws IOException, JRException {
		String jrxmlSourcePath = null;
		String jasperSourcePath = null;
		jrxmlSourcePath = outpath + "/table_test.jrxml";
		jasperSourcePath = outpath + "/table_test.jasper";
		if (isReCreate) {
			JasperCompileManager.compileReportToFile(jrxmlSourcePath, jasperSourcePath);// 用于编译JRXML报表模板
		}
		File f = new File(jasperSourcePath);
		byte[] bytes = JasperRunManager.runReportToPdf(f.getPath(), map);// 把JASPER转成PDF
		FileOutputStream outs = null;
		if (!outpath.equals("") && !outFileName.equals("")) {
			String pdffile = outpath +"\\"+ outFileName + ".pdf";
			outs = new FileOutputStream(pdffile, false);
			outs.write(bytes, 0, bytes.length);
			outs.flush();
			outs.close();
			System.out.println("Created...");
			System.out.println(pdffile);
			if (filein(pdffile)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public static boolean filein(String path) {
		if (new File(path).exists()) {
			return true;
		} else {
			return false;
		}
	}

}
