package us.pinguo.camerasdk.core.util;
/* compiled from: PGPreconditions.java */
/* loaded from: classes4.dex */
public class a {
    public static <T> T a(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }
}
