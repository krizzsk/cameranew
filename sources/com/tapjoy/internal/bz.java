package com.tapjoy.internal;

import java.io.InputStream;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.common.network.HttpRequest;
/* loaded from: classes3.dex */
public abstract class bz extends ca {
    public abstract Object a(bn bnVar);

    @Override // com.tapjoy.internal.ca
    public final Map a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(HttpRequest.HEADER_ACCEPT, HttpRequest.CONTENT_TYPE_JSON);
        return linkedHashMap;
    }

    @Override // com.tapjoy.internal.ca
    public final Object a(URI uri, InputStream inputStream) {
        bn a = bn.a(inputStream);
        a.a("BASE_URI", uri);
        int i2 = 0;
        try {
            a.h();
            Object obj = null;
            String str = null;
            while (a.j()) {
                String l2 = a.l();
                if ("status".equals(l2)) {
                    i2 = a.r();
                } else if ("message".equals(l2)) {
                    str = a.m();
                } else if ("data".equals(l2)) {
                    obj = a(a);
                } else {
                    a.s();
                }
            }
            a.i();
            if (i2 == 200) {
                return obj;
            }
            throw new cb(i2, str);
        } finally {
            a.close();
        }
    }
}
