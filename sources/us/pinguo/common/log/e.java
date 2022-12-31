package us.pinguo.common.log;

import android.text.TextUtils;
import java.util.concurrent.LinkedBlockingQueue;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LogWriter.java */
/* loaded from: classes4.dex */
public final class e {
    private static LinkedBlockingQueue<b> a = new LinkedBlockingQueue<>((int) IjkMediaCodecInfo.RANK_SECURE);
    private static boolean b = false;
    private static String c;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void a() {
        a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void b(b bVar) {
        if (b) {
            if (!TextUtils.isEmpty(c)) {
                if (c.equals(bVar.c())) {
                    a.offer(bVar);
                    return;
                }
                return;
            }
            a.offer(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void c(String str) {
        c = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void d(String str, String str2) {
        if (b) {
            return;
        }
        b = true;
        d.b(true);
        new d(str, str2).start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void e() {
        d.b(false);
        b bVar = new b(e.class.getName(), "-E N D-", "日志结束");
        try {
            a.put(bVar);
        } catch (InterruptedException unused) {
            a.offer(bVar);
        }
        b = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final b f() throws InterruptedException {
        return a.take();
    }
}
