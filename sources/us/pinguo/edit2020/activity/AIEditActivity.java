package us.pinguo.edit2020.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.transition.TransitionInflater;
import android.util.Size;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.io.File;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.fragment.AIEditFragment;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.foundation.statistics.h;
import us.pinguo.foundation.utils.d0;
import us.pinguo.foundation.utils.k0;
import us.pinguo.inspire.w;
import us.pinguo.u3dengine.PgUnityPlayer;
import us.pinguo.util.c;
import us.pinguo.util.v;
/* compiled from: AIEditActivity.kt */
/* loaded from: classes4.dex */
public final class AIEditActivity extends BaseActivity {
    public static final a a = new a(null);

    /* compiled from: AIEditActivity.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final void a(Context context, String str, boolean z, Uri uri, boolean z2) {
            s.h(context, "context");
            if (c.f12477k) {
                k0 k0Var = k0.a;
                String string = context.getResources().getString(R.string.device_do_not_support_the_function);
                s.g(string, "context.resources.getStr…not_support_the_function)");
                k0Var.b(string);
                return;
            }
            Intent intent = new Intent(context, AIEditActivity.class);
            intent.putExtra("photo_path", str);
            intent.putExtra("is_from_preview", z);
            intent.putExtra("bundle_key_goto", uri);
            intent.putExtra("bundle_key_used_vip_in_camera", z2);
            context.startActivity(intent);
        }
    }

    public AIEditActivity() {
        new LinkedHashMap();
    }

    private final Size q0(String str) {
        String bitmap;
        if (new File(str).exists()) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            String str2 = "null";
            if (decodeFile != null && (bitmap = decodeFile.toString()) != null) {
                str2 = bitmap;
            }
            us.pinguo.common.log.a.c(str2, new Object[0]);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            if (i2 < 100 || i3 < 100) {
                k0.a.a(R.string.pick_pic_waring);
                return null;
            }
            float f2 = i2 / i3;
            if (f2 <= 5.0f && f2 >= 0.2f) {
                return new Size(i2, i3);
            }
            k0.a.a(R.string.pick_pic_waring);
            return null;
        }
        return null;
    }

    private final Size r0() {
        String stringExtra = getIntent().getStringExtra("photo_path");
        if (stringExtra == null) {
            stringExtra = "";
        }
        if (!new File(stringExtra).exists()) {
            k0.a.a(R.string.puzzle_msg_pic_error);
            return null;
        }
        return q0(stringExtra);
    }

    private final AIEditFragment s0() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.containerFragment);
        AIEditFragment aIEditFragment = findFragmentById instanceof AIEditFragment ? (AIEditFragment) findFragmentById : null;
        return aIEditFragment == null ? new AIEditFragment() : aIEditFragment;
    }

    private final void u0() {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        int i2 = R.id.containerFragment;
        AIEditFragment s0 = s0();
        FragmentTransaction replace = beginTransaction.replace(i2, s0);
        VdsAgent.onFragmentTransactionReplace(beginTransaction, i2, s0, replace);
        replace.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == 1) {
            finish();
        }
        if (6928 != i2) {
            if (i2 == 1000 && i3 == -1) {
                h.b.R("sub_succuss");
            }
        } else if (!v.j()) {
            finish();
        } else if (r0() == null) {
            finish();
        } else {
            t0();
            u0();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        s0().H0();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (s0().onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mEnableBaseNotch = false;
        d0.a(this);
        super.onCreate(bundle);
        PgUnityPlayer.d(this);
        us.pinguo.foundation.c.d(this, "create");
        getWindow().requestFeature(12);
        getWindow().requestFeature(13);
        getWindow().setExitTransition(TransitionInflater.from(this).inflateTransition(R.transition.image_transition));
        setContentView(R.layout.activity_edit);
        us.pinguo.util.h.o(this);
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        s.g(lp, "lp");
        us.pinguo.util.h.a(lp);
        getWindow().setAttributes(lp);
        if (!v.j()) {
            w.b(this, "android.permission.WRITE_EXTERNAL_STORAGE");
        } else if (r0() == null) {
            finish();
        } else if (bundle == null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            s.g(supportFragmentManager, "supportFragmentManager");
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            s.g(beginTransaction, "beginTransaction()");
            beginTransaction.setReorderingAllowed(true);
            s.g(beginTransaction.add(R.id.containerFragment, AIEditFragment.class, null, null), "add(containerViewId, F::class.java, args, tag)");
            beginTransaction.commit();
            t0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        d0.b(this);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @Instrumented
    public void onNewIntent(Intent intent) {
        VdsAgent.onNewIntent(this, intent);
        super.onNewIntent(intent);
        s0().L0(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            us.pinguo.util.h.o(this);
        }
    }

    public final void t0() {
    }
}
