package com.tencent.open.log;

import com.tencent.connect.common.Constants;
import java.io.File;
/* compiled from: ProGuard */
/* loaded from: classes3.dex */
public class c {
    public static int a = 60;
    public static int b = 60;
    public static String c = "OpenSDK.Client.File.Tracer";

    /* renamed from: d  reason: collision with root package name */
    public static String f8192d;

    /* renamed from: e  reason: collision with root package name */
    public static String f8193e;

    /* renamed from: f  reason: collision with root package name */
    public static long f8194f;

    /* renamed from: g  reason: collision with root package name */
    public static int f8195g;

    /* renamed from: h  reason: collision with root package name */
    public static int f8196h;

    /* renamed from: i  reason: collision with root package name */
    public static int f8197i;

    /* renamed from: j  reason: collision with root package name */
    public static String f8198j;

    /* renamed from: k  reason: collision with root package name */
    public static String f8199k;

    /* renamed from: l  reason: collision with root package name */
    public static String f8200l;
    public static int m;
    public static long n;
    public static String o;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("Tencent");
        String str = File.separator;
        sb.append(str);
        sb.append("msflogs");
        sb.append(str);
        sb.append("com");
        sb.append(str);
        sb.append("tencent");
        sb.append(str);
        sb.append("mobileqq");
        sb.append(str);
        f8192d = sb.toString();
        f8193e = ".log";
        f8194f = 8388608L;
        f8195g = 262144;
        f8196h = 1024;
        f8197i = 10000;
        f8198j = "debug.file.blockcount";
        f8199k = "debug.file.keepperiod";
        f8200l = "debug.file.tracelevel";
        m = 24;
        n = 604800000L;
        o = Constants.APP_SPECIFIC_ROOT + str + "logs";
    }
}
