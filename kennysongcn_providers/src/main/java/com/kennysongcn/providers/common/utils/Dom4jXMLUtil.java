package com.kennysongcn.providers.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.XPath;

import com.kennysongcn.providers.admin.model.user.OldUser;

public class Dom4jXMLUtil {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map getObject(String xml) throws DocumentException {
		Map reslutMap = new HashMap();
		Document document = DocumentHelper.parseText(xml);
		Element root = document.getRootElement();
		System.out.println("根节点：" + root.getName());
		Iterator TelDetails = root.elementIterator("TelDetails");
		OldUser userInfo = new OldUser();
		while (TelDetails.hasNext()) {
			Element recordEless = (Element) TelDetails.next();
			Iterator TelDetail = recordEless.elementIterator("TelDetail");
			while (TelDetail.hasNext()) {
				Element item = (Element) TelDetail.next();
				// String lastname = item.elementTextTrim("lastname");
				// 拿到TelDetail下的字节点的值
				if ("1".equals(item.elementTextTrim("issus"))) {
					userInfo.setName(item.elementTextTrim("lastname"));
					userInfo.setEmail(item.elementTextTrim("email"));
					userInfo.setLoginName(item.elementTextTrim("loginid"));
					userInfo.setPositionName(item.elementTextTrim("job"));
					userInfo.setDepartment(item.elementTextTrim("dep"));
					userInfo.setSuperior(item.elementTextTrim("managerworkcode"));
					// userInfo.setSuperior(item.elementTextTrim("managername"));
					userInfo.setUserCode(item.elementTextTrim("workcode"));
					userInfo.setTelphone(item.elementTextTrim("mobile"));
					if ("试用".equals(item.elementTextTrim("status1"))) {
						userInfo.setUserStatus(0);
					}
					if ("临时".equals(item.elementTextTrim("status1"))) {
						userInfo.setUserStatus(1);
					}
					if ("实习".equals(item.elementTextTrim("status1"))) {
						userInfo.setUserStatus(2);
					}
					if ("正式".equals(item.elementTextTrim("status1"))) {
						userInfo.setUserStatus(3);
					}
					reslutMap.put("loginUser", userInfo);
				}
				reslutMap.put("resultCode", item.elementTextTrim("issus"));
			}
		}
		return reslutMap;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<OldUser> getObjectList(String xml) throws DocumentException {
		//命名空间转换
		List<OldUser> userInfos = new ArrayList<OldUser>();
		Map map = new HashMap();
		map.put("ns","http://www.apusic.com/esb/mf");
		Document document = DocumentHelper.parseText(xml);
		XPath x = document.createXPath("//ns:value");
		x.setNamespaceURIs(map);
		List nodes = x.selectNodes(document);
		Node n = (Node)nodes.get(0);
		String data = n.getText();
		//业务数据转换
		document = DocumentHelper.parseText(data);
		Element root = document.getRootElement();
		Iterator user = root.elementIterator("user");
		while (user.hasNext()) {
			OldUser userInfo = new OldUser();
			Element item = (Element) user.next();
			userInfo.setName(item.elementTextTrim("lastname"));
			userInfo.setEmail(item.elementTextTrim("email"));
			userInfo.setLoginName(item.elementTextTrim("loginid"));
			userInfo.setPositionName(item.elementTextTrim("job"));
			userInfo.setDepartment(item.elementTextTrim("dep"));
			userInfo.setSuperior(item.elementTextTrim("managerworkcode"));
			userInfo.setUserCode(item.elementTextTrim("workcode"));
			userInfo.setTelphone(item.elementTextTrim("mobile"));
			if ("试用".equals(item.elementTextTrim("status1"))) {
				userInfo.setUserStatus(0);
			}
			if ("临时".equals(item.elementTextTrim("status1"))) {
				userInfo.setUserStatus(1);
			}
			if ("实习".equals(item.elementTextTrim("status1"))) {
				userInfo.setUserStatus(2);
			}
			if ("正式".equals(item.elementTextTrim("status1"))) {
				userInfo.setUserStatus(3);
			}
			userInfos.add(userInfo);
		}
		return userInfos;

	}
}
