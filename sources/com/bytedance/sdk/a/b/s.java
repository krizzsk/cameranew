package com.bytedance.sdk.a.b;

import com.growingio.android.sdk.collection.Constants;
import com.growingio.android.sdk.java_websocket.WebSocket;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.slf4j.Marker;
/* compiled from: HttpUrl.java */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: d  reason: collision with root package name */
    private static final char[] f1111d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    final String a;
    final String b;
    final int c;

    /* renamed from: e  reason: collision with root package name */
    private final String f1112e;

    /* renamed from: f  reason: collision with root package name */
    private final String f1113f;

    /* renamed from: g  reason: collision with root package name */
    private final List<String> f1114g;

    /* renamed from: h  reason: collision with root package name */
    private final List<String> f1115h;

    /* renamed from: i  reason: collision with root package name */
    private final String f1116i;

    /* renamed from: j  reason: collision with root package name */
    private final String f1117j;

    /* compiled from: HttpUrl.java */
    /* loaded from: classes.dex */
    public static final class a {
        String a;

        /* renamed from: d  reason: collision with root package name */
        String f1118d;

        /* renamed from: f  reason: collision with root package name */
        final List<String> f1120f;

        /* renamed from: g  reason: collision with root package name */
        List<String> f1121g;

        /* renamed from: h  reason: collision with root package name */
        String f1122h;
        String b = "";
        String c = "";

        /* renamed from: e  reason: collision with root package name */
        int f1119e = -1;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: HttpUrl.java */
        /* renamed from: com.bytedance.sdk.a.b.s$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public enum EnumC0039a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f1120f = arrayList;
            arrayList.add("");
        }

        private boolean f(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean g(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        public a a(String str) {
            Objects.requireNonNull(str, "scheme == null");
            if (str.equalsIgnoreCase("http")) {
                this.a = "http";
            } else if (str.equalsIgnoreCase("https")) {
                this.a = "https";
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
            return this;
        }

        public a b(String str) {
            Objects.requireNonNull(str, "username == null");
            this.b = s.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public a c(String str) {
            Objects.requireNonNull(str, "password == null");
            this.c = s.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public a d(String str) {
            Objects.requireNonNull(str, "host == null");
            String e2 = e(str, 0, str.length());
            if (e2 != null) {
                this.f1118d = e2;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        public a e(String str) {
            this.f1121g = str != null ? s.b(s.a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append("://");
            if (!this.b.isEmpty() || !this.c.isEmpty()) {
                sb.append(this.b);
                if (!this.c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.c);
                }
                sb.append('@');
            }
            if (this.f1118d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f1118d);
                sb.append(']');
            } else {
                sb.append(this.f1118d);
            }
            int a = a();
            if (a != s.a(this.a)) {
                sb.append(':');
                sb.append(a);
            }
            s.a(sb, this.f1120f);
            if (this.f1121g != null) {
                sb.append('?');
                s.b(sb, this.f1121g);
            }
            if (this.f1122h != null) {
                sb.append(Constants.ID_PREFIX);
                sb.append(this.f1122h);
            }
            return sb.toString();
        }

        private static int f(String str, int i2, int i3) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(s.a(str, i2, i3, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        private static String e(String str, int i2, int i3) {
            return com.bytedance.sdk.a.b.a.c.a(s.a(str, i2, i3, false));
        }

        a b() {
            int size = this.f1120f.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f1120f.set(i2, s.a(this.f1120f.get(i2), "[]", true, true, false, true));
            }
            List<String> list = this.f1121g;
            if (list != null) {
                int size2 = list.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    String str = this.f1121g.get(i3);
                    if (str != null) {
                        this.f1121g.set(i3, s.a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f1122h;
            if (str2 != null) {
                this.f1122h = s.a(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public s c() {
            if (this.a != null) {
                if (this.f1118d != null) {
                    return new s(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        private void d() {
            List<String> list = this.f1120f;
            if (list.remove(list.size() - 1).isEmpty() && !this.f1120f.isEmpty()) {
                List<String> list2 = this.f1120f;
                list2.set(list2.size() - 1, "");
                return;
            }
            this.f1120f.add("");
        }

        public a a(int i2) {
            if (i2 > 0 && i2 <= 65535) {
                this.f1119e = i2;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i2);
        }

        private static int c(String str, int i2, int i3) {
            int i4 = 0;
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i4++;
                i2++;
            }
            return i4;
        }

        private static int d(String str, int i2, int i3) {
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt == ':') {
                    return i2;
                }
                if (charAt == '[') {
                    do {
                        i2++;
                        if (i2 < i3) {
                        }
                    } while (str.charAt(i2) != ']');
                }
                i2++;
            }
            return i3;
        }

        int a() {
            int i2 = this.f1119e;
            return i2 != -1 ? i2 : s.a(this.a);
        }

        EnumC0039a a(s sVar, String str) {
            int a;
            int i2;
            int a2 = com.bytedance.sdk.a.b.a.c.a(str, 0, str.length());
            int b = com.bytedance.sdk.a.b.a.c.b(str, a2, str.length());
            if (b(str, a2, b) != -1) {
                if (str.regionMatches(true, a2, "https:", 0, 6)) {
                    this.a = "https";
                    a2 += 6;
                } else if (str.regionMatches(true, a2, "http:", 0, 5)) {
                    this.a = "http";
                    a2 += 5;
                } else {
                    return EnumC0039a.UNSUPPORTED_SCHEME;
                }
            } else if (sVar != null) {
                this.a = sVar.a;
            } else {
                return EnumC0039a.MISSING_SCHEME;
            }
            int c = c(str, a2, b);
            char c2 = '?';
            char c3 = Constants.ID_PREFIX;
            if (c < 2 && sVar != null && sVar.a.equals(this.a)) {
                this.b = sVar.d();
                this.c = sVar.e();
                this.f1118d = sVar.b;
                this.f1119e = sVar.c;
                this.f1120f.clear();
                this.f1120f.addAll(sVar.i());
                if (a2 == b || str.charAt(a2) == '#') {
                    e(sVar.j());
                }
            } else {
                int i3 = a2 + c;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    a = com.bytedance.sdk.a.b.a.c.a(str, i3, b, "@/\\?#");
                    char charAt = a != b ? str.charAt(a) : (char) 65535;
                    if (charAt == 65535 || charAt == c3 || charAt == '/' || charAt == '\\' || charAt == c2) {
                        break;
                    }
                    if (charAt == '@') {
                        if (!z) {
                            int a3 = com.bytedance.sdk.a.b.a.c.a(str, i3, a, ':');
                            i2 = a;
                            String a4 = s.a(str, i3, a3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                a4 = this.b + "%40" + a4;
                            }
                            this.b = a4;
                            if (a3 != i2) {
                                this.c = s.a(str, a3 + 1, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i2 = a;
                            this.c += "%40" + s.a(str, i3, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i3 = i2 + 1;
                    }
                    c2 = '?';
                    c3 = Constants.ID_PREFIX;
                }
                int d2 = d(str, i3, a);
                int i4 = d2 + 1;
                if (i4 < a) {
                    this.f1118d = e(str, i3, d2);
                    int f2 = f(str, i4, a);
                    this.f1119e = f2;
                    if (f2 == -1) {
                        return EnumC0039a.INVALID_PORT;
                    }
                } else {
                    this.f1118d = e(str, i3, d2);
                    this.f1119e = s.a(this.a);
                }
                if (this.f1118d == null) {
                    return EnumC0039a.INVALID_HOST;
                }
                a2 = a;
            }
            int a5 = com.bytedance.sdk.a.b.a.c.a(str, a2, b, "?#");
            a(str, a2, a5);
            if (a5 < b && str.charAt(a5) == '?') {
                int a6 = com.bytedance.sdk.a.b.a.c.a(str, a5, b, (char) Constants.ID_PREFIX);
                this.f1121g = s.b(s.a(str, a5 + 1, a6, " \"'<>#", true, false, true, true, null));
                a5 = a6;
            }
            if (a5 < b && str.charAt(a5) == '#') {
                this.f1122h = s.a(str, 1 + a5, b, "", true, false, false, false, null);
            }
            return EnumC0039a.SUCCESS;
        }

        private static int b(String str, int i2, int i3) {
            if (i3 - i2 < 2) {
                return -1;
            }
            char charAt = str.charAt(i2);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i2++;
                    if (i2 >= i3) {
                        break;
                    }
                    char charAt2 = str.charAt(i2);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i2;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0044 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0041 -> B:11:0x0029). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void a(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L3
                return
            L3:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L1e
                r1 = 92
                if (r0 != r1) goto L13
                goto L1e
            L13:
                java.util.List<java.lang.String> r0 = r10.f1120f
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L29
            L1e:
                java.util.List<java.lang.String> r0 = r10.f1120f
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f1120f
                r0.add(r2)
                goto L41
            L29:
                r6 = r12
                if (r6 >= r13) goto L44
                java.lang.String r12 = "/\\"
                int r12 = com.bytedance.sdk.a.b.a.c.a(r11, r6, r13, r12)
                if (r12 >= r13) goto L36
                r0 = 1
                goto L37
            L36:
                r0 = 0
            L37:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.a(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L29
            L41:
                int r12 = r12 + 1
                goto L29
            L44:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.a.b.s.a.a(java.lang.String, int, int):void");
        }

        private void a(String str, int i2, int i3, boolean z, boolean z2) {
            String a = s.a(str, i2, i3, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (f(a)) {
                return;
            }
            if (g(a)) {
                d();
                return;
            }
            List<String> list = this.f1120f;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.f1120f;
                list2.set(list2.size() - 1, a);
            } else {
                this.f1120f.add(a);
            }
            if (z) {
                this.f1120f.add("");
            }
        }
    }

    s(a aVar) {
        this.a = aVar.a;
        this.f1112e = a(aVar.b, false);
        this.f1113f = a(aVar.c, false);
        this.b = aVar.f1118d;
        this.c = aVar.a();
        this.f1114g = a(aVar.f1120f, false);
        List<String> list = aVar.f1121g;
        this.f1115h = list != null ? a(list, true) : null;
        String str = aVar.f1122h;
        this.f1116i = str != null ? a(str, false) : null;
        this.f1117j = aVar.toString();
    }

    public URI a() {
        String aVar = n().b().toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e2) {
            try {
                return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    public String b() {
        return this.a;
    }

    public boolean c() {
        return this.a.equals("https");
    }

    public String d() {
        if (this.f1112e.isEmpty()) {
            return "";
        }
        int length = this.a.length() + 3;
        String str = this.f1117j;
        return this.f1117j.substring(length, com.bytedance.sdk.a.b.a.c.a(str, length, str.length(), ":@"));
    }

    public String e() {
        if (this.f1113f.isEmpty()) {
            return "";
        }
        int indexOf = this.f1117j.indexOf(64);
        return this.f1117j.substring(this.f1117j.indexOf(58, this.a.length() + 3) + 1, indexOf);
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && ((s) obj).f1117j.equals(this.f1117j);
    }

    public String f() {
        return this.b;
    }

    public int g() {
        return this.c;
    }

    public String h() {
        int indexOf = this.f1117j.indexOf(47, this.a.length() + 3);
        String str = this.f1117j;
        return this.f1117j.substring(indexOf, com.bytedance.sdk.a.b.a.c.a(str, indexOf, str.length(), "?#"));
    }

    public int hashCode() {
        return this.f1117j.hashCode();
    }

    public List<String> i() {
        int indexOf = this.f1117j.indexOf(47, this.a.length() + 3);
        String str = this.f1117j;
        int a2 = com.bytedance.sdk.a.b.a.c.a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a2) {
            int i2 = indexOf + 1;
            int a3 = com.bytedance.sdk.a.b.a.c.a(this.f1117j, i2, a2, '/');
            arrayList.add(this.f1117j.substring(i2, a3));
            indexOf = a3;
        }
        return arrayList;
    }

    public String j() {
        if (this.f1115h == null) {
            return null;
        }
        int indexOf = this.f1117j.indexOf(63) + 1;
        String str = this.f1117j;
        return this.f1117j.substring(indexOf, com.bytedance.sdk.a.b.a.c.a(str, indexOf, str.length(), (char) Constants.ID_PREFIX));
    }

    public String k() {
        if (this.f1115h == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        b(sb, this.f1115h);
        return sb.toString();
    }

    public String l() {
        if (this.f1116i == null) {
            return null;
        }
        return this.f1117j.substring(this.f1117j.indexOf(35) + 1);
    }

    public String m() {
        return d("/...").b("").c("").c().toString();
    }

    public a n() {
        a aVar = new a();
        aVar.a = this.a;
        aVar.b = d();
        aVar.c = e();
        aVar.f1118d = this.b;
        aVar.f1119e = this.c != a(this.a) ? this.c : -1;
        aVar.f1120f.clear();
        aVar.f1120f.addAll(i());
        aVar.e(j());
        aVar.f1122h = l();
        return aVar;
    }

    public String toString() {
        return this.f1117j;
    }

    static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            String str = list.get(i2);
            String str2 = list.get(i2 + 1);
            if (i2 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public s c(String str) {
        a d2 = d(str);
        if (d2 != null) {
            return d2.c();
        }
        return null;
    }

    public static s e(String str) {
        a aVar = new a();
        if (aVar.a(null, str) == a.EnumC0039a.SUCCESS) {
            return aVar.c();
        }
        return null;
    }

    public a d(String str) {
        a aVar = new a();
        if (aVar.a(this, str) == a.EnumC0039a.SUCCESS) {
            return aVar;
        }
        return null;
    }

    public static int a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        if (str.equals("https")) {
            return WebSocket.DEFAULT_WSS_PORT;
        }
        return -1;
    }

    static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append('/');
            sb.append(list.get(i2));
        }
    }

    static List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int indexOf = str.indexOf(38, i2);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i2);
            if (indexOf2 != -1 && indexOf2 <= indexOf) {
                arrayList.add(str.substring(i2, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            } else {
                arrayList.add(str.substring(i2, indexOf));
                arrayList.add(null);
            }
            i2 = indexOf + 1;
        }
        return arrayList;
    }

    public static s a(URL url) {
        return e(url.toString());
    }

    static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    private List<String> a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            String str = list.get(i2);
            arrayList.add(str != null ? a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String a(String str, int i2, int i3, boolean z) {
        for (int i4 = i2; i4 < i3; i4++) {
            char charAt = str.charAt(i4);
            if (charAt == '%' || (charAt == '+' && z)) {
                com.bytedance.sdk.a.a.c cVar = new com.bytedance.sdk.a.a.c();
                cVar.a(str, i2, i4);
                a(cVar, str, i4, i3, z);
                return cVar.o();
            }
        }
        return str.substring(i2, i3);
    }

    static void a(com.bytedance.sdk.a.a.c cVar, String str, int i2, int i3, boolean z) {
        int i4;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt == 37 && (i4 = i2 + 2) < i3) {
                int a2 = com.bytedance.sdk.a.b.a.c.a(str.charAt(i2 + 1));
                int a3 = com.bytedance.sdk.a.b.a.c.a(str.charAt(i4));
                if (a2 != -1 && a3 != -1) {
                    cVar.i((a2 << 4) + a3);
                    i2 = i4;
                }
                cVar.a(codePointAt);
            } else {
                if (codePointAt == 43 && z) {
                    cVar.i(32);
                }
                cVar.a(codePointAt);
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    static boolean a(String str, int i2, int i3) {
        int i4 = i2 + 2;
        return i4 < i3 && str.charAt(i2) == '%' && com.bytedance.sdk.a.b.a.c.a(str.charAt(i2 + 1)) != -1 && com.bytedance.sdk.a.b.a.c.a(str.charAt(i4)) != -1;
    }

    static String a(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int i4 = i2;
        while (i4 < i3) {
            int codePointAt = str.codePointAt(i4);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z4)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || a(str, i4, i3)))) && (codePointAt != 43 || !z3))) {
                    i4 += Character.charCount(codePointAt);
                }
            }
            com.bytedance.sdk.a.a.c cVar = new com.bytedance.sdk.a.a.c();
            cVar.a(str, i2, i4);
            a(cVar, str, i4, i3, str2, z, z2, z3, z4, charset);
            return cVar.o();
        }
        return str.substring(i2, i3);
    }

    static void a(com.bytedance.sdk.a.a.c cVar, String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        com.bytedance.sdk.a.a.c cVar2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z3) {
                    cVar.b(z ? Marker.ANY_NON_NULL_MARKER : "%2B");
                } else if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z4) && str2.indexOf(codePointAt) == -1 && (codePointAt != 37 || (z && (!z2 || a(str, i2, i3)))))) {
                    cVar.a(codePointAt);
                } else {
                    if (cVar2 == null) {
                        cVar2 = new com.bytedance.sdk.a.a.c();
                    }
                    if (charset != null && !charset.equals(com.bytedance.sdk.a.b.a.c.f910e)) {
                        cVar2.a(str, i2, Character.charCount(codePointAt) + i2, charset);
                    } else {
                        cVar2.a(codePointAt);
                    }
                    while (!cVar2.e()) {
                        int h2 = cVar2.h() & Draft_75.END_OF_FRAME;
                        cVar.i(37);
                        char[] cArr = f1111d;
                        cVar.i((int) cArr[(h2 >> 4) & 15]);
                        cVar.i((int) cArr[h2 & 15]);
                    }
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
