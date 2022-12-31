package com.bytedance.sdk.a.b;

import androidx.core.location.LocationRequestCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import us.pinguo.common.network.common.header.PGTransHeader;
/* compiled from: Cookie.java */
/* loaded from: classes.dex */
public final class l {
    private static final Pattern a = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern c = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f1097d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: e  reason: collision with root package name */
    private final String f1098e;

    /* renamed from: f  reason: collision with root package name */
    private final String f1099f;

    /* renamed from: g  reason: collision with root package name */
    private final long f1100g;

    /* renamed from: h  reason: collision with root package name */
    private final String f1101h;

    /* renamed from: i  reason: collision with root package name */
    private final String f1102i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f1103j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f1104k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f1105l;
    private final boolean m;

    private l(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f1098e = str;
        this.f1099f = str2;
        this.f1100g = j2;
        this.f1101h = str3;
        this.f1102i = str4;
        this.f1103j = z;
        this.f1104k = z2;
        this.m = z3;
        this.f1105l = z4;
    }

    public String a() {
        return this.f1098e;
    }

    public String b() {
        return this.f1099f;
    }

    public boolean equals(Object obj) {
        if (obj instanceof l) {
            l lVar = (l) obj;
            return lVar.f1098e.equals(this.f1098e) && lVar.f1099f.equals(this.f1099f) && lVar.f1101h.equals(this.f1101h) && lVar.f1102i.equals(this.f1102i) && lVar.f1100g == this.f1100g && lVar.f1103j == this.f1103j && lVar.f1104k == this.f1104k && lVar.f1105l == this.f1105l && lVar.m == this.m;
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.f1100g;
        return ((((((((((((((((527 + this.f1098e.hashCode()) * 31) + this.f1099f.hashCode()) * 31) + this.f1101h.hashCode()) * 31) + this.f1102i.hashCode()) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (!this.f1103j ? 1 : 0)) * 31) + (!this.f1104k ? 1 : 0)) * 31) + (!this.f1105l ? 1 : 0)) * 31) + (!this.m ? 1 : 0);
    }

    public String toString() {
        return a(false);
    }

    private static boolean a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !com.bytedance.sdk.a.b.a.c.c(str);
    }

    private static String b(String str) {
        if (!str.endsWith(".")) {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            String a2 = com.bytedance.sdk.a.b.a.c.a(str);
            if (a2 != null) {
                return a2;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    public static l a(s sVar, String str) {
        return a(System.currentTimeMillis(), sVar, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static com.bytedance.sdk.a.b.l a(long r23, com.bytedance.sdk.a.b.s r25, java.lang.String r26) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.a.b.l.a(long, com.bytedance.sdk.a.b.s, java.lang.String):com.bytedance.sdk.a.b.l");
    }

    private static long a(String str, int i2, int i3) {
        int a2 = a(str, i2, i3, false);
        Matcher matcher = f1097d.matcher(str);
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        while (a2 < i3) {
            int a3 = a(str, a2 + 1, i3, true);
            matcher.region(a2, a3);
            if (i5 == -1 && matcher.usePattern(f1097d).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
                i8 = Integer.parseInt(matcher.group(2));
                i9 = Integer.parseInt(matcher.group(3));
            } else if (i6 == -1 && matcher.usePattern(c).matches()) {
                i6 = Integer.parseInt(matcher.group(1));
            } else {
                if (i7 == -1) {
                    Pattern pattern = b;
                    if (matcher.usePattern(pattern).matches()) {
                        i7 = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                    }
                }
                if (i4 == -1 && matcher.usePattern(a).matches()) {
                    i4 = Integer.parseInt(matcher.group(1));
                }
            }
            a2 = a(str, a3 + 1, i3, false);
        }
        if (i4 >= 70 && i4 <= 99) {
            i4 += 1900;
        }
        if (i4 >= 0 && i4 <= 69) {
            i4 += 2000;
        }
        if (i4 >= 1601) {
            if (i7 != -1) {
                if (i6 < 1 || i6 > 31) {
                    throw new IllegalArgumentException();
                }
                if (i5 < 0 || i5 > 23) {
                    throw new IllegalArgumentException();
                }
                if (i8 < 0 || i8 > 59) {
                    throw new IllegalArgumentException();
                }
                if (i9 >= 0 && i9 <= 59) {
                    GregorianCalendar gregorianCalendar = new GregorianCalendar(com.bytedance.sdk.a.b.a.c.f912g);
                    gregorianCalendar.setLenient(false);
                    gregorianCalendar.set(1, i4);
                    gregorianCalendar.set(2, i7 - 1);
                    gregorianCalendar.set(5, i6);
                    gregorianCalendar.set(11, i5);
                    gregorianCalendar.set(12, i8);
                    gregorianCalendar.set(13, i9);
                    gregorianCalendar.set(14, 0);
                    return gregorianCalendar.getTimeInMillis();
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    private static int a(String str, int i2, int i3, boolean z) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    private static long a(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e2) {
            if (str.matches("-?\\d+")) {
                if (str.startsWith(PGTransHeader.CONNECTOR)) {
                    return Long.MIN_VALUE;
                }
                return LocationRequestCompat.PASSIVE_INTERVAL;
            }
            throw e2;
        }
    }

    public static List<l> a(s sVar, r rVar) {
        List<String> b2 = rVar.b("Set-Cookie");
        int size = b2.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            l a2 = a(sVar, b2.get(i2));
            if (a2 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(a2);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    String a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1098e);
        sb.append('=');
        sb.append(this.f1099f);
        if (this.f1105l) {
            if (this.f1100g == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(com.bytedance.sdk.a.b.a.c.d.a(new Date(this.f1100g)));
            }
        }
        if (!this.m) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.f1101h);
        }
        sb.append("; path=");
        sb.append(this.f1102i);
        if (this.f1103j) {
            sb.append("; secure");
        }
        if (this.f1104k) {
            sb.append("; httponly");
        }
        return sb.toString();
    }
}
