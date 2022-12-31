package us.pinguo.inspire.module.MissionDetail;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import us.pinguo.foundation.base.BaseActivity;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class NewTaskDetailActivity extends BaseActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.new_task_detail_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_res_0x7d060229);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.MissionDetail.NewTaskDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewTaskDetailActivity.this.onBackPressed();
            }
        });
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        collapsingToolbarLayout.setTitle("CollapsingToolbarLayout");
        collapsingToolbarLayout.setExpandedTitleColor(-1);
        collapsingToolbarLayout.setCollapsedTitleTextColor(-16711936);
    }
}
