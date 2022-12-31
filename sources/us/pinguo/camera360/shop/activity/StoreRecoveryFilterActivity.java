package us.pinguo.camera360.shop.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.newShop.model.StoreHistoryNew;
import com.pinguo.camera360.newShop.model.StoreOrder;
import com.pinguo.camera360.newShop.model.StoreOrderItem;
import com.pinguo.camera360.ui.TitleBarLayout;
import com.pinguo.lib.GsonUtilKt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import us.pinguo.camera360.shop.data.i;
import us.pinguo.camera360.shop.data.install.FilterOperateManager;
import us.pinguo.camera360.shop.data.install.p;
import us.pinguo.camera360.shop.data.install.q;
import us.pinguo.camera360.shop.data.show.UnlockManager;
import us.pinguo.camera360.shop.data.show.u;
import us.pinguo.camera360.shop.manager.DividerGridItemDecoration;
import us.pinguo.camera360.shop.manager.q0;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.foundation.utils.j0;
import us.pinguo.foundation.utils.w;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class StoreRecoveryFilterActivity extends BaseActivity implements TitleBarLayout.a, UnlockManager.g, q0.c {

    /* renamed from: j  reason: collision with root package name */
    private static final String f9559j = StoreRecoveryFilterActivity.class.getSimpleName();
    private RecyclerView a;
    private AlertDialog b;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9561e;

    /* renamed from: f  reason: collision with root package name */
    private Toast f9562f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9563g;

    /* renamed from: h  reason: collision with root package name */
    private q0 f9564h;
    @BindView
    View mErrorLay;
    @BindView
    TextView mErrorTxt;
    @BindView
    TitleBarLayout mTitleBarLayout;
    private ArrayMap<String, p> c = new ArrayMap<>();

    /* renamed from: d  reason: collision with root package name */
    private List<StoreOrderItem> f9560d = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<String> f9565i = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (StoreRecoveryFilterActivity.this.a != null) {
                StoreRecoveryFilterActivity storeRecoveryFilterActivity = StoreRecoveryFilterActivity.this;
                if (storeRecoveryFilterActivity.mErrorLay != null) {
                    RecyclerView recyclerView = storeRecoveryFilterActivity.a;
                    recyclerView.setVisibility(8);
                    VdsAgent.onSetViewVisibility(recyclerView, 8);
                    StoreRecoveryFilterActivity.this.mErrorTxt.setText(R.string.store_recovery_no_data);
                    View view = StoreRecoveryFilterActivity.this.mErrorLay;
                    view.setVisibility(0);
                    VdsAgent.onSetViewVisibility(view, 0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (StoreRecoveryFilterActivity.this.a != null) {
                StoreRecoveryFilterActivity storeRecoveryFilterActivity = StoreRecoveryFilterActivity.this;
                if (storeRecoveryFilterActivity.mErrorLay != null) {
                    RecyclerView recyclerView = storeRecoveryFilterActivity.a;
                    recyclerView.setVisibility(0);
                    VdsAgent.onSetViewVisibility(recyclerView, 0);
                    View view = StoreRecoveryFilterActivity.this.mErrorLay;
                    view.setVisibility(8);
                    VdsAgent.onSetViewVisibility(view, 8);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (StoreRecoveryFilterActivity.this.b != null) {
                if (StoreRecoveryFilterActivity.this.b.isShowing()) {
                    return;
                }
            } else {
                StoreRecoveryFilterActivity storeRecoveryFilterActivity = StoreRecoveryFilterActivity.this;
                storeRecoveryFilterActivity.b = w.p(storeRecoveryFilterActivity, R.string.rec_dialog_msg);
            }
            AlertDialog alertDialog = StoreRecoveryFilterActivity.this.b;
            alertDialog.show();
            VdsAgent.showDialog(alertDialog);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (StoreRecoveryFilterActivity.this.b == null || !StoreRecoveryFilterActivity.this.b.isShowing() || StoreRecoveryFilterActivity.this.isFinishing()) {
                return;
            }
            StoreRecoveryFilterActivity.this.b.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (StoreRecoveryFilterActivity.this.f9560d == null || StoreRecoveryFilterActivity.this.f9560d.isEmpty()) {
                return;
            }
            StoreRecoveryFilterActivity.this.a.setAdapter(StoreRecoveryFilterActivity.this.f9564h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f implements Runnable {
        final /* synthetic */ StoreOrderItem a;

        f(StoreOrderItem storeOrderItem) {
            this.a = storeOrderItem;
        }

        @Override // java.lang.Runnable
        public void run() {
            q0.b bVar;
            int indexOf = StoreRecoveryFilterActivity.this.f9560d.indexOf(this.a);
            View childAt = (indexOf == -1 || StoreRecoveryFilterActivity.this.a == null) ? null : StoreRecoveryFilterActivity.this.a.getChildAt(indexOf);
            if (childAt == null || (bVar = (q0.b) StoreRecoveryFilterActivity.this.a.getChildViewHolder(childAt)) == null || bVar.f9731d.getVisibility() != 0) {
                return;
            }
            View view = bVar.f9731d;
            view.setVisibility(8);
            VdsAgent.onSetViewVisibility(view, 8);
            StoreRecoveryFilterActivity.this.a.removeView(childAt);
            us.pinguo.common.log.a.m(StoreRecoveryFilterActivity.f9559j, "hideItemProgressUI", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class g implements p {
        private StoreOrderItem a;

        /* loaded from: classes3.dex */
        class a implements Runnable {
            final /* synthetic */ q a;

            a(q qVar) {
                this.a = qVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                StoreRecoveryFilterActivity.this.f9561e = false;
                String string = StoreRecoveryFilterActivity.this.getResources().getString(R.string.install_failed_tips);
                int a = this.a.a();
                if (a == 1) {
                    string = StoreRecoveryFilterActivity.this.getResources().getString(R.string.download_no_memory);
                } else if (a == 2) {
                    string = StoreRecoveryFilterActivity.this.getResources().getString(R.string.download_not_network);
                }
                g gVar = g.this;
                StoreRecoveryFilterActivity.this.H0(gVar.a);
                StoreRecoveryFilterActivity storeRecoveryFilterActivity = StoreRecoveryFilterActivity.this;
                storeRecoveryFilterActivity.f9562f = Toast.makeText(storeRecoveryFilterActivity, string, 0);
                if (StoreRecoveryFilterActivity.this.f9563g) {
                    return;
                }
                StoreRecoveryFilterActivity.this.f9563g = true;
                Toast toast = StoreRecoveryFilterActivity.this.f9562f;
                toast.show();
                VdsAgent.showToast(toast);
            }
        }

        public g(StoreOrderItem storeOrderItem) {
            this.a = storeOrderItem;
        }

        @Override // us.pinguo.camera360.shop.data.install.p
        public void a(q qVar) {
            String str = StoreRecoveryFilterActivity.f9559j;
            us.pinguo.common.log.a.d(str, "install finished,topic_id:" + qVar.c() + ",success:" + qVar.d() + ",errorCode:" + qVar.a(), new Object[0]);
            if (qVar.b() != null) {
                qVar.b().printStackTrace();
            }
            StoreRecoveryFilterActivity.this.H0(this.a);
            if (qVar.d()) {
                StoreRecoveryFilterActivity.this.f9564h.i(this.a);
                StoreRecoveryFilterActivity.this.c.remove(this.a.productId);
                StoreRecoveryFilterActivity.this.f9560d.remove(this.a);
                if (StoreRecoveryFilterActivity.this.c.isEmpty()) {
                    StoreRecoveryFilterActivity.this.f9561e = false;
                }
                if (StoreRecoveryFilterActivity.this.f9560d.isEmpty() || StoreRecoveryFilterActivity.this.f9560d.size() == 0) {
                    StoreRecoveryFilterActivity.this.N0();
                }
                StoreRecoveryFilterActivity.this.f9565i.add(this.a.productId);
                i.e().u();
            } else {
                us.pinguo.foundation.utils.f.c(new a(qVar));
            }
            if (qVar.c() != null) {
                FilterOperateManager.h().u(qVar.c());
            }
        }

        @Override // us.pinguo.camera360.shop.data.install.p
        public void b(String str) {
            try {
                StoreOrderItem storeOrderItem = this.a;
                if (storeOrderItem != null) {
                    StoreRecoveryFilterActivity.this.O0(storeOrderItem);
                }
            } catch (Exception e2) {
                us.pinguo.common.log.a.f(e2);
            }
        }

        @Override // us.pinguo.camera360.shop.data.install.p
        public void c(String str, int i2) {
        }
    }

    private void F0(StoreOrderItem storeOrderItem) {
        try {
            this.f9561e = true;
            g gVar = new g(storeOrderItem);
            this.c.put(storeOrderItem.productId, gVar);
            FilterOperateManager.h().q(storeOrderItem.productId, gVar);
            FilterOperateManager.h().m(u.b().h(storeOrderItem.productId));
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(StoreOrderItem storeOrderItem) {
        us.pinguo.foundation.utils.f.c(new f(storeOrderItem));
    }

    private void I0() {
        us.pinguo.foundation.utils.f.c(new d());
    }

    private void J0() {
        P0();
        if (!us.pinguo.util.q.f(this)) {
            j0.c(R.string.network_not_available);
            b0();
            return;
        }
        u.b().q(0, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K0 */
    public /* synthetic */ void L0(DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        if (i2 == -1) {
            dialogInterface.dismiss();
            Intent intent = new Intent();
            intent.putStringArrayListExtra("key_storemanager_install_list", this.f9565i);
            setResult(3, intent);
            finish();
            return;
        }
        dialogInterface.dismiss();
    }

    private void M0(List<StoreOrderItem> list) {
        if (list != null) {
            try {
            } catch (Exception e2) {
                us.pinguo.common.log.a.f(e2);
            }
            if (list.size() >= 1) {
                HashSet<StoreOrderItem> hashSet = new HashSet();
                hashSet.addAll(list);
                ArrayList arrayList = new ArrayList();
                for (StoreOrderItem storeOrderItem : hashSet) {
                    if (FilterOperateManager.h().k(storeOrderItem.productId) || storeOrderItem.type != 1) {
                        arrayList.add(storeOrderItem);
                    }
                }
                hashSet.removeAll(arrayList);
                if (hashSet.size() == 0) {
                    I0();
                    N0();
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                this.f9560d = arrayList2;
                arrayList2.addAll(hashSet);
                List<StoreOrderItem> list2 = this.f9560d;
                if (list2 != null && !list2.isEmpty()) {
                    q0 q0Var = new q0(this.f9560d);
                    this.f9564h = q0Var;
                    q0Var.j(this);
                }
                us.pinguo.foundation.utils.f.d(new e(), 200L);
                I0();
                G0();
                return;
            }
        }
        I0();
        N0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(StoreOrderItem storeOrderItem) {
        RecyclerView recyclerView;
        int indexOf = this.f9560d.indexOf(storeOrderItem);
        View childAt = (indexOf == -1 || (recyclerView = this.a) == null) ? null : recyclerView.getChildAt(indexOf);
        if (childAt != null) {
            this.a.getChildViewHolder(childAt);
        }
    }

    private void P0() {
        us.pinguo.foundation.utils.f.c(new c());
    }

    private void initView() {
        this.mTitleBarLayout.setTiTleText(R.string.store_recovery_title);
        this.mTitleBarLayout.setLeftImageBtnRes(R.drawable.store_details_back);
        this.mTitleBarLayout.setOnTitleBarClickListener(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.store_filter_manager_recyclerView);
        this.a = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.a.setLayoutManager(new GridLayoutManager(this, 4));
        this.a.addItemDecoration(new DividerGridItemDecoration(this));
    }

    public void G0() {
        us.pinguo.foundation.utils.f.c(new b());
    }

    @Override // us.pinguo.camera360.shop.manager.q0.c
    public void N(q0.b bVar, StoreOrderItem storeOrderItem) {
        F0(storeOrderItem);
    }

    public void N0() {
        us.pinguo.foundation.utils.f.c(new a());
    }

    @Override // us.pinguo.camera360.shop.data.show.UnlockManager.g
    public void R(String str) {
        StoreOrder storeOrder;
        try {
            StoreHistoryNew storeHistoryNew = (StoreHistoryNew) GsonUtilKt.getCachedGson().j(str, StoreHistoryNew.class);
            if (storeHistoryNew != null && (storeOrder = storeHistoryNew.data) != null && storeOrder.lists.size() != 0) {
                M0(storeHistoryNew.data.lists);
            }
            h0();
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
            I0();
            N0();
        }
    }

    @Override // us.pinguo.camera360.shop.data.show.UnlockManager.g
    public void b0() {
        h0();
    }

    @Override // us.pinguo.camera360.shop.data.show.UnlockManager.g
    public void h0() {
        StoreOrder storeOrder;
        List<StoreOrderItem> list;
        try {
            StoreHistoryNew c2 = u.b().c();
            if (c2 != null && (storeOrder = c2.data) != null && (list = storeOrder.lists) != null) {
                M0(list);
            } else {
                I0();
                N0();
            }
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
            I0();
            N0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_store_filter_manager);
        ButterKnife.bind(this);
        initView();
        J0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ArrayMap<String, p> arrayMap = this.c;
        if (arrayMap == null || arrayMap.size() <= 0) {
            return;
        }
        for (String str : this.c.keySet()) {
            FilterOperateManager.h().u(str);
            FilterOperateManager.h().f(str);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            Intent intent = new Intent();
            intent.putStringArrayListExtra("key_storemanager_install_list", this.f9565i);
            setResult(3, intent);
            finish();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.pinguo.camera360.ui.TitleBarLayout.a
    public void onLeftBtnClick(View view) {
        if (this.f9561e) {
            w.i(this, R.string.store_recovery_stop_msg, R.string.ok, R.string.cancel, new DialogInterface.OnClickListener() { // from class: us.pinguo.camera360.shop.activity.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    StoreRecoveryFilterActivity.this.L0(dialogInterface, i2);
                }
            });
            return;
        }
        Intent intent = new Intent();
        intent.putStringArrayListExtra("key_storemanager_install_list", this.f9565i);
        setResult(3, intent);
        finish();
    }

    @Override // com.pinguo.camera360.ui.TitleBarLayout.a
    public void onRightBtnClick(View view) {
    }
}
