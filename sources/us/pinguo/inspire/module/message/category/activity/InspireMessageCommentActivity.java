package us.pinguo.inspire.module.message.category.activity;

import android.os.Bundle;
import us.pinguo.inspire.module.message.category.fragment.InspireMessageCommentFragment;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class InspireMessageCommentActivity extends InspireMessageBaseActivity {
    @Override // us.pinguo.user.BaseLoginCheckActivity
    public void onLoginCreate(Bundle bundle) {
        setContentView(R.layout.message_main_layout);
        InspireMessageCommentFragment inspireMessageCommentFragment = new InspireMessageCommentFragment();
        inspireMessageCommentFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_message_main_layout, inspireMessageCommentFragment).commit();
    }

    @Override // us.pinguo.foundation.base.BaseActivity
    protected boolean useDefaultPageStatistic() {
        return false;
    }
}
