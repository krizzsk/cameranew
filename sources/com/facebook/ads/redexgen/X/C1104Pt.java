package com.facebook.ads.redexgen.X;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
/* renamed from: com.facebook.ads.redexgen.X.Pt  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1104Pt implements AudioManager.OnAudioFocusChangeListener {
    public final /* synthetic */ C06597k A00;

    public C1104Pt(C06597k c06597k) {
        this.A00 = c06597k;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i2) {
        new Handler(Looper.getMainLooper()).post(new KA(this, i2));
    }
}
