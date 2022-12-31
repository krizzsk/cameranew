package us.pinguo.inspire.widget.progress;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class InspireProgressDialog extends Dialog {
    private Style a;
    private BabyProgressView b;
    private us.pinguo.inspire.widget.progress.a c;

    /* loaded from: classes9.dex */
    public enum Style {
        DEFAULT_CIRCLE,
        PROGRESS_CIRCLE
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Style.values().length];
            a = iArr;
            try {
                iArr[Style.DEFAULT_CIRCLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Style.PROGRESS_CIRCLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public InspireProgressDialog(Context context) {
        this(context, Style.PROGRESS_CIRCLE);
    }

    private void a() {
        setContentView(R.layout.inspire_progress_default_circle_layout);
        this.c = new us.pinguo.inspire.widget.progress.a();
        TextView textView = (TextView) findViewById(R.id.baby_progress_default_circle_content);
        this.c.b = (ImageView) findViewById(R.id.baby_progress_default_circle_error);
        this.c.c = (ProgressBar) findViewById(R.id.baby_progress_default_circle_progress);
        this.c.a = (ImageView) findViewById(R.id.baby_progress_default_circle_success);
    }

    private void b() {
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.inspire_progress_size);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        BabyProgressView babyProgressView = new BabyProgressView(getContext());
        this.b = babyProgressView;
        setContentView(babyProgressView, layoutParams);
    }

    private void c() {
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        int i2 = a.a[this.a.ordinal()];
        if (i2 == 1) {
            a();
        } else if (i2 != 2) {
        } else {
            b();
        }
    }

    public InspireProgressDialog(Context context, Style style) {
        super(context);
        this.a = Style.PROGRESS_CIRCLE;
        this.a = style;
        c();
    }
}
