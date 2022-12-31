package us.pinguo.common.pgdownloader.core;

import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.common.pgdownloader.download.BlockListener;
import us.pinguo.common.pgdownloader.download.DownloadBlock;
/* compiled from: DownloadRunnable.kt */
/* loaded from: classes4.dex */
public final class DownloadRunnable implements Runnable {
    private static final int BUFFER_SIZE = 8192;
    public static final Companion Companion = new Companion(null);
    private final DownloadBlock block;
    private final CountDownLatch cdl;
    private BlockListener listener;

    /* compiled from: DownloadRunnable.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }
    }

    public DownloadRunnable(DownloadBlock block, BlockListener blockListener, CountDownLatch countDownLatch) {
        s.h(block, "block");
        this.block = block;
        this.listener = blockListener;
        this.cdl = countDownLatch;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0199 A[Catch: all -> 0x021e, TryCatch #11 {all -> 0x021e, blocks: (B:56:0x0180, B:59:0x0199, B:63:0x01a3, B:67:0x01b0, B:70:0x01ba, B:66:0x01ac, B:76:0x01d1, B:79:0x01ea, B:83:0x01f4, B:87:0x0201, B:90:0x020b, B:86:0x01fd), top: B:102:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01ea A[Catch: all -> 0x021e, TryCatch #11 {all -> 0x021e, blocks: (B:56:0x0180, B:59:0x0199, B:63:0x01a3, B:67:0x01b0, B:70:0x01ba, B:66:0x01ac, B:76:0x01d1, B:79:0x01ea, B:83:0x01f4, B:87:0x0201, B:90:0x020b, B:86:0x01fd), top: B:102:0x004f }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.common.pgdownloader.core.DownloadRunnable.run():void");
    }

    public /* synthetic */ DownloadRunnable(DownloadBlock downloadBlock, BlockListener blockListener, CountDownLatch countDownLatch, int i2, o oVar) {
        this(downloadBlock, blockListener, (i2 & 4) != 0 ? null : countDownLatch);
    }
}
