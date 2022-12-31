package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.concurrent.CopyOnWriteArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractAdUnitManager.java */
/* loaded from: classes2.dex */
public abstract class a {
    int b;

    /* renamed from: d  reason: collision with root package name */
    private AbstractSmash f5492d;

    /* renamed from: e  reason: collision with root package name */
    private AbstractSmash f5493e;

    /* renamed from: f  reason: collision with root package name */
    String f5494f;

    /* renamed from: g  reason: collision with root package name */
    String f5495g;

    /* renamed from: j  reason: collision with root package name */
    Boolean f5498j;

    /* renamed from: k  reason: collision with root package name */
    boolean f5499k;

    /* renamed from: i  reason: collision with root package name */
    boolean f5497i = false;

    /* renamed from: l  reason: collision with root package name */
    boolean f5500l = true;
    final CopyOnWriteArrayList<AbstractSmash> c = new CopyOnWriteArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    com.ironsource.mediationsdk.logger.c f5496h = com.ironsource.mediationsdk.logger.c.i();
    com.ironsource.mediationsdk.utils.d a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractSmash B() {
        return this.f5492d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractSmash C() {
        return this.f5493e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(AbstractSmash abstractSmash) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        cVar.d(ironSourceTag, abstractSmash.r() + " is set as backfill", 0);
        this.f5492d = abstractSmash;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(AbstractSmash abstractSmash) {
        try {
            String w = IronSourceObject.getInstance().w();
            if (!TextUtils.isEmpty(w)) {
                abstractSmash.O(w);
            }
            String c = com.ironsource.mediationsdk.k0.a.a().c();
            if (TextUtils.isEmpty(c)) {
                return;
            }
            abstractSmash.Q(c, com.ironsource.mediationsdk.k0.a.a().b());
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            cVar.d(ironSourceTag, ":setCustomParams():" + e2.toString(), 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(AbstractSmash abstractSmash) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        cVar.d(ironSourceTag, abstractSmash.r() + " is set as premium", 0);
        this.f5493e = abstractSmash;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(int i2) {
        this.b = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(AbstractSmash abstractSmash) {
        this.c.add(abstractSmash);
        com.ironsource.mediationsdk.utils.d dVar = this.a;
        if (dVar != null) {
            dVar.b(abstractSmash);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean z() {
        return this.f5500l;
    }
}
