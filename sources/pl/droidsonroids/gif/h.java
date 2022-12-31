package pl.droidsonroids.gif;

import android.annotation.SuppressLint;
import android.content.Context;
/* compiled from: LibraryLoader.java */
/* loaded from: classes3.dex */
public class h {
    @SuppressLint({"StaticFieldLeak"})
    private static Context a;

    private static Context a() {
        if (a == null) {
            try {
                a = (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception e2) {
                throw new IllegalStateException("LibraryLoader not initialized. Call LibraryLoader.initialize() before using library classes.", e2);
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context) {
        try {
            System.loadLibrary("pl_droidsonroids_gif");
        } catch (UnsatisfiedLinkError unused) {
            if (context == null) {
                context = a();
            }
            j.h(context);
        }
    }
}
