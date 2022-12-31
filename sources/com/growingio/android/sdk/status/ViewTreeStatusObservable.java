package com.growingio.android.sdk.status;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.RequiresApi;
import com.growingio.android.sdk.base.event.ViewTreeDrawEvent;
import com.growingio.android.sdk.base.event.ViewTreeStatusChangeEvent;
import com.growingio.android.sdk.base.event.ViewTreeWindowFocusChangedEvent;
import com.growingio.eventcenter.bus.EventBus;
@RequiresApi(api = 16)
/* loaded from: classes2.dex */
public class ViewTreeStatusObservable implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, ViewTreeObserver.OnGlobalFocusChangeListener, ViewTreeObserver.OnDrawListener {
    public static volatile ViewTreeStatusObservable viewTreeStatusObservable;

    @RequiresApi(api = 18)
    /* loaded from: classes2.dex */
    public static class FocusListener implements ViewTreeObserver.OnWindowFocusChangeListener {
        private static FocusListener instance;

        public static FocusListener getInstance() {
            if (instance == null) {
                instance = new FocusListener();
            }
            return instance;
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean z) {
            EventBus.getDefault().post(new ViewTreeWindowFocusChangedEvent());
        }
    }

    public static ViewTreeStatusObservable getInstance() {
        if (viewTreeStatusObservable == null) {
            synchronized (ViewTreeStatusObservable.class) {
                if (viewTreeStatusObservable == null) {
                    viewTreeStatusObservable = new ViewTreeStatusObservable();
                }
            }
        }
        return viewTreeStatusObservable;
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public void onDraw() {
        EventBus.getDefault().post(new ViewTreeDrawEvent());
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public void onGlobalFocusChanged(View view, View view2) {
        EventBus.getDefault().post(new ViewTreeStatusChangeEvent(ViewTreeStatusChangeEvent.StatusType.FocusChanged, view, view2));
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        EventBus.getDefault().post(new ViewTreeStatusChangeEvent(ViewTreeStatusChangeEvent.StatusType.LayoutChanged));
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        EventBus.getDefault().post(new ViewTreeStatusChangeEvent(ViewTreeStatusChangeEvent.StatusType.ScrollChanged));
    }
}
