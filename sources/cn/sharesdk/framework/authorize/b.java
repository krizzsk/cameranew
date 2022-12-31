package cn.sharesdk.framework.authorize;

import android.app.Activity;
/* compiled from: AuthorizeParams.java */
/* loaded from: classes.dex */
public class b {
    private static volatile b a;
    private Activity b;
    private boolean c;

    public static b c() {
        synchronized (b.class) {
            if (a == null) {
                synchronized (b.class) {
                    if (a == null) {
                        a = new b();
                    }
                }
            }
        }
        return a;
    }

    public boolean a() {
        return this.c;
    }

    public Activity b() {
        return this.b;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public void a(Activity activity) {
        this.b = activity;
    }
}
