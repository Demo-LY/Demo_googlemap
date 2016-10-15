package com.example.leonwang.demo_google1003.Utils;

import java.io.IOException;
import java.net.UnknownHostException;

import com.example.leonwang.demo_google1003.Dtos.UserDTO;

public class UserConf {
	private static UserConf userconf = null;
	public static String addressState = "";

	private UserDTO userinfo = null;
	public static boolean isReflush = true;// 我的地址刷新

	// 12F lp 修改成静态变量，方便11F访问
	// public static String urlIp="http://42.120.61.167:80/";//生产地址
	// 外网地址,29的外网
	// public static String urlIp = "http://172.21.32.29:18080/";// 主干测试地址，测试用
	// public static String urlIp="http://118.194.241.200:18080/";//外网地址,52的外网
	// public static String urlIp="http://172.21.32.52:18080/";//主干测试地址，研发用
	// public static String urlIp = "http://172.21.28.198:8080/";// 陈权

	// private static String htmlUrlIp = "http://product.ali-jk.com/h5/";//

//	private String UrlCode = urlIp + "ErxCloud/restservices/";
	//private String wapUrl = urlIp + "ErxCloud/wenjuan/index.html";
	//private LastPushAdrres lastPushAdrres;// 位置信息
	//private ArrayList<RetObj> mRetObjLists = null;
	//private UserDTO userinfo = null;
	private String addressId = "";
	private boolean applyRefreshFlag = false;
	//private OrderInfoDTO orderInfodto;
	//private OrderDetailResponseDTO orderDetailInfodto;

	/** 接口列表 */

	// 扫码后添加预购单
	//public String SCANNER_SHOPPING_ADD = UrlCode + "DrugInfo/selectDrugByScan";

	//public static String DRUG_DETAIL_URL = htmlUrlIp + "drugs.html";

	// 药店详情
	//public static String DRUG_STORE_DETAIL_URL = htmlStoreUrlIp + "pharm.html";
	// 删选
	//public static String DRUG_FILTER_URL = htmlUrlIp + "filter.html#home";


	public String getmProvince() {
		return mProvince;
	}

	public String getmCity() {
		return mCity;
	}

	public String getDistrict() {
		return mAreadress;
	}

	private String mProvince;
	private String mCity;
	private String mAreadress;
	private String mAddressTitle;
	private String mAddressLatitude;

	public String getmAddressLatitude() {
		return mAddressLatitude;
	}

	public void setmAddressLatitude(String mAddressLatitude) {
		this.mAddressLatitude = mAddressLatitude;
	}

	public String getmAddressLongitude() {
		return mAddressLongitude;
	}

	public void setmAddressLongitude(String mAddressLongitude) {
		this.mAddressLongitude = mAddressLongitude;
	}

	public String getmAddressAreacode() {
		return mAddressAreacode;
	}

	public void setmAddressAreacode(String mAddressAreacode) {
		this.mAddressAreacode = mAddressAreacode;
	}

	private String mAddressLongitude;
	private String mAddressAreacode;

	public String getmtMyLocationStreet() {
		return mAddressTitle;
	}

	public void setMyLocationStreet(String mAddressTitle) {
		this.mAddressTitle = mAddressTitle;
	}

	synchronized public static UserConf getInstance()
			throws UnknownHostException, IOException {
		if (userconf == null) {
			userconf = new UserConf();
		}
		return userconf;
	}

	//public String getWapUrl() {
	//	return wapUrl;
	//}

	//public void setWapUrl(String wapUrl) {
	//	this.wapUrl = wapUrl;
	//}

	public boolean getApplyRefreshFlag() {
		return applyRefreshFlag;
	}

	public void setApplyRefreshFlag(boolean applyRefreshFlag) {
		this.applyRefreshFlag = applyRefreshFlag;
	}
/*
	public LastPushAdrres getLastPushAdrres() {
		return lastPushAdrres;
	}

	public void setLastPushAdrres(LastPushAdrres addressInfo) {
		this.lastPushAdrres = addressInfo;
	}

	*//**
	 * 获取处方详情的状况
	 *//*
	public RetObj getRetObjBypresNo(String serialNo) {
		RetObj result = null;
		RetObj pinfo = null;

		if (mRetObjLists == null) {
			return result;
		}
		if (mRetObjLists.size() == 0) {
			return result;
		}
		for (int i = 0; i < mRetObjLists.size(); i++) {
			pinfo = mRetObjLists.get(i);
			String presNo = pinfo.getSerialNo();
			if (presNo.equalsIgnoreCase(serialNo)) {
				result = pinfo;
				break;
			}
		}
		return result;
	}

	public RetObj getRetObjByPushId(String pushId) {
		RetObj result = null;
		RetObj pinfo = null;

		if (mRetObjLists == null) {
			return result;
		}
		if (mRetObjLists.size() == 0) {
			return result;
		}
		for (int i = 0; i < mRetObjLists.size(); i++) {
			pinfo = mRetObjLists.get(i);
			String currentPushId = pinfo.getRequestId();
			if (currentPushId.equalsIgnoreCase(pushId)) {
				result = pinfo;
				break;
			}
		}
		return result;
	}

	public void removeRetObj(String serialNo) {
		RetObj pinfo = null;

		if (mRetObjLists == null) {
			return;
		}
		if (mRetObjLists.size() == 0) {
			return;
		}
		for (int i = 0; i < mRetObjLists.size(); i++) {
			pinfo = mRetObjLists.get(i);
			String presNo = pinfo.getSerialNo();
			if (presNo.equalsIgnoreCase(serialNo)) {
				mRetObjLists.remove(i);
				break;
			}
		}
	}

	public void addRetobj(RetObj retobj) {

		if (retobj == null)
			return;
		if (mRetObjLists == null)
			mRetObjLists = new ArrayList<RetObj>();

		if (mRetObjLists.contains(retobj))
			return;

		for (int i = 0; i < mRetObjLists.size(); i++) {
			RetObj pinfo = mRetObjLists.get(i);
			String presNo = pinfo.getSerialNo();
			if (presNo.equalsIgnoreCase(retobj.getSerialNo())) {
				pinfo = retobj;
				return;
			}
		}
		mRetObjLists.add(retobj);
	}

	public void removeAllRetObj() {
		if (mRetObjLists == null)
			return;
		mRetObjLists.clear();
	}*/

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public UserDTO getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserDTO userinfo) {
		this.userinfo = userinfo;
	}

	public static UserConf getUserconf() {
		return userconf;
	}

	public static void setUserconf(UserConf userconf) {
		UserConf.userconf = userconf;
	}

	//public String getUrlCode() {
		//return UrlCode;
	//}

	//public void setUrlCode(String urlCode) {
	//	UrlCode = urlCode;
	//}


	/**
	 * @param pprovince
	 */
	public void setMyLocationProvince(String pprovince) {
		// TODO Auto-generated method stub
		mProvince = pprovince;
	}

	/**
	 * @param pcity
	 */
	public void setMyLocationCity(String pcity) {
		// TODO Auto-generated method stub
		mCity = pcity;
	}

	/**
	 * @param pareadress
	 */
	public void setMyLocationDistrict(String pareadress) {
		// TODO padaddress;
		mAreadress = pareadress;
	}

}
