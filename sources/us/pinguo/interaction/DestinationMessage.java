package us.pinguo.interaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.foundation.base.InspireContentActivity;
import us.pinguo.foundation.o.c;
/* compiled from: DestinationMessage.kt */
/* loaded from: classes4.dex */
public final class DestinationMessage extends us.pinguo.foundation.interaction.b {

    /* compiled from: DestinationMessage.kt */
    /* loaded from: classes4.dex */
    public static final class a implements c.a {
        final /* synthetic */ AlertDialog a;
        final /* synthetic */ kotlin.jvm.b.a<kotlin.u> b;

        a(AlertDialog alertDialog, kotlin.jvm.b.a<kotlin.u> aVar) {
            this.a = alertDialog;
            this.b = aVar;
        }

        @Override // us.pinguo.foundation.o.c.a
        public void a() {
            if (this.a.isShowing()) {
                this.a.dismiss();
            }
            kotlin.jvm.b.a<kotlin.u> aVar = this.b;
            if (aVar == null) {
                return;
            }
            aVar.invoke();
        }

        @Override // us.pinguo.foundation.o.c.a
        public void b() {
            if (this.a.isShowing()) {
                this.a.dismiss();
            }
        }

        @Override // us.pinguo.foundation.o.c.a
        public void c() {
            AlertDialog alertDialog = this.a;
            alertDialog.show();
            VdsAgent.showDialog(alertDialog);
        }

        @Override // us.pinguo.foundation.o.c.a
        public void d() {
            if (this.a.isShowing()) {
                this.a.dismiss();
            }
        }

        @Override // us.pinguo.foundation.o.c.a
        public void e() {
        }

        @Override // us.pinguo.foundation.o.c.a
        public void f(int i2) {
        }

        @Override // us.pinguo.foundation.o.c.a
        public void g() {
            if (this.a.isShowing()) {
                this.a.dismiss();
            }
        }
    }

    private final void l(Context context, String str, kotlin.jvm.b.a<kotlin.u> aVar) {
        us.pinguo.foundation.o.c.a.a(str, new a(us.pinguo.ui.b.a.a(context), aVar));
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public Intent a(Uri uri, Bundle extra, Context context) {
        kotlin.jvm.internal.s.h(uri, "uri");
        kotlin.jvm.internal.s.h(extra, "extra");
        kotlin.jvm.internal.s.h(context, "context");
        Intent intent = new Intent(context, InspireContentActivity.class);
        intent.putExtra(InspireContentActivity.FRAGMENT_NAME, "us.pinguo.inspire.module.message.category.fragment.InspireMsgFragment");
        return intent;
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public void b(Uri uri, Context context, Intent intent) {
        kotlin.jvm.internal.s.h(uri, "uri");
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(intent, "intent");
        l(context, "Inspire", new DestinationMessage$launchIntent$1(this, uri, context, intent));
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        boolean x;
        kotlin.jvm.internal.s.h(uri, "uri");
        String uri2 = uri.toString();
        kotlin.jvm.internal.s.g(uri2, "uri.toString()");
        x = kotlin.text.t.x(uri2, "app://camera360/portal/message", false, 2, null);
        return x;
    }
}
