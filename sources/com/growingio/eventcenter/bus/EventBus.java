package com.growingio.eventcenter.bus;

import com.growingio.eventcenter.EventFilter;
import com.growingio.eventcenter.bus.meta.Subscriber;
import com.growingio.eventcenter.bus.meta.SubscriberInfoIndex;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
/* loaded from: classes2.dex */
public class EventBus {
    public static String TAG = "EventBus";
    static volatile EventBus defaultInstance;
    private final AsyncPoster asyncPoster;
    private final BackgroundPoster backgroundPoster;
    private final ThreadLocal<PostingThreadState> currentPostingThreadState;
    private final boolean eventInheritance;
    private final ExecutorService executorService;
    private final Map<Class<?>, CopyOnWriteArrayList<EventFilter>> filtersByEventType;
    private final int indexCount;
    private final boolean logNoSubscriberMessages;
    private final boolean logSubscriberExceptions;
    private final Logger logger;
    private final Poster mainThreadPoster;
    private final MainThreadSupport mainThreadSupport;
    private final boolean sendNoSubscriberEvent;
    private final boolean sendSubscriberExceptionEvent;
    private final Map<Class<?>, Object> stickyEvents;
    private final Map<Class<?>, CopyOnWriteArrayList<Subscription>> subscriptionsByEventType;
    private final boolean throwSubscriberException;
    private final Map<Object, List<Class<?>>> typesBySubscriber;
    private static final EventBusBuilder DEFAULT_BUILDER = new EventBusBuilder();
    private static final Map<Class<?>, List<Class<?>>> eventTypesCache = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.growingio.eventcenter.bus.EventBus$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$growingio$eventcenter$bus$ThreadMode;

