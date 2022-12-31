package com.bytedance.sdk.openadsdk.h;

import android.net.Uri;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.common.network.common.header.PGTransHeader;
/* compiled from: Request.java */
/* loaded from: classes.dex */
public class i {
    public final c a;
    public final List<b> b;
    public final a c;

    /* compiled from: Request.java */
    /* loaded from: classes.dex */
    static final class a {
        final int a;
        final String b;
        final String c;

        /* renamed from: d  reason: collision with root package name */
        final int f2063d;

        /* renamed from: e  reason: collision with root package name */
        final int f2064e;

        /* renamed from: f  reason: collision with root package name */
        final String f2065f;

        /* renamed from: g  reason: collision with root package name */
        final List<String> f2066g;

        private a(int i2, String str, String str2, int i3, int i4, String str3, List<String> list) {
            this.a = i2;
            this.b = str;
            this.c = str2;
            this.f2063d = i3;
            this.f2064e = i4;
            this.f2065f = str3;
            this.f2066g = list;
        }

        static a a(c cVar, List<b> list) throws d {
            String str;
            int i2;
            int i3;
            int indexOf = cVar.b.indexOf("?");
            if (indexOf != -1) {
                ArrayList arrayList = new ArrayList();
                String str2 = null;
                String str3 = null;
                String str4 = null;
                int i4 = 0;
                for (String str5 : cVar.b.substring(indexOf + 1).split("&")) {
                    String[] split = str5.split("=");
                    if (split.length == 2) {
                        if ("rk".equals(split[0])) {
                            str3 = Uri.decode(split[1]);
                        } else if ("k".equals(split[0])) {
                            str4 = Uri.decode(split[1]);
                        } else if (split[0].startsWith("u")) {
                            arrayList.add(Uri.decode(split[1]));
                        } else if ("f".equals(split[0]) && com.bytedance.sdk.openadsdk.h.g.d.b(split[1]) == 1) {
                            i4 = 1;
                        }
                    }
                }
                if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                    if (list != null) {
                        i3 = 0;
                        int i5 = 0;
                        for (b bVar : list) {
                            if (bVar != null && "Range".equalsIgnoreCase(bVar.a)) {
                                int indexOf2 = bVar.b.indexOf("=");
                                if (indexOf2 != -1) {
                                    if ("bytes".equalsIgnoreCase(bVar.b.substring(0, indexOf2).trim())) {
                                        String substring = bVar.b.substring(indexOf2 + 1);
                                        if (!substring.contains(",")) {
                                            int indexOf3 = substring.indexOf(PGTransHeader.CONNECTOR);
                                            if (indexOf3 != -1) {
                                                String trim = substring.substring(0, indexOf3).trim();
                                                String trim2 = substring.substring(indexOf3 + 1).trim();
                                                try {
                                                    if (trim.length() > 0) {
                                                        i3 = Integer.parseInt(trim);
                                                    }
                                                    if (trim2.length() > 0 && i3 > (i5 = Integer.parseInt(trim2))) {
                                                        throw new d("Range format error, Range: " + bVar.b);
                                                    }
                                                    str2 = bVar.b;
                                                } catch (NumberFormatException unused) {
                                                    throw new d("Range format error, Range: " + bVar.b);
                                                }
                                            } else {
                                                throw new d("Range format error, Range: " + bVar.b);
                                            }
                                        } else {
                                            throw new d("Range format error, Range: " + bVar.b);
                                        }
                                    } else {
                                        throw new d("Range format error, Range: " + bVar.b);
                                    }
                                } else {
                                    throw new d("Range format error, Range: " + bVar.b);
                                }
                            }
                        }
                        i2 = i5;
                        str = str2;
                    } else {
                        str = null;
                        i2 = 0;
                        i3 = 0;
                    }
                    if (!arrayList.isEmpty()) {
                        return new a(i4, str3, str4, i3, i2, str, arrayList);
                    }
                    throw new d("no url found: path: " + cVar.b);
                }
                throw new d("rawKey or key is empty, path: " + cVar.b);
            }
            throw new d("path format error, path: " + cVar.b);
        }

