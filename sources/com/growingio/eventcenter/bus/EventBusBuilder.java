package com.growingio.eventcenter.bus;

import android.os.Looper;
import com.growingio.eventcenter.bus.Logger;
import com.growingio.eventcenter.bus.MainThreadSupport;
import com.growingio.eventcenter.bus.meta.SubscriberInfoIndex;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class EventBusBuilder {
    private static final ExecutorService DEFAULT_EXECUTOR_SERVICE = Executors.newCachedThreadPool();
    boolean ignoreGeneratedIndex;
    Logger logger;
    MainThreadSupport mainThreadSupport;
    List<Class<?>> skipMethodVerificationForClasses;
    boolean strictMethodVerification;
    List<SubscriberInfoIndex> subscriberInfoIndexes;
    boolean throwSubscriberException;
    boolean logSubscriberExceptions = true;
    boolean logNoSubscriberMessages = false;
    boolean sendSubscriberExceptionEvent = true;
    boolean sendNoSubscriberEvent = true;
    boolean eventInheritance = true;
    ExecutorService executorService = DEFAULT_EXECUTOR_SERVICE;

    public EventBusBuilder addIndex(SubscriberInfoIndex subscriberInfoIndex) {
        if (this.subscriberInfoIndexes == null) {
            this.subscriberInfoIndexes = new ArrayList();
        }
        this.subscriberInfoIndexes.add(subscriberInfoIndex);
        return this;
    }

    public EventBus build() {
        return new EventBus(this);
    }

    public EventBusBuilder eventInheritance(boolean z) {
        this.eventInheritance = z;
        return this;
    }

    public EventBusBuilder executorService(ExecutorService executorService) {
        this.executorService = executorService;
        return this;
    }

    Object getAndroidMainLooperOrNull() {
        try {
            return Looper.getMainLooper();
        } catch (RuntimeException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Logger getLogger() {
        Logger logger = this.logger;
        return logger != null ? logger : (!AndroidLogger.isAndroidLogAvailable() || getAndroidMainLooperOrNull() == null) ? new Logger.SystemOutLogger() : new AndroidLogger("EventBus");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MainThreadSupport getMainThreadSupport() {
        Object androidMainLooperOrNull;
        MainThreadSupport mainThreadSupport = this.mainThreadSupport;
        if (mainThreadSupport != null) {
            return mainThreadSupport;
        }
        if (!AndroidLogger.isAndroidLogAvailable() || (androidMainLooperOrNull = getAndroidMainLooperOrNull()) == null) {
            return null;
        }
        return new MainThreadSupport.AndroidHandlerMainThreadSupport((Looper) androidMainLooperOrNull);
    }

    public EventBusBuilder ignoreGeneratedIndex(boolean z) {
        this.ignoreGeneratedIndex = z;
        return this;
    }

    public EventBus installDefaultEventBus() {
        EventBus eventBus;
        synchronized (EventBus.class) {
            if (EventBus.defaultInstance == null) {
                EventBus.defaultInstance = build();
                eventBus = EventBus.defaultInstance;
            } else {
                throw new EventCenterException("Default instance already exists. It may be only set once before it's used the first time to ensure consistent behavior.");
            }
        }
        return eventBus;
    }

    public EventBusBuilder logNoSubscriberMessages(boolean z) {
        this.logNoSubscriberMessages = z;
        return this;
    }

    public EventBusBuilder logSubscriberExceptions(boolean z) {
        this.logSubscriberExceptions = z;
        return this;
    }

    public EventBusBuilder logger(Logger logger) {
        this.logger = logger;
        return this;
    }

    public EventBusBuilder sendNoSubscriberEvent(boolean z) {
        this.sendNoSubscriberEvent = z;
        return this;
    }

    public EventBusBuilder sendSubscriberExceptionEvent(boolean z) {
        this.sendSubscriberExceptionEvent = z;
        return this;
    }

    public EventBusBuilder skipMethodVerificationFor(Class<?> cls) {
        if (this.skipMethodVerificationForClasses == null) {
            this.skipMethodVerificationForClasses = new ArrayList();
        }
        this.skipMethodVerificationForClasses.add(cls);
        return this;
    }

    public EventBusBuilder strictMethodVerification(boolean z) {
        this.strictMethodVerification = z;
        return this;
    }

    public EventBusBuilder throwSubscriberException(boolean z) {
        this.throwSubscriberException = z;
        return this;
    }
}
