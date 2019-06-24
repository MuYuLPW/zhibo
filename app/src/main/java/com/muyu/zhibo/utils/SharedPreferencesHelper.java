package com.muyu.zhibo.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

public class SharedPreferencesHelper {

	public static final String FILE_NAME = "share_data";

	private static SharedPreferencesHelper sharedPreferencesHelper = null;

	public static SharedPreferencesHelper getInstance(Context context) {
		if (sharedPreferencesHelper == null) {
			synchronized (SharedPreferencesHelper.class) {
				if (sharedPreferencesHelper == null) {
					sharedPreferencesHelper = new SharedPreferencesHelper();
					sharedPreferencesHelper.setContext(context.getApplicationContext());
					return sharedPreferencesHelper;
				}
			}
		}
		return sharedPreferencesHelper;
	}

	private Context context;

	public void setContext(Context context) {
		this.context = context;
	}

	public boolean getBoolean(String key, boolean defValue) {
		try {
			return getSP().getBoolean(key, defValue);
		} catch (NullPointerException exception) {
			return defValue;
		}
	}

	public void putBoolean(String key, boolean value) {
		try {
			SharedPreferences.Editor editor = getSP().edit();
			editor.putBoolean(key, value);
			editor.commit();
		} catch (NullPointerException exception) {
			Log.d("hcj", "" + exception);
		}
	}

	public long getLong(String key, long defValue) {
		try {
			return getSP().getLong(key, defValue);
		} catch (NullPointerException exception) {
			Log.d("hcj", "" + exception);
			return defValue;
		}
	}

	public void putLong(String key, long value) {
		try {
			SharedPreferences.Editor editor = getSP().edit();
			editor.putLong(key, value);
			editor.commit();
		} catch (NullPointerException exception) {
			Log.d("hcj", "" + exception);
		}
	}

	public int getInt(String key, int defaultValue) {
		try {
			return getSP().getInt(key, defaultValue);
		} catch (Exception e) {
			Log.d("hcj", "" + e);
			return defaultValue;

		}
	}

	public void putInt(String key, int value) {
		try {
			SharedPreferences.Editor editor = getSP().edit();
			editor.putInt(key, value);
			editor.commit();
		} catch (Exception e) {
			Log.d("hcj", "" + e);
		}
	}

	public String getString(String key) {
		try {
			return getSP().getString(key, "");
		} catch (Exception e) {
			Log.d("hcj", "" + e);
			return "";

		}
	}

	public void putString(String key, String value) {
		try {
			SharedPreferences.Editor editor = getSP().edit();
			editor.putString(key, value);
			editor.commit();
		} catch (Exception e) {
			Log.d("hcj", "" + e);
		}
	}

	public void clearOnly(String key) {
		try {
			SharedPreferences.Editor editor = getSP().edit();
			editor.remove(key);
			editor.commit();
		} catch (NullPointerException e) {
			Log.d("hcj", "" + e);
		}
	}

	public void clear() {
		try {
			SharedPreferences.Editor editor = getSP().edit();
			editor.clear();
			editor.commit();
		} catch (NullPointerException e) {
			Log.d("hcj", "" + e);
		}
	}

	private SharedPreferences getSP() {
		return context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
	}

	/**
	 * desc:保存对象
	 * 

	 * @param key
	 * @param obj
	 *            要保存的对象，只能保存实现了serializable的对象 modified:
	 */
	public void putObject(String key, Object obj) {
		try {
			// 保存对象
			SharedPreferences.Editor editor = getSP().edit();
			// 先将序列化结果写到byte缓存中，其实就分配一个内存空间
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream os = new ObjectOutputStream(bos);
			// 将对象序列化写入byte缓存
			os.writeObject(obj);
			// 将序列化的数据转为16进制保存
			String bytesToHexString = bytesToHexString(bos.toByteArray());
			// 保存该16进制数组
			editor.putString(key, bytesToHexString);
			editor.commit();
		} catch (IOException e) {
			e.printStackTrace();
			Log.e("tag==",e.getMessage());
		}
	}

