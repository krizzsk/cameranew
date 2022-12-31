package com.bumptech.glide.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
/* compiled from: RequestTracker.java */
/* loaded from: classes.dex */
public class l {
    private final Set<com.bumptech.glide.request.a> a = Collections.newSetFromMap(new WeakHashMap());
    private final List<com.bumptech.glide.request.a> b = new ArrayList();
    private boolean c;

    public void a() {
        for (com.bumptech.glide.request.a aVar : com.bumptech.glide.l.h.g(this.a)) {
            aVar.clear();
        }
        this.b.clear();
    }

    public void b() {
        this.c = true;
        for (com.bumptech.glide.request.a aVar : com.bumptech.glide.l.h.g(this.a)) {
            if (aVar.isRunning()) {
                aVar.pause();
                this.b.add(aVar);
            }
        }
    }

    public void c(com.bumptech.glide.request.a aVar) {
        this.a.remove(aVar);
        this.b.remove(aVar);
    }

    public void d() {
        for (com.bumptech.glide.request.a aVar : com.bumptech.glide.l.h.g(this.a)) {
            if (!aVar.e() && !aVar.isCancelled()) {
                aVar.pause();
                if (!this.c) {
                    aVar.f();
                } else {
                    this.b.add(aVar);
                }
            }
        }
    }

    public void e() {
        this.c = false;
        for (com.bumptech.glide.request.a aVar : com.bumptech.glide.l.h.g(this.a)) {
            if (!aVar.e() && !aVar.isCancelled() && !aVar.isRunning()) {
                aVar.f();
            }
        }
        this.b.clear();
    }

    public void f(com.bumptech.glide.request.a aVar) {
        this.a.add(aVar);
        if (!this.c) {
            aVar.f();
        } else {
            this.b.add(aVar);
        }
    }
}
