package org.slf4j.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* compiled from: AndroidLoggerFactory.java */
/* loaded from: classes3.dex */
class a implements org.slf4j.a {
    private final ConcurrentMap<String, org.slf4j.b> a = new ConcurrentHashMap();

    private static String b(String str) {
        int length = str.length();
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            int i2 = lastIndexOf + 1;
            if (length - i2 <= 23) {
                return str.substring(i2);
            }
        }
        return '*' + str.substring((length - 23) + 1);
    }

    static String c(String str) {
        if (str == null) {
            return "null";
        }
        int length = str.length();
        if (length <= 23) {
            return str;
        }
        StringBuilder sb = new StringBuilder(26);
        int i2 = 0;
        int i3 = 0;
        do {
            int indexOf = str.indexOf(46, i2);
            if (indexOf == -1) {
                int i4 = length - i2;
                if (i3 != 0 && i3 + i4 <= 23) {
                    sb.append((CharSequence) str, i2, length);
                    return sb.toString();
                }
                return b(str);
            }
            sb.append(str.charAt(i2));
            if (indexOf - i2 > 1) {
                sb.append('*');
            }
            sb.append('.');
            i2 = indexOf + 1;
            i3 = sb.length();
        } while (i3 <= 23);
        return b(str);
    }

    @Override // org.slf4j.a
    public org.slf4j.b a(String str) {
        String c = c(str);
        org.slf4j.b bVar = this.a.get(c);
        if (bVar == null) {
            AndroidLoggerAdapter androidLoggerAdapter = new AndroidLoggerAdapter(c);
            org.slf4j.b putIfAbsent = this.a.putIfAbsent(c, androidLoggerAdapter);
            return putIfAbsent == null ? androidLoggerAdapter : putIfAbsent;
        }
        return bVar;
    }
}
