package com.pinguo.camera360.utils;

import com.tapjoy.TJAdUnitConstants;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.j;
import us.pinguo.repository2020.ServiceControlRepository;
import us.pinguo.repository2020.entity.ServiceControlSwitch;
/* compiled from: RecommendationManager.kt */
/* loaded from: classes3.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    public final boolean a() {
        return s.c(TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON, j.e().k("pref_personalized_recommendation_key", TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON));
    }

    public final boolean b() {
        Integer recommendSwitchOn;
        ServiceControlSwitch a2 = ServiceControlRepository.a.a();
        return (a2 == null || (recommendSwitchOn = a2.getRecommendSwitchOn()) == null || recommendSwitchOn.intValue() != 1) ? false : true;
    }
}
