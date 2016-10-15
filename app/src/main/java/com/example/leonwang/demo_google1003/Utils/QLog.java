/**
 * 
 */
package com.example.leonwang.demo_google1003.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.util.Log;

/**
 * @author yangrf
 * @date Nov 20, 2011
 * @time 5:56:00 PM
 */
public class QLog {
	static final String TAG = "com.bushwalking";
	static final int LOG_LEVEL = LogLevel.Error.ordinal();
	static PrintStream stream = null;
	static Date date = new Date();
	private final static boolean DEBUG=true;
	private static Context mParamContext;
	enum LogLevel {
		Verbose, Debug, Info, Warn, Error
	};

	public static void init(Context paramContext) {
		mParamContext = paramContext;
	}

	
	public static void writeLog() {
		if(mParamContext == null)
			return;
		try {
			if(DEBUG){
			SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
			String text = dd.format(new Date());
			String rootPath = FileManager.getUserLogDirPath(mParamContext);
			File dir = new File(rootPath);
			if(!dir.exists())
				dir.mkdirs();
			File file = new File(rootPath,text+"_log.txt");
			file.createNewFile();
			if(stream == null)
				stream = new PrintStream(new FileOutputStream(file, true), true);
			if(date == null)
				date = new Date();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void error(String msg) {
		writeLog();
		if (DEBUG && (LOG_LEVEL <= LogLevel.Error.ordinal())) {
			Log.e(TAG, msg);
			if (stream != null) {
				date.setTime(System.currentTimeMillis());
				stream.println(date.toLocaleString() + "	error$	" + msg);
			}
		}
	}

	public static void error(String tag, String msg) {
		writeLog();
		if (DEBUG && (LOG_LEVEL <= LogLevel.Error.ordinal())) {
			Log.e(tag, msg);
			if (stream != null) {
				date.setTime(System.currentTimeMillis());
				stream.println(date.toLocaleString() + "	error$	" + "	TAG:	"
						+ tag + msg);
			}
		}
	}

	public static void warn(String msg) {
		if (DEBUG && (LOG_LEVEL <= LogLevel.Warn.ordinal())) {
			Log.w(TAG, msg);
			if (stream != null) {
				date.setTime(System.currentTimeMillis());
				stream.println(date.toLocaleString() + "	warn$	" + msg);
			}
		}
	}

	public static void warn(String tag, String msg) {
		if (DEBUG && (LOG_LEVEL <= LogLevel.Warn.ordinal())) {
			Log.w(tag, msg);
			if (stream != null) {
				date.setTime(System.currentTimeMillis());
				stream.println(date.toLocaleString() + "	warn$	" + "	TAG$	"
						+ tag + msg);
			}
		}
	}

	public static void info(String msg) {
		if (DEBUG && (LOG_LEVEL <= LogLevel.Info.ordinal())) {
			Log.i(TAG, msg);
			if (stream != null) {
				date.setTime(System.currentTimeMillis());
				stream.println(date.toLocaleString() + "	info$	" + msg);
			}
		}
	}

	public static void info(String tag, String msg) {
		if (DEBUG && (LOG_LEVEL <= LogLevel.Info.ordinal())) {
			Log.i(tag, msg);
			if (stream != null) {
				date.setTime(System.currentTimeMillis());
				stream.println(date.toLocaleString() + "	info$	" + "	TAG$	"
						+ tag + msg);
			}
		}
	}

	public static void debug(String msg) {
		if (DEBUG && (LOG_LEVEL <= LogLevel.Debug.ordinal())) {
			Log.d(TAG, msg);
			if (stream != null) {
				date.setTime(System.currentTimeMillis());
				stream.println(date.toLocaleString() + "	debug$	" + msg);
			}
		}
	}

	public static void debug(String tag, String msg) {
		if (DEBUG && (LOG_LEVEL <= LogLevel.Debug.ordinal())
				&& msg != null) {
			Log.d(tag, msg);
			if (stream != null) {
				date.setTime(System.currentTimeMillis());
				stream.println(date.toLocaleString() + "	debug$	" + "	TAG: "
						+ tag + msg);
			}
		}
	}

	public static void debugStackTrace(String tag, Exception ex) {
		if (DEBUG && (LOG_LEVEL <= LogLevel.Debug.ordinal())) {

			StackTraceElement[] se = ex.getStackTrace();
			QLog.debug(tag + ex.toString());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < se.length; i++) {
				sb.append(se[i].toString()).append("\n");
				QLog.debug(tag, se[i].toString());
			}

			if (stream != null) {
				date.setTime(System.currentTimeMillis());
				stream.println(date.toLocaleString() + "	debug$	" + "	TAG: "
						+ tag + sb.toString());
			}
		}
	}

	public static void verbose(String msg) {
		if (DEBUG && (LOG_LEVEL <= LogLevel.Verbose.ordinal())) {
			Log.v(TAG, msg);
			if (stream != null) {
				date.setTime(System.currentTimeMillis());
				stream.println(date.toLocaleString() + "	verbose$	" + msg);
			}
		}
	}

	public static void verbose(String tag, String msg) {
		if (DEBUG && (LOG_LEVEL <= LogLevel.Verbose.ordinal())) {
			Log.v(tag, msg);
			if (stream != null) {
				date.setTime(System.currentTimeMillis());
				stream.println(date.toLocaleString() + "	verbose$	" + "	TAG:	"
						+ tag + msg);
			}
		}
	}
}