package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzedk {
    static final /* synthetic */ int[] zzidt;
    static final /* synthetic */ int[] zzidu;
    static final /* synthetic */ int[] zzidv;

    static {
        int[] iArr = new int[zzefe.values().length];
        zzidv = iArr;
        try {
            iArr[zzefe.UNCOMPRESSED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zzidv[zzefe.DO_NOT_USE_CRUNCHY_UNCOMPRESSED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            zzidv[zzefe.COMPRESSED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        int[] iArr2 = new int[zzefs.values().length];
        zzidu = iArr2;
        try {
            iArr2[zzefs.NIST_P256.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            zzidu[zzefs.NIST_P384.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            zzidu[zzefs.NIST_P521.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
        int[] iArr3 = new int[zzeft.values().length];
        zzidt = iArr3;
        try {
            iArr3[zzeft.SHA1.ordinal()] = 1;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            zzidt[zzeft.SHA256.ordinal()] = 2;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            zzidt[zzeft.SHA512.ordinal()] = 3;
        } catch (NoSuchFieldError unused9) {
        }
    }
}
