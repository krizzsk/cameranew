package com.google.ads.mediation.customevent;

import com.google.ads.mediation.MediationServerParameters;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.firebase.messaging.Constants;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes.dex */
public final class c extends MediationServerParameters {
    @MediationServerParameters.a(name = Constants.ScionAnalytics.PARAM_LABEL, required = true)
    public String a;
    @MediationServerParameters.a(name = "class_name", required = true)
    public String b;
    @MediationServerParameters.a(name = MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD, required = false)
    public String c = null;
}
