package us.pinguo.util;

import androidx.annotation.Nullable;
import java.util.LinkedList;
import java.util.List;
/* compiled from: AppContextInfoUtils.java */
/* loaded from: classes6.dex */
public class d {
    private static String a;
    private static final LinkedList<String> b = new LinkedList<>();
    private static int c = -1;

    /* renamed from: d  reason: collision with root package name */
    public static String f12479d = "?";

    /* renamed from: e  reason: collision with root package name */
    public static String f12480e = "?";

    public static int a() {
        return c;
    }

    @Nullable
    public static String b() {
        return a;
    }

    public static List<String> c() {
        return b;
    }

    public static synchronized void d(String str) {
        synchronized (d.class) {
            us.pinguo.common.log.a.c(str, new Object[0]);
            LinkedList<String> linkedList = b;
            if (linkedList.size() < 20) {
                linkedList.addFirst(str);
            }
        }
    }

    public static void e(int i2) {
        c = i2;
    }

    public static void f(@Nullable String str) {
        a = str;
    }
}
