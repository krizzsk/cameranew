package com.bytedance.sdk.adnet.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.c.f;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.d.c;
import com.bytedance.sdk.adnet.d.e;
import com.bytedance.sdk.adnet.d.g;
import com.bytedance.sdk.adnet.d.h;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.collection.Constants;
import com.tencent.stat.DeviceInfo;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import us.pinguo.bigalbum.db.BigAlbumStore;
/* compiled from: AppConfig.java */
/* loaded from: classes.dex */
public class a implements com.bytedance.sdk.adnet.c.a, h.a {
    private static a b;
    private final boolean c;

    /* renamed from: j  reason: collision with root package name */
    private final Context f1167j;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f1161d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1162e = true;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1163f = false;

    /* renamed from: g  reason: collision with root package name */
    private long f1164g = 0;

    /* renamed from: h  reason: collision with root package name */
    private long f1165h = 0;

    /* renamed from: i  reason: collision with root package name */
    private AtomicBoolean f1166i = new AtomicBoolean(false);

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f1168k = false;
    final h a = new h(Looper.getMainLooper(), this);

    private a(Context context, boolean z) {
        this.f1167j = context;
        this.c = z;
    }

    private void d(boolean z) {
        if (this.f1163f) {
            return;
        }
        if (this.f1162e) {
            this.f1162e = false;
            this.f1164g = 0L;
            this.f1165h = 0L;
        }
        long j2 = z ? 10800000L : 43200000L;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f1164g <= j2 || currentTimeMillis - this.f1165h <= 120000) {
            return;
        }
        boolean a = e.a(this.f1167j);
        if (!this.f1168k || a) {
            b(a);
        }
    }

    private boolean e() {
        String[] d2 = d();
        if (d2 != null && d2.length != 0) {
            a(0);
        }
        return false;
    }

    public synchronized void c() {
        if (this.f1168k) {
            return;
        }
        this.f1168k = true;
        long j2 = this.f1167j.getSharedPreferences("ss_app_config", 0).getLong("last_refresh_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (j2 > currentTimeMillis) {
            j2 = currentTimeMillis;
        }
        this.f1164g = j2;
        if (f.a().e() != null) {
            f.a().e().a();
        }
    }

    public static void b(Context context) {
        a aVar = b;
        if (aVar != null) {
            if (com.bytedance.sdk.adnet.d.f.b(context)) {
                aVar.a(true);
            } else {
                aVar.a();
            }
        }
    }

    public static a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (b == null) {
                a aVar2 = new a(context.getApplicationContext(), com.bytedance.sdk.adnet.d.f.b(context));
                b = aVar2;
                com.bytedance.sdk.adnet.a.a(aVar2);
            }
            aVar = b;
        }
        return aVar;
    }

    synchronized void b() {
        if (System.currentTimeMillis() - this.f1164g > 3600000) {
            this.f1164g = System.currentTimeMillis();
            try {
                if (f.a().e() != null) {
                    f.a().e().b();
                }
            } catch (Exception unused) {
            }
        }
    }

    public void a() {
        a(false);
    }

    public synchronized void a(boolean z) {
        if (this.c) {
            d(z);
        } else if (this.f1164g <= 0) {
            try {
                new Thread("LoadDomainConfig4Other-Thread") { // from class: com.bytedance.sdk.adnet.a.a.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        a.this.b();
                    }
                }.start();
            } catch (Throwable unused) {
            }
        }
    }

    void c(boolean z) {
        c.b("TNCManager", "doRefresh, actual request");
        c();
        this.f1163f = true;
        if (!z) {
            this.a.sendEmptyMessage(102);
            return;
        }
        try {
            e();
        } catch (Exception unused) {
            this.f1166i.set(false);
        }
    }

    public boolean b(final boolean z) {
        c.b("TNCManager", "doRefresh: updating state " + this.f1166i.get());
        if (!this.f1166i.compareAndSet(false, true)) {
            c.b("TNCManager", "doRefresh, already running");
            return false;
        }
        if (z) {
            this.f1165h = System.currentTimeMillis();
        }
        new Thread("AppConfigThread") { // from class: com.bytedance.sdk.adnet.a.a.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                a.this.c(z);
            }
        }.start();
        return true;
    }

    public String[] d() {
        String[] f2 = com.bytedance.sdk.adnet.a.a().f();
        return (f2 == null || f2.length <= 0) ? new String[0] : f2;
    }

    @Override // com.bytedance.sdk.adnet.d.h.a
    public void a(Message message) {
        int i2 = message.what;
        if (i2 == 101) {
            this.f1163f = false;
            this.f1164g = System.currentTimeMillis();
            c.b("TNCManager", "doRefresh, succ");
            if (this.f1162e) {
                a();
            }
            this.f1166i.set(false);
        } else if (i2 != 102) {
        } else {
            this.f1163f = false;
            if (this.f1162e) {
                a();
            }
            c.b("TNCManager", "doRefresh, error");
            this.f1166i.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        h hVar = this.a;
        if (hVar != null) {
            hVar.sendEmptyMessage(i2);
        }
    }

    private String b(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Address a = com.bytedance.sdk.adnet.a.a().a(this.f1167j);
        g gVar = new g(Constants.HTTPS_PROTOCOL_PREFIX + str + "/get_domains/v4/");
        if (a != null && a.hasLatitude() && a.hasLongitude()) {
            gVar.a(BigAlbumStore.PhotoColumns.LATITUDE, a.getLatitude());
            gVar.a(BigAlbumStore.PhotoColumns.LONGITUDE, a.getLongitude());
            String locality = a.getLocality();
            if (!TextUtils.isEmpty(locality)) {
                gVar.a(BigAlbumStore.PhotoAddressColumns.CITY, Uri.encode(locality));
            }
        }
        if (this.f1161d) {
            gVar.a("force", 1);
        }
        try {
            if (Build.VERSION.SDK_INT < 21) {
                str2 = Build.CPU_ABI;
            } else {
                str2 = Build.SUPPORTED_ABIS[0];
            }
            gVar.a("abi", str2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        gVar.a(DeviceInfo.TAG_ANDROID_ID, com.bytedance.sdk.adnet.a.a().a());
        gVar.a(ParamKeyConstants.WebViewConstants.QUERY_PLATFORM, com.bytedance.sdk.adnet.a.a().c());
        gVar.a("channel", com.bytedance.sdk.adnet.a.a().b());
        gVar.a("version_code", com.bytedance.sdk.adnet.a.a().d());
        gVar.a("custom_info_1", com.bytedance.sdk.adnet.a.a().e());
        return gVar.toString();
    }

    @Override // com.bytedance.sdk.adnet.c.a
    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            try {
                return f.a().a(str);
            } catch (Throwable unused) {
                return str;
            }
        }
        try {
            if (this.c) {
                c();
            } else {
                b();
            }
            return f.a().a(str);
        } catch (Throwable unused2) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Object obj) throws Exception {
        JSONObject jSONObject;
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            jSONObject = new JSONObject(str);
            if (!FirebaseAnalytics.Param.SUCCESS.equals(jSONObject.getString("message"))) {
                return false;
            }
        } else {
            jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
        }
        if (jSONObject == null) {
            return false;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        synchronized (this) {
            SharedPreferences.Editor edit = this.f1167j.getSharedPreferences("ss_app_config", 0).edit();
            edit.putLong("last_refresh_time", System.currentTimeMillis());
            edit.apply();
        }
        if (f.a().e() != null) {
            f.a().e().a(jSONObject2);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i2) {
        String[] d2 = d();
        if (d2 != null && d2.length > i2) {
            String str = d2[i2];
            if (TextUtils.isEmpty(str)) {
                b(102);
                return;
            }
            try {
                String b2 = b(str);
                if (TextUtils.isEmpty(b2)) {
                    b(102);
                    return;
                } else {
                    new com.bytedance.sdk.adnet.b.f(0, b2, new JSONObject(), new m.a<JSONObject>() { // from class: com.bytedance.sdk.adnet.a.a.3
                        @Override // com.bytedance.sdk.adnet.core.m.a
                        public void a(m<JSONObject> mVar) {
                            JSONObject jSONObject = mVar.a;
                            if (jSONObject == null) {
                                a.this.a(i2 + 1);
                                return;
                            }
                            String str2 = null;
                            try {
                                str2 = jSONObject.getString("message");
                            } catch (Exception unused) {
                            }
                            if (!FirebaseAnalytics.Param.SUCCESS.equals(str2)) {
                                a.this.a(i2 + 1);
                                return;
                            }
                            try {
                                if (a.this.a(jSONObject)) {
                                    a.this.b(101);
                                } else {
                                    a.this.a(i2 + 1);
                                }
                            } catch (Exception unused2) {
                            }
                        }

                        @Override // com.bytedance.sdk.adnet.core.m.a
                        public void b(m<JSONObject> mVar) {
                            a.this.a(i2 + 1);
                        }
                    }).setRetryPolicy(new com.bytedance.sdk.adnet.core.e().a(10000).b(0)).build(com.bytedance.sdk.adnet.a.a(this.f1167j));
                    return;
                }
            } catch (Throwable th) {
                c.b("AppConfig", "try app config exception: " + th);
                return;
            }
        }
        b(102);
    }
}
