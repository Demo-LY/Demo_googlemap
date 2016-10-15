package com.example.leonwang.demo_google1003.mains;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Stack;
import android.app.Application;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.widget.RadioGroup;
import com.example.leonwang.demo_google1003.Dtos.FragmentDTO;
import com.example.leonwang.demo_google1003.Dtos.UserRequestDTO;
import com.example.leonwang.demo_google1003.Utils.QLog;
import com.example.leonwang.demo_google1003.activities.MainActivity;
import com.example.leonwang.demo_google1003.R;



public class UserApplication extends Application implements
		UncaughtExceptionHandler {
	private String username = "";// 用户名
	private UserRequestDTO user;// 用户登录的信息
	private static UserApplication instance;
	private Stack<FragmentDTO> mfStacks;
	private boolean isClickTab = true;
	private Fragment currentFragment;
	public static final String INTENT_KEY = "key";
	public static final String INTENT_CONTENT = "content";

	public Fragment getCurrentFragment() {
		return currentFragment;
	}

	public void setCurrentFragment(Fragment currentFragment) {
		this.currentFragment = currentFragment;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		QLog.init(this);
		Thread.setDefaultUncaughtExceptionHandler(this);
		instance = this;
		initEngineManager(this);
		init();
	}

	private void init() {
		user = new UserRequestDTO();
		user.setPatientCode("1");

	}

	public void initEngineManager(Context context) {
		// 在使用SDK各组件之前初始化context信息，传入ApplicationContext
		// 注意该方法要再setContentView方法之前实现
	//	 SDKInitializer.initialize(context);

	}

	public Stack<FragmentDTO> getMfStacks() {
		if (mfStacks == null) {
			mfStacks = new Stack<FragmentDTO>();
		}
		return mfStacks;
	}

	public void setMfStacks(Stack<FragmentDTO> mfStacks) {
		this.mfStacks = mfStacks;
	}

	public void popfStacks(int index) {
		if(mfStacks != null && mfStacks.size()>0){
			mfStacks.remove(index);
		}
	}

	public static void setInstance(UserApplication instance) {
		UserApplication.instance = instance;
	}

	public static UserApplication getInstance() {
		if (null == instance) {
			instance = new UserApplication();
		}
		return instance;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public UserRequestDTO getUser() {
		return user;
	}

	public void setUser(UserRequestDTO user) {
		this.user = user;
	}

	@Override
	public void uncaughtException(Thread arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		QLog.error("MyApp  uncaughtException", arg1.toString());
		StackTraceElement[] array = arg1.getStackTrace();
		for (StackTraceElement stackTraceElement : array) {
			QLog.error(stackTraceElement.toString());
		}
	}

	/**
	 * Notification显示
	 * 
	 * @param context
	 */
	@SuppressWarnings("deprecation")
	private Notification showNotification(Context context, String msg) {
		// 构建一个通知对象(需要传递的参数有三个,分别是图标,标题和 时间)
		Notification notification = new Notification(R.drawable.ic_launcher,
				getString(R.string.notification), System.currentTimeMillis());
		Intent intent = new Intent(context, MainActivity.class);
		// intent.putExtra(ConstantTool.KEY, ConstantTool.PUSH);
		/*
		MessageDTO data = null;
		PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
				intent, 0);
		try {

			Gson gson = new Gson();
			JsonReader reader = new JsonReader(new StringReader(msg));
			reader.setLenient(true);
			data=gson.fromJson(reader, MessageDTO.class);
		} catch (Exception e) {
			e.toString();
		}
		if (data != null) {
			
			if(!FormatTools.isEmptyStr(data.getDetailType())){
			pendingIntent = PendingIntent.getActivity(context, Integer.parseInt(data.getDetailType()),
					intent, 0);
			}
			notification.setLatestEventInfo(context.getApplicationContext(),
					data.getTitle(), data.getDescription(),
					pendingIntent);
		} else {
			notification.setLatestEventInfo(context.getApplicationContext(),
					getString(R.string.notification), "", pendingIntent);
		}*/
		notification.flags = Notification.FLAG_AUTO_CANCEL;// 点击后自动消失
		notification.defaults = Notification.DEFAULT_SOUND;// 声音默认
		// manager.notify(1, notification);//
		// 发动通知,id由自己指定，每一个Notification对应的唯一标志
		// 其实这里的id没有必要设置,只是为了下面要用到它才进行了设置
		return notification;
	}
}