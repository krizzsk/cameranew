package com.nostra13.universalimageloader.core;

import java.util.concurrent.locks.ReentrantLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageLoadingInfo.java */
/* loaded from: classes3.dex */
public final class f {
    final String a;
    final String b;
    final com.nostra13.universalimageloader.core.j.a c;

    /* renamed from: d  reason: collision with root package name */
    final com.nostra13.universalimageloader.core.assist.c f5958d;

    /* renamed from: e  reason: collision with root package name */
    final c f5959e;

    /* renamed from: f  reason: collision with root package name */
    final com.nostra13.universalimageloader.core.k.a f5960f;

    /* renamed from: g  reason: collision with root package name */
    final com.nostra13.universalimageloader.core.k.b f5961g;

    /* renamed from: h  reason: collision with root package name */
    final ReentrantLock f5962h;

    public f(String str, com.nostra13.universalimageloader.core.j.a aVar, com.nostra13.universalimageloader.core.assist.c cVar, String str2, c cVar2, com.nostra13.universalimageloader.core.k.a aVar2, com.nostra13.universalimageloader.core.k.b bVar, ReentrantLock reentrantLock) {
        this.a = str;
        this.c = aVar;
        this.f5958d = cVar;
        this.f5959e = cVar2;
        this.f5960f = aVar2;
        this.f5961g = bVar;
        this.f5962h = reentrantLock;
        this.b = str2;
    }
}
