package com.bumptech.glide.manager;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* compiled from: ActivityFragmentLifecycle.java */
/* loaded from: classes.dex */
class a implements g {
    private final Set<h> a = Collections.newSetFromMap(new WeakHashMap());
    private boolean b;
    private boolean c;

    @Override // com.bumptech.glide.manager.g
    public void a(h hVar) {
        this.a.add(hVar);
        if (this.c) {
            hVar.onDestroy();
        } else if (this.b) {
            hVar.onStart();
        } else {
            hVar.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.c = true;
        for (h hVar : com.bumptech.glide.l.h.g(this.a)) {
            hVar.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.b = true;
        for (h hVar : com.bumptech.glide.l.h.g(this.a)) {
            hVar.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        this.b = false;
        for (h hVar : com.bumptech.glide.l.h.g(this.a)) {
            hVar.onStop();
        }
    }
}
