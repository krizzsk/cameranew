package us.pinguo.inspire.module.message.category.activity;

import android.os.Bundle;
import us.pinguo.inspire.module.message.category.fragment.InspireMessageFansFragment;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class InspireMessageFansActivity extends InspireMessageBaseActivity {
    @Override // us.pinguo.user.BaseLoginCheckActivity
    protected void onLoginCreate(Bundle bundle) {
        setContentView(R.layout.message_main_layout);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_message_main_layout, new InspireMessageFansFragment()).commit();
    }
}
