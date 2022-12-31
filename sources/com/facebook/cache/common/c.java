package com.facebook.cache.common;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
/* compiled from: CacheKeyUtil.java */
/* loaded from: classes.dex */
public final class c {
    public static String a(b bVar) {
        try {
            if (bVar instanceof d) {
                return c(((d) bVar).d().get(0));
            }
            return c(bVar);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static List<String> b(b bVar) {
        ArrayList arrayList;
        try {
            if (bVar instanceof d) {
                List<b> d2 = ((d) bVar).d();
                arrayList = new ArrayList(d2.size());
                for (int i2 = 0; i2 < d2.size(); i2++) {
                    arrayList.add(c(d2.get(i2)));
                }
            } else {
                arrayList = new ArrayList(1);
                arrayList.add(bVar.c() ? bVar.a() : c(bVar));
            }
            return arrayList;
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static String c(b bVar) throws UnsupportedEncodingException {
        return com.facebook.common.util.b.a(bVar.a().getBytes("UTF-8"));
    }
}
