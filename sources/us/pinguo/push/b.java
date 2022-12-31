package us.pinguo.push;

import java.util.HashMap;
/* compiled from: PushConfig.java */
/* loaded from: classes6.dex */
public class b {
    private final HashMap<Integer, Class> a;

    /* compiled from: PushConfig.java */
    /* renamed from: us.pinguo.push.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0432b {
        public HashMap<Integer, Class> a = new HashMap<>();

        public C0432b a(Integer num, Class cls) {
            this.a.put(num, cls);
            return this;
        }

        public b b() {
            return new b(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c a(Integer num) {
        Class cls = this.a.get(num);
        if (cls == null) {
            return null;
        }
        try {
            Object newInstance = cls.newInstance();
            if (newInstance instanceof c) {
                return (c) newInstance;
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private b(HashMap<Integer, Class> hashMap) {
        this.a = hashMap;
    }
}
