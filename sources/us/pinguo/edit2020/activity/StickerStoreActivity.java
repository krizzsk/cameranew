package us.pinguo.edit2020.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelLazy;
import java.util.LinkedHashMap;
import kotlin.f;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.u;
import kotlinx.coroutines.flow.e;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.fragment.StickerStoreListFragment;
import us.pinguo.edit2020.utils.FlowObserver;
import us.pinguo.edit2020.viewmodel.StaticStickerStoreViewModel;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.repository2020.manager.FilterRepository;
import us.pinguo.util.h;
/* compiled from: StickerStoreActivity.kt */
/* loaded from: classes4.dex */
public final class StickerStoreActivity extends BaseActivity {
    public static final a c = new a(null);
    private final f a;
    private StickerStoreListFragment b;

    /* compiled from: StickerStoreActivity.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final Intent a(Context context) {
            s.h(context, "context");
            return b(context, "sticker_management");
        }

        public final Intent b(Context context, String str) {
            s.h(context, "context");
            Intent intent = new Intent(context, StickerStoreActivity.class);
            if (!(str == null || str.length() == 0)) {
                intent.putExtra("data", str);
            }
            return intent;
        }
    }

    public StickerStoreActivity() {
        new LinkedHashMap();
        this.a = new ViewModelLazy(v.b(StaticStickerStoreViewModel.class), new StickerStoreActivity$special$$inlined$viewModels$default$2(this), new StickerStoreActivity$special$$inlined$viewModels$default$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t0(l<? super FragmentTransaction, u> lVar) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        s.g(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        s.g(beginTransaction, "beginTransaction()");
        lVar.invoke(beginTransaction);
        beginTransaction.commit();
    }

    private final StaticStickerStoreViewModel u0() {
        return (StaticStickerStoreViewModel) this.a.getValue();
    }

    private final void v0() {
        new FlowObserver(this, e.y(u0().s(), new StickerStoreActivity$initObserver$1(this, null)), new StickerStoreActivity$initObserver$$inlined$observeInLifecycle$1(null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mEnableBaseNotch = false;
        setContentView(R.layout.activity_sticker_store_layout);
        h.o(this);
        FilterRepository.a.A();
        String stringExtra = getIntent().getStringExtra("data");
        if (stringExtra == null) {
            t0(new StickerStoreActivity$onCreate$1(this));
        } else if (s.c(stringExtra, "sticker_management")) {
            t0(StickerStoreActivity$onCreate$2.INSTANCE);
        } else {
            t0(new StickerStoreActivity$onCreate$3(stringExtra));
        }
        v0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        requestCheckIsFullDisplay(-1);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            h.o(this);
        }
    }
}
