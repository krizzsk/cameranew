package com.growingio.android.sdk.autoburry;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.growingio.android.sdk.autoburry.SuperFragment;
import com.growingio.android.sdk.autoburry.page.GrowingIOPageIgnore;
import com.growingio.android.sdk.autoburry.page.PageObserver;
import com.growingio.android.sdk.base.event.ActivityLifecycleEvent;
import com.growingio.android.sdk.collection.AbstractGrowingIO;
import com.growingio.android.sdk.collection.Constants;
import com.growingio.android.sdk.collection.CoreAppState;
import com.growingio.android.sdk.collection.ErrorLog;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.utils.ClassExistHelper;
import com.growingio.android.sdk.utils.EncryptionUtil;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.NetworkUtil;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.utils.ViewHelper;
import com.growingio.android.sdk.utils.WeakSet;
import com.growingio.cp_annotation.Subscribe;
import com.growingio.eventcenter.bus.SubscriberMethod;
import com.growingio.eventcenter.bus.ThreadMode;
import com.growingio.eventcenter.bus.meta.Subscriber;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.WeakHashMap;
@TargetApi(11)
/* loaded from: classes2.dex */
public class AutoBuryAppState implements Subscriber {
    private static final String TAG = "GIO.AutoAppState";
    AutoBuryMessageProcessor autoBuryMessageProcessor;
    private GConfig mConfig;
    private CoreAppState mCoreAppState;
    private SuperFragment mForegroundFragment;
    WeakHashMap<Activity, WeakSet<Object>> mActivitiesWithFragments = new WeakHashMap<>();
    WeakHashMap<Activity, List<Integer>> mActivitiesWithIgnoredFragments = new WeakHashMap<>(2);
    WeakHashMap<Activity, List<Integer>> mActivitiesWithCustomViewPager = new WeakHashMap<>(2);
    WeakHashMap<Activity, String> mActivitiesManualPageNames = new WeakHashMap<>(0);
    WeakSet<Activity> mTrackAllFragmentSpecialActivities = new WeakSet<>();
    private WeakHashMap<Object, String> mPageAlias = new WeakHashMap<>(0);
    private List<WeakReference<EditText>> trackingEditTexts = new LinkedList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.growingio.android.sdk.autoburry.AutoBuryAppState$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$growingio$android$sdk$base$event$ActivityLifecycleEvent$EVENT_TYPE;

