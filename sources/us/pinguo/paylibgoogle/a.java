package us.pinguo.paylibgoogle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsParams;
import com.android.billingclient.api.SkuDetailsResponseListener;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.paylibcenter.PayCallback;
import us.pinguo.paylibcenter.PayHelp;
import us.pinguo.paylibcenter.bean.PayResult;
import us.pinguo.paylibcenter.h;
/* compiled from: GoogleIapHelp.java */
/* loaded from: classes5.dex */
public class a implements h, PurchasesUpdatedListener, ConsumeResponseListener {
    private static int n = 5000;

    /* renamed from: e  reason: collision with root package name */
    private PayHelp.i f11604e;

    /* renamed from: f  reason: collision with root package name */
    private BillingClient f11605f;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList f11607h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList f11608i;
    private boolean a = false;
    private PayCallback b = null;
    private Context c = null;

    /* renamed from: d  reason: collision with root package name */
    private PayHelp.PAYWAY f11603d = PayHelp.PAYWAY.GooglePay;

    /* renamed from: g  reason: collision with root package name */
    private Handler f11606g = new Handler(Looper.getMainLooper());

    /* renamed from: j  reason: collision with root package name */
    private List<SkuDetails> f11609j = null;

    /* renamed from: k  reason: collision with root package name */
    private List<SkuDetails> f11610k = null;

    /* renamed from: l  reason: collision with root package name */
    private int f11611l = 0;
    private BillingClientStateListener m = new C0424a();

    /* compiled from: GoogleIapHelp.java */
    /* renamed from: us.pinguo.paylibgoogle.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C0424a implements BillingClientStateListener {
        C0424a() {
        }

        @Override // com.android.billingclient.api.BillingClientStateListener
        public void onBillingServiceDisconnected() {
            a.this.a = false;
            a.this.f11605f.startConnection(a.this.m);
        }

        @Override // com.android.billingclient.api.BillingClientStateListener
        public void onBillingSetupFinished(BillingResult billingResult) {
            if (billingResult.getResponseCode() == 0) {
                a.this.a = true;
                a.this.B();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GoogleIapHelp.java */
    /* loaded from: classes5.dex */
    public class b implements SkuDetailsResponseListener {
        b() {
        }

