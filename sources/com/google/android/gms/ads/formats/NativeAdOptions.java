package com.google.android.gms.ads.formats;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.VideoOptions;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@Deprecated
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
    @Deprecated
    public static final int ORIENTATION_ANY = 0;
    @Deprecated
    public static final int ORIENTATION_LANDSCAPE = 2;
    @Deprecated
    public static final int ORIENTATION_PORTRAIT = 1;
    private final boolean a;
    private final int b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f3446d;

    /* renamed from: e  reason: collision with root package name */
    private final int f3447e;

    /* renamed from: f  reason: collision with root package name */
    private final VideoOptions f3448f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f3449g;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes2.dex */
    public @interface AdChoicesPlacement {
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: e  reason: collision with root package name */
        private VideoOptions f3451e;
        private boolean a = false;
        private int b = -1;
        private int c = 0;

        /* renamed from: d  reason: collision with root package name */
        private boolean f3450d = false;

        /* renamed from: f  reason: collision with root package name */
        private int f3452f = 1;

        /* renamed from: g  reason: collision with root package name */
        private boolean f3453g = false;

        public final NativeAdOptions build() {
            return new NativeAdOptions(this);
        }

        public final Builder setAdChoicesPlacement(@AdChoicesPlacement int i2) {
            this.f3452f = i2;
            return this;
        }

        @Deprecated
        public final Builder setImageOrientation(int i2) {
            this.b = i2;
            return this;
        }

        public final Builder setMediaAspectRatio(@NativeMediaAspectRatio int i2) {
            this.c = i2;
            return this;
        }

        public final Builder setRequestCustomMuteThisAd(boolean z) {
            this.f3453g = z;
            return this;
        }

        public final Builder setRequestMultipleImages(boolean z) {
            this.f3450d = z;
            return this;
        }

        public final Builder setReturnUrlsForImageAssets(boolean z) {
            this.a = z;
            return this;
        }

        public final Builder setVideoOptions(VideoOptions videoOptions) {
            this.f3451e = videoOptions;
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
        this.f3446d = builder.f3450d;
        this.f3447e = builder.f3452f;
        this.f3448f = builder.f3451e;
        this.f3449g = builder.f3453g;
    }

    public final int getAdChoicesPlacement() {
        return this.f3447e;
    }

    @Deprecated
    public final int getImageOrientation() {
        return this.b;
    }

    public final int getMediaAspectRatio() {
        return this.c;
    }

    @Nullable
    public final VideoOptions getVideoOptions() {
        return this.f3448f;
    }

    public final boolean shouldRequestMultipleImages() {
        return this.f3446d;
    }

    public final boolean shouldReturnUrlsForImageAssets() {
        return this.a;
    }

    public final boolean zzjt() {
        return this.f3449g;
    }
}
