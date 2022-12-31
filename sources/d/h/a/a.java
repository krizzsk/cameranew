package d.h.a;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.view.View;
import android.widget.Toast;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.gallery.RootActivity;
import com.pinguo.camera360.gallery.data.u;
import com.pinguo.camera360.gallery.data.w;
import com.pinguo.camera360.k.b.a;
import java.util.List;
import us.pinguo.foundation.utils.k0;
import us.pinguo.inspire.module.contact.cell.FindFriendHeaderCell;
import us.pinguo.librouter.c.d;
import us.pinguo.pgshare.commons.f;
import us.pinguo.share.c.e;
import us.pinguo.share.core.PGShareInfo;
import us.pinguo.share.core.PGShareListener;
import us.pinguo.share.core.PGShareManager;
import us.pinguo.share.core.ShareSite;
import us.pinguo.share.exception.AppNotExistException;
import us.pinguo.share.util.ExpandShareSite;
import us.pinguo.share.util.InspirePublishDialog;
import us.pinguo.share.util.InspireShareUtils;
import us.pinguo.share.util.OnShareSiteClickListener;
import us.pinguo.share.util.k;
import us.pinguo.share.util.n;
import us.pinguo.util.s;
import vStudio.Android.Camera360.R;
/* compiled from: ShareHelper.java */
/* loaded from: classes3.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShareHelper.java */
    /* renamed from: d.h.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0306a implements PGShareListener {
        final /* synthetic */ View a;

        /* compiled from: ShareHelper.java */
        /* renamed from: d.h.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class RunnableC0307a implements Runnable {
            RunnableC0307a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Toast makeText = Toast.makeText(C0306a.this.a.getContext(), (int) R.string.share_callback_msg_success, 0);
                makeText.show();
                VdsAgent.showToast(makeText);
            }
        }

        /* compiled from: ShareHelper.java */
        /* renamed from: d.h.a.a$a$b */
        /* loaded from: classes3.dex */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Toast makeText = Toast.makeText(C0306a.this.a.getContext(), (int) R.string.share_not_install_app, 0);
                makeText.show();
                VdsAgent.showToast(makeText);
            }
        }

        /* compiled from: ShareHelper.java */
        /* renamed from: d.h.a.a$a$c */
        /* loaded from: classes3.dex */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Toast makeText = Toast.makeText(C0306a.this.a.getContext(), (int) R.string.share_callback_msg_error, 0);
                makeText.show();
                VdsAgent.showToast(makeText);
            }
        }

        C0306a(View view) {
            this.a = view;
        }

        @Override // us.pinguo.share.core.PGShareListener
        public void onShareCancel(ShareSite shareSite) {
            us.pinguo.common.log.a.c("onShareCancel:" + shareSite, new Object[0]);
        }

        @Override // us.pinguo.share.core.PGShareListener
        public void onShareComplete(ShareSite shareSite, boolean z) {
            us.pinguo.common.log.a.c("onShareComplete:" + shareSite + ", fakeComplete" + z, new Object[0]);
            if (z) {
                return;
            }
            this.a.post(new RunnableC0307a());
        }

        @Override // us.pinguo.share.core.PGShareListener
        public void onShareError(ShareSite shareSite, Throwable th) {
            us.pinguo.common.log.a.e("onShareError:" + shareSite + ":" + th.toString(), new Object[0]);
            if (th instanceof AppNotExistException) {
                this.a.post(new b());
            } else {
                this.a.post(new c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShareHelper.java */
    /* loaded from: classes3.dex */
    public class b extends us.pinguo.pgshare.commons.b {
        final /* synthetic */ int a;
        final /* synthetic */ PGShareInfo b;
        final /* synthetic */ View c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Activity f8613d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ PGShareListener f8614e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f8615f;

        b(int i2, PGShareInfo pGShareInfo, View view, Activity activity, PGShareListener pGShareListener, String str) {
            this.a = i2;
            this.b = pGShareInfo;
            this.c = view;
            this.f8613d = activity;
            this.f8614e = pGShareListener;
            this.f8615f = str;
        }

        @Override // us.pinguo.pgshare.commons.b
        public void a(us.pinguo.pgshare.commons.c cVar, String str) {
            d.c().getInterface().a((Activity) this.c.getContext(), 1, 1, this.f8615f);
        }

        @Override // us.pinguo.pgshare.commons.b
        public void b(us.pinguo.pgshare.commons.c cVar, ResolveInfo resolveInfo) {
            a.i.a(this.a, a.b(ShareSite.OTHER));
            PGShareManager pGShareManager = PGShareManager.getInstance();
            Context context = this.c.getContext();
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            pGShareManager.intentShare(context, activityInfo.packageName, activityInfo.name, this.b, null);
        }

        @Override // us.pinguo.pgshare.commons.b
        public void c(us.pinguo.pgshare.commons.c cVar, ShareSite shareSite) {
            a.i.a(this.a, a.b(shareSite));
            int i2 = c.a[shareSite.ordinal()];
            if (i2 == 1) {
                this.b.setText(n.b(this.c.getContext()));
            } else if (i2 == 2) {
                this.b.setText(n.a(this.c.getContext()));
            } else if (i2 == 3) {
                this.b.setText(this.c.getContext().getString(R.string.share_default_message));
            }
            if (shareSite == ShareSite.FACEBOOK) {
                if (!s.h("com.facebook.katana", this.f8613d)) {
                    k0.a.a(R.string.not_install_app);
                } else {
                    us.pinguo.share.b.d(this.f8613d, this.b, this.f8614e);
                }
            } else if (shareSite != ShareSite.SINAWEIBO && shareSite != ShareSite.WECHAT_FRIENDS && shareSite != ShareSite.WECHAT_MOMENTS) {
                if (shareSite == ShareSite.QQ) {
                    PGShareManager.getInstance().intentShare(this.f8613d, shareSite.getPackageName(), "com.tencent.mobileqq.activity.JumpActivity", this.b, this.f8614e);
                } else {
                    PGShareManager.getInstance().intentShare(this.f8613d, shareSite.getPackageName(), null, this.b, this.f8614e);
                }
            } else {
                PGShareManager.getInstance().siteShare(this.f8613d, shareSite, this.b, this.f8614e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShareHelper.java */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ShareSite.values().length];
            a = iArr;
            try {
                iArr[ShareSite.SINAWEIBO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ShareSite.TWITTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ShareSite.QZONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ShareSite.FACEBOOK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ShareSite.INSTAGRAM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ShareSite.QQ.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ShareSite.WECHAT_FRIENDS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ShareSite.WECHAT_MOMENTS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[ShareSite.OTHER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(ShareSite shareSite) {
        if (shareSite == null) {
            return us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER;
        }
        switch (c.a[shareSite.ordinal()]) {
            case 1:
                return "sinawebo";
            case 2:
                return FindFriendHeaderCell.TWITTER;
            case 3:
                return "qqzone";
            case 4:
                return "facebook";
            case 5:
                return "instagram";
            case 6:
                return "qq";
            case 7:
                return "weichat";
            case 8:
                return "friend";
            default:
                return us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER;
        }
    }

    public static us.pinguo.pgshare.commons.c c(int i2, String str, View view, boolean z, Activity activity) {
        f i3;
        C0306a c0306a = new C0306a(view);
        PGShareInfo pGShareInfo = new PGShareInfo();
        pGShareInfo.setImageUri(str);
        if (z) {
            f.b bVar = new f.b();
            bVar.f(R.string.camera360_publish, R.drawable.camera360_publish, "camera360_publish");
            bVar.e();
            bVar.k("image/jpeg");
            i3 = bVar.h();
        } else {
            i3 = f.b.i();
        }
        return us.pinguo.pgshare.commons.d.b(i3, view.getContext(), new b(i2, pGShareInfo, view, activity, c0306a, str));
    }

    public static us.pinguo.pgshare.commons.c d(String str, View view, Activity activity) {
        return c(-999, str, view, false, activity);
    }

    public static InspirePublishDialog e(RootActivity rootActivity, w wVar, boolean z, String str) {
        List<ExpandShareSite> a = k.a(z);
        e eVar = (e) d.c().getInterface().e(wVar.o(), false);
        OnShareSiteClickListener defaultShareSiteClickListener = InspireShareUtils.getDefaultShareSiteClickListener(rootActivity, eVar, null, null, str);
        boolean z2 = wVar instanceof u;
        return InspireShareUtils.showShareDialogToSNS(rootActivity, z2 ? 2 : 1, z2 ? 2 : 1, wVar.o(), a, eVar, defaultShareSiteClickListener, str);
    }
}
