package com.bytedance.sdk.openadsdk.core.g;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.w;
import com.coremedia.iso.boxes.UserBox;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tapjoy.TapjoyConstants;
import com.tencent.stat.DeviceInfo;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import us.pinguo.bigalbum.db.BigAlbumStore;
/* compiled from: SdkSettingsHelper.java */
/* loaded from: classes.dex */
public class f implements Runnable {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    private static volatile f f1650e;
    private final d a;
    private final Context b;
    private final Executor c;

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicLong f1649d = new AtomicLong(0);

    /* renamed from: f  reason: collision with root package name */
    private static volatile boolean f1651f = false;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f1652g = true;

    /* compiled from: SdkSettingsHelper.java */
    /* loaded from: classes.dex */
    private class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VdsAgent.onBroadcastReceiver(this, context, intent);
            if (intent == null) {
                return;
            }
            int intExtra = intent.getIntExtra("b_msg_id", -1);
            if (intExtra == 1) {
                long longExtra = intent.getLongExtra("b_msg_time", -1L);
                if (longExtra > 0) {
                    f.f1649d.set(longExtra);
                }
            } else if (intExtra == 2) {
                try {
                    if (f.this.a != null) {
                        f.this.a.a();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    private f(d dVar) {
        this.a = dVar == null ? o.h() : dVar;
        Context a2 = o.a();
        this.b = a2;
        this.c = Executors.newSingleThreadExecutor();
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            try {
                a2.registerReceiver(new a(), new IntentFilter("com.bytedance.openadsdk.settingReceiver"));
            } catch (Throwable unused) {
            }
        }
    }

    public static void b() {
        if (o.a() != null) {
            try {
                Intent intent = new Intent();
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 2);
                o.a().sendBroadcast(intent);
            } catch (Throwable unused) {
            }
        }
    }

    private boolean f() {
        return TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.h.b().c());
    }

