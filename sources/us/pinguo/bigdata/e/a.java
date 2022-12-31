package us.pinguo.bigdata.e;

import java.util.concurrent.ArrayBlockingQueue;
/* compiled from: LogQueueManager.java */
/* loaded from: classes3.dex */
public class a {
    private static volatile a c;
    private boolean b = true;
    private final ArrayBlockingQueue<String> a = new ArrayBlockingQueue<>(100);

    private a() {
    }

    public static a a() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    public void b(String str) {
        this.a.offer(str);
        if (this.b) {
            this.a.offer("FLUSH");
        }
    }

    public void c(boolean z) {
        this.b = z;
    }

    public String d() throws InterruptedException {
        return this.a.take();
    }
}
