package us.pinguo.inspire.util.transition;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.transition.ChangeBounds;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import com.facebook.drawee.drawable.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.discovery.entity.InspireFeed;
import us.pinguo.inspire.module.discovery.entity.InspireFeedContent;
import us.pinguo.inspire.widget.PhotoGridView;
import us.pinguo.inspire.widget.fresco.WebpDraweeView;
import vStudio.Android.Camera360.R;
/* compiled from: TransitionHelper.kt */
@TargetApi(21)
/* loaded from: classes9.dex */
public final class h {
    public static final h a = new h();
    private static final int b = 250;
    private static final boolean c;

    /* compiled from: TransitionHelper.kt */
    /* loaded from: classes9.dex */
    public static final class a extends SharedElementCallback {
        final /* synthetic */ Activity a;
        final /* synthetic */ us.pinguo.inspire.util.transition.c b;

        a(Activity activity, us.pinguo.inspire.util.transition.c cVar) {
            this.a = activity;
            this.b = cVar;
        }

        @Override // android.app.SharedElementCallback
        public View onCreateSnapshotView(Context context, Parcelable snapshot) {
            s.h(context, "context");
            s.h(snapshot, "snapshot");
            if (snapshot instanceof RotationInfo) {
                RotationInfo rotationInfo = (RotationInfo) snapshot;
                Parcelable parcelable = rotationInfo.parcelable;
                View view = super.onCreateSnapshotView(context, parcelable);
                view.setTag(R.id.tag_rotated, Float.valueOf(rotationInfo.rotation));
                if (parcelable instanceof Bitmap) {
                    Bitmap bitmap = (Bitmap) parcelable;
                    view.setLayoutParams(new ViewGroup.LayoutParams(bitmap.getHeight(), bitmap.getWidth()));
                }
                s.g(view, "view");
                return view;
            } else if (snapshot instanceof TouchScaleInfo) {
                View view2 = super.onCreateSnapshotView(context, ((TouchScaleInfo) snapshot).bitmap);
                view2.setTag(R.id.tag_element_info, snapshot);
                s.g(view2, "view");
                return view2;
            } else {
                View onCreateSnapshotView = super.onCreateSnapshotView(context, snapshot);
                s.g(onCreateSnapshotView, "super.onCreateSnapshotView(context, snapshot)");
                return onCreateSnapshotView;
            }
        }

        @Override // android.app.SharedElementCallback
        public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
            s.h(names, "names");
            s.h(sharedElements, "sharedElements");
            h.a.k(this.a, this.b, names, sharedElements);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementStart(List<String> sharedElementNames, List<? extends View> sharedElements, List<? extends View> sharedElementSnapshots) {
            s.h(sharedElementNames, "sharedElementNames");
            s.h(sharedElements, "sharedElements");
            s.h(sharedElementSnapshots, "sharedElementSnapshots");
            int size = sharedElements.size();
            int i2 = 0;
            while (i2 < size) {
                int i3 = i2 + 1;
                if (h.a.g(sharedElements.get(i2))) {
                    View view = sharedElementSnapshots.get(i2);
                    if (view == null) {
                        return;
                    }
                    Object tag = view.getTag(R.id.tag_rotated);
                    if (tag instanceof Float) {
                        sharedElements.get(i2).setTag(R.id.tag_rotated, tag);
                    }
                } else {
                    View view2 = sharedElementSnapshots.get(i2);
                    if ((view2 == null ? null : view2.getTag(R.id.tag_element_info)) instanceof TouchScaleInfo) {
                        View view3 = sharedElementSnapshots.get(i2);
                        Object tag2 = view3 != null ? view3.getTag(R.id.tag_element_info) : null;
                        Objects.requireNonNull(tag2, "null cannot be cast to non-null type us.pinguo.inspire.util.transition.TouchScaleInfo");
                        TouchScaleInfo touchScaleInfo = (TouchScaleInfo) tag2;
                        Rect rect = touchScaleInfo.bounds;
                        View view4 = sharedElements.get(i2);
                        view4.setTag(R.id.tag_element_info, touchScaleInfo);
                        view4.measure(View.MeasureSpec.makeMeasureSpec(rect.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(rect.height(), 1073741824));
                        view4.layout(rect.left, rect.top, rect.right, rect.bottom);
                    }
                }
                i2 = i3;
            }
        }
    }