    @NonNull
    private JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        int i2 = 1;
        ab.a(jSONObject, true);
        try {
            int f2 = com.bytedance.sdk.openadsdk.core.h.b().f();
            com.bytedance.sdk.openadsdk.utils.o.b("setting", "Settings().isGdprUser =" + o.h().u());
            int u = o.h().u();
            if (u != -1) {
                if (u == 0) {
                    a(jSONObject);
                } else if (u == 1 && f2 == 0) {
                    b(jSONObject);
                }
            } else if (ab.m()) {
                if (f2 == 0) {
                    a(jSONObject);
                }
            } else if (f2 == 0 || f2 == -1) {
                a(jSONObject);
            }
            jSONObject.put("gdpr", f2);
            jSONObject.put("coppa", com.bytedance.sdk.openadsdk.core.h.b().e());
            jSONObject.put("MCC", w.b());
            jSONObject.put("conn_type", q.c(this.b));
            jSONObject.put("os", 1);
            jSONObject.put("oversea_version_type", 1);
            jSONObject.put(TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, String.valueOf(Build.VERSION.RELEASE));
            jSONObject.put("sdk_version", "3.1.5.4");
            jSONObject.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, com.bytedance.sdk.openadsdk.core.j.a());
            jSONObject.put("time_zone", ab.o());
            jSONObject.put("package_name", ab.f());
            boolean c = ab.c(this.b, ab.f());
            com.bytedance.sdk.openadsdk.utils.o.c("isApplicationForeground", "isApplicationForeground:" + c);
            if (!c) {
                i2 = 2;
            }
            jSONObject.put("position", i2);
            jSONObject.put(TapjoyConstants.TJC_APP_VERSION_NAME, ab.h());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put(TapjoyConstants.TJC_ANDROID_ID, com.bytedance.sdk.openadsdk.core.j.c(this.b));
            jSONObject.put(UserBox.TYPE, com.bytedance.sdk.openadsdk.core.j.d(this.b));
            if (com.bytedance.sdk.openadsdk.core.h.b() != null && com.bytedance.sdk.openadsdk.core.h.b().c() != null) {
                jSONObject.put(TapjoyConstants.TJC_APP_ID, com.bytedance.sdk.openadsdk.core.h.b().c());
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put(DeviceInfo.TAG_TIMESTAMPS, currentTimeMillis);
            String str = "";
            if (com.bytedance.sdk.openadsdk.core.h.b() != null && com.bytedance.sdk.openadsdk.core.h.b().c() != null) {
                str = com.bytedance.sdk.openadsdk.core.h.b().c().concat(String.valueOf(currentTimeMillis)).concat("3.1.5.4");
            }
            jSONObject.put("req_sign", com.bytedance.sdk.openadsdk.utils.h.a(str));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public void c() {
        try {
            if (f()) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            AtomicLong atomicLong = f1649d;
            if (currentTimeMillis - atomicLong.get() < 600000) {
                return;
            }
            atomicLong.set(currentTimeMillis);
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                a(currentTimeMillis);
            }
            this.c.execute(this);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.a("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!q.a(this.b)) {
            try {
                this.a.a();
            } catch (Throwable unused) {
            }
        } else if (f()) {
        } else {
            new com.bytedance.sdk.adnet.b.f(1, ab.i("/api/ad/union/sdk/settings/"), c(g()), new m.a<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.g.f.1
                /* JADX WARN: Can't wrap try/catch for region: R(13:4|(12:6|(2:29|30)|8|9|(1:11)(1:27)|12|14|15|(1:17)|18|19|(2:21|22)(1:24))(12:35|(2:37|(2:39|40))(1:44)|8|9|(0)(0)|12|14|15|(0)|18|19|(0)(0))|31|8|9|(0)(0)|12|14|15|(0)|18|19|(0)(0)) */
                /* JADX WARN: Removed duplicated region for block: B:24:0x0093  */
                /* JADX WARN: Removed duplicated region for block: B:25:0x0094 A[Catch: all -> 0x009b, TryCatch #2 {all -> 0x009b, blocks: (B:22:0x008f, B:26:0x0096, B:25:0x0094), top: B:45:0x008f }] */
                /* JADX WARN: Removed duplicated region for block: B:29:0x00a1 A[Catch: all -> 0x00ae, TryCatch #3 {all -> 0x00ae, blocks: (B:27:0x009b, B:29:0x00a1, B:30:0x00a4), top: B:47:0x009b }] */
                /* JADX WARN: Removed duplicated region for block: B:35:0x00b5  */
                /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
                @Override // com.bytedance.sdk.adnet.core.m.a
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void a(com.bytedance.sdk.adnet.core.m<org.json.JSONObject> r9) {
                    /*
                        r8 = this;
                        if (r9 == 0) goto Lb9
                        T r0 = r9.a
                        if (r0 == 0) goto Lb9
                        org.json.JSONObject r0 = (org.json.JSONObject) r0
                        r1 = -1
                        java.lang.String r2 = "cypher"
                        int r0 = r0.optInt(r2, r1)
                        T r1 = r9.a
                        r2 = r1
                        org.json.JSONObject r2 = (org.json.JSONObject) r2
                        java.lang.String r3 = "message"
                        r4 = 1
                        r5 = 0
                        java.lang.String r6 = "SdkSettingsHelper"
                        if (r0 != r4) goto L55
                        org.json.JSONObject r1 = (org.json.JSONObject) r1
                        java.lang.String r0 = r1.optString(r3)
                        java.lang.String r1 = com.bytedance.sdk.openadsdk.core.b.a()
                        java.lang.String r0 = com.bytedance.sdk.openadsdk.core.a.b(r0, r1)
                        boolean r1 = android.text.TextUtils.isEmpty(r0)
                        if (r1 != 0) goto L8f
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4e
                        r1.<init>()     // Catch: java.lang.Throwable -> L4e
                        java.lang.String r3 = "setting data : "
                        r1.append(r3)     // Catch: java.lang.Throwable -> L4e
                        java.lang.String r3 = r0.toString()     // Catch: java.lang.Throwable -> L4e
                        r1.append(r3)     // Catch: java.lang.Throwable -> L4e
                        java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L4e
                        com.bytedance.sdk.openadsdk.utils.o.b(r6, r1)     // Catch: java.lang.Throwable -> L4e
                        org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L4e
                        r1.<init>(r0)     // Catch: java.lang.Throwable -> L4e
                        goto L85
                    L4e:
                        r1 = move-exception
                        java.lang.String r3 = "setting data error: "
                        com.bytedance.sdk.openadsdk.utils.o.a(r6, r3, r1)
                        goto L8f
                    L55:
                        r7 = 2
                        if (r0 != r7) goto L8e
                        org.json.JSONObject r1 = (org.json.JSONObject) r1
                        java.lang.String r0 = r1.optString(r3)
                        java.lang.String r0 = com.bytedance.sdk.openadsdk.utils.ab.k(r0)
                        boolean r1 = android.text.TextUtils.isEmpty(r0)
                        if (r1 != 0) goto L8f
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L87
                        r1.<init>()     // Catch: java.lang.Throwable -> L87
                        java.lang.String r3 = "setting data1 : "
                        r1.append(r3)     // Catch: java.lang.Throwable -> L87
                        java.lang.String r3 = r0.toString()     // Catch: java.lang.Throwable -> L87
                        r1.append(r3)     // Catch: java.lang.Throwable -> L87
                        java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L87
                        com.bytedance.sdk.openadsdk.utils.o.b(r6, r1)     // Catch: java.lang.Throwable -> L87
                        org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L87
                        r1.<init>(r0)     // Catch: java.lang.Throwable -> L87
                    L85:
                        r2 = r1
                        goto L8f
                    L87:
                        r1 = move-exception
                        java.lang.String r3 = "setting data error2: "
                        com.bytedance.sdk.openadsdk.utils.o.a(r6, r3, r1)
                        goto L8f
                    L8e:
                        r0 = r5
                    L8f:
                        com.bytedance.sdk.adnet.face.a$a r9 = r9.b     // Catch: java.lang.Throwable -> L9b
                        if (r9 != 0) goto L94
                        goto L96
                    L94:
                        java.util.Map<java.lang.String, java.lang.String> r5 = r9.f1265h     // Catch: java.lang.Throwable -> L9b
                    L96:
                        com.bytedance.sdk.openadsdk.core.g.f r9 = com.bytedance.sdk.openadsdk.core.g.f.this     // Catch: java.lang.Throwable -> L9b
                        com.bytedance.sdk.openadsdk.core.g.f.a(r9, r0, r5)     // Catch: java.lang.Throwable -> L9b
                    L9b:
                        boolean r9 = com.bytedance.sdk.openadsdk.core.g.f.e()     // Catch: java.lang.Throwable -> Lae
                        if (r9 != 0) goto La4
                        com.bytedance.sdk.openadsdk.core.g.f.a(r4)     // Catch: java.lang.Throwable -> Lae
                    La4:
                        com.bytedance.sdk.openadsdk.core.g.f r9 = com.bytedance.sdk.openadsdk.core.g.f.this     // Catch: java.lang.Throwable -> Lae
                        com.bytedance.sdk.openadsdk.core.g.d r9 = com.bytedance.sdk.openadsdk.core.g.f.a(r9)     // Catch: java.lang.Throwable -> Lae
                        r9.a(r2)     // Catch: java.lang.Throwable -> Lae
                        goto Laf
                    Lae:
                    Laf:
                        boolean r9 = com.bytedance.sdk.openadsdk.multipro.b.b()
                        if (r9 == 0) goto Lb8
                        com.bytedance.sdk.openadsdk.core.g.f.b()
                    Lb8:
                        return
                    Lb9:
                        com.bytedance.sdk.openadsdk.core.g.f r9 = com.bytedance.sdk.openadsdk.core.g.f.this     // Catch: java.lang.Throwable -> Lc2
                        com.bytedance.sdk.openadsdk.core.g.d r9 = com.bytedance.sdk.openadsdk.core.g.f.a(r9)     // Catch: java.lang.Throwable -> Lc2
                        r9.a()     // Catch: java.lang.Throwable -> Lc2
                    Lc2:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.g.f.AnonymousClass1.a(com.bytedance.sdk.adnet.core.m):void");
                }

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void b(m<JSONObject> mVar) {
                    try {
                        f.this.a.a();
                    } catch (Throwable unused2) {
                    }
                }
            }).setResponseOnMain(false).build(com.bytedance.sdk.openadsdk.g.d.a(this.b).d());
        }
    }

    public static f a(d dVar) {
        if (f1650e == null) {
            synchronized (f.class) {
                if (f1650e == null) {
                    f1650e = new f(dVar);
                }
            }
        }
        return f1650e;
    }

    private void b(JSONObject jSONObject) throws JSONException {
        jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, com.bytedance.sdk.openadsdk.utils.g.a(true));
        jSONObject.put(BigAlbumStore.PhotoTagColumns.MODEL, Build.MODEL);
        jSONObject.put("device_city", ab.k());
        jSONObject.put("gaid", d.a.a.a.a.b.a.a().e());
    }

    private JSONObject c(JSONObject jSONObject) {
        return f1652g ? ab.a(jSONObject) : jSONObject;
    }

    public static void a() {
        File file;
        try {
            Context a2 = o.a();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 24) {
                file = new File(a2.getDataDir(), "shared_prefs");
            } else {
                file = new File(a2.getDatabasePath("1").getParentFile().getParentFile(), "shared_prefs");
            }
            File file2 = new File(file, "tt_sdk_settings.xml");
            if (file2.exists() && file2.isFile()) {
                String replace = file2.getName().replace(".xml", "");
                if (i2 >= 24) {
                    a2.deleteSharedPreferences(replace);
                    return;
                }
                a2.getSharedPreferences(replace, 0).edit().clear().apply();
                com.bytedance.sdk.openadsdk.utils.i.c(file2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(long j2) {
        if (j2 > 0 && o.a() != null) {
            try {
                Intent intent = new Intent();
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 1);
                intent.putExtra("b_msg_time", j2);
                o.a().sendBroadcast(intent);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Map<String, String> map) {
        int i2 = 1;
        try {
            if (!TextUtils.isEmpty(str) && map != null) {
                int intValue = Integer.valueOf(map.get("active-control")).intValue();
                long longValue = Long.valueOf(map.get(DeviceInfo.TAG_TIMESTAMPS)).longValue();
                String str2 = map.get("pst");
                String a2 = com.bytedance.sdk.openadsdk.h.g.b.a(str + intValue + longValue);
                if (a2 != null) {
                    if (a2.equalsIgnoreCase(str2)) {
                        i2 = intValue;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        g.a(i2);
    }

    private void a(JSONObject jSONObject) throws JSONException {
        if (com.bytedance.sdk.openadsdk.core.h.b() == null || com.bytedance.sdk.openadsdk.core.h.b().g() == 1) {
            return;
        }
        jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, com.bytedance.sdk.openadsdk.utils.g.a(true));
        jSONObject.put(BigAlbumStore.PhotoTagColumns.MODEL, Build.MODEL);
        jSONObject.put("device_city", ab.k());
        jSONObject.put("gaid", d.a.a.a.a.b.a.a().e());
    }
}
