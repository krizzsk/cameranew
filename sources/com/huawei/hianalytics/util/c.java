package com.huawei.hianalytics.util;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class c {
    public static void a(com.huawei.hianalytics.a.c cVar, com.huawei.hianalytics.a.b bVar) {
        if (TextUtils.isEmpty(bVar.h()) || bVar.h().length() > 4096) {
            com.huawei.hianalytics.b.b.c("HiAnalytics", "androidId Parameter error!");
            cVar.h("");
        } else {
            cVar.h(bVar.h());
        }
        if (TextUtils.isEmpty(bVar.i()) || bVar.i().length() > 4096) {
            com.huawei.hianalytics.b.b.c("HiAnalytics", "IMEI Parameter error!");
            cVar.g("");
        } else {
            cVar.g(bVar.i());
        }
        if (!TextUtils.isEmpty(bVar.j()) && bVar.j().length() <= 4096) {
            cVar.j(bVar.j());
            return;
        }
        com.huawei.hianalytics.b.b.c("HiAnalytics", "UDID Parameter error!");
        cVar.j("");
    }
}
