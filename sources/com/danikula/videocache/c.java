package com.danikula.videocache;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Config.java */
/* loaded from: classes.dex */
public class c {
    public final File a;
    public final com.danikula.videocache.p.c b;
    public final com.danikula.videocache.p.a c;

    /* renamed from: d  reason: collision with root package name */
    public final com.danikula.videocache.r.c f2214d;

    /* renamed from: e  reason: collision with root package name */
    public final com.danikula.videocache.q.b f2215e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(File file, com.danikula.videocache.p.c cVar, com.danikula.videocache.p.a aVar, com.danikula.videocache.r.c cVar2, com.danikula.videocache.q.b bVar) {
        this.a = file;
        this.b = cVar;
        this.c = aVar;
        this.f2214d = cVar2;
        this.f2215e = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File a(String str) {
        return new File(this.a, this.b.a(str));
    }
}
