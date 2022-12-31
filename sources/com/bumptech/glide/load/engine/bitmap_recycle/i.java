package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
/* compiled from: SizeConfigStrategy.java */
@TargetApi(19)
/* loaded from: classes.dex */
public class i implements g {

    /* renamed from: d  reason: collision with root package name */
    private static final Bitmap.Config[] f733d = {Bitmap.Config.ARGB_8888, null};

    /* renamed from: e  reason: collision with root package name */
    private static final Bitmap.Config[] f734e = {Bitmap.Config.RGB_565};

    /* renamed from: f  reason: collision with root package name */
    private static final Bitmap.Config[] f735f = {Bitmap.Config.ARGB_4444};

    /* renamed from: g  reason: collision with root package name */
    private static final Bitmap.Config[] f736g = {Bitmap.Config.ALPHA_8};
    private final c a = new c();
    private final e<b, Bitmap> b = new e<>();
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> c = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SizeConfigStrategy.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SizeConfigStrategy.java */
    /* loaded from: classes.dex */
    public static final class b implements h {
        private final c a;
        private int b;
        private Bitmap.Config c;

        public b(c cVar) {
            this.a = cVar;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.h
        public void a() {
            this.a.c(this);
        }

        public void c(int i2, Bitmap.Config config) {
            this.b = i2;
            this.c = config;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.b == bVar.b) {
                    Bitmap.Config config = this.c;
                    Bitmap.Config config2 = bVar.c;
                    if (config == null) {
                        if (config2 != null) {
                            return false;
                        }
                    } else if (!config.equals(config2)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            int i2 = this.b * 31;
            Bitmap.Config config = this.c;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return i.i(this.b, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SizeConfigStrategy.java */
    /* loaded from: classes.dex */
    public static class c extends com.bumptech.glide.load.engine.bitmap_recycle.b<b> {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.b
        /* renamed from: d */
        public b a() {
            return new b(this);
        }

        public b e(int i2, Bitmap.Config config) {
            b b = b();
            b.c(i2, config);
            return b;
        }
    }

    private void g(Integer num, Bitmap.Config config) {
        NavigableMap<Integer, Integer> k2 = k(config);
        Integer num2 = (Integer) k2.get(num);
        if (num2.intValue() == 1) {
            k2.remove(num);
        } else {
            k2.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private b h(b bVar, int i2, Bitmap.Config config) {
        Bitmap.Config[] j2;
        for (Bitmap.Config config2 : j(config)) {
            Integer ceilingKey = k(config2).ceilingKey(Integer.valueOf(i2));
            if (ceilingKey != null && ceilingKey.intValue() <= i2 * 8) {
                if (ceilingKey.intValue() == i2) {
                    if (config2 == null) {
                        if (config == null) {
                            return bVar;
                        }
                    } else if (config2.equals(config)) {
                        return bVar;
                    }
                }
                this.a.c(bVar);
                return this.a.e(ceilingKey.intValue(), config2);
            }
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String i(int i2, Bitmap.Config config) {
        return "[" + i2 + "](" + config + ")";
    }

    private static Bitmap.Config[] j(Bitmap.Config config) {
        int i2 = a.a[config.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return i2 != 4 ? new Bitmap.Config[]{config} : f736g;
                }
                return f735f;
            }
            return f734e;
        }
        return f733d;
    }

    private NavigableMap<Integer, Integer> k(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.c.get(config);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.c.put(config, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public void a(Bitmap bitmap) {
        b e2 = this.a.e(com.bumptech.glide.l.h.e(bitmap), bitmap.getConfig());
        this.b.d(e2, bitmap);
        NavigableMap<Integer, Integer> k2 = k(bitmap.getConfig());
        Integer num = (Integer) k2.get(Integer.valueOf(e2.b));
        k2.put(Integer.valueOf(e2.b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public String b(Bitmap bitmap) {
        return i(com.bumptech.glide.l.h.e(bitmap), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public String c(int i2, int i3, Bitmap.Config config) {
        return i(com.bumptech.glide.l.h.d(i2, i3, config), config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public Bitmap d(int i2, int i3, Bitmap.Config config) {
        int d2 = com.bumptech.glide.l.h.d(i2, i3, config);
        Bitmap a2 = this.b.a(h(this.a.e(d2, config), d2, config));
        if (a2 != null) {
            g(Integer.valueOf(com.bumptech.glide.l.h.e(a2)), a2.getConfig());
            a2.reconfigure(i2, i3, a2.getConfig() != null ? a2.getConfig() : Bitmap.Config.ARGB_8888);
        }
        return a2;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public int e(Bitmap bitmap) {
        return com.bumptech.glide.l.h.e(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public Bitmap removeLast() {
        Bitmap f2 = this.b.f();
        if (f2 != null) {
            g(Integer.valueOf(com.bumptech.glide.l.h.e(f2)), f2.getConfig());
        }
        return f2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.b);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.c.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.c.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }
}
