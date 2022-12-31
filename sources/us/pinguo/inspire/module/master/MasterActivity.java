package us.pinguo.inspire.module.master;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import us.pinguo.foundation.base.InspireBaseActivity;
import us.pinguo.user.ui.view.CompatibleToolbar;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class MasterActivity extends InspireBaseActivity {
    private MasterFragment mMasterFragment;
    private CompatibleToolbar mToolbar;

    public static void launch(Activity activity) {
        activity.startActivity(new Intent(activity, MasterActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public /* synthetic */ void r0(View view) {
        finish();
    }

    public CompatibleToolbar getToolbar() {
        return this.mToolbar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.InspireRedirectActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_master);
        this.mToolbar = (CompatibleToolbar) findViewById(R.id.master_title);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        MasterFragment masterFragment = new MasterFragment();
        this.mMasterFragment = masterFragment;
        beginTransaction.replace(R.id.master_fragment_container, masterFragment);
        beginTransaction.commit();
    }

    public void updateMasterUI(int i2) {
        this.mMasterFragment.updateUiForMaster(Integer.valueOf(i2));
    }

    public void updateUIForMasterApplyFragment() {
        this.mToolbar.setNavigationIcon(us.pinguo.ui.R.drawable.navigation_back_black);
        this.mToolbar.setTitle(R.string.master_apply);
        this.mToolbar.setTitleTextAppearance(this, us.pinguo.user.R.style.ToolBar_TextSize);
        this.mToolbar.setOverflowIcon(getResources().getDrawable(R.drawable.toolbar_more_selector));
    }

    public void updateUIForMaterFragment() {
        this.mToolbar.setNavigationIcon(us.pinguo.ui.R.drawable.navigation_back_black);
        this.mToolbar.setTitle(R.string.master_intro);
        this.mToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.master.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MasterActivity.this.r0(view);
            }
        });
    }
}
