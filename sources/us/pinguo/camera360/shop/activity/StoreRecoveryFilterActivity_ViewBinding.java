package us.pinguo.camera360.shop.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.pinguo.camera360.ui.TitleBarLayout;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class StoreRecoveryFilterActivity_ViewBinding implements Unbinder {
    @UiThread
    public StoreRecoveryFilterActivity_ViewBinding(StoreRecoveryFilterActivity storeRecoveryFilterActivity, View view) {
        storeRecoveryFilterActivity.mTitleBarLayout = (TitleBarLayout) butterknife.internal.a.c(view, R.id.title_bar_layout_res_0x7f090781, "field 'mTitleBarLayout'", TitleBarLayout.class);
        storeRecoveryFilterActivity.mErrorLay = butterknife.internal.a.b(view, R.id.store_manager_error_lay, "field 'mErrorLay'");
        storeRecoveryFilterActivity.mErrorTxt = (TextView) butterknife.internal.a.c(view, R.id.store_manager_error_txt, "field 'mErrorTxt'", TextView.class);
    }
}
