package us.pinguo.webview;

import java.util.HashMap;
/* compiled from: PGJsConfig.java */
/* loaded from: classes6.dex */
public class a {
    private final HashMap<String, Class> a;

    /* compiled from: PGJsConfig.java */
    /* loaded from: classes6.dex */
    public static class b {
        private HashMap<String, Class> a = new HashMap<>();

        public b a(String str, Class cls) {
            this.a.put(str, cls);
            return this;
        }

        public a b() {
            return new a(this.a);
        }
    }

    public boolean a(String str) {
        return this.a.containsKey(str);
    }

    public us.pinguo.webview.f.b b(String str) {
        Class cls = this.a.get(str);
        if (cls == null) {
            return null;
        }
        try {
            Object newInstance = cls.newInstance();
            if (newInstance instanceof us.pinguo.webview.f.b) {
                return (us.pinguo.webview.f.b) newInstance;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private a(HashMap<String, Class> hashMap) {
        this.a = hashMap;
    }
}
