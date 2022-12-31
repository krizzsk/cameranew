package us.pinguo.svideo.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.timepicker.TimeModel;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import us.pinguo.foundation.o.c;
import us.pinguo.foundation.statistics.l;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.librouter.module.inspire.d;
import us.pinguo.ui.uilview.PhotoImageView;
import us.pinguo.ui.widget.GaussianBlur.GaussianBlurImageView;
import vStudio.Android.Camera360.R;
/* loaded from: classes6.dex */
public class GuideChallengeActivity extends Activity implements View.OnClickListener {
    private TextView a;
    private PhotoImageView b;
    private Parcelable c;

    /* renamed from: d  reason: collision with root package name */
    private String f12067d;

    /* renamed from: e  reason: collision with root package name */
    private String f12068e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f12069f;

    /* renamed from: g  reason: collision with root package name */
    private String f12070g;

    /* renamed from: h  reason: collision with root package name */
    private GaussianBlurImageView f12071h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements c.a {
        final /* synthetic */ AlertDialog a;

        a(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // us.pinguo.foundation.o.c.a
        public void a() {
            try {
                try {
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (!this.a.isShowing()) {
                        return;
                    }
                }
                if (GuideChallengeActivity.this.c == null) {
                    if (this.a.isShowing()) {
                        this.a.dismiss();
                        return;
                    }
                    return;
                }
                Intent intent = new Intent();
                intent.setClassName(GuideChallengeActivity.this, "us.pinguo.inspire.module.MissionDetail.TaskDetailActivity");
                intent.putExtra("task", GuideChallengeActivity.this.c);
                intent.putExtra("task_detail_from_guide", true);
                GuideChallengeActivity.this.startActivity(intent);
                GuideChallengeActivity.this.finish();
                if (!this.a.isShowing()) {
                    return;
                }
                this.a.dismiss();
            } catch (Throwable th) {
                if (this.a.isShowing()) {
                    this.a.dismiss();
                }
                throw th;
            }
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

    private CharSequence b(int i2) {
        String string = getString(R.string.participant_count);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getResources().getColor(R.color.guide_challenge_btn_color));
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(us.pinguo.foundation.t.b.a.a(this, 15.0f));
        int length = string.split(TimeModel.NUMBER_FORMAT)[0].length();
        int length2 = String.valueOf(i2).length() + length;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.format(string, Integer.valueOf(i2)));
        spannableStringBuilder.setSpan(foregroundColorSpan, length, length2, 33);
        spannableStringBuilder.setSpan(absoluteSizeSpan, length, length2, 33);
        return spannableStringBuilder;
    }

    private void c(Parcelable parcelable) {
        String str;
        String str2;
        if (!TextUtils.isEmpty(this.f12067d)) {
            str = this.f12067d;
            str2 = InspirePublishFragment.FROM_EXIST_VIDEO;
        } else {
            str = this.f12068e;
            str2 = InspirePublishFragment.FROM_EXIST_PIC;
        }
        d dVar = us.pinguo.librouter.c.d.c().getInterface();
        dVar.h(this, parcelable, str2, this.f12070g, str, !TextUtils.isEmpty(this.f12067d), 1);
    }

    private void d(Context context, String str) {
        c.a.a(str, new a(us.pinguo.ui.b.a.a(context)));
    }

    private void e() {
        Bundle extras;
        if (getIntent() != null && (extras = getIntent().getExtras()) != null) {
            this.c = extras.getParcelable("task_key");
            this.f12067d = extras.getString("video_url_key");
            this.f12068e = extras.getString("pic_url_key");
            this.f12070g = extras.getString("key_first_frame_path");
        }
        if (this.c == null) {
            return;
        }
        this.f12071h = (GaussianBlurImageView) findViewById(R.id.guide_challenge_blur_image);
        this.a = (TextView) findViewById(R.id.guide_participant_count);
        this.b = (PhotoImageView) findViewById(R.id.guide_challenge_cover);
        this.f12069f = (TextView) findViewById(R.id.guide_challenge_tips);
        this.b.getLayoutParams().height = (int) (us.pinguo.foundation.t.b.a.j(this) / 1.0f);
        findViewById(R.id.btn_guide_participant).setOnClickListener(this);
        findViewById(R.id.btn_guide_back).setOnClickListener(this);
        f();
    }

    private void f() {
        String b = us.pinguo.librouter.c.d.c().getTaskInterface().b(this.c);
        int a2 = us.pinguo.librouter.c.d.c().getTaskInterface().a(this.c);
        String c = us.pinguo.librouter.c.d.c().getTaskInterface().c(this.c);
        this.b.setImageUri(b);
        this.f12071h.setImageUri(b);
        this.a.setText(b(a2));
        this.f12069f.setText("「" + c + "」");
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && i3 == -1) {
            c cVar = c.a;
            d(this, "Inspire");
            return;
        }
        finish();
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        int id = view.getId();
        if (id == R.id.btn_guide_back) {
            finish();
        } else if (id != R.id.btn_guide_participant) {
        } else {
            l.h(BaseApplication.d(), "pc_participate_to_challenges");
            c(this.c);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.guide_challenge_layout);
        l.h(BaseApplication.d(), "pc_guide_to_challenges");
        e();
    }
}
