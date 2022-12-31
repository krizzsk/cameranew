package us.pinguo.camera360.shop.activity;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.k.b.a;
import com.pinguo.camera360.lib.camera.view.FreshGuideView;
import com.pinguo.camera360.ui.TitleBarLayout;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.camera360.shop.data.FilterType;
import us.pinguo.camera360.shop.data.g;
import us.pinguo.camera360.shop.data.h;
import us.pinguo.camera360.shop.data.i;
import us.pinguo.camera360.shop.data.install.FilterOperateManager;
import us.pinguo.camera360.shop.manager.p0;
import us.pinguo.camera360.shop.manager.r0;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.foundation.utils.f;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class StoreManagerFilterActivity extends BaseActivity implements TitleBarLayout.a, p0.b {
    private RecyclerView a;
    private ItemTouchHelper b;
    private boolean c;

    /* renamed from: e  reason: collision with root package name */
    private p0 f9554e;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView.LayoutManager f9555f;

    /* renamed from: g  reason: collision with root package name */
    private r0 f9556g;
    @BindView
    View mErrorLay;
    @BindView
    FreshGuideView mGuideView;
    @BindView
    TitleBarLayout mTitleBarLayout;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<h> f9553d = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<String> f9557h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<String> f9558i = new ArrayList<>();

    private void initView() {
        this.mTitleBarLayout.setTiTleText(R.string.str_collected_filter);
        this.mTitleBarLayout.setLeftImageBtnRes(R.drawable.store_details_back);
        this.mTitleBarLayout.setOnTitleBarClickListener(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.store_filter_manager_recyclerView);
        this.a = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.a.addItemDecoration(new a(this));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.f9555f = linearLayoutManager;
        this.a.setLayoutManager(linearLayoutManager);
    }

    private void r0() {
        List<h> f2 = i.e().f(FilterType.Effect, FilterType.Loc);
        for (h hVar : f2) {
            String d2 = hVar.d();
            if (d2.contains("assets://")) {
                hVar.m(d2.replace("assets://", "asset:///"));
            }
        }
        ArrayList<h> arrayList = new ArrayList<>();
        this.f9553d = arrayList;
        arrayList.addAll(f2);
        ArrayList<h> arrayList2 = this.f9553d;
        if (arrayList2 != null && arrayList2.size() >= 1) {
            q0();
        } else {
            y0();
        }
        this.f9554e = new p0(this.f9553d);
        r0 r0Var = new r0(this.f9554e);
        this.f9556g = r0Var;
        this.b = new ItemTouchHelper(r0Var);
        this.f9554e.q(this);
        this.f9554e.r(new p0.d() { // from class: us.pinguo.camera360.shop.activity.b
            @Override // us.pinguo.camera360.shop.manager.p0.d
            public final void a(RecyclerView.ViewHolder viewHolder) {
                StoreManagerFilterActivity.this.v0(viewHolder);
            }
        });
        this.a.setAdapter(this.f9554e);
        this.b.attachToRecyclerView(this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public /* synthetic */ void t0() {
        RecyclerView recyclerView = this.a;
        if (recyclerView == null || this.mErrorLay == null) {
            return;
        }
        recyclerView.setVisibility(0);
        VdsAgent.onSetViewVisibility(recyclerView, 0);
        View view = this.mErrorLay;
        view.setVisibility(8);
        VdsAgent.onSetViewVisibility(view, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public /* synthetic */ void v0(RecyclerView.ViewHolder viewHolder) {
        this.c = true;
        this.b.startDrag(viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0 */
    public /* synthetic */ void x0() {
        RecyclerView recyclerView = this.a;
        if (recyclerView == null || this.mErrorLay == null) {
            return;
        }
        recyclerView.setVisibility(8);
        VdsAgent.onSetViewVisibility(recyclerView, 8);
        View view = this.mErrorLay;
        view.setVisibility(0);
        VdsAgent.onSetViewVisibility(view, 0);
    }

    @Override // us.pinguo.camera360.shop.manager.p0.b
    public void M(p0.c cVar, h hVar) {
        this.c = true;
        this.f9553d.remove(hVar);
        if (this.f9553d.size() == 0) {
            y0();
        }
    }

    @Override // us.pinguo.camera360.shop.manager.p0.b
    public void j(p0.c cVar, g gVar) {
        this.c = true;
        this.f9553d.get(cVar.getLayoutPosition()).c(new FilterType[0]).remove(gVar);
        a.b.i("filter", gVar.getPackageId(), gVar.getFilterId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (18 == i2 && 3 == i3) {
            this.f9557h.addAll(intent.getStringArrayListExtra("key_storemanager_install_list"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_store_filter_manager);
        ButterKnife.bind(this);
        initView();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.mGuideView.getVisibility() == 0) {
                FreshGuideView freshGuideView = this.mGuideView;
                freshGuideView.setVisibility(8);
                VdsAgent.onSetViewVisibility(freshGuideView, 8);
                return true;
            }
            Intent intent = new Intent();
            intent.putStringArrayListExtra("key_storemanager_install_list", this.f9557h);
            intent.putStringArrayListExtra("key_storemanager_uninstall_list", this.f9558i);
            intent.putExtra("key_data_changed", this.c);
            setResult(3, intent);
            finish();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.pinguo.camera360.ui.TitleBarLayout.a
    public void onLeftBtnClick(View view) {
        if (this.mGuideView.getVisibility() == 0) {
            FreshGuideView freshGuideView = this.mGuideView;
            freshGuideView.setVisibility(8);
            VdsAgent.onSetViewVisibility(freshGuideView, 8);
            return;
        }
        Intent intent = new Intent();
        intent.putStringArrayListExtra("key_storemanager_install_list", this.f9557h);
        intent.putStringArrayListExtra("key_storemanager_uninstall_list", this.f9558i);
        intent.putExtra("key_data_changed", this.c);
        setResult(3, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        FilterOperateManager.h().s(this.f9554e.f());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        r0();
    }

    @Override // com.pinguo.camera360.ui.TitleBarLayout.a
    public void onRightBtnClick(View view) {
        startActivityForResult(new Intent(this, StoreRecoveryFilterActivity.class), 18);
    }

    public void q0() {
        f.c(new Runnable() { // from class: us.pinguo.camera360.shop.activity.c
            @Override // java.lang.Runnable
            public final void run() {
                StoreManagerFilterActivity.this.t0();
            }
        });
    }

    public void y0() {
        f.c(new Runnable() { // from class: us.pinguo.camera360.shop.activity.a
            @Override // java.lang.Runnable
            public final void run() {
                StoreManagerFilterActivity.this.x0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends RecyclerView.ItemDecoration {
        private Drawable a;
        private int b;

        public a(StoreManagerFilterActivity storeManagerFilterActivity, int i2) {
            this.b = 2;
            this.a = new ColorDrawable(i2);
        }

        public void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
            int childCount = recyclerView.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = recyclerView.getChildAt(i2);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                this.a.setBounds((childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) + us.pinguo.foundation.t.b.a.a(recyclerView.getContext(), 88.0f), bottom, childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, this.b + bottom);
                this.a.draw(canvas);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            drawHorizontal(canvas, recyclerView);
        }

        public a(StoreManagerFilterActivity storeManagerFilterActivity) {
            this(storeManagerFilterActivity, Color.parseColor("#d8d8d8"));
        }
    }
}
