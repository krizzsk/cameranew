package com.ironsource.environment;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.growingio.android.sdk.utils.NetworkUtil;
import java.io.DataOutputStream;
import java.lang.Thread;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;
import us.pinguo.common.network.HttpRequest;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* loaded from: classes2.dex */
public class CrashReporter {
    private JSONObject a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5339d;

    /* renamed from: e  reason: collision with root package name */
    private Context f5340e;

    /* renamed from: f  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f5341f;

    /* renamed from: g  reason: collision with root package name */
    private String f5342g;

    /* renamed from: h  reason: collision with root package name */
    private String f5343h;

    /* loaded from: classes2.dex */
    class a implements com.ironsource.environment.b {
        a(CrashReporter crashReporter) {
        }

        @Override // com.ironsource.environment.b
        public void a(ANRError aNRError) {
        }

        @Override // com.ironsource.environment.b
        public void b() {
        }
    }

    /* loaded from: classes2.dex */
    class b implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;

        b(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String[] d2 = e.d(this.a);
                if (d2.length == 2) {
                    if (!TextUtils.isEmpty(d2[0])) {
                        CrashReporter.this.b = d2[0];
                    }
                    CrashReporter.this.f5339d = Boolean.parseBoolean(d2[1]);
                    SharedPreferences.Editor edit = this.a.getSharedPreferences("CRep", 0).edit();
                    edit.putString("String1", CrashReporter.this.b);
                    edit.putString("sId", this.b);
                    edit.apply();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(CrashReporter.getInstance().f5342g).openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty(HttpRequest.HEADER_CONTENT_TYPE, "application/json;charset=UTF-8");
                httpURLConnection.setRequestProperty(HttpRequest.HEADER_ACCEPT, HttpRequest.CONTENT_TYPE_JSON);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                Log.i("JSON", CrashReporter.this.a.toString());
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.writeBytes(CrashReporter.this.a.toString());
                dataOutputStream.flush();
                dataOutputStream.close();
                Log.i("STATUS", String.valueOf(httpURLConnection.getResponseCode()));
                Log.i("MSG", httpURLConnection.getResponseMessage());
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class d {
        static volatile CrashReporter a = new CrashReporter(null);
    }

    /* synthetic */ CrashReporter(a aVar) {
        this();
    }

    private String f(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return PortalFollowFeeds.TYPE_NONE;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            return networkCapabilities == null ? PortalFollowFeeds.TYPE_NONE : networkCapabilities.hasTransport(1) ? "wifi" : networkCapabilities.hasTransport(0) ? "cellular" : PortalFollowFeeds.TYPE_NONE;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getTypeName().equalsIgnoreCase(NetworkUtil.NETWORK_WIFI)) {
                return "wifi";
            }
            if (activeNetworkInfo.getTypeName().equalsIgnoreCase("MOBILE")) {
                return "cellular";
            }
        }
        return PortalFollowFeeds.TYPE_NONE;
    }

    public static CrashReporter getInstance() {
        return d.a;
    }

    private void j(Context context, HashSet<String> hashSet) {
        String f2 = f(g());
        if (f2.equals(PortalFollowFeeds.TYPE_NONE)) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("CRep", 0);
        String string = sharedPreferences.getString("String1", this.b);
        String string2 = sharedPreferences.getString("sId", this.c);
        for (f fVar : DbHandler.t()) {
            String b2 = fVar.b();
            String d2 = fVar.d();
            String c2 = fVar.c();
            String packageName = context.getPackageName();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("crashDate", b2);
                jSONObject.put("stacktraceCrash", d2);
                jSONObject.put("crashType", c2);
                jSONObject.put("CrashReporterVersion", "1.0.2");
                jSONObject.put("SDKVersion", "7.1.6.1");
                jSONObject.put("deviceLanguage", e.n(context));
                jSONObject.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, com.ironsource.environment.c.h(context, packageName));
                jSONObject.put("deviceOSVersion", e.f());
                jSONObject.put("network", f2);
                jSONObject.put("deviceApiLevel", e.e());
                jSONObject.put("deviceModel", e.q());
                jSONObject.put("deviceOS", e.t());
                jSONObject.put("advertisingId", string);
                jSONObject.put("isLimitAdTrackingEnabled", this.f5339d);
                jSONObject.put("deviceOEM", e.r());
                jSONObject.put("systemProperties", System.getProperties());
                jSONObject.put("bundleId", packageName);
                jSONObject.put("sId", string2);
                JSONObject jSONObject2 = new JSONObject();
                if (hashSet != null && !hashSet.isEmpty()) {
                    Iterator<String> it = hashSet.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        try {
                            if (jSONObject.has(next)) {
                                jSONObject2.put(next, jSONObject.opt(next));
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    jSONObject = jSONObject2;
                }
                this.a = jSONObject;
            } catch (Exception unused) {
            }
            if (this.a.length() == 0) {
                Log.d("ISCrashReport", " Is Empty");
            } else {
                new Thread(new c()).start();
                DbHandler.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context g() {
        return this.f5340e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h() {
        return this.f5343h;
    }

    public void i(Context context, HashSet<String> hashSet, String str, String str2, boolean z, String str3, int i2) {
        if (context != null) {
            Log.d("automation_log", "init ISCrashReporter");
            this.f5340e = context;
            if (!TextUtils.isEmpty(str2)) {
                this.f5343h = str2;
            }
            if (!TextUtils.isEmpty(str)) {
                this.f5342g = str;
            }
            this.c = str3;
            if (z) {
                com.ironsource.environment.a aVar = new com.ironsource.environment.a(i2);
                aVar.e(true);
                aVar.d(new a(this));
                aVar.start();
            }
            j(context, hashSet);
            new Thread(new b(context, str3)).start();
        }
    }

    private CrashReporter() {
        this.f5339d = false;
        this.a = new JSONObject();
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        this.f5341f = defaultUncaughtExceptionHandler;
        this.f5343h = " ";
        this.f5342g = "https://outcome-crash-report.supersonicads.com/reporter";
        Thread.setDefaultUncaughtExceptionHandler(new com.ironsource.environment.d(defaultUncaughtExceptionHandler));
    }
}
