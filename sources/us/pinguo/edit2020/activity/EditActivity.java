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
import androidx.lifecycle.LifecycleOwnerKt;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.io.File;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.l;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.fragment.EditFragment;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.foundation.utils.d0;
import us.pinguo.foundation.utils.i;
import us.pinguo.foundation.utils.k0;
import us.pinguo.inspire.w;
import us.pinguo.repository2020.entity.Graffiti;
import us.pinguo.repository2020.entity.MaterialResponse;
import us.pinguo.repository2020.entity.Mosaic;
import us.pinguo.repository2020.network.HttpBaseResponse;
import us.pinguo.u3dengine.PgUnityPlayer;
import us.pinguo.util.v;
/* compiled from: EditActivity.kt */
/* loaded from: classes4.dex */
public final class EditActivity extends BaseActivity {
    public static final Companion a = new Companion(null);

    /* compiled from: EditActivity.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }

        public final void a(Context context, String path, int i2) {
            s.h(path, "path");
            if (context == null) {
                return;
            }
            l.d(n0.a(z0.b()), null, null, new EditActivity$Companion$gotoEdit$1(path, i2, context, null), 3, null);
        }

        public final void b(Context context, String str, boolean z, Uri uri, boolean z2) {
            s.h(context, "context");
            Intent intent = new Intent(context, EditActivity.class);
            intent.putExtra("photo_path", str);
            intent.putExtra("is_from_preview", z);
            intent.putExtra("bundle_key_goto", uri);
            intent.putExtra("bundle_key_used_vip_in_camera", z2);
            context.startActivity(intent);
        }
    }

    /* compiled from: MaterialDataManager.kt */
    /* loaded from: classes4.dex */
    public static final class a extends com.google.gson.t.a<HttpBaseResponse<MaterialResponse<Mosaic>>> {
    }

    /* compiled from: MaterialDataManager.kt */
    /* loaded from: classes4.dex */
    public static final class b extends com.google.gson.t.a<HttpBaseResponse<MaterialResponse<Graffiti>>> {
    }

    /* compiled from: MaterialDataManager.kt */
    /* loaded from: classes4.dex */
    public static final class c extends com.google.gson.t.a<String[]> {
    }

    /* compiled from: MaterialDataManager.kt */
    /* loaded from: classes4.dex */
    public static final class d extends com.google.gson.t.a<Integer[]> {
    }

    /* compiled from: MaterialDataManager.kt */
    /* loaded from: classes4.dex */
    public static final class e extends com.google.gson.t.a<HttpBaseResponse<MaterialResponse<Mosaic>>> {
    }

    /* compiled from: MaterialDataManager.kt */
    /* loaded from: classes4.dex */
    public static final class f extends com.google.gson.t.a<HttpBaseResponse<MaterialResponse<Graffiti>>> {
    }

    /* compiled from: MaterialDataManager.kt */
    /* loaded from: classes4.dex */
    public static final class g extends com.google.gson.t.a<String[]> {
    }

    /* compiled from: MaterialDataManager.kt */
    /* loaded from: classes4.dex */
    public static final class h extends com.google.gson.t.a<Integer[]> {
    }

    public EditActivity() {
        new LinkedHashMap();
    }

