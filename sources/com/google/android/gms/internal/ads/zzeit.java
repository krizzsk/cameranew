package com.google.android.gms.internal.ads;

import java.security.SecureRandom;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzeit extends ThreadLocal<SecureRandom> {
    @Override // java.lang.ThreadLocal
    protected final /* synthetic */ SecureRandom initialValue() {
        SecureRandom zzbfu;
        zzbfu = zzeiu.zzbfu();
        return zzbfu;
    }
}
