package us.pinguo.camera360.shop.data.show;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import com.android.volley.Request;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.JsonSyntaxException;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.k.b.a;
import com.pinguo.camera360.newShop.model.StoreHistoryNew;
import com.pinguo.camera360.newShop.model.StoreOrder;
import com.pinguo.camera360.newShop.model.StoreOrderItem;
import com.pinguo.lib.GsonUtilKt;
import java.io.File;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import rx.Subscription;
import rx.functions.Action1;
import us.pinguo.camera360.shop.data.share.ShareInfoManager;
import us.pinguo.camera360.shop.download.BaseDownloader;
import us.pinguo.camera360.shop.manager.ExceptionStatManager;
import us.pinguo.camera360.shop.manager.IPayCenter;
import us.pinguo.camera360.shop.manager.t0;
import us.pinguo.foundation.utils.AsyncTask;
import us.pinguo.foundation.utils.a0;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.paylibcenter.bean.PayResult;
import us.pinguo.user.User;
import us.pinguo.user.v0;
import vStudio.Android.Camera360.R;
/* loaded from: classes4.dex */
public class UnlockManager implements t0 {

    /* renamed from: k  reason: collision with root package name */
    private static final String f9625k = "UnlockManager";

    /* renamed from: l  reason: collision with root package name */
    private static final UnlockManager f9626l = new UnlockManager();
    private static final byte[] m = new byte[0];

    /* renamed from: d  reason: collision with root package name */
    private List<String> f9627d;

    /* renamed from: e  reason: collision with root package name */
    private Subscription f9628e;

    /* renamed from: f  reason: collision with root package name */
    private ShowPkg f9629f;

    /* renamed from: j  reason: collision with root package name */
    private com.pinguo.camera360.l.a.a f9633j;
    private h c = null;

    /* renamed from: h  reason: collision with root package name */
    private StoreHistoryNew f9631h = null;

    /* renamed from: i  reason: collision with root package name */
    private IPayCenter f9632i = null;
    private Context a = BaseApplication.d();
    private ShareInfoManager b = ShareInfoManager.getInstance();