    private final Size q0(String str) {
        String bitmap;
        if (new File(str).exists()) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            PrintStream printStream = System.out;
            String str2 = "null";
            if (decodeFile != null && (bitmap = decodeFile.toString()) != null) {
                str2 = bitmap;
            }
            printStream.println((Object) str2);
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

    private final void s0(String str) {
        l.d(LifecycleOwnerKt.getLifecycleScope(this), z0.b(), null, new EditActivity$clearCache$1(str, null), 2, null);
    }

    private final EditFragment t0() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.containerFragment);
        EditFragment editFragment = findFragmentById instanceof EditFragment ? (EditFragment) findFragmentById : null;
        return editFragment == null ? new EditFragment() : editFragment;
    }

    private final void v0() {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        int i2 = R.id.containerFragment;
        EditFragment t0 = t0();
        FragmentTransaction replace = beginTransaction.replace(i2, t0);
        VdsAgent.onFragmentTransactionReplace(beginTransaction, i2, t0, replace);
        replace.commitAllowingStateLoss();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == 1) {
            finish();
        }
        if (6928 == i2) {
            if (!v.j()) {
                finish();
            } else if (r0() == null) {
                finish();
            } else {
                u0();
                v0();
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        t0().k2();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (t0().onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

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
            s.g(beginTransaction.add(R.id.containerFragment, EditFragment.class, null, null), "add(containerViewId, F::class.java, args, tag)");
            beginTransaction.commit();
            u0();
        }
    }

    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        d0.b(this);
        super.onDestroy();
        us.pinguo.foundation.c.d(this, "destroy");
    }

    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @Instrumented
    public void onNewIntent(Intent intent) {
        VdsAgent.onNewIntent(this, intent);
        super.onNewIntent(intent);
        t0().t2(intent);
    }

    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        us.pinguo.foundation.statistics.g.c("edit_page");
        super.onPause();
        us.pinguo.foundation.c.d(this, "pause");
        if (i.c()) {
            return;
        }
        us.pinguo.bigdata.a.d();
    }

    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        us.pinguo.foundation.c.d(this, "resume");
        us.pinguo.foundation.statistics.g.d("edit_page");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            us.pinguo.util.h.o(this);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:(1:3)(41:322|(1:324)|318|25|(1:27)(32:214|(1:216)|210|44|45|(1:47)(15:199|(1:201)|67|(1:69)(4:99|(1:101)|86|87)|70|(1:72)(4:96|(1:98)|86|87)|73|74|(1:76)(4:93|(1:95)|86|87)|77|78|(4:80|(1:91)(1:82)|83|84)|92|86|87)|48|(1:50)(15:196|(1:198)|67|(0)(0)|70|(0)(0)|73|74|(0)(0)|77|78|(0)|92|86|87)|51|(1:53)(15:193|(1:195)|67|(0)(0)|70|(0)(0)|73|74|(0)(0)|77|78|(0)|92|86|87)|54|(1:56)(3:189|(1:191)|192)|57|58|(4:136|(12:139|(3:168|(3:171|(2:173|174)|169)|175)|143|(1:145)(1:167)|146|(2:147|(2:149|(2:151|152))(2:165|166))|153|(1:155)|156|(3:162|163|164)(3:158|159|160)|161|137)|176|177)|(3:109|(1:111)(4:113|(6:116|(3:123|(3:125|126|127)(1:129)|128)|130|(0)(0)|128|114)|131|132)|112)(1:62)|63|(1:65)(2:102|(2:104|(1:106)(2:107|108)))|66|67|(0)(0)|70|(0)(0)|73|74|(0)(0)|77|78|(0)|92|86|87)|28|(1:30)(32:211|(1:213)|210|44|45|(0)(0)|48|(0)(0)|51|(0)(0)|54|(0)(0)|57|58|(1:60)(5:133|136|(1:137)|176|177)|(0)(0)|63|(0)(0)|66|67|(0)(0)|70|(0)(0)|73|74|(0)(0)|77|78|(0)|92|86|87)|31|32|(1:34)(32:207|(1:209)|210|44|45|(0)(0)|48|(0)(0)|51|(0)(0)|54|(0)(0)|57|58|(0)(0)|(0)(0)|63|(0)(0)|66|67|(0)(0)|70|(0)(0)|73|74|(0)(0)|77|78|(0)|92|86|87)|35|(5:37|(1:205)(1:39)|40|41|(30:43|44|45|(0)(0)|48|(0)(0)|51|(0)(0)|54|(0)(0)|57|58|(0)(0)|(0)(0)|63|(0)(0)|66|67|(0)(0)|70|(0)(0)|73|74|(0)(0)|77|78|(0)|92|86|87))(1:206)|202|45|(0)(0)|48|(0)(0)|51|(0)(0)|54|(0)(0)|57|58|(0)(0)|(0)(0)|63|(0)(0)|66|67|(0)(0)|70|(0)(0)|73|74|(0)(0)|77|78|(0)|92|86|87)|(1:6)(41:319|(1:321)|318|25|(0)(0)|28|(0)(0)|31|32|(0)(0)|35|(0)(0)|202|45|(0)(0)|48|(0)(0)|51|(0)(0)|54|(0)(0)|57|58|(0)(0)|(0)(0)|63|(0)(0)|66|67|(0)(0)|70|(0)(0)|73|74|(0)(0)|77|78|(0)|92|86|87)|(1:10)(41:315|(1:317)|318|25|(0)(0)|28|(0)(0)|31|32|(0)(0)|35|(0)(0)|202|45|(0)(0)|48|(0)(0)|51|(0)(0)|54|(0)(0)|57|58|(0)(0)|(0)(0)|63|(0)(0)|66|67|(0)(0)|70|(0)(0)|73|74|(0)(0)|77|78|(0)|92|86|87)|(46:251|(15:254|255|256|257|(3:285|(3:288|(2:291|292)(1:290)|286)|293)|261|(1:263)(1:284)|264|(2:265|(2:267|(2:270|271)(1:269))(2:282|283))|272|(1:274)|275|(2:277|278)(2:280|281)|279|252)|303|304|(3:224|(1:226)(4:228|(6:231|(3:238|(3:240|241|242)(1:244)|243)|245|(0)(0)|243|229)|246|247)|227)(1:20)|21|(1:23)(2:217|(2:219|(1:221)(2:222|223)))|24|25|(0)(0)|28|(0)(0)|31|32|(0)(0)|35|(0)(0)|202|45|(0)(0)|48|(0)(0)|51|(0)(0)|54|(0)(0)|57|58|(0)(0)|(0)(0)|63|(0)(0)|66|67|(0)(0)|70|(0)(0)|73|74|(0)(0)|77|78|(0)|92|86|87)|57|58|(0)(0)|(0)(0)|63|(0)(0)|66|67|(0)(0)|70|(0)(0)|73|74|(0)(0)|77|78|(0)|92|86|87) */
    /* JADX WARN: Can't wrap try/catch for region: R(26:(24:(1:3)(41:322|(1:324)|318|25|(1:27)(32:214|(1:216)|210|44|45|(1:47)(15:199|(1:201)|67|(1:69)(4:99|(1:101)|86|87)|70|(1:72)(4:96|(1:98)|86|87)|73|74|(1:76)(4:93|(1:95)|86|87)|77|78|(4:80|(1:91)(1:82)|83|84)|92|86|87)|48|(1:50)(15:196|(1:198)|67|(0)(0)|70|(0)(0)|73|74|(0)(0)|77|78|(0)|92|86|87)|51|(1:53)(15:193|(1:195)|67|(0)(0)|70|(0)(0)|73|74|(0)(0)|77|78|(0)|92|86|87)|54|(1:56)(3:189|(1:191)|192)|57|58|(4:136|(12:139|(3:168|(3:171|(2:173|174)|169)|175)|143|(1:145)(1:167)|146|(2:147|(2:149|(2:151|152))(2:165|166))|153|(1:155)|156|(3:162|163|164)(3:158|159|160)|161|137)|176|177)|(3:109|(1:111)(4:113|(6:116|(3:123|(3:125|126|127)(1:129)|128)|130|(0)(0)|128|114)|131|132)|112)(1:62)|63|(1:65)(2:102|(2:104|(1:106)(2:107|108)))|66|67|(0)(0)|70|(0)(0)|73|74|(0)(0)|77|78|(0)|92|86|87)|28|(1:30)(32:211|(1:213)|210|44|45|(0)(0)|48|(0)(0)|51|(0)(0)|54|(0)(0)|57|58|(1:60)(5:133|136|(1:137)|176|177)|(0)(0)|63|(0)(0)|66|67|(0)(0)|70|(0)(0)|73|74|(0)(0)|77|78|(0)|92|86|87)|31|32|(1:34)(32:207|(1:209)|210|44|45|(0)(0)|48|(0)(0)|51|(0)(0)|54|(0)(0)|57|58|(0)(0)|(0)(0)|63|(0)(0)|66|67|(0)(0)|70|(0)(0)|73|74|(0)(0)|77|78|(0)|92|86|87)|35|(5:37|(1:205)(1:39)|40|41|(30:43|44|45|(0)(0)|48|(0)(0)|51|(0)(0)|54|(0)(0)|57|58|(0)(0)|(0)(0)|63|(0)(0)|66|67|(0)(0)|70|(0)(0)|73|74|(0)(0)|77|78|(0)|92|86|87))(1:206)|202|45|(0)(0)|48|(0)(0)|51|(0)(0)|54|(0)(0)|57|58|(0)(0)|(0)(0)|63|(0)(0)|66|67|(0)(0)|70|(0)(0)|73|74|(0)(0)|77|78|(0)|92|86|87)|(1:6)(41:319|(1:321)|318|25|(0)(0)|28|(0)(0)|31|32|(0)(0)|35|(0)(0)|202|45|(0)(0)|48|(0)(0)|51|(0)(0)|54|(0)(0)|57|58|(0)(0)|(0)(0)|63|(0)(0)|66|67|(0)(0)|70|(0)(0)|73|74|(0)(0)|77|78|(0)|92|86|87)|(1:10)(41:315|(1:317)|318|25|(0)(0)|28|(0)(0)|31|32|(0)(0)|35|(0)(0)|202|45|(0)(0)|48|(0)(0)|51|(0)(0)|54|(0)(0)|57|58|(0)(0)|(0)(0)|63|(0)(0)|66|67|(0)(0)|70|(0)(0)|73|74|(0)(0)|77|78|(0)|92|86|87)|(46:251|(15:254|255|256|257|(3:285|(3:288|(2:291|292)(1:290)|286)|293)|261|(1:263)(1:284)|264|(2:265|(2:267|(2:270|271)(1:269))(2:282|283))|272|(1:274)|275|(2:277|278)(2:280|281)|279|252)|303|304|(3:224|(1:226)(4:228|(6:231|(3:238|(3:240|241|242)(1:244)|243)|245|(0)(0)|243|229)|246|247)|227)(1:20)|21|(1:23)(2:217|(2:219|(1:221)(2:222|223)))|24|25|(0)(0)|28|(0)(0)|31|32|(0)(0)|35|(0)(0)|202|45|(0)(0)|48|(0)(0)|51|(0)(0)|54|(0)(0)|57|58|(0)(0)|(0)(0)|63|(0)(0)|66|67|(0)(0)|70|(0)(0)|73|74|(0)(0)|77|78|(0)|92|86|87)|57|58|(0)(0)|(0)(0)|63|(0)(0)|66|67|(0)(0)|70|(0)(0)|73|74|(0)(0)|77|78|(0)|92|86|87)|15|16|18|(0)(0)|21|(0)(0)|24|25|(0)(0)|28|(0)(0)|31|32|(0)(0)|35|(0)(0)|202|45|(0)(0)|48|(0)(0)|51|(0)(0)|54|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:437:0x02c9, code lost:
        r24 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:584:0x0635, code lost:
        if (kotlin.jvm.internal.s.c(us.pinguo.repository2020.entity.Graffiti.class, us.pinguo.repository2020.entity.Mosaic.class) != false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:585:0x0637, code lost:
        r0 = r4.f();
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:586:0x063c, code lost:
        r0.setValue(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:588:0x0644, code lost:
        if (kotlin.jvm.internal.s.c(us.pinguo.repository2020.entity.Graffiti.class, us.pinguo.repository2020.entity.Graffiti.class) != false) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:589:0x0646, code lost:
        r0 = r4.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:590:0x064a, code lost:
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:625:0x06c3, code lost:
        if (r3.c(r2, (r4 == null || (r4 = r4.getInterval()) == null) ? -1 : r4.intValue(), null) == us.pinguo.repository2020.utils.RequestIntervalPref.RefreshType.NONE_REFRESH) goto L86;
     */
    /* JADX WARN: Removed duplicated region for block: B:405:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x0262 A[Catch: all -> 0x02c7, Exception -> 0x02cb, TryCatch #0 {Exception -> 0x02cb, blocks: (B:425:0x02a3, B:427:0x02a9, B:428:0x02b1, B:430:0x02b7, B:432:0x02bd, B:433:0x02c1, B:434:0x02c6, B:406:0x0262, B:424:0x02a0, B:409:0x026a, B:410:0x0273, B:412:0x0279, B:414:0x0286, B:416:0x028c, B:422:0x0298, B:423:0x029c, B:372:0x012e, B:374:0x0141, B:385:0x0170, B:387:0x017f, B:388:0x0186, B:390:0x018c, B:395:0x01af, B:397:0x01b3, B:398:0x0240, B:401:0x0247, B:386:0x0178, B:377:0x0149, B:378:0x014d, B:380:0x0153, B:403:0x025b), top: B:631:0x012e }] */
    /* JADX WARN: Removed duplicated region for block: B:427:0x02a9 A[Catch: all -> 0x02c7, Exception -> 0x02cb, TryCatch #0 {Exception -> 0x02cb, blocks: (B:425:0x02a3, B:427:0x02a9, B:428:0x02b1, B:430:0x02b7, B:432:0x02bd, B:433:0x02c1, B:434:0x02c6, B:406:0x0262, B:424:0x02a0, B:409:0x026a, B:410:0x0273, B:412:0x0279, B:414:0x0286, B:416:0x028c, B:422:0x0298, B:423:0x029c, B:372:0x012e, B:374:0x0141, B:385:0x0170, B:387:0x017f, B:388:0x0186, B:390:0x018c, B:395:0x01af, B:397:0x01b3, B:398:0x0240, B:401:0x0247, B:386:0x0178, B:377:0x0149, B:378:0x014d, B:380:0x0153, B:403:0x025b), top: B:631:0x012e }] */
    /* JADX WARN: Removed duplicated region for block: B:428:0x02b1 A[Catch: all -> 0x02c7, Exception -> 0x02cb, TryCatch #0 {Exception -> 0x02cb, blocks: (B:425:0x02a3, B:427:0x02a9, B:428:0x02b1, B:430:0x02b7, B:432:0x02bd, B:433:0x02c1, B:434:0x02c6, B:406:0x0262, B:424:0x02a0, B:409:0x026a, B:410:0x0273, B:412:0x0279, B:414:0x0286, B:416:0x028c, B:422:0x0298, B:423:0x029c, B:372:0x012e, B:374:0x0141, B:385:0x0170, B:387:0x017f, B:388:0x0186, B:390:0x018c, B:395:0x01af, B:397:0x01b3, B:398:0x0240, B:401:0x0247, B:386:0x0178, B:377:0x0149, B:378:0x014d, B:380:0x0153, B:403:0x025b), top: B:631:0x012e }] */
    /* JADX WARN: Removed duplicated region for block: B:452:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:453:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:458:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:460:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:465:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:466:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:471:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:482:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:488:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:489:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:494:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:495:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:500:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:501:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:506:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:507:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:514:0x0491 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:515:0x0493 A[Catch: all -> 0x062f, Exception -> 0x0631, TryCatch #3 {Exception -> 0x0631, blocks: (B:512:0x0461, B:571:0x0609, B:573:0x060f, B:574:0x0617, B:576:0x061d, B:578:0x0623, B:579:0x0627, B:580:0x062e, B:552:0x05c8, B:570:0x0606, B:555:0x05d0, B:556:0x05d9, B:558:0x05df, B:560:0x05ec, B:562:0x05f2, B:568:0x05fe, B:569:0x0602, B:515:0x0493, B:518:0x049b, B:519:0x049f, B:521:0x04a5, B:523:0x04c1, B:533:0x04ea, B:535:0x04f9, B:536:0x0500, B:538:0x0506, B:542:0x051d, B:544:0x0521, B:545:0x05ae, B:548:0x05b6, B:534:0x04f2, B:526:0x04c9, B:527:0x04cd, B:529:0x04d3, B:549:0x05c3), top: B:634:0x0461, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:521:0x04a5 A[Catch: all -> 0x062f, Exception -> 0x0631, TryCatch #3 {Exception -> 0x0631, blocks: (B:512:0x0461, B:571:0x0609, B:573:0x060f, B:574:0x0617, B:576:0x061d, B:578:0x0623, B:579:0x0627, B:580:0x062e, B:552:0x05c8, B:570:0x0606, B:555:0x05d0, B:556:0x05d9, B:558:0x05df, B:560:0x05ec, B:562:0x05f2, B:568:0x05fe, B:569:0x0602, B:515:0x0493, B:518:0x049b, B:519:0x049f, B:521:0x04a5, B:523:0x04c1, B:533:0x04ea, B:535:0x04f9, B:536:0x0500, B:538:0x0506, B:542:0x051d, B:544:0x0521, B:545:0x05ae, B:548:0x05b6, B:534:0x04f2, B:526:0x04c9, B:527:0x04cd, B:529:0x04d3, B:549:0x05c3), top: B:634:0x0461, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:551:0x05c7  */
    /* JADX WARN: Removed duplicated region for block: B:552:0x05c8 A[Catch: all -> 0x062f, Exception -> 0x0631, TryCatch #3 {Exception -> 0x0631, blocks: (B:512:0x0461, B:571:0x0609, B:573:0x060f, B:574:0x0617, B:576:0x061d, B:578:0x0623, B:579:0x0627, B:580:0x062e, B:552:0x05c8, B:570:0x0606, B:555:0x05d0, B:556:0x05d9, B:558:0x05df, B:560:0x05ec, B:562:0x05f2, B:568:0x05fe, B:569:0x0602, B:515:0x0493, B:518:0x049b, B:519:0x049f, B:521:0x04a5, B:523:0x04c1, B:533:0x04ea, B:535:0x04f9, B:536:0x0500, B:538:0x0506, B:542:0x051d, B:544:0x0521, B:545:0x05ae, B:548:0x05b6, B:534:0x04f2, B:526:0x04c9, B:527:0x04cd, B:529:0x04d3, B:549:0x05c3), top: B:634:0x0461, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:573:0x060f A[Catch: all -> 0x062f, Exception -> 0x0631, TryCatch #3 {Exception -> 0x0631, blocks: (B:512:0x0461, B:571:0x0609, B:573:0x060f, B:574:0x0617, B:576:0x061d, B:578:0x0623, B:579:0x0627, B:580:0x062e, B:552:0x05c8, B:570:0x0606, B:555:0x05d0, B:556:0x05d9, B:558:0x05df, B:560:0x05ec, B:562:0x05f2, B:568:0x05fe, B:569:0x0602, B:515:0x0493, B:518:0x049b, B:519:0x049f, B:521:0x04a5, B:523:0x04c1, B:533:0x04ea, B:535:0x04f9, B:536:0x0500, B:538:0x0506, B:542:0x051d, B:544:0x0521, B:545:0x05ae, B:548:0x05b6, B:534:0x04f2, B:526:0x04c9, B:527:0x04cd, B:529:0x04d3, B:549:0x05c3), top: B:634:0x0461, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:574:0x0617 A[Catch: all -> 0x062f, Exception -> 0x0631, TryCatch #3 {Exception -> 0x0631, blocks: (B:512:0x0461, B:571:0x0609, B:573:0x060f, B:574:0x0617, B:576:0x061d, B:578:0x0623, B:579:0x0627, B:580:0x062e, B:552:0x05c8, B:570:0x0606, B:555:0x05d0, B:556:0x05d9, B:558:0x05df, B:560:0x05ec, B:562:0x05f2, B:568:0x05fe, B:569:0x0602, B:515:0x0493, B:518:0x049b, B:519:0x049f, B:521:0x04a5, B:523:0x04c1, B:533:0x04ea, B:535:0x04f9, B:536:0x0500, B:538:0x0506, B:542:0x051d, B:544:0x0521, B:545:0x05ae, B:548:0x05b6, B:534:0x04f2, B:526:0x04c9, B:527:0x04cd, B:529:0x04d3, B:549:0x05c3), top: B:634:0x0461, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:596:0x0661  */
    /* JADX WARN: Removed duplicated region for block: B:597:0x0664  */
    /* JADX WARN: Removed duplicated region for block: B:602:0x0672  */
    /* JADX WARN: Removed duplicated region for block: B:604:0x0679  */
    /* JADX WARN: Removed duplicated region for block: B:609:0x068a  */
    /* JADX WARN: Removed duplicated region for block: B:611:0x0691  */
    /* JADX WARN: Removed duplicated region for block: B:616:0x06a2  */
    /* JADX WARN: Removed duplicated region for block: B:635:0x05fe A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:638:0x05d9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:650:0x0298 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:653:0x0273 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u0() {
        /*
            Method dump skipped, instructions count: 1809
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.activity.EditActivity.u0():void");
    }
}
