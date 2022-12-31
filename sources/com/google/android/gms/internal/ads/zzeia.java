package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzeia {
    static final /* synthetic */ int[] zzijw;
    static final /* synthetic */ int[] zzijx;

    static {
        int[] iArr = new int[zzehz.values().length];
        zzijx = iArr;
        try {
            iArr[zzehz.NIST_P256.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zzijx[zzehz.NIST_P384.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            zzijx[zzehz.NIST_P521.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        int[] iArr2 = new int[zzeic.values().length];
        zzijw = iArr2;
        try {
            iArr2[zzeic.UNCOMPRESSED.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            zzijw[zzeic.DO_NOT_USE_CRUNCHY_UNCOMPRESSED.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            zzijw[zzeic.COMPRESSED.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
