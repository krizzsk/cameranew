package us.pinguo.user.ui.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.Toolbar;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.user.R;
/* loaded from: classes6.dex */
public class CompatibleToolbar extends RelativeLayout {
    private Toolbar a;

    public CompatibleToolbar(Context context) {
        super(context);
        d();
    }

    @TargetApi(21)
    private void d() {
        if (isInEditMode()) {
            return;
        }
        this.a = (Toolbar) LayoutInflater.from(getContext()).inflate(R.layout.compatible_toolbar_layout, (ViewGroup) this, true).findViewById(R.id.compatible_toolbar);
    }

    public TextView a() {
        return (TextView) findViewById(R.id.tv_center_title);
    }

    public Toolbar b() {
        return this.a;
    }

    public void c(@MenuRes int i2) {
        this.a.inflateMenu(i2);
    }

    public void setCenterTitle(CharSequence charSequence) {
        TextView a = a();
        a.setVisibility(0);
        VdsAgent.onSetViewVisibility(a, 0);
        a.setText(charSequence);
    }

    public void setCollapsible(boolean z) {
        this.a.setCollapsible(z);
    }

    public void setLogo(@DrawableRes int i2) {
        this.a.setLogo(i2);
    }

    public void setNavigationContentDescription(@StringRes int i2) {
        this.a.setNavigationContentDescription(i2);
    }

    public void setNavigationIcon(@DrawableRes int i2) {
        this.a.setNavigationIcon(i2);
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        this.a.setNavigationOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(Toolbar.OnMenuItemClickListener onMenuItemClickListener) {
        this.a.setOnMenuItemClickListener(onMenuItemClickListener);
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        this.a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(@StyleRes int i2) {
        this.a.setPopupTheme(i2);
    }

    public void setSubtitle(int i2) {
        this.a.setSubtitle(i2);
    }

    public void setSubtitleTextAppearance(Context context, @StyleRes int i2) {
        this.a.setSubtitleTextAppearance(context, i2);
    }

    public void setTitle(CharSequence charSequence) {
        this.a.setTitle(charSequence);
    }

    public void setTitleTextAppearance(Context context, @StyleRes int i2) {
        this.a.setTitleTextAppearance(context, i2);
    }

    public void setTitleTextColor(@ColorInt int i2) {
        this.a.setTitleTextColor(i2);
    }

    public void setLogo(Drawable drawable) {
        this.a.setLogo(drawable);
    }

    public void setNavigationContentDescription(@Nullable CharSequence charSequence) {
        this.a.setNavigationContentDescription(charSequence);
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        this.a.setNavigationIcon(drawable);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.a.setSubtitle(charSequence);
    }

    public void setTitle(@StringRes int i2) {
        this.a.setTitle(i2);
    }

    public CompatibleToolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }

    public CompatibleToolbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        d();
    }
}
