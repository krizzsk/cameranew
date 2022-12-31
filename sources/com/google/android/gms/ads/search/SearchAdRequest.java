package com.google.android.gms.ads.search;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.ads.zzzj;
import com.google.android.gms.internal.ads.zzzk;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@Deprecated
/* loaded from: classes2.dex */
public final class SearchAdRequest {
    public static final int BORDER_TYPE_DASHED = 1;
    public static final int BORDER_TYPE_DOTTED = 2;
    public static final int BORDER_TYPE_NONE = 0;
    public static final int BORDER_TYPE_SOLID = 3;
    public static final int CALL_BUTTON_COLOR_DARK = 2;
    public static final int CALL_BUTTON_COLOR_LIGHT = 0;
    public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
    public static final String DEVICE_ID_EMULATOR = "B3EEABB8EE11C2BE770B684D95219ECB";
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    private final zzzk a;
    private final String b;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class Builder {
        private final zzzj a = new zzzj();
        private String b;

        public final Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.a.zzb(cls, bundle);
            return this;
        }

        public final Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.a.zza(networkExtras);
            return this;
        }

        public final Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.a.zza(cls, bundle);
            return this;
        }

        @Deprecated
        public final Builder addTestDevice(String str) {
            this.a.zzcg(str);
            return this;
        }

        public final SearchAdRequest build() {
            return new SearchAdRequest(this);
        }

        @Deprecated
        public final Builder setAnchorTextColor(int i2) {
            return this;
        }

        @Deprecated
        public final Builder setBackgroundColor(int i2) {
            return this;
        }

        @Deprecated
        public final Builder setBackgroundGradient(int i2, int i3) {
            return this;
        }

        @Deprecated
        public final Builder setBorderColor(int i2) {
            return this;
        }

        @Deprecated
        public final Builder setBorderThickness(int i2) {
            return this;
        }

        @Deprecated
        public final Builder setBorderType(int i2) {
            return this;
        }

        @Deprecated
        public final Builder setCallButtonColor(int i2) {
            return this;
        }

        @Deprecated
        public final Builder setCustomChannels(String str) {
            return this;
        }

        @Deprecated
        public final Builder setDescriptionTextColor(int i2) {
            return this;
        }

        @Deprecated
        public final Builder setFontFace(String str) {
            return this;
        }

        @Deprecated
        public final Builder setHeaderTextColor(int i2) {
            return this;
        }

        @Deprecated
        public final Builder setHeaderTextSize(int i2) {
            return this;
        }

        public final Builder setLocation(Location location) {
            this.a.zza(location);
            return this;
        }

        public final Builder setQuery(String str) {
            this.b = str;
            return this;
        }

        public final Builder setRequestAgent(String str) {
            this.a.zzck(str);
            return this;
        }

        public final Builder tagForChildDirectedTreatment(boolean z) {
            this.a.zzz(z);
            return this;
        }
    }

    private SearchAdRequest(Builder builder) {
        this.b = builder.b;
        this.a = new zzzk(builder.a, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzzk a() {
        return this.a;
    }

    @Deprecated
    public final int getAnchorTextColor() {
        return 0;
    }

    @Deprecated
    public final int getBackgroundColor() {
        return 0;
    }

    @Deprecated
    public final int getBackgroundGradientBottom() {
        return 0;
    }

    @Deprecated
    public final int getBackgroundGradientTop() {
        return 0;
    }

    @Deprecated
    public final int getBorderColor() {
        return 0;
    }

    @Deprecated
    public final int getBorderThickness() {
        return 0;
    }

    @Deprecated
    public final int getBorderType() {
        return 0;
    }

    @Deprecated
    public final int getCallButtonColor() {
        return 0;
    }

    @Deprecated
    public final String getCustomChannels() {
        return null;
    }

    public final <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.a.getCustomEventExtrasBundle(cls);
    }

    @Deprecated
    public final int getDescriptionTextColor() {
        return 0;
    }

    @Deprecated
    public final String getFontFace() {
        return null;
    }

    @Deprecated
    public final int getHeaderTextColor() {
        return 0;
    }

    @Deprecated
    public final int getHeaderTextSize() {
        return 0;
    }

    public final Location getLocation() {
        return this.a.getLocation();
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (T) this.a.getNetworkExtras(cls);
    }

    public final <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.a.getNetworkExtrasBundle(cls);
    }

    public final String getQuery() {
        return this.b;
    }

    public final boolean isTestDevice(Context context) {
        return this.a.isTestDevice(context);
    }
}
