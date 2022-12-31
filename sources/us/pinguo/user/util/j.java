package us.pinguo.user.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.java_websocket.framing.CloseFrame;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.j0;
import us.pinguo.foundation.utils.w;
import us.pinguo.user.R;
import us.pinguo.user.User;
import us.pinguo.user.s0;
import us.pinguo.user.util.j;
/* compiled from: ShareHelper.kt */
/* loaded from: classes6.dex */
public final class j {
    public static final j a = new j();

    /* compiled from: ShareHelper.kt */
    /* loaded from: classes6.dex */
    public static final class a implements g {
        final /* synthetic */ Activity a;
        final /* synthetic */ Runnable b;
        final /* synthetic */ Runnable c;

        /* renamed from: d */
        final /* synthetic */ Runnable f12465d;

        a(Activity activity, Runnable runnable, Runnable runnable2, Runnable runnable3) {
            this.a = activity;
            this.b = runnable;
            this.c = runnable2;
            this.f12465d = runnable3;
        }

        public static final void b(Activity activity, DialogInterface dialogInterface, int i2) {
            VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
            s.h(activity, "$activity");
            if (i2 == -2) {
                if (dialogInterface == null) {
                    return;
                }
                dialogInterface.dismiss();
            } else if (i2 != -1) {
            } else {
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                Intent intent = new Intent();
                intent.setClassName(us.pinguo.foundation.e.b(), "us.pinguo.inspire.PhoneBindActivity");
                activity.startActivityForResult(intent, CloseFrame.NOCODE);
            }
        }

        @Override // us.pinguo.user.util.g
        public void onFetchBaseInfo(BaseInfoResult baseInfoResult, int i2) {
            if (i2 != 0) {
                j0.c(R.string.no_connect);
            } else if (baseInfoResult != null) {
                if (baseInfoResult.isShareOn()) {
                    if (s0.getInstance().e()) {
                        if (n.m(User.d().h(), baseInfoResult.isChina())) {
                            Resources resources = this.a.getResources();
                            Activity activity = this.a;
                            CharSequence text = resources.getText(R.string.bind_phone_title);
                            CharSequence text2 = resources.getText(R.string.bind_phone_detail);
                            CharSequence text3 = resources.getText(R.string.ok_bind);
                            CharSequence text4 = resources.getText(R.string.cancel);
                            final Activity activity2 = this.a;
                            w.h(activity, text, text2, text3, text4, new DialogInterface.OnClickListener() { // from class: us.pinguo.user.util.b
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i3) {
                                    j.a.b(activity2, dialogInterface, i3);
                                }
                            });
                            return;
                        }
                        this.b.run();
                        return;
                    } else if (baseInfoResult.isChina()) {
                        s0.getInstance().a(this.a, 205, us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER);
                        return;
                    } else {
                        this.b.run();
                        return;
                    }
                }
                j0.c(R.string.share_disabled);
                Runnable runnable = this.c;
                if (runnable == null) {
                    return;
                }
                runnable.run();
            } else {
                j0.c(R.string.no_connect);
                Runnable runnable2 = this.f12465d;
                if (runnable2 == null) {
                    return;
                }
                runnable2.run();
            }
        }
    }

    private j() {
    }

    public static /* synthetic */ void c(j jVar, Activity activity, Runnable runnable, Runnable runnable2, Runnable runnable3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            runnable2 = null;
        }
        if ((i2 & 8) != 0) {
            runnable3 = null;
        }
        jVar.b(activity, runnable, runnable2, runnable3);
    }

    public static final void d(Activity activity, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        s.h(activity, "$activity");
        if (i2 == -2) {
            if (dialogInterface == null) {
                return;
            }
            dialogInterface.dismiss();
        } else if (i2 != -1) {
        } else {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            Intent intent = new Intent();
            intent.setClassName(us.pinguo.foundation.e.b(), "us.pinguo.inspire.PhoneBindActivity");
            activity.startActivityForResult(intent, CloseFrame.NOCODE);
        }
    }

    public final void b(final Activity activity, Runnable shareAction, Runnable runnable, Runnable runnable2) {
        s.h(activity, "activity");
        s.h(shareAction, "shareAction");
        n nVar = n.a;
        BaseInfoResult g2 = nVar.g();
        if (g2 == null) {
            nVar.h(new a(activity, shareAction, runnable, runnable2));
        } else if (g2.isShareOn()) {
            if (s0.getInstance().e()) {
                if (n.m(User.d().h(), g2.isChina())) {
                    Resources resources = activity.getResources();
                    w.h(activity, resources.getText(R.string.bind_phone_title), resources.getText(R.string.bind_phone_detail), resources.getText(R.string.ok_bind), resources.getText(R.string.cancel), new DialogInterface.OnClickListener() { // from class: us.pinguo.user.util.a
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            j.d(activity, dialogInterface, i2);
                        }
                    });
                    return;
                }
                shareAction.run();
            } else if (g2.isChina()) {
                s0.getInstance().a(activity, 205, us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER);
            } else {
                shareAction.run();
            }
        } else {
            j0.c(R.string.share_disabled);
            if (runnable == null) {
                return;
            }
            runnable.run();
        }
    }
}
