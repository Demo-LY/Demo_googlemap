package com.example.leonwang.demo_google1003.Utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;


public class ConfigManager {

	private static final String CITIC21_USER_PREF = "citic21_user_config";
	private Context context;
	private SharedPreferences pref = null;
	public static final String DEVICE_TYPE = "1";//"Android"

	/**
	 *
	 */
	public ConfigManager(Context context) {
		super();
		this.context = context;
		pref = context.getSharedPreferences(CITIC21_USER_PREF,
				Context.MODE_PRIVATE);
	}

	public SharedPreferences getPreferences() {
		return pref;
	}

	public SharedPreferences.Editor getEditor() {
		return pref.edit();
	}

	public static SharedPreferences getPreferences(Context context) {
		return context.getSharedPreferences(CITIC21_USER_PREF,
				Context.MODE_PRIVATE);
	}

	/**
	 * 获取设备id策略： 1，优先IMEI串号； 2，MAC地址串； 3，ANDROID_ID串号(获取 Android 设备的唯一标识码 )；
	 *
	 * @return
	 */
	public String getDeviceId() {
		String deviceId = pref.getString("device_id", null);
		if (deviceId == null) {
			TelephonyManager tm = (TelephonyManager) context
					.getSystemService(Context.TELEPHONY_SERVICE);
			deviceId = tm.getDeviceId();
//			LogM.d("ConfigManager", "getDeviceId:" + deviceId);
			long deviceIdInt = 0;
			try{
				deviceIdInt = Long.parseLong(deviceId);
			}
			catch(Exception e){
				e.printStackTrace();
				deviceIdInt = 0;
			}
//			if (deviceId == null || "0".equalsIgnoreCase(deviceId)) {
			if(deviceIdInt == 0){
				deviceId = getDeviceMacAddress();
				if (deviceId == null) {
					deviceId = getDeviceAndroidId();
				}
				QLog.debug("ConfigManager", "getDeviceMacAddress:" + deviceId);
			}
			SharedPreferences.Editor editor = getEditor();
			editor.putString("device_id", deviceId);
			editor.commit();
		}
		return deviceId;
	}

	/**
	 * 获取配置文件中版本号versionName android:versionName="1.0.6"
	 */
	public String getVersionName() {
		String versionName = null;
		try {
			PackageInfo packInfo = context.getPackageManager().getPackageInfo(
					context.getPackageName(), 0);
			versionName = packInfo.versionName;
			QLog.debug("ConfigManager","versionName=" + versionName);
		} catch (Exception e) {
			QLog.debug("ConfigManager","Failed to get versionName: " + e.getMessage());
		}
		return versionName;
	}

	/**
	 * 获取配置文件中版本号versionCode versionCode= 10
	 */
	public int getVersionCode() {
		int versionCode = 0;
		try {

			PackageInfo packInfo = context.getPackageManager().getPackageInfo(
					context.getPackageName(), 0);
			versionCode = packInfo.versionCode;
			QLog.debug("ConfigManager","versionName=" + versionCode);
		} catch (Exception e) {
			QLog.debug("ConfigManager","Failed to get versionName: " + e.getMessage());
		}
		return versionCode;
	}

	/**
	 * 获取渠道名
	 * @param ctx 此处习惯性的设置为activity，实际上context就可以
	 * @return 如果没有获取成功，那么返回值为空
	 */
	public String getChannelName() {

		String channelName = null;
		try {
			PackageManager packageManager = context.getPackageManager();
			if (packageManager != null) {
				//注意此处为ApplicationInfo 而不是 ActivityInfo,因为友盟设置的meta-data是在application标签中，而不是某activity标签中，所以用ApplicationInfo
				ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
				if (applicationInfo != null) {
					if (applicationInfo.metaData != null) {
						channelName = ""+applicationInfo.metaData.getInt("UMENG_CHANNEL");
					}
				}

			}
		} catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
		}
		return channelName;
	}


	/*
	 * 活动id
	 */
	public String getActivityId() {
		String activityId = null;
		int id = 0;
		try {
			ApplicationInfo ai = context.getPackageManager()
					.getApplicationInfo(context.getPackageName(),
							PackageManager.GET_META_DATA);
			Bundle bundle = ai.metaData;
			id = bundle.getInt("ACTIVITY_ID");
			activityId = String.valueOf(id);
		} catch (NameNotFoundException e) {
			QLog.debug("ConfigManager","Failed to load meta-data, NameNotFound: " + e.getMessage());
		} catch (NullPointerException e) {
			QLog.debug("ConfigManager","Failed to load meta-data, NullPointer: " + e.getMessage());
		}
		return activityId;
	}

	/**
	 * 获取应用名
	 */
	public String getAppName() {
		String appName = null;
		try {
			PackageInfo packInfo = context.getPackageManager().getPackageInfo(
					context.getPackageName(), 0);
			// 当前版本的包名
			appName = packInfo.packageName;
			QLog.debug("ConfigManager","appName=" + appName);
		} catch (Exception e) {
			QLog.debug("ConfigManager","Failed to get versionName: " + e.getMessage());
		}
		return appName;
	}

	/**
	 * 获取mac地址作为认证
	 *
	 * @return
	 */
	public String getDeviceMacAddress() {

		String macAddr = "";
		try {
			WifiManager wifi = (WifiManager) context
					.getSystemService(Context.WIFI_SERVICE);
			WifiInfo info = wifi.getConnectionInfo();
			macAddr = info.getMacAddress();
		} catch (Exception e) {
			macAddr = null;
			e.printStackTrace();
		}

		return macAddr;
	}

	/**
	 * 获取设备的唯一标识码
	 */
	public String getDeviceAndroidId() {
		String android_id = Secure.getString(context.getContentResolver(),
				Secure.ANDROID_ID);
		return android_id;
	}

	/**
	 * 获取设备cpu序列号
	 *
	 * @return CPU序列号(16位) 未使用过 读取失败为"0000000000000000"
	 */
	public static String getCPUSerial() {
		String str = "", strCPU = "", cpuAddress = "0000000000000000";
		try {
			// 读取CPU信息
			// Process pp = Runtime.getRuntime().exec("cat /proc/cpuinfo");
			Process pp = Runtime.getRuntime().exec("system/proc/cpuinfo");
			InputStreamReader ir = new InputStreamReader(pp.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			// 查找CPU序列号
			for (int i = 1; i < 500; i++) {
				str = input.readLine();
				if (str != null) {
					// 查找到序列号所在行
					// if (str.indexOf("Serial") > -1) {
					// 提取序列号
					strCPU = str.substring(str.indexOf(":") + 1, str.length());
					// 去空格
					// cpuAddress = strCPU.trim();
					cpuAddress += str.trim();
					// break;
					// }
				} else {
					// 文件结尾
					break;
				}
			}
		} catch (IOException ex) {
			// 赋予默认值
			ex.printStackTrace();
		}
		return cpuAddress;
	}


	/**
	 * 手机型号
	 */
	public String getPhoneModel(){
		return	Build.MODEL;
	}

	/**
	 * OS version
	 */
	public String getOSVersion(){
		return Build.VERSION.RELEASE;
	}
}