package com.pinguo.camera360.gallery.data;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.text.DateFormat;
import java.util.Date;
/* compiled from: LocalMediaItem.java */
/* loaded from: classes3.dex */
public abstract class t extends w {

    /* renamed from: i  reason: collision with root package name */
    public int f6380i;

    /* renamed from: j  reason: collision with root package name */
    public String f6381j;

    /* renamed from: k  reason: collision with root package name */
    public String f6382k;

    /* renamed from: l  reason: collision with root package name */
    public long f6383l;
    public double m;
    public double n;
    public long o;
    public String p;
    public int q;
    public int r;
    public int s;

    public t(Path path, long j2) {
        super(path, j2);
        this.m = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.n = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public int D() {
        return this.q;
    }

    public long E() {
        return this.f6383l;
    }

    @Override // com.pinguo.camera360.gallery.data.x
    public v e() {
        v e2 = super.e();
        e2.a(200, this.p);
        e2.a(1, this.f6381j);
        e2.a(3, DateFormat.getDateTimeInstance().format(new Date(this.o)));
        if (com.pinguo.album.j.c.l(this.m, this.n)) {
            e2.a(4, new double[]{this.m, this.n});
        }
        long j2 = this.f6383l;
        if (j2 > 0) {
            e2.a(10, Long.valueOf(j2));
        }
        return e2;
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public long n() {
        return this.o;
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public String o() {
        return this.p;
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public long r() {
        return this.f6380i;
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public String s() {
        return this.f6382k;
    }
}
