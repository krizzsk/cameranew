package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.e;
import java.util.HashMap;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@Deprecated
/* loaded from: classes2.dex */
public final class CustomEventExtras implements e {
    private final HashMap<String, Object> a = new HashMap<>();

    public final Object getExtra(String str) {
        return this.a.get(str);
    }

    public final void setExtra(String str, Object obj) {
        this.a.put(str, obj);
    }
}
