package us.pinguo.widet;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import us.pinguo.foundation.t.b.a;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.user.R;
import us.pinguo.user.s0;
/* loaded from: classes6.dex */
public class PortraitImageView extends HatImageView implements View.OnClickListener {

    /* renamed from: k  reason: collision with root package name */
    private String f12505k;

    /* renamed from: l  reason: collision with root package name */
    private int f12506l;
    private View.OnClickListener m;
    private Bitmap n;

    public PortraitImageView(Context context) {
        super(context);
        setOnClickListener(this);
    }

    public static void f(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(s0.getInstance().getUserId())) {
                h(context);
                return;
            } else {
                g(context, str);
                return;
            }
        }
        h(context);
    }

    public static void g(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName(context, "us.pinguo.inspire.module.profile.activity.GuestProfileActivity");
        intent.putExtra(GuestProfileFragment.USER_ID, str);
        context.startActivity(intent);
    }

    public static void h(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, "us.pinguo.inspire.module.profile.activity.ProfileActivity");
        context.startActivity(intent);
    }

    @Override // us.pinguo.widet.HatImageView
    public boolean e() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        View.OnClickListener onClickListener = this.m;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widet.HatImageView, us.pinguo.ui.uilview.CircleImageView, us.pinguo.ui.uilview.PhotoImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = new Rect();
        if (getWidth() < a.a(getContext(), 40.0f)) {
            rect.left = (int) (getWidth() * 0.67d);
            rect.right = (int) (getWidth() * 0.97d);
            rect.top = (int) (getHeight() * 0.68d);
            rect.bottom = (int) (getHeight() * 0.98d);
        } else {
            rect.left = (int) (getWidth() * 0.67d);
            rect.right = (int) (getWidth() * 0.97d);
            rect.top = (int) (getHeight() * 0.67d);
            rect.bottom = (int) (getHeight() * 0.97d);
        }
        int i2 = this.f12506l;
        if (i2 == 0) {
            return;
        }
        if (i2 == 101) {
            if (this.n == null) {
                if (getWidth() < a.a(getContext(), 40.0f)) {
                    this.n = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.official_master_icon);
                } else {
                    this.n = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.official_master_icon);
                }
            }
        } else if (this.n == null) {
            if (getWidth() < a.a(getContext(), 40.0f)) {
                this.n = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.master_icon);
            } else {
                this.n = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.master_icon);
            }
        }
        canvas.drawBitmap(this.n, (Rect) null, rect, (Paint) null);
    }

    public void setBeforeOnClickListener(View.OnClickListener onClickListener) {
        this.m = onClickListener;
    }

    public void setMark(int i2) {
    }

    public void setUserId(String str) {
        this.f12505k = str;
    }

    public void setUserType(int i2) {
        this.f12506l = i2;
    }

    public PortraitImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnClickListener(this);
    }

    public PortraitImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setOnClickListener(this);
    }
}
