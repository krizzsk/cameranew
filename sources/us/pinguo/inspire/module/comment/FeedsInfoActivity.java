package us.pinguo.inspire.module.comment;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import us.pinguo.foundation.base.InspireBaseActivity;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.feeds.model.FeedsList;
import us.pinguo.ui.R;
/* loaded from: classes9.dex */
public class FeedsInfoActivity extends InspireBaseActivity {
    private FeedsInfoFragment mFeedsInfoFragment;

    @Override // android.app.Activity
    public void finish() {
        Intent intent = new Intent();
        InspireWork curWork = FeedsList.getCurWork();
        FeedsList.setFeedsList(null, null);
        FeedsList.tempBitmaps = null;
        intent.putExtra("curWork", curWork);
        setResult(-1, intent);
        super.finish();
    }

    @Override // android.app.Activity
    public void finishAfterTransition() {
        Intent intent = new Intent();
        FeedsInfoFragment feedsInfoFragment = this.mFeedsInfoFragment;
        if (feedsInfoFragment != null) {
            feedsInfoFragment.onFinish(intent);
        }
        setResult(-1, intent);
        super.finishAfterTransition();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireRedirectActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 != 1005 && i2 != 205) {
            super.onActivityResult(i2, i3, intent);
            us.pinguo.librouter.c.d.b().getPayInterface().b(i2, i3, intent);
        } else if (i3 == -1) {
            this.mFeedsInfoFragment.onActivityResult(i2, i3, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        FeedsInfoFragment feedsInfoFragment = this.mFeedsInfoFragment;
        if (feedsInfoFragment == null || !feedsInfoFragment.onBackPressed()) {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.InspireRedirectActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mEnableBaseNotch = false;
        us.pinguo.inspire.util.transition.h hVar = us.pinguo.inspire.util.transition.h.a;
        hVar.d(this);
        if (!hVar.e()) {
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
        if (Build.VERSION.SDK_INT < 26) {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
        hVar.l(this);
        setContentView(vStudio.Android.Camera360.R.layout.inspire_comment_layout);
        FeedsInfoFragment feedsInfoFragment = (FeedsInfoFragment) getSupportFragmentManager().findFragmentByTag("infoFragment");
        this.mFeedsInfoFragment = feedsInfoFragment;
        if (feedsInfoFragment == null) {
            FeedsInfoFragment feedsInfoFragment2 = new FeedsInfoFragment();
            this.mFeedsInfoFragment = feedsInfoFragment2;
            feedsInfoFragment2.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(vStudio.Android.Camera360.R.id.comment_container, this.mFeedsInfoFragment, "infoFragment").commit();
        }
        getWindow().setBackgroundDrawable(new ColorDrawable(-1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.SubscriptionActivity, us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CommentViewCache.clear();
    }
}
