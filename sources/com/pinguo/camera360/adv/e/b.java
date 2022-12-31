package com.pinguo.camera360.adv.e;

import android.app.Activity;
import android.view.ViewGroup;
import com.pinguo.camera360.adv.e.c.c;
import com.pinguo.camera360.adv.e.g.d;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
/* compiled from: PGAdvViewFactory.java */
/* loaded from: classes3.dex */
public class b {
    public static c a(Activity activity, us.pinguo.advsdk.a.b bVar, ViewGroup viewGroup, String str) {
        if (IADStatisticBase.UNIT_ID_RESULT_BANNER.equals(str)) {
            if (bVar.l() == 20) {
                return new com.pinguo.camera360.adv.e.g.c(activity, bVar, viewGroup);
            }
            return new d(activity, bVar, viewGroup);
        } else if (!IADStatisticBase.UNIT_ID_ALBUM_TOP_GIF.equals(str) && !IADStatisticBase.UNIT_ID_CHALLENGE_GIFT.equals(str) && !IADStatisticBase.UNIT_ID_RESULT_GIFT.equals(str) && !IADStatisticBase.UNIT_ID_HOME_GIFT.equals(str)) {
            if (IADStatisticBase.UNIT_ID_ALBUM_BOTTOM_BANNER.equals(str)) {
                return new com.pinguo.camera360.adv.e.d.a(activity, bVar, viewGroup);
            }
            if (IADStatisticBase.UNIT_ID_FUNCTION_2.equals(str)) {
                return new com.pinguo.camera360.adv.e.f.a(activity, bVar, viewGroup);
            }
            if (IADStatisticBase.UNIT_ID_HOME_BANNER.equals(str)) {
                return new com.pinguo.camera360.adv.e.e.a(activity, bVar, viewGroup);
            }
            return null;
        } else {
            return new com.pinguo.camera360.adv.e.d.b(activity, bVar, viewGroup);
        }
    }
}
