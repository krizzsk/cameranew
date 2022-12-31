package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzvq {
    public static final zzvq zzcif = new zzvq();

    protected zzvq() {
    }

    public static zzvl zza(Context context, zzzk zzzkVar) {
        Context context2;
        List list;
        zzve zzveVar;
        String str;
        Date birthday = zzzkVar.getBirthday();
        long time = birthday != null ? birthday.getTime() : -1L;
        String contentUrl = zzzkVar.getContentUrl();
        int gender = zzzkVar.getGender();
        Set<String> keywords = zzzkVar.getKeywords();
        if (keywords.isEmpty()) {
            context2 = context;
            list = null;
        } else {
            list = Collections.unmodifiableList(new ArrayList(keywords));
            context2 = context;
        }
        boolean isTestDevice = zzzkVar.isTestDevice(context2);
        Location location = zzzkVar.getLocation();
        Bundle networkExtrasBundle = zzzkVar.getNetworkExtrasBundle(AdMobAdapter.class);
        if (zzzkVar.zzro() != null) {
            zzveVar = new zzve(zzzkVar.zzro().getAdString(), zzwr.zzqv().containsKey(zzzkVar.zzro().getQueryInfo()) ? zzwr.zzqv().get(zzzkVar.zzro().getQueryInfo()) : "");
        } else {
            zzveVar = null;
        }
        boolean manualImpressionsEnabled = zzzkVar.getManualImpressionsEnabled();
        String publisherProvidedId = zzzkVar.getPublisherProvidedId();
        SearchAdRequest zzrj = zzzkVar.zzrj();
        zzaaq zzaaqVar = zzrj != null ? new zzaaq(zzrj) : null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzwr.zzqn();
            str = zzaza.zza(Thread.currentThread().getStackTrace(), packageName);
        } else {
            str = null;
        }
        boolean isDesignedForFamilies = zzzkVar.isDesignedForFamilies();
        RequestConfiguration requestConfiguration = zzzn.zzrs().getRequestConfiguration();
        return new zzvl(8, time, networkExtrasBundle, gender, list, isTestDevice, Math.max(zzzkVar.zzrm(), requestConfiguration.getTagForChildDirectedTreatment()), manualImpressionsEnabled, publisherProvidedId, zzaaqVar, location, contentUrl, zzzkVar.zzrl(), zzzkVar.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(zzzkVar.zzrn())), zzzkVar.zzri(), str, isDesignedForFamilies, zzveVar, Math.max(zzzkVar.zzrp(), requestConfiguration.getTagForUnderAgeOfConsent()), (String) Collections.max(Arrays.asList(zzzkVar.getMaxAdContentRating(), requestConfiguration.getMaxAdContentRating()), zzvp.zzcie), zzzkVar.zzrh(), zzzkVar.zzrq());
    }

    public static zzava zza(Context context, zzzk zzzkVar, String str) {
        return new zzava(zza(context, zzzkVar), str);
    }
}
