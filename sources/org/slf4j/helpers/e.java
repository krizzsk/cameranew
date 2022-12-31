package org.slf4j.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
/* compiled from: SubstituteLoggerFactory.java */
/* loaded from: classes3.dex */
public class e implements org.slf4j.a {
    boolean a = false;
    final Map<String, d> b = new HashMap();
    final LinkedBlockingQueue<org.slf4j.event.c> c = new LinkedBlockingQueue<>();

    @Override // org.slf4j.a
    public synchronized org.slf4j.b a(String str) {
        d dVar;
        dVar = this.b.get(str);
        if (dVar == null) {
            dVar = new d(str, this.c, this.a);
            this.b.put(str, dVar);
        }
        return dVar;
    }

    public void b() {
        this.b.clear();
        this.c.clear();
    }

    public LinkedBlockingQueue<org.slf4j.event.c> c() {
        return this.c;
    }

    public List<d> d() {
        return new ArrayList(this.b.values());
    }

    public void e() {
        this.a = true;
    }
}
