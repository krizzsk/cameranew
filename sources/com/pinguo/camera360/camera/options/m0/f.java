package com.pinguo.camera360.camera.options.m0;

import android.text.TextUtils;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;
import us.pinguo.foundation.domain.OptionsSettingEntry;
import us.pinguo.user.s0;
/* compiled from: OptionSettingManager.java */
/* loaded from: classes3.dex */
public class f {
    private CompositeSubscription a;

    private void a(Subscription subscription) {
        if (this.a == null) {
            this.a = new CompositeSubscription();
        }
        this.a.add(subscription);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(e eVar, OptionsSettingEntry optionsSettingEntry) {
        if (eVar != null) {
            eVar.a(optionsSettingEntry);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(e eVar, Throwable th) {
        us.pinguo.foundation.e.e(th);
        d.f.a.b.d.c(th);
        if (eVar != null) {
            eVar.b(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(e eVar, OptionsSettingEntry optionsSettingEntry) {
        if (eVar != null) {
            eVar.a(optionsSettingEntry);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f(e eVar, Throwable th) {
        us.pinguo.foundation.e.e(th);
        d.f.a.b.d.c(th);
        if (eVar != null) {
            eVar.b(th);
        }
    }

    public void b(final e eVar) {
        String userId = s0.getInstance().getUserId();
        if (TextUtils.isEmpty(userId)) {
            return;
        }
        a(us.pinguo.librouter.c.d.c().getInterface().d(userId).subscribe(new Action1() { // from class: com.pinguo.camera360.camera.options.m0.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                f.c(e.this, (OptionsSettingEntry) obj);
            }
        }, new Action1() { // from class: com.pinguo.camera360.camera.options.m0.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                f.d(e.this, (Throwable) obj);
            }
        }));
    }

    public void g() {
        CompositeSubscription compositeSubscription = this.a;
        if (compositeSubscription != null) {
            compositeSubscription.unsubscribe();
        }
    }

    public void h(OptionsSettingEntry optionsSettingEntry, final e eVar) {
        String userId = s0.getInstance().getUserId();
        if (TextUtils.isEmpty(userId)) {
            return;
        }
        a(us.pinguo.librouter.c.d.c().getInterface().i(userId, optionsSettingEntry).subscribe(new Action1() { // from class: com.pinguo.camera360.camera.options.m0.d
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                f.e(e.this, (OptionsSettingEntry) obj);
            }
        }, new Action1() { // from class: com.pinguo.camera360.camera.options.m0.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                f.f(e.this, (Throwable) obj);
            }
        }));
    }
}
