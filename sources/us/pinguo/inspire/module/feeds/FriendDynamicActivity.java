package us.pinguo.inspire.module.feeds;

import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import us.pinguo.foundation.base.BaseSplitActivity;
/* loaded from: classes9.dex */
public class FriendDynamicActivity extends BaseSplitActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setId(1);
        setContentView(frameLayout);
        Fragment friendDynamicFragment = new FriendDynamicFragment();
        friendDynamicFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(1, friendDynamicFragment).commit();
    }
}
