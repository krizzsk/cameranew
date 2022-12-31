package com.pinguo.camera360.cloud.cropImage;

import android.graphics.BitmapFactory;
import java.util.Iterator;
import java.util.WeakHashMap;
/* loaded from: classes3.dex */
public class BitmapManager {
    private static BitmapManager b;
    private final WeakHashMap<Thread, c> a = new WeakHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum State {
        CANCEL,
        ALLOW
    }

    /* loaded from: classes3.dex */
    public static class b implements Iterable<Thread> {
        private final WeakHashMap<Thread, Object> a = new WeakHashMap<>();

        @Override // java.lang.Iterable
        public Iterator<Thread> iterator() {
            return this.a.keySet().iterator();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c {
        public State a;
        public BitmapFactory.Options b;

        private c() {
            this.a = State.ALLOW;
        }

        public String toString() {
            String str;
            State state = this.a;
            if (state == State.CANCEL) {
                str = "Cancel";
            } else {
                str = state == State.ALLOW ? "Allow" : "?";
            }
            return "thread state = " + str + ", options = " + this.b;
        }
    }

    private BitmapManager() {
    }

    private synchronized c c(Thread thread) {
        c cVar;
        cVar = this.a.get(thread);
        if (cVar == null) {
            cVar = new c();
            this.a.put(thread, cVar);
        }
        return cVar;
    }

    public static synchronized BitmapManager d() {
        BitmapManager bitmapManager;
        synchronized (BitmapManager.class) {
            if (b == null) {
                b = new BitmapManager();
            }
            bitmapManager = b;
        }
        return bitmapManager;
    }

    public synchronized void a(b bVar) {
        Iterator<Thread> it = bVar.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    public synchronized void b(Thread thread) {
        c c2 = c(thread);
        c2.a = State.CANCEL;
        BitmapFactory.Options options = c2.b;
        if (options != null) {
            options.requestCancelDecode();
        }
        notifyAll();
    }
}
