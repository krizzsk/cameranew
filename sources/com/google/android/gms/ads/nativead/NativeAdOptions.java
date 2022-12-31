package com.google.android.gms.ads.nativead;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.VideoOptions;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class NativeAdOptions {
    public static final int ADCHOICES_BOTTOM_LEFT = 3;
    public static final int ADCHOICES_BOTTOM_RIGHT = 2;
    public static final int ADCHOICES_TOP_LEFT = 0;
    public static final int ADCHOICES_TOP_RIGHT = 1;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_ANY = 1;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_LANDSCAPE = 2;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_PORTRAIT = 3;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_SQUARE = 4;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_UNKNOWN = 0;
    private final boolean a;
    private final int b;
    private final boolean c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3562d;

    /* renamed from: e  reason: collision with root package name */
    private final VideoOptions f3563e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f3564f;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes2.dex */
    public @interface AdChoicesPlacement {
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: d  reason: collision with root package name */
        private VideoOptions f3565d;
        private boolean a = false;
        private int b = 0;
        private boolean c = false;

        /* renamed from: e  reason: collision with root package name */
        private int f3566e = 1;

        /* renamed from: f  reason: collision with root package name */
        private boolean f3567f = false;

        public final NativeAdOptions build() {
            return new NativeAdOptions(this);
        }

        public final Builder setAdChoicesPlacement(@AdChoicesPlacement int i2) {
            this.f3566e = i2;
            return this;
        }

        public final Builder setMediaAspectRatio(@NativeMediaAspectRatio int i2) {
            this.b = i2;
            return this;
        }

        public final Builder setRequestCustomMuteThisAd(boolean z) {
            this.f3567f = z;
            return this;
        }

        public final Builder setRequestMultipleImages(boolean z) {
            this.c = z;
            return this;
        }

        public final Builder setReturnUrlsForImageAssets(boolean z) {
            this.a = z;
            return this;
        }

        public final Builder setVideoOptions(VideoOptions videoOptions) {
            this.f3565d = videoOptions;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes2.dex */
    public @interface NativeMediaAspectRatio {
    }

    private NativeAdOptions(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.f3562d = builder.f3566e;
        this.f3563e = builder.f3565d;
        this.f3564f = builder.f3567f;
    }

    public final int getAdChoicesPlacement() {
        return this.f3562d;
    }

    public final int getMediaAspectRatio() {
        return this.b;
    }

    @Nullable
    public final VideoOptions getVideoOptions() {
        return this.f3563e;
    }

    public final boolean shouldRequestMultipleImages() {
        return this.c;
    }

    public final boolean shouldReturnUrlsForImageAssets() {
        return this.a;
    }

    public final boolean zzjt() {
        return this.f3564f;
    }
}
