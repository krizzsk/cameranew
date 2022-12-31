package com.bytedance.sdk.a.b;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import us.pinguo.common.network.HttpRequest;
/* compiled from: MediaType.java */
/* loaded from: classes.dex */
public final class u {
    private static final Pattern a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    private final String c;

    /* renamed from: d  reason: collision with root package name */
    private final String f1126d;

    /* renamed from: e  reason: collision with root package name */
    private final String f1127e;

    /* renamed from: f  reason: collision with root package name */
    private final String f1128f;

    private u(String str, String str2, String str3, String str4) {
        this.c = str;
        this.f1126d = str2;
        this.f1127e = str3;
        this.f1128f = str4;
    }

    public static u a(String str) {
        Matcher matcher = a.matcher(str);
        if (matcher.lookingAt()) {
            String group = matcher.group(1);
            Locale locale = Locale.US;
            String lowerCase = group.toLowerCase(locale);
            String lowerCase2 = matcher.group(2).toLowerCase(locale);
            Matcher matcher2 = b.matcher(str);
            String str2 = null;
            for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
                matcher2.region(end, str.length());
                if (!matcher2.lookingAt()) {
                    return null;
                }
                String group2 = matcher2.group(1);
                if (group2 != null && group2.equalsIgnoreCase(HttpRequest.PARAM_CHARSET)) {
                    String group3 = matcher2.group(2);
                    if (group3 != null) {
                        if (group3.startsWith("'") && group3.endsWith("'") && group3.length() > 2) {
                            group3 = group3.substring(1, group3.length() - 1);
                        }
                    } else {
                        group3 = matcher2.group(3);
                    }
                    if (str2 != null && !group3.equalsIgnoreCase(str2)) {
                        return null;
                    }
                    str2 = group3;
                }
            }
            return new u(str, lowerCase, lowerCase2, str2);
        }
        return null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof u) && ((u) obj).c.equals(this.c);
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        return this.c;
    }
}
