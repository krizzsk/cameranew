package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class TapjoyCacheMap extends ConcurrentHashMap {
    private Context a;
    private int b;

    public TapjoyCacheMap(Context context, int i2) {
        this.b = -1;
        this.a = context;
        this.b = i2;
    }

    private String a() {
        long j2 = -1;
        String str = "";
        for (Map.Entry entry : entrySet()) {
            long timestampInSeconds = ((TapjoyCachedAssetData) entry.getValue()).getTimestampInSeconds();
            if (j2 == 0 || timestampInSeconds < j2) {
                str = (String) entry.getKey();
                j2 = timestampInSeconds;
            }
        }
        return str;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public TapjoyCachedAssetData put(String str, TapjoyCachedAssetData tapjoyCachedAssetData) {
        TapjoyLog.d("TapjoyCacheMap", "TapjoyCacheMap::put() -- key: " + str + " assetURL: " + tapjoyCachedAssetData.getAssetURL());
        if (tapjoyCachedAssetData != null && tapjoyCachedAssetData.getTimeOfDeathInSeconds() > System.currentTimeMillis() / 1000) {
            if (size() == this.b) {
                remove((Object) a());
            }
            SharedPreferences.Editor edit = this.a.getSharedPreferences(TapjoyConstants.PREF_TAPJOY_CACHE, 0).edit();
            edit.putString(tapjoyCachedAssetData.getLocalFilePath(), tapjoyCachedAssetData.toRawJSONString());
            edit.apply();
            return (TapjoyCachedAssetData) super.put((TapjoyCacheMap) str, (String) tapjoyCachedAssetData);
        }
        return null;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public TapjoyCachedAssetData remove(Object obj) {
        if (containsKey(obj)) {
            SharedPreferences.Editor edit = this.a.getSharedPreferences(TapjoyConstants.PREF_TAPJOY_CACHE, 0).edit();
            edit.remove(((TapjoyCachedAssetData) get(obj)).getLocalFilePath());
            edit.apply();
            String localFilePath = ((TapjoyCachedAssetData) get(obj)).getLocalFilePath();
            if (localFilePath != null && localFilePath.length() > 0) {
                TapjoyUtil.deleteFileOrDirectory(new File(localFilePath));
            }
            TapjoyLog.d("TapjoyCacheMap", "TapjoyCacheMap::remove() -- key: " + obj);
            return (TapjoyCachedAssetData) super.remove(obj);
        }
        return null;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(String str, TapjoyCachedAssetData tapjoyCachedAssetData, TapjoyCachedAssetData tapjoyCachedAssetData2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.Map, java.util.concurrent.ConcurrentMap
    public TapjoyCachedAssetData replace(String str, TapjoyCachedAssetData tapjoyCachedAssetData) {
        throw new UnsupportedOperationException();
    }
}