    /* compiled from: TransitionHelper.kt */
    /* loaded from: classes9.dex */
    public static final class b extends SharedElementCallback {
        final /* synthetic */ Activity a;
        final /* synthetic */ us.pinguo.inspire.util.transition.c b;

        b(Activity activity, us.pinguo.inspire.util.transition.c cVar) {
            this.a = activity;
            this.b = cVar;
        }

        @Override // android.app.SharedElementCallback
        public Parcelable onCaptureSharedElementSnapshot(View sharedElement, Matrix viewToGlobalMatrix, RectF screenBounds) {
            TouchScaleInfo touchScaleInfo;
            s.h(sharedElement, "sharedElement");
            s.h(viewToGlobalMatrix, "viewToGlobalMatrix");
            s.h(screenBounds, "screenBounds");
            Parcelable onCaptureSharedElementSnapshot = super.onCaptureSharedElementSnapshot(sharedElement, viewToGlobalMatrix, screenBounds);
            if (sharedElement instanceof WebpDraweeView) {
                if (!(sharedElement.getRotation() == 0.0f)) {
                    RotationInfo rotationInfo = new RotationInfo();
                    rotationInfo.parcelable = onCaptureSharedElementSnapshot;
                    rotationInfo.rotation = sharedElement.getRotation();
                    return rotationInfo;
                }
            }
            if (sharedElement instanceof PhotoGridView) {
                Object tag = sharedElement.getTag(R.id.tag_element_info);
                touchScaleInfo = tag instanceof TouchScaleInfo ? (TouchScaleInfo) tag : null;
                if (touchScaleInfo == null) {
                    if (onCaptureSharedElementSnapshot == null) {
                        onCaptureSharedElementSnapshot = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
                    }
                    s.g(onCaptureSharedElementSnapshot, "parcelable ?: Bitmap.cre…1, Bitmap.Config.RGB_565)");
                    return onCaptureSharedElementSnapshot;
                }
                return touchScaleInfo;
            } else if (sharedElement.getId() != R.id.profile_image_view) {
                if (onCaptureSharedElementSnapshot == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
                    s.g(createBitmap, "createBitmap(1, 1, Bitmap.Config.RGB_565)");
                    return createBitmap;
                }
                return onCaptureSharedElementSnapshot;
            } else {
                Object tag2 = sharedElement.getTag(R.id.tag_element_info);
                boolean z = tag2 instanceof TouchScaleInfo;
                if (z) {
                    if (onCaptureSharedElementSnapshot instanceof Bitmap) {
                        ((TouchScaleInfo) tag2).bitmap = (Bitmap) onCaptureSharedElementSnapshot;
                    } else {
                        ((TouchScaleInfo) tag2).bitmap = h.a.c(sharedElement, viewToGlobalMatrix, screenBounds);
                    }
                }
                touchScaleInfo = z ? (TouchScaleInfo) tag2 : null;
                if (touchScaleInfo == null) {
                    if (onCaptureSharedElementSnapshot == null) {
                        onCaptureSharedElementSnapshot = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
                    }
                    s.g(onCaptureSharedElementSnapshot, "parcelable ?: Bitmap.cre…1, Bitmap.Config.RGB_565)");
                    return onCaptureSharedElementSnapshot;
                }
                return touchScaleInfo;
            }
        }

        @Override // android.app.SharedElementCallback
        public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
            s.h(names, "names");
            s.h(sharedElements, "sharedElements");
            h.a.k(this.a, this.b, names, sharedElements);
        }
    }

    /* compiled from: TransitionHelper.kt */
    /* loaded from: classes9.dex */
    public static final class c implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ View a;
        final /* synthetic */ Activity b;

        c(View view, Activity activity) {
            this.a = view;
            this.b = activity;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        @SuppressLint({"NewApi"})
        public boolean onPreDraw() {
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
            this.b.startPostponedEnterTransition();
            return true;
        }
    }

    /* compiled from: TransitionHelper.kt */
    /* loaded from: classes9.dex */
    public static final class d implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ View a;
        final /* synthetic */ Runnable b;
        final /* synthetic */ Activity c;

