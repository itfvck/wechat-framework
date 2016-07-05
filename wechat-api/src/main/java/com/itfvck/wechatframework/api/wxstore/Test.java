package com.itfvck.wechatframework.api.wxstore;

import java.util.ArrayList;
import java.util.List;

import com.itfvck.wechatframework.api.wxstore.deliveryMoney.WxStoreDeliveryMoneyAPI;
import com.itfvck.wechatframework.api.wxstore.deliveryMoney.model.DeliveryMoney;
import com.itfvck.wechatframework.api.wxstore.deliveryMoney.model.DeliveryMoneyCustomInfo;
import com.itfvck.wechatframework.api.wxstore.deliveryMoney.model.DeliveryMoneyNormalInfo;
import com.itfvck.wechatframework.api.wxstore.deliveryMoney.model.DeliveryMoneyRtnInfo;
import com.itfvck.wechatframework.api.wxstore.deliveryMoney.model.DeliveryMoneyTopFreeInfo;
import com.itfvck.wechatframework.api.wxstore.group.WxStoreGroupAPI;
import com.itfvck.wechatframework.api.wxstore.group.model.Group;
import com.itfvck.wechatframework.api.wxstore.group.model.GroupDetailInfo;
import com.itfvck.wechatframework.api.wxstore.group.model.GroupProduct;
import com.itfvck.wechatframework.api.wxstore.group.model.GroupProductInfo;
import com.itfvck.wechatframework.api.wxstore.group.model.GroupRtnInfo;
import com.itfvck.wechatframework.api.wxstore.order.WxStoreOrderAPI;
import com.itfvck.wechatframework.api.wxstore.order.model.OrderPara;
import com.itfvck.wechatframework.api.wxstore.product.WxStoreProductAPI;
import com.itfvck.wechatframework.api.wxstore.product.model.AttrExt;
import com.itfvck.wechatframework.api.wxstore.product.model.AttrInfo;
import com.itfvck.wechatframework.api.wxstore.product.model.AttrInfoDetail;
import com.itfvck.wechatframework.api.wxstore.product.model.CommodityRtnInfo;
import com.itfvck.wechatframework.api.wxstore.product.model.DeliveryInfo;
import com.itfvck.wechatframework.api.wxstore.product.model.DeliveryInfoExpress;
import com.itfvck.wechatframework.api.wxstore.product.model.Product;
import com.itfvck.wechatframework.api.wxstore.shelf.WxStoreShelfAPI;
import com.itfvck.wechatframework.api.wxstore.shelf.model.EidCInfo;
import com.itfvck.wechatframework.api.wxstore.shelf.model.EidEInfo;
import com.itfvck.wechatframework.api.wxstore.shelf.model.GroupCInfo;
import com.itfvck.wechatframework.api.wxstore.shelf.model.GroupEInfo;
import com.itfvck.wechatframework.api.wxstore.shelf.model.GroupEInfos;
import com.itfvck.wechatframework.api.wxstore.shelf.model.Shelf;
import com.itfvck.wechatframework.api.wxstore.stock.WxStoreStockAPI;
import com.itfvck.wechatframework.api.wxstore.stock.model.StockInfo;


public class Test {

	private static String appid = "?";
	private static String appscret = "?";
	
	String filePath = "C:/Users/wangbingwang/Desktop/wxpic/";
	String fileName = "gongju1.jpg";
	
