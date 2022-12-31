package com.facebook.internal.instrument.d;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.f;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.c;
import com.facebook.internal.x;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.json.JSONArray;
import org.json.JSONException;
/* compiled from: CrashHandler.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class a implements Thread.UncaughtExceptionHandler {
    private static final String b = a.class.getCanonicalName();
    @Nullable
    private static a c;
    @Nullable
    private final Thread.UncaughtExceptionHandler a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CrashHandler.java */
    /* renamed from: com.facebook.internal.instrument.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0110a implements Comparator<InstrumentData> {
        C0110a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(InstrumentData instrumentData, InstrumentData instrumentData2) {
            return instrumentData.b(instrumentData2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CrashHandler.java */
    /* loaded from: classes.dex */
    public static class b implements GraphRequest.e {
        final /* synthetic */ ArrayList a;

        b(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // com.facebook.GraphRequest.e
        public void a(GraphResponse graphResponse) {
            try {
                if (graphResponse.g() == null && graphResponse.h().getBoolean(FirebaseAnalytics.Param.SUCCESS)) {
                    for (int i2 = 0; this.a.size() > i2; i2++) {
                        ((InstrumentData) this.a.get(i2)).a();
                    }
                }
            } catch (JSONException unused) {
            }
        }
    }

    private a(@Nullable Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = uncaughtExceptionHandler;
    }

    public static synchronized void a() {
        synchronized (a.class) {
            if (f.k()) {
                b();
            }
            if (c != null) {
                Log.w(b, "Already enabled!");
                return;
            }
            a aVar = new a(Thread.getDefaultUncaughtExceptionHandler());
            c = aVar;
            Thread.setDefaultUncaughtExceptionHandler(aVar);
        }
    }

    private static void b() {
        if (x.Q()) {
            return;
        }
        File[] g2 = c.g();
        ArrayList arrayList = new ArrayList();
        for (File file : g2) {
            InstrumentData c2 = InstrumentData.b.c(file);
            if (c2.g()) {
                arrayList.add(c2);
            }
        }
        Collections.sort(arrayList, new C0110a());
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < arrayList.size() && i2 < 5; i2++) {
            jSONArray.put(arrayList.get(i2));
        }
        c.i("crash_reports", jSONArray, new b(arrayList));
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (c.e(th)) {
            com.facebook.internal.instrument.a.b(th);
            InstrumentData.b.a(th, InstrumentData.Type.CrashReport).h();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
