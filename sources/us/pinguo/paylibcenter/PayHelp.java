package us.pinguo.paylibcenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import us.pinguo.paylibcenter.bean.PayCenterParm;
import us.pinguo.paylibcenter.bean.PayResult;
import us.pinguo.paylibcenter.bean.WxReqBean;
import us.pinguo.paylibcenter.order.CreateOrderReq;
import us.pinguo.paylibcenter.order.CreateOrderResp;
import us.pinguo.paylibcenter.order.PurchaseReq;
import us.pinguo.paylibcenter.order.PurchaseResp;
import us.pinguo.paylibcenter.order.SyncOrderReq;
import us.pinguo.paylibcenter.order.SyncOrderResp;
import us.pinguo.paylibcenter.view.PayCenterProgressDialog;
/* loaded from: classes5.dex */
public class PayHelp {
    private us.pinguo.paylibcenter.order.b b;

    /* renamed from: d  reason: collision with root package name */
    private PayCenterProgressDialog f11562d;

    /* renamed from: e  reason: collision with root package name */
    private us.pinguo.paylibcenter.i f11563e;

    /* renamed from: f  reason: collision with root package name */
    private us.pinguo.paylibcenter.h f11564f;

    /* renamed from: g  reason: collision with root package name */
    private us.pinguo.paylibcenter.m f11565g;

    /* renamed from: h  reason: collision with root package name */
    private us.pinguo.paylibcenter.l f11566h;

    /* renamed from: i  reason: collision with root package name */
    private us.pinguo.paylibcenter.j f11567i;

    /* renamed from: j  reason: collision with root package name */
    private us.pinguo.paylibcenter.k f11568j;

    /* renamed from: k  reason: collision with root package name */
    private us.pinguo.paylibcenter.e f11569k;

    /* renamed from: l  reason: collision with root package name */
    private us.pinguo.paylibcenter.g f11570l;
    ExecutorService a = Executors.newFixedThreadPool(2);
    private String c = "";
    private int m = 0;

    /* loaded from: classes5.dex */
    public enum PAYWAY {
        OtherPay("0"),
        AliPay("101"),
        WxPay("201"),
        GooglePay("901"),
        MolWebPay("301"),
        MiGuPay("1201"),
        MMPay("1501"),
        HuaweiIAP("1102"),
        CCBPay("1601"),
        VivoPay("1701"),
        OppoPay("1702"),
        WOPay("1202"),
        PayssionPay("402");
        
        public final String value;

        PAYWAY(String str) {
            this.value = str;
        }
    }

    /* loaded from: classes5.dex */
    public enum SubsState {
        PURCHASED(1),
        PENDING(2),
        INVALID(0),
        UNINIT(-1);
        
        public final int value;

        SubsState(int i2) {
            this.value = i2;
        }
    }

    /* loaded from: classes5.dex */
    class a implements PayCallback {
        final /* synthetic */ Activity a;
        final /* synthetic */ PayCallback b;
        final /* synthetic */ PayCenterParm c;