    String newAccessToken = "";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Test t = new Test();
		// 货架测试
		//t.hjDelShelf();
		t.getAllShelf();
		//t.hjUpdateShelf();
		//t.getByShelfId();
		//t.hjAddTest1();
		//t.hjAddTest2();
		// 订单测试
		//t.ddGetidTest();
		//t.ddgetBystatusTest();
		// 库存测试
		//t.fzSubStockTest();
		//t.fzAddStockTest();
		// 分组测试
		//t.fzAddTest();
		//t.fzgetByidTest();
		//t.fzUpdagePropertisTest();
		//t.fzUpdageProductTest();
		//t.fzDelTest();
		//t.fzgetAllTest();
		// 商品测试
		//t.spAddTest();
		// 邮费模板
		//t.yfAddTest();
		//t.yfUpdateTest();
		//t.getMbTest();
		//t.getAllTest();
	}
	
	public void hjDelShelf() {
		WxStoreShelfAPI wss = new WxStoreShelfAPI();
		wss.doDelShelfManager(newAccessToken,2);
	}
	
	// 修改货架信息
	public void hjUpdateShelf() {
		WxStoreShelfAPI wss = new WxStoreShelfAPI();
		WxStoreProductAPI wcs = new WxStoreProductAPI();
		Shelf shelf = new Shelf();
		EidEInfo e = new EidEInfo();
		e.setEid(5);
		e.setImg_background(wcs.uploadImg(newAccessToken,filePath, fileName));
		GroupEInfos group_infos = new GroupEInfos();
		List<GroupEInfo> groups = new ArrayList<GroupEInfo>();
		GroupEInfo a = new GroupEInfo();
		a.setGroup_id(43);
		groups.add(a);
		GroupEInfo b = new GroupEInfo();
		a.setGroup_id(44);
		groups.add(b);
		group_infos.setGroups(groups);
		e.setGroup_infos(group_infos);
		shelf.setShelf_data(e);
		shelf.setShelf_banner(wcs.uploadImg(newAccessToken,filePath, fileName));
		shelf.setShelf_name("测试货架");
		shelf.setShelf_id(2);
		wss.doUpdateExpress(newAccessToken,shelf);
	}
	
	// 获取所有货架信息
	public void getAllShelf() {
		WxStoreShelfAPI wss = new WxStoreShelfAPI();
		wss.getAllShelf(newAccessToken);
	}
	
	
	// 根据货架ID获取货架信息
	public void getByShelfId() {
		WxStoreShelfAPI wss = new WxStoreShelfAPI();
		wss.getByShelfId(newAccessToken,4);
	}
	
	// 增加货架
	public void hjAddTest1() {
		WxStoreShelfAPI wss = new WxStoreShelfAPI();
		WxStoreProductAPI wcs = new WxStoreProductAPI();
		Shelf shelf = new Shelf();
		EidEInfo e = new EidEInfo();
		e.setEid(5);
		e.setImg_background(wcs.uploadImg(newAccessToken,filePath, fileName));
		GroupEInfos group_infos = new GroupEInfos();
		List<GroupEInfo> groups = new ArrayList<GroupEInfo>();
		GroupEInfo a = new GroupEInfo();
		a.setGroup_id(43);
		groups.add(a);
		GroupEInfo b = new GroupEInfo();
		a.setGroup_id(44);
		groups.add(b);
		group_infos.setGroups(groups);
		e.setGroup_infos(group_infos);
		shelf.setShelf_data(e);
		shelf.setShelf_banner(wcs.uploadImg(newAccessToken,filePath, fileName));
		shelf.setShelf_name("测试货架");
		wss.doAddExpress(newAccessToken,shelf);
	}
	
	// 增加货架
	public void hjAddTest2() {
		WxStoreShelfAPI wss = new WxStoreShelfAPI();
		WxStoreProductAPI wcs = new WxStoreProductAPI();
		Shelf shelf = new Shelf();
		EidCInfo e = new EidCInfo();
		e.setEid(3);
		GroupCInfo group_info = new GroupCInfo();
		group_info.setGroup_id(205038469);
		group_info.setImg(wcs.uploadImg(newAccessToken,filePath, fileName));
		e.setGroup_info(group_info);
		shelf.setShelf_data(e);
		shelf.setShelf_banner(wcs.uploadImg(newAccessToken,filePath, fileName));
		shelf.setShelf_name("测试货架");
		wss.doAddExpress(newAccessToken,shelf);
	}
	
	// 根据订单ID获取订单详情
	public void ddGetidTest() {
		WxStoreOrderAPI woms = new WxStoreOrderAPI();
		woms.getByOrderId(newAccessToken,"7197417460812533543");
	}
	
	public void ddgetBystatusTest() {
		WxStoreOrderAPI woms = new WxStoreOrderAPI();
		OrderPara orderPara = new OrderPara();
		orderPara.setStatus(2);
		orderPara.setBegintime(1397130460);
		orderPara.setEndtime(1397130470);
		woms.getByFilter(newAccessToken,orderPara);
	}
	
	// 增加库存
	public void fzAddStockTest() {
		WxStoreStockAPI JwStockAPI = new WxStoreStockAPI();
		StockInfo stockInfo = new StockInfo();
		stockInfo.setProduct_id("pqII7uOmhvayKYQyZdXEa_7qfAQM");
		stockInfo.setSku_info("");
		stockInfo.setQuantity(10);
		JwStockAPI.doAddStock(newAccessToken,stockInfo);
	}
	
	// 减少库存
	public void fzSubStockTest() {
		WxStoreStockAPI JwStockAPI = new WxStoreStockAPI();
		StockInfo stockInfo = new StockInfo();
		stockInfo.setProduct_id("pqII7uOmhvayKYQyZdXEa_7qfAQM");
		stockInfo.setSku_info("");
		stockInfo.setQuantity(5);
		JwStockAPI.doSubStock(newAccessToken,stockInfo);
	}
		
	
	// 删除分组信息
	public void fzDelTest() {
		WxStoreGroupAPI wgms = new WxStoreGroupAPI();
		GroupRtnInfo gdis = wgms.doDelGroupManager(newAccessToken,205038402);
	}
	
	// 获取分组信息
	public void fzgetAllTest() {
		WxStoreGroupAPI wgms = new WxStoreGroupAPI();
		List<GroupDetailInfo> gdis = wgms.getAllGroup(newAccessToken);
	}
	
	// 修改分组商品
	public void fzUpdageProductTest() {
		WxStoreGroupAPI wgms = new WxStoreGroupAPI();
		GroupProductInfo g = new GroupProductInfo();
		g.setGroup_id(205038402);
		List<GroupProduct> product = new ArrayList<GroupProduct>();
		GroupProduct gp = new GroupProduct();
		gp.setProduct_id("pqII7uOmhvayKYQyZdXEa_7qfAQM");
		gp.setMod_action(0);
		product.add(gp);
		g.setProduct(product);
		GroupRtnInfo gdi = wgms.doUpdateGroupManagerProduct(newAccessToken,g);
	}
	
	// 修改分组属性
	public void fzUpdagePropertisTest() {
		WxStoreGroupAPI wgms = new WxStoreGroupAPI();
		Group g = new Group();
		g.setGroup_id(205038402);
		g.setGroup_name("测试分组22");
		GroupRtnInfo gdi = wgms.doUpdateGroupManagerProperties(newAccessToken,g);
	}
	
	// 根据分组ID获取分组信息
	public void fzgetByidTest() {
		WxStoreGroupAPI wgms = new WxStoreGroupAPI();
		GroupDetailInfo gdi = wgms.getByGroupId(newAccessToken,205038402);
	}
	
	// 增加分组
	public void fzAddTest() {
		WxStoreGroupAPI wgms = new WxStoreGroupAPI();
		Group group = new Group();
		GroupDetailInfo group_detail = new GroupDetailInfo();
		group_detail.setGroup_name("测试分组");
		List<String> product_list = new ArrayList<String>();
		product_list.add("pqII7uOqbiJvESwQls_smyB2Z60U");
		product_list.add("pqII7uOmhvayKYQyZdXEa_7qfAQM");
		group_detail.setProduct_list(product_list);
		group.setGroup_detail(group_detail);
		GroupRtnInfo r = wgms.doAddGroupManager(newAccessToken,group);
	}
	
	// 添加商品
    public void spAddTest() {
    	WxStoreProductAPI wcs = new WxStoreProductAPI();
    	
    	Product product = new Product();
    	// 基础信息
    	AttrInfo attrInfo = new AttrInfo();
    	attrInfo.setName("西安商品测试");
    	attrInfo.setMain_img(wcs.uploadImg(newAccessToken,filePath, fileName));
    	List<String> imgs = new ArrayList<String>();
    	imgs.add(wcs.uploadImg(newAccessToken,filePath, fileName));
    	attrInfo.setImg(imgs);
    	// 商品详情列表
    	List<AttrInfoDetail> details = new ArrayList<AttrInfoDetail>();
    	AttrInfoDetail detail1 = new AttrInfoDetail();
    	detail1.setText("苹果");
    	detail1.setImg(wcs.uploadImg(newAccessToken,filePath, fileName));
    	details.add(detail1);
    	AttrInfoDetail detail2 = new AttrInfoDetail();
    	detail2.setText("橘子");
    	detail2.setImg(wcs.uploadImg(newAccessToken,filePath, fileName));
    	details.add(detail2);
    	attrInfo.setDetail(details);
    	attrInfo.setBuy_limit(56);
    	List<String> categorylist = new ArrayList<String>();
    	categorylist.add("537074298");
    	attrInfo.setCategory_id(categorylist);
    	product.setProduct_base(attrInfo);
    	// 商品其他属性
    	AttrExt attrExt = new AttrExt();
    	product.setAttrext(attrExt);
    	// 运费信息
    	DeliveryInfo deliveryInfo = new DeliveryInfo();
    	deliveryInfo.setDelivery_type(0);
    	deliveryInfo.setTemplate_id(0);
    	List<DeliveryInfoExpress> expressList = new ArrayList<DeliveryInfoExpress>();
    	DeliveryInfoExpress express1 = new DeliveryInfoExpress();
    	express1.setId(10000027);
    	express1.setPrice(800);
    	expressList.add(express1);
    	DeliveryInfoExpress express2 = new DeliveryInfoExpress();
    	express2.setId(10000028);
    	express2.setPrice(900);
    	expressList.add(express2);
    	deliveryInfo.setExpress(expressList);
    	product.setDelivery_info(deliveryInfo);
    	
    	CommodityRtnInfo object = wcs.doAddCommodity(newAccessToken,product);
    }
	
	// 获取指定ID的邮费模板
	public void getAllTest() {
		WxStoreDeliveryMoneyAPI wps = new WxStoreDeliveryMoneyAPI();
		List<DeliveryMoney> p = wps.getAllExpress(newAccessToken);
		//System.out.println(p.getTemplate_id());
	}
	
	// 获取指定ID的邮费模板
	public void getMbTest() {
		WxStoreDeliveryMoneyAPI wps = new WxStoreDeliveryMoneyAPI();
		DeliveryMoney p = wps.getByIdExpress(newAccessToken,205036446);
		System.out.println(p.getTemplate_id());
	}

	// 邮费模板管理接口修改
	public void yfUpdateTest() {
		WxStoreDeliveryMoneyAPI wps = new WxStoreDeliveryMoneyAPI();
		DeliveryMoney p = new DeliveryMoney();
		p.setTemplate_id(205035813);
		p.setAssumer(0);
		p.setName("Test2222");
		p.setValuation(0);
		List<DeliveryMoneyTopFreeInfo> topFee = new ArrayList<DeliveryMoneyTopFreeInfo>();
		DeliveryMoneyTopFreeInfo ptf = new DeliveryMoneyTopFreeInfo();
		ptf.setType(10000029);
		
		DeliveryMoneyNormalInfo pni = new DeliveryMoneyNormalInfo();
		pni.setAddFees(3);
		pni.setAddStandards(1);
		pni.setStartFees(8);
		pni.setStartStandards(2);
		ptf.setNormal(pni);
		
		List<DeliveryMoneyCustomInfo> pci = new ArrayList<DeliveryMoneyCustomInfo>();
		DeliveryMoneyCustomInfo pc = new DeliveryMoneyCustomInfo();
		pc.setAddFees(11);
		pc.setAddStandards(2);
		pc.setStartFees(8);
		pc.setStartStandards(1);
		pc.setDestCountry("中国");
		pc.setDestProvince("广东省");
		pc.setDestCity("广州市");
		pci.add(pc);
		ptf.setCustom(pci);
		topFee.add(ptf);
		p.setTopFee(topFee);
		DeliveryMoneyRtnInfo rtn = wps.doUpdateExpress(newAccessToken,p);
		System.out.println(rtn.getErrmsg());
	}
	
	// 邮费模板管理接口增加
	public void yfAddTest() {
		WxStoreDeliveryMoneyAPI wps = new WxStoreDeliveryMoneyAPI();
		DeliveryMoney p = new DeliveryMoney();
		p.setAssumer(0);
		p.setName("testexpress");
		p.setValuation(0);
		List<DeliveryMoneyTopFreeInfo> topFee = new ArrayList<DeliveryMoneyTopFreeInfo>();
		DeliveryMoneyTopFreeInfo ptf = new DeliveryMoneyTopFreeInfo();
		ptf.setType(10000027);
		
		DeliveryMoneyNormalInfo pni = new DeliveryMoneyNormalInfo();
		pni.setAddFees(3);
		pni.setAddStandards(1);
		pni.setStartFees(8);
		pni.setStartStandards(2);
		ptf.setNormal(pni);
		
		List<DeliveryMoneyCustomInfo> pci = new ArrayList<DeliveryMoneyCustomInfo>();
		DeliveryMoneyCustomInfo pc = new DeliveryMoneyCustomInfo();
		pc.setAddFees(11);
		pc.setAddStandards(2);
		pc.setStartFees(8);
		pc.setStartStandards(1);
		pc.setDestCountry("中国");
		pc.setDestProvince("广东省");
		pc.setDestCity("广州市");
		pci.add(pc);
		ptf.setCustom(pci);
		topFee.add(ptf);
		p.setTopFee(topFee);
		DeliveryMoneyRtnInfo rtn = wps.doAddExpress(newAccessToken, p);
	}
}
