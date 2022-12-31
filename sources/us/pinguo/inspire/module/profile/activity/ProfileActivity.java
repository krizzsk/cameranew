package us.pinguo.inspire.module.profile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.foundation.base.InspireBaseActivity;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.feeds.cell.FeedsPhotoCell;
import us.pinguo.inspire.module.publishguide.PublishAnim2;
import us.pinguo.ui.R;
/* loaded from: classes9.dex */
public class ProfileActivity extends InspireBaseActivity implements us.pinguo.inspire.util.transition.c {
    MineProfileFragment fragment;
    private PublishAnim2 publishAnim = null;
    InspireWork reenterWork;

    private boolean hidePublishFragment(boolean z) {
        if (isPublishShown()) {
            if (z) {
                this.publishAnim.hide();
                return true;
            }
            this.publishAnim.hideNoAnim();
            return true;
        }
        return false;
    }

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

    public boolean isPublishShown() {
        return findViewById(R.id.portal_publish_container_parent).getVisibility() == 0;
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
        final Object tag = checkScrollTo.getTag(vStudio.Android.Camera360.R.id.tag_element_info);
        hVar.l(this);
        if (tag instanceof FeedsPhotoCell) {
            hVar.t(this, checkScrollTo, new Runnable() { // from class: us.pinguo.inspire.module.profile.activity.ProfileActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    ((FeedsPhotoCell) tag).setSelectedInnerIndex(intExtra);
                }
            });
        } else {
            hVar.s(this, checkScrollTo);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (hidePublishFragment(true)) {
            return;
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.InspireRedirectActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(vStudio.Android.Camera360.R.layout.profile_activity_layout);
        this.fragment = new MineProfileFragment();
        getSupportFragmentManager().beginTransaction().add(vStudio.Android.Camera360.R.id.profile_fragment_container, this.fragment).commit();
        us.pinguo.inspire.util.transition.h.a.n(this, this);
    }

    public void publish() {
        if (this.publishAnim == null) {
            this.publishAnim = new PublishAnim2(this, getSupportFragmentManager());
        }
        this.publishAnim.show();
    }
}
