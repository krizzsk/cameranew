package com.google.zxing.common;

import java.util.List;
/* compiled from: DecoderResult.java */
/* loaded from: classes2.dex */
public final class d {
    private final byte[] a;
    private final String b;
    private final List<byte[]> c;

    /* renamed from: d  reason: collision with root package name */
    private final String f4986d;

    /* renamed from: e  reason: collision with root package name */
    private Object f4987e;

    /* renamed from: f  reason: collision with root package name */
    private final int f4988f;

    /* renamed from: g  reason: collision with root package name */
    private final int f4989g;

    public d(byte[] bArr, String str, List<byte[]> list, String str2, int i2, int i3) {
        this.a = bArr;
        if (bArr != null) {
            int length = bArr.length;
        }
        this.b = str;
        this.c = list;
        this.f4986d = str2;
        this.f4988f = i3;
        this.f4989g = i2;
    }

    public List<byte[]> a() {
        return this.c;
    }

    public String b() {
        return this.f4986d;
    }

    public Object c() {
        return this.f4987e;
    }

    public byte[] d() {
        return this.a;
    }

    public int e() {
        return this.f4988f;
    }

    public int f() {
        return this.f4989g;
    }

    public String g() {
        return this.b;
    }

    public boolean h() {
        return this.f4988f >= 0 && this.f4989g >= 0;
    }

    public void i(Object obj) {
        this.f4987e = obj;
    }
}
