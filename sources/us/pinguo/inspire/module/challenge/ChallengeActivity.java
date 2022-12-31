package us.pinguo.inspire.module.challenge;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
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
/* compiled from: ChallengeActivity.kt */
/* loaded from: classes9.dex */
public final class ChallengeActivity extends InspireBaseActivity implements us.pinguo.inspire.util.transition.c {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private ChallengeTabFragment mChallengeFragment;
    private InspireWork reenterWork;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onActivityReenter$lambda-0  reason: not valid java name */
    public static final void m106onActivityReenter$lambda0(Object obj, int i2) {
        ((FeedsPhotoCell) obj).setSelectedInnerIndex(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onActivityResult$lambda-1  reason: not valid java name */
    public static final void m107onActivityResult$lambda1(ChallengeActivity this$0) {
        s.h(this$0, "this$0");
        ChallengeTabFragment challengeTabFragment = this$0.mChallengeFragment;
        if (challengeTabFragment == null) {
            return;
        }
        challengeTabFragment.handleSharePreprocessResult();
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
        ChallengeTabFragment challengeTabFragment = this.mChallengeFragment;
        View changedShareElementByWork = challengeTabFragment == null ? null : challengeTabFragment.getChangedShareElementByWork(inspireWork);
        this.reenterWork = null;
        return changedShareElementByWork;
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
        ChallengeTabFragment challengeTabFragment = this.mChallengeFragment;
        if (challengeTabFragment == null) {
            checkScrollTo = null;
        } else {
            InspireWork inspireWork3 = this.reenterWork;
            s.e(inspireWork3);
            checkScrollTo = challengeTabFragment.checkScrollTo(inspireWork3);
        }
        final Object tag = checkScrollTo != null ? checkScrollTo.getTag(R.id.tag_element_info) : null;
        hVar.l(this);
        if (tag instanceof FeedsPhotoCell) {
            hVar.t(this, checkScrollTo, new Runnable() { // from class: us.pinguo.inspire.module.challenge.b
                @Override // java.lang.Runnable
                public final void run() {
                    ChallengeActivity.m106onActivityReenter$lambda0(tag, intExtra);
                }
            });
        } else {
            us.pinguo.inspire.util.transition.h.u(hVar, this, checkScrollTo, null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireRedirectActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 != 205 && i2 != 1005) {
            super.onActivityResult(i2, i3, intent);
            us.pinguo.librouter.c.d.b().getPayInterface().b(i2, i3, intent);
        } else if (i3 == -1) {
            getWindow().getDecorView().post(new Runnable() { // from class: us.pinguo.inspire.module.challenge.a
                @Override // java.lang.Runnable
                public final void run() {
                    ChallengeActivity.m107onActivityResult$lambda1(ChallengeActivity.this);
                }
            });
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        ChallengeTabFragment challengeTabFragment = this.mChallengeFragment;
        boolean z = false;
        if (challengeTabFragment != null && challengeTabFragment.onBackPressed()) {
            z = true;
        }
        if (z) {
            return;
        }
        super.onBackPressed();
        us.pinguo.foundation.statistics.h.a.A0("challenge_task_list", "", "click_back");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.InspireRedirectActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mEnableBaseNotch = false;
        us.pinguo.inspire.util.transition.h hVar = us.pinguo.inspire.util.transition.h.a;
        hVar.d(this);
        super.onCreate(bundle);
        setContentView(R.layout.inspire_comment_layout);
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("challengeFragment");
        ChallengeTabFragment challengeTabFragment = findFragmentByTag instanceof ChallengeTabFragment ? (ChallengeTabFragment) findFragmentByTag : null;
        this.mChallengeFragment = challengeTabFragment;
        if (challengeTabFragment == null) {
            ChallengeTabFragment challengeTabFragment2 = new ChallengeTabFragment();
            this.mChallengeFragment = challengeTabFragment2;
            s.e(challengeTabFragment2);
            challengeTabFragment2.setArguments(getIntent().getExtras());
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            ChallengeTabFragment challengeTabFragment3 = this.mChallengeFragment;
            s.e(challengeTabFragment3);
            beginTransaction.add(R.id.comment_container, challengeTabFragment3, "challengeFragment").commit();
        }
        hVar.n(this, this);
        getWindow().setBackgroundDrawable(new ColorDrawable(-1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireRedirectActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        ChallengeTabFragment challengeTabFragment = this.mChallengeFragment;
        if (challengeTabFragment == null) {
            return;
        }
        challengeTabFragment.onNewIntent(intent);
    }
}
