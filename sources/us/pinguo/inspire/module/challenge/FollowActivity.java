package us.pinguo.inspire.module.challenge;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.base.InspireBaseActivity;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.feeds.cell.FeedsPhotoCell;
import vStudio.Android.Camera360.R;
/* compiled from: FollowActivity.kt */
/* loaded from: classes9.dex */
public final class FollowActivity extends InspireBaseActivity implements us.pinguo.inspire.util.transition.c {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private FollowFragment mFollowFragment;
    private InspireWork reenterWork;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onActivityReenter$lambda-0  reason: not valid java name */
    public static final void m108onActivityReenter$lambda0(Object obj, int i2) {
        ((FeedsPhotoCell) obj).setSelectedInnerIndex(i2);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // us.pinguo.inspire.util.transition.c
    public View getChangedShareElement() {
        InspireWork inspireWork = this.reenterWork;
        if (inspireWork == null) {
            return null;
        }
        FollowFragment followFragment = this.mFollowFragment;
        View changedShareElement = followFragment == null ? null : followFragment.getChangedShareElement(inspireWork);
        this.reenterWork = null;
        return changedShareElement;
    }

    @Override // android.app.Activity
    public void onActivityReenter(int i2, Intent intent) {
        RecyclerView checkScrollTo;
        super.onActivityReenter(i2, intent);
        if (intent != null) {
            intent.setExtrasClassLoader(getClassLoader());
        }
        String stringExtra = intent == null ? null : intent.getStringExtra("changedTaskId");
        String stringExtra2 = intent == null ? null : intent.getStringExtra("changedWorkId");
        final int intExtra = intent != null ? intent.getIntExtra("changedWorkInnerIndex", -1) : -1;
        us.pinguo.inspire.util.transition.h hVar = us.pinguo.inspire.util.transition.h.a;
        if (!hVar.e() || stringExtra2 == null) {
            return;
        }
        InspireWork inspireWork = new InspireWork();
        this.reenterWork = inspireWork;
        s.e(inspireWork);
        inspireWork.taskId = stringExtra;
        InspireWork inspireWork2 = this.reenterWork;
        s.e(inspireWork2);
        inspireWork2.workId = stringExtra2;
        FollowFragment followFragment = this.mFollowFragment;
        if (followFragment == null) {
            checkScrollTo = null;
        } else {
            InspireWork inspireWork3 = this.reenterWork;
            s.e(inspireWork3);
            checkScrollTo = followFragment.checkScrollTo(inspireWork3, intExtra);
        }
        final Object tag = checkScrollTo != null ? checkScrollTo.getTag(R.id.tag_element_info) : null;
        hVar.l(this);
        if (tag instanceof FeedsPhotoCell) {
            hVar.t(this, checkScrollTo, new Runnable() { // from class: us.pinguo.inspire.module.challenge.h
                @Override // java.lang.Runnable
                public final void run() {
                    FollowActivity.m108onActivityReenter$lambda0(tag, intExtra);
                }
            });
        } else {
            us.pinguo.inspire.util.transition.h.u(hVar, this, checkScrollTo, null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.InspireRedirectActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        us.pinguo.inspire.util.transition.h hVar = us.pinguo.inspire.util.transition.h.a;
        hVar.d(this);
        super.onCreate(bundle);
        FrameLayout frameLayout = new FrameLayout(this);
        int i2 = us.pinguo.ui.R.id.fragment_container;
        frameLayout.setId(i2);
        setContentView(frameLayout);
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("challengeFragment");
        FollowFragment followFragment = findFragmentByTag instanceof FollowFragment ? (FollowFragment) findFragmentByTag : null;
        this.mFollowFragment = followFragment;
        if (followFragment == null) {
            FollowFragment followFragment2 = new FollowFragment();
            this.mFollowFragment = followFragment2;
            s.e(followFragment2);
            followFragment2.setArguments(getIntent().getExtras());
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment fragment = this.mFollowFragment;
            s.e(fragment);
            beginTransaction.add(i2, fragment, "challengeFragment").commit();
        }
        hVar.n(this, this);
        getWindow().setBackgroundDrawable(new ColorDrawable(-1));
    }
}
