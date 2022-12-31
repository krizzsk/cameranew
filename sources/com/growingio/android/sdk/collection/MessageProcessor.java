package com.growingio.android.sdk.collection;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import com.growingio.android.sdk.base.event.RefreshPageEvent;
import com.growingio.android.sdk.models.AppCloseEvent;
import com.growingio.android.sdk.models.ConversionEvent;
import com.growingio.android.sdk.models.PageEvent;
import com.growingio.android.sdk.models.PageVariableEvent;
import com.growingio.android.sdk.models.PeopleEvent;
import com.growingio.android.sdk.models.VPAEvent;
import com.growingio.android.sdk.models.VisitEvent;
import com.growingio.android.sdk.models.VisitorVarEvent;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.cp_annotation.Subscribe;
import com.growingio.eventcenter.EventCenter;
import com.growingio.eventcenter.bus.SubscriberMethod;
import com.growingio.eventcenter.bus.ThreadMode;
import com.growingio.eventcenter.bus.meta.Subscriber;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class MessageProcessor implements Subscriber {
    private static final String TAG = "GIO.MessageProcessor";
    private CoreAppState mCoreAppState;
    private GConfig mGConfig;
    private PageEvent mLastPageEvent;
    private WeakReference<Object> mLastPageObjRef;
    private PageEvent mPendingPageEvent;
    private WeakReference<Object> mPendingPageObjRef;

    public MessageProcessor(GConfig gConfig, CoreAppState coreAppState) {
        WeakReference<Object> weakReference = Constants.NULL_REF;
        this.mLastPageObjRef = weakReference;
        this.mPendingPageObjRef = weakReference;
        this.mGConfig = gConfig;
        this.mCoreAppState = coreAppState;
    }

    @Override // com.growingio.eventcenter.bus.meta.Subscriber
    public void do$Action(String str, Object obj) {
        if (str.equals("#refreshPageIfNeed(com.growingio.android.sdk.base.event.RefreshPageEvent")) {
            refreshPageIfNeed((RefreshPageEvent) obj);
        } else {
            System.out.println("No such method to delegate");
        }
    }

    @Override // com.growingio.eventcenter.bus.meta.Subscriber
    public SubscriberMethod[] get$SubscriberMethods() {
        return new SubscriberMethod[]{new SubscriberMethod("refreshPageIfNeed", RefreshPageEvent.class, "#refreshPageIfNeed(com.growingio.android.sdk.base.event.RefreshPageEvent", ThreadMode.MAIN, 1000, false)};
    }

    public PageEvent getLastPageEvent() {
        return this.mLastPageEvent;
    }

    public long getPTMWithPending() {
        PageEvent pageEvent = this.mPendingPageEvent;
        if (pageEvent != null) {
            return pageEvent.getTime();
        }
        return getPTMWithoutPending();
    }

    public long getPTMWithoutPending() {
        PageEvent pageEvent = this.mLastPageEvent;
        if (pageEvent == null) {
            return 0L;
        }
        return pageEvent.getTime();
    }

    public String getPageNameWithPending() {
        PageEvent pageEvent = this.mPendingPageEvent;
        if (pageEvent != null) {
            return pageEvent.mPageName;
        }
        return getPageNameWithoutPending();
    }

    public String getPageNameWithoutPending() {
        PageEvent pageEvent = this.mLastPageEvent;
        if (pageEvent == null) {
            return null;
        }
        return pageEvent.mPageName;
    }

    public Object getPendingObj() {
        return this.mPendingPageObjRef.get();
    }

    public PageEvent getPendingPageEvent() {
        return this.mPendingPageEvent;
    }

    public boolean isLastEventPage(Object obj) {
        if (obj instanceof String) {
            return obj.equals(this.mLastPageObjRef.get());
        }
        return this.mLastPageObjRef.get() == obj;
    }

    public boolean isPendingPage(Object obj) {
        if (obj instanceof String) {
            return obj.equals(this.mPendingPageObjRef.get());
        }
        return this.mPendingPageObjRef.get() == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onAppVariableUpdated() {
        if (this.mPendingPageEvent != null || this.mLastPageEvent == null) {
            return;
        }
        refreshPageIfNeed(new RefreshPageEvent(false, false));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPageVariableUpdated(Object obj) {
        LogUtil.i(TAG, "onPageVariableUpdated:" + obj.toString());
        if (isLastEventPage(obj)) {
            persistEvent(new PageVariableEvent(this.mLastPageEvent, this.mCoreAppState.getPageVariableHelper(obj).getVariable()));
        }
    }

    public void persistEvent(@Nullable VPAEvent vPAEvent) {
        if (vPAEvent == null || !this.mGConfig.isEnabled()) {
            return;
        }
        this.mCoreAppState.waitUntilInitComplete();
        EventCenter.getInstance().post(vPAEvent);
    }

    @Subscribe(priority = 1000, threadMode = ThreadMode.MAIN)
    public void refreshPageIfNeed(RefreshPageEvent refreshPageEvent) {
        if (this.mLastPageEvent == null) {
            LogUtil.d(TAG, "refreshPageIfNeed: lastPage is null, return");
            return;
        }
        long currentTimeMillis = refreshPageEvent.isNewPTM() ? System.currentTimeMillis() : this.mLastPageEvent.getTime();
        String str = this.mLastPageEvent.mPageName;
        savePage(new PageEvent(str, str, currentTimeMillis), this.mLastPageObjRef.get());
    }

    public void saveCustomEvent(CustomEvent customEvent) {
        if (GConfig.isRnMode) {
            savePage("GIOFakePage");
        }
        if (!customEvent.fromWebView()) {
            customEvent.setPageTime(getPTMWithPending());
            customEvent.mPageName = getPageNameWithPending();
        }
        persistEvent(customEvent);
    }

    public void savePage(PageEvent pageEvent, Object obj) {
        JSONObject variable;
        PageEvent pageEvent2 = this.mPendingPageEvent;
        if (pageEvent2 != null && pageEvent2 != pageEvent && !pageEvent2.mPageName.equals(pageEvent.mPageName)) {
            persistEvent(this.mPendingPageEvent);
            Object obj2 = this.mPendingPageObjRef.get();
            if (obj2 != null && (variable = this.mCoreAppState.getPageVariableHelper(obj2).getVariable()) != null && variable.length() != 0) {
                persistEvent(new PageVariableEvent(this.mPendingPageEvent, variable));
            }
        }
        this.mPendingPageEvent = null;
        this.mPendingPageObjRef = Constants.NULL_REF;
        this.mLastPageEvent = pageEvent;
        this.mLastPageObjRef = new WeakReference<>(obj);
        persistEvent(pageEvent);
        JSONObject variable2 = this.mCoreAppState.getPageVariableHelper(obj).getVariable();
        if (variable2 == null || variable2.length() == 0) {
            return;
        }
        persistEvent(new PageVariableEvent(this.mLastPageEvent, variable2));
    }

    public void saveVisit(boolean z) {
        if (z) {
            persistEvent(VisitEvent.makeVisitEvent());
            JSONObject visitorVariable = this.mCoreAppState.getVisitorVariable();
            if (visitorVariable != null) {
                persistEvent(new VisitorVarEvent(visitorVariable, System.currentTimeMillis()));
            }
        } else {
            persistEvent(VisitEvent.getCachedVisitEvent());
        }
        if (GConfig.isRnMode) {
            savePage("GIOFakePage");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAppClose(long j2) {
        PageEvent pageEvent = this.mLastPageEvent;
        if (pageEvent == null) {
            LogUtil.d(TAG, "appClose: lastPage is null, return");
        } else {
            persistEvent(new AppCloseEvent(pageEvent, j2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEvar(JSONObject jSONObject) {
        persistEvent(new ConversionEvent(jSONObject, System.currentTimeMillis()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPeople(JSONObject jSONObject) {
        persistEvent(new PeopleEvent(jSONObject, System.currentTimeMillis()));
    }

    public void updatePendingPageEvent(PageEvent pageEvent, Object obj) {
        this.mPendingPageEvent = pageEvent;
        this.mPendingPageObjRef = new WeakReference<>(obj);
    }

    public void savePage(String str) {
        PageEvent pageEvent = this.mLastPageEvent;
        savePage(new PageEvent(str, pageEvent != null ? pageEvent.mPageName : null, System.currentTimeMillis()), str);
    }
}
