package com.bytedance.sdk.openadsdk.core.g;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.q;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.collection.Constants;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* compiled from: SdkDnsHelper.java */
/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicBoolean f1647d = new AtomicBoolean(false);
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    private static volatile e f1648e;
    private final d a;
    private final Context b;
    private final Executor c;

    /* compiled from: SdkDnsHelper.java */
    /* loaded from: classes.dex */
    private class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VdsAgent.onBroadcastReceiver(this, context, intent);
            if (intent != null && intent.getIntExtra("b_msg_id", -1) == 1) {
                String stringExtra = intent.getStringExtra("b_msg_data");
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(stringExtra);
                    if (e.this.a != null) {
                        e.this.a.a(jSONObject);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    private e(d dVar) {
        this.a = dVar == null ? o.h() : dVar;
        Context a2 = o.a();
        this.b = a2;
        this.c = Executors.newSingleThreadExecutor();
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            try {
                a2.registerReceiver(new a(), new IntentFilter("com.bytedance.openadsdk.dnsSettingReceiver"));
            } catch (Throwable unused) {
            }
        }
    }

    public void a() {
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!q.a(this.b)) {
            try {
                this.a.a();
                f1647d.set(false);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        new com.bytedance.sdk.adnet.b.f(0, a(null, null), (String) null, new m.a<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.g.e.1
            @Override // com.bytedance.sdk.adnet.core.m.a
            public void a(m<JSONObject> mVar) {
                JSONObject jSONObject;
                e.f1647d.set(false);
                if (mVar == null || (jSONObject = mVar.a) == null) {
                    try {
                        e.this.a.a();
                        return;
                    } catch (Throwable unused2) {
                        return;
                    }
                }
                JSONObject jSONObject2 = jSONObject;
                try {
                    e.this.a.a(jSONObject2);
                } catch (Throwable unused3) {
                }
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    e.a(jSONObject2.toString());
                }
            }

            @Override // com.bytedance.sdk.adnet.core.m.a
            public void b(m<JSONObject> mVar) {
                e.f1647d.set(false);
                try {
                    e.this.a.a();
                } catch (Throwable unused2) {
                }
            }
        }).setResponseOnMain(false).build(com.bytedance.sdk.openadsdk.g.d.a(this.b).d());
    }

    public static e a(d dVar) {
        if (f1648e == null) {
            synchronized (e.class) {
                if (f1648e == null) {
                    f1648e = new e(dVar);
                }
            }
        }
        return f1648e;
    }

    private String a(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer(Constants.HTTPS_PROTOCOL_PREFIX);
        if (!TextUtils.isEmpty(str)) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append("dig.bdurl.net");
        }
        stringBuffer.append("/q?host=");
        if (!TextUtils.isEmpty(str2)) {
            stringBuffer.append(str2);
        } else {
            stringBuffer.append("is.snssdk.com");
        }
        stringBuffer.append("&aid=");
        stringBuffer.append("1371");
        return stringBuffer.toString();
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str) || o.a() == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("com.bytedance.openadsdk.dnsSettingReceiver");
            intent.putExtra("b_msg_id", 1);
            intent.putExtra("b_msg_data", str);
            o.a().sendBroadcast(intent);
        } catch (Throwable unused) {
        }
    }
}
