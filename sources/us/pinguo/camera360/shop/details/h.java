package us.pinguo.camera360.shop.details;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.k.b.a;
import com.pinguo.camera360.vip.VipManager;
import java.util.List;
import us.pinguo.camera360.shop.data.FilterType;
import us.pinguo.camera360.shop.data.install.FilterOperateManager;
import us.pinguo.camera360.shop.data.k;
import us.pinguo.camera360.shop.data.show.BaseShow;
import us.pinguo.camera360.shop.data.show.ShowDetail;
import us.pinguo.camera360.shop.data.show.ShowPkg;
import us.pinguo.camera360.shop.data.show.ShowScene;
import us.pinguo.camera360.shop.data.show.UnlockType;
import us.pinguo.camera360.shop.data.show.q;
import us.pinguo.camera360.shop.data.show.s;
import us.pinguo.camera360.shop.data.show.u;
import us.pinguo.camera360.shop.details.PkgDetailsView;
import us.pinguo.camera360.shop.view.details.DetailsInstallButton;
import us.pinguo.camera360.shop.view.details.DetailsLoadView;
import us.pinguo.foundation.utils.w;
import us.pinguo.ui.widget.banner.CellStandoutIndicator;
import vStudio.Android.Camera360.R;
/* compiled from: PkgDetailPresenter.java */
/* loaded from: classes4.dex */
public class h extends e {

    /* renamed from: j  reason: collision with root package name */
    private static final String f9689j = "h";
    private f b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private u f9690d;

    /* renamed from: e  reason: collision with root package name */
    private PkgDetailsView.b f9691e;

    /* renamed from: f  reason: collision with root package name */
    private Context f9692f;

    /* renamed from: g  reason: collision with root package name */
    private DetailsLoadView f9693g;

    /* renamed from: h  reason: collision with root package name */
    private ShowPkg f9694h;

    /* renamed from: i  reason: collision with root package name */
    private Long f9695i = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PkgDetailPresenter.java */
    /* loaded from: classes4.dex */
    public class a implements s {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // us.pinguo.camera360.shop.data.show.s
        public void a() {
            if (h.this.q()) {
                h.this.f9693g.d();
            }
        }

        @Override // us.pinguo.camera360.shop.data.show.s
        public void b(List<ShowScene> list) {
            if (h.this.q()) {
                ShowPkg o = h.this.o(this.a);
                if (o == null) {
                    h.this.f9693g.d();
                } else {
                    h.this.w(o, a.b.c);
                }
            }
        }

