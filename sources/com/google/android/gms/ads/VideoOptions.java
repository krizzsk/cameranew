package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzaau;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class VideoOptions {
    private final boolean a;
    private final boolean b;
    private final boolean c;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class Builder {
        private boolean a = true;
        private boolean b = false;
        private boolean c = false;

        public final VideoOptions build() {
            return new VideoOptions(this);
        }

        public final Builder setClickToExpandRequested(boolean z) {
            this.c = z;
            return this;
        }

        public final Builder setCustomControlsRequested(boolean z) {
            this.b = z;
            return this;
        }

        public final Builder setStartMuted(boolean z) {
            this.a = z;
            return this;
        }
    }

    public VideoOptions(zzaau zzaauVar) {
        this.a = zzaauVar.zzadx;
        this.b = zzaauVar.zzady;
        this.c = zzaauVar.zzadz;
    }

    public final boolean getClickToExpandRequested() {
        return this.c;
    }

    public final boolean getCustomControlsRequested() {
        return this.b;
    }

    public final boolean getStartMuted() {
        return this.a;
    }

    private VideoOptions(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
    }
}
