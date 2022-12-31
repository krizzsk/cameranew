package us.pinguo.inspire.widget.photopager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import androidx.appcompat.app.ActionBar;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.Calendar;
import us.pinguo.foundation.base.BaseSplitActivity;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class PictureViewPagerActivity extends BaseSplitActivity {
    private ExtendedViewPager a;
    private LinearLayout b;
    private ArrayList<String> c;

    /* renamed from: d  reason: collision with root package name */
    private b f11384d;

    /* renamed from: e  reason: collision with root package name */
    private int f11385e;

    /* renamed from: f  reason: collision with root package name */
    private long f11386f;

    /* renamed from: g  reason: collision with root package name */
    private ViewPager.OnPageChangeListener f11387g = new a();

    /* loaded from: classes9.dex */
    class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            PictureViewPagerActivity.this.f11385e = i2;
            ActionBar supportActionBar = PictureViewPagerActivity.this.getSupportActionBar();
            supportActionBar.setTitle((i2 + 1) + "/" + PictureViewPagerActivity.this.f11384d.getCount());
        }
    }

    private void init() {
        setContentView(R.layout.activity_picture_view_pager);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        this.a = (ExtendedViewPager) findViewById(R.id.evp_apvp);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_apvp);
        this.b = linearLayout;
        b bVar = new b(this, linearLayout);
        this.f11384d = bVar;
        bVar.h(this.f11387g);
        ArrayList<String> arrayList = (ArrayList) getIntent().getSerializableExtra(PictureViewPagerDialogFragment.EXTRA_IMAGE_URLS);
        this.c = arrayList;
        this.f11384d.f(arrayList);
        this.a.setAdapter(this.f11384d);
        this.a.addOnPageChangeListener(this.f11384d);
        int intExtra = getIntent().getIntExtra(PictureViewPagerDialogFragment.EXTRA_CURRENT_ITEM, 0);
        this.f11385e = intExtra;
        if (intExtra != 0) {
            this.f11384d.c();
        }
        this.a.setCurrentItem(this.f11385e);
        ArrayList<String> arrayList2 = this.c;
        int size = arrayList2 != null ? arrayList2.size() : 0;
        supportActionBar.setTitle((this.f11385e + 1) + "/" + size);
    }

    private void s0() {
        onBackPressed();
    }

    private void t0() {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (timeInMillis - this.f11386f > 400) {
            this.c.remove(this.f11385e);
            if (this.c.size() == 0) {
                s0();
            } else {
                if (this.f11385e > this.f11384d.getCount() - 1) {
                    this.f11385e = this.f11384d.getCount();
                    this.f11384d.c();
                }
                this.f11384d.g(this.c, this.f11385e);
                ActionBar supportActionBar = getSupportActionBar();
                supportActionBar.setTitle((this.f11385e + 1) + "/" + this.f11384d.getCount());
            }
            this.f11386f = timeInMillis;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra(PictureViewPagerDialogFragment.EXTRA_IMAGE_URLS, this.c);
        setResult(-1, intent);
        finish();
        super.onBackPressed();
        overridePendingTransition(17432576, 17432577);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        init();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (getIntent().getBooleanExtra("EXTRA_DELETE_ENABLE", false)) {
            getMenuInflater().inflate(R.menu.menu_picture_pager, menu);
            return true;
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.delete_menu) {
            t0();
            return true;
        } else if (menuItem.getItemId() == 16908332) {
            s0();
            return true;
        } else {
            return true;
        }
    }
}
