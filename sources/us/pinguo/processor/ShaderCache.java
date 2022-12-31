package us.pinguo.processor;
/* compiled from: ShaderCache.kt */
/* loaded from: classes6.dex */
public final class ShaderCache {
    public static final ShaderCache a = new ShaderCache();
    private static final kotlin.f b;

    static {
        kotlin.f b2;
        b2 = kotlin.h.b(ShaderCache$shader$2.INSTANCE);
        b = b2;
    }

    private ShaderCache() {
    }

    public final byte[] a() {
        return (byte[]) b.getValue();
    }
}