        public String toString() {
            return "Extra{flag=" + this.a + ", rawKey='" + this.b + "', key='" + this.c + "', from=" + this.f2063d + ", to=" + this.f2064e + ", urls=" + this.f2066g + '}';
        }
    }

    /* compiled from: Request.java */
    /* loaded from: classes.dex */
    public static final class b {
        public final String a;
        public final String b;

        public b(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        static b a(String str) throws d {
            int indexOf = str.indexOf(":");
            if (indexOf != -1) {
                String trim = str.substring(0, indexOf).trim();
                String trim2 = str.substring(indexOf + 1).trim();
                if (trim.length() != 0 && trim2.length() != 0) {
                    return new b(trim, trim2);
                }
                throw new d("request header format error, header: " + str);
            }
            throw new d("request header format error, header: " + str);
        }

        public String toString() {
            return "Header{name='" + this.a + "', value='" + this.b + "'}";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Request.java */
    /* loaded from: classes.dex */
    public static final class c {
        final String a;
        final String b;
        final String c;

        private c(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        static c a(String str) throws d {
            int indexOf = str.indexOf(32);
            if (indexOf != -1) {
                int lastIndexOf = str.lastIndexOf(32);
                if (lastIndexOf > indexOf) {
                    String trim = str.substring(0, indexOf).trim();
                    String trim2 = str.substring(indexOf + 1, lastIndexOf).trim();
                    String trim3 = str.substring(lastIndexOf + 1).trim();
                    if (trim.length() != 0 && trim2.length() != 0 && trim3.length() != 0) {
                        return new c(trim, trim2, trim3);
                    }
                    throw new d("request line format error, line: " + str);
                }
                throw new d("request line format error, line: " + str);
            }
            throw new d("request line format error, line: " + str);
        }

        public String toString() {
            return "RequestLine{method='" + this.a + "', path='" + this.b + "', version='" + this.c + "'}";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Request.java */
    /* loaded from: classes.dex */
    public static final class d extends Exception {
        d(String str) {
            super(str);
        }
    }

    public i(c cVar, List<b> list, a aVar) {
        this.a = cVar;
        this.b = list;
        this.c = aVar;
    }

    public static i a(InputStream inputStream) throws IOException, d {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, com.bytedance.sdk.openadsdk.h.g.d.a));
        ArrayList arrayList = new ArrayList();
        c cVar = null;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                break;
            }
            String trim = readLine.trim();
            if (cVar == null) {
                cVar = c.a(trim);
            } else {
                arrayList.add(b.a(trim));
            }
        }
        if (cVar != null) {
            return new i(cVar, arrayList, a.a(cVar, arrayList));
        }
        throw new d("request line is null");
    }

    public String toString() {
        return "Request{requestLine=" + this.a + ", headers=" + this.b + ", extra=" + this.c + '}';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, String str2, List<String> list) {
        StringBuilder sb = new StringBuilder(512);
        String str3 = null;
        do {
            if (str3 != null) {
                if (list.size() == 1) {
                    return null;
                }
                list.remove(list.size() - 1);
            }
            str3 = a(sb, str, str2, list);
        } while (str3.length() > 3072);
        return str3;
    }

    private static String a(StringBuilder sb, String str, String str2, List<String> list) {
        sb.delete(0, sb.length());
        sb.append("rk");
        sb.append("=");
        sb.append(Uri.encode(str));
        sb.append("&");
        sb.append("k");
        sb.append("=");
        sb.append(Uri.encode(str2));
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append("&");
            sb.append("u");
            sb.append(i2);
            sb.append("=");
            sb.append(Uri.encode(list.get(i2)));
        }
        return sb.toString();
    }
}
