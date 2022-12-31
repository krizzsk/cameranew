package com.bytedance.sdk.openadsdk;
/* loaded from: classes.dex */
public class TTImage {
    private int a;
    private int b;
    private String c;

    public TTImage(int i2, int i3, String str) {
        this.a = i2;
        this.b = i3;
        this.c = str;
    }

    public int getHeight() {
        return this.a;
    }

    public String getImageUrl() {
        return this.c;
    }

    public int getWidth() {
        return this.b;
    }

    public boolean isValid() {
        String str;
        return this.a > 0 && this.b > 0 && (str = this.c) != null && str.length() > 0;
    }
}
