package us.pinguo.inspire.module.comment.cell;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import java.util.Objects;
import kotlin.jvm.internal.Ref$ObjectRef;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.widget.photopager.InfoTouchImageView;
import us.pinguo.ui.uilview.PhotoImageView;
import us.pinguo.user.util.f;
import vStudio.Android.Camera360.R;
/* compiled from: ImageInfoCell.kt */
/* loaded from: classes9.dex */
public final class ImageInfoCell extends ContentInfoCell {
    private final float MAX_WH_RATE;
    private int mIndex;
    private Bitmap tempBitmap;
    private String transitionName;

    /* compiled from: ImageInfoCell.kt */
    /* loaded from: classes9.dex */
    private static final class NoAnimDisplayer extends us.pinguo.foundation.t.a.f {
        public NoAnimDisplayer(int i2) {
            super(i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageInfoCell(InspireWork data, int i2) {
        super(data);
        kotlin.jvm.internal.s.h(data, "data");
        this.MAX_WH_RATE = 1.7777778f;
        this.mIndex = i2;
    }

    private final void calScaleLimit(int i2, int i3, int i4, int i5, int i6, InfoTouchImageView infoTouchImageView) {
        float f2;
        float f3 = i3;
        float f4 = i2 / f3;
        if (f4 >= 1.3333334f) {
            f2 = i6 / f3;
        } else {
            r4 = f4 < 1.0f ? 0.5f : 0.8f;
            f2 = 2.0f;
        }
        infoTouchImageView.setScaleLevels(r4, 1.0f, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final boolean m174onBindViewHolder$lambda0(ImageInfoCell this$0, Ref$ObjectRef photoImageView, com.github.chrisbanes.photoview.l lVar, float f2, float f3, float f4) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(photoImageView, "$photoImageView");
        if (Math.abs(lVar.N() - lVar.L()) < 0.001f) {
            f.b onDoubleClickListener = this$0.getOnDoubleClickListener();
            if (onDoubleClickListener != null) {
                onDoubleClickListener.onDoubleClick((View) photoImageView.element);
            }
        } else {
            lVar.k0(lVar.L(), f3, f4, true);
        }
        return true;
    }

    @Override // us.pinguo.inspire.y.a.b
    public us.pinguo.inspire.y.a.c createViewHolder(ViewGroup parent) {
        kotlin.jvm.internal.s.h(parent, "parent");
        return new us.pinguo.inspire.y.a.c(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_image_info, parent, false));
    }

    public final float getMAX_WH_RATE() {
        return this.MAX_WH_RATE;
    }

    public final int getMIndex() {
        return this.mIndex;
    }

    @Override // us.pinguo.inspire.module.comment.cell.BaseInfoCell
    public View getShareElement() {
        us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
        if (mViewHolder == null) {
            return null;
        }
        return (InfoTouchImageView) mViewHolder.a(R.id.piv_image_info);
    }

    public final Bitmap getTempBitmap() {
        return this.tempBitmap;
    }

    public final String getTransitionName() {
        return this.transitionName;
    }

    @Override // us.pinguo.inspire.y.a.b
    public int getType() {
        return BaseInfoCell.Companion.getTYPE_PIC();
    }

    @Override // us.pinguo.inspire.module.comment.cell.BaseInfoCell
    public boolean isContentPreparedForShare() {
        View view;
        us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
        PhotoImageView photoImageView = (mViewHolder == null || (view = mViewHolder.b) == null) ? null : (PhotoImageView) view.findViewById(R.id.piv_image_info);
        if ((photoImageView != null ? photoImageView.getDrawable() : null) instanceof us.pinguo.foundation.t.a.g) {
            Drawable drawable = photoImageView.getDrawable();
            Objects.requireNonNull(drawable, "null cannot be cast to non-null type us.pinguo.foundation.uilext.displayer.CenterCropRoundedDrawable");
            return ((us.pinguo.foundation.t.a.g) drawable).a() != null;
        } else if (us.pinguo.foundation.d.f10985d) {
            throw new RuntimeException("判断逻辑需要更新");
        } else {
            return false;
        }
    }

    @Override // us.pinguo.inspire.module.comment.cell.BaseInfoCell
    public boolean isFullScreen(View root) {
        View view;
        Matrix imageMatrix;
        Drawable drawable;
        Rect bounds;
        kotlin.jvm.internal.s.h(root, "root");
        us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
        Integer num = null;
        InfoTouchImageView infoTouchImageView = (mViewHolder == null || (view = mViewHolder.b) == null) ? null : (InfoTouchImageView) view.findViewById(R.id.piv_image_info);
        int[] iArr = new int[2];
        if (infoTouchImageView != null && (drawable = infoTouchImageView.getDrawable()) != null && (bounds = drawable.getBounds()) != null) {
            num = Integer.valueOf(bounds.height());
        }
        float[] fArr = new float[9];
        if (infoTouchImageView != null && (imageMatrix = infoTouchImageView.getImageMatrix()) != null) {
            imageMatrix.getValues(fArr);
        }
        return iArr[0] <= 0 && (num == null ? 0.0f : (float) num.intValue()) * fArr[0] >= ((float) root.getHeight());
    }

    public final boolean isScaled() {
        View view;
        us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
        InfoTouchImageView infoTouchImageView = null;
        if (mViewHolder != null && (view = mViewHolder.b) != null) {
            infoTouchImageView = (InfoTouchImageView) view.findViewById(R.id.piv_image_info);
        }
        return Math.abs((infoTouchImageView == null ? 1.0f : infoTouchImageView.e()) - 1.0f) > 1.0E-5f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, android.view.View] */
    @Override // us.pinguo.inspire.module.comment.cell.ContentInfoCell, us.pinguo.inspire.module.comment.cell.BaseInfoCell, us.pinguo.inspire.y.a.b
    public void onBindViewHolder(us.pinguo.inspire.y.a.c viewHolder) {
        int i2;
        int i3;
        String str;
        int c;
        int c2;
        kotlin.jvm.internal.s.h(viewHolder, "viewHolder");
        super.onBindViewHolder(viewHolder);
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ?? findViewById = viewHolder.b.findViewById(R.id.piv_image_info);
        ref$ObjectRef.element = findViewById;
        ((InfoTouchImageView) findViewById).setTag(R.id.tag_inspire_work, getMData());
        if (!getMData().isMulityPhotos()) {
            ViewCompat.setTransitionName((View) ref$ObjectRef.element, us.pinguo.inspire.util.transition.h.a.i(getMData()));
        } else {
            ViewCompat.setTransitionName((View) ref$ObjectRef.element, this.transitionName);
        }
        ((InfoTouchImageView) ref$ObjectRef.element).b().S(new com.github.chrisbanes.photoview.c() { // from class: us.pinguo.inspire.module.comment.cell.v
            @Override // com.github.chrisbanes.photoview.c
            public final boolean a(com.github.chrisbanes.photoview.l lVar, float f2, float f3, float f4) {
                boolean m174onBindViewHolder$lambda0;
                m174onBindViewHolder$lambda0 = ImageInfoCell.m174onBindViewHolder$lambda0(ImageInfoCell.this, ref$ObjectRef, lVar, f2, f3, f4);
                return m174onBindViewHolder$lambda0;
            }
        });
        int j2 = us.pinguo.foundation.t.b.a.j(us.pinguo.foundation.e.b());
        int h2 = us.pinguo.foundation.t.b.a.h(us.pinguo.foundation.e.b()) - us.pinguo.foundation.t.b.a.k();
        if (getMData().isMulityPhotos()) {
            i2 = getMData().members.get(this.mIndex).width;
            i3 = getMData().members.get(this.mIndex).height;
            str = getMData().members.get(this.mIndex).memUrl;
            kotlin.jvm.internal.s.g(str, "mData.members[mIndex].memUrl");
        } else {
            i2 = getMData().width;
            i3 = getMData().height;
            str = getMData().workUrl;
            kotlin.jvm.internal.s.g(str, "mData.workUrl");
        }
        int i4 = i2;
        int i5 = i3;
        float f2 = i4;
        float f3 = i5;
        float f4 = this.MAX_WH_RATE;
        int i6 = f2 / f3 > f4 ? (int) (j2 * (1 / f4)) : (int) (j2 * (f3 / f2));
        if (this.tempBitmap != null) {
            ((InfoTouchImageView) ref$ObjectRef.element).setImageDrawable(new us.pinguo.foundation.t.a.g(this.tempBitmap, 0, 0));
            ((InfoTouchImageView) ref$ObjectRef.element).resetViewBeforeLoading(false);
            ((InfoTouchImageView) ref$ObjectRef.element).setDisplayer(new NoAnimDisplayer(0));
            Bitmap bitmap = this.tempBitmap;
            kotlin.jvm.internal.s.e(bitmap);
            doBlur(bitmap);
        } else {
            us.pinguo.foundation.utils.n nVar = us.pinguo.foundation.utils.n.a;
            c = kotlin.z.j.c(j2, i4);
            c2 = kotlin.z.j.c(i6, i5);
            nVar.a(str, new com.facebook.imagepipeline.common.d(c, c2), new ImageInfoCell$onBindViewHolder$2(ref$ObjectRef, this));
        }
        T photoImageView = ref$ObjectRef.element;
        kotlin.jvm.internal.s.g(photoImageView, "photoImageView");
        calScaleLimit(j2, i6, i4, i5, h2, (InfoTouchImageView) photoImageView);
        ((InfoTouchImageView) ref$ObjectRef.element).setLoadingBgSize(j2, i6);
        if (getShowTransition()) {
            setShowTransition(false);
            ViewCompat.setTransitionName(viewHolder.b, "blurBg");
        }
    }

    public final void setMIndex(int i2) {
        this.mIndex = i2;
    }

    public final void setTempBitmap(Bitmap bitmap) {
        this.tempBitmap = bitmap;
    }

    public final void setTransitionName(String str) {
        this.transitionName = str;
        us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
        View a = mViewHolder == null ? null : mViewHolder.a(R.id.piv_image_info);
        if (a != null) {
            ViewCompat.setTransitionName(a, this.transitionName);
        }
    }
}
