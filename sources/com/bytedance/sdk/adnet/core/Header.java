package com.bytedance.sdk.adnet.core;

import android.text.TextUtils;
/* loaded from: classes.dex */
public final class Header {
    private final String a;
    private final String b;

    public Header(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Header.class != obj.getClass()) {
            return false;
        }
        Header header = (Header) obj;
        return TextUtils.equals(this.a, header.a) && TextUtils.equals(this.b, header.b);
    }

    public final String getName() {
        return this.a;
    }

    public final String getValue() {
        return this.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.a + ",value=" + this.b + "]";
    }
}
