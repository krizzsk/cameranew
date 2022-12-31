package com.bytedance.sdk.adnet.d;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* compiled from: UrlBuilder.java */
/* loaded from: classes.dex */
public class g {
    private final Map<String, List<String>> a;
    private String b;

    public g(String str) {
        this.a = new LinkedHashMap();
        this.b = str;
    }

    private String b(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public void a(String str, int i2) {
        List<String> list = this.a.get(str);
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(String.valueOf(i2));
        this.a.put(str, list);
    }

    public String toString() {
        return a();
    }

    public g() {
        this.a = new LinkedHashMap();
        this.b = null;
    }

    public void a(String str, double d2) {
        List<String> list = this.a.get(str);
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(String.valueOf(d2));
        this.a.put(str, list);
    }

    public void a(String str, String str2) {
        List<String> list = this.a.get(str);
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(String.valueOf(str2));
        this.a.put(str, list);
    }

    public String a() {
        StringBuilder sb;
        String str;
        if (this.a.isEmpty()) {
            return this.b;
        }
        String a = a(this.a, "UTF-8");
        String str2 = this.b;
        if (str2 == null || str2.length() == 0) {
            return a;
        }
        if (this.b.indexOf(63) >= 0) {
            sb = new StringBuilder();
            sb.append(this.b);
            str = "&";
        } else {
            sb = new StringBuilder();
            sb.append(this.b);
            str = "?";
        }
        sb.append(str);
        sb.append(a);
        return sb.toString();
    }

    public String a(Map<String, List<String>> map, String str) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String b = b(entry.getKey(), str);
            List<String> value = entry.getValue();
            if (value != null && value.size() > 0) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    String b2 = next != null ? b(next, str) : "";
                    if (sb.length() > 0) {
                        sb.append("&");
                    }
                    sb.append(b);
                    if (!b2.isEmpty()) {
                        sb.append("=");
                        sb.append(b2);
                    }
                }
            }
        }
        return sb.toString();
    }
}
