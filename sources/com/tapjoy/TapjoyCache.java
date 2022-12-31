package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.internal.fj;
import com.tencent.bugly.BuglyStrategy;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TapjoyCache {
    public static final String CACHE_DIRECTORY_NAME = "Tapjoy/Cache/";
    public static final int CACHE_LIMIT = -1;
    private static TapjoyCache a = null;
    public static boolean unit_test_mode = false;
    private Context b;
    private TapjoyCacheMap c;

    /* renamed from: d  reason: collision with root package name */
    private Vector f7260d;

    /* renamed from: e  reason: collision with root package name */
    private ExecutorService f7261e;

    /* renamed from: f  reason: collision with root package name */
    private File f7262f;

    /* loaded from: classes3.dex */
    public class CacheAssetThread implements Callable {
        private URL b;
        private String c;

        /* renamed from: d  reason: collision with root package name */
        private long f7263d;

        public CacheAssetThread(URL url, String str, long j2) {
            this.b = url;
            this.c = str;
            this.f7263d = j2;
            if (j2 <= 0) {
                this.f7263d = 86400L;
            }
            TapjoyCache.this.f7260d.add(TapjoyCache.b(this.b.toString()));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v12, types: [java.io.BufferedOutputStream] */
        /* JADX WARN: Type inference failed for: r4v18 */
        /* JADX WARN: Type inference failed for: r4v23 */
        /* JADX WARN: Type inference failed for: r4v24, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
        /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r4v7 */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            Exception exc;
            BufferedOutputStream bufferedOutputStream;
            SocketTimeoutException socketTimeoutException;
            BufferedOutputStream bufferedOutputStream2;
            int responseCode;
            String b = TapjoyCache.b(this.b.toString());
            if (TapjoyCache.this.c.containsKey(b)) {
                if (new File(((TapjoyCachedAssetData) TapjoyCache.this.c.get(b)).getLocalFilePath()).exists()) {
                    if (this.f7263d != 0) {
                        ((TapjoyCachedAssetData) TapjoyCache.this.c.get(b)).resetTimeToLive(this.f7263d);
                    } else {
                        ((TapjoyCachedAssetData) TapjoyCache.this.c.get(b)).resetTimeToLive(86400L);
                    }
                    TapjoyLog.d("TapjoyCache", "Reseting time to live for " + this.b.toString());
                    TapjoyCache.this.f7260d.remove(b);
                    return Boolean.TRUE;
                }
                TapjoyCache.getInstance().removeAssetFromCache(b);
            }
            System.currentTimeMillis();
            try {
                File file = new File(TapjoyCache.this.f7262f + "/" + TapjoyUtil.SHA256(b));
                StringBuilder sb = new StringBuilder("Downloading and caching asset from: ");
                sb.append(this.b);
                ?? r4 = " to ";
                sb.append(" to ");
                sb.append(file);
                TapjoyLog.d("TapjoyCache", sb.toString());
                BufferedInputStream bufferedInputStream = null;
                try {
                    try {
                        URLConnection a = fj.a(this.b);
                        a.setConnectTimeout(15000);
                        a.setReadTimeout(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
                        a.connect();
                        if ((a instanceof HttpURLConnection) && (responseCode = ((HttpURLConnection) a).getResponseCode()) != 200) {
                            throw new IOException("Unexpected response code: " + responseCode);
                        }
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(a.getInputStream());
                        try {
                            r4 = new BufferedOutputStream(new FileOutputStream(file));
                            try {
                                TapjoyUtil.writeFileToDevice(bufferedInputStream2, r4);
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException unused) {
                                }
                                try {
                                    r4.close();
                                } catch (IOException unused2) {
                                }
                                TapjoyCachedAssetData tapjoyCachedAssetData = new TapjoyCachedAssetData(this.b.toString(), file.getAbsolutePath(), this.f7263d);
                                String str = this.c;
                                if (str != null) {
                                    tapjoyCachedAssetData.setOfferID(str);
                                }
                                TapjoyCache.this.c.put(b, tapjoyCachedAssetData);
                                TapjoyCache.this.f7260d.remove(b);
                                TapjoyLog.d("TapjoyCache", "----- Download complete -----" + tapjoyCachedAssetData.toString());
                                return Boolean.TRUE;
                            } catch (SocketTimeoutException e2) {
                                socketTimeoutException = e2;
                                bufferedInputStream = bufferedInputStream2;
                                bufferedOutputStream2 = r4;
                                TapjoyLog.e("TapjoyCache", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.NETWORK_ERROR, "Network timeout during caching: " + socketTimeoutException.toString()));
                                TapjoyCache.this.f7260d.remove(b);
                                TapjoyUtil.deleteFileOrDirectory(file);
                                Boolean bool = Boolean.FALSE;
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException unused3) {
                                    }
                                }
                                if (bufferedOutputStream2 != null) {
                                    try {
                                        bufferedOutputStream2.close();
                                    } catch (IOException unused4) {
                                    }
                                }
                                return bool;
                            } catch (Exception e3) {
                                exc = e3;
                                bufferedInputStream = bufferedInputStream2;
                                bufferedOutputStream = r4;
                                TapjoyLog.e("TapjoyCache", "Error caching asset: " + exc.toString());
                                TapjoyCache.this.f7260d.remove(b);
                                TapjoyUtil.deleteFileOrDirectory(file);
                                Boolean bool2 = Boolean.FALSE;
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException unused5) {
                                    }
                                }
                                if (bufferedOutputStream != null) {
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (IOException unused6) {
                                    }
                                }
                                return bool2;
                            } catch (Throwable th) {
                                th = th;
                                bufferedInputStream = bufferedInputStream2;
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException unused7) {
                                    }
                                }
                                if (r4 != 0) {
                                    try {
                                        r4.close();
                                    } catch (IOException unused8) {
                                    }
                                }
                                throw th;
                            }
                        } catch (SocketTimeoutException e4) {
                            bufferedOutputStream2 = null;
                            bufferedInputStream = bufferedInputStream2;
                            socketTimeoutException = e4;
                        } catch (Exception e5) {
                            bufferedOutputStream = null;
                            bufferedInputStream = bufferedInputStream2;
                            exc = e5;
                        } catch (Throwable th2) {
                            th = th2;
                            r4 = 0;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (SocketTimeoutException e6) {
                    socketTimeoutException = e6;
                    bufferedOutputStream2 = null;
                } catch (Exception e7) {
                    exc = e7;
                    bufferedOutputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    r4 = 0;
                }
            } catch (Exception unused9) {
                TapjoyCache.this.f7260d.remove(b);
                return Boolean.FALSE;
            }
        }
    }

    public TapjoyCache(Context context) {
        if (a == null || unit_test_mode) {
            a = this;
            this.b = context;
            this.c = new TapjoyCacheMap(context, -1);
            this.f7260d = new Vector();
            this.f7261e = Executors.newFixedThreadPool(5);
            if (Environment.getExternalStorageDirectory() != null) {
                TapjoyUtil.deleteFileOrDirectory(new File(Environment.getExternalStorageDirectory(), "tapjoy"));
                TapjoyUtil.deleteFileOrDirectory(new File(Environment.getExternalStorageDirectory(), "tjcache/tmp/"));
            }
            File file = new File(this.b.getFilesDir() + "/Tapjoy/Cache/");
            this.f7262f = file;
            if (!file.exists()) {
                if (this.f7262f.mkdirs()) {
                    TapjoyLog.d("TapjoyCache", "Created directory at: " + this.f7262f.getPath());
                } else {
                    TapjoyLog.e("TapjoyCache", "Error initalizing cache");
                    a = null;
                }
            }
            a();
        }
    }

    public static TapjoyCache getInstance() {
        return a;
    }

    public static void setInstance(TapjoyCache tapjoyCache) {
        a = tapjoyCache;
    }

    public Future cacheAssetFromJSONObject(JSONObject jSONObject) {
        try {
            return cacheAssetFromURL(jSONObject.getString("url"), jSONObject.optString(TapjoyConstants.TJC_PLACEMENT_OFFER_ID), Long.valueOf(jSONObject.optLong(TapjoyConstants.TJC_TIME_TO_LIVE)).longValue());
        } catch (JSONException unused) {
            TapjoyLog.e("TapjoyCache", "Required parameters to cache an asset from JSON is not present");
            return null;
        }
    }

    public Future cacheAssetFromURL(String str, String str2, long j2) {
        try {
            URL url = new URL(str);
            if (this.f7260d.contains(b(str))) {
                TapjoyLog.d("TapjoyCache", "URL is already in the process of being cached: " + str);
                return null;
            }
            return startCachingThread(url, str2, j2);
        } catch (MalformedURLException unused) {
            TapjoyLog.d("TapjoyCache", "Invalid cache assetURL");
            return null;
        }
    }

    public void cacheAssetGroup(final JSONArray jSONArray, final TJCacheListener tJCacheListener) {
        if (jSONArray != null && jSONArray.length() > 0) {
            new Thread() { // from class: com.tapjoy.TapjoyCache.1
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    TapjoyLog.d("TapjoyCache", "Starting to cache asset group size of " + jSONArray.length());
                    ArrayList<Future> arrayList = new ArrayList();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        try {
                            Future cacheAssetFromJSONObject = TapjoyCache.this.cacheAssetFromJSONObject(jSONArray.getJSONObject(i2));
                            if (cacheAssetFromJSONObject != null) {
                                arrayList.add(cacheAssetFromJSONObject);
                            }
                        } catch (JSONException unused) {
                            TapjoyLog.e("TapjoyCache", "Failed to load JSON object from JSONArray");
                        }
                    }
                    int i3 = 1;
                    for (Future future : arrayList) {
                        try {
                        } catch (InterruptedException e2) {
                            TapjoyLog.e("TapjoyCache", "Caching thread failed: " + e2.toString());
                        } catch (ExecutionException e3) {
                            TapjoyLog.e("TapjoyCache", "Caching thread failed: " + e3.toString());
                        }
                        if (!((Boolean) future.get()).booleanValue()) {
                            i3 = 2;
                        }
                    }
                    TapjoyLog.d("TapjoyCache", "Finished caching group");
                    TJCacheListener tJCacheListener2 = tJCacheListener;
                    if (tJCacheListener2 != null) {
                        tJCacheListener2.onCachingComplete(i3);
                    }
                }
            }.start();
        } else if (tJCacheListener != null) {
            tJCacheListener.onCachingComplete(1);
        }
    }

    public String cachedAssetsToJSON() {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : this.c.entrySet()) {
            try {
                jSONObject.put(((String) entry.getKey()).toString(), ((TapjoyCachedAssetData) entry.getValue()).toRawJSONString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public void clearTapjoyCache() {
        TapjoyLog.d("TapjoyCache", "Cleaning Tapjoy cache!");
        TapjoyUtil.deleteFileOrDirectory(this.f7262f);
        if (this.f7262f.mkdirs()) {
            TapjoyLog.d("TapjoyCache", "Created new cache directory at: " + this.f7262f.getPath());
        }
        this.c = new TapjoyCacheMap(this.b, -1);
    }

    public TapjoyCacheMap getCachedData() {
        return this.c;
    }

    public TapjoyCachedAssetData getCachedDataForURL(String str) {
        String b = b(str);
        if (b != "") {
            return (TapjoyCachedAssetData) this.c.get(b);
        }
        return null;
    }

    public String getCachedOfferIDs() {
        ArrayList arrayList = new ArrayList();
        TapjoyCacheMap tapjoyCacheMap = this.c;
        if (tapjoyCacheMap != null) {
            for (Map.Entry entry : tapjoyCacheMap.entrySet()) {
                String offerId = ((TapjoyCachedAssetData) entry.getValue()).getOfferId();
                if (offerId != null && offerId.length() != 0 && !arrayList.contains(offerId)) {
                    arrayList.add(offerId);
                }
            }
            return TextUtils.join(",", arrayList);
        }
        return "";
    }

    public String getPathOfCachedURL(String str) {
        String b = b(str);
        if (b == "" || !this.c.containsKey(b)) {
            return str;
        }
        TapjoyCachedAssetData tapjoyCachedAssetData = (TapjoyCachedAssetData) this.c.get(b);
        if (new File(tapjoyCachedAssetData.getLocalFilePath()).exists()) {
            return tapjoyCachedAssetData.getLocalURL();
        }
        getInstance().removeAssetFromCache(str);
        return str;
    }

    public boolean isURLCached(String str) {
        return this.c.get(b(str)) != null;
    }

    public boolean isURLDownloading(String str) {
        String b;
        return (this.f7260d == null || (b = b(str)) == "" || !this.f7260d.contains(b)) ? false : true;
    }

    public void printCacheInformation() {
        TapjoyLog.d("TapjoyCache", "------------- Cache Data -------------");
        TapjoyLog.d("TapjoyCache", "Number of files in cache: " + this.c.size());
        TapjoyLog.d("TapjoyCache", "Cache Size: " + TapjoyUtil.fileOrDirectorySize(this.f7262f));
        TapjoyLog.d("TapjoyCache", "--------------------------------------");
    }

    public boolean removeAssetFromCache(String str) {
        String b = b(str);
        return (b == "" || this.c.remove((Object) b) == null) ? false : true;
    }

    public Future startCachingThread(URL url, String str, long j2) {
        if (url != null) {
            return this.f7261e.submit(new CacheAssetThread(url, str, j2));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        if (str.startsWith("//")) {
            str = "http:" + str;
        }
        try {
            return new URL(str).getFile();
        } catch (MalformedURLException unused) {
            TapjoyLog.e("TapjoyCache", "Invalid URL " + str);
            return "";
        }
    }

    private void a() {
        SharedPreferences sharedPreferences = this.b.getSharedPreferences(TapjoyConstants.PREF_TAPJOY_CACHE, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            File file = new File(entry.getKey());
            if (file.exists() && file.isFile()) {
                TapjoyCachedAssetData fromRawJSONString = TapjoyCachedAssetData.fromRawJSONString(entry.getValue().toString());
                if (fromRawJSONString != null) {
                    TapjoyLog.d("TapjoyCache", "Loaded Asset: " + fromRawJSONString.getAssetURL());
                    String b = b(fromRawJSONString.getAssetURL());
                    if (b != null && !"".equals(b) && b.length() > 0) {
                        if (fromRawJSONString.getTimeOfDeathInSeconds() < System.currentTimeMillis() / 1000) {
                            TapjoyLog.d("TapjoyCache", "Asset expired, removing from cache: " + fromRawJSONString.getAssetURL());
                            if (fromRawJSONString.getLocalFilePath() != null && fromRawJSONString.getLocalFilePath().length() > 0) {
                                TapjoyUtil.deleteFileOrDirectory(new File(fromRawJSONString.getLocalFilePath()));
                            }
                        } else {
                            this.c.put(b, fromRawJSONString);
                        }
                    } else {
                        TapjoyLog.e("TapjoyCache", "Removing asset because deserialization failed.");
                        edit.remove(entry.getKey()).apply();
                    }
                } else {
                    TapjoyLog.e("TapjoyCache", "Removing asset because deserialization failed.");
                    edit.remove(entry.getKey()).apply();
                }
            } else {
                TapjoyLog.d("TapjoyCache", "Removing reference to missing asset: " + entry.getKey());
                edit.remove(entry.getKey()).apply();
            }
        }
    }
}