    /* renamed from: g  reason: collision with root package name */
    private SharedPreferences f9630g = this.a.getSharedPreferences("effect_unlocked", 0);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends AsyncTask<Void, Void, String> {
        final /* synthetic */ int a;
        final /* synthetic */ g b;

        a(int i2, g gVar) {
            this.a = i2;
            this.b = gVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.foundation.utils.AsyncTask
        /* renamed from: a */
        public String doInBackground(Void... voidArr) {
            try {
                UnlockManager.this.f9633j = new com.pinguo.camera360.l.a.a(BaseApplication.d(), this.a);
                String str = UnlockManager.this.f9633j.get();
                String str2 = UnlockManager.f9625k;
                us.pinguo.common.log.a.m(str2, "String: " + str, new Object[0]);
                return str;
            } catch (Exception e2) {
                us.pinguo.common.log.a.f(e2);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.foundation.utils.AsyncTask
        /* renamed from: b */
        public void onPostExecute(String str) {
            if (UnlockManager.this.f9633j == null || UnlockManager.this.f9633j.e() == null) {
                return;
            }
            UnlockManager unlockManager = UnlockManager.this;
            unlockManager.n(unlockManager.f9633j.e(), str, this.b, this.a);
            UnlockManager.this.f9633j = null;
        }
    }

    /* loaded from: classes4.dex */
    class b implements Runnable {
        final /* synthetic */ ShowTopic a;
        final /* synthetic */ ShowPkg b;

        b(ShowTopic showTopic, ShowPkg showPkg) {
            this.a = showTopic;
            this.b = showPkg;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a == null) {
                us.pinguo.common.log.a.m("paycenter", "paySuccess " + a.b.a, new Object[0]);
                a.b.h(a.b.a, this.b.getId(), null);
                UnlockManager.this.H(this.b);
                UnlockManager.this.M(this.b);
                return;
            }
            us.pinguo.common.log.a.m("paycenter", "paySuccess " + a.b.b, new Object[0]);
            a.b.h(a.b.b, this.a.getId(), this.b.getId());
            UnlockManager.this.G(this.a.getId());
            UnlockManager.this.M(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements DialogInterface.OnClickListener {
        final /* synthetic */ Activity a;
        final /* synthetic */ int b;
        final /* synthetic */ ShowPkg c;

        c(Activity activity, int i2, ShowPkg showPkg) {
            this.a = activity;
            this.b = i2;
            this.c = showPkg;
        }

        @Override // android.content.DialogInterface.OnClickListener
        @Instrumented
        public void onClick(DialogInterface dialogInterface, int i2) {
            VdsAgent.onClick(this, dialogInterface, i2);
            if (i2 == -2) {
                UnlockManager.this.L(this.c);
                dialogInterface.dismiss();
            } else if (i2 != -1) {
            } else {
                a.f.c(1);
                a.e.b(2);
                v0.h(this.a, 1, this.b, us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER);
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements us.pinguo.camera360.shop.data.share.d {
        d() {
        }

        @Override // us.pinguo.camera360.shop.data.share.d
        public void a(ShowPkg showPkg) {
            UnlockManager.this.H(showPkg);
            UnlockManager.this.M(showPkg);
        }

        @Override // us.pinguo.camera360.shop.data.share.d
        public void b(ShowPkg showPkg) {
            UnlockManager.this.L(showPkg);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements us.pinguo.camera360.shop.data.share.c {
        final /* synthetic */ AlertDialog a;
        final /* synthetic */ ShowPkg b;
        final /* synthetic */ Activity c;

        e(AlertDialog alertDialog, ShowPkg showPkg, Activity activity) {
            this.a = alertDialog;
            this.b = showPkg;
            this.c = activity;
        }

        @Override // us.pinguo.camera360.shop.data.share.c
        public void a(Exception exc) {
            this.a.dismiss();
            Toast makeText = Toast.makeText(UnlockManager.this.a, (int) R.string.share_callback_msg_error, 0);
            makeText.show();
            VdsAgent.showToast(makeText);
            UnlockManager.this.L(this.b);
        }

        @Override // us.pinguo.camera360.shop.data.share.c
        public void b(us.pinguo.camera360.shop.data.share.f fVar) {
            this.a.dismiss();
            UnlockManager.this.J(this.b, this.c, fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class f {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[UnlockType.values().length];
            a = iArr;
            try {
                iArr[UnlockType.MEMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[UnlockType.SHARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[UnlockType.PAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface g {
        void R(String str);

        void b0();

        void h0();
    }

    /* loaded from: classes4.dex */
    public interface h {
        void a(BaseShow baseShow);

        void b(BaseShow baseShow);
    }

    private UnlockManager() {
    }

    private StoreHistoryNew A(Request request, String str) {
        try {
            return (StoreHistoryNew) GsonUtilKt.getCachedGson().j(str, StoreHistoryNew.class);
        } catch (JsonSyntaxException e2) {
            ExceptionStatManager.getInstance().f(request, e2.getMessage());
            return null;
        }
    }

    private void B(ShowPkg showPkg, Activity activity) {
        String shareId = showPkg.getShareId();
        us.pinguo.camera360.shop.data.share.f h2 = this.b.h(shareId);
        if (h2 != null && h2.b() != null && h2.b().length != 0) {
            J(showPkg, activity, h2);
            return;
        }
        AlertDialog p = us.pinguo.foundation.utils.w.p(activity, -999);
        p.setCancelable(false);
        p.setCanceledOnTouchOutside(false);
        p.show();
        VdsAgent.showDialog(p);
        this.b.i(shareId, new e(p, showPkg, activity));
    }

    private void C() {
        Subscription subscription = this.f9628e;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.f9628e = us.pinguo.foundation.r.d.a().c(us.pinguo.foundation.r.b.class).subscribe(new Action1() { // from class: us.pinguo.camera360.shop.data.show.m
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                UnlockManager.this.v((us.pinguo.foundation.r.b) obj);
            }
        }, n.a);
    }

    private void E(Request request, String str, boolean z, StoreHistoryNew storeHistoryNew) {
        try {
            String str2 = BaseApplication.d().getFilesDir().getAbsolutePath() + "/shop/";
            List<StoreOrderItem> q = q(p());
            if (storeHistoryNew.data == null) {
                if (z) {
                    this.f9631h = null;
                    String str3 = str2 + "shopOrder.json";
                    File file = new File(str3);
                    File file2 = new File(str2 + "shopOrderStickerList.json");
                    if (file.exists()) {
                        file.delete();
                    }
                    if (file2.exists()) {
                        file2.delete();
                    }
                    us.pinguo.util.k.i(str3, str.getBytes("utf-8"));
                    return;
                }
                return;
            }
            if (!q.isEmpty() && !z) {
                StoreHistoryNew A = A(request, str);
                if (q(A).size() > 0) {
                    A.data.lists.addAll(q);
                    us.pinguo.util.k.i(str2 + "shopOrder.json", GsonUtilKt.getCachedGson().s(A).getBytes("utf-8"));
                    return;
                }
                return;
            }
            this.f9631h = null;
            String str4 = str2 + "shopOrder.json";
            File file3 = new File(str4);
            File file4 = new File(str2 + "shopOrderStickerList.json");
            if (file3.exists()) {
                file3.delete();
            }
            if (file4.exists()) {
                file4.delete();
            }
            us.pinguo.util.k.i(str4, str.getBytes("utf-8"));
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
        }
    }

    private void F(List<StoreOrderItem> list) {
        for (StoreOrderItem storeOrderItem : list) {
            if (storeOrderItem != null) {
                G(storeOrderItem.productId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(ShowPkg showPkg, Activity activity, us.pinguo.camera360.shop.data.share.f fVar) {
        us.pinguo.camera360.shop.data.share.e.a(activity, showPkg, fVar, new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(BaseShow baseShow) {
        h hVar = this.c;
        if (hVar != null) {
            hVar.a(baseShow);
        }
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(BaseShow baseShow) {
        h hVar = this.c;
        if (hVar != null) {
            hVar.b(baseShow);
        }
        this.c = null;
    }

    public static UnlockManager getInstance() {
        return f9626l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Request request, String str, g gVar, int i2) {
        if (str == null) {
            gVar.h0();
            return;
        }
        boolean z = i2 == 0;
        StoreHistoryNew A = A(request, str);
        if (A == null) {
            gVar.h0();
            return;
        }
        int i3 = A.status;
        if (i3 != 200) {
            if (i3 != 10220) {
                ExceptionStatManager.getInstance().g(request, Integer.valueOf(A.status));
                gVar.h0();
                return;
            }
            E(request, str, z, A);
            gVar.b0();
            return;
        }
        StoreOrder storeOrder = A.data;
        if (storeOrder != null) {
            us.pinguo.foundation.base.e.f(BaseApplication.d(), "pref_key_newshop_order_version", storeOrder.version);
            ArrayList arrayList = new ArrayList(A.data.lists);
            if (arrayList.size() == 0) {
                if (p() == null) {
                    E(request, str, z, A);
                }
            } else if (arrayList.size() > 0) {
                F(arrayList);
                E(request, str, z, A);
            }
            this.f9631h = A;
            gVar.R(str);
            return;
        }
        gVar.h0();
    }

    private synchronized IPayCenter o() {
        IPayCenter iPayCenter = this.f9632i;
        if (iPayCenter != null) {
            return iPayCenter;
        }
        try {
            this.f9632i = (IPayCenter) a0.b(Class.forName("us.pinguo.camera360.shop.manager.s0"), "getInstance");
        } catch (Throwable unused) {
        }
        return this.f9632i;
    }

    private List<StoreOrderItem> q(StoreHistoryNew storeHistoryNew) {
        StoreOrder storeOrder;
        List<StoreOrderItem> list;
        ArrayList arrayList = new ArrayList();
        if (storeHistoryNew != null && (storeOrder = storeHistoryNew.data) != null && (list = storeOrder.lists) != null) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    private StoreHistoryNew r(String str, Object obj) throws Exception {
        Reader reader = null;
        try {
            reader = new BaseDownloader(BaseApplication.d()).c(str, obj);
            StoreHistoryNew storeHistoryNew = (StoreHistoryNew) GsonUtilKt.getCachedGson().h(reader, StoreHistoryNew.class);
            us.pinguo.util.f.a(reader);
            return storeHistoryNew;
        } catch (Throwable th) {
            us.pinguo.util.f.a(reader);
            throw th;
        }
    }

    private List<String> s() {
        ArrayList arrayList = new ArrayList();
        try {
            Map<String, ?> all = this.f9630g.getAll();
            if (all != null) {
                for (String str : all.keySet()) {
                    if (((Boolean) all.get(str)).booleanValue()) {
                        arrayList.add(str);
                    }
                }
            }
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public /* synthetic */ void v(us.pinguo.foundation.r.b bVar) {
        if (bVar.a != null) {
            M(this.f9629f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void w(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
    }

    private boolean z(ShowTopic showTopic) {
        UnlockType unlockType = showTopic.getUnlockType();
        if (User.d().r(false).d() || unlockType == UnlockType.FREE) {
            return false;
        }
        if (unlockType == UnlockType.MEMBER) {
            return !User.d().n();
        }
        if (unlockType == UnlockType.PAY) {
            return !t(showTopic.getId());
        }
        if (unlockType == UnlockType.SHARE) {
            return !t(showTopic.getId());
        }
        return false;
    }

    public void D() {
        this.c = null;
        List<String> list = this.f9627d;
        if (list != null) {
            list.clear();
            this.f9627d = null;
        }
        Subscription subscription = this.f9628e;
        if (subscription != null) {
            subscription.unsubscribe();
            this.f9628e = null;
        }
        this.f9629f = null;
    }

    public boolean G(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            SharedPreferences.Editor edit = this.f9630g.edit();
            edit.putBoolean(str, true);
            if (edit.commit()) {
                if (this.f9627d == null) {
                    this.f9627d = s();
                }
                this.f9627d.add(str);
            }
            return true;
        } catch (Exception e2) {
            us.pinguo.common.log.a.g(f9625k, "set show pkg unlocked fail!", new Object[0]);
            us.pinguo.common.log.a.f(e2);
            return false;
        }
    }

    public boolean H(ShowPkg showPkg) {
        return G(showPkg.getId());
    }

    public void I(ShowPkg showPkg, int i2, Activity activity) {
        us.pinguo.foundation.utils.w.g(activity, -999, R.string.store_effect_install_dialog_msg, R.string.cs_login, R.string.dialog_cancel, new c(activity, i2, showPkg));
    }

    public void K(ShowPkg showPkg, h hVar, Activity activity) {
        if (!x(showPkg)) {
            hVar.b(showPkg);
            return;
        }
        this.c = hVar;
        int i2 = f.a[showPkg.getType().ordinal()];
        if (i2 == 1) {
            this.f9629f = showPkg;
            C();
            I(showPkg, 0, activity);
            us.pinguo.foundation.statistics.h.a.f(showPkg.getId(), FirebaseAnalytics.Event.LOGIN);
        } else if (i2 == 2) {
            B(showPkg, activity);
            us.pinguo.foundation.statistics.h.a.f(showPkg.getId(), FirebaseAnalytics.Event.SHARE);
        } else if (i2 != 3) {
        } else {
            o();
            IPayCenter iPayCenter = this.f9632i;
            if (iPayCenter != null) {
                iPayCenter.a(activity, showPkg, this);
            }
            us.pinguo.foundation.statistics.h.a.f(showPkg.getId(), "buy");
        }
    }

    public void N(int i2, g gVar) {
        us.pinguo.foundation.base.e.f(BaseApplication.d(), "pref_key_newshop_order_version", i2);
        if (this.f9633j != null) {
            gVar.h0();
        } else {
            new a(i2, gVar).execute(new Void[0]);
        }
    }

    @Override // us.pinguo.camera360.shop.manager.t0
    public void d(PayResult payResult) {
    }

    @Override // us.pinguo.camera360.shop.manager.t0
    public void e(PayResult payResult) {
    }

    @Override // us.pinguo.camera360.shop.manager.t0
    public void f(ShowTopic showTopic, ShowPkg showPkg) {
        if (showTopic == null) {
            L(showPkg);
        } else {
            L(showTopic);
        }
    }

    @Override // us.pinguo.camera360.shop.manager.t0
    public void g(PayResult payResult) {
    }

    @Override // us.pinguo.camera360.shop.manager.t0
    public void h(ShowTopic showTopic, ShowPkg showPkg) {
        us.pinguo.foundation.utils.f.c(new b(showTopic, showPkg));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized StoreHistoryNew p() {
        StoreOrder storeOrder;
        List<StoreOrderItem> list;
        try {
            if (this.f9631h == null) {
                String str = (BaseApplication.d().getFilesDir().getAbsolutePath() + "/shop/") + "shopOrder.json";
                if (new File(str).exists()) {
                    synchronized (m) {
                        try {
                            this.f9631h = r(InspirePublishFragment.FILE_HEADER + str, null);
                        } catch (Exception e2) {
                            us.pinguo.common.log.a.f(e2);
                            this.f9631h = null;
                        }
                    }
                }
            }
            StoreHistoryNew storeHistoryNew = this.f9631h;
            if (storeHistoryNew == null) {
                return new StoreHistoryNew();
            }
            int i2 = storeHistoryNew.status;
            if (i2 == 10220) {
                return new StoreHistoryNew();
            }
            if (i2 == 200 && ((storeOrder = storeHistoryNew.data) == null || (list = storeOrder.lists) == null || list.size() == 0)) {
                return new StoreHistoryNew();
            }
            return this.f9631h;
        } catch (Exception e3) {
            us.pinguo.common.log.a.f(e3);
            return null;
        }
    }

    public boolean t(String str) {
        if (this.f9627d == null) {
            this.f9627d = s();
        }
        return this.f9627d.contains(str);
    }

    public boolean x(BaseShow baseShow) {
        if (baseShow instanceof ShowPkg) {
            return y((ShowPkg) baseShow);
        }
        if (baseShow instanceof ShowTopic) {
            return z((ShowTopic) baseShow);
        }
        throw new IllegalArgumentException("base show must be showPkg or showTopic");
    }

    public boolean y(ShowPkg showPkg) {
        UnlockType type = showPkg.getType();
        if (User.d().r(false).d() || type == UnlockType.FREE) {
            return false;
        }
        if (type == UnlockType.MEMBER) {
            return !User.d().n();
        }
        if (type == UnlockType.PAY) {
            return !t(showPkg.getId());
        }
        if (type == UnlockType.SHARE) {
            return !t(showPkg.getId());
        }
        return false;
    }
}
