package com.facebook.internal.instrument.f;

import androidx.annotation.RestrictTo;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.f;
import com.facebook.internal.x;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.json.JSONArray;
import org.json.JSONException;
/* compiled from: ErrorReportHandler.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ErrorReportHandler.java */
    /* loaded from: classes.dex */
    public static class a implements Comparator<com.facebook.internal.instrument.f.a> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.facebook.internal.instrument.f.a aVar, com.facebook.internal.instrument.f.a aVar2) {
            return aVar.b(aVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ErrorReportHandler.java */
    /* renamed from: com.facebook.internal.instrument.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0111b implements GraphRequest.e {
        final /* synthetic */ ArrayList a;

        C0111b(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // com.facebook.GraphRequest.e
        public void a(GraphResponse graphResponse) {
            try {
                if (graphResponse.g() == null && graphResponse.h().getBoolean(FirebaseAnalytics.Param.SUCCESS)) {
                    for (int i2 = 0; this.a.size() > i2; i2++) {
                        ((com.facebook.internal.instrument.f.a) this.a.get(i2)).a();
                    }
                }
            } catch (JSONException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ErrorReportHandler.java */
    /* loaded from: classes.dex */
    public static class c implements FilenameFilter {
        c() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.matches(String.format("^%s[0-9]+.json$", "error_log_"));
        }
    }

    public static void a() {
        if (f.k()) {
            d();
        }
    }

    public static File[] b() {
        File c2 = com.facebook.internal.instrument.c.c();
        return c2 == null ? new File[0] : c2.listFiles(new c());
    }

    public static void c(String str) {
        try {
            new com.facebook.internal.instrument.f.a(str).e();
        } catch (Exception unused) {
        }
    }

    public static void d() {
        if (x.Q()) {
            return;
        }
        File[] b = b();
        ArrayList arrayList = new ArrayList();
        for (File file : b) {
            com.facebook.internal.instrument.f.a aVar = new com.facebook.internal.instrument.f.a(file);
            if (aVar.d()) {
                arrayList.add(aVar);
            }
        }
        Collections.sort(arrayList, new a());
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < arrayList.size() && i2 < 1000; i2++) {
            jSONArray.put(arrayList.get(i2));
        }
        com.facebook.internal.instrument.c.i("error_reports", jSONArray, new C0111b(arrayList));
    }
}
