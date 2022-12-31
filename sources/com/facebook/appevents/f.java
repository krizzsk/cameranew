package com.facebook.appevents;

import androidx.annotation.RestrictTo;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.l;
/* compiled from: AppEventsManager.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class f {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppEventsManager.java */
    /* loaded from: classes.dex */
    public static class a implements FetchedAppSettingsManager.d {

        /* compiled from: AppEventsManager.java */
        /* renamed from: com.facebook.appevents.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0075a implements FeatureManager.c {
            C0075a(a aVar) {
            }

            @Override // com.facebook.internal.FeatureManager.c
            public void a(boolean z) {
                if (z) {
                    com.facebook.appevents.j.a.c();
                }
            }
        }

        /* compiled from: AppEventsManager.java */
        /* loaded from: classes.dex */
        class b implements FeatureManager.c {
            b(a aVar) {
            }

            @Override // com.facebook.internal.FeatureManager.c
            public void a(boolean z) {
                if (z) {
                    com.facebook.appevents.m.a.a();
                }
            }
        }

        /* compiled from: AppEventsManager.java */
        /* loaded from: classes.dex */
        class c implements FeatureManager.c {
            c(a aVar) {
            }

            @Override // com.facebook.internal.FeatureManager.c
            public void a(boolean z) {
                if (z) {
                    ModelManager.g();
                }
            }
        }

        /* compiled from: AppEventsManager.java */
        /* loaded from: classes.dex */
        class d implements FeatureManager.c {
            d(a aVar) {
            }

            @Override // com.facebook.internal.FeatureManager.c
            public void a(boolean z) {
                if (z) {
                    com.facebook.appevents.k.a.a();
                }
            }
        }

        a() {
        }

        @Override // com.facebook.internal.FetchedAppSettingsManager.d
        public void a() {
        }

        @Override // com.facebook.internal.FetchedAppSettingsManager.d
        public void b(l lVar) {
            FeatureManager.a(FeatureManager.Feature.AAM, new C0075a(this));
            FeatureManager.a(FeatureManager.Feature.RestrictiveDataFiltering, new b(this));
            FeatureManager.a(FeatureManager.Feature.PrivacyProtection, new c(this));
            FeatureManager.a(FeatureManager.Feature.EventDeactivation, new d(this));
        }
    }

    public static void a() {
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return;
        }
        try {
            FetchedAppSettingsManager.h(new a());
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
        }
    }
}
