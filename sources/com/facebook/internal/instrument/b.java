package com.facebook.internal.instrument;

import androidx.annotation.RestrictTo;
import com.facebook.f;
import com.facebook.internal.FeatureManager;
/* compiled from: InstrumentManager.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InstrumentManager.java */
    /* loaded from: classes.dex */
    public static class a implements FeatureManager.c {
        a() {
        }

        @Override // com.facebook.internal.FeatureManager.c
        public void a(boolean z) {
            if (z) {
                com.facebook.internal.instrument.d.a.a();
                if (FeatureManager.g(FeatureManager.Feature.CrashShield)) {
                    com.facebook.internal.instrument.a.a();
                    com.facebook.internal.instrument.e.a.a();
                }
                if (FeatureManager.g(FeatureManager.Feature.ThreadCheck)) {
                    com.facebook.internal.instrument.g.a.a();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InstrumentManager.java */
    /* renamed from: com.facebook.internal.instrument.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0109b implements FeatureManager.c {
        C0109b() {
        }

        @Override // com.facebook.internal.FeatureManager.c
        public void a(boolean z) {
            if (z) {
                com.facebook.internal.instrument.f.b.a();
            }
        }
    }

    public static void a() {
        if (f.k()) {
            FeatureManager.a(FeatureManager.Feature.CrashReport, new a());
            FeatureManager.a(FeatureManager.Feature.ErrorReport, new C0109b());
        }
    }
}
