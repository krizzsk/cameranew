package com.bytedance.sdk.openadsdk.f.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.c.i;
import com.bytedance.sdk.openadsdk.core.g.g;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;
/* compiled from: LogUploaderImpl.java */
/* loaded from: classes.dex */
public class c implements com.bytedance.sdk.openadsdk.f.b.a {
    private final List<a> b = Collections.synchronizedList(new LinkedList());
    private final ExecutorService c = Executors.newSingleThreadExecutor();
    private final b a = b.a();

    public static com.bytedance.sdk.openadsdk.f.b.a c() {
        return e.c();
    }

    @Override // com.bytedance.sdk.openadsdk.f.b.a
    public void a() {
        this.c.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.f.b.c.1
            @Override // java.lang.Runnable
            public void run() {
                List<a> d2 = c.this.a.d();
                if (d2 != null) {
                    c.this.b.addAll(d2);
                }
                c.this.a.c();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.f.b.a
    public void b() {
        ExecutorService executorService = this.c;
        if (executorService != null) {
            executorService.shutdownNow();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.f.b.a
    public void a(com.bytedance.sdk.openadsdk.f.a.a aVar) {
        a(aVar, false);
    }

    @Override // com.bytedance.sdk.openadsdk.f.b.a
    public void a(com.bytedance.sdk.openadsdk.f.a.a aVar, boolean z) {
        if (aVar == null || !g.a()) {
            return;
        }
        a aVar2 = new a(UUID.randomUUID().toString(), aVar.a());
        if (z) {
            o.e().a(aVar2);
        } else {
            o.d().a(aVar2);
        }
    }

    /* compiled from: LogUploaderImpl.java */
    /* loaded from: classes.dex */
    public static class a implements i {
        public final String a;
        public final JSONObject b;

        public a(String str, JSONObject jSONObject) {
            this.a = str;
            this.b = jSONObject;
        }

        public static a a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("localId", null);
                JSONObject optJSONObject = jSONObject.optJSONObject("event");
                if (!TextUtils.isEmpty(optString) && optJSONObject != null) {
                    return new a(optString, optJSONObject);
                }
            } catch (Throwable unused) {
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.c.i
        public String b() {
            return this.a;
        }

        public String a() {
            if (TextUtils.isEmpty(this.a) || this.b == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("localId", this.a);
                jSONObject.put("event", this.b);
            } catch (Throwable unused) {
            }
            return jSONObject.toString();
        }
    }
}
