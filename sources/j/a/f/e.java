package j.a.f;

import android.content.Context;
import java.util.HashMap;
/* compiled from: BDProxy.java */
/* loaded from: classes6.dex */
public class e {
    public static a a = new b();

    /* compiled from: BDProxy.java */
    /* loaded from: classes6.dex */
    public interface a {
        void a(Throwable th);

        void b(boolean z);

        void c(String str);

        String d(Context context);

        void e(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Context context, boolean z2);

        void onEvent(String str);

        void onEvent(String str, String str2);

        void onEvent(String str, String str2, String str3);

        void onEvent(String str, HashMap<String, String> hashMap);

        void onPause();

        void onResume();
    }

    /* compiled from: BDProxy.java */
    /* loaded from: classes6.dex */
    public static class b implements a {
        @Override // j.a.f.e.a
        public void a(Throwable th) {
        }

        @Override // j.a.f.e.a
        public void b(boolean z) {
        }

        @Override // j.a.f.e.a
        public void c(String str) {
        }

        @Override // j.a.f.e.a
        public String d(Context context) {
            return null;
        }

        @Override // j.a.f.e.a
        public void e(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Context context, boolean z2) {
        }

        @Override // j.a.f.e.a
        public void onEvent(String str) {
        }

        @Override // j.a.f.e.a
        public void onEvent(String str, String str2) {
        }

        @Override // j.a.f.e.a
        public void onEvent(String str, String str2, String str3) {
        }

        @Override // j.a.f.e.a
        public void onEvent(String str, HashMap<String, String> hashMap) {
        }

        @Override // j.a.f.e.a
        public void onPause() {
        }

        @Override // j.a.f.e.a
        public void onResume() {
        }
    }

    public static String a(Context context) {
        return a.d(context);
    }

    public static void b(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Context context, boolean z2) {
        a.e(z, str, str2, str3, str4, str5, str6, str7, str8, context, z2);
    }

    public static void c() {
        a.onPause();
    }

    public static void d() {
        a.onResume();
    }

    public static void e(Throwable th) {
        a.a(th);
    }

    public static void f(String str) {
        a.c(str);
    }

    public static void g(a aVar) {
        a = aVar;
    }

    public static void onEvent(String str) {
        a.onEvent(str);
    }

    public static void onEvent(String str, String str2) {
        a.onEvent(str, str2);
    }

    public static void onEvent(String str, String str2, String str3) {
        a.onEvent(str, str2, str3);
    }

    public static void onEvent(String str, HashMap<String, String> hashMap) {
        a.onEvent(str, hashMap);
    }
}
