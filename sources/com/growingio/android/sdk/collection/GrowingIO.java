package com.growingio.android.sdk.collection;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AdapterView;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.growingio.android.sdk.autoburry.AutoBuryAppState;
import com.growingio.android.sdk.autoburry.AutoBuryObservableInitialize;
import com.growingio.android.sdk.autoburry.ImpObserver;
import com.growingio.android.sdk.deeplink.DeeplinkCallback;
import com.growingio.android.sdk.utils.ClassExistHelper;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GrowingIO extends AbstractGrowingIO<GrowingIO> {
    private AutoBuryAppState autoBuryAppState;
    private ImpObserver impObserver;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class EmptyGrowingIO extends GrowingIO {
        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO clearGeoLocation() {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO clearUserId() {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO disable() {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public void disableDataCollect() {
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO disableImpression() {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public boolean doDeeplinkByUrl(@Nullable String str, @Nullable DeeplinkCallback deeplinkCallback) {
            return false;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public void enableDataCollect() {
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public String getDeviceId() {
            return null;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public String getSessionId() {
            return null;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public String getUserId() {
            return null;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public String getVisitUserId() {
            return null;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO ignoreFragment(Activity activity, Fragment fragment) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO ignoreFragment(Activity activity, androidx.fragment.app.Fragment fragment) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO ignoreFragmentX(Activity activity, androidx.fragment.app.Fragment fragment) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO manualPageShow(@NonNull Activity activity, @NonNull String str) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO markViewImpression(ImpressionMark impressionMark) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO onNewIntent(Activity activity, Intent intent) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO resume() {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public void saveVisit(String str) {
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO setAndroidIdEnable(boolean z) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO setAppVariable(String str, Number number) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO setAppVariable(String str, String str2) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO setAppVariable(String str, boolean z) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO setAppVariable(JSONObject jSONObject) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO setChannel(String str) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO setEvar(String str, Number number) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO setEvar(String str, String str2) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO setEvar(String str, boolean z) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO setEvar(JSONObject jSONObject) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO setGeoLocation(double d2, double d3) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO setGoogleAdIdEnable(boolean z) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO setImeiEnable(boolean z) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO setImp(boolean z) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO setOAIDEnable(boolean z) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO setPageName(Activity activity, String str) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO setPageName(Fragment fragment, String str) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO setPageName(androidx.fragment.app.Fragment fragment, String str) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO setPageNameX(androidx.fragment.app.Fragment fragment, String str) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO setPageVariable(Activity activity, String str, Number number) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO setPageVariable(Activity activity, String str, String str2) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO setPageVariable(Activity activity, String str, boolean z) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO setPageVariable(Activity activity, JSONObject jSONObject) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO setPageVariable(Fragment fragment, String str, Number number) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO setPageVariable(Fragment fragment, String str, String str2) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO setPageVariable(Fragment fragment, String str, boolean z) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO setPageVariable(Fragment fragment, JSONObject jSONObject) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO setPageVariable(androidx.fragment.app.Fragment fragment, String str, Number number) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO setPageVariable(androidx.fragment.app.Fragment fragment, String str, String str2) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO setPageVariable(androidx.fragment.app.Fragment fragment, String str, boolean z) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO setPageVariable(androidx.fragment.app.Fragment fragment, JSONObject jSONObject) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO setPageVariable(String str, JSONObject jSONObject) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO setPageVariableX(androidx.fragment.app.Fragment fragment, String str, Number number) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO setPageVariableX(androidx.fragment.app.Fragment fragment, String str, String str2) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO setPageVariableX(androidx.fragment.app.Fragment fragment, String str, boolean z) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO setPageVariableX(androidx.fragment.app.Fragment fragment, JSONObject jSONObject) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO setPeopleVariable(String str, Number number) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO setPeopleVariable(String str, String str2) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO setPeopleVariable(String str, boolean z) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO setPeopleVariable(JSONObject jSONObject) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO setTestHandler(Handler handler) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO setThrottle(boolean z) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO setTrackAllFragment(Activity activity, boolean z) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO setUserId(String str) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO setVisitor(JSONObject jSONObject) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO stop() {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO stopMarkViewImpression(View view) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO track(String str) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO track(String str, Number number) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO track(String str, Number number, JSONObject jSONObject) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public GrowingIO track(String str, JSONObject jSONObject) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO trackEditText(EditText editText) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO trackFragment(Activity activity, Fragment fragment) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO trackFragment(Activity activity, androidx.fragment.app.Fragment fragment) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO trackFragment(Activity activity, ViewPager viewPager, View view, String str) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO trackFragmentX(Activity activity, androidx.fragment.app.Fragment fragment) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.GrowingIO
        public GrowingIO trackFragmentX(Activity activity, ViewPager viewPager, View view, String str) {
            return this;
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public void trackPage(String str) {
        }

        @Override // com.growingio.android.sdk.collection.AbstractGrowingIO
        public void trackPage(String str, String str2, long j2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GrowingIO(Configuration configuration) {
        super(configuration);
        this.autoBuryAppState = AutoBuryObservableInitialize.autoBuryAppState();
        this.impObserver = AutoBuryObservableInitialize.impObserver();
        GInternal.getInstance().addFeaturesVersion("au", GConfig.GROWING_VERSION);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GrowingIO customStart(Configuration configuration) {
        AbstractGrowingIO.setHybridJSSDKUrlPrefix(configuration.hybridJSSDKUrlPrefix);
        AbstractGrowingIO.setJavaCirclePluginHost(configuration.javaCirclePluginHost);
        return AbstractGrowingIO.customStart(configuration);
    }

    private GrowingIO ignoreFragmentInternal(final Activity activity, final Object obj) {
        AbstractGrowingIO.runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.GrowingIO.8
            @Override // java.lang.Runnable
            public void run() {
                GrowingIO.this.autoBuryAppState.ignoreFragment(activity, obj);
            }
        });
        return this;
    }

    public static void ignoredView(final View view) {
        AbstractGrowingIO.runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.GrowingIO.2
            @Override // java.lang.Runnable
            public void run() {
                View view2 = view;
                if (view2 != null) {
                    view2.setTag(AbstractGrowingIO.GROWING_IGNORE_VIEW_KEY, Boolean.TRUE);
                }
            }
        });
    }

    private GrowingIO setPageNameInternal(final Object obj, final String str) {
        if (!this.mArgumentChecker.isIllegalEventName(str)) {
            AbstractGrowingIO.runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.GrowingIO.9
                @Override // java.lang.Runnable
                public void run() {
                    GrowingIO.this.autoBuryAppState.setPageAlias(obj, str);
                }
            });
        }
        return this;
    }

    private GrowingIO setPageVariableInternal(final Object obj, String str, JSONObject jSONObject) {
        if (obj == null) {
            Log.e("GrowingIO", ErrorLog.argumentBeNull(str));
            return this;
        }
        final JSONObject validJSONObject = this.mArgumentChecker.validJSONObject(jSONObject, true);
        if (validJSONObject != null) {
            AbstractGrowingIO.runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.GrowingIO.12
                @Override // java.lang.Runnable
                public void run() {
                    AbstractGrowingIO.getAPPState().setPageVariable(obj, validJSONObject);
                }
            });
        }
        return this;
    }

    @Deprecated
    public static void setPressed(final View view) {
        AbstractGrowingIO.runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.GrowingIO.16
            @Override // java.lang.Runnable
            public void run() {
                view.setPressed(true);
                view.setClickable(true);
                view.postDelayed(new Runnable() { // from class: com.growingio.android.sdk.collection.GrowingIO.16.1
                    @Override // java.lang.Runnable
                    public void run() {
                        view.setPressed(false);
                    }
                }, ViewConfiguration.getPressedStateDuration());
            }
        });
    }

    @Deprecated
    public static void setTabName(View view, String str) {
        view.setTag(AbstractGrowingIO.GROWING_VIEW_NAME_KEY, str);
    }

    public static void setViewContent(View view, String str) {
        view.setTag(AbstractGrowingIO.GROWING_CONTENT_KEY, str);
    }

    public static void setViewInfo(View view, String str) {
        view.setTag(AbstractGrowingIO.GROWING_INHERIT_INFO_KEY, str);
    }

    public static GrowingIO startWithConfiguration(Application application, Configuration configuration) {
        return AbstractGrowingIO.startWithConfiguration(application, configuration);
    }

    public static void trackBanner(final View view, final List<String> list) {
        if (!(view instanceof AdapterView) && !ClassExistHelper.instanceOfAndroidXRecyclerView(view) && !ClassExistHelper.instanceOfAndroidXViewPager(view) && !ClassExistHelper.instanceOfSupportViewPager(view) && !ClassExistHelper.instanceOfSupportRecyclerView(view)) {
            new IllegalArgumentException("当前只支持AdapterView, ViewPager 和 RecyclerView 实现的Banner").printStackTrace();
        }
        AbstractGrowingIO.runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.GrowingIO.1
            @Override // java.lang.Runnable
            public void run() {
                view.setTag(AbstractGrowingIO.GROWING_BANNER_KEY, list);
            }
        });
    }

    private GrowingIO trackFragmentInternal(final Activity activity, final Object obj) {
        AbstractGrowingIO.runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.GrowingIO.10
            @Override // java.lang.Runnable
            public void run() {
                GrowingIO.this.autoBuryAppState.trackFragment(activity, obj);
            }
        });
        return this;
    }

    private GrowingIO trackFragmentViewPagerInternal(final Activity activity, final Object obj, final View view, final String str) {
        if (!this.mArgumentChecker.isIllegalEventName(str)) {
            AbstractGrowingIO.runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.GrowingIO.11
                @Override // java.lang.Runnable
                public void run() {
                    GrowingIO.this.autoBuryAppState.trackCustomFragment(activity, (View) obj, view, str);
                }
            });
        }
        return this;
    }

    public GrowingIO ignoreFragment(Activity activity, Fragment fragment) {
        return ignoreFragmentInternal(activity, fragment);
    }

    public GrowingIO ignoreFragmentX(Activity activity, androidx.fragment.app.Fragment fragment) {
        return ignoreFragmentInternal(activity, fragment);
    }

    public void ignoreViewImp(final View view) {
        if (view != null) {
            AbstractGrowingIO.runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.GrowingIO.3
                @Override // java.lang.Runnable
                public void run() {
                    view.setTag(AbstractGrowingIO.GROWING_IGNORE_VIEW_IMP_KEY, Boolean.TRUE);
                }
            });
        }
    }

    public GrowingIO manualPageShow(final Activity activity, @NonNull final String str) {
        if (activity == null) {
            Log.e("GrowingIO", ErrorLog.VALUE_BE_EMPTY);
            return this;
        }
        if (!this.mArgumentChecker.isIllegalEventName(str)) {
            AbstractGrowingIO.runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.GrowingIO.4
                @Override // java.lang.Runnable
                public void run() {
                    GrowingIO.this.autoBuryAppState.manualPage(activity, str);
                }
            });
        }
        return this;
    }

    public GrowingIO markViewImpression(final ImpressionMark impressionMark) {
        if (this.mArgumentChecker.isIllegalEventName(impressionMark.getEventId())) {
            return this;
        }
        if (impressionMark.getVariable() != null) {
            impressionMark.setVariable(this.mArgumentChecker.validJSONObject(impressionMark.getVariable()));
        }
        AbstractGrowingIO.runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.GrowingIO.5
            @Override // java.lang.Runnable
            public void run() {
                GrowingIO.this.impObserver.markViewImpression(impressionMark);
            }
        });
        return this;
    }

    public GrowingIO setPageName(Activity activity, String str) {
        return setPageNameInternal(activity, str);
    }

    public GrowingIO setPageNameX(androidx.fragment.app.Fragment fragment, String str) {
        return setPageNameInternal(fragment, str);
    }

    public GrowingIO setPageVariable(Activity activity, JSONObject jSONObject) {
        return setPageVariableInternal(activity, "activity", jSONObject);
    }

    public GrowingIO setPageVariableX(androidx.fragment.app.Fragment fragment, JSONObject jSONObject) {
        return setPageVariableInternal(fragment, "fragment", jSONObject);
    }

    public GrowingIO setTrackAllFragment(final Activity activity, final boolean z) {
        if (activity == null) {
            return this;
        }
        AbstractGrowingIO.runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.GrowingIO.7
            @Override // java.lang.Runnable
            public void run() {
                GrowingIO.this.autoBuryAppState.setTrackAllFragment(activity, z);
            }
        });
        return this;
    }

    public GrowingIO stopMarkViewImpression(final View view) {
        AbstractGrowingIO.runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.GrowingIO.6
            @Override // java.lang.Runnable
            public void run() {
                GrowingIO.this.impObserver.stopStampViewImp(view);
            }
        });
        return this;
    }

    public GrowingIO trackEditText(final EditText editText) {
        AbstractGrowingIO.runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.GrowingIO.17
            @Override // java.lang.Runnable
            public void run() {
                editText.setTag(AbstractGrowingIO.GROWING_TRACK_TEXT, Boolean.TRUE);
            }
        });
        return this;
    }

    public GrowingIO trackFragment(Activity activity, Fragment fragment) {
        return trackFragmentInternal(activity, fragment);
    }

    public GrowingIO trackFragmentX(Activity activity, androidx.fragment.app.Fragment fragment) {
        return trackFragmentInternal(activity, fragment);
    }

    public GrowingIO trackWebView(View view) {
        view.setTag(AbstractGrowingIO.GROWING_TRACK_WEB_VIEW, Boolean.TRUE);
        return this;
    }

    public GrowingIO ignoreFragment(Activity activity, androidx.fragment.app.Fragment fragment) {
        return ignoreFragmentInternal(activity, fragment);
    }

    @TargetApi(11)
    public GrowingIO setPageName(Fragment fragment, String str) {
        return setPageNameInternal(fragment, str);
    }

    public GrowingIO setPageVariable(Activity activity, String str, String str2) {
        return setPageVariableInternal(activity, "activity", str, str2);
    }

    public GrowingIO setPageVariableX(androidx.fragment.app.Fragment fragment, String str, String str2) {
        return setPageVariableInternal(fragment, "fragment", str, str2);
    }

    public GrowingIO trackFragment(Activity activity, androidx.fragment.app.Fragment fragment) {
        return trackFragmentInternal(activity, fragment);
    }

    public GrowingIO trackFragmentX(Activity activity, ViewPager viewPager, View view, String str) {
        return trackFragmentViewPagerInternal(activity, viewPager, view, str);
    }

    public GrowingIO setPageName(androidx.fragment.app.Fragment fragment, String str) {
        return setPageNameInternal(fragment, str);
    }

    public GrowingIO setPageVariable(Activity activity, String str, boolean z) {
        return setPageVariableInternal(activity, "activity", str, z);
    }

    public GrowingIO setPageVariableX(androidx.fragment.app.Fragment fragment, String str, boolean z) {
        return setPageVariableInternal(fragment, "fragment", str, z);
    }

    public GrowingIO trackFragment(Activity activity, ViewPager viewPager, View view, String str) {
        return trackFragmentViewPagerInternal(activity, viewPager, view, str);
    }

    private GrowingIO setPageVariableInternal(final Object obj, String str, final String str2, final String str3) {
        if (obj == null) {
            Log.e("GrowingIO", ErrorLog.argumentBeNull(str));
            return this;
        }
        if (!this.mArgumentChecker.isIllegalEventName(str2) && (str3 == null || !this.mArgumentChecker.isIllegalValue(str3))) {
            AbstractGrowingIO.runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.GrowingIO.13
                @Override // java.lang.Runnable
                public void run() {
                    AbstractGrowingIO.getAPPState().setPageVariable(obj, str2, str3);
                }
            });
        }
        return this;
    }

    public GrowingIO setPageVariable(Activity activity, String str, Number number) {
        return setPageVariableInternal(activity, "activity", str, number);
    }

    public GrowingIO setPageVariableX(androidx.fragment.app.Fragment fragment, String str, Number number) {
        return setPageVariableInternal(fragment, "fragment", str, number);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GrowingIO() {
    }

    public GrowingIO setPageVariable(Fragment fragment, JSONObject jSONObject) {
        return setPageVariableInternal(fragment, "fragment", jSONObject);
    }

    public GrowingIO setPageVariable(Fragment fragment, String str, String str2) {
        return setPageVariableInternal(fragment, "fragment", str, str2);
    }

    private GrowingIO setPageVariableInternal(final Object obj, String str, final String str2, final boolean z) {
        if (obj == null) {
            Log.e("GrowingIO", ErrorLog.argumentBeNull(str));
            return this;
        }
        if (!this.mArgumentChecker.isIllegalEventName(str2)) {
            AbstractGrowingIO.runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.GrowingIO.14
                @Override // java.lang.Runnable
                public void run() {
                    AbstractGrowingIO.getAPPState().setPageVariable(obj, str2, Boolean.valueOf(z));
                }
            });
        }
        return this;
    }

    public GrowingIO setPageVariable(Fragment fragment, String str, boolean z) {
        return setPageVariableInternal(fragment, "fragment", str, z);
    }

    public GrowingIO setPageVariable(Fragment fragment, String str, Number number) {
        return setPageVariableInternal(fragment, "fragment", str, number);
    }

    public GrowingIO setPageVariable(androidx.fragment.app.Fragment fragment, JSONObject jSONObject) {
        return setPageVariableInternal(fragment, "fragment", jSONObject);
    }

    private GrowingIO setPageVariableInternal(final Object obj, String str, final String str2, final Number number) {
        if (obj == null) {
            Log.e("GrowingIO", ErrorLog.argumentBeNull(str));
        } else if (!this.mArgumentChecker.isIllegalEventName(str2) && !this.mArgumentChecker.isIllegalValue(number)) {
            AbstractGrowingIO.runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.GrowingIO.15
                @Override // java.lang.Runnable
                public void run() {
                    AbstractGrowingIO.getAPPState().setPageVariable(obj, str2, number);
                }
            });
        }
        return this;
    }

    public GrowingIO setPageVariable(androidx.fragment.app.Fragment fragment, String str, String str2) {
        return setPageVariableInternal(fragment, "fragment", str, str2);
    }

    public GrowingIO setPageVariable(androidx.fragment.app.Fragment fragment, String str, boolean z) {
        return setPageVariableInternal(fragment, "fragment", str, z);
    }

    public GrowingIO setPageVariable(androidx.fragment.app.Fragment fragment, String str, Number number) {
        return setPageVariableInternal(fragment, "fragment", str, number);
    }
}
