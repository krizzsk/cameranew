package com.growingio.eventcenter.bus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
/* loaded from: classes2.dex */
class HandlerPoster extends Handler implements Poster {
    private final EventBus eventBus;
    private boolean handlerActive;
    private final int maxMillisInsideHandleMessage;
    private final PendingPostQueue queue;

    public HandlerPoster(EventBus eventBus, Looper looper, int i2) {
        super(looper);
        this.eventBus = eventBus;
        this.maxMillisInsideHandleMessage = i2;
        this.queue = new PendingPostQueue();
    }

    @Override // com.growingio.eventcenter.bus.Poster
    public void enqueue(Subscription subscription, Object obj) {
        PendingPost obtainPendingPost = PendingPost.obtainPendingPost(subscription, obj);
        synchronized (this) {
            this.queue.enqueue(obtainPendingPost);
            if (!this.handlerActive) {
                this.handlerActive = true;
                if (!sendMessage(obtainMessage())) {
                    throw new EventCenterException("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                PendingPost poll = this.queue.poll();
                if (poll == null) {
                    synchronized (this) {
                        poll = this.queue.poll();
                        if (poll == null) {
                            this.handlerActive = false;
                            return;
                        }
                    }
                }
                this.eventBus.invokeSubscriber(poll);
            } while (SystemClock.uptimeMillis() - uptimeMillis < this.maxMillisInsideHandleMessage);
            if (sendMessage(obtainMessage())) {
                this.handlerActive = true;
                return;
            }
            throw new EventCenterException("Could not send handler message");
        } finally {
            this.handlerActive = false;
        }
    }
}
