package pl.droidsonroids.gif;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* compiled from: GifRenderingExecutor.java */
/* loaded from: classes3.dex */
final class d extends ScheduledThreadPoolExecutor {

    /* compiled from: GifRenderingExecutor.java */
    /* loaded from: classes3.dex */
    private static final class b {
        private static final d a = new d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d a() {
        return b.a;
    }

    private d() {
        super(1, new ThreadPoolExecutor.DiscardPolicy());
    }
}
