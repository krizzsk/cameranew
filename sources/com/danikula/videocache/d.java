package com.danikula.videocache;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* compiled from: GetRequest.java */
/* loaded from: classes.dex */
class d {

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f2216d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f2217e = Pattern.compile("GET /(.*) HTTP");
    public final String a;
    public final long b;
    public final boolean c;

    public d(String str) {
        j.d(str);
        long a = a(str);
        this.b = Math.max(0L, a);
        this.c = a >= 0;
        this.a = b(str);
    }

    private long a(String str) {
        Matcher matcher = f2216d.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    private String b(String str) {
        Matcher matcher = f2217e.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public static d c(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (!TextUtils.isEmpty(readLine)) {
                sb.append(readLine);
                sb.append('\n');
            } else {
                return new d(sb.toString());
            }
        }
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.b + ", partial=" + this.c + ", uri='" + this.a + "'}";
    }
}
