package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
/* loaded from: classes.dex */
public abstract class WorkerFactory {
    private static final String TAG = Logger.tagWithPrefix("WorkerFactory");

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static WorkerFactory getDefaultWorkerFactory() {
        return new WorkerFactory() { // from class: androidx.work.WorkerFactory.1
            @Override // androidx.work.WorkerFactory
            @Nullable
            public ListenableWorker createWorker(@NonNull Context context, @NonNull String str, @NonNull WorkerParameters workerParameters) {
                return null;
            }
        };
    }

    @Nullable
    public abstract ListenableWorker createWorker(@NonNull Context context, @NonNull String str, @NonNull WorkerParameters workerParameters);

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final ListenableWorker createWorkerWithDefaultFallback(@NonNull Context context, @NonNull String str, @NonNull WorkerParameters workerParameters) {
        ListenableWorker createWorker = createWorker(context, str, workerParameters);
        if (createWorker != null) {
            return createWorker;
        }
        try {
            try {
                return (ListenableWorker) Class.forName(str).asSubclass(ListenableWorker.class).getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context, workerParameters);
            } catch (Exception e2) {
                Logger logger = Logger.get();
                String str2 = TAG;
                logger.error(str2, "Could not instantiate " + str, e2);
                return null;
            }
        } catch (ClassNotFoundException unused) {
            Logger logger2 = Logger.get();
            String str3 = TAG;
            logger2.error(str3, "Class not found: " + str, new Throwable[0]);
            return null;
        }
    }
}
