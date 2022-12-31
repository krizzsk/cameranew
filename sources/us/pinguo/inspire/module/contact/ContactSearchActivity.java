package us.pinguo.inspire.module.contact;

import android.os.Bundle;
import us.pinguo.foundation.base.BaseSplitActivity;
import us.pinguo.inspire.module.publish.InspireSelectAttentionListFragment;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class ContactSearchActivity extends BaseSplitActivity {
    SearchFragment searchFragment;

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        SearchFragment searchFragment = this.searchFragment;
        if (searchFragment != null) {
            searchFragment.onBackPressed();
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.search_activity_layout);
        boolean booleanExtra = getIntent().getBooleanExtra(InspireSelectAttentionListFragment.isFromFriend, false);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(InspireSelectAttentionListFragment.isFromFriend, booleanExtra);
        SearchFragment searchFragment = new SearchFragment();
        this.searchFragment = searchFragment;
        searchFragment.setArguments(bundle2);
        getSupportFragmentManager().beginTransaction().add(R.id.search_fragment_container, this.searchFragment).commit();
    }
}