        a(Activity activity, PayCallback payCallback, PayCenterParm payCenterParm) {
            this.a = activity;
            this.b = payCallback;
            this.c = payCenterParm;
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void H(PayResult payResult) {
            payResult.orderId = PayHelp.this.c;
            PayHelp.this.e0(this.a, SyncOrderReq.SYNCPAYSTATUS.WXFAIL, payResult.getMessage());
            this.b.H(payResult);
            us.pinguo.common.log.a.q(payResult.getMessage(), new Object[0]);
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void W() {
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void d(PayResult payResult) {
            payResult.orderId = PayHelp.this.c;
            PayHelp.this.e0(this.a, SyncOrderReq.SYNCPAYSTATUS.WXSUCCESS, payResult.getMessage());
            this.b.d(payResult);
            PayHelp.this.f0(this.a, this.c.getUserId());
            us.pinguo.common.log.a.q(payResult.getMessage(), new Object[0]);
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void e(PayResult payResult) {
            payResult.orderId = PayHelp.this.c;
            this.b.e(payResult);
            us.pinguo.common.log.a.q(payResult.getMessage(), new Object[0]);
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void s() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ PAYWAY c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f11572d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f11573e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Activity f11574f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ PayCallback f11575g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Object f11576h;

        b(String str, String str2, PAYWAY payway, String str3, String str4, Activity activity, PayCallback payCallback, Object obj) {
            this.a = str;
            this.b = str2;
            this.c = payway;
            this.f11572d = str3;
            this.f11573e = str4;
            this.f11574f = activity;
            this.f11575g = payCallback;
            this.f11576h = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    CreateOrderReq createOrderReq = new CreateOrderReq();
                    createOrderReq.setUserId(this.a);
                    createOrderReq.setProductId(this.b);
                    createOrderReq.setWay(this.c);
                    createOrderReq.setMolChannel(this.f11572d);
                    createOrderReq.setPurchaseTag(this.f11573e);
                    PayHelp payHelp = PayHelp.this;
                    payHelp.b = payHelp.L(this.f11574f.getApplicationContext(), createOrderReq);
                    CreateOrderResp createOrderResp = PayHelp.this.b.get();
                    if (createOrderResp != null) {
                        if (createOrderResp.isSuccess()) {
                            if (us.pinguo.paylibcenter.d.a().b()) {
                                us.pinguo.common.log.a.q("create order:" + us.pinguo.paylibcenter.o.a.a(createOrderResp), new Object[0]);
                            }
                            PAYWAY payway = this.c;
                            if (payway == PAYWAY.AliPay) {
                                if (PayHelp.this.f11565g != null && createOrderResp.getData() != null && !TextUtils.isEmpty(createOrderResp.getData().getPackageValue())) {
                                    PayHelp.this.c = us.pinguo.paylibcenter.o.a.c(createOrderResp.getData().getPackageValue());
                                    PayHelp.this.f11565g.a(this.f11574f, createOrderResp.getData().getPackageValue(), this.f11575g);
                                }
                            } else if (payway == PAYWAY.WxPay) {
                                if (PayHelp.this.f11565g != null && createOrderResp.getData() != null) {
                                    WxReqBean wxReqBean = new WxReqBean();
                                    wxReqBean.setAppId(createOrderResp.getData().getAppid());
                                    wxReqBean.setPrepayId(createOrderResp.getData().getPrepayid());
                                    wxReqBean.setPartnerId(createOrderResp.getData().getPartnerid());
                                    wxReqBean.setNonceStr(createOrderResp.getData().getNoncestr());
                                    wxReqBean.setTimeStamp(createOrderResp.getData().getTimestamp());
                                    wxReqBean.setPackageValue(createOrderResp.getData().getPackage());
                                    wxReqBean.setSign(createOrderResp.getData().getSign());
                                    PayHelp.this.c = createOrderResp.getData().getOid();
                                    PayHelp.this.f11565g.b(this.f11574f, wxReqBean, this.f11575g);
                                }
                            } else if (payway == PAYWAY.MolWebPay) {
                                if (PayHelp.this.f11568j != null && createOrderResp.getData() != null && !TextUtils.isEmpty(createOrderResp.getData().getUrl())) {
                                    PayHelp.this.f11568j.a(this.f11574f, createOrderResp.getData().getUrl(), this.f11575g);
                                }
                            } else {
                                if (payway != PAYWAY.MiGuPay && payway != PAYWAY.MMPay && payway != PAYWAY.CCBPay) {
                                    if (payway == PAYWAY.PayssionPay) {
                                        if (PayHelp.this.f11566h != null && createOrderResp.getData() != null) {
                                            CreateOrderResp.Data data = createOrderResp.getData();
                                            PayHelp.this.f11566h.a(this.f11574f, data.getOid(), data.getApikey(), data.getAmount(), data.getCurrency(), data.getProductDesc(), this.f11575g);
                                        }
                                    } else {
                                        CreateOrderResp.Data data2 = createOrderResp.getData();
                                        if (PayHelp.this.f11570l != null && data2 != null) {
                                            new us.pinguo.paylibcenter.f().a = this.f11576h;
                                            PayHelp.this.f11570l.a(this.f11574f, data2, this.f11575g, this.f11576h);
                                        }
                                    }
                                }
                                if (PayHelp.this.f11569k != null && createOrderResp.getData() != null && !TextUtils.isEmpty(createOrderResp.getData().getUrl())) {
                                    PayHelp.this.f11569k.S(this.f11574f, createOrderResp.getData().getUrl(), this.f11575g);
                                }
                            }
                        } else if (10514 == createOrderResp.getStatus()) {
                            PayResult obtain = PayResult.obtain(this.f11574f.getString(R.string.paylib_result_order_restore));
                            obtain.setResultCode(0);
                            obtain.setPayway(this.c);
                            this.f11575g.d(obtain);
                            us.pinguo.common.log.a.q("create order ispayed", new Object[0]);
                        } else {
                            PayResult obtain2 = PayResult.obtain(this.f11574f.getString(R.string.paylib_result_order_fail));
                            obtain2.setResultCode(12);
                            obtain2.setStatus(createOrderResp.getStatus());
                            obtain2.setExt(us.pinguo.paylibcenter.o.a.a(createOrderResp));
                            obtain2.setPayway(this.c);
                            this.f11575g.H(obtain2);
                            us.pinguo.common.log.a.q("create order:" + us.pinguo.paylibcenter.o.a.a(createOrderResp), new Object[0]);
                        }
                    } else {
                        PayResult obtain3 = PayResult.obtain(this.f11574f.getString(R.string.paylib_result_order_resp_empty));
                        obtain3.setResultCode(14);
                        obtain3.setPayway(this.c);
                        this.f11575g.H(obtain3);
                        us.pinguo.common.log.a.q("create order resp is null", new Object[0]);
                    }
                } catch (Exception e2) {
                    PayResult obtain4 = PayResult.obtain(this.f11574f.getString(R.string.paylib_result_order_error));
                    obtain4.setResultCode(13);
                    obtain4.setExt(e2.toString());
                    obtain4.setPayway(this.c);
                    this.f11575g.H(obtain4);
                    us.pinguo.common.log.a.q("create order exception:" + e2.toString(), new Object[0]);
                }
            } finally {
                PayHelp.this.u();
                PayHelp.this.b = null;
            }
        }
    }

    /* loaded from: classes5.dex */
    class c implements PayCallback {
        final /* synthetic */ PayCallback a;
        final /* synthetic */ Activity b;
        final /* synthetic */ PayCenterParm c;

        c(PayCallback payCallback, Activity activity, PayCenterParm payCenterParm) {
            this.a = payCallback;
            this.b = activity;
            this.c = payCenterParm;
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void H(PayResult payResult) {
            payResult.orderId = PayHelp.this.c;
            this.a.H(payResult);
            us.pinguo.common.log.a.q(payResult.getMessage(), new Object[0]);
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void W() {
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void d(PayResult payResult) {
            payResult.orderId = PayHelp.this.c;
            this.a.d(payResult);
            PayHelp.this.f0(this.b, this.c.getUserId());
            us.pinguo.common.log.a.q(payResult.getMessage(), new Object[0]);
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void e(PayResult payResult) {
            payResult.orderId = PayHelp.this.c;
            this.a.e(payResult);
            us.pinguo.common.log.a.q(payResult.getMessage(), new Object[0]);
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void s() {
        }
    }

    /* loaded from: classes5.dex */
    class d implements PayCallback {
        final /* synthetic */ PayCallback a;
        final /* synthetic */ Context b;
        final /* synthetic */ PayCenterParm c;

        d(PayCallback payCallback, Context context, PayCenterParm payCenterParm) {
            this.a = payCallback;
            this.b = context;
            this.c = payCenterParm;
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void H(PayResult payResult) {
            us.pinguo.common.log.a.q("google pay failed", new Object[0]);
            if (payResult.getStatus() == 7 && PayHelp.this.f11564f != null) {
                try {
                    PayHelp.this.f11564f.f();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.a.H(payResult);
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void W() {
            this.a.W();
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void d(PayResult payResult) {
            us.pinguo.common.log.a.q("google pay sucess", new Object[0]);
            this.a.d(payResult);
            PayHelp payHelp = PayHelp.this;
            Context context = this.b;
            String productId = this.c.getProductId();
            String userId = this.c.getUserId();
            PayCenterParm payCenterParm = this.c;
            payHelp.S(context, productId, userId, payCenterParm.isSubscription, payCenterParm.getPurchaseTag(), payResult, this.a);
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void e(PayResult payResult) {
            us.pinguo.common.log.a.q("google pay cancel", new Object[0]);
            this.a.e(payResult);
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void s() {
            this.a.s();
        }
    }

    /* loaded from: classes5.dex */
    class e implements PayCallback {
        final /* synthetic */ PayCallback a;

        e(PayCallback payCallback) {
            this.a = payCallback;
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void H(PayResult payResult) {
            payResult.orderId = PayHelp.this.c;
            this.a.H(payResult);
            us.pinguo.common.log.a.q(payResult.getMessage(), new Object[0]);
            us.pinguo.common.log.a.q(payResult.getExt(), new Object[0]);
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void W() {
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void d(PayResult payResult) {
            payResult.orderId = PayHelp.this.c;
            if (PayHelp.this.f11566h != null) {
                PayHelp.this.f11566h.b(payResult, this.a);
            }
            us.pinguo.common.log.a.q(payResult.getMessage(), new Object[0]);
            us.pinguo.common.log.a.q(payResult.getExt(), new Object[0]);
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void e(PayResult payResult) {
            payResult.orderId = PayHelp.this.c;
            this.a.e(payResult);
            us.pinguo.common.log.a.q(payResult.getMessage(), new Object[0]);
            us.pinguo.common.log.a.q(payResult.getExt(), new Object[0]);
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void s() {
        }
    }

    /* loaded from: classes5.dex */
    class f implements PayCallback {
        final /* synthetic */ Activity a;
        final /* synthetic */ PayCallback b;
        final /* synthetic */ PayCenterParm c;

        f(Activity activity, PayCallback payCallback, PayCenterParm payCenterParm) {
            this.a = activity;
            this.b = payCallback;
            this.c = payCenterParm;
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void H(PayResult payResult) {
            payResult.orderId = PayHelp.this.c;
            PayHelp.this.e0(this.a, SyncOrderReq.SYNCPAYSTATUS.ALIFAIL, payResult.getSourceResult());
            this.b.H(payResult);
            us.pinguo.common.log.a.q(payResult.getMessage(), new Object[0]);
            us.pinguo.common.log.a.q(payResult.getExt(), new Object[0]);
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void W() {
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void d(PayResult payResult) {
            PayHelp.this.e0(this.a, SyncOrderReq.SYNCPAYSTATUS.ALISUCCESS, payResult.getMessage());
            payResult.orderId = PayHelp.this.c;
            this.b.d(payResult);
            PayHelp.this.f0(this.a, this.c.getUserId());
            us.pinguo.common.log.a.q(payResult.getMessage(), new Object[0]);
            us.pinguo.common.log.a.q(payResult.getExt(), new Object[0]);
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void e(PayResult payResult) {
            payResult.orderId = PayHelp.this.c;
            this.b.e(payResult);
            us.pinguo.common.log.a.q(payResult.getMessage(), new Object[0]);
            us.pinguo.common.log.a.q(payResult.getExt(), new Object[0]);
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void s() {
        }
    }

    /* loaded from: classes5.dex */
    class g implements Runnable {
        final /* synthetic */ Activity a;
        final /* synthetic */ String b;
        final /* synthetic */ PayCallback c;

        g(Activity activity, String str, PayCallback payCallback) {
            this.a = activity;
            this.b = str;
            this.c = payCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            PayHelp.this.f11565g.a(this.a, this.b, this.c);
        }
    }

    /* loaded from: classes5.dex */
    class h implements PayCallback {
        final /* synthetic */ Activity a;
        final /* synthetic */ PayCallback b;
        final /* synthetic */ PayCenterParm c;

        h(Activity activity, PayCallback payCallback, PayCenterParm payCenterParm) {
            this.a = activity;
            this.b = payCallback;
            this.c = payCenterParm;
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void H(PayResult payResult) {
            payResult.orderId = PayHelp.this.c;
            PayHelp.this.e0(this.a, SyncOrderReq.SYNCPAYSTATUS.ALIFAIL, payResult.getSourceResult());
            this.b.H(payResult);
            us.pinguo.common.log.a.q(payResult.getMessage(), new Object[0]);
            us.pinguo.common.log.a.q(payResult.getExt(), new Object[0]);
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void W() {
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void d(PayResult payResult) {
            PayHelp.this.e0(this.a, SyncOrderReq.SYNCPAYSTATUS.ALISUCCESS, payResult.getMessage());
            payResult.orderId = PayHelp.this.c;
            this.b.d(payResult);
            PayHelp.this.f0(this.a, this.c.getUserId());
            PayHelp payHelp = PayHelp.this;
            Activity activity = this.a;
            String productId = this.c.getProductId();
            String userId = this.c.getUserId();
            PayCenterParm payCenterParm = this.c;
            payHelp.S(activity, productId, userId, payCenterParm.isSubscription, payCenterParm.getPurchaseTag(), payResult, this.b);
            us.pinguo.common.log.a.q(payResult.getMessage(), new Object[0]);
            us.pinguo.common.log.a.q(payResult.getExt(), new Object[0]);
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void e(PayResult payResult) {
            payResult.orderId = PayHelp.this.c;
            this.b.e(payResult);
            us.pinguo.common.log.a.q(payResult.getMessage(), new Object[0]);
            us.pinguo.common.log.a.q(payResult.getExt(), new Object[0]);
        }

        @Override // us.pinguo.paylibcenter.PayCallback
        public void s() {
        }
    }

    /* loaded from: classes5.dex */
    public interface i {
        void a();
    }

    /* loaded from: classes5.dex */
    public interface j {
    }

    /* loaded from: classes5.dex */
    public interface k {
    }

    /* loaded from: classes5.dex */
    public static class l {
        public String a;
        public String b;
    }

    /* loaded from: classes5.dex */
    private static class m {
        private static PayHelp a = new PayHelp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public /* synthetic */ void O(String str, String str2, String str3, PayResult payResult, Context context, boolean z, PayCallback payCallback) {
        try {
            try {
                PurchaseReq purchaseReq = new PurchaseReq();
                purchaseReq.setPurchaseTag(str);
                purchaseReq.setProductId(str2);
                purchaseReq.setUserId(str3);
                if (PAYWAY.HuaweiIAP == payResult.getPayway()) {
                    purchaseReq.setWay(payResult.getPayway().value);
                    purchaseReq.setPurchaseToken(payResult.getToken());
                    purchaseReq.setSubscribeId(payResult.getSubscribeId());
                    purchaseReq.setHmsProductId(payResult.getHmsProductId());
                } else if (PAYWAY.GooglePay == payResult.getPayway()) {
                    purchaseReq.setReceipt(payResult.getSourceResult());
                    purchaseReq.setSignture(payResult.getToken());
                }
                String str4 = new us.pinguo.paylibcenter.order.c(context, purchaseReq, z).get();
                us.pinguo.common.log.a.q(str4, new Object[0]);
                PurchaseResp purchaseResp = (PurchaseResp) us.pinguo.paylibcenter.o.a.b(str4, PurchaseResp.class);
                if (purchaseResp != null && purchaseResp.isSuccess()) {
                    payResult.setMessage(context.getString(R.string.paylib_result_iappay_success));
                    payResult.setResultCode(0);
                    payCallback.W();
                    f0(context, str3);
                    p(context, payResult.getToken());
                } else {
                    payResult.setMessage(context.getResources().getString(R.string.paylib_result_iapcheck_fail));
                    payResult.setResultCode(16);
                    payResult.setExt(us.pinguo.paylibcenter.o.a.a(purchaseResp));
                    payCallback.s();
                }
            } catch (Exception e2) {
                payResult.setMessage(context.getResources().getString(R.string.paylib_result_iapcheck_error));
                payResult.setResultCode(17);
                payResult.setExt(e2.toString());
                payCallback.s();
            }
        } finally {
            u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P */
    public /* synthetic */ void Q(SyncOrderReq.SYNCPAYSTATUS syncpaystatus, String str, Context context) {
        try {
            try {
                SyncOrderReq syncOrderReq = new SyncOrderReq();
                syncOrderReq.setStatus(syncpaystatus.value);
                syncOrderReq.setOut_trade_no(this.c);
                syncOrderReq.setReceipt(str);
                SyncOrderResp syncOrderResp = new us.pinguo.paylibcenter.order.e(context, syncOrderReq).get();
                if (syncOrderResp != null && syncOrderResp.isSuccess()) {
                    us.pinguo.common.log.a.q(syncOrderResp.getMessage(), new Object[0]);
                } else {
                    us.pinguo.common.log.a.q("syncorder" + syncOrderResp.getMessage(), new Object[0]);
                }
            } catch (Exception e2) {
                us.pinguo.common.log.a.q("syncorder error" + e2.toString(), new Object[0]);
            }
        } finally {
            this.c = "";
        }
    }

    private void V() {
        try {
            if (this.f11565g != null) {
                return;
            }
            this.f11565g = (us.pinguo.paylibcenter.m) Class.forName("us.pinguo.paylibwxalipay.AliWxpayHelp").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e2) {
            us.pinguo.common.log.a.e(e2.getMessage(), new Object[0]);
        }
    }

    private void W() {
        if (this.f11564f != null) {
            return;
        }
        try {
            this.f11564f = (us.pinguo.paylibcenter.h) Class.forName("us.pinguo.paylibgoogle.a").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e2) {
            us.pinguo.common.log.a.e(e2.getMessage(), new Object[0]);
        }
    }

    private void X(Activity activity) {
        try {
            this.f11567i = (us.pinguo.paylibcenter.j) Class.forName("com.huawei.iap.PayHuaweiHelp").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e2) {
            us.pinguo.common.log.a.e(e2.getMessage(), new Object[0]);
        }
    }

    private void b0() {
        try {
            if (this.f11566h != null) {
                return;
            }
            this.f11566h = (us.pinguo.paylibcenter.l) Class.forName("us.pinguo.payssion.PayssionPayImp").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e2) {
            us.pinguo.common.log.a.e(e2.getMessage(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(final Context context, final SyncOrderReq.SYNCPAYSTATUS syncpaystatus, final String str) {
        if (TextUtils.isEmpty(this.c) || context == null) {
            return;
        }
        this.a.execute(new Runnable() { // from class: us.pinguo.paylibcenter.b
            @Override // java.lang.Runnable
            public final void run() {
                PayHelp.this.Q(syncpaystatus, str, context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(Context context, String str) {
        try {
            OrderHelp.getInstance().e(context, str, 0, us.pinguo.paylibcenter.c.a, null, "", Boolean.TRUE);
        } catch (Exception e2) {
            us.pinguo.common.log.a.q("update restory product:" + e2.toString(), new Object[0]);
        }
    }

    public static synchronized PayHelp getInstance() {
        PayHelp payHelp;
        synchronized (PayHelp.class) {
            payHelp = m.a;
        }
        return payHelp;
    }

    private boolean n(Context context, String str, String str2, PayCallback payCallback, PAYWAY payway) {
        try {
            us.pinguo.common.log.a.q("check productID:" + str, new Object[0]);
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(str)) {
            PayResult obtain = PayResult.obtain(context.getString(R.string.paylib_result_product_empty));
            obtain.setResultCode(4);
            obtain.setPayway(payway);
            payCallback.H(obtain);
            return false;
        }
        return true;
    }

    private void s(Activity activity, PAYWAY payway, String str, String str2, String str3, PayCallback payCallback, Object obj, String str4) {
        if (this.b == null && n(activity.getApplicationContext(), str, str2, payCallback, payway)) {
            d0(activity);
            this.a.execute(new b(str2, str, payway, str4, str3, activity, payCallback, obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        PayCenterProgressDialog payCenterProgressDialog = this.f11562d;
        if (payCenterProgressDialog != null) {
            payCenterProgressDialog.dismiss();
            this.f11562d = null;
        }
    }

    public String A(String str, PAYWAY payway) {
        if (payway == PAYWAY.GooglePay) {
            us.pinguo.paylibcenter.h hVar = this.f11564f;
            if (hVar != null) {
                return hVar.a(str);
            }
            throw new IllegalStateException("You need init Google Pay first,pls check initPay method");
        }
        throw new IllegalStateException("Only GP channel can query it currently");
    }

    public void B(Activity activity, PayCenterParm payCenterParm, PayCallback payCallback) {
        if (us.pinguo.paylibcenter.o.a.d(new long[0]) || payCenterParm == null) {
            return;
        }
        V();
        q(activity, PAYWAY.AliPay, payCenterParm.getProductId(), payCenterParm.getUserId(), payCenterParm.getPurchaseTag(), new f(activity, payCallback, payCenterParm));
    }

    public void C(Activity activity, String str, PayCallback payCallback) {
        if (us.pinguo.paylibcenter.o.a.d(new long[0])) {
            return;
        }
        V();
        if (this.f11565g != null) {
            this.a.execute(new g(activity, str, payCallback));
        }
    }

    public void D(Activity activity, PAYWAY payway, PayCenterParm payCenterParm, PayCallback payCallback, String str) {
        if (us.pinguo.paylibcenter.o.a.d(new long[0]) || payCenterParm == null) {
            return;
        }
        r(activity, payway, payCenterParm.getProductId(), payCenterParm.getUserId(), payCenterParm.getPurchaseTag(), new c(payCallback, activity, payCenterParm), str);
    }

    public void E(Activity activity, PayCenterParm payCenterParm, PayCallback payCallback) {
        if (us.pinguo.paylibcenter.o.a.d(new long[0]) || payCenterParm == null) {
            return;
        }
        Context applicationContext = activity.getApplicationContext();
        W();
        if (this.f11564f == null || !n(applicationContext, payCenterParm.getProductId(), payCenterParm.getUserId(), payCallback, PAYWAY.GooglePay)) {
            return;
        }
        us.pinguo.common.log.a.q("google pay:" + payCenterParm.getProductId(), new Object[0]);
        this.f11564f.e(activity, payCenterParm.getGoogleId(), payCenterParm.isSubscription, payCenterParm.getRequestCode(), new d(payCallback, applicationContext, payCenterParm));
    }

    public void F(Activity activity, PayCenterParm payCenterParm, PayCallback payCallback) {
        if (us.pinguo.paylibcenter.o.a.d(new long[0]) || payCenterParm == null) {
            return;
        }
        if (payCenterParm.getProductId() == null) {
            payCallback.H(new PayResult(18, "无效商品"));
            return;
        }
        try {
            if (this.f11567i == null) {
                X(activity);
            }
            this.f11567i.d(payCenterParm);
            this.f11567i.e(activity, new h(activity, payCallback, payCenterParm));
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
        }
    }

    public void G(Activity activity, PayCenterParm payCenterParm, PayCallback payCallback) {
        if (us.pinguo.paylibcenter.o.a.d(new long[0]) || payCenterParm == null) {
            return;
        }
        b0();
        q(activity, PAYWAY.PayssionPay, payCenterParm.getProductId(), payCenterParm.getUserId(), payCenterParm.getPurchaseTag(), new e(payCallback));
    }

    public void H(Activity activity, PayCenterParm payCenterParm, PayCallback payCallback) {
        if (us.pinguo.paylibcenter.o.a.d(new long[0]) || payCenterParm == null) {
            return;
        }
        V();
        q(activity, PAYWAY.WxPay, payCenterParm.getProductId(), payCenterParm.getUserId(), payCenterParm.getPurchaseTag(), new a(activity, payCallback, payCenterParm));
    }

    public void I(Activity activity, WxReqBean wxReqBean, PayCallback payCallback) {
        if (us.pinguo.paylibcenter.o.a.d(new long[0])) {
            return;
        }
        V();
        us.pinguo.paylibcenter.m mVar = this.f11565g;
        if (mVar != null) {
            mVar.b(activity, wxReqBean, payCallback);
        }
    }

    public boolean J(int i2, int i3, Intent intent) {
        us.pinguo.common.log.a.q("google pay handleActivityResult", new Object[0]);
        us.pinguo.paylibcenter.h hVar = this.f11564f;
        if (hVar != null) {
            return hVar.b(i2, i3, intent);
        }
        return false;
    }

    public boolean K(Context context, us.pinguo.paylibcenter.i iVar, ArrayList arrayList, ArrayList arrayList2, i iVar2) {
        try {
            this.m++;
            us.pinguo.common.log.a.k("initGoolgePayWay mGoogleInitCount = " + this.m, new Object[0]);
            if (this.f11564f == null) {
                this.f11563e = iVar;
                W();
                this.f11564f.h(context, arrayList, arrayList2, iVar2);
            } else if (iVar2 != null) {
                iVar2.a();
            }
            return true;
        } catch (Exception e2) {
            if (iVar2 != null) {
                iVar2.a();
            }
            us.pinguo.common.log.a.q(e2.toString(), new Object[0]);
            return false;
        }
    }

    protected us.pinguo.paylibcenter.order.b L(Context context, CreateOrderReq createOrderReq) {
        return new us.pinguo.paylibcenter.order.b(context, createOrderReq);
    }

    public boolean M(Activity activity, us.pinguo.paylibcenter.i iVar, PAYWAY payway) {
        try {
            this.f11563e = iVar;
            if (PAYWAY.GooglePay == payway) {
                if (this.f11564f == null) {
                    W();
                    return true;
                }
                return true;
            } else if (PAYWAY.HuaweiIAP == payway) {
                X(activity);
                return true;
            } else if (PAYWAY.VivoPay == payway) {
                return true;
            } else {
                V();
                X(activity);
                return true;
            }
        } catch (Exception e2) {
            us.pinguo.common.log.a.q(e2.toString(), new Object[0]);
            return false;
        }
    }

    public void S(final Context context, final String str, final String str2, final boolean z, final String str3, final PayResult payResult, final PayCallback payCallback) {
        this.a.execute(new Runnable() { // from class: us.pinguo.paylibcenter.a
            @Override // java.lang.Runnable
            public final void run() {
                PayHelp.this.O(str3, str, str2, payResult, context, z, payCallback);
            }
        });
    }

    public void T(Context context, PAYWAY payway, k kVar) {
        if (this.f11567i == null) {
            X(null);
        }
        this.f11567i.c(context, kVar);
    }

    public SubsState U(String str, PAYWAY payway) {
        if (payway == PAYWAY.GooglePay) {
            us.pinguo.paylibcenter.h hVar = this.f11564f;
            if (hVar != null) {
                return hVar.d(str);
            }
            throw new IllegalStateException("You need init Google Pay first,pls check initPay method");
        }
        throw new IllegalStateException("Only GP channel can query it currently");
    }

    public void Y(int i2) {
        if (i2 == 0) {
            us.pinguo.paylibcenter.n.c.b = us.pinguo.paylibcenter.n.c.f11592g;
            us.pinguo.paylibcenter.n.c.c = us.pinguo.paylibcenter.n.c.f11591f;
        } else if (1 == i2) {
            us.pinguo.paylibcenter.n.c.b = us.pinguo.paylibcenter.n.c.f11590e;
            us.pinguo.paylibcenter.n.c.c = us.pinguo.paylibcenter.n.c.f11589d;
        }
    }

    public void Z(us.pinguo.paylibcenter.e eVar) {
        this.f11569k = eVar;
    }

    public void a0(us.pinguo.paylibcenter.i iVar) {
        this.f11563e = iVar;
    }

    public void c0(String str) {
        us.pinguo.paylibcenter.n.c.a = str;
    }

    public void d0(Activity activity) {
        PayCenterProgressDialog payCenterProgressDialog = this.f11562d;
        if (payCenterProgressDialog == null || !payCenterProgressDialog.isShowing()) {
            PayCenterProgressDialog a2 = PayCenterProgressDialog.a(activity);
            this.f11562d = a2;
            if (a2.isShowing()) {
                return;
            }
            this.f11562d.show();
        }
    }

    public void o(PAYWAY payway) {
        if (payway != PAYWAY.GooglePay) {
            return;
        }
        if (this.f11564f == null) {
            W();
        }
        this.f11564f.c();
    }

    public void p(Context context, String str) {
        if (this.f11567i == null) {
            X(null);
        }
        this.f11567i.b(context, str);
    }

    public void q(Activity activity, PAYWAY payway, String str, String str2, String str3, PayCallback payCallback) {
        s(activity, payway, str, str2, str3, payCallback, null, null);
    }

    public void r(Activity activity, PAYWAY payway, String str, String str2, String str3, PayCallback payCallback, Object obj) {
        s(activity, payway, str, str2, str3, payCallback, obj, null);
    }

    public void t() {
        us.pinguo.paylibcenter.order.b bVar = this.b;
        if (bVar != null) {
            bVar.cancel(true);
            this.b = null;
        }
        us.pinguo.common.log.a.q("google pay destory", new Object[0]);
    }

    public void v(boolean z) {
        us.pinguo.paylibcenter.d.a().c(z);
        us.pinguo.common.log.a.n(z);
        us.pinguo.paylibcenter.h hVar = this.f11564f;
        if (hVar != null) {
            hVar.i(z);
        }
    }

    public Map<String, String> w() {
        us.pinguo.paylibcenter.i iVar = this.f11563e;
        if (iVar != null) {
            return iVar.a();
        }
        return null;
    }

    public void x(Context context, List<String> list, j jVar) {
        if (this.f11567i == null) {
            X(null);
        }
        this.f11567i.a(context, list, jVar);
    }

    public us.pinguo.paylibcenter.h y() {
        return this.f11564f;
    }

    public long z(String str, PAYWAY payway) {
        if (payway == PAYWAY.GooglePay) {
            us.pinguo.paylibcenter.h hVar = this.f11564f;
            if (hVar != null) {
                return hVar.g(str);
            }
            throw new IllegalStateException("You need init Google Pay first,pls check initPay method");
        }
        throw new IllegalStateException("Only GP channel can query it currently");
    }
}
