package us.pinguo.inspire.module.contact;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import us.pinguo.inspire.proxy.InspireStatistics;
import us.pinguo.user.BaseLoginCheckActivity;
import us.pinguo.user.ui.view.CompatibleToolbar;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class ContactActivity extends BaseLoginCheckActivity {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0 */
    public /* synthetic */ void u0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public /* synthetic */ boolean w0(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.find_friend_search) {
            startActivity(new Intent(this, ContactSearchActivity.class));
            return false;
        }
        return false;
    }

    @Override // us.pinguo.user.BaseLoginCheckActivity
    protected void onLoginCreate(Bundle bundle) {
        setContentView(R.layout.contact_layout);
        CompatibleToolbar compatibleToolbar = (CompatibleToolbar) findViewById(R.id.contact_toolbar);
        compatibleToolbar.setNavigationIcon(R.drawable.naivagation_back_black_profilemy);
        compatibleToolbar.setTitle(R.string.add_friend);
        compatibleToolbar.c(R.menu.find_friend_search_menu);
        compatibleToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.contact.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContactActivity.this.u0(view);
            }
        });
        compatibleToolbar.setTitleTextAppearance(this, us.pinguo.user.R.style.ToolBar_TextSize);
        compatibleToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() { // from class: us.pinguo.inspire.module.contact.g
            @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return ContactActivity.this.w0(menuItem);
            }
        });
        getSupportFragmentManager().beginTransaction().add(R.id.contact_container, FindFriendFragment.getInstance()).commit();
        InspireStatistics.enterAddFriendsPage();
    }

    @Override // us.pinguo.foundation.base.BaseActivity
    protected boolean useDefaultPageStatistic() {
        return false;
    }
}
