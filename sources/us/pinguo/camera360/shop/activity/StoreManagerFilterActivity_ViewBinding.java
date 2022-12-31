package us.pinguo.camera360.shop.activity;

import android.view.View;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.pinguo.camera360.lib.camera.view.FreshGuideView;
import com.pinguo.camera360.ui.TitleBarLayout;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class StoreManagerFilterActivity_ViewBinding implements Unbinder {
    @UiThread
    public StoreManagerFilterActivity_ViewBinding(StoreManagerFilterActivity storeManagerFilterActivity, View view) {
        storeManagerFilterActivity.mTitleBarLayout = (TitleBarLayout) butterknife.internal.a.c(view, R.id.title_bar_layout_res_0x7f090781, "field 'mTitleBarLayout'", TitleBarLayout.class);
        storeManagerFilterActivity.mErrorLay = butterknife.internal.a.b(view, R.id.store_manager_error_lay, "field 'mErrorLay'");
        storeManagerFilterActivity.mGuideView = (FreshGuideView) butterknife.internal.a.c(view, R.id.store_fresh_guide_view, "field 'mGuideView'", FreshGuideView.class);
    }
}
