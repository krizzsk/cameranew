package com.facebook.share.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.u;
/* compiled from: LikeStatusClient.java */
@Deprecated
/* loaded from: classes.dex */
final class e extends u {

    /* renamed from: j  reason: collision with root package name */
    private String f3231j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, String str, String str2) {
        super(context, 65542, 65543, 20141001, str);
        this.f3231j = str2;
    }

    @Override // com.facebook.internal.u
    protected void d(Bundle bundle) {
        bundle.putString("com.facebook.platform.extra.OBJECT_ID", this.f3231j);
    }
}
