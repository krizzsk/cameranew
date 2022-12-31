package com.tapjoy.internal;

import java.io.File;
/* loaded from: classes3.dex */
public final class gx implements Runnable {
    final hl a;
    cd b;
    private final Object c;

    /* renamed from: d  reason: collision with root package name */
    private final Thread f7589d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7590e;

    public gx(File file) {
        hl hlVar = new hl(file);
        this.a = hlVar;
        this.c = hlVar;
        hlVar.b();
        Thread thread = new Thread(this, "5Rocks");
        this.f7589d = thread;
        thread.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(boolean z) {
        synchronized (this.c) {
            this.f7590e = z;
            this.c.notify();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x008e A[Catch: InterruptedException | Exception -> 0x0106, TryCatch #3 {InterruptedException | Exception -> 0x0106, blocks: (B:3:0x0003, B:5:0x0008, B:9:0x0014, B:11:0x001e, B:12:0x0028, B:14:0x0030, B:16:0x0036, B:18:0x003a, B:19:0x0041, B:21:0x0047, B:22:0x004e, B:24:0x0054, B:26:0x005a, B:28:0x0062, B:31:0x0071, B:35:0x008e, B:37:0x0099, B:39:0x00a1, B:41:0x00a9, B:46:0x00c9, B:47:0x00d1, B:49:0x00da, B:50:0x00dc, B:57:0x00ea, B:58:0x00ec, B:59:0x00ed, B:61:0x00f3, B:64:0x0100, B:63:0x00fb, B:51:0x00dd, B:52:0x00e4, B:44:0x00b2), top: B:72:0x0003, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00c6 A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.gx.run():void");
    }

    public final void a() {
        if (this.b == null || this.a.c()) {
            return;
        }
        a(true);
    }
}
