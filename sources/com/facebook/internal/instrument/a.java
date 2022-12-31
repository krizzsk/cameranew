package com.facebook.internal.instrument;

import androidx.annotation.RestrictTo;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.f;
import com.facebook.i;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.x;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ExceptionAnalyzer.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class a {
    private static boolean a = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ExceptionAnalyzer.java */
    /* renamed from: com.facebook.internal.instrument.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0108a implements GraphRequest.e {
        final /* synthetic */ InstrumentData a;

        C0108a(InstrumentData instrumentData) {
            this.a = instrumentData;
        }

        @Override // com.facebook.GraphRequest.e
        public void a(GraphResponse graphResponse) {
            try {
                if (graphResponse.g() == null && graphResponse.h().getBoolean(FirebaseAnalytics.Param.SUCCESS)) {
                    this.a.a();
                }
            } catch (JSONException unused) {
            }
        }
    }

    public static void a() {
        a = true;
        if (f.k()) {
            c();
        }
    }

    public static void b(Throwable th) {
        if (a) {
            HashSet hashSet = new HashSet();
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                FeatureManager.Feature d2 = FeatureManager.d(stackTraceElement.getClassName());
                if (d2 != FeatureManager.Feature.Unknown) {
                    FeatureManager.c(d2);
                    hashSet.add(d2.toString());
                }
            }
            if (!f.k() || hashSet.isEmpty()) {
                return;
            }
            InstrumentData.b.b(new JSONArray((Collection) hashSet)).h();
        }
    }

    private static void c() {
        if (x.Q()) {
            return;
        }
        File[] f2 = c.f();
        ArrayList arrayList = new ArrayList();
        for (File file : f2) {
            InstrumentData c = InstrumentData.b.c(file);
            if (c.g()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("crash_shield", c.toString());
                    arrayList.add(GraphRequest.K(null, String.format("%s/instruments", f.g()), jSONObject, new C0108a(c)));
                } catch (JSONException unused) {
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        new i(arrayList).f();
    }
}
