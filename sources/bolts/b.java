package bolts;

import com.tapjoy.TapjoyConstants;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* compiled from: BoltsExecutors.java */
/* loaded from: classes.dex */
final class b {
    private static final b c = new b();
    private final ExecutorService a;
    private final Executor b;

    /* compiled from: BoltsExecutors.java */
    /* renamed from: bolts.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class ExecutorC0011b implements Executor {
        private ThreadLocal<Integer> a;

        private ExecutorC0011b() {
            this.a = new ThreadLocal<>();
        }

        private int a() {
            Integer num = this.a.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.a.remove();
            } else {
                this.a.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        private int b() {
            Integer num = this.a.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.a.set(Integer.valueOf(intValue));
            return intValue;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                if (b() <= 15) {
                    runnable.run();
                } else {
                    b.a().execute(runnable);
                }
            } finally {
                a();
            }
        }
    }

    private b() {
        this.a = !c() ? Executors.newCachedThreadPool() : bolts.a.b();
        Executors.newSingleThreadScheduledExecutor();
        this.b = new ExecutorC0011b();
    }

    public static ExecutorService a() {
        return c.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor b() {
        return c.b;
    }

    private static boolean c() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains(TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE);
    }
}
