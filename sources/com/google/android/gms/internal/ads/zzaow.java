package com.google.android.gms.internal.ads;

import com.google.ads.AdRequest$ErrorCode;
import com.google.ads.AdRequest$Gender;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzaow {
    private static final /* synthetic */ int[] zzdoj;
    static final /* synthetic */ int[] zzdok;

    static {
        int[] iArr = new int[AdRequest$ErrorCode.values().length];
        zzdok = iArr;
        try {
            iArr[AdRequest$ErrorCode.INTERNAL_ERROR.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zzdok[AdRequest$ErrorCode.INVALID_REQUEST.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            zzdok[AdRequest$ErrorCode.NETWORK_ERROR.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            zzdok[AdRequest$ErrorCode.NO_FILL.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        int[] iArr2 = new int[AdRequest$Gender.values().length];
        zzdoj = iArr2;
        try {
            iArr2[AdRequest$Gender.FEMALE.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            zzdoj[AdRequest$Gender.MALE.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            zzdoj[AdRequest$Gender.UNKNOWN.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