        d(View view, Runnable runnable, Activity activity) {
            this.a = view;
            this.b = runnable;
            this.c = activity;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        @SuppressLint({"NewApi"})
        public boolean onPreDraw() {
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
            this.a.requestLayout();
            Runnable runnable = this.b;
            if (runnable != null) {
                runnable.run();
            }
            this.c.startPostponedEnterTransition();
            return true;
        }
    }

    static {
        c = Build.VERSION.SDK_INT >= 21;
    }

    private h() {
    }

    @RequiresApi(api = 21)
    private final TransitionSet b(p.c cVar, p.c cVar2) {
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new com.facebook.drawee.view.c(cVar, cVar2));
        return transitionSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(Activity activity, us.pinguo.inspire.util.transition.c cVar, List<String> list, Map<String, View> map) {
        View changedShareElement = cVar.getChangedShareElement();
        if (changedShareElement == null) {
            return;
        }
        View decorView = activity.getWindow().getDecorView();
        s.g(decorView, "srcActivity.window.decorView");
        if (h(decorView, changedShareElement)) {
            list.clear();
            map.clear();
            String transitionName = ViewCompat.getTransitionName(changedShareElement);
            s.e(transitionName);
            s.g(transitionName, "getTransitionName(changedShareView)!!");
            list.add(transitionName);
            String transitionName2 = ViewCompat.getTransitionName(changedShareElement);
            s.e(transitionName2);
            s.g(transitionName2, "getTransitionName(changedShareView)!!");
            map.put(transitionName2, changedShareElement);
            return;
        }
        list.clear();
        map.clear();
    }

