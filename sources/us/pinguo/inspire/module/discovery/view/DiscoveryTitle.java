package us.pinguo.inspire.module.discovery.view;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import us.pinguo.foundation.R;
import us.pinguo.foundation.statistics.l;
import us.pinguo.inspire.module.contact.ContactSearchActivity;
/* loaded from: classes9.dex */
public class DiscoveryTitle implements us.pinguo.ui.widget.dialog.a {
    private Activity mActivity;
    private Toolbar mToolbar;

    private DiscoveryTitle(Toolbar toolbar, Activity activity) {
        this.mToolbar = toolbar;
        this.mActivity = activity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(Activity activity, Toolbar toolbar, View view) {
        activity.startActivity(new Intent(activity, ContactSearchActivity.class));
        l.onEvent(toolbar.getContext(), "Community_Discovery_Search_Click");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean b(Activity activity, Toolbar toolbar, MenuItem menuItem) {
        activity.startActivity(new Intent(activity, ContactSearchActivity.class));
        l.onEvent(toolbar.getContext(), "Community_Discovery_Search_Click");
        return true;
    }

    public static DiscoveryTitle init(Toolbar toolbar, Activity activity) {
        DiscoveryTitle discoveryTitle = new DiscoveryTitle(toolbar, activity);
        discoveryTitle.initTitle(toolbar, activity);
        return discoveryTitle;
    }

    protected void initTitle(final Toolbar toolbar, final Activity activity) {
        toolbar.setTitleTextColor(activity.getResources().getColor(R.color.light_main_title_text));
        toolbar.setTitleTextAppearance(activity, us.pinguo.user.R.style.ToolBar_TextSize);
        toolbar.setTitle(vStudio.Android.Camera360.R.string.home_inspire_title);
        toolbar.setNavigationIcon(vStudio.Android.Camera360.R.drawable.search);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.discovery.view.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DiscoveryTitle.a(activity, toolbar, view);
            }
        });
        toolbar.inflateMenu(vStudio.Android.Camera360.R.menu.find_friend_search_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() { // from class: us.pinguo.inspire.module.discovery.view.a
            @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return DiscoveryTitle.b(activity, toolbar, menuItem);
            }
        });
    }

    public void onDestroyView() {
    }

    @Override // us.pinguo.ui.widget.dialog.a
    public void onPause() {
    }

    @Override // us.pinguo.ui.widget.dialog.a
    public void onResume() {
    }

    public void onSelected() {
    }

    public void onUnSelected() {
    }

    public void onViewCreated() {
    }
}
