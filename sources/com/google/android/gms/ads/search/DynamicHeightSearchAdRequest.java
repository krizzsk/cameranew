package com.google.android.gms.ads.search;

import android.content.Context;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.ads.zzzk;
import com.tapjoy.TJAdUnitConstants;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class DynamicHeightSearchAdRequest {
    private final SearchAdRequest a;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class Builder {
        private final SearchAdRequest.Builder a = new SearchAdRequest.Builder();
        private final Bundle b = new Bundle();

        public final Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.a.addCustomEventExtrasBundle(cls, bundle);
            return this;
        }

        public final Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.a.addNetworkExtras(networkExtras);
            return this;
        }

        public final Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.a.addNetworkExtrasBundle(cls, bundle);
            return this;
        }

        public final DynamicHeightSearchAdRequest build() {
            this.a.addNetworkExtrasBundle(AdMobAdapter.class, this.b);
            return new DynamicHeightSearchAdRequest(this);
        }

        public final Builder setAdBorderSelectors(String str) {
            this.b.putString("csa_adBorderSelectors", str);
            return this;
        }

        public final Builder setAdTest(boolean z) {
            this.b.putString("csa_adtest", z ? TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON : "off");
            return this;
        }

        public final Builder setAdjustableLineHeight(int i2) {
            this.b.putString("csa_adjustableLineHeight", Integer.toString(i2));
            return this;
        }

        public final Builder setAdvancedOptionValue(String str, String str2) {
            this.b.putString(str, str2);
            return this;
        }

        public final Builder setAttributionSpacingBelow(int i2) {
            this.b.putString("csa_attributionSpacingBelow", Integer.toString(i2));
            return this;
        }

        public final Builder setBorderSelections(String str) {
            this.b.putString("csa_borderSelections", str);
            return this;
        }

        public final Builder setChannel(String str) {
            this.b.putString("csa_channel", str);
            return this;
        }

        public final Builder setColorAdBorder(String str) {
            this.b.putString("csa_colorAdBorder", str);
            return this;
        }

        public final Builder setColorAdSeparator(String str) {
            this.b.putString("csa_colorAdSeparator", str);
            return this;
        }

        public final Builder setColorAnnotation(String str) {
            this.b.putString("csa_colorAnnotation", str);
            return this;
        }

        public final Builder setColorAttribution(String str) {
            this.b.putString("csa_colorAttribution", str);
            return this;
        }

        public final Builder setColorBackground(String str) {
            this.b.putString("csa_colorBackground", str);
            return this;
        }

        public final Builder setColorBorder(String str) {
            this.b.putString("csa_colorBorder", str);
            return this;
        }

        public final Builder setColorDomainLink(String str) {
            this.b.putString("csa_colorDomainLink", str);
            return this;
        }

        public final Builder setColorText(String str) {
            this.b.putString("csa_colorText", str);
            return this;
        }

        public final Builder setColorTitleLink(String str) {
            this.b.putString("csa_colorTitleLink", str);
            return this;
        }

        public final Builder setCssWidth(int i2) {
            this.b.putString("csa_width", Integer.toString(i2));
            return this;
        }

        public final Builder setDetailedAttribution(boolean z) {
            this.b.putString("csa_detailedAttribution", Boolean.toString(z));
            return this;
        }

        public final Builder setFontFamily(String str) {
            this.b.putString("csa_fontFamily", str);
            return this;
        }

        public final Builder setFontFamilyAttribution(String str) {
            this.b.putString("csa_fontFamilyAttribution", str);
            return this;
        }

        public final Builder setFontSizeAnnotation(int i2) {
            this.b.putString("csa_fontSizeAnnotation", Integer.toString(i2));
            return this;
        }

        public final Builder setFontSizeAttribution(int i2) {
            this.b.putString("csa_fontSizeAttribution", Integer.toString(i2));
            return this;
        }

        public final Builder setFontSizeDescription(int i2) {
            this.b.putString("csa_fontSizeDescription", Integer.toString(i2));
            return this;
        }

        public final Builder setFontSizeDomainLink(int i2) {
            this.b.putString("csa_fontSizeDomainLink", Integer.toString(i2));
            return this;
        }

        public final Builder setFontSizeTitle(int i2) {
            this.b.putString("csa_fontSizeTitle", Integer.toString(i2));
            return this;
        }

        public final Builder setHostLanguage(String str) {
            this.b.putString("csa_hl", str);
            return this;
        }

        public final Builder setIsClickToCallEnabled(boolean z) {
            this.b.putString("csa_clickToCall", Boolean.toString(z));
            return this;
        }

        public final Builder setIsLocationEnabled(boolean z) {
            this.b.putString("csa_location", Boolean.toString(z));
            return this;
        }

        public final Builder setIsPlusOnesEnabled(boolean z) {
            this.b.putString("csa_plusOnes", Boolean.toString(z));
            return this;
        }

        public final Builder setIsSellerRatingsEnabled(boolean z) {
            this.b.putString("csa_sellerRatings", Boolean.toString(z));
            return this;
        }

        public final Builder setIsSiteLinksEnabled(boolean z) {
            this.b.putString("csa_siteLinks", Boolean.toString(z));
            return this;
        }

        public final Builder setIsTitleBold(boolean z) {
            this.b.putString("csa_titleBold", Boolean.toString(z));
            return this;
        }

        public final Builder setIsTitleUnderlined(boolean z) {
            this.b.putString("csa_noTitleUnderline", Boolean.toString(!z));
            return this;
        }

        public final Builder setLocationColor(String str) {
            this.b.putString("csa_colorLocation", str);
            return this;
        }

        public final Builder setLocationFontSize(int i2) {
            this.b.putString("csa_fontSizeLocation", Integer.toString(i2));
            return this;
        }

        public final Builder setLongerHeadlines(boolean z) {
            this.b.putString("csa_longerHeadlines", Boolean.toString(z));
            return this;
        }

        public final Builder setNumber(int i2) {
            this.b.putString("csa_number", Integer.toString(i2));
            return this;
        }

        public final Builder setPage(int i2) {
            this.b.putString("csa_adPage", Integer.toString(i2));
            return this;
        }

        public final Builder setQuery(String str) {
            this.a.setQuery(str);
            return this;
        }

        public final Builder setVerticalSpacing(int i2) {
            this.b.putString("csa_verticalSpacing", Integer.toString(i2));
            return this;
        }
    }

    private DynamicHeightSearchAdRequest(Builder builder) {
        this.a = builder.a.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzzk a() {
        return this.a.a();
    }

    public final <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.a.getCustomEventExtrasBundle(cls);
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (T) this.a.getNetworkExtras(cls);
    }

    public final <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.a.getNetworkExtrasBundle(cls);
    }

    public final String getQuery() {
        return this.a.getQuery();
    }

    public final boolean isTestDevice(Context context) {
        return this.a.isTestDevice(context);
    }
}
