package com.facebook.internal.logging.monitor;

import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.GraphRequest;
import com.facebook.f;
import com.facebook.i;
import com.facebook.internal.logging.ExternalLog;
import com.facebook.internal.x;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: MonitorLoggingManager.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class b implements com.facebook.internal.logging.b {

    /* renamed from: e  reason: collision with root package name */
    private static b f3068e;
    private com.facebook.internal.logging.a a;
    private com.facebook.internal.logging.c b;
    private ScheduledFuture c;

    /* renamed from: d  reason: collision with root package name */
    private static final Integer f3067d = 100;

    /* renamed from: f  reason: collision with root package name */
    private static String f3069f = Build.VERSION.RELEASE;

    /* renamed from: g  reason: collision with root package name */
    private static String f3070g = Build.MODEL;

    private b(com.facebook.internal.logging.a aVar, com.facebook.internal.logging.c cVar) {
        Executors.newSingleThreadScheduledExecutor();
        if (this.a == null) {
            this.a = aVar;
        }
        if (this.b == null) {
            this.b = cVar;
        }
    }

    @Nullable
    static GraphRequest b(List<? extends ExternalLog> list) {
        String packageName = f.f().getPackageName();
        JSONArray jSONArray = new JSONArray();
        for (ExternalLog externalLog : list) {
            jSONArray.put(externalLog.convertToJSONObject());
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_os_version", f3069f);
            jSONObject.put("device_model", f3070g);
            jSONObject.put("unique_application_identifier", packageName);
            jSONObject.put(RemoteConfigConstants.ResponseFieldKey.ENTRIES, jSONArray.toString());
            return GraphRequest.K(null, String.format("%s/monitorings", f.g()), jSONObject, null);
        } catch (JSONException unused) {
            return null;
        }
    }

    static List<GraphRequest> c(com.facebook.internal.logging.a aVar) {
        ArrayList arrayList = new ArrayList();
        if (x.S(f.g())) {
            return arrayList;
        }
        while (!aVar.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < f3067d.intValue() && !aVar.isEmpty(); i2++) {
                arrayList2.add(aVar.b());
            }
            GraphRequest b = b(arrayList2);
            if (b != null) {
                arrayList.add(b);
            }
        }
        return arrayList;
    }

    public static synchronized b e(com.facebook.internal.logging.a aVar, com.facebook.internal.logging.c cVar) {
        b bVar;
        synchronized (b.class) {
            if (f3068e == null) {
                f3068e = new b(aVar, cVar);
            }
            bVar = f3068e;
        }
        return bVar;
    }

    @Override // com.facebook.internal.logging.b
    public void a() {
        this.a.a(this.b.a());
        d();
    }

    public void d() {
        ScheduledFuture scheduledFuture = this.c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        try {
            new i(c(this.a)).f();
        } catch (Exception unused) {
        }
    }
}
