package com.facebook.internal.logging.monitor;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.facebook.f;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.l;
/* compiled from: MonitorManager.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class c {
    private static b a = new a();

    /* compiled from: MonitorManager.java */
    /* loaded from: classes.dex */
    static class a implements b {
        a() {
        }

        @Override // com.facebook.internal.logging.monitor.c.b
        public void a() {
            com.facebook.internal.logging.monitor.a.a();
        }
    }

    /* compiled from: MonitorManager.java */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    public static void a() {
        l j2;
        if (f.u() && (j2 = FetchedAppSettingsManager.j(f.g())) != null && j2.h()) {
            a.a();
        }
    }
}
