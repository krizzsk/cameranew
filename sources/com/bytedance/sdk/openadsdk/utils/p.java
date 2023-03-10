package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* compiled from: MimeDetector.java */
/* loaded from: classes.dex */
public class p {
    private static volatile p c;
    private Map<String, String> a;
    private volatile boolean b = false;

    /* renamed from: d  reason: collision with root package name */
    private Context f2108d;

    private p(Context context) {
        if (context != null && this.f2108d == null) {
            this.f2108d = context.getApplicationContext();
            a();
        }
        this.f2108d = context;
    }

    private static String b(String str) {
        String substring;
        int indexOf = str.indexOf(47);
        int indexOf2 = str.indexOf(59);
        if (indexOf < 0) {
            return null;
        }
        String trim = str.substring(0, indexOf).trim();
        Locale locale = Locale.ENGLISH;
        String lowerCase = trim.toLowerCase(locale);
        if (c(lowerCase)) {
            int i2 = indexOf + 1;
            if (indexOf2 < 0) {
                substring = str.substring(i2);
            } else {
                substring = str.substring(i2, indexOf2);
            }
            String lowerCase2 = substring.trim().toLowerCase(locale);
            if (c(lowerCase2)) {
                StringBuilder sb = new StringBuilder(lowerCase.length() + lowerCase2.length() + 1);
                sb.append(lowerCase);
                sb.append('/');
                sb.append(lowerCase2);
                return sb.toString();
            }
            return null;
        }
        return null;
    }

    private static boolean c(String str) {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (!a(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    private String d(String str) {
        String str2;
        String e2 = e(str);
        if (e2.isEmpty()) {
            return null;
        }
        a();
        Map<String, String> map = this.a;
        if (map == null || map.isEmpty()) {
            return null;
        }
        do {
            str2 = this.a.get(e2);
            if (str2 == null) {
                e2 = e(e2);
            }
            if (str2 != null) {
                break;
            }
        } while (!e2.isEmpty());
        return str2;
    }

    private static String e(String str) {
        int indexOf;
        return (str == null || str.isEmpty() || (indexOf = str.indexOf(46)) < 0 || indexOf >= str.length() + (-1)) ? "" : str.substring(indexOf + 1);
    }

    private void f(String str) {
        String trim = str.trim();
        if (trim.isEmpty()) {
            return;
        }
        if (trim.charAt(0) == '#') {
            return;
        }
        String replaceAll = trim.replaceAll("\\s*#.*", "");
        if (replaceAll.indexOf(61) > 0) {
            Matcher matcher = Pattern.compile("\\btype=(\"\\p{Graph}+?/\\p{Graph}+?\"|\\p{Graph}+/\\p{Graph}+\\b)").matcher(replaceAll);
            if (matcher.find()) {
                String substring = matcher.group().substring(5);
                if (substring.charAt(0) == '\"') {
                    substring = substring.substring(1, substring.length() - 1);
                }
                Matcher matcher2 = Pattern.compile("\\bexts=(\"[\\p{Graph}|\\p{Blank}]+?\"|\\p{Graph}+\\b)").matcher(replaceAll);
                if (matcher2.find()) {
                    String substring2 = matcher2.group().substring(5);
                    if (substring2.charAt(0) == '\"') {
                        substring2 = substring2.substring(1, substring2.length() - 1);
                    }
                    for (String str2 : substring2.split("[\\p{Blank}|\\p{Punct}]+")) {
                        a(str2, substring);
                    }
                    return;
                }
                return;
            }
            return;
        }
        String[] split = replaceAll.split("\\s+");
        for (int i2 = 1; i2 < split.length; i2++) {
            a(split[i2], split[0]);
        }
    }

    public static String a(Context context, String str) {
        if (str != null) {
            try {
                if (str.startsWith("http") && str.contains("?")) {
                    str = str.split("\\?")[0];
                    if (str.endsWith("/")) {
                        str = str.substring(0, str.length() - 1);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return a(context).a(str);
    }

    static p a(Context context) {
        if (c == null) {
            synchronized (p.class) {
                if (c == null) {
                    c = new p(context);
                }
            }
        }
        return c;
    }

    public final String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String d2 = d(str);
        if (TextUtils.isEmpty(d2)) {
            return null;
        }
        return b(d2);
    }

    private static boolean a(char c2) {
        return c2 > ' ' && c2 < 127 && "()<>@,;:/[]?=\\\"".indexOf(c2) < 0;
    }

    private void a() {
        if (this.f2108d == null || this.b) {
            return;
        }
        synchronized (this) {
            if (!this.b) {
                List list = (List) AccessController.doPrivileged(new PrivilegedAction<List<String>>() { // from class: com.bytedance.sdk.openadsdk.utils.p.1
                    @Override // java.security.PrivilegedAction
                    /* renamed from: a */
                    public List<String> run() {
                        BufferedReader bufferedReader;
                        InputStream inputStream = null;
                        try {
                            ArrayList arrayList = new ArrayList();
                            InputStream open = p.this.f2108d.getAssets().open("tt_mime_type.pro");
                            try {
                                bufferedReader = new BufferedReader(new InputStreamReader(open));
                                while (true) {
                                    try {
                                        String readLine = bufferedReader.readLine();
                                        if (readLine == null) {
                                            break;
                                        } else if (!TextUtils.isEmpty(readLine)) {
                                            arrayList.add(readLine);
                                        }
                                    } catch (Throwable unused) {
                                        inputStream = open;
                                        try {
                                            List<String> emptyList = Collections.emptyList();
                                            if (bufferedReader != null) {
                                                try {
                                                    bufferedReader.close();
                                                } catch (Throwable unused2) {
                                                }
                                            }
                                            return emptyList;
                                        } finally {
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Throwable unused3) {
                                                }
                                            }
                                            if (bufferedReader != null) {
                                                try {
                                                    bufferedReader.close();
                                                } catch (Throwable unused4) {
                                                }
                                            }
                                        }
                                    }
                                }
                                if (open != null) {
                                    try {
                                        open.close();
                                    } catch (Throwable unused5) {
                                    }
                                }
                                try {
                                    bufferedReader.close();
                                } catch (Throwable unused6) {
                                }
                                return arrayList;
                            } catch (Throwable unused7) {
                                bufferedReader = null;
                            }
                        } catch (Throwable unused8) {
                            bufferedReader = null;
                        }
                    }
                });
                this.a = new HashMap(list.size());
                String str = "";
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    String str2 = str + ((String) it.next());
                    if (str2.endsWith("\\")) {
                        str = str2.substring(0, str2.length() - 1);
                    } else {
                        f(str2);
                        str = "";
                    }
                }
                if (!str.isEmpty()) {
                    f(str);
                }
                this.b = true;
            }
        }
    }

    private void a(String str, String str2) {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty() || this.a.containsKey(str)) {
            return;
        }
        this.a.put(str, str2);
    }
}
