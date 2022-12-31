package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;
/* compiled from: Result.java */
/* loaded from: classes2.dex */
public final class g {
    private final String a;
    private Map<ResultMetadataType, Object> b;

    public g(String str, byte[] bArr, h[] hVarArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, hVarArr, barcodeFormat, System.currentTimeMillis());
    }

    public Map<ResultMetadataType, Object> a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public void c(ResultMetadataType resultMetadataType, Object obj) {
        if (this.b == null) {
            this.b = new EnumMap(ResultMetadataType.class);
        }
        this.b.put(resultMetadataType, obj);
    }

    public String toString() {
        return this.a;
    }

    public g(String str, byte[] bArr, h[] hVarArr, BarcodeFormat barcodeFormat, long j2) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, hVarArr, barcodeFormat, j2);
    }

    public g(String str, byte[] bArr, int i2, h[] hVarArr, BarcodeFormat barcodeFormat, long j2) {
        this.a = str;
        this.b = null;
    }
}
