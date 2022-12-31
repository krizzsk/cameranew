package us.pinguo.inspire_proxy.b.a;

import android.app.Activity;
import android.os.Parcelable;
import rx.Observable;
import rx.Subscriber;
import us.pinguo.foundation.domain.OptionsSettingEntry;
import us.pinguo.librouter.module.inspire.d;
import us.pinguo.librouter.module.inspire.f;
/* compiled from: InspireDefauleInterface.java */
/* loaded from: classes4.dex */
public class a implements d {

    /* compiled from: InspireDefauleInterface.java */
    /* renamed from: us.pinguo.inspire_proxy.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0414a implements Observable.OnSubscribe<OptionsSettingEntry> {
        C0414a(a aVar) {
        }

        @Override // rx.functions.Action1
        /* renamed from: a */
        public void call(Subscriber<? super OptionsSettingEntry> subscriber) {
            subscriber.onError(new Exception("InspireDefauleInterface"));
        }
    }

    /* compiled from: InspireDefauleInterface.java */
    /* loaded from: classes4.dex */
    class b implements Observable.OnSubscribe<OptionsSettingEntry> {
        b(a aVar) {
        }

        @Override // rx.functions.Action1
        /* renamed from: a */
        public void call(Subscriber<? super OptionsSettingEntry> subscriber) {
            subscriber.onError(new Exception("InspireDefauleInterface"));
        }
    }

    /* compiled from: InspireDefauleInterface.java */
    /* loaded from: classes4.dex */
    class c implements f {
        c(a aVar) {
        }

        @Override // us.pinguo.librouter.module.inspire.f
        public int a(Object obj) {
            return 0;
        }

        @Override // us.pinguo.librouter.module.inspire.f
        public String b(Object obj) {
            return null;
        }

        @Override // us.pinguo.librouter.module.inspire.f
        public String c(Object obj) {
            return null;
        }
    }

    @Override // us.pinguo.librouter.module.inspire.d
    public void a(Activity activity, int i2, int i3, String str) {
    }

    @Override // us.pinguo.librouter.module.inspire.d
    public String b() {
        return "";
    }

    @Override // us.pinguo.librouter.module.inspire.d
    public String c(String str) {
        return str;
    }

    @Override // us.pinguo.librouter.module.inspire.d
    public Observable<OptionsSettingEntry> d(String str) {
        return Observable.create(new C0414a(this));
    }

    @Override // us.pinguo.librouter.module.inspire.d
    public Object e(String str, boolean z) {
        return new us.pinguo.inspire_proxy.c.a(str, z);
    }

    @Override // us.pinguo.librouter.module.inspire.d
    public f f() {
        return new c(this);
    }

    @Override // us.pinguo.librouter.module.inspire.d
    public boolean g(Object obj) {
        return false;
    }

    @Override // us.pinguo.librouter.module.inspire.d
    public void h(Activity activity, Parcelable parcelable, String str, String str2, String str3, boolean z, int i2) {
    }

    @Override // us.pinguo.librouter.module.inspire.d
    public Observable<OptionsSettingEntry> i(String str, OptionsSettingEntry optionsSettingEntry) {
        return Observable.create(new b(this));
    }
}
