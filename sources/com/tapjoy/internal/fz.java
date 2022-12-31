package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJActionRequest;
import com.tapjoy.TJError;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyLog;
import com.tapjoy.internal.fs;
import java.util.Observable;
import java.util.Observer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class fz {
    volatile a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements TJPlacementListener, Observer {
        private final Object b;
        private final fi c;

        /* renamed from: d  reason: collision with root package name */
        private volatile boolean f7552d;

        /* renamed from: e  reason: collision with root package name */
        private TJPlacement f7553e;

        a(fz fzVar, Object obj) {
            this(obj, new fi(10000L));
        }

        final void a() {
            synchronized (this) {
                if (this.f7552d) {
                    return;
                }
                if (this.c.a()) {
                    a("Timed out");
                    return;
                }
                if (!TapjoyConnectCore.isConnected()) {
                    fs.a aVar = fs.a;
                    aVar.addObserver(this);
                    if (!TapjoyConnectCore.isConnected()) {
                        return;
                    }
                    aVar.deleteObserver(this);
                }
                TJPlacement tJPlacement = this.f7553e;
                if (tJPlacement == null) {
                    if (!fz.this.a()) {
                        a("Cannot request");
                        return;
                    }
                    TJPlacement a = fz.this.a(TapjoyConnectCore.getContext(), this, this.b);
                    this.f7553e = a;
                    a.requestContent();
                } else if (tJPlacement.isContentReady()) {
                    if (fz.this.a((Observer) this)) {
                        this.f7553e.showContent();
                        a(null);
                    }
                }
            }
        }

        @Override // com.tapjoy.TJPlacementListener
        public final void onClick(TJPlacement tJPlacement) {
        }

        @Override // com.tapjoy.TJPlacementListener
        public final void onContentDismiss(TJPlacement tJPlacement) {
        }

        @Override // com.tapjoy.TJPlacementListener
        public final void onContentReady(TJPlacement tJPlacement) {
            a();
        }

        @Override // com.tapjoy.TJPlacementListener
        public final void onContentShow(TJPlacement tJPlacement) {
        }

        @Override // com.tapjoy.TJPlacementListener
        public final void onPurchaseRequest(TJPlacement tJPlacement, TJActionRequest tJActionRequest, String str) {
        }

        @Override // com.tapjoy.TJPlacementListener
        public final void onRequestFailure(TJPlacement tJPlacement, TJError tJError) {
            a(tJError.message);
        }

        @Override // com.tapjoy.TJPlacementListener
        public final void onRequestSuccess(TJPlacement tJPlacement) {
        }

        @Override // com.tapjoy.TJPlacementListener
        public final void onRewardRequest(TJPlacement tJPlacement, TJActionRequest tJActionRequest, String str, int i2) {
        }

        @Override // java.util.Observer
        public final void update(Observable observable, Object obj) {
            a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Object obj, fi fiVar) {
            this.b = obj;
            this.c = fiVar;
        }

        private void a(String str) {
            synchronized (this) {
                String a = fz.this.a(this.b);
                if (str == null) {
                    TapjoyLog.i("SystemPlacement", "Placement " + a + " is presented now");
                } else {
                    TapjoyLog.i("SystemPlacement", "Cannot show placement " + a + " now (" + str + ")");
                }
                this.f7552d = true;
                this.f7553e = null;
                fs.a.deleteObserver(this);
                fs.f7545e.deleteObserver(this);
                fs.c.deleteObserver(this);
            }
            fz fzVar = fz.this;
            synchronized (fzVar) {
                if (fzVar.b == this) {
                    fzVar.b = null;
                }
            }
        }
    }

    protected abstract TJPlacement a(Context context, TJPlacementListener tJPlacementListener, Object obj);

    protected abstract String a(Object obj);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a() {
        return !TapjoyConnectCore.isFullScreenViewOpen();
    }

    protected a b(Object obj) {
        return new a(this, obj);
    }

    public final boolean c(Object obj) {
        if (a()) {
            a aVar = null;
            synchronized (this) {
                if (this.b == null) {
                    aVar = b(obj);
                    this.b = aVar;
                }
            }
            if (aVar != null) {
                aVar.a();
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(Observer observer) {
        if (TapjoyConnectCore.isFullScreenViewOpen()) {
            fs.a aVar = fs.f7545e;
            aVar.addObserver(observer);
            if (TapjoyConnectCore.isFullScreenViewOpen()) {
                return false;
            }
            aVar.deleteObserver(observer);
        }
        if (gz.a().d()) {
            return true;
        }
        fs.a aVar2 = fs.c;
        aVar2.addObserver(observer);
        if (gz.a().d()) {
            aVar2.deleteObserver(observer);
            return true;
        }
        return false;
    }
}
