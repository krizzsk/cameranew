package com.google.firebase.remoteconfig.internal;

import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.b;
import com.google.android.gms.tasks.d;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.j;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
@AnyThread
/* loaded from: classes2.dex */
public class ConfigCacheClient {
    private static final Executor DIRECT_EXECUTOR;
    static final long DISK_READ_TIMEOUT_IN_SECONDS = 5;
    @GuardedBy("ConfigCacheClient.class")
    private static final Map<String, ConfigCacheClient> clientInstances = new HashMap();
    @Nullable
    @GuardedBy("this")
    private g<ConfigContainer> cachedContainerTask = null;
    private final ExecutorService executorService;
    private final ConfigStorageClient storageClient;

    /* loaded from: classes2.dex */
    public static class AwaitListener<TResult> implements e<TResult>, d, b {
        private final CountDownLatch latch;

        private AwaitListener() {
            this.latch = new CountDownLatch(1);
        }

        public void await() throws InterruptedException {
            this.latch.await();
        }

        @Override // com.google.android.gms.tasks.b
        public void onCanceled() {
            this.latch.countDown();
        }

        @Override // com.google.android.gms.tasks.d
        public void onFailure(@NonNull Exception exc) {
            this.latch.countDown();
        }

        @Override // com.google.android.gms.tasks.e
        public void onSuccess(TResult tresult) {
            this.latch.countDown();
        }

        public boolean await(long j2, TimeUnit timeUnit) throws InterruptedException {
            return this.latch.await(j2, timeUnit);
        }
    }

    static {
        Executor executor;
        executor = ConfigCacheClient$$Lambda$4.instance;
        DIRECT_EXECUTOR = executor;
    }

    private ConfigCacheClient(ExecutorService executorService, ConfigStorageClient configStorageClient) {
        this.executorService = executorService;
        this.storageClient = configStorageClient;
    }

    private static <TResult> TResult await(g<TResult> gVar, long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        AwaitListener awaitListener = new AwaitListener();
        Executor executor = DIRECT_EXECUTOR;
        gVar.d(executor, awaitListener);
        gVar.c(executor, awaitListener);
        gVar.a(executor, awaitListener);
        if (awaitListener.await(j2, timeUnit)) {
            if (gVar.n()) {
                return gVar.j();
            }
            throw new ExecutionException(gVar.i());
        }
        throw new TimeoutException("Task await timed out.");
    }

    @VisibleForTesting
    public static synchronized void clearInstancesForTest() {
        synchronized (ConfigCacheClient.class) {
            clientInstances.clear();
        }
    }

    public static synchronized ConfigCacheClient getInstance(ExecutorService executorService, ConfigStorageClient configStorageClient) {
        ConfigCacheClient configCacheClient;
        synchronized (ConfigCacheClient.class) {
            String fileName = configStorageClient.getFileName();
            Map<String, ConfigCacheClient> map = clientInstances;
            if (!map.containsKey(fileName)) {
                map.put(fileName, new ConfigCacheClient(executorService, configStorageClient));
            }
            configCacheClient = map.get(fileName);
        }
        return configCacheClient;
    }

    public static /* synthetic */ g lambda$put$1(ConfigCacheClient configCacheClient, boolean z, ConfigContainer configContainer, Void r3) throws Exception {
        if (z) {
            configCacheClient.updateInMemoryConfigContainer(configContainer);
        }
        return j.e(configContainer);
    }

    private synchronized void updateInMemoryConfigContainer(ConfigContainer configContainer) {
        this.cachedContainerTask = j.e(configContainer);
    }

    public void clear() {
        synchronized (this) {
            this.cachedContainerTask = j.e(null);
        }
        this.storageClient.clear();
    }

    public synchronized g<ConfigContainer> get() {
        g<ConfigContainer> gVar = this.cachedContainerTask;
        if (gVar == null || (gVar.m() && !this.cachedContainerTask.n())) {
            ExecutorService executorService = this.executorService;
            ConfigStorageClient configStorageClient = this.storageClient;
            configStorageClient.getClass();
            this.cachedContainerTask = j.c(executorService, ConfigCacheClient$$Lambda$3.lambdaFactory$(configStorageClient));
        }
        return this.cachedContainerTask;
    }

    @Nullable
    public ConfigContainer getBlocking() {
        return getBlocking(5L);
    }

    @Nullable
    @VisibleForTesting
    synchronized g<ConfigContainer> getCachedContainerTask() {
        return this.cachedContainerTask;
    }

    public g<ConfigContainer> put(ConfigContainer configContainer) {
        return put(configContainer, true);
    }

    @Nullable
    @VisibleForTesting
    ConfigContainer getBlocking(long j2) {
        synchronized (this) {
            g<ConfigContainer> gVar = this.cachedContainerTask;
            if (gVar != null && gVar.n()) {
                return this.cachedContainerTask.j();
            }
            try {
                return (ConfigContainer) await(get(), j2, TimeUnit.SECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException e2) {
                Log.d(FirebaseRemoteConfig.TAG, "Reading from storage file failed.", e2);
                return null;
            }
        }
    }

    public g<ConfigContainer> put(ConfigContainer configContainer, boolean z) {
        return j.c(this.executorService, ConfigCacheClient$$Lambda$1.lambdaFactory$(this, configContainer)).p(this.executorService, ConfigCacheClient$$Lambda$2.lambdaFactory$(this, z, configContainer));
    }
}
