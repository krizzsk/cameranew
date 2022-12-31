package com.tapjoy.internal;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public final class cu {
    public final cx a;
    final WebView b;
    public final List c;

    /* renamed from: d  reason: collision with root package name */
    final String f7347d;

    /* renamed from: e  reason: collision with root package name */
    public final String f7348e;

    /* renamed from: f  reason: collision with root package name */
    public final cv f7349f;

    private cu(cx cxVar, String str, List list, String str2) {
        cv cvVar;
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        this.a = cxVar;
        this.b = null;
        this.f7347d = str;
        if (list != null) {
            arrayList.addAll(list);
            cvVar = cv.NATIVE;
        } else {
            cvVar = cv.HTML;
        }
        this.f7349f = cvVar;
        this.f7348e = str2;
    }

    public static cu a(cx cxVar, String str, List list, String str2) {
        Cdo.a(cxVar, "Partner is null");
        Cdo.a((Object) str, "OM SDK JS script content is null");
        Cdo.a(list, "VerificationScriptResources is null");
        if (str2.length() <= 256) {
            return new cu(cxVar, str, list, str2);
        }
        throw new IllegalArgumentException("CustomReferenceData is greater than 256 characters");
    }
}
