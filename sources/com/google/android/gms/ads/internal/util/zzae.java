package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.media.AudioManager;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzae {
    private boolean a = false;
    private float b = 1.0f;

    private final synchronized boolean a() {
        return this.b >= 0.0f;
    }

    public static float zzbg(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return 0.0f;
        }
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        int streamVolume = audioManager.getStreamVolume(3);
        if (streamMaxVolume == 0) {
            return 0.0f;
        }
        return streamVolume / streamMaxVolume;
    }

    public final synchronized void setAppMuted(boolean z) {
        this.a = z;
    }

    public final synchronized void setAppVolume(float f2) {
        this.b = f2;
    }

    public final synchronized float zzra() {
        if (a()) {
            return this.b;
        }
        return 1.0f;
    }

    public final synchronized boolean zzrb() {
        return this.a;
    }
}
