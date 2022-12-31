package com.google.android.datatransport.cct;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.f;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
/* compiled from: CCTDestination.java */
/* loaded from: classes.dex */
public final class a implements f {
    static final String c = e.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");

    /* renamed from: d  reason: collision with root package name */
    static final String f3314d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f3315e;

    /* renamed from: f  reason: collision with root package name */
    private static final Set<com.google.android.datatransport.b> f3316f;

    /* renamed from: g  reason: collision with root package name */
    public static final a f3317g;
    @NonNull
    private final String a;
    @Nullable
    private final String b;

    static {
        String a = e.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        f3314d = a;
        String a2 = e.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f3315e = a2;
        f3316f = Collections.unmodifiableSet(new HashSet(Arrays.asList(com.google.android.datatransport.b.b("proto"), com.google.android.datatransport.b.b("json"))));
        f3317g = new a(a, a2);
    }

    public a(@NonNull String str, @Nullable String str2) {
        this.a = str;
        this.b = str2;
    }

    @NonNull
    public static a c(@NonNull byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (str.startsWith("1$")) {
            String[] split = str.substring(2).split(Pattern.quote("\\"), 2);
            if (split.length == 2) {
                String str2 = split[0];
                if (!str2.isEmpty()) {
                    String str3 = split[1];
                    if (str3.isEmpty()) {
                        str3 = null;
                    }
                    return new a(str2, str3);
                }
                throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
            }
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        throw new IllegalArgumentException("Version marker missing from extras");
    }

    @Override // com.google.android.datatransport.runtime.f
    public Set<com.google.android.datatransport.b> a() {
        return f3316f;
    }

    @Nullable
    public byte[] b() {
        String str = this.b;
        if (str == null && this.a == null) {
            return null;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "1$";
        objArr[1] = this.a;
        objArr[2] = "\\";
        if (str == null) {
            str = "";
        }
        objArr[3] = str;
        return String.format("%s%s%s%s", objArr).getBytes(Charset.forName("UTF-8"));
    }

    @Nullable
    public String d() {
        return this.b;
    }

    @NonNull
    public String e() {
        return this.a;
    }

    @Override // com.google.android.datatransport.runtime.e
    @Nullable
    public byte[] getExtras() {
        return b();
    }

    @Override // com.google.android.datatransport.runtime.e
    @NonNull
    public String getName() {
        return "cct";
    }
}
