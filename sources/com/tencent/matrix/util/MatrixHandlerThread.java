package com.tencent.matrix.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Printer;
import com.tencent.matrix.AppActiveMatrixDelegate;
import com.tencent.matrix.listeners.IAppForeground;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class MatrixHandlerThread {
    public static final String MATRIX_THREAD_NAME = "default_matrix_thread";
    private static final String TAG = "Matrix.HandlerThread";
    private static volatile Handler defaultHandler;
    private static volatile HandlerThread defaultHandlerThread;
    private static volatile Handler defaultMainHandler = new Handler(Looper.getMainLooper());
    private static HashSet<HandlerThread> handlerThreads = new HashSet<>();
    public static boolean isDebug = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a implements Printer, IAppForeground {
        private ConcurrentHashMap<String, b> a = new ConcurrentHashMap<>();
        private boolean b;

        /* renamed from: com.tencent.matrix.util.MatrixHandlerThread$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0275a implements Comparator<b> {
            C0275a(a aVar) {
            }

            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(b bVar, b bVar2) {
                return bVar2.b - bVar.b;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class b {
            String a;
            int b;

            b(a aVar) {
            }

            public String toString() {
                return this.a + ":" + this.b;
            }
        }

        a() {
            AppActiveMatrixDelegate appActiveMatrixDelegate = AppActiveMatrixDelegate.INSTANCE;
            appActiveMatrixDelegate.addListener(this);
            this.b = appActiveMatrixDelegate.isAppForeground();
        }

        @Override // com.tencent.matrix.listeners.IAppForeground
        public void onForeground(boolean z) {
            this.b = z;
            if (z) {
                long currentTimeMillis = System.currentTimeMillis();
                LinkedList linkedList = new LinkedList();
                for (b bVar : this.a.values()) {
                    if (bVar.b > 1) {
                        linkedList.add(bVar);
                    }
                }
                Collections.sort(linkedList, new C0275a(this));
                this.a.clear();
                if (linkedList.isEmpty()) {
                    return;
                }
                MatrixLog.i(MatrixHandlerThread.TAG, "matrix default thread has exec in background! %s cost:%s", linkedList, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return;
            }
            this.a.clear();
        }

        @Override // android.util.Printer
        public void println(String str) {
            if (!this.b && str.charAt(0) == '>') {
                int indexOf = str.indexOf("} ");
                int indexOf2 = str.indexOf("@", indexOf);
                if (indexOf < 0 || indexOf2 < 0) {
                    return;
                }
                String substring = str.substring(indexOf, indexOf2);
                b bVar = this.a.get(substring);
                if (bVar == null) {
                    bVar = new b(this);
                    bVar.a = substring;
                    this.a.put(substring, bVar);
                }
                bVar.b++;
            }
        }
    }

    public static Handler getDefaultHandler() {
        if (defaultHandler == null) {
            getDefaultHandlerThread();
        }
        return defaultHandler;
    }

    public static HandlerThread getDefaultHandlerThread() {
        HandlerThread handlerThread;
        synchronized (MatrixHandlerThread.class) {
            if (defaultHandlerThread == null) {
                defaultHandlerThread = new HandlerThread(MATRIX_THREAD_NAME);
                defaultHandlerThread.start();
                defaultHandler = new Handler(defaultHandlerThread.getLooper());
                defaultHandlerThread.getLooper().setMessageLogging(isDebug ? new a() : null);
                MatrixLog.w(TAG, "create default handler thread, we should use these thread normal, isDebug:%s", Boolean.valueOf(isDebug));
            }
            handlerThread = defaultHandlerThread;
        }
        return handlerThread;
    }

    public static Handler getDefaultMainHandler() {
        return defaultMainHandler;
    }

    public static HandlerThread getNewHandlerThread(String str, int i2) {
        Iterator<HandlerThread> it = handlerThreads.iterator();
        while (it.hasNext()) {
            if (!it.next().isAlive()) {
                it.remove();
                MatrixLog.w(TAG, "warning: remove dead handler thread with name %s", str);
            }
        }
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.setPriority(i2);
        handlerThread.start();
        handlerThreads.add(handlerThread);
        MatrixLog.w(TAG, "warning: create new handler thread with name %s, alive thread size:%d", str, Integer.valueOf(handlerThreads.size()));
        return handlerThread;
    }
}
