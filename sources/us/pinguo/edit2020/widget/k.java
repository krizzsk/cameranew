package us.pinguo.edit2020.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.GravityCompat;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.io.File;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import kotlin.u;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.bean.TutorialModel;
import us.pinguo.foundation.video.FixedRateVideoView2;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.ui.widget.AlphaPressedConstraintLayout;
import us.pinguo.ui.widget.LanFitTextView;
/* compiled from: TutorialDialog.kt */
/* loaded from: classes4.dex */
public final class k extends Dialog implements View.OnClickListener {
    private final Context a;
    private final String b;
    private kotlin.jvm.b.a<u> c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Context mContext, String type) {
        super(mContext);
        s.h(mContext, "mContext");
        s.h(type, "type");
        this.a = mContext;
        this.b = type;
    }

    private final void a(FixedRateVideoView2 fixedRateVideoView2) {
        if (fixedRateVideoView2 != null) {
            if (fixedRateVideoView2.getVisibility() == 8) {
                if (fixedRateVideoView2.v()) {
                    fixedRateVideoView2.x();
                    return;
                }
                return;
            }
            fixedRateVideoView2.B();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(k this$0) {
        s.h(this$0, "this$0");
        ((SimpleDraweeView) this$0.findViewById(R.id.iv_tutorial_img)).setVisibility(8);
        FixedRateVideoView2 fixedRateVideoView2 = (FixedRateVideoView2) this$0.findViewById(R.id.vv_tutorial_video);
        fixedRateVideoView2.setVisibility(0);
        VdsAgent.onSetViewVisibility(fixedRateVideoView2, 0);
    }

    public final void d(kotlin.jvm.b.a<u> aVar) {
        this.c = aVar;
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i2 = R.id.tv_dismiss;
        if (valueOf != null && valueOf.intValue() == i2) {
            kotlin.jvm.b.a<u> aVar = this.c;
            if (aVar != null) {
                aVar.invoke();
            }
            dismiss();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        String g0;
        requestWindowFeature(1);
        super.onCreate(bundle);
        setContentView(R.layout.dialog_tutorial);
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        TutorialModel tutorialModel = TutorialModel.Companion.k(this.b)[0];
        String sourcePath = tutorialModel.getSourcePath();
        if (!(sourcePath.length() == 0)) {
            g0 = StringsKt__StringsKt.g0(sourcePath, InspirePublishFragment.FILE_HEADER);
            if (new File(g0).exists()) {
                int i2 = R.id.vv_tutorial_video;
                ((FixedRateVideoView2) findViewById(i2)).setVideoURI(Uri.parse(tutorialModel.getSourcePath()));
                int i3 = R.id.iv_tutorial_img;
                ((SimpleDraweeView) findViewById(i3)).setActualImageResource(tutorialModel.getDefaultCoverImg());
                ((SimpleDraweeView) findViewById(i3)).setVisibility(0);
                FixedRateVideoView2 fixedRateVideoView2 = (FixedRateVideoView2) findViewById(i2);
                fixedRateVideoView2.setVisibility(0);
                VdsAgent.onSetViewVisibility(fixedRateVideoView2, 0);
                ((FixedRateVideoView2) findViewById(i2)).setLooping(true);
                ((FixedRateVideoView2) findViewById(i2)).setOnStartListener(new us.pinguo.foundation.video.a() { // from class: us.pinguo.edit2020.widget.j
                    @Override // us.pinguo.foundation.video.a
                    public final void a() {
                        k.c(k.this);
                    }
                });
                a((FixedRateVideoView2) findViewById(i2));
                ((LanFitTextView) findViewById(R.id.tv_tutorial_desc)).setText(us.pinguo.foundation.e.b().getString(tutorialModel.getDesc()));
                ((AlphaPressedConstraintLayout) findViewById(R.id.tv_dismiss)).setOnClickListener(this);
            }
        }
        ((SimpleDraweeView) findViewById(R.id.iv_tutorial_img)).setActualImageResource(tutorialModel.getDefaultCoverImg());
        ImageView imageView = new ImageView(this.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        imageView.setImageResource(R.drawable.ic_video_symbol);
        layoutParams.setMarginEnd(us.pinguo.common.widget.i.a.a(11));
        layoutParams.topMargin = us.pinguo.common.widget.i.a.a(11);
        layoutParams.gravity = GravityCompat.END;
        ((FrameLayout) findViewById(R.id.fl_tutorial_img)).addView(imageView, layoutParams);
        ((LanFitTextView) findViewById(R.id.tv_tutorial_desc)).setText(us.pinguo.foundation.e.b().getString(tutorialModel.getDesc()));
        ((AlphaPressedConstraintLayout) findViewById(R.id.tv_dismiss)).setOnClickListener(this);
    }
}