        static {
            int[] iArr = new int[ThreadMode.values().length];
            $SwitchMap$com$growingio$eventcenter$bus$ThreadMode = iArr;
            try {
                iArr[ThreadMode.POSTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$growingio$eventcenter$bus$ThreadMode[ThreadMode.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$growingio$eventcenter$bus$ThreadMode[ThreadMode.MAIN_ORDERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$growingio$eventcenter$bus$ThreadMode[ThreadMode.BACKGROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$growingio$eventcenter$bus$ThreadMode[ThreadMode.ASYNC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes2.dex */
    interface PostCallback {
        void onPostCompleted(List<SubscriberExceptionEvent> list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class PostingThreadState {
        boolean canceled;
        Object event;
        final List<Object> eventQueue = new ArrayList();
        boolean isMainThread;
        boolean isPosting;
        Subscription subscription;

        PostingThreadState() {
        }
    }

    public EventBus() {
        this(DEFAULT_BUILDER);
    }

    static void addInterfaces(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                addInterfaces(list, cls.getInterfaces());
            }
        }
    }

    public static EventBusBuilder builder() {
        return new EventBusBuilder();
    }

    private void checkPostStickyEventToSubscription(Subscription subscription, Object obj) {
        if (obj != null) {
            postToSubscription(subscription, obj, isMainThread());
        }
    }

    public static void clearCaches() {
        eventTypesCache.clear();
    }

    public static EventBus getDefault() {
        EventBus eventBus = defaultInstance;
        if (eventBus == null) {
            synchronized (EventBus.class) {
                eventBus = defaultInstance;
                if (eventBus == null) {
                    eventBus = new EventBus();
                    defaultInstance = eventBus;
                }
            }
        }
        return eventBus;
    }

    private boolean isMainThread() {
        MainThreadSupport mainThreadSupport = this.mainThreadSupport;
        if (mainThreadSupport != null) {
            return mainThreadSupport.isMainThread();
        }
        return true;
    }

    private static List<Class<?>> lookupAllEventTypes(Class<?> cls) {
        List<Class<?>> list;
        Map<Class<?>, List<Class<?>>> map = eventTypesCache;
        synchronized (map) {
            list = map.get(cls);
            if (list == null) {
                list = new ArrayList<>();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    addInterfaces(list, cls2.getInterfaces());
                }
                eventTypesCache.put(cls, list);
            }
        }
        return list;
    }

    private void postSingleEvent(Object obj, PostingThreadState postingThreadState) throws Error {
        boolean postSingleEventForEventType;
        Class<?> cls = obj.getClass();
        if (this.eventInheritance) {
            List<Class<?>> lookupAllEventTypes = lookupAllEventTypes(cls);
            int size = lookupAllEventTypes.size();
            postSingleEventForEventType = false;
            for (int i2 = 0; i2 < size; i2++) {
                postSingleEventForEventType |= postSingleEventForEventType(obj, postingThreadState, lookupAllEventTypes.get(i2));
            }
        } else {
            postSingleEventForEventType = postSingleEventForEventType(obj, postingThreadState, cls);
        }
        if (postSingleEventForEventType) {
            return;
        }
        if (this.logNoSubscriberMessages) {
            Logger logger = this.logger;
            Level level = Level.FINE;
            logger.log(level, "No subscribers registered for event " + cls);
        }
        if (!this.sendNoSubscriberEvent || cls == NoSubscriberEvent.class || cls == SubscriberExceptionEvent.class) {
            return;
        }
        realPost(new NoSubscriberEvent(this, obj));
    }

    private boolean postSingleEventForEventType(Object obj, PostingThreadState postingThreadState, Class<?> cls) {
        CopyOnWriteArrayList<Subscription> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.subscriptionsByEventType.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator<Subscription> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            Subscription next = it.next();
            CopyOnWriteArrayList<EventFilter> copyOnWriteArrayList2 = this.filtersByEventType.get(cls);
            if (copyOnWriteArrayList2 != null && !copyOnWriteArrayList2.isEmpty()) {
                Iterator<EventFilter> it2 = copyOnWriteArrayList2.iterator();
                while (it2.hasNext()) {
                    if (!it2.next().beforeAction(obj, next.subscriber, next.subscriberMethod.methodName)) {
                        return false;
                    }
                }
            }
            postingThreadState.event = obj;
            postingThreadState.subscription = next;
            try {
                postToSubscription(next, obj, postingThreadState.isMainThread);
                if (postingThreadState.canceled) {
                    return true;
                }
            } finally {
                postingThreadState.event = null;
                postingThreadState.subscription = null;
                postingThreadState.canceled = false;
            }
        }
        return true;
    }

    private void postToSubscription(Subscription subscription, Object obj, boolean z) {
        int i2 = AnonymousClass2.$SwitchMap$com$growingio$eventcenter$bus$ThreadMode[subscription.subscriberMethod.threadMode.ordinal()];
        if (i2 == 1) {
            invokeSubscriber(subscription, obj);
        } else if (i2 == 2) {
            if (z) {
                invokeSubscriber(subscription, obj);
            } else {
                this.mainThreadPoster.enqueue(subscription, obj);
            }
        } else if (i2 == 3) {
            Poster poster = this.mainThreadPoster;
            if (poster != null) {
                poster.enqueue(subscription, obj);
            } else {
                invokeSubscriber(subscription, obj);
            }
        } else if (i2 == 4) {
            if (z) {
                this.backgroundPoster.enqueue(subscription, obj);
            } else {
                invokeSubscriber(subscription, obj);
            }
        } else if (i2 == 5) {
            this.asyncPoster.enqueue(subscription, obj);
        } else {
            throw new IllegalStateException("Unknown thread mode: " + subscription.subscriberMethod.threadMode);
        }
    }

    private void subscribe(Subscriber subscriber, SubscriberMethod subscriberMethod) {
        Class<?> cls = subscriberMethod.eventType;
        Subscription subscription = new Subscription(subscriber, subscriberMethod);
        CopyOnWriteArrayList<Subscription> copyOnWriteArrayList = this.subscriptionsByEventType.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.subscriptionsByEventType.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(subscription)) {
            throw new EventCenterException("Subscriber " + subscriber.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i2 = 0; i2 <= size; i2++) {
            if (i2 == size || subscriberMethod.priority > copyOnWriteArrayList.get(i2).subscriberMethod.priority) {
                copyOnWriteArrayList.add(i2, subscription);
                break;
            }
        }
        List<Class<?>> list = this.typesBySubscriber.get(subscriber);
        if (list == null) {
            list = new ArrayList<>();
            this.typesBySubscriber.put(subscriber, list);
        }
        list.add(cls);
        if (subscriberMethod.sticky) {
            if (this.eventInheritance) {
                for (Map.Entry<Class<?>, Object> entry : this.stickyEvents.entrySet()) {
                    if (cls.isAssignableFrom(entry.getKey())) {
                        checkPostStickyEventToSubscription(subscription, entry.getValue());
                    }
                }
                return;
            }
            checkPostStickyEventToSubscription(subscription, this.stickyEvents.get(cls));
        }
    }

    private void unsubscribeByEventType(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<Subscription> copyOnWriteArrayList = this.subscriptionsByEventType.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Subscription subscription = copyOnWriteArrayList.get(i2);
                if (subscription.subscriber == obj) {
                    subscription.active = false;
                    copyOnWriteArrayList.remove(i2);
                    i2--;
                    size--;
                }
                i2++;
            }
        }
    }

    void afterActionFilter(Subscription subscription, Object obj) {
        CopyOnWriteArrayList<EventFilter> copyOnWriteArrayList = this.filtersByEventType.get(subscription.subscriberMethod.eventType);
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return;
        }
        Iterator<EventFilter> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            it.next().afterAction(obj, subscription.subscriber, subscription.subscriberMethod.methodName);
        }
    }

    public void cancelEventDelivery(Object obj) {
        PostingThreadState postingThreadState = this.currentPostingThreadState.get();
        if (!postingThreadState.isPosting) {
            throw new EventCenterException("This method may only be called from inside event handling methods on the posting thread");
        }
        if (obj != null) {
            if (postingThreadState.event == obj) {
                if (postingThreadState.subscription.subscriberMethod.threadMode == ThreadMode.POSTING) {
                    postingThreadState.canceled = true;
                    return;
                }
                throw new EventCenterException(" event handlers may only abort the incoming event");
            }
            throw new EventCenterException("Only the currently handled event may be aborted");
        }
        throw new EventCenterException("Event may not be null");
    }

    public ExecutorService getExecutorService() {
        return this.executorService;
    }

    public Logger getLogger() {
        return this.logger;
    }

    public <T> T getStickyEvent(Class<T> cls) {
        T cast;
        synchronized (this.stickyEvents) {
            cast = cls.cast(this.stickyEvents.get(cls));
        }
        return cast;
    }

    public boolean hasSubscriberForEvent(Class<?> cls) {
        CopyOnWriteArrayList<Subscription> copyOnWriteArrayList;
        List<Class<?>> lookupAllEventTypes = lookupAllEventTypes(cls);
        if (lookupAllEventTypes != null) {
            int size = lookupAllEventTypes.size();
            for (int i2 = 0; i2 < size; i2++) {
                Class<?> cls2 = lookupAllEventTypes.get(i2);
                synchronized (this) {
                    copyOnWriteArrayList = this.subscriptionsByEventType.get(cls2);
                }
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invokeSubscriber(PendingPost pendingPost) {
        Object obj = pendingPost.event;
        Subscription subscription = pendingPost.subscription;
        PendingPost.releasePendingPost(pendingPost);
        if (subscription.active) {
            invokeSubscriber(subscription, obj);
        }
    }

    public synchronized boolean isRegistered(Object obj) {
        return this.typesBySubscriber.containsKey(obj);
    }

    public void post(Object obj) {
        realPost(obj);
    }

    public void postSticky(Object obj) {
        synchronized (this.stickyEvents) {
            this.stickyEvents.put(obj.getClass(), obj);
        }
        post(obj);
    }

    public void realPost(Object obj) {
        PostingThreadState postingThreadState = this.currentPostingThreadState.get();
        List<Object> list = postingThreadState.eventQueue;
        list.add(obj);
        if (postingThreadState.isPosting) {
            return;
        }
        postingThreadState.isMainThread = isMainThread();
        postingThreadState.isPosting = true;
        if (postingThreadState.canceled) {
            throw new EventCenterException("Internal error. Abort state was not reset");
        }
        while (true) {
            try {
                if (list.isEmpty()) {
                    return;
                }
                postSingleEvent(list.remove(0), postingThreadState);
            } finally {
                postingThreadState.isPosting = false;
                postingThreadState.isMainThread = false;
            }
        }
    }

    public void realRegister(Subscriber subscriber) {
        SubscriberMethod[] subscriberMethodArr = subscriber.get$SubscriberMethods();
        synchronized (this) {
            for (SubscriberMethod subscriberMethod : subscriberMethodArr) {
                subscribe(subscriber, subscriberMethod);
            }
        }
    }

    public void register(Object obj) {
        if (obj instanceof Subscriber) {
            realRegister((Subscriber) obj);
        }
    }

    public void registerFilter(EventFilter eventFilter) {
        Class<?> eventClass = eventFilter.getEventClass();
        CopyOnWriteArrayList<EventFilter> copyOnWriteArrayList = this.filtersByEventType.get(eventClass);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.add(eventFilter);
        } else {
            int size = copyOnWriteArrayList.size();
            for (int i2 = 0; i2 <= size; i2++) {
                if (i2 == size || eventFilter.getPriority() > copyOnWriteArrayList.get(i2).getPriority()) {
                    copyOnWriteArrayList.add(i2, eventFilter);
                    break;
                }
            }
        }
        this.filtersByEventType.put(eventClass, copyOnWriteArrayList);
    }

    public void removeAllStickyEvents() {
        synchronized (this.stickyEvents) {
            this.stickyEvents.clear();
        }
    }

    public <T> T removeStickyEvent(Class<T> cls) {
        T cast;
        synchronized (this.stickyEvents) {
            cast = cls.cast(this.stickyEvents.remove(cls));
        }
        return cast;
    }

    public String toString() {
        return "EventBus[indexCount=" + this.indexCount + ", eventInheritance=" + this.eventInheritance + "]";
    }

    public void unRegisterFilter(EventFilter eventFilter) {
        CopyOnWriteArrayList<EventFilter> copyOnWriteArrayList = this.filtersByEventType.get(eventFilter.getEventClass());
        if (copyOnWriteArrayList == null) {
            return;
        }
        copyOnWriteArrayList.remove(eventFilter);
        if (copyOnWriteArrayList.isEmpty()) {
            this.filtersByEventType.remove(eventFilter.getEventClass());
        }
    }

    public synchronized void unregister(Object obj) {
        List<Class<?>> list = this.typesBySubscriber.get(obj);
        if (list != null) {
            for (Class<?> cls : list) {
                unsubscribeByEventType(obj, cls);
            }
            this.typesBySubscriber.remove(obj);
        } else {
            Logger logger = this.logger;
            Level level = Level.WARNING;
            logger.log(level, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EventBus(EventBusBuilder eventBusBuilder) {
        this.currentPostingThreadState = new ThreadLocal<PostingThreadState>() { // from class: com.growingio.eventcenter.bus.EventBus.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.lang.ThreadLocal
            public PostingThreadState initialValue() {
                return new PostingThreadState();
            }
        };
        this.logger = eventBusBuilder.getLogger();
        this.filtersByEventType = new HashMap();
        this.subscriptionsByEventType = new HashMap();
        this.typesBySubscriber = new HashMap();
        this.stickyEvents = new ConcurrentHashMap();
        MainThreadSupport mainThreadSupport = eventBusBuilder.getMainThreadSupport();
        this.mainThreadSupport = mainThreadSupport;
        this.mainThreadPoster = mainThreadSupport != null ? mainThreadSupport.createPoster(this) : null;
        this.backgroundPoster = new BackgroundPoster(this);
        this.asyncPoster = new AsyncPoster(this);
        List<SubscriberInfoIndex> list = eventBusBuilder.subscriberInfoIndexes;
        this.indexCount = list != null ? list.size() : 0;
        this.logSubscriberExceptions = eventBusBuilder.logSubscriberExceptions;
        this.logNoSubscriberMessages = eventBusBuilder.logNoSubscriberMessages;
        this.sendSubscriberExceptionEvent = eventBusBuilder.sendSubscriberExceptionEvent;
        this.sendNoSubscriberEvent = eventBusBuilder.sendNoSubscriberEvent;
        this.throwSubscriberException = eventBusBuilder.throwSubscriberException;
        this.eventInheritance = eventBusBuilder.eventInheritance;
        this.executorService = eventBusBuilder.executorService;
    }

    public boolean removeStickyEvent(Object obj) {
        synchronized (this.stickyEvents) {
            Class<?> cls = obj.getClass();
            if (obj.equals(this.stickyEvents.get(cls))) {
                this.stickyEvents.remove(cls);
                return true;
            }
            return false;
        }
    }

    void invokeSubscriber(Subscription subscription, Object obj) {
        subscription.action(obj);
        afterActionFilter(subscription, obj);
    }
}
