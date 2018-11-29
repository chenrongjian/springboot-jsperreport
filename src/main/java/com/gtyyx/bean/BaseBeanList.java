package com.gtyyx.bean;

import java.util.ArrayList;

/**   
 * @author: crj
 * @date: 2018年11月8日 下午2:56:35 
 */
public class BaseBeanList {
	 public ArrayList<BaseBean> getDataBeanList() {
	      ArrayList<BaseBean> dataBeanList = new ArrayList<BaseBean>();

	      dataBeanList.add(produce("1", "测试1","第1类",1,true));
	      dataBeanList.add(produce("2", "测试2","第2类",2,true));
	      dataBeanList.add(produce("3", "测试3","第3类",3,true));
	      dataBeanList.add(produce("4", "测试4","第4类",4,true));

	      return dataBeanList;
	   }

	   /**
	    * This method returns a DataBean object,
	    * with name and country set in it.
	    */
	   private BaseBean produce(String id,String name, String lable,long number,boolean showFlag) {
		   BaseBean dataBean = new BaseBean();
		  dataBean.setId(id);
	      dataBean.setName(name);
	      dataBean.setLable(lable);
	      dataBean.setNumber(number);
	      dataBean.setShowFlag(showFlag);
	      return dataBean;
	   }

}