	/**
	 * desc:将数组转为16进制
	 * 
	 * @param bArray
	 * @return modified:
	 */
	@SuppressLint("DefaultLocale")
	public static String bytesToHexString(byte[] bArray) {
		if (bArray == null) {
			return null;
		}
		if (bArray.length == 0) {
			return "";
		}
		StringBuffer sb = new StringBuffer(bArray.length);
		String sTemp;
		for (int i = 0; i < bArray.length; i++) {
			sTemp = Integer.toHexString(0xFF & bArray[i]);
			if (sTemp.length() < 2)
				sb.append(0);
			sb.append(sTemp.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * desc:获取保存的Object对象
	 *
	 * @param key
	 * @return modified:
	 */
	public Object getObject(String key) {
		try {
			SharedPreferences sharedata = getSP();
			if (sharedata.contains(key)) {
				String string = sharedata.getString(key, "");
				if (TextUtils.isEmpty(string)) {
					return null;
				} else {
					// 将16进制的数据转为数组，准备反序列化
					byte[] stringToBytes = StringToBytes(string);
					ByteArrayInputStream bis = new ByteArrayInputStream(stringToBytes);
					ObjectInputStream is = new ObjectInputStream(bis);
					// 返回反序列化得到的对象
					Object readObject = is.readObject();
					return readObject;
				}
			}
		} catch (StreamCorruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e("tag==",e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e("tag==",e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e("tag==",e.getMessage());
		}
		// 所有异常返回null
		return null;

	}

	/**
	 * desc:将16进制的数据转为数组
	 * <p>
	 * 创建人：聂旭阳 , 2014-5-25 上午11:08:33
	 * </p>
	 * 
	 * @param data
	 * @return modified:
	 */
	@SuppressLint("DefaultLocale")
	public static byte[] StringToBytes(String data) {
		String hexString = data.toUpperCase().trim();
		if (hexString.length() % 2 != 0) {
			return null;
		}
		byte[] retData = new byte[hexString.length() / 2];
		for (int i = 0; i < hexString.length(); i++) {
			int int_ch; // 两位16进制数转化后的10进制数
			char hex_char1 = hexString.charAt(i); // //两位16进制数中的第一位(高位*16)
			int int_ch1;
			if (hex_char1 >= '0' && hex_char1 <= '9')
				int_ch1 = (hex_char1 - 48) * 16; // // 0 的Ascll - 48
			else if (hex_char1 >= 'A' && hex_char1 <= 'F')
				int_ch1 = (hex_char1 - 55) * 16; // // A 的Ascll - 65
			else
				return null;
			i++;
			char hex_char2 = hexString.charAt(i); // /两位16进制数中的第二位(低位)
			int int_ch2;
			if (hex_char2 >= '0' && hex_char2 <= '9')
				int_ch2 = (hex_char2 - 48); // // 0 的Ascll - 48
			else if (hex_char2 >= 'A' && hex_char2 <= 'F')
				int_ch2 = hex_char2 - 55; // // A 的Ascll - 65
			else
				return null;
			int_ch = int_ch1 + int_ch2;
			retData[i / 2] = (byte) int_ch;// 将转化后的数放入Byte里
		}
		return retData;
	}

//	/**
//	 * 保存List
//	 * @param datalist
//	 */
//	public <T> void putDataList(String key, List<T> datalist) {
//		if (null == datalist || datalist.size() <= 0)
//			return;
//		Gson gson = new Gson();
//		//转换成json数据，再保存
//		String strJson = gson.toJson(datalist);
//		SharedPreferences.Editor editor = getSP().edit();
//		editor.putString(key, strJson);
//		editor.commit();
//	}
//
//	/**
//	 * 获取List
//	 * @param tag
//	 * @return
//	 */
//	public  <T> List<T> getDataList(String tag) {
//		List<T> datalist=new ArrayList<T>();
//		String strJson = getSP().getString(tag,"");
//		if (MyUtils.isEmpty(strJson)) {
//			return datalist;
//		}
//		Gson gson = new Gson();
//		datalist = gson.fromJson(strJson, new TypeToken<List<T>>(){}.getType());
//		return datalist;
//
//	}
}