        @Override // us.pinguo.camera360.shop.data.show.s
        public void c(Exception exc) {
            if (h.this.q()) {
                h.this.f9693g.d();
            }
            String str = h.f9689j;
            us.pinguo.common.log.a.e(str, "requestShowDetail error e=" + exc.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PkgDetailPresenter.java */
    /* loaded from: classes4.dex */
    public class b implements q {
        b() {
        }

        @Override // us.pinguo.camera360.shop.data.show.q
        public void a(Exception exc) {
            if (h.this.q()) {
                h.this.f9693g.d();
            }
            String str = h.f9689j;
            us.pinguo.common.log.a.e(str, "requestShowDetail error e=" + exc.getMessage());
        }

        @Override // us.pinguo.camera360.shop.data.show.q
        public void b(ShowDetail showDetail) {
            h.this.f9693g.b();
            if (h.this.q()) {
                h.this.f9691e.f9678i = showDetail;
                h.this.A();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PkgDetailPresenter.java */
    /* loaded from: classes4.dex */
    public class c implements us.pinguo.camera360.shop.view.details.e {
        final /* synthetic */ ShowPkg a;

        c(ShowPkg showPkg) {
            this.a = showPkg;
        }

        @Override // us.pinguo.camera360.shop.view.details.e
        public void a(View view) {
            if (h.this.k(this.a) || h.this.a == null) {
                return;
            }
            int i2 = d.a[this.a.getType().ordinal()];
            if (i2 == 1) {
                a.b.o(a.b.a, this.a.getId(), FirebaseAnalytics.Event.LOGIN);
                h.this.a.Y(this.a);
                us.pinguo.foundation.statistics.h.a.I("", this.a.getId(), "login_request", "1");
            } else if (i2 == 2) {
                a.b.o(a.b.a, this.a.getId(), FirebaseAnalytics.Event.SHARE);
                h.this.a.H(this.a);
            } else if (i2 != 3) {
                us.pinguo.common.log.a.u("", "Invalid unlockType:" + this.a.getType(), new Object[0]);
            } else {
                a.b.o(a.b.a, this.a.getId(), "pay");
                h.this.a.L(this.a);
                us.pinguo.foundation.statistics.h.a.I("", this.a.getId(), "buy_request", "1");
            }
        }

        @Override // us.pinguo.camera360.shop.view.details.e
        public void b(View view) {
            g gVar = h.this.a;
            if (gVar != null) {
                gVar.m(this.a);
            }
        }

        @Override // us.pinguo.camera360.shop.view.details.e
        public void c(View view) {
            g gVar;
            if (h.this.k(this.a) || (gVar = h.this.a) == null) {
                return;
            }
            gVar.X(this.a);
            us.pinguo.foundation.statistics.h.a.I("", this.a.getId(), "use", "1");
        }

        @Override // us.pinguo.camera360.shop.view.details.e
        public void d(View view) {
            if (h.this.k(this.a)) {
                return;
            }
            a.b.o(a.b.a, this.a.getId(), "down");
            h.this.n(this.a);
        }

        @Override // us.pinguo.camera360.shop.view.details.e
        public void e(View view) {
            g gVar = h.this.a;
            if (gVar != null) {
                gVar.i(this.a);
                us.pinguo.foundation.statistics.h.a.I("", this.a.getId(), "goto_free_trial", "1");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PkgDetailPresenter.java */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class d {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[ShowPkg.Status.values().length];
            b = iArr;
            try {
                iArr[ShowPkg.Status.uninstalled.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[ShowPkg.Status.installed.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[ShowPkg.Status.installing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[ShowPkg.Status.failed.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[UnlockType.values().length];
            a = iArr2;
            try {
                iArr2[UnlockType.MEMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[UnlockType.SHARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[UnlockType.PAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[UnlockType.FREE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        PkgDetailsView.b bVar = this.f9691e;
        ShowDetail showDetail = bVar.f9678i;
        ShowPkg showPkg = bVar.f9677h;
        bVar.f9680k.setTiTleText(showPkg.getName());
        String desc = showDetail.getDesc();
        if (showDetail.getImageInfos() != null) {
            this.f9691e.a.setImageInfos(showDetail.getImageInfos(), showDetail.getOriginPic());
            if (showDetail.getImageInfos().size() > 0) {
                this.f9691e.a.setAutoScroll(true);
            }
            CellStandoutIndicator cellStandoutIndicator = this.f9691e.f9675f;
            cellStandoutIndicator.setVisibility(0);
            VdsAgent.onSetViewVisibility(cellStandoutIndicator, 0);
            PkgDetailsView.b bVar2 = this.f9691e;
            bVar2.f9675f.setCellCount(bVar2.a.i());
        } else {
            CellStandoutIndicator cellStandoutIndicator2 = this.f9691e.f9675f;
            cellStandoutIndicator2.setVisibility(8);
            VdsAgent.onSetViewVisibility(cellStandoutIndicator2, 8);
            this.f9691e.a.p();
        }
        this.f9691e.a.requestLayout();
        float f2 = this.f9691e.f9675f.getResources().getDisplayMetrics().density;
        this.f9691e.f9675f.setCellColor(-2131824914, -1);
        this.f9691e.f9675f.setGapWidth((int) (4.0f * f2));
        this.f9691e.f9675f.setCellSize((int) (5.0f * f2), (int) (f2 * 10.0f));
        this.f9691e.f9673d.setText(desc);
        z(showPkg);
        DetailsInstallButton detailsInstallButton = this.f9691e.c;
        detailsInstallButton.setVisibility(0);
        VdsAgent.onSetViewVisibility(detailsInstallButton, 0);
        this.f9691e.c.setOnInstallBtnClickListener(new c(showPkg));
    }

    private void j(String str) {
        if (this.f9690d == null) {
            this.f9690d = u.b();
        }
        ShowPkg o = o(str);
        if (o == null) {
            this.f9693g.e();
            if (this.f9690d.r(new a(str), true)) {
                return;
            }
            this.f9693g.d();
            return;
        }
        w(o, a.b.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k(ShowPkg showPkg) {
        if (showPkg.getPackageType() != FilterType.Loc || us.pinguo.camera360.loc.c.f()) {
            return false;
        }
        Toast makeText = Toast.makeText(this.f9692f, (int) R.string.loc_invalid, 0);
        makeText.show();
        VdsAgent.showToast(makeText);
        return true;
    }

    private void l(ShowPkg showPkg) {
        this.f9693g.b();
        this.f9691e.f9677h = showPkg;
        if (this.f9690d == null) {
            this.f9690d = u.b();
        }
        ShowDetail n = this.f9690d.n(showPkg.getId());
        if (n == null) {
            this.f9693g.e();
            this.f9690d.m(showPkg.getId(), new b());
            return;
        }
        this.f9691e.f9678i = n;
        A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(ShowPkg showPkg) {
        if (this.a == null) {
            return;
        }
        if (us.pinguo.util.q.f(this.f9692f)) {
            this.a.c0(showPkg);
            return;
        }
        Toast makeText = Toast.makeText(this.f9692f, (int) R.string.download_not_network, 0);
        makeText.show();
        VdsAgent.showToast(makeText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ShowPkg o(String str) {
        ShowPkg h2 = this.f9690d.h(str);
        return h2 == null ? this.f9690d.i(str) : h2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public /* synthetic */ void s(ShowPkg showPkg, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        if (i2 == -1) {
            a.b.j(a.b.a, showPkg.getId(), this.c);
            if (us.pinguo.camera360.shop.data.i.e().l(FilterType.Effect).size() > 1) {
                g gVar = this.a;
                if (gVar != null) {
                    gVar.l(showPkg);
                    return;
                }
                return;
            }
            Context context = this.f9692f;
            Toast makeText = Toast.makeText(context, context.getString(R.string.store_manager_uninstall_tips), 0);
            makeText.show();
            VdsAgent.showToast(makeText);
            return;
        }
        a.b.k(a.b.a, showPkg.getId(), this.c);
    }

    private void z(ShowPkg showPkg) {
        String string;
        this.f9694h = showPkg;
        if (this.f9690d == null) {
            this.f9690d = u.b();
        }
        boolean j2 = this.f9690d.j(showPkg);
        if (showPkg.isVipLabelVisible()) {
            View view = this.f9691e.f9681l;
            view.setVisibility(0);
            VdsAgent.onSetViewVisibility(view, 0);
        } else {
            View view2 = this.f9691e.f9681l;
            view2.setVisibility(8);
            VdsAgent.onSetViewVisibility(view2, 8);
        }
        if (showPkg.isFreeLabelVisible()) {
            View view3 = this.f9691e.m;
            view3.setVisibility(0);
            VdsAgent.onSetViewVisibility(view3, 0);
        } else {
            View view4 = this.f9691e.m;
            view4.setVisibility(8);
            VdsAgent.onSetViewVisibility(view4, 8);
        }
        boolean isVipLabelVisible = showPkg.isVipLabelVisible();
        ShowPkg.Status j3 = FilterOperateManager.h().j(showPkg.getId());
        int i2 = d.b[j3.ordinal()];
        String str = "";
        if (i2 == 1) {
            boolean z = isVipLabelVisible && VipManager.a.e(true);
            if (!j2 && !z) {
                int color = this.f9692f.getResources().getColor(R.color.color_999999);
                int i3 = d.a[showPkg.getType().ordinal()];
                if (i3 == 1 || i3 == 2) {
                    this.f9691e.n.setText(this.f9692f.getString(R.string.store_item_unlock));
                    TextView textView = this.f9691e.n;
                    textView.setPaintFlags(textView.getPaintFlags() | 16);
                } else if (i3 == 3) {
                    this.f9691e.n.setText(showPkg.getPayInfo().price);
                    TextView textView2 = this.f9691e.n;
                    textView2.setPaintFlags(textView2.getPaintFlags() | 16);
                } else if (i3 != 4) {
                    us.pinguo.common.log.a.u("", "Invalid unlockType:" + showPkg.getType(), new Object[0]);
                } else {
                    this.f9691e.n.setText(this.f9692f.getString(R.string.store_pkg_free));
                    TextView textView3 = this.f9691e.n;
                    textView3.setPaintFlags(textView3.getPaintFlags() & (-17));
                }
                this.f9691e.c.setState(isVipLabelVisible, 1, this.f9692f.getString(R.string.free_download));
                this.f9691e.n.setTextColor(color);
            } else {
                int color2 = this.f9692f.getResources().getColor(R.color.color_9d5fff);
                int i4 = d.a[showPkg.getType().ordinal()];
                if (i4 == 1) {
                    str = this.f9692f.getString(R.string.cs_login);
                    string = this.f9692f.getString(R.string.store_item_unlock);
                } else if (i4 != 2) {
                    if (i4 == 3) {
                        str = showPkg.getPayInfo().price;
                        if (z) {
                            str = this.f9692f.getString(R.string.filter_buy_and_unlock);
                            string = str;
                        }
                    } else if (i4 != 4) {
                        us.pinguo.common.log.a.u("", "Invalid unlockType:" + showPkg.getType(), new Object[0]);
                    } else {
                        str = this.f9692f.getString(R.string.store_pkg_free);
                        color2 = this.f9692f.getResources().getColor(R.color.color_999999);
                    }
                    string = str;
                } else {
                    str = this.f9692f.getString(R.string.pgcommon_share);
                    string = this.f9692f.getString(R.string.store_item_unlock);
                }
                this.f9691e.c.setState(isVipLabelVisible, 8, str);
                this.f9691e.n.setText(string);
                if (VipManager.a.e(true)) {
                    TextView textView4 = this.f9691e.n;
                    textView4.setPaintFlags(textView4.getPaintFlags() | 16);
                    color2 = this.f9692f.getResources().getColor(R.color.color_999999);
                } else {
                    TextView textView5 = this.f9691e.n;
                    textView5.setPaintFlags(textView5.getPaintFlags() & (-17));
                }
                this.f9691e.n.setTextColor(color2);
            }
            this.f9691e.f9674e.setVisibility(4);
        } else if (i2 != 2) {
            if (i2 == 3) {
                this.f9691e.f9674e.setVisibility(4);
                this.f9691e.c.setState(isVipLabelVisible, 4, this.f9692f.getString(R.string.store_pkg_details_downloading));
            } else if (i2 != 4) {
                us.pinguo.common.log.a.u("", "Invalid state:" + j3, new Object[0]);
            } else {
                this.f9691e.f9674e.setVisibility(4);
                if (showPkg.getType() == UnlockType.PAY) {
                    this.f9691e.c.setState(isVipLabelVisible, 1, this.f9692f.getString(R.string.store_pkg_download));
                } else {
                    this.f9691e.c.setState(isVipLabelVisible, 1, this.f9692f.getString(R.string.store_pkg_free));
                }
            }
        } else {
            int i5 = d.a[showPkg.getType().ordinal()];
            if (i5 == 1 || i5 == 2) {
                this.f9691e.n.setText(this.f9692f.getString(R.string.store_item_unlock));
                TextView textView6 = this.f9691e.n;
                textView6.setPaintFlags(textView6.getPaintFlags() | 16);
            } else if (i5 == 3) {
                this.f9691e.n.setText(showPkg.getPayInfo().price);
                TextView textView7 = this.f9691e.n;
                textView7.setPaintFlags(textView7.getPaintFlags() | 16);
            } else if (i5 != 4) {
                us.pinguo.common.log.a.u("", "Invalid unlockType:" + showPkg.getType(), new Object[0]);
            } else {
                this.f9691e.n.setText(this.f9692f.getString(R.string.store_pkg_free));
                TextView textView8 = this.f9691e.n;
                textView8.setPaintFlags(textView8.getPaintFlags() & (-17));
            }
            this.f9691e.f9674e.setVisibility(4);
            VipManager vipManager = VipManager.a;
            boolean e2 = vipManager.e(true);
            if (isVipLabelVisible && !e2 && showPkg.getType() == UnlockType.PAY && j2) {
                this.f9691e.c.setState(isVipLabelVisible, 8, this.f9692f.getString(R.string.filter_buy_and_unlock));
                TextView textView9 = this.f9691e.n;
                textView9.setPaintFlags(textView9.getPaintFlags() & (-17));
                this.f9691e.n.setTextColor(this.f9692f.getResources().getColor(R.color.color_9d5fff));
            } else if (!vipManager.e(true) && j2) {
                this.f9691e.n.setTextColor(this.f9692f.getResources().getColor(R.color.color_9d5fff));
                TextView textView10 = this.f9691e.n;
                textView10.setPaintFlags(textView10.getPaintFlags() & (-17));
                this.f9691e.c.setState(isVipLabelVisible, 8, showPkg.getPayInfo().price);
            } else {
                this.f9691e.n.setTextColor(this.f9692f.getResources().getColor(R.color.color_999999));
                if (isVipLabelVisible) {
                    TextView textView11 = this.f9691e.n;
                    textView11.setPaintFlags(textView11.getPaintFlags() | 16);
                } else {
                    TextView textView12 = this.f9691e.n;
                    textView12.setPaintFlags(textView12.getPaintFlags() & (-17));
                }
                this.f9691e.c.setState(isVipLabelVisible, 2, this.f9692f.getString(R.string.str_use));
            }
        }
    }

    public void B() {
        ShowPkg showPkg = this.f9694h;
        if (showPkg != null) {
            z(showPkg);
            this.f9691e.c.f();
        }
    }

    public void i(us.pinguo.foundation.p.b bVar) {
        f fVar = (f) bVar;
        this.b = fVar;
        this.f9692f = fVar.getContext();
        PkgDetailsView.b bVar2 = (PkgDetailsView.b) this.b.b();
        this.f9691e = bVar2;
        this.f9693g = bVar2.b();
    }

    public void m() {
        this.b = null;
        this.f9691e.c();
        this.f9691e = null;
        this.a = null;
    }

    public void p(String str) {
        a.b.n(a.b.a, str, this.c);
        j(str);
        this.b.a();
    }

    public boolean q() {
        f fVar = this.b;
        return fVar != null && fVar.isShowing();
    }

    public void t(View view) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.onDetailViewCloseClick(view);
        }
    }

    public void u(final ShowPkg showPkg) {
        String format = String.format(this.f9692f.getString(R.string.delete_effect_package_sure), showPkg.getName());
        Context context = this.f9692f;
        w.h(context, context.getString(R.string.cs_tips), format, this.f9692f.getString(R.string.dialog_sure), this.f9692f.getString(R.string.dialog_cancel), new DialogInterface.OnClickListener() { // from class: us.pinguo.camera360.shop.details.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                h.this.s(showPkg, dialogInterface, i2);
            }
        });
    }

    public void v(View view, boolean z) {
        if (z && this.f9695i == null) {
            this.f9695i = Long.valueOf(System.currentTimeMillis());
        } else if (z || this.f9695i == null) {
        } else {
            long currentTimeMillis = System.currentTimeMillis() - this.f9695i.longValue();
            this.f9695i = null;
            ShowPkg showPkg = this.f9694h;
            if (showPkg != null) {
                us.pinguo.foundation.statistics.h.a.I(k.c(showPkg), this.f9694h.getId(), "show", String.valueOf(currentTimeMillis));
            }
        }
    }

    public void w(BaseShow baseShow, String str) {
        this.c = str;
        if (baseShow == null) {
            return;
        }
        if (baseShow instanceof ShowPkg) {
            ShowPkg showPkg = (ShowPkg) baseShow;
            a.b.n(a.b.a, showPkg.getId(), this.c);
            l(showPkg);
            this.b.a();
            return;
        }
        throw new IllegalArgumentException("baseShow must be instance of ShowTopic");
    }

    public void x(ShowPkg showPkg) {
        us.pinguo.common.log.a.c(f9689j, "pkg details unlocked");
        A();
        if (showPkg != null) {
            if (showPkg.getType() == UnlockType.MEMBER) {
                us.pinguo.foundation.statistics.h.a.I("", showPkg.getId(), "login_success", "1");
            } else if (showPkg.getType() == UnlockType.PAY) {
                us.pinguo.foundation.statistics.h.a.I("", showPkg.getId(), "buy_success", "1");
            }
        }
    }

    public void y(String str, int i2) {
        PkgDetailsView.b bVar;
        ShowPkg showPkg;
        if (TextUtils.isEmpty(str) || (showPkg = (bVar = this.f9691e).f9677h) == null || bVar.f9678i == null || !str.equals(showPkg.getId())) {
            return;
        }
        if (i2 > 0 && i2 < 100) {
            this.f9691e.f9674e.setVisibility(4);
            this.f9691e.c.setState(showPkg.isVipLabelVisible(), 4, this.f9692f.getString(R.string.store_pkg_details_downloading));
            this.f9691e.c.setProgress(i2);
            return;
        }
        z(showPkg);
    }
}
