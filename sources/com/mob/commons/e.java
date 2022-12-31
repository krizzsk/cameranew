package com.mob.commons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* compiled from: MobChannel.java */
/* loaded from: classes2.dex */
public class e {
    private static e a;
    private HashMap<String, Object> b;

    private e() {
        HashMap<String, Object> c = c();
        this.b = c;
        if (c == null) {
            this.b = new HashMap<>();
        }
        ArrayList<MobProduct> products = MobProductCollector.getProducts();
        if (products == null || products.isEmpty()) {
            return;
        }
        Iterator<MobProduct> it = products.iterator();
        while (it.hasNext()) {
            MobProduct next = it.next();
            if (!this.b.containsKey(next.getProductTag())) {
                this.b.put(next.getProductTag(), 0);
            }
        }
    }

    public static e a() {
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new e();
                }
            }
        }
        return a;
    }

    private HashMap<String, Object> c() {
        try {
            return h.e();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public synchronized HashMap<String, Object> b() {
        return this.b;
    }

    public synchronized void a(MobProduct mobProduct, int i2) {
        if (mobProduct != null) {
            this.b.put(mobProduct.getProductTag(), Integer.valueOf(i2));
            a(this.b);
        }
    }

    private void a(HashMap<String, Object> hashMap) {
        try {
            h.a(hashMap);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
