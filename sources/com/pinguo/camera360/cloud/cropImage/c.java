package com.pinguo.camera360.cloud.cropImage;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* compiled from: MediaItem.java */
/* loaded from: classes3.dex */
public final class c {
    public long a;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public String f6276d;

    /* renamed from: f  reason: collision with root package name */
    public double f6278f;

    /* renamed from: g  reason: collision with root package name */
    public double f6279g;

    /* renamed from: k  reason: collision with root package name */
    public int f6283k;

    /* renamed from: l  reason: collision with root package name */
    public float f6284l;
    public String m;

    /* renamed from: e  reason: collision with root package name */
    private int f6277e = -1;

    /* renamed from: h  reason: collision with root package name */
    public long f6280h = 0;

    /* renamed from: i  reason: collision with root package name */
    public long f6281i = 0;

    /* renamed from: j  reason: collision with root package name */
    public long f6282j = 0;
    public String b = "";

    public int a() {
        if (this.f6277e == -1) {
            String str = this.f6276d;
            this.f6277e = (str == null || !str.startsWith("video/")) ? 0 : 1;
        }
        return this.f6277e;
    }

    public boolean b() {
        return (this.f6278f == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && this.f6279g == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) ? false : true;
    }

    public String toString() {
        return this.b;
    }
}
