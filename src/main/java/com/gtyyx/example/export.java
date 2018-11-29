package com.gtyyx.example;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gtyyx.bean.BaseBean;
import com.gtyyx.bean.BaseBeanList;
import com.gtyyx.util.JsperreportUtil;
import com.gtyyx.util.ToPDFUtils;
import com.gtyyx.vo.TableVo;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**   
 * @author: crj
 * @date: 2018年11月6日 下午6:02:21 
 */
@RestController
public class export {
	@RequestMapping("/hello")
	public String hello() {
		return "hello world!";
	}
	
	@Value("${prop.upload-folder}")
	private String UPLOAD_FOLDER;
	@RequestMapping("/exportPDF")
	public void exportPDF(HttpServletRequest request,HttpServletResponse response) throws Exception {
		/*TableVo report = new TableVo();  
	    //List<TableVo> reports = new ArrayList<TableVo>();    
	    //装载数据  
	    report.setId("1");//测试为空时，
	    report.setName("测1");
	    report.setNumber(6);
	    report.setLable("第一类");
	    report.setShowFlag(true);
	    //reports.add(report);
*/	    
		//List<HashMap<String,TableVo>> reports = new ArrayList<HashMap<String,TableVo>>();
		/*List<TableVo> reports = new ArrayList<TableVo>();  
		TableVo report = new TableVo();
		report.setId("1");// 测试为空时，
		report.setName("测1");
		report.setNumber(6);
		report.setLable("第一类");
		report.setShowFlag(true);
		
		report = new TableVo(); 
	    report.setId("3");
	    report.setName("测3");
	    report.setNumber(3);
	    report.setLable("第一类");
	    report.setShowFlag(true);
	    reports.add(report);

	    report = new TableVo(); 
	    report.setId("4");
	    report.setName("测1");
	    report.setNumber(1);
	    report.setLable("第二类");
	    report.setShowFlag(true);
	    reports.add(report);

	    report = new TableVo();           
	    report.setId("5");
	    report.setName("测2");
	    report.setNumber(4);
	    report.setLable("第二类");
	    report.setShowFlag(true);
	    reports.add(report);

	    report = new TableVo();           
	    report.setId("6");
	    report.setName("测3");
	    report.setNumber(15);
	    report.setLable("第二类");
	    report.setShowFlag(true);
	    reports.add(report);*/
		
		TableVo report = new TableVo();
		report.setId("1");// 测试为空时，
		report.setName("测1");
		report.setNumber(6);
		report.setLable("第一类");
		report.setShowFlag(true);
		
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("id", report.getId());
	    map.put("name",report.getName());
	    map.put("lable", report.getLable());
	    map.put("number", report.getNumber());
	    map.put("showFlag", report.isShowFlag());
		
		
		/*DataBeanList DataBeanList = new DataBeanList();
	      ArrayList<BaseBean> dataList = DataBeanList.getDataBeanList();

	      JRBeanCollectionDataSource beanColDataSource =
	      new JRBeanCollectionDataSource(dataList);*/

	     // Map parameters = new HashMap();
	    String fileName = "table测试";
	   // Map<String, Object> parameters = new HashMap<String, Object>();
	   // JRDataSource jrDataSource = new JRBeanCollectionDataSource(reports);
	   // Boolean isin = ToPDFUtils.topdf(parameters,UPLOAD_FOLDER,fileName, true,beanColDataSource);
	    Boolean isin = ToPDFUtils.topdf(map,UPLOAD_FOLDER,fileName, true);
		System.out.println(isin);
		if(isin) {
			System.out.println("file is created");
			//页面显示pdf
			ToPDFUtils.getPDF(response, UPLOAD_FOLDER, fileName);
		}else {
			System.out.println("has no file");
		}
	    /*report = new TableVo(); 
	    report.setId("2");
	    report.setName("测2");
	    report.setNumber(2);
	    report.setLable("第一类");
	    report.setShowFlag(true);
	    reports.add(report);

	    report = new TableVo(); 
	    report.setId("3");
	    report.setName("测3");
	    report.setNumber(3);
	    report.setLable("第一类");
	    report.setShowFlag(true);
	    reports.add(report);

	    report = new TableVo(); 
	    report.setId("4");
	    report.setName("测1");
	    report.setNumber(1);
	    report.setLable("第二类");
	    report.setShowFlag(true);
	    reports.add(report);

	    report = new TableVo();           
	    report.setId("5");
	    report.setName("测2");
	    report.setNumber(4);
	    report.setLable("第二类");
	    report.setShowFlag(true);
	    reports.add(report);

	    report = new TableVo();           
	    report.setId("6");
	    report.setName("测3");
	    report.setNumber(15);
	    report.setLable("第二类");
	    report.setShowFlag(true);
	    reports.add(report);*/
	    
	    

	  /*  //JRBeanCollectionDataSource通过构造注入collection类型的参数，这里我们用的是list结构  
	    JRDataSource jrDataSource = new JRBeanCollectionDataSource(reports);
	   //构建参数map 
	    Map<String, Object> map=new HashMap<String, Object>();
	    map.put("query", "其他参数测试"); 
	    //子数据源测试
	   // map.put("chart1", reports);
	    //指定模板文件
	  ServletContext context = request.getSession().getServletContext();
	  File reportFile = null;
	  File f = new File(this.getClass().getResource("/").getPath()); 
	  System.out.println(f); 
	 // URL xmlpath = this.getClass().getClassLoader().getResource("table_test.jasper");
	  System.out.println(context.getContextPath());
	//获取跟目录
	  Resource resource = new ClassPathResource("templates/jasper/table_test.jrxml");
	  URL url = this.getClass().getClassLoader().getResource("templates/jasper/table_test.jrxml");
	 // reportFile = new File(url.getPath());
	  System.out.println(url.toString());
	  String jasper = JasperCompileManager.compileReportToFile(url.toString());
	  System.out.println(jasper);
	  //Jasper
	  System.out.println(reportFile);
	  //指定导出文件名称
	  String exportFileName = "table导出测试";
	  //调用工具类
	  JsperreportUtil.showPdf(exportFileName, reportFile.getPath(), request, response, map,jrDataSource);
	  //JasperHelper.showHtml(exportFilePath , reportFile.getPath(), request,response, map, jrDataSource);        
	  //JasperHelper.export("excel", exportFilePath, reportFile, request, response, map, jrDataSource);
*/
	}
	
}
