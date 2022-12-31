package com.ironsource.mediationsdk.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: SessionCappingManager.java */
/* loaded from: classes2.dex */
public class m {
    private Map<String, Integer> a = new HashMap();
    private Map<String, Integer> b = new HashMap();

    /* compiled from: SessionCappingManager.java */
    /* loaded from: classes2.dex */
    public interface a {
        int B();

        String x();
    }

    public m(List<a> list) {
        for (a aVar : list) {
            this.a.put(aVar.x(), 0);
            this.b.put(aVar.x(), Integer.valueOf(aVar.B()));
        }
    }

    public boolean a() {
        for (String str : this.b.keySet()) {
            if (this.a.get(str).intValue() < this.b.get(str).intValue()) {
                return false;
            }
        }
        return true;
    }

    public void b(a aVar) {
        synchronized (this) {
            String x = aVar.x();
            if (this.a.containsKey(x)) {
                Map<String, Integer> map = this.a;
                map.put(x, Integer.valueOf(map.get(x).intValue() + 1));
            }
        }
    }

    public boolean c(a aVar) {
        synchronized (this) {
            String x = aVar.x();
            if (this.a.containsKey(x)) {
                return this.a.get(x).intValue() >= aVar.B();
            }
            return false;
        }
    }
}
