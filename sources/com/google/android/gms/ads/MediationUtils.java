package com.google.android.gms.ads;

import android.content.Context;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public class MediationUtils {
    public static AdSize findClosestSize(Context context, AdSize adSize, List<AdSize> list) {
        AdSize adSize2 = null;
        if (list != null && adSize != null) {
            if (!adSize.c()) {
                float f2 = context.getResources().getDisplayMetrics().density;
                adSize = new AdSize(Math.round(adSize.getWidthInPixels(context) / f2), Math.round(adSize.getHeightInPixels(context) / f2));
            }
            for (AdSize adSize3 : list) {
                boolean z = false;
                if (adSize3 != null) {
                    int width = adSize.getWidth();
                    int width2 = adSize3.getWidth();
                    int height = adSize.getHeight();
                    int height2 = adSize3.getHeight();
                    if (width * 0.5d <= width2 && width >= width2 && (!adSize.c() ? !(height * 0.7d > height2 || height < height2) : adSize.d() >= height2)) {
                        z = true;
                    }
                }
                if (z && (adSize2 == null || adSize2.getWidth() * adSize2.getHeight() <= adSize3.getWidth() * adSize3.getHeight())) {
                    adSize2 = adSize3;
                }
            }
        }
        return adSize2;
    }
}
