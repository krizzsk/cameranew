package us.pinguo.smaatoapi;

import android.content.Context;
import android.content.Intent;
import us.pinguo.smaatoapi.activity.InsertitialActivity;
import us.pinguo.smaatoapi.activity.InsertitialWebActivity;
/* compiled from: SmaatoInsertitial.java */
/* loaded from: classes6.dex */
public class a {
    private Context a;
    private us.pinguo.smaatoapi.c.a b;

    /* compiled from: SmaatoInsertitial.java */
    /* renamed from: us.pinguo.smaatoapi.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0444a {
        void a(a aVar);

        void b(a aVar);

        void d(String str);

        void f(a aVar);

        void onInterstitialDismissed();

        void onInterstitialImpression();
    }

    public a(Context context, us.pinguo.smaatoapi.c.a aVar) {
        this.a = context;
        this.b = aVar;
    }

    public us.pinguo.smaatoapi.c.a a() {
        return this.b;
    }

    public void b() {
        if (this.b.a().equalsIgnoreCase("Img")) {
            this.a.startActivity(new Intent(this.a, InsertitialActivity.class));
        } else if (this.b.a().equalsIgnoreCase("Richmedia")) {
            this.a.startActivity(new Intent(this.a, InsertitialWebActivity.class));
        }
    }
}
