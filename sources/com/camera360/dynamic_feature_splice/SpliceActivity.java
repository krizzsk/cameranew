package com.camera360.dynamic_feature_splice;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import java.util.LinkedHashMap;
import us.pinguo.foundation.base.BaseActivity;
/* compiled from: SpliceActivity.kt */
/* loaded from: classes8.dex */
public final class SpliceActivity extends BaseActivity implements l1 {
    private SpliceEditFragment a;
    private SpliceResultFragment b;

    public SpliceActivity() {
        new LinkedHashMap();
    }

    private final SpliceResultFragment q0() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        kotlin.jvm.internal.s.g(supportFragmentManager, "supportFragmentManager");
        return (SpliceResultFragment) supportFragmentManager.findFragmentByTag("splice_result");
    }

    private final void s0() {
        us.pinguo.foundation.statistics.f.f("splice_page");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        kotlin.jvm.internal.s.g(supportFragmentManager, "supportFragmentManager");
        SpliceResultFragment spliceResultFragment = (SpliceResultFragment) supportFragmentManager.findFragmentByTag("splice_result");
        if (spliceResultFragment != null) {
            supportFragmentManager.beginTransaction().remove(spliceResultFragment).commitAllowingStateLoss();
        }
    }

    private final SpliceResultFragment t0(SpliceResult spliceResult) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        kotlin.jvm.internal.s.g(supportFragmentManager, "supportFragmentManager");
        SpliceResultFragment spliceResultFragment = (SpliceResultFragment) supportFragmentManager.findFragmentByTag("splice_result");
        if (spliceResultFragment == null) {
            spliceResultFragment = new SpliceResultFragment();
            supportFragmentManager.beginTransaction().setCustomAnimations(vStudio.Android.Camera360.R.anim.fragment_aplha_in, vStudio.Android.Camera360.R.anim.fragment_alpha_out).add(vStudio.Android.Camera360.R.id.activity_splice_root, spliceResultFragment, "splice_result").commitAllowingStateLoss();
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("arg_result", spliceResult);
        spliceResultFragment.setArguments(bundle);
        us.pinguo.foundation.statistics.f.e("splice_page", true);
        return spliceResultFragment;
    }

    private final SpliceEditFragment u0() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        kotlin.jvm.internal.s.g(supportFragmentManager, "supportFragmentManager");
        SpliceEditFragment spliceEditFragment = (SpliceEditFragment) supportFragmentManager.findFragmentByTag("splice_edit");
        if (spliceEditFragment == null) {
            SpliceEditFragment spliceEditFragment2 = new SpliceEditFragment();
            supportFragmentManager.beginTransaction().add(vStudio.Android.Camera360.R.id.activity_splice_root, spliceEditFragment2, "splice_edit").commitAllowingStateLoss();
            return spliceEditFragment2;
        }
        return spliceEditFragment;
    }

    @Override // com.camera360.dynamic_feature_splice.l1
    public void F(SpliceResult result) {
        kotlin.jvm.internal.s.h(result, "result");
        this.b = t0(result);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if ((i2 == 205 || i2 == 1005) && i3 == -1) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            kotlin.jvm.internal.s.g(supportFragmentManager, "supportFragmentManager");
            SpliceResultFragment spliceResultFragment = (SpliceResultFragment) supportFragmentManager.findFragmentByTag("splice_result");
            if (spliceResultFragment == null) {
                return;
            }
            spliceResultFragment.onActivityResult(i2, i3, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        SpliceResultFragment spliceResultFragment = this.b;
        boolean z = false;
        if (spliceResultFragment != null && spliceResultFragment.onBackPressed()) {
            z = true;
        }
        if (z) {
            return;
        }
        if (this.b != null) {
            s0();
            this.b = null;
            return;
        }
        SpliceEditFragment spliceEditFragment = this.a;
        if (spliceEditFragment == null) {
            kotlin.jvm.internal.s.z("editFragment");
            throw null;
        } else if (spliceEditFragment.onBackPressed()) {
        } else {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        us.pinguo.picker.image.g.a.h(false);
        super.onCreate(bundle);
        setContentView(vStudio.Android.Camera360.R.layout.activity_splice);
        SpliceEditFragment u0 = u0();
        this.a = u0;
        if (u0 != null) {
            u0.y1(this);
            this.b = q0();
            return;
        }
        kotlin.jvm.internal.s.z("editFragment");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        us.pinguo.picker.image.g.a.h(true);
        SpliceEditFragment spliceEditFragment = this.a;
        if (spliceEditFragment != null) {
            spliceEditFragment.y1(null);
            super.onDestroy();
            return;
        }
        kotlin.jvm.internal.s.z("editFragment");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        us.pinguo.foundation.statistics.f.e("splice_page", true);
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        us.pinguo.foundation.statistics.f.f("splice_page");
    }

    public final void r0() {
        s0();
    }
}
