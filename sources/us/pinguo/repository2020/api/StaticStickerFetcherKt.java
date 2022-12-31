package us.pinguo.repository2020.api;

import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.common.network.common.PGNetworkConfig;
import us.pinguo.foundation.j;
import us.pinguo.foundation.utils.v;
import us.pinguo.repository2020.database.staticsticker.ShopDetail;
import us.pinguo.repository2020.database.staticsticker.ShopDetailResponse;
import us.pinguo.repository2020.database.staticsticker.StaticStickerJson;
import us.pinguo.repository2020.database.staticsticker.StaticStickerResponse;
import us.pinguo.repository2020.utils.RequestIntervalPref;
/* compiled from: StaticStickerFetcher.kt */
/* loaded from: classes6.dex */
public final class StaticStickerFetcherKt {
    public static final void a(String pid, p<? super ShopDetail, ? super Throwable, u> pVar) {
        s.h(pid, "pid");
        c cVar = new c("/api/product/unity-static-p-detail", ShopDetailResponse.class);
        cVar.a("packageId", pid);
        cVar.c(new StaticStickerFetcherKt$fetchStickerShopDetailFromRemote$1(pVar));
    }

    public static final void b(boolean z, p<? super StaticStickerJson, ? super Throwable, u> pVar) {
        RequestIntervalPref.RefreshType refreshType;
        if (z) {
            refreshType = RequestIntervalPref.RefreshType.RESET_REFRESH;
        } else {
            int i2 = j.e().i("force_update_static_sticker", 0);
            RequestIntervalPref.RefreshType refreshType2 = RequestIntervalPref.RefreshType.TIME_REFRESH;
            if (i2 >= 0) {
                refreshType = RequestIntervalPref.a.c("/api/product/unity-static", -1L, null);
                if (refreshType == RequestIntervalPref.RefreshType.NONE_REFRESH) {
                    return;
                }
            } else {
                refreshType = refreshType2;
            }
        }
        c cVar = new c("/api/product/unity-static", StaticStickerResponse.class);
        if (refreshType == RequestIntervalPref.RefreshType.RESET_REFRESH) {
            HashMap hashMap = new HashMap();
            Locale a = v.a();
            String language = a.getLanguage();
            String country = a.getCountry();
            if (country == null) {
                country = "";
            }
            PGNetworkConfig.getInstance().resetLocale(language, country);
            hashMap.put("version", "0");
            hashMap.put("UTCOffset", String.valueOf(TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000));
            cVar.b(hashMap);
        }
        cVar.c(new StaticStickerFetcherKt$fetchStickersFromRemote$1(0, pVar));
    }
}
