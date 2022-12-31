package com.google.android.gms.internal.ads;

import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class zzczt implements zzdvz {
    static final zzdvz zzeaj = new zzczt();

    private zzczt() {
    }

    @Override // com.google.android.gms.internal.ads.zzdvz
    public final Object apply(Object obj) {
        String optString;
        optString = ((JSONObject) obj).optString("nas");
        return optString;
    }
}
