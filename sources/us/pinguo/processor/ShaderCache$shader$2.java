package us.pinguo.processor;

import java.io.BufferedInputStream;
import java.io.InputStream;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import us.pinguo.util.v;
/* compiled from: ShaderCache.kt */
/* loaded from: classes6.dex */
final class ShaderCache$shader$2 extends Lambda implements kotlin.jvm.b.a<byte[]> {
    public static final ShaderCache$shader$2 INSTANCE = new ShaderCache$shader$2();

    ShaderCache$shader$2() {
        super(0);
    }

    @Override // kotlin.jvm.b.a
    public final byte[] invoke() {
        InputStream it = v.a().getAssets().open("load_background.jpg");
        try {
            s.g(it, "it");
            byte[] c = kotlin.io.a.c(it instanceof BufferedInputStream ? (BufferedInputStream) it : new BufferedInputStream(it, 8192));
            kotlin.io.b.a(it, null);
            return c;
        } finally {
        }
    }
}
