package us.pinguo.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* compiled from: HttpParamsSignUtils.kt */
/* loaded from: classes6.dex */
public final class o {
    public static final o a = new o();

    private o() {
    }

    public static final String a(String url, String method, List<String> paramList, String secretKey) {
        kotlin.jvm.internal.s.h(url, "url");
        kotlin.jvm.internal.s.h(method, "method");
        kotlin.jvm.internal.s.h(paramList, "paramList");
        kotlin.jvm.internal.s.h(secretKey, "secretKey");
        if (paramList.isEmpty()) {
            return "";
        }
        Collections.sort(paramList, b.a);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(url);
        stringBuffer.append(method);
        for (String str : paramList) {
            stringBuffer.append(str);
        }
        try {
            i iVar = i.a;
            String stringBuffer2 = stringBuffer.toString();
            kotlin.jvm.internal.s.g(stringBuffer2, "params.toString()");
            String d2 = iVar.d(stringBuffer2, secretKey);
            us.pinguo.common.log.a.c("Get signature for : " + ((Object) stringBuffer) + " and ops sig is : " + d2, new Object[0]);
            return d2;
        } catch (UnsupportedEncodingException e2) {
            us.pinguo.common.log.a.f(e2);
            return "";
        }
    }

    public static final String b(String url, String method, Map<String, String> params, String secretKey) {
        kotlin.jvm.internal.s.h(url, "url");
        kotlin.jvm.internal.s.h(method, "method");
        kotlin.jvm.internal.s.h(params, "params");
        kotlin.jvm.internal.s.h(secretKey, "secretKey");
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            arrayList.add(entry.getKey() + '=' + entry.getValue());
        }
        return a(url, method, arrayList, secretKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int c(String str, String s2) {
        kotlin.jvm.internal.s.g(s2, "s2");
        return str.compareTo(s2);
    }

    public static final String d(List<String> paramList, String signKey) {
        kotlin.jvm.internal.s.h(paramList, "paramList");
        kotlin.jvm.internal.s.h(signKey, "signKey");
        if (paramList.isEmpty()) {
            return "";
        }
        Collections.sort(paramList, a.a);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : paramList) {
            stringBuffer.append(str);
        }
        try {
            String stringBuffer2 = stringBuffer.toString();
            kotlin.jvm.internal.s.g(stringBuffer2, "params.toString()");
            String h2 = i.h(stringBuffer2, signKey);
            us.pinguo.common.log.a.c("Get signature for : " + ((Object) stringBuffer) + " and sig is : " + h2, new Object[0]);
            return h2;
        } catch (UnsupportedEncodingException e2) {
            us.pinguo.common.log.a.f(e2);
            return "";
        }
    }

    public static final String e(Map<String, String> params, String signKey) {
        kotlin.jvm.internal.s.h(params, "params");
        kotlin.jvm.internal.s.h(signKey, "signKey");
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            arrayList.add(entry.getKey() + '=' + entry.getValue());
        }
        return d(arrayList, signKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int f(String str, String s2) {
        kotlin.jvm.internal.s.g(s2, "s2");
        return str.compareTo(s2);
    }
}
