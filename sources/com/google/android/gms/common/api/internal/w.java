package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class w implements BackgroundDetector.a {
    private final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(f fVar) {
        this.a = fVar;
    }

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.a
    public final void onBackgroundStateChanged(boolean z) {
        this.a.m.sendMessage(this.a.m.obtainMessage(1, Boolean.valueOf(z)));
    }
}
