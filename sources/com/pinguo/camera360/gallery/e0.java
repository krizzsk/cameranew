package com.pinguo.camera360.gallery;

import java.util.HashMap;
/* compiled from: TransitionStore.java */
/* loaded from: classes3.dex */
public class e0 {
    private HashMap<Object, Object> a = new HashMap<>();

    public void a() {
        this.a.clear();
    }

    public <T> T b(Object obj) {
        return (T) this.a.get(obj);
    }

    public <T> T c(Object obj, T t) {
        T t2 = (T) this.a.get(obj);
        return t2 == null ? t : t2;
    }

    public void d(Object obj, Object obj2) {
        this.a.put(obj, obj2);
    }
}
