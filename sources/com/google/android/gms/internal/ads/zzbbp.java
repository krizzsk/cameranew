package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@TargetApi(14)
/* loaded from: classes2.dex */
public final class zzbbp implements AudioManager.OnAudioFocusChangeListener {
    private float zzdi = 1.0f;
    private boolean zzekb;
    private final AudioManager zzenb;
    private final zzbbs zzenc;
    private boolean zzend;
    private boolean zzene;

    public zzbbp(Context context, zzbbs zzbbsVar) {
        this.zzenb = (AudioManager) context.getSystemService("audio");
        this.zzenc = zzbbsVar;
    }

    private final void zzabn() {
        boolean z;
        boolean z2;
        boolean z3 = this.zzekb && !this.zzene && this.zzdi > 0.0f;
        if (z3 && !(z2 = this.zzend)) {
            AudioManager audioManager = this.zzenb;
            if (audioManager != null && !z2) {
                this.zzend = audioManager.requestAudioFocus(this, 3, 2) == 1;
            }
            this.zzenc.zzaaj();
        } else if (z3 || !(z = this.zzend)) {
        } else {
            AudioManager audioManager2 = this.zzenb;
            if (audioManager2 != null && z) {
                this.zzend = audioManager2.abandonAudioFocus(this) == 0;
            }
            this.zzenc.zzaaj();
        }
    }

    public final float getVolume() {
        float f2 = this.zzene ? 0.0f : this.zzdi;
        if (this.zzend) {
            return f2;
        }
        return 0.0f;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i2) {
        this.zzend = i2 > 0;
        this.zzenc.zzaaj();
    }

    public final void setMuted(boolean z) {
        this.zzene = z;
        zzabn();
    }

    public final void setVolume(float f2) {
        this.zzdi = f2;
        zzabn();
    }

    public final void zzaaz() {
        this.zzekb = true;
        zzabn();
    }

    public final void zzaba() {
        this.zzekb = false;
        zzabn();
    }
}
