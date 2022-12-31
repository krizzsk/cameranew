package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzemo;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzebj<KeyProtoT extends zzemo, PublicKeyProtoT extends zzemo> extends zzeax<KeyProtoT> {
    private final Class<PublicKeyProtoT> zzibw;

    /* JADX INFO: Access modifiers changed from: protected */
    @SafeVarargs
    public zzebj(Class<KeyProtoT> cls, Class<PublicKeyProtoT> cls2, zzeaz<?, KeyProtoT>... zzeazVarArr) {
        super(cls, zzeazVarArr);
        this.zzibw = cls2;
    }
}
