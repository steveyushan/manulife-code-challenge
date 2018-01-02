package com.steve.util;

import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

/**
 * KVStorage£¬using sharedpreferences to save data
 * 
 */
public class KvStorage {
	private static KvStorage sInstance = null;
	private static SharedPreferences sSharedPreferences = null;
	private static Editor sEditor = null;

	private KvStorage(Context context) {
		if (sSharedPreferences == null) {
			sSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
			sEditor = sSharedPreferences.edit();
		}
	}

	public boolean clear() {
		return sEditor.clear() != null;
	}

	public boolean putString(String key, String value) {
		return sEditor.putString(key, value) != null;
	}

	public boolean commit() {
		return sEditor.commit();
	}

	public boolean putBoolean(String key, boolean value) {
		return sEditor.putBoolean(key, value) != null;
	}

	public boolean putInt(String key, int value) {
		return sEditor.putInt(key, value) != null;
	}

	public boolean putFloat(String key, float value) {
		return sEditor.putFloat(key, value) != null;
	}

	public boolean putLong(String key, long value) {
		return sEditor.putLong(key, value) != null;
	}

	public boolean remove(String key) {
		return sEditor.remove(key) != null;
	}

	public boolean contains(String key) {
		return sSharedPreferences.contains(key);
	}

	public Map<String, ?> getAll() {
		return sSharedPreferences.getAll();
	}

	public boolean getBoolean(String key, boolean defValue) {
		return sSharedPreferences.getBoolean(key, defValue);
	}

	public float getFloat(String key, float defValue) {
		return sSharedPreferences.getFloat(key, defValue);
	}

	public int getInt(String key, int defValue) {
		return sSharedPreferences.getInt(key, defValue);
	}

	public long getLong(String key, long defValue) {
		return sSharedPreferences.getLong(key, defValue);
	}

	public String getString(String key, String defValue) {
		return sSharedPreferences.getString(key, defValue);
	}

	public static KvStorage getInstance(Context context) {
		if (sInstance == null) {
			synchronized (KvStorage.class) {
				if (sInstance == null) {
					sInstance = new KvStorage(context.getApplicationContext());
				}
			}
		}
		return sInstance;		// single instance
	}

}
