package us.pinguo.camera360.module;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.play.core.review.ReviewInfo;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.adv.HomeInterstitialActivity;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.homepage.UpdateDialog;
import com.pinguo.camera360.k.b.a;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.camera2020.view.dialog.HomeAdvDialog;
import us.pinguo.foundation.interaction.AppGoto;
import vStudio.Android.Camera360.R;
/* compiled from: PortalInterfaceImpl.java */
/* loaded from: classes3.dex */
public class w implements us.pinguo.librouter.module.inspire.b {
    private HomeAdvDialog a;
    long b = 0;
    private boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9542d = true;

    /* renamed from: e  reason: collision with root package name */
    private Handler f9543e;

    private void A(final Activity activity) {
        us.pinguo.foundation.statistics.h.a.n0("show");
        us.pinguo.foundation.utils.w.n(activity, R.string.options_grade_tips_ok, R.string.options_grade_tips_cancel, new DialogInterface.OnClickListener() { // from class: us.pinguo.camera360.module.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                w.this.u(activity, dialogInterface, i2);
            }
        });
    }

    private void B(final Activity activity) {
        us.pinguo.common.manager.b bVar;
        final AdvItem d2;
        if (us.pinguo.foundation.f.e() && f() && (d2 = (bVar = us.pinguo.common.manager.b.a).d("059cb142134fa6993e486b574028e6e4", "homePage", false)) != null) {
            HomeAdvDialog homeAdvDialog = new HomeAdvDialog();
            this.a = homeAdvDialog;
            homeAdvDialog.o0(d2.downloadedFilePath);
            this.a.q0(new kotlin.jvm.b.a() { // from class: us.pinguo.camera360.module.p
                @Override // kotlin.jvm.b.a
                public final Object invoke() {
                    return w.this.w(d2, activity);
                }
            });
            this.a.p0(new kotlin.jvm.b.a() { // from class: us.pinguo.camera360.module.k
                @Override // kotlin.jvm.b.a
                public final Object invoke() {
                    return us.pinguo.foundation.statistics.h.a.L("main_page", AdvItem.this.advId, "cancel");
                }
            });
            AdvConfigManager.getInstance().addGuidDisplayCount(d2);
            bVar.a(d2);
            if (this.a == null || !(activity instanceof FragmentActivity) || activity.isFinishing()) {
                return;
            }
            FragmentTransaction beginTransaction = ((FragmentActivity) activity).getSupportFragmentManager().beginTransaction();
            try {
                if (!this.f9542d) {
                    HomeAdvDialog homeAdvDialog2 = this.a;
                    VdsAgent.showDialogFragment(homeAdvDialog2, beginTransaction, "HomeAdvDialog", homeAdvDialog2.show(beginTransaction, "HomeAdvDialog"));
                }
            } catch (Throwable unused) {
            }
            us.pinguo.foundation.statistics.h.a.L("main_page", d2.advId, "show");
        }
    }

    private boolean f() {
        HomeAdvDialog homeAdvDialog = this.a;
        return (homeAdvDialog == null || !homeAdvDialog.isVisible()) && !this.c;
    }

    private void h() {
        if (this.f9543e == null) {
            this.f9543e = new Handler();
        }
    }

    private void i(Activity activity) {
        AdvItem loadDownloadedImage = AdvConfigManager.getInstance().loadDownloadedImage(AdvConfigManager.getInstance().getItemHightPrioritys("a2708d8113ee758a5e172f8b4a8952d0"));
        if (loadDownloadedImage != null && "homePage".equals(loadDownloadedImage.popPosition)) {
            this.c = true;
            activity.startActivity(new Intent(activity, HomeInterstitialActivity.class));
        }
    }

    private void j(final Activity activity) {
        final com.google.android.play.core.review.c a = com.google.android.play.core.review.d.a(activity);
        com.google.android.play.core.tasks.d<ReviewInfo> a2 = a.a();
        a2.a(new com.google.android.play.core.tasks.a() { // from class: us.pinguo.camera360.module.m
            @Override // com.google.android.play.core.tasks.a
            public final void onComplete(com.google.android.play.core.tasks.d dVar) {
                w.l(com.google.android.play.core.review.c.this, activity, dVar);
            }
        });
        a2.b(g.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void k(Activity activity, com.google.android.play.core.tasks.d dVar) {
        a.b.c();
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void l(com.google.android.play.core.review.c cVar, final Activity activity, com.google.android.play.core.tasks.d dVar) {
        if (dVar.i()) {
            us.pinguo.common.log.a.c("in_app_review", "task successful");
            cVar.b(activity, (ReviewInfo) dVar.g()).a(new com.google.android.play.core.tasks.a() { // from class: us.pinguo.camera360.module.o
                @Override // com.google.android.play.core.tasks.a
                public final void onComplete(com.google.android.play.core.tasks.d dVar2) {
                    w.k(activity, dVar2);
                }
            });
            return;
        }
        us.pinguo.common.log.a.e("in_app_review", "in-app review task failed=>");
        a.b.c();
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void n(Activity activity, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        if (i2 == -2) {
            us.pinguo.foundation.statistics.h.a.n0("click_negative_cancel");
            activity.finish();
        } else if (i2 != -1) {
        } else {
            us.pinguo.foundation.statistics.h.a.n0("click_negative_ok");
            new k.a.a(activity).a();
            a.b.c();
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void o(Activity activity, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        if (i2 == -2) {
            us.pinguo.foundation.statistics.h.a.n0("click_positive_cancel");
            activity.finish();
        } else if (i2 != -1) {
        } else {
            us.pinguo.foundation.statistics.h.a.n0("click_positive_ok");
            k.a.a.b(activity);
            a.b.c();
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public /* synthetic */ void u(final Activity activity, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        if (i2 == -2) {
            us.pinguo.foundation.statistics.h.a.n0("click_cancel");
            h();
            this.f9543e.postDelayed(new Runnable() { // from class: us.pinguo.camera360.module.j
                @Override // java.lang.Runnable
                public final void run() {
                    w.this.s(activity);
                }
            }, 50L);
        } else if (i2 != -1) {
        } else {
            us.pinguo.foundation.statistics.h.a.n0("click_ok");
            if (k.a.a.c(activity)) {
                j(activity);
                return;
            }
            h();
            this.f9543e.postDelayed(new Runnable() { // from class: us.pinguo.camera360.module.n
                @Override // java.lang.Runnable
                public final void run() {
                    w.this.q(activity);
                }
            }, 50L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public /* synthetic */ kotlin.u w(AdvItem advItem, Activity activity) {
        g();
        us.pinguo.foundation.statistics.h.a.L("main_page", advItem.advId, "click");
        AppGoto.getInstance().d(advItem).b(activity);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public void s(final Activity activity) {
        us.pinguo.foundation.utils.w.o(activity, -999, R.string.options_feedback_tips_msg, R.string.options_feedback_tips_ok, R.string.options_feedback_tips_cancel, new DialogInterface.OnClickListener() { // from class: us.pinguo.camera360.module.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                w.n(activity, dialogInterface, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public void q(final Activity activity) {
        us.pinguo.foundation.utils.w.o(activity, -999, R.string.options_rate_tips_msg, R.string.options_rate_tips_ok, R.string.options_rate_tips_cancel, new DialogInterface.OnClickListener() { // from class: us.pinguo.camera360.module.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                w.o(activity, dialogInterface, i2);
            }
        });
    }

    @Override // us.pinguo.librouter.module.inspire.b
    public void a(Activity activity) {
        this.f9542d = false;
        if (CameraBusinessSettingModel.v().m()) {
            return;
        }
        us.pinguo.foundation.utils.f.b(q.a);
    }

    @Override // us.pinguo.librouter.module.inspire.b
    public void b(Activity activity) {
        this.b = System.currentTimeMillis();
        CameraBusinessSettingModel.v().F("key_camera_lunch_count", CameraBusinessSettingModel.v().n("key_camera_lunch_count", 0) + 1);
        CameraBusinessSettingModel.v().b();
        this.f9542d = true;
    }

    @Override // us.pinguo.librouter.module.inspire.b
    public void c(Activity activity) {
        this.f9542d = true;
        CameraBusinessSettingModel.v().b();
        g();
    }

    @Override // us.pinguo.librouter.module.inspire.b
    public boolean d(Activity activity) {
        if (new k.a.a(activity).e()) {
            A(activity);
            return true;
        }
        return false;
    }

    @Override // us.pinguo.librouter.module.inspire.b
    public void e(Activity activity) {
        us.pinguo.common.log.a.c("home launch time:" + (System.currentTimeMillis() - this.b), new Object[0]);
        this.c = false;
        i(activity);
        UpdateDialog updateDialog = new UpdateDialog();
        updateDialog.k0(activity);
        updateDialog.l0(AdvConfigManager.getInstance().getItem("1e6d82ea76b94425b4935623e1db5354"));
        updateDialog.j0(AdvConfigManager.getInstance().getItem("da45affffdb941348052fb7c6e642199"));
        if (updateDialog.c0()) {
            updateDialog.setCancelable(false);
            if (activity instanceof FragmentActivity) {
                updateDialog.show(((FragmentActivity) activity).getSupportFragmentManager(), "updata-dialog");
            }
        } else {
            B(activity);
        }
        us.pinguo.camera360.shop.data.show.u.b().s(null, false);
        com.pinguo.camera360.adv.c.g(activity.getApplicationContext());
    }

    protected void g() {
        HomeAdvDialog homeAdvDialog = this.a;
        if (homeAdvDialog != null) {
            try {
                homeAdvDialog.dismissAllowingStateLoss();
            } catch (Exception unused) {
            }
            this.a = null;
        }
    }

    @Override // us.pinguo.librouter.module.inspire.b
    public void onDestroy() {
        g();
        CameraBusinessSettingModel.v().b();
    }
}
