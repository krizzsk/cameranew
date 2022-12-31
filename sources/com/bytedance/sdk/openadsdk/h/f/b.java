package com.bytedance.sdk.openadsdk.h.f;

import java.io.Serializable;
/* compiled from: VideoUrlModel.java */
/* loaded from: classes.dex */
public class b implements Serializable {
    public String a;
    public int b = 204800;
    public String c;

    public b a(String str) {
        this.a = str;
        return this;
    }

    public b b(String str) {
        this.c = str;
        return this;
    }

    public String toString() {
        return "VideoUrlModel{url='" + this.a + "', maxPreloadSize=" + this.b + ", fileNameKey='" + this.c + "'}";
    }

    public b a(int i2) {
        if (i2 > 0) {
            this.b = i2;
        }
        return this;
    }
}
