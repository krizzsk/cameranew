package com.growingio.eventcenter.bus;

import android.os.Looper;
/* loaded from: classes2.dex */
public interface MainThreadSupport {

    /* loaded from: classes2.dex */
    public static class AndroidHandlerMainThreadSupport implements MainThreadSupport {
        private final Looper looper;

        public AndroidHandlerMainThreadSupport(Looper looper) {
            this.looper = looper;
        }

        @Override // com.growingio.eventcenter.bus.MainThreadSupport
        public Poster createPoster(EventBus eventBus) {
            return new HandlerPoster(eventBus, this.looper, 10);
        }

        @Override // com.growingio.eventcenter.bus.MainThreadSupport
        public boolean isMainThread() {
            return this.looper == Looper.myLooper();
        }
    }

    Poster createPoster(EventBus eventBus);

    boolean isMainThread();
}
