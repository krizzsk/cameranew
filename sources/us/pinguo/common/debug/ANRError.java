package us.pinguo.common.debug;

import android.os.Looper;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import us.pinguo.common.debug.ANRError$$;
/* loaded from: classes4.dex */
public class ANRError extends Error {
    private static final long serialVersionUID = 1;

    /* loaded from: classes4.dex */
    static class a implements Comparator<Thread> {
        final /* synthetic */ Thread a;

        a(Thread thread) {
            this.a = thread;
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Thread thread, Thread thread2) {
            if (thread == thread2) {
                return 0;
            }
            Thread thread3 = this.a;
            if (thread == thread3) {
                return 1;
            }
            if (thread2 == thread3) {
                return -1;
            }
            return thread2.getName().compareTo(thread.getName());
        }
    }

    private ANRError(ANRError$$._Thread _thread) {
        super("Application Not Responding", _thread);
    }

    static ANRError New(String str, boolean z) {
        Thread thread = Looper.getMainLooper().getThread();
        TreeMap treeMap = new TreeMap(new a(thread));
        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
            if (entry.getKey() == thread || (entry.getKey().getName().startsWith(str) && (z || entry.getValue().length > 0))) {
                treeMap.put(entry.getKey(), entry.getValue());
            }
        }
        ANRError$$._Thread _thread = null;
        for (Map.Entry entry2 : treeMap.entrySet()) {
            _thread = new ANRError$$._Thread(new ANRError$$(((Thread) entry2.getKey()).getName(), (StackTraceElement[]) entry2.getValue(), null), _thread, null);
        }
        return new ANRError(_thread);
    }

    static ANRError NewMainOnly() {
        Thread thread = Looper.getMainLooper().getThread();
        return new ANRError(new ANRError$$._Thread(new ANRError$$(thread.getName(), thread.getStackTrace(), null), null, null));
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
