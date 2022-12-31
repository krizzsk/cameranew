package com.facebook.rebound;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* compiled from: BaseSpringSystem.java */
/* loaded from: classes9.dex */
public class a {
    private final g c;
    private final Map<String, d> a = new HashMap();
    private final Set<d> b = new CopyOnWriteArraySet();

    /* renamed from: d  reason: collision with root package name */
    private final CopyOnWriteArraySet<h> f3145d = new CopyOnWriteArraySet<>();

    /* renamed from: e  reason: collision with root package name */
    private boolean f3146e = true;

    public a(g gVar) {
        if (gVar != null) {
            this.c = gVar;
            gVar.a(this);
            return;
        }
        throw new IllegalArgumentException("springLooper is required");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        d dVar = this.a.get(str);
        if (dVar != null) {
            this.b.add(dVar);
            if (d()) {
                this.f3146e = false;
                this.c.b();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("springId " + str + " does not reference a registered spring");
    }

    void b(double d2) {
        for (d dVar : this.b) {
            if (dVar.p()) {
                dVar.b(d2 / 1000.0d);
            } else {
                this.b.remove(dVar);
            }
        }
    }

    public d c() {
        d dVar = new d(this);
        f(dVar);
        return dVar;
    }

    public boolean d() {
        return this.f3146e;
    }

    public void e(double d2) {
        Iterator<h> it = this.f3145d.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        b(d2);
        if (this.b.isEmpty()) {
            this.f3146e = true;
        }
        Iterator<h> it2 = this.f3145d.iterator();
        while (it2.hasNext()) {
            it2.next().b(this);
        }
        if (this.f3146e) {
            this.c.c();
        }
    }

    void f(d dVar) {
        if (dVar != null) {
            if (!this.a.containsKey(dVar.e())) {
                this.a.put(dVar.e(), dVar);
                return;
            }
            throw new IllegalArgumentException("spring is already registered");
        }
        throw new IllegalArgumentException("spring is required");
    }
}