        static {
            int[] iArr = new int[ActivityLifecycleEvent.EVENT_TYPE.values().length];
            $SwitchMap$com$growingio$android$sdk$base$event$ActivityLifecycleEvent$EVENT_TYPE = iArr;
            try {
                iArr[ActivityLifecycleEvent.EVENT_TYPE.ON_CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$base$event$ActivityLifecycleEvent$EVENT_TYPE[ActivityLifecycleEvent.EVENT_TYPE.ON_NEW_INTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$base$event$ActivityLifecycleEvent$EVENT_TYPE[ActivityLifecycleEvent.EVENT_TYPE.ON_RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$base$event$ActivityLifecycleEvent$EVENT_TYPE[ActivityLifecycleEvent.EVENT_TYPE.ON_PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$base$event$ActivityLifecycleEvent$EVENT_TYPE[ActivityLifecycleEvent.EVENT_TYPE.ON_STOPPED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$base$event$ActivityLifecycleEvent$EVENT_TYPE[ActivityLifecycleEvent.EVENT_TYPE.ON_DESTROYED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoBuryAppState(CoreAppState coreAppState, GConfig gConfig) {
        this.mCoreAppState = coreAppState;
        this.mConfig = gConfig;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    private static String getEndcodedName(Class<?> cls) {
        try {
            Field declaredField = cls.getDeclaredField(Constants.SIGN_FIELD_NAME);
            declaredField.setAccessible(true);
            String AESDecode = EncryptionUtil.AESDecode((String) declaredField.get(null));
            if (!TextUtils.isEmpty(AESDecode)) {
                cls = Constants.SIGN_FLAG + AESDecode;
            } else {
                cls = Util.getSimpleClassName(cls);
            }
            return cls;
        } catch (Exception unused) {
            return Util.getSimpleClassName(cls);
        }
    }

    private void ignoreFragmentWithRef(Activity activity, Object obj) {
        List<Integer> list = this.mActivitiesWithIgnoredFragments.get(activity);
        if (list == null) {
            list = new ArrayList<>(1);
            this.mActivitiesWithIgnoredFragments.put(activity, list);
        }
        list.add(Integer.valueOf(obj.hashCode()));
        WeakSet<Object> weakSet = this.mActivitiesWithFragments.get(activity);
        if (weakSet != null && weakSet.contains(obj)) {
            weakSet.remove(obj);
        }
        SuperFragment superFragment = this.mForegroundFragment;
        if (superFragment != null && superFragment.getFragment() == obj) {
            this.mForegroundFragment = null;
        }
        PageObserver.scheduleViewPageDetectByFragmentChange(activity);
    }

    private boolean isBannerView(View view) {
        if (view == null) {
            return false;
        }
        while (view != null) {
            if (view.getTag(AbstractGrowingIO.GROWING_BANNER_KEY) != null) {
                return true;
            }
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return false;
    }

    private boolean isIgnoredFragment(Activity activity, int i2) {
        List<Integer> list = this.mActivitiesWithIgnoredFragments.get(activity);
        return list != null && list.contains(Integer.valueOf(i2));
    }

    private void trackFragmentWithRef(Activity activity, Object obj) {
        WeakSet<Object> weakSet = this.mActivitiesWithFragments.get(activity);
        if (weakSet == null) {
            weakSet = new WeakSet<>();
            this.mActivitiesWithFragments.put(activity, weakSet);
        }
        weakSet.add(obj);
        List<Integer> list = this.mActivitiesWithIgnoredFragments.get(activity);
        if (list != null) {
            int hashCode = obj.hashCode();
            if (list.contains(Integer.valueOf(hashCode))) {
                list.remove(Integer.valueOf(hashCode));
            }
        }
        PageObserver.scheduleViewPageDetectByFragmentChange(activity);
    }

    public void clearForegroundFragment(Activity activity) {
        SuperFragment superFragment = this.mForegroundFragment;
        if (superFragment == null || !superFragment.isBelongActivity(activity)) {
            return;
        }
        this.mForegroundFragment = null;
    }

    @Override // com.growingio.eventcenter.bus.meta.Subscriber
    public void do$Action(String str, Object obj) {
        if (str.equals("#onActivityLifeCycleChange(com.growingio.android.sdk.base.event.ActivityLifecycleEvent")) {
            onActivityLifeCycleChange((ActivityLifecycleEvent) obj);
        } else {
            System.out.println("No such method to delegate");
        }
    }

    @Override // com.growingio.eventcenter.bus.meta.Subscriber
    public SubscriberMethod[] get$SubscriberMethods() {
        return new SubscriberMethod[]{new SubscriberMethod("onActivityLifeCycleChange", ActivityLifecycleEvent.class, "#onActivityLifeCycleChange(com.growingio.android.sdk.base.event.ActivityLifecycleEvent", ThreadMode.POSTING, 0, false)};
    }

    public Object getCurrentPage() {
        SuperFragment superFragment;
        Activity resumedActivity = this.mCoreAppState.getResumedActivity();
        return (resumedActivity == null || (superFragment = this.mForegroundFragment) == null) ? resumedActivity : superFragment.getFragment();
    }

    public Object getForegroundFragment() {
        SuperFragment superFragment = this.mForegroundFragment;
        if (superFragment == null) {
            return null;
        }
        return superFragment.getFragment();
    }

    public Object getFragmentByView(Activity activity, View view) {
        WeakSet<Object> weakSet = this.mActivitiesWithFragments.get(activity);
        if (weakSet == null) {
            return null;
        }
        Iterator<Object> it = weakSet.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next != null) {
                if (next instanceof Fragment) {
                    if (((Fragment) next).getView() == view) {
                        return next;
                    }
                } else if (ClassExistHelper.instanceOfAndroidXFragment(next)) {
                    if (((androidx.fragment.app.Fragment) next).getView() == view) {
                        return next;
                    }
                } else if (ClassExistHelper.instanceOfSupportFragment(next) && ((androidx.fragment.app.Fragment) next).getView() == view) {
                    return next;
                }
            }
        }
        return null;
    }

    public String getPageName() {
        Activity resumedActivity = this.mCoreAppState.getResumedActivity();
        if (resumedActivity == null) {
            return null;
        }
        return getPageName(resumedActivity);
    }

    public void ignoreFragment(Activity activity, Object obj) {
        ignoreFragmentWithRef(activity, obj);
    }

    public boolean isFragmentView(Activity activity, View view) {
        WeakSet<Object> weakSet = this.mActivitiesWithFragments.get(activity);
        if (weakSet != null && !weakSet.isEmpty()) {
            Iterator<Object> it = weakSet.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next != null) {
                    if (next instanceof Fragment) {
                        if (((Fragment) next).getView() == view) {
                            return true;
                        }
                    } else if (ClassExistHelper.instanceOfAndroidXFragment(next)) {
                        if (((androidx.fragment.app.Fragment) next).getView() == view) {
                            return true;
                        }
                    } else if (ClassExistHelper.instanceOfSupportFragment(next) && ((androidx.fragment.app.Fragment) next).getView() == view) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isIgnoredActivity(Activity activity) {
        if (activity.getClass().getAnnotation(GrowingIOPageIgnore.class) != null) {
            Log.d(TAG, activity.getClass().getName() + " is ignore ...");
            return true;
        }
        return false;
    }

    public boolean isPageManualModel(Activity activity) {
        return this.mActivitiesManualPageNames.containsKey(activity);
    }

    public boolean isTrackCustomFragment(Activity activity, ViewGroup viewGroup) {
        List<Integer> list = this.mActivitiesWithCustomViewPager.get(activity);
        return list != null && list.contains(Integer.valueOf(viewGroup.hashCode()));
    }

    public void manualPage(Activity activity, String str) {
        String str2 = this.mActivitiesManualPageNames.get(activity);
        if (str2 != null && str2.equals(str)) {
            Log.e(TAG, "manualPage, but oldPageName.equal(pageName) return");
            return;
        }
        this.mActivitiesWithFragments.remove(activity);
        this.mActivitiesWithIgnoredFragments.remove(activity);
        this.mActivitiesWithCustomViewPager.remove(activity);
        this.mActivitiesManualPageNames.put(activity, str);
        if (this.mCoreAppState.getResumedActivity() != null) {
            this.autoBuryMessageProcessor.savePageForManualModel(activity);
        }
    }

    @Subscribe
    public void onActivityLifeCycleChange(ActivityLifecycleEvent activityLifecycleEvent) {
        Activity activity = activityLifecycleEvent.getActivity();
        int i2 = AnonymousClass1.$SwitchMap$com$growingio$android$sdk$base$event$ActivityLifecycleEvent$EVENT_TYPE[activityLifecycleEvent.event_type.ordinal()];
        if (i2 == 1) {
            if (activity == null) {
                LogUtil.d(TAG, "onActivityCreated, but activity not found, return");
            } else {
                LogUtil.d(TAG, "onActivityCreated ", activity);
            }
        } else if (i2 == 3) {
            if (activity == null) {
                LogUtil.d(TAG, "onActivityResumed, but activity not found, return");
                return;
            }
            LogUtil.d(TAG, "onActivityResumed ", activity);
            this.mForegroundFragment = null;
        } else if (i2 == 4) {
            if (activity == null) {
                LogUtil.d(TAG, "onActivityPaused, but activity not found, return");
                return;
            }
            LogUtil.d(TAG, "onActivityPaused ", activity);
            View findFocus = activity.getWindow().getDecorView().findFocus();
            if (findFocus instanceof EditText) {
                LogUtil.d(TAG, "onActivityPaused, and focus view is EditText");
                ViewHelper.changeOn(findFocus);
            }
        } else if (i2 == 5) {
            if (activity == null) {
                LogUtil.d(TAG, "onActivityStopped, but activity not found, return");
            } else {
                LogUtil.d(TAG, "onActivityStopped ", activity);
            }
        } else if (i2 != 6) {
        } else {
            if (activity == null) {
                LogUtil.d(TAG, "onActivityDestroyed, but activity not found, return");
                return;
            }
            LogUtil.d(TAG, "onActivityDestroyed ", activity);
            this.mActivitiesWithFragments.remove(activity);
            this.mActivitiesWithIgnoredFragments.remove(activity);
        }
    }

    public void onPageFragmentInvisible(SuperFragment superFragment) {
        if (superFragment.equals(this.mForegroundFragment)) {
            this.mForegroundFragment = null;
        }
    }

    public void onPageFragmentVisible(SuperFragment superFragment) {
        if (shouldTrackFragment(superFragment)) {
            this.mForegroundFragment = superFragment;
            this.autoBuryMessageProcessor.onFragmentPage(superFragment);
        }
    }

    public void setPageAlias(Object obj, String str) {
        this.mPageAlias.put(obj, str);
    }

    public void setTrackAllFragment(Activity activity, boolean z) {
        if (this.mConfig.shouldTrackAllFragment() == z) {
            Log.e(TAG, ErrorLog.TRACK_FRAGMENT_ERROR);
        } else {
            this.mTrackAllFragmentSpecialActivities.add(activity);
        }
    }

    public boolean shouldTrackAllFragment(@Nullable Activity activity) {
        boolean shouldTrackAllFragment = this.mConfig.shouldTrackAllFragment();
        if (activity == null) {
            return shouldTrackAllFragment;
        }
        if (shouldTrackAllFragment) {
            return !this.mTrackAllFragmentSpecialActivities.contains(activity);
        }
        return this.mTrackAllFragmentSpecialActivities.contains(activity);
    }

    public boolean shouldTrackFragment(@NonNull SuperFragment superFragment) {
        Activity resumedActivity = this.mCoreAppState.getResumedActivity();
        return resumedActivity != null && shouldTrackFragment(resumedActivity, superFragment);
    }

    public void silentTrackEditText(EditText editText) {
        Iterator<WeakReference<EditText>> it = this.trackingEditTexts.iterator();
        while (it.hasNext()) {
            EditText editText2 = it.next().get();
            if (editText2 == null) {
                it.remove();
                continue;
            }
            if (editText2 == editText) {
                return;
            }
        }
        this.trackingEditTexts.add(new WeakReference<>(editText));
    }

    public void trackCustomFragment(Activity activity, View view, View view2, String str) {
        List<Integer> list = this.mActivitiesWithCustomViewPager.get(activity);
        if (list == null) {
            list = new ArrayList<>(1);
            this.mActivitiesWithCustomViewPager.put(activity, list);
        }
        list.add(Integer.valueOf(view.hashCode()));
        setPageAlias(view2, str);
    }

    public void trackFragment(Activity activity, Object obj) {
        trackFragmentWithRef(activity, obj);
    }

    public void trackFragmentWithFilter(Object obj) {
        Activity activityFromFragment = SuperFragment.getActivityFromFragment(obj);
        if (activityFromFragment == null) {
            activityFromFragment = this.mCoreAppState.getForegroundActivity();
        }
        if (!shouldTrackAllFragment(activityFromFragment)) {
            LogUtil.d(TAG, "trackFragmentWithFilter, and not trackAllFragment. return ...");
        } else if (activityFromFragment != null && obj != null) {
            if (isPageManualModel(activityFromFragment)) {
                LogUtil.d(TAG, "trackFragmentWithFilter, current Activity is manual page model, return...");
            } else if (isIgnoredFragment(activityFromFragment, obj.hashCode())) {
                LogUtil.d(TAG, "trackFragmentWithFilter, and ignored fragment. return");
            } else {
                WeakSet<Object> weakSet = this.mActivitiesWithFragments.get(activityFromFragment);
                if (weakSet != null && weakSet.contains(obj)) {
                    LogUtil.d(TAG, "trackFragmentWithFilter, and contained, return");
                } else if (obj instanceof Fragment) {
                    trackFragment(activityFromFragment, obj);
                } else if (ClassExistHelper.instanceOfAndroidXFragment(obj)) {
                    trackFragment(activityFromFragment, obj);
                } else if (ClassExistHelper.instanceOfSupportFragment(obj)) {
                    trackFragment(activityFromFragment, obj);
                } else {
                    LogUtil.d(TAG, "trackFragmentWithFilter, and unknown type");
                }
            }
        } else {
            LogUtil.d(TAG, "trackFragmentWithFilter, and activity is null. return ...");
        }
    }

    public String getPageName(Activity activity) {
        if (activity == null) {
            return NetworkUtil.NETWORK_UNKNOWN;
        }
        String str = this.mActivitiesManualPageNames.get(activity);
        if (str != null) {
            return str;
        }
        SuperFragment superFragment = this.mForegroundFragment;
        if (superFragment != null) {
            Object fragment = superFragment.getFragment();
            if (this.mForegroundFragment.isBelongActivity(activity) && fragment != null) {
                String str2 = this.mPageAlias.get(fragment);
                if (str2 != null) {
                    LogUtil.d(TAG, "GET className from userSet :" + str2);
                    return str2;
                }
                return getEndcodedName(fragment.getClass());
            }
        }
        String str3 = this.mPageAlias.get(activity);
        return str3 != null ? str3 : getEndcodedName(activity.getClass());
    }

    @VisibleForTesting
    boolean shouldTrackFragment(Activity activity, SuperFragment superFragment) {
        Object fragment;
        if (!superFragment.isBelongActivity(activity) || (fragment = superFragment.getFragment()) == null || isIgnoredFragment(activity, fragment.hashCode()) || isBannerView(superFragment.getView())) {
            return false;
        }
        if (!shouldTrackAllFragment(activity) || (superFragment instanceof SuperFragment.ViewFragment)) {
            WeakSet<Object> weakSet = this.mActivitiesWithFragments.get(activity);
            return (weakSet != null && weakSet.contains(fragment)) || this.mPageAlias.get(fragment) != null;
        }
        return true;
    }

    public AutoBuryAppState() {
    }
}
