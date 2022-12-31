package us.pinguo.inspire.module.profile;

import androidx.appcompat.widget.Toolbar;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class ProfileOnScrollListener extends us.pinguo.inspire.base.d {
    private boolean canPublish;
    private boolean isMyProfile;

    public ProfileOnScrollListener(Toolbar toolbar, us.pinguo.inspire.cell.recycler.d dVar) {
        super(toolbar, dVar);
        this.isMyProfile = false;
        this.canPublish = false;
    }

    @Override // us.pinguo.inspire.base.d
    public void handleCustomView(float f2, Toolbar toolbar) {
        super.handleCustomView(f2, toolbar);
        if (f2 < 0.5d) {
            if (toolbar.getMenu().size() == 0) {
                if (this.isMyProfile) {
                    toolbar.findViewById(R.id.profile_item_edit).setVisibility(0);
                    if (this.canPublish) {
                        toolbar.findViewById(R.id.btn_publish).setVisibility(0);
                    } else {
                        toolbar.findViewById(R.id.btn_publish).setVisibility(4);
                    }
                    toolbar.findViewById(R.id.header_toolbar_custom_view).setVisibility(8);
                    return;
                }
                toolbar.findViewById(R.id.profile_item_edit).setVisibility(8);
                toolbar.findViewById(R.id.btn_publish).setVisibility(8);
                toolbar.findViewById(R.id.header_toolbar_custom_view).setVisibility(0);
                return;
            }
            return;
        }
        if (toolbar.getMenu().size() > 0) {
            toolbar.getMenu().clear();
        }
        toolbar.findViewById(R.id.profile_item_edit).setVisibility(8);
        toolbar.findViewById(R.id.btn_publish).setVisibility(8);
        toolbar.findViewById(R.id.header_toolbar_custom_view).setVisibility(8);
    }

    public void setMyProfile(boolean z) {
        this.isMyProfile = z;
    }

    public ProfileOnScrollListener(Toolbar toolbar, us.pinguo.inspire.cell.recycler.d dVar, boolean z) {
        this(toolbar, dVar);
        this.canPublish = z;
    }
}
