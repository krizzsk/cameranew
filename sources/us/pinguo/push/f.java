package us.pinguo.push;

import android.content.Context;
/* compiled from: PushFactory.java */
/* loaded from: classes6.dex */
public class f {
    static b a;
    static Context b;
    public static a c;

    /* compiled from: PushFactory.java */
    /* loaded from: classes6.dex */
    public interface a {
        void a(String str, String str2, boolean z);

        void b(String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context a() {
        return b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b b() {
        return a;
    }

    public static void c(Context context, b bVar) {
        b = context;
        a = bVar;
    }

    public static void d(a aVar) {
        c = aVar;
    }
}
