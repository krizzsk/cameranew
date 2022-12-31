package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.CappingManager;
import com.ironsource.mediationsdk.utils.ContextProvider;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: BannerUtils.java */
/* loaded from: classes2.dex */
public class h {

    /* compiled from: BannerUtils.java */
    /* loaded from: classes2.dex */
    interface a {
        void a(Map<String, Object> map, List<String> list, StringBuilder sb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BannerUtils.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a(String str);

        void b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, ConcurrentHashMap<String, ProgBannerSmash> concurrentHashMap, a aVar) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        if (!CappingManager.m(ContextProvider.getInstance().b(), str)) {
            for (ProgBannerSmash progBannerSmash : concurrentHashMap.values()) {
                if (progBannerSmash.L()) {
                    Map<String, Object> Q = progBannerSmash.Q();
                    if (Q != null) {
                        hashMap.put(progBannerSmash.x(), Q);
                        sb.append("2" + progBannerSmash.x() + ",");
                    }
                } else if (!progBannerSmash.L()) {
                    arrayList.add(progBannerSmash.x());
                    sb.append("1" + progBannerSmash.x() + ",");
                }
            }
        }
        aVar.a(hashMap, arrayList, sb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b(long j2, long j3) {
        return j3 - (new Date().getTime() - j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(IronSourceBannerLayout ironSourceBannerLayout) {
        return (ironSourceBannerLayout == null || ironSourceBannerLayout.h()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(IronSourceBannerLayout ironSourceBannerLayout, com.ironsource.mediationsdk.model.h hVar, b bVar) {
        String str;
        if (c(ironSourceBannerLayout)) {
            str = null;
        } else {
            Object[] objArr = new Object[1];
            objArr[0] = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
            str = String.format("can't load banner - %s", objArr);
        }
        if (hVar == null || TextUtils.isEmpty(hVar.c())) {
            Object[] objArr2 = new Object[1];
            objArr2[0] = hVar == null ? "placement is null" : "placement name is empty";
            str = String.format("can't load banner - %s", objArr2);
        }
        if (!TextUtils.isEmpty(str)) {
            IronLog.INTERNAL.error(str);
            bVar.a(str);
            return;
        }
        bVar.b();
    }
}
