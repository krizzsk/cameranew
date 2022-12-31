package com.huawei.hianalytics.v2.a.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hianalytics.util.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public final class f implements l {
    private static f a;
    private Context b;

    private f(Context context) {
        this.b = context.getApplicationContext();
    }

    public static synchronized f a(Context context) {
        f fVar;
        synchronized (f.class) {
            if (a == null) {
                a = new f(context);
            }
            fVar = a;
        }
        return fVar;
    }

    @SuppressLint({"ApplySharedPref"})
    private void a() {
        com.huawei.hianalytics.b.b.b("HiAnalytics", "clear data file start!");
        SharedPreferences a2 = com.huawei.hianalytics.util.k.a(this.b, "stat_v2");
        if (a2 != null) {
            SharedPreferences.Editor edit = a2.edit();
            edit.remove("events");
            edit.commit();
        }
        com.huawei.hianalytics.util.l.b(this.b, "cached_v2");
    }

    private void a(List<c> list, String str) {
        int i2;
        int size = list.size();
        if (size <= 0) {
            com.huawei.hianalytics.b.b.b("HiAnalytics", "no events to send");
            return;
        }
        for (int i3 = 0; i3 < size; i3 = i2) {
            i2 = i3 + 500;
            if (i2 > size) {
                i2 = size;
            }
            try {
                b(list.subList(i3, i2), str);
            } catch (d.a unused) {
                com.huawei.hianalytics.b.b.c("EventReportTask", "doHandleEvents(): RSAEncryptionException");
            }
        }
    }

    private <T, T2> void a(List<T> list, List<T2> list2, Map<Object, String> map, m mVar, String str) {
        com.huawei.hianalytics.b.b.a("EventReportTask", "choiceHandleEvents type: " + str);
        List<c> a2 = o.a((com.huawei.hianalytics.v2.a.a.e[]) list.toArray(new com.huawei.hianalytics.v2.a.a.e[list.size()]), (com.huawei.hianalytics.v2.a.a.a[]) list2.toArray(new com.huawei.hianalytics.v2.a.a.a[list2.size()]));
        if (TextUtils.isEmpty(map.get(str))) {
            com.huawei.hianalytics.b.b.b("HiAnalytics", "no upload url now");
            if ("preins".equals(str)) {
                new p(this.b).a();
            }
        }
        a(a2, str);
    }

    private <T> void a(T[] tArr, List<T>... listArr) {
        List<T> list;
        for (T t : tArr) {
            String d2 = (t instanceof com.huawei.hianalytics.v2.a.a.e ? (com.huawei.hianalytics.v2.a.a.e) t : (com.huawei.hianalytics.v2.a.a.a) t).d();
            if (TextUtils.isEmpty(d2) || "oper".equals(d2)) {
                list = listArr[0];
            } else if ("maint".equals(d2)) {
                list = listArr[1];
            } else if ("preins".equals(d2)) {
                list = listArr[2];
            }
            list.add(t);
        }
    }

    private void b(List<c> list, String str) {
        String str2;
        com.huawei.hianalytics.v2.a.a.f a2 = o.a(list, this.b);
        if (a2.a().length > 0) {
            q b = q.b();
            if (b != null) {
                b.a(new b(this.b, a2, str));
                return;
            }
            str2 = "falied to start data send task!";
        } else {
            str2 = "empty event data, no need to send";
        }
        com.huawei.hianalytics.b.b.b("HiAnalytics", str2);
    }

    @Override // java.lang.Runnable
    public void run() {
        com.huawei.hianalytics.b.b.b("HiAnalytics", "run report");
        m a2 = h.a();
        HashMap<Object, String> y = a2.d().y();
        if (y == null) {
            return;
        }
        com.huawei.hianalytics.v2.a.a.e[] a3 = com.huawei.hianalytics.v2.a.a.e.a(com.huawei.hianalytics.util.e.a(this.b), this.b);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        a(a3, arrayList, arrayList2, arrayList3);
        a(com.huawei.hianalytics.v2.a.a.a.b(com.huawei.hianalytics.util.e.b(this.b)), arrayList4, arrayList5, arrayList6);
        a();
        com.huawei.hianalytics.util.a.a(this.b).a(com.huawei.hianalytics.util.d.a());
        if (arrayList.size() > 0 || arrayList4.size() > 0) {
            a(arrayList, arrayList4, y, a2, "oper");
        }
        if (arrayList2.size() > 0 || arrayList5.size() > 0) {
            a(arrayList2, arrayList5, y, a2, "maint");
        }
        if (arrayList3.size() > 0 || arrayList6.size() > 0) {
            a(arrayList3, arrayList6, y, a2, "preins");
        }
    }
}
