package com.bytedance.sdk.openadsdk.j;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ab;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
/* compiled from: TrackAdUrlUtils.java */
/* loaded from: classes.dex */
public class e {
    private static int a(int i2) {
        int i3 = 2;
        if (i2 != 2) {
            i3 = 3;
            if (i2 != 3) {
                i3 = 4;
                if (i2 != 4) {
                    i3 = 5;
                    if (i2 != 5 && i2 != 15) {
                        return -1;
                    }
                }
            }
        }
        return i3;
    }

    public static List<String> a(List<String> list, boolean z) {
        String a = j.a(o.a());
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.contains("{TS}") || next.contains("__TS__")) {
                long currentTimeMillis = System.currentTimeMillis();
                next = next.replace("{TS}", String.valueOf(currentTimeMillis)).replace("__TS__", String.valueOf(currentTimeMillis));
            }
            if ((next.contains("{UID}") || next.contains("__UID__")) && !TextUtils.isEmpty(a)) {
                next = next.replace("{UID}", a).replace("__UID__", a);
            }
            if (z) {
                next = a(next);
            }
            arrayList.add(next);
        }
        return arrayList;
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return str.replace("[ss_random]", String.valueOf(new Random().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static List<String> a(List<String> list, boolean z, com.bytedance.sdk.openadsdk.core.d.h hVar) {
        String a = j.a(o.a());
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.contains("{TS}") || next.contains("__TS__")) {
                long currentTimeMillis = System.currentTimeMillis();
                next = next.replace("{TS}", String.valueOf(currentTimeMillis)).replace("__TS__", String.valueOf(currentTimeMillis));
            }
            if ((next.contains("{UID}") || next.contains("__UID__")) && !TextUtils.isEmpty(a)) {
                next = next.replace("{UID}", a).replace("__UID__", a);
            }
            if (next.contains("__CID__") && hVar != null && !TextUtils.isEmpty(hVar.J())) {
                next = next.replace("__CID__", hVar.J());
            }
            if (next.contains("__CTYPE__") && hVar != null) {
                next = next.replace("__CTYPE__", String.valueOf(a(hVar.N())));
            }
            if (next.contains("__GAID__")) {
                next = next.replace("__GAID__", d.a.a.a.a.b.a.a().e());
            }
            if (next.contains("__ANDROIDID1__")) {
                next = next.replace("__ANDROIDID1__", j.c(o.a()));
            }
            if (next.contains("__OS__")) {
                next = next.replace("__OS__", "0");
            }
            if (next.contains("__IP__")) {
                next = next.replace("__IP__", com.bytedance.sdk.openadsdk.utils.g.a(true));
            }
            if (next.contains("__UA1__")) {
                next = next.replace("__UA1__", URLEncoder.encode(ab.c()));
            }
            if (z) {
                next = a(next);
            }
            arrayList.add(next);
        }
        return arrayList;
    }
}
