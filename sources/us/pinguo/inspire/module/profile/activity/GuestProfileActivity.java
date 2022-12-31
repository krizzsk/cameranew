package us.pinguo.inspire.module.profile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.foundation.base.InspireBaseActivity;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.feeds.cell.FeedsPhotoCell;
import us.pinguo.inspire.proxy.InspireStatistics;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class GuestProfileActivity extends InspireBaseActivity implements us.pinguo.inspire.util.transition.c {
    GuestProfileFragment fragment;
    InspireWork reenterWork;

    @Override // us.pinguo.inspire.util.transition.c
    public View getChangedShareElement() {
        InspireWork inspireWork = this.reenterWork;
        if (inspireWork == null) {
            return null;
        }
        View changedShareElement = this.fragment.getChangedShareElement(inspireWork);
        this.reenterWork = null;
        return changedShareElement;
    }

    @Override // android.app.Activity
    public void onActivityReenter(int i2, Intent intent) {
        super.onActivityReenter(i2, intent);
        if (intent == null || this.fragment == null) {
            return;
        }
        intent.setExtrasClassLoader(getClassLoader());
        String stringExtra = intent.getStringExtra("changedTaskId");
        String stringExtra2 = intent.getStringExtra("changedWorkId");
        final int intExtra = intent.getIntExtra("changedWorkInnerIndex", -1);
        us.pinguo.inspire.util.transition.h hVar = us.pinguo.inspire.util.transition.h.a;
        if (!hVar.e() || stringExtra2 == null) {
            return;
        }
        InspireWork inspireWork = new InspireWork();
        this.reenterWork = inspireWork;
        inspireWork.taskId = stringExtra;
        inspireWork.workId = stringExtra2;
        RecyclerView checkScrollTo = this.fragment.checkScrollTo(inspireWork, intExtra);
        final Object tag = checkScrollTo.getTag(R.id.tag_element_info);
        hVar.l(this);
        if (tag instanceof FeedsPhotoCell) {
            hVar.t(this, checkScrollTo, new Runnable() { // from class: us.pinguo.inspire.module.profile.activity.GuestProfileActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    ((FeedsPhotoCell) tag).setSelectedInnerIndex(intExtra);
                }
            });
        } else {
            hVar.s(this, checkScrollTo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.InspireRedirectActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.guest_profile_layout);
        InspireStatistics.enterGuestProfilePage();
        this.fragment = new GuestProfileFragment();
        this.fragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(R.id.guest_profile_container, this.fragment).commit();
        us.pinguo.inspire.util.transition.h.a.n(this, this);
    }
}