        @Override // com.android.billingclient.api.SkuDetailsResponseListener
        public void onSkuDetailsResponse(BillingResult billingResult, List<SkuDetails> list) {
            a.this.f11610k = list;
            a.q(a.this);
            if (a.this.f11604e == null || a.this.f11611l != 0) {
                return;
            }
            a.this.f11604e.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GoogleIapHelp.java */
    /* loaded from: classes5.dex */
    public class c implements SkuDetailsResponseListener {
        c() {
        }

        @Override // com.android.billingclient.api.SkuDetailsResponseListener
        public void onSkuDetailsResponse(BillingResult billingResult, List<SkuDetails> list) {
            a.this.f11609j = list;
            a.q(a.this);
            if (a.this.f11604e == null || a.this.f11611l != 0) {
                return;
            }
            a.this.f11604e.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GoogleIapHelp.java */
    /* loaded from: classes5.dex */
    public class d implements AcknowledgePurchaseResponseListener {
        final /* synthetic */ Purchase a;

        /* compiled from: GoogleIapHelp.java */
        /* renamed from: us.pinguo.paylibgoogle.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class RunnableC0425a implements Runnable {
            RunnableC0425a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = d.this;
                a.this.v(dVar.a);
            }
        }

        d(Purchase purchase) {
            this.a = purchase;
        }

        @Override // com.android.billingclient.api.AcknowledgePurchaseResponseListener
        public void onAcknowledgePurchaseResponse(BillingResult billingResult) {
            if (billingResult.getResponseCode() != 0) {
                a.this.f11606g.postDelayed(new RunnableC0425a(), a.n);
            }
        }
    }

    /* compiled from: GoogleIapHelp.java */
    /* loaded from: classes5.dex */
    class e implements Runnable {
        final /* synthetic */ String a;

        e(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f11605f == null) {
                return;
            }
            a.this.f11605f.consumeAsync(ConsumeParams.newBuilder().setPurchaseToken(this.a).build(), a.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GoogleIapHelp.java */
    /* loaded from: classes5.dex */
    public class f implements SkuDetailsResponseListener {
        final /* synthetic */ boolean a;
        final /* synthetic */ Activity b;
        final /* synthetic */ String c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f11612d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ PayCallback f11613e;

        f(boolean z, Activity activity, String str, int i2, PayCallback payCallback) {
            this.a = z;
            this.b = activity;
            this.c = str;
            this.f11612d = i2;
            this.f11613e = payCallback;
        }

        @Override // com.android.billingclient.api.SkuDetailsResponseListener
        public void onSkuDetailsResponse(BillingResult billingResult, List<SkuDetails> list) {
            if (this.a) {
                a.this.f11610k = list;
            } else {
                a.this.f11609j = list;
            }
            a.this.e(this.b, this.c, this.a, this.f11612d, this.f11613e);
        }
    }

    private void A(Activity activity, String str, boolean z, int i2, PayCallback payCallback) {
        ArrayList arrayList;
        if (z) {
            arrayList = this.f11608i;
        } else {
            arrayList = this.f11607h;
        }
        arrayList.add(str);
        SkuDetailsParams.Builder newBuilder = SkuDetailsParams.newBuilder();
        newBuilder.setSkusList(arrayList);
        if (z) {
            newBuilder.setType("subs");
        } else {
            newBuilder.setType(BillingClient.SkuType.INAPP);
        }
        this.f11605f.querySkuDetailsAsync(newBuilder.build(), new f(z, activity, str, i2, payCallback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        this.f11611l = 0;
        ArrayList arrayList = this.f11608i;
        if (arrayList != null && arrayList.size() != 0) {
            this.f11611l++;
            SkuDetailsParams.Builder newBuilder = SkuDetailsParams.newBuilder();
            newBuilder.setSkusList(this.f11608i);
            newBuilder.setType("subs");
            this.f11605f.querySkuDetailsAsync(newBuilder.build(), new b());
        }
        ArrayList arrayList2 = this.f11607h;
        if (arrayList2 == null || arrayList2.size() == 0) {
            return;
        }
        this.f11611l++;
        SkuDetailsParams.Builder newBuilder2 = SkuDetailsParams.newBuilder();
        newBuilder2.setSkusList(this.f11607h);
        newBuilder2.setType(BillingClient.SkuType.INAPP);
        this.f11605f.querySkuDetailsAsync(newBuilder2.build(), new c());
    }

    static /* synthetic */ int q(a aVar) {
        int i2 = aVar.f11611l;
        aVar.f11611l = i2 - 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(Purchase purchase) {
        if (this.f11605f == null) {
            return;
        }
        this.f11605f.acknowledgePurchase(AcknowledgePurchaseParams.newBuilder().setPurchaseToken(purchase.getPurchaseToken()).build(), new d(purchase));
    }

    private void w() {
        PayResult obtain = PayResult.obtain(this.c.getString(R.string.paylib_result_canel));
        obtain.setResultCode(1);
        obtain.setPayway(this.f11603d);
        obtain.setStatus(1);
        this.b.e(obtain);
    }

    private void x(BillingResult billingResult) {
        PayResult obtain = PayResult.obtain(this.c.getString(R.string.paylib_result_error));
        obtain.setResultCode(6);
        obtain.setPayway(this.f11603d);
        obtain.setStatus(billingResult.getResponseCode());
        this.b.H(obtain);
    }

    private void y(Purchase purchase) {
        if (purchase.getPurchaseState() == 1) {
            if (z(purchase.getSku())) {
                if (!purchase.isAcknowledged()) {
                    v(purchase);
                }
            } else {
                this.f11605f.consumeAsync(ConsumeParams.newBuilder().setPurchaseToken(purchase.getPurchaseToken()).build(), this);
            }
            PayResult obtain = PayResult.obtain(this.c.getString(R.string.paylib_result_success));
            obtain.setResultCode(0);
            obtain.setToken(purchase.getSignature());
            obtain.setSourceResult(purchase.getOriginalJson());
            obtain.setPayway(this.f11603d);
            obtain.mPuchaseState = purchase.getPurchaseState();
            obtain.mPuchaseTime = purchase.getPurchaseTime();
            obtain.mPuchaseToken = purchase.getPurchaseToken();
            obtain.setStatus(0);
            this.b.d(obtain);
        } else if (purchase.getPurchaseState() == 2) {
            PayResult obtain2 = PayResult.obtain(this.c.getString(R.string.paylib_result_error));
            obtain2.setResultCode(21);
            obtain2.setToken(purchase.getSignature());
            obtain2.setSourceResult(purchase.getOriginalJson());
            obtain2.setPayway(this.f11603d);
            obtain2.mPuchaseState = purchase.getPurchaseState();
            obtain2.mPuchaseTime = purchase.getPurchaseTime();
            obtain2.mPuchaseToken = purchase.getPurchaseToken();
            obtain2.setStatus(0);
            this.b.H(obtain2);
        }
    }

    private boolean z(String str) {
        List<SkuDetails> list = this.f11610k;
        if (list != null) {
            for (SkuDetails skuDetails : list) {
                if (skuDetails.getSku().equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // us.pinguo.paylibcenter.h
    public String a(String str) {
        List<SkuDetails> list = this.f11610k;
        if (list != null) {
            for (SkuDetails skuDetails : list) {
                if (skuDetails.getSku().equals(str)) {
                    return skuDetails.getPrice() + "@" + skuDetails.getPriceAmountMicros();
                }
            }
        }
        List<SkuDetails> list2 = this.f11609j;
        if (list2 != null) {
            for (SkuDetails skuDetails2 : list2) {
                if (skuDetails2.getSku().equals(str)) {
                    return skuDetails2.getPrice() + "@" + skuDetails2.getPriceAmountMicros();
                }
            }
            return "";
        }
        return "";
    }

    @Override // us.pinguo.paylibcenter.h
    public boolean b(int i2, int i3, Intent intent) {
        return false;
    }

    @Override // us.pinguo.paylibcenter.h
    public void c() {
        BillingClient billingClient = this.f11605f;
        if (billingClient == null) {
            return;
        }
        List<Purchase> purchasesList = billingClient.queryPurchases("subs").getPurchasesList();
        if (purchasesList != null && purchasesList.size() > 0) {
            for (Purchase purchase : purchasesList) {
                if (!purchase.isAcknowledged()) {
                    v(purchase);
                }
            }
        }
        List<Purchase> purchasesList2 = this.f11605f.queryPurchases(BillingClient.SkuType.INAPP).getPurchasesList();
        if (purchasesList == null || purchasesList.size() <= 0) {
            return;
        }
        for (Purchase purchase2 : purchasesList2) {
            this.f11605f.consumeAsync(ConsumeParams.newBuilder().setPurchaseToken(purchase2.getPurchaseToken()).build(), this);
        }
    }

    @Override // us.pinguo.paylibcenter.h
    public PayHelp.SubsState d(String str) {
        BillingClient billingClient = this.f11605f;
        if (billingClient == null) {
            return PayHelp.SubsState.INVALID;
        }
        List<Purchase> purchasesList = billingClient.queryPurchases("subs").getPurchasesList();
        if (purchasesList != null && purchasesList.size() > 0) {
            for (Purchase purchase : purchasesList) {
                if (purchase.getSku().equals(str)) {
                    if (purchase.getPurchaseState() == 1) {
                        if (!purchase.isAcknowledged()) {
                            v(purchase);
                        }
                        return PayHelp.SubsState.PURCHASED;
                    } else if (purchase.getPurchaseState() == 2) {
                        return PayHelp.SubsState.PENDING;
                    }
                }
            }
        }
        return PayHelp.SubsState.INVALID;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004f A[Catch: Exception -> 0x0065, TryCatch #0 {Exception -> 0x0065, blocks: (B:6:0x000e, B:8:0x0013, B:9:0x0019, B:11:0x001f, B:21:0x004f, B:22:0x0053, B:14:0x0030, B:15:0x0036, B:17:0x003c), top: B:28:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0053 A[Catch: Exception -> 0x0065, TRY_LEAVE, TryCatch #0 {Exception -> 0x0065, blocks: (B:6:0x000e, B:8:0x0013, B:9:0x0019, B:11:0x001f, B:21:0x004f, B:22:0x0053, B:14:0x0030, B:15:0x0036, B:17:0x003c), top: B:28:0x000e }] */
    @Override // us.pinguo.paylibcenter.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(android.app.Activity r5, java.lang.String r6, boolean r7, int r8, us.pinguo.paylibcenter.PayCallback r9) {
        /*
            r4 = this;
            android.content.Context r0 = r5.getApplicationContext()
            r4.c = r0
            boolean r0 = r4.a
            if (r0 == 0) goto L87
            com.android.billingclient.api.BillingClient r0 = r4.f11605f
            if (r0 == 0) goto L87
            r4.b = r9     // Catch: java.lang.Exception -> L65
            r0 = 0
            if (r7 == 0) goto L30
            java.util.List<com.android.billingclient.api.SkuDetails> r1 = r4.f11610k     // Catch: java.lang.Exception -> L65
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Exception -> L65
        L19:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Exception -> L65
            if (r2 == 0) goto L4d
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Exception -> L65
            com.android.billingclient.api.SkuDetails r2 = (com.android.billingclient.api.SkuDetails) r2     // Catch: java.lang.Exception -> L65
            java.lang.String r3 = r2.getSku()     // Catch: java.lang.Exception -> L65
            boolean r3 = r3.equals(r6)     // Catch: java.lang.Exception -> L65
            if (r3 == 0) goto L19
            goto L4c
        L30:
            java.util.List<com.android.billingclient.api.SkuDetails> r1 = r4.f11609j     // Catch: java.lang.Exception -> L65
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Exception -> L65
        L36:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Exception -> L65
            if (r2 == 0) goto L4d
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Exception -> L65
            com.android.billingclient.api.SkuDetails r2 = (com.android.billingclient.api.SkuDetails) r2     // Catch: java.lang.Exception -> L65
            java.lang.String r3 = r2.getSku()     // Catch: java.lang.Exception -> L65
            boolean r3 = r3.equals(r6)     // Catch: java.lang.Exception -> L65
            if (r3 == 0) goto L36
        L4c:
            r0 = r2
        L4d:
            if (r0 != 0) goto L53
            r4.A(r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L65
            goto La2
        L53:
            com.android.billingclient.api.BillingFlowParams$Builder r6 = com.android.billingclient.api.BillingFlowParams.newBuilder()     // Catch: java.lang.Exception -> L65
            com.android.billingclient.api.BillingFlowParams$Builder r6 = r6.setSkuDetails(r0)     // Catch: java.lang.Exception -> L65
            com.android.billingclient.api.BillingFlowParams r6 = r6.build()     // Catch: java.lang.Exception -> L65
            com.android.billingclient.api.BillingClient r7 = r4.f11605f     // Catch: java.lang.Exception -> L65
            r7.launchBillingFlow(r5, r6)     // Catch: java.lang.Exception -> L65
            goto La2
        L65:
            r6 = move-exception
            int r7 = us.pinguo.paylibgoogle.R.string.paylib_result_error
            java.lang.String r5 = r5.getString(r7)
            us.pinguo.paylibcenter.bean.PayResult r5 = us.pinguo.paylibcenter.bean.PayResult.obtain(r5)
            r7 = 6
            r5.setResultCode(r7)
            java.lang.String r6 = r6.toString()
            r5.setExt(r6)
            r5.setStatus(r7)
            us.pinguo.paylibcenter.PayHelp$PAYWAY r6 = r4.f11603d
            r5.setPayway(r6)
            r9.H(r5)
            goto La2
        L87:
            int r6 = us.pinguo.paylibgoogle.R.string.paylib_result_noinstall_google
            java.lang.String r5 = r5.getString(r6)
            us.pinguo.paylibcenter.bean.PayResult r5 = us.pinguo.paylibcenter.bean.PayResult.obtain(r5)
            r6 = 9
            r5.setResultCode(r6)
            r6 = 2
            r5.setStatus(r6)
            us.pinguo.paylibcenter.PayHelp$PAYWAY r6 = r4.f11603d
            r5.setPayway(r6)
            r9.H(r5)
        La2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.paylibgoogle.a.e(android.app.Activity, java.lang.String, boolean, int, us.pinguo.paylibcenter.PayCallback):void");
    }

    @Override // us.pinguo.paylibcenter.h
    public void f() {
    }

    @Override // us.pinguo.paylibcenter.h
    public long g(String str) {
        BillingClient billingClient = this.f11605f;
        if (billingClient == null) {
            return 0L;
        }
        List<Purchase> purchasesList = billingClient.queryPurchases("subs").getPurchasesList();
        if (purchasesList != null && purchasesList.size() > 0) {
            for (Purchase purchase : purchasesList) {
                if (purchase.getSku().equals(str)) {
                    return purchase.getPurchaseTime();
                }
            }
        }
        List<Purchase> purchasesList2 = this.f11605f.queryPurchases(BillingClient.SkuType.INAPP).getPurchasesList();
        if (purchasesList != null && purchasesList.size() > 0) {
            for (Purchase purchase2 : purchasesList2) {
                if (purchase2.getSku().equals(str)) {
                    return purchase2.getPurchaseTime();
                }
            }
        }
        return 0L;
    }

    @Override // us.pinguo.paylibcenter.h
    public boolean h(Context context, ArrayList arrayList, ArrayList arrayList2, PayHelp.i iVar) {
        this.f11604e = iVar;
        this.f11607h = arrayList;
        this.f11608i = arrayList2;
        us.pinguo.common.log.a.k("initGooglePayModule start", new Object[0]);
        if (this.f11605f == null) {
            BillingClient build = BillingClient.newBuilder(context).enablePendingPurchases().setListener(this).build();
            this.f11605f = build;
            build.startConnection(this.m);
        }
        return false;
    }

    @Override // us.pinguo.paylibcenter.h
    public void i(boolean z) {
    }

    @Override // com.android.billingclient.api.ConsumeResponseListener
    public void onConsumeResponse(BillingResult billingResult, String str) {
        if (billingResult.getResponseCode() != 0) {
            this.f11606g.postDelayed(new e(str), n);
        }
    }

    @Override // com.android.billingclient.api.PurchasesUpdatedListener
    public void onPurchasesUpdated(BillingResult billingResult, @Nullable List<Purchase> list) {
        if (this.c == null) {
            return;
        }
        if (billingResult.getResponseCode() == 0) {
            for (Purchase purchase : list) {
                y(purchase);
            }
        } else if (billingResult.getResponseCode() == 1) {
            w();
        } else {
            x(billingResult);
        }
    }
}