    public static /* synthetic */ void u(h hVar, Activity activity, View view, Runnable runnable, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            runnable = null;
        }
        hVar.t(activity, view, runnable);
    }

    public final Bitmap c(View view, Matrix matrix, RectF bounds) {
        s.h(view, "view");
        s.h(matrix, "matrix");
        s.h(bounds, "bounds");
        int round = Math.round(bounds.width());
        int round2 = Math.round(bounds.height());
        if (round <= 0 || round2 <= 0) {
            return null;
        }
        float min = Math.min(1.0f, 1048576 / (round * round2));
        matrix.postTranslate(-bounds.left, -bounds.top);
        matrix.postScale(min, min);
        Bitmap createBitmap = Bitmap.createBitmap((int) (round * min), (int) (round2 * min), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.concat(matrix);
        view.draw(canvas);
        return createBitmap;
    }

    public final void d(Activity activity) {
        s.h(activity, "activity");
        if (c) {
            activity.getWindow().requestFeature(12);
        }
    }

    public final boolean e() {
        return c;
    }

    public final Bundle f(Activity activity, View... shareView) {
        s.h(activity, "activity");
        s.h(shareView, "shareView");
        if (c) {
            View findViewById = activity.findViewById(16908335);
            View findViewById2 = activity.findViewById(16908336);
            ArrayList arrayList = new ArrayList();
            if (findViewById != null) {
                arrayList.add(Pair.create(findViewById, "android:status:background"));
            }
            if (findViewById2 != null) {
                arrayList.add(Pair.create(findViewById2, "android:navigation:background"));
            }
            for (View view : shareView) {
                arrayList.add(Pair.create(view, view.getTransitionName()));
            }
            Object[] array = arrayList.toArray(new Pair[0]);
            s.f(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            Pair[] pairArr = (Pair[]) array;
            ActivityOptionsCompat makeSceneTransitionAnimation = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, (Pair[]) Arrays.copyOf(pairArr, pairArr.length));
            s.g(makeSceneTransitionAnimation, "makeSceneTransitionAnima…on(activity, *pairsArray)");
            return makeSceneTransitionAnimation.toBundle();
        }
        return null;
    }

    public final boolean g(View view) {
        s.h(view, "view");
        return view.getId() == R.id.video_info_content;
    }

    public final boolean h(View decorView, View view) {
        s.h(decorView, "decorView");
        s.h(view, "view");
        Rect rect = new Rect();
        decorView.getHitRect(rect);
        return view.getLocalVisibleRect(rect);
    }

    public final String i(InspireWork work) {
        s.h(work, "work");
        return work.getWorkId();
    }

    public final String j(InspireFeed inspireFeed) {
        if ((inspireFeed == null ? null : inspireFeed.getFcnt()) != null) {
            InspireFeedContent fcnt = inspireFeed.getFcnt();
            s.e(fcnt);
            String str = fcnt.workId;
            s.g(str, "feed.getFcnt()!!.workId");
            return str;
        }
        return "";
    }

    public final void l(Activity activity) {
        s.h(activity, "activity");
        if (c) {
            activity.postponeEnterTransition();
        }
    }

    public final void m(Activity dstActivity, us.pinguo.inspire.util.transition.c getShareElement) {
        s.h(dstActivity, "dstActivity");
        s.h(getShareElement, "getShareElement");
        if (c) {
            dstActivity.setEnterSharedElementCallback(new a(dstActivity, getShareElement));
        }
    }

    public final void n(Activity srcActivity, us.pinguo.inspire.util.transition.c getShareElement) {
        s.h(srcActivity, "srcActivity");
        s.h(getShareElement, "getShareElement");
        if (c) {
            srcActivity.setExitSharedElementCallback(new b(srcActivity, getShareElement));
        }
    }

    public final void o(Activity activity) {
        s.h(activity, "activity");
        if (c) {
            p.c CENTER_CROP = p.c.f2566g;
            s.g(CENTER_CROP, "CENTER_CROP");
            p.c FIT_CENTER = p.c.c;
            s.g(FIT_CENTER, "FIT_CENTER");
            TransitionSet b2 = b(CENTER_CROP, FIT_CENTER);
            s.g(FIT_CENTER, "FIT_CENTER");
            s.g(CENTER_CROP, "CENTER_CROP");
            TransitionSet b3 = b(FIT_CENTER, CENTER_CROP);
            b2.addTransition(new us.pinguo.inspire.util.transition.d(true));
            b3.addTransition(new us.pinguo.inspire.util.transition.d(false));
            b2.addTransition(new g(true));
            b3.addTransition(new g(false));
            b2.addTransition(new e(true));
            b3.addTransition(new e(false));
            int i2 = b;
            b2.setDuration(i2);
            b3.setDuration(i2);
            activity.getWindow().setSharedElementEnterTransition(b2);
            activity.getWindow().setSharedElementReturnTransition(b3);
        }
    }

    public final void p(Activity activity) {
        s.h(activity, "activity");
        if (c) {
            p.c CENTER_CROP = p.c.f2566g;
            s.g(CENTER_CROP, "CENTER_CROP");
            p.c FIT_CENTER = p.c.c;
            s.g(FIT_CENTER, "FIT_CENTER");
            TransitionSet b2 = b(CENTER_CROP, FIT_CENTER);
            s.g(FIT_CENTER, "FIT_CENTER");
            s.g(CENTER_CROP, "CENTER_CROP");
            TransitionSet b3 = b(FIT_CENTER, CENTER_CROP);
            b2.addTransition(new ChangeBounds());
            b3.addTransition(new ChangeBounds());
            b2.addTransition(new f(true));
            b3.addTransition(new f(false));
            int i2 = b;
            b2.setDuration(i2);
            b3.setDuration(i2);
            activity.getWindow().setSharedElementEnterTransition(b2);
            activity.getWindow().setSharedElementReturnTransition(b3);
        }
    }

    public final boolean q(InspireWork work) {
        s.h(work, "work");
        return false;
    }

    public final void r(Activity activity, View shareElement, String str) {
        s.h(activity, "activity");
        s.h(shareElement, "shareElement");
        if (c) {
            if (!s.c("from_feed", str) && !s.c("from_profile", str)) {
                o(activity);
            } else {
                p(activity);
            }
            shareElement.getViewTreeObserver().addOnPreDrawListener(new c(shareElement, activity));
        }
    }

    public final void s(Activity activity, View view) {
        s.h(activity, "activity");
        u(this, activity, view, null, 4, null);
    }

    public final void t(Activity activity, View view, Runnable runnable) {
        s.h(activity, "activity");
        if (!c || view == null) {
            return;
        }
        view.getViewTreeObserver().addOnPreDrawListener(new d(view, runnable, activity));
        view.invalidate();
    }
}
