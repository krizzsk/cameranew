package us.pinguo.inspire.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.foundation.utils.l;
import vStudio.Android.Camera360.R;
/* compiled from: SlipHeaderDefaultListener.java */
/* loaded from: classes9.dex */
public class d extends RecyclerView.OnScrollListener {
    private int mBackIconFromColor;
    private int mBackIconTargetColor;
    private View mHeaderBgView;
    private View mShadowView;
    private us.pinguo.inspire.cell.recycler.d mSlipHeaderRecyclerCell;
    private int mTitleFromColor;
    private int mTitleTargetColor;
    private Toolbar mToolbar;
    private int mToolbarFromColor = 0;
    private int mToolbarTargetColor;
    private int statusHeight;

    public d(Toolbar toolbar, us.pinguo.inspire.cell.recycler.d dVar) {
        this.mToolbar = toolbar;
        this.mSlipHeaderRecyclerCell = dVar;
        this.mToolbarTargetColor = toolbar.getContext().getResources().getColor(R.color.common_toolbar_color);
        this.mToolbar.setBackgroundColor(0);
        this.mBackIconTargetColor = ViewCompat.MEASURED_STATE_MASK;
        this.mBackIconFromColor = -1;
        this.mTitleFromColor = 0;
        this.mTitleTargetColor = this.mToolbar.getContext().getResources().getColor(us.pinguo.foundation.R.color.light_main_text);
        this.statusHeight = getStatusBarHeight(toolbar.getContext());
    }

    private int getStatusBarHeight(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public void handleCustomView(float f2, Toolbar toolbar) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        super.onScrollStateChanged(recyclerView, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    @TargetApi(21)
    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        super.onScrolled(recyclerView, i2, i3);
        View findViewById = recyclerView.findViewById(R.id.profile_cover);
        this.mHeaderBgView = findViewById;
        if (findViewById == null || recyclerView.getChildCount() == 0) {
            return;
        }
        if (this.mShadowView == null) {
            this.mShadowView = recyclerView.getRootView().findViewById(R.id.feeds_title_shadow);
        }
        int[] iArr = new int[2];
        this.mHeaderBgView.getLocationOnScreen(iArr);
        int abs = Math.abs(iArr[1]) - this.statusHeight;
        float height = abs / (this.mHeaderBgView.getHeight() * 0.5f);
        us.pinguo.common.log.a.m("FUCK", "bottom：" + abs + "height:" + this.mHeaderBgView.getHeight() + "rate:" + height + "statusHeight:" + this.statusHeight, new Object[0]);
        if (height > 1.0f) {
            height = 1.0f;
        }
        if (height < 0.0f) {
            height = 0.0f;
        }
        float f2 = ((GridLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition() <= 0 ? height : 1.0f;
        int b = l.b(this.mToolbarFromColor, this.mToolbarTargetColor, f2);
        this.mToolbar.setBackgroundColor(b);
        View view = this.mShadowView;
        if (view != null) {
            view.setAlpha(Color.alpha(b));
        }
        this.mToolbar.getNavigationIcon().setColorFilter(new PorterDuffColorFilter(l.b(this.mBackIconFromColor, this.mBackIconTargetColor, f2), PorterDuff.Mode.MULTIPLY));
        this.mToolbar.setTitleTextColor(l.b(this.mTitleFromColor, this.mTitleTargetColor, f2));
        this.mToolbar.setTitleTextAppearance(recyclerView.getContext(), us.pinguo.user.R.style.ToolBar_TextSize);
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(l.b(this.mBackIconFromColor, this.mTitleFromColor, f2), PorterDuff.Mode.MULTIPLY);
        if (this.mToolbar.getMenu().size() > 0 && this.mToolbar.getMenu().getItem(0).getIcon() != null) {
            this.mToolbar.getMenu().getItem(0).getIcon().setColorFilter(porterDuffColorFilter);
        }
        handleCustomView(f2, this.mToolbar);
    }
}
