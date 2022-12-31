package com.google.android.gms.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzzj;
import com.google.android.gms.internal.ads.zzzk;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;
import java.util.List;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public class AdRequest {
    public static final String DEVICE_ID_EMULATOR = "B3EEABB8EE11C2BE770B684D95219ECB";
    public static final int ERROR_CODE_APP_ID_MISSING = 8;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_MEDIATION_NO_FILL = 9;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    @Deprecated
    public static final String MAX_AD_CONTENT_RATING_G = "G";
    @Deprecated
    public static final String MAX_AD_CONTENT_RATING_MA = "MA";
    @Deprecated
    public static final String MAX_AD_CONTENT_RATING_PG = "PG";
    @Deprecated
    public static final String MAX_AD_CONTENT_RATING_T = "T";
    public static final int MAX_CONTENT_URL_LENGTH = 512;
    @Deprecated
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_FALSE = 0;
    @Deprecated
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_TRUE = 1;
    @Deprecated
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_UNSPECIFIED = -1;
    protected final zzzk a;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes2.dex */
    public static class Builder {
        protected final zzzj a;

        public Builder() {
            zzzj zzzjVar = new zzzj();
            this.a = zzzjVar;
            zzzjVar.zzcg("B3EEABB8EE11C2BE770B684D95219ECB");
        }

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.a.zzb(cls, bundle);
            return this;
        }

        public Builder addKeyword(String str) {
            this.a.zzcf(str);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.a.zza(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationExtrasReceiver> cls, Bundle bundle) {
            this.a.zza(cls, bundle);
            if (cls.equals(AdMobAdapter.class) && bundle.getBoolean("_emulatorLiveAds")) {
                this.a.zzch("B3EEABB8EE11C2BE770B684D95219ECB");
            }
            return this;
        }

        @Deprecated
        public Builder addTestDevice(String str) {
            this.a.zzcg(str);
            return this;
        }

        public AdRequest build() {
            return new AdRequest(this);
        }

        public Builder setAdInfo(AdInfo adInfo) {
            this.a.zza(adInfo);
            return this;
        }

        @Deprecated
        public Builder setBirthday(Date date) {
            this.a.zza(date);
            return this;
        }

        public Builder setContentUrl(String str) {
            q.k(str, "Content URL must be non-null.");
            q.g(str, "Content URL must be non-empty.");
            q.c(str.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", 512, Integer.valueOf(str.length()));
            this.a.zzci(str);
            return this;
        }

        @Deprecated
        public Builder setGender(int i2) {
            this.a.zzcw(i2);
            return this;
        }

        public Builder setHttpTimeoutMillis(int i2) {
            this.a.zzcy(i2);
            return this;
        }

        @Deprecated
        public Builder setIsDesignedForFamilies(boolean z) {
            this.a.zzaa(z);
            return this;
        }

        public Builder setLocation(Location location) {
            this.a.zza(location);
            return this;
        }

        @Deprecated
        public Builder setMaxAdContentRating(String str) {
            this.a.zzcm(str);
            return this;
        }

        public Builder setNeighboringContentUrls(List<String> list) {
            if (list == null) {
                zzazk.zzex("neighboring content URLs list should not be null");
                return this;
            }
            this.a.zzc(list);
            return this;
        }

        public Builder setRequestAgent(String str) {
            this.a.zzck(str);
            return this;
        }

        @Deprecated
        public Builder setTagForUnderAgeOfConsent(int i2) {
            this.a.zzcx(i2);
            return this;
        }

        @Deprecated
        public Builder tagForChildDirectedTreatment(boolean z) {
            this.a.zzz(z);
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    @Retention(RetentionPolicy.SOURCE)
    @Deprecated
    /* loaded from: classes2.dex */
    public @interface MaxAdContentRating {
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    @Retention(RetentionPolicy.SOURCE)
    @Deprecated
    /* loaded from: classes2.dex */
    public @interface TagForUnderAgeOfConsent {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AdRequest(Builder builder) {
        this.a = new zzzk(builder.a);
    }

    @Deprecated
    public Date getBirthday() {
        return this.a.getBirthday();
    }

    public String getContentUrl() {
        return this.a.getContentUrl();
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.a.getCustomEventExtrasBundle(cls);
    }

    public Bundle getCustomTargeting() {
        return this.a.getCustomTargeting();
    }

    @Deprecated
    public int getGender() {
        return this.a.getGender();
    }

    public Set<String> getKeywords() {
        return this.a.getKeywords();
    }

    public Location getLocation() {
        return this.a.getLocation();
    }

    public List<String> getNeighboringContentUrls() {
        return this.a.zzrh();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (T) this.a.getNetworkExtras(cls);
    }

    public <T extends MediationExtrasReceiver> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.a.getNetworkExtrasBundle(cls);
    }

    public boolean isTestDevice(Context context) {
        return this.a.isTestDevice(context);
    }

    public zzzk zzds() {
        return this.a;
    }
}
