package us.pinguo.smaatoapi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.e;
import com.bumptech.glide.request.g.j;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import us.pinguo.smaatoapi.R;
import us.pinguo.smaatoapi.network.InsertitialLoader;
/* loaded from: classes6.dex */
public class InsertitialActivity extends AppCompatActivity {
    private ImageView a;
    private ImageView b;

    /* loaded from: classes6.dex */
    class a implements com.bumptech.glide.request.c<String, com.bumptech.glide.load.h.e.b> {
        final /* synthetic */ us.pinguo.smaatoapi.c.a a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: us.pinguo.smaatoapi.activity.InsertitialActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0445a implements Runnable {
            RunnableC0445a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.a.g() == null || a.this.a.g().size() <= 0) {
                    return;
                }
                a aVar = a.this;
                us.pinguo.smaatoapi.network.a.b(InsertitialActivity.this, aVar.a.g().get(0), null);
            }
        }

        a(us.pinguo.smaatoapi.c.a aVar) {
            this.a = aVar;
        }

        @Override // com.bumptech.glide.request.c
        /* renamed from: c */
        public boolean a(Exception exc, String str, j<com.bumptech.glide.load.h.e.b> jVar, boolean z) {
            return false;
        }

        @Override // com.bumptech.glide.request.c
        /* renamed from: d */
        public boolean b(com.bumptech.glide.load.h.e.b bVar, String str, j<com.bumptech.glide.load.h.e.b> jVar, boolean z, boolean z2) {
            if (this.a.g().size() > 0) {
                new Thread(new RunnableC0445a()).start();
            }
            this.a.h().onInterstitialImpression();
            return false;
        }
    }

    /* loaded from: classes6.dex */
    class b implements View.OnClickListener {
        final /* synthetic */ us.pinguo.smaatoapi.c.a a;

        /* loaded from: classes6.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                us.pinguo.smaatoapi.network.a.b(InsertitialActivity.this, bVar.a.c().get(0), null);
            }
        }

        b(us.pinguo.smaatoapi.c.a aVar) {
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            if (this.a.c().size() > 0) {
                new Thread(new a()).start();
            }
            if (this.a.b() != null) {
                Intent intent = new Intent(InsertitialActivity.this, WebViewActivity.class);
                intent.putExtra("url", this.a.b());
                InsertitialActivity.this.startActivity(intent);
            }
            this.a.h().f(InsertitialLoader.b(InsertitialActivity.this).f11991d);
            this.a.h().onInterstitialDismissed();
            InsertitialActivity.this.finish();
        }
    }

    /* loaded from: classes6.dex */
    class c implements View.OnClickListener {
        final /* synthetic */ us.pinguo.smaatoapi.c.a a;

        c(us.pinguo.smaatoapi.c.a aVar) {
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            this.a.h().onInterstitialDismissed();
            InsertitialActivity.this.finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_insertitial);
        this.a = (ImageView) findViewById(R.id.adImage);
        this.b = (ImageView) findViewById(R.id.closeBtn);
        us.pinguo.smaatoapi.c.a a2 = InsertitialLoader.b(this).f11991d.a();
        if (a2 == null) {
            finish();
            return;
        }
        a2.h().b(InsertitialLoader.b(this).f11991d);
        int a3 = us.pinguo.smaatoapi.d.a.a(this, a2.i());
        int a4 = us.pinguo.smaatoapi.d.a.a(this, a2.d());
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.a.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).height = a4;
        ((ViewGroup.MarginLayoutParams) layoutParams).width = a3;
        this.a.setLayoutParams(layoutParams);
        com.bumptech.glide.b<String> q = e.r(this).q(a2.f());
        q.z(new a(a2));
        q.j(this.a);
        this.a.setOnClickListener(new b(a2));
        this.b.setOnClickListener(new c(a2));
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }
}
