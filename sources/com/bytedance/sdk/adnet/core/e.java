package com.bytedance.sdk.adnet.core;

import com.bytedance.sdk.adnet.err.VAdError;
/* compiled from: DefaultRetryPolicy.java */
/* loaded from: classes.dex */
public class e implements com.bytedance.sdk.adnet.face.d {
    private int a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private final float f1234d;

    public e() {
        this(2500, 1, 1.0f);
    }

    public e a(int i2) {
        this.a = i2;
        return this;
    }

    public e b(int i2) {
        this.c = i2;
        return this;
    }

    protected boolean c() {
        return this.b <= this.c;
    }

    public e(int i2, int i3, float f2) {
        this.a = i2;
        this.c = i3;
        this.f1234d = f2;
    }

    @Override // com.bytedance.sdk.adnet.face.d
    public int a() {
        return this.a;
    }

    @Override // com.bytedance.sdk.adnet.face.d
    public int b() {
        return this.b;
    }

    @Override // com.bytedance.sdk.adnet.face.d
    public void a(VAdError vAdError) throws VAdError {
        this.b++;
        int i2 = this.a;
        this.a = i2 + ((int) (i2 * this.f1234d));
        if (!c()) {
            throw vAdError;
        }
    }
}
