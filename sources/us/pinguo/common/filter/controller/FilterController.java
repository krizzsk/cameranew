package us.pinguo.common.filter.controller;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewKt;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.effect.model.entity.Effect;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.common.EventType;
import us.pinguo.common.filter.CameraFilterModule;
import us.pinguo.common.filter.ChangeStatus;
import us.pinguo.common.filter.controller.FilterController;
import us.pinguo.common.filter.view.FilterPackageListView;
import us.pinguo.common.filter.view.FilterPanelItemView;
import us.pinguo.common.filter.view.FilterPanelTabView;
import us.pinguo.common.filter.view.FilterPanelView;
import us.pinguo.common.h;
import us.pinguo.common.widget.FilterLayerOpacityAdjustSelector;
import us.pinguo.common.widget.ScrollCenterLayoutManager;
import us.pinguo.commonui.R;
import us.pinguo.foundation.utils.d0;
import us.pinguo.foundation.utils.k0;
import us.pinguo.foundation.utils.w;
import us.pinguo.repository2020.FilterConstants;
import us.pinguo.repository2020.entity.CategoryItem;
import us.pinguo.repository2020.entity.FilterEntry;
import us.pinguo.repository2020.entity.FilterItem;
import us.pinguo.repository2020.entity.PackageItem;
import us.pinguo.repository2020.entity.SkyParamsRecord;
import us.pinguo.repository2020.m;
import us.pinguo.repository2020.q;
import us.pinguo.repository2020.utils.o;
import us.pinguo.ui.widget.AutofitTextView;
import us.pinguo.ui.widget.StickySeekBar;
import us.pinguo.ui.widget.h;
/* compiled from: FilterController.kt */
/* loaded from: classes4.dex */
public class FilterController implements us.pinguo.common.h, us.pinguo.common.g, FilterPanelView.a {
    private final FilterPanelView a;
    private final CameraFilterModule b;
    private final boolean c;

    /* renamed from: d */
    private kotlin.jvm.b.l<? super String, u> f9830d;

    /* renamed from: e */
    private final Context f9831e;

    /* renamed from: f */
    private List<CategoryItem> f9832f;

    /* renamed from: g */
    private List<PackageItem> f9833g;

    /* renamed from: h */
    private us.pinguo.common.filter.guide.c f9834h;

    /* renamed from: i */
    private kotlin.jvm.b.l<? super us.pinguo.common.filter.guide.c, u> f9835i;

    /* renamed from: j */
    private int f9836j;

    /* renamed from: k */
    private final int f9837k;

    /* renamed from: l */
    private final int f9838l;
    private boolean m;
    private PackageItem n;
    private boolean o;
    private boolean p;
    private final HashSet<String> q;
    private ConstraintLayout r;
    private volatile boolean s;
    private boolean t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FilterController.kt */
    /* renamed from: us.pinguo.common.filter.controller.FilterController$1 */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends Lambda implements p<PackageItem, Integer, u> {

        /* compiled from: FilterController.kt */
        @DebugMetadata(c = "us.pinguo.common.filter.controller.FilterController$1$1", f = "FilterController.kt", i = {1}, l = {97, 103, 105}, m = "invokeSuspend", n = {"filterId"}, s = {"L$0"})
        /* renamed from: us.pinguo.common.filter.controller.FilterController$1$1 */
        /* loaded from: classes4.dex */
        public static final class C03751 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
            Object L$0;
            int label;
            final /* synthetic */ FilterController this$0;

            /* compiled from: FilterController.kt */
            @DebugMetadata(c = "us.pinguo.common.filter.controller.FilterController$1$1$1", f = "FilterController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: us.pinguo.common.filter.controller.FilterController$1$1$1 */
            /* loaded from: classes4.dex */
            public static final class C03761 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
                final /* synthetic */ String $filterId;
                final /* synthetic */ boolean $textureVisible;
                int label;
                final /* synthetic */ FilterController this$0;

                /* compiled from: FilterController.kt */
                /* renamed from: us.pinguo.common.filter.controller.FilterController$1$1$1$a */
                /* loaded from: classes4.dex */
                public static final class a implements us.pinguo.ui.widget.h {
                    private boolean a;
                    final /* synthetic */ FilterController b;
                    final /* synthetic */ ConstraintLayout c;

                    /* renamed from: d */
                    final /* synthetic */ Ref$ObjectRef<ConstraintLayout> f9839d;

                    a(FilterController filterController, ConstraintLayout constraintLayout, Ref$ObjectRef<ConstraintLayout> ref$ObjectRef) {
                        this.b = filterController;
                        this.c = constraintLayout;
                        this.f9839d = ref$ObjectRef;
                    }

                    @Override // us.pinguo.ui.widget.h
                    public void b(int i2) {
                        SkyParamsRecord skyParamsRecord;
                        this.a = false;
                        this.b.b.h0(false);
                        ImageView imageView = (ImageView) this.f9839d.element.findViewById(R.id.imgSkyChangeMirror);
                        s.g(imageView, "panel.imgSkyChangeMirror");
                        imageView.setVisibility(0);
                        VdsAgent.onSetViewVisibility(imageView, 0);
                        this.c.setBackgroundColor(Color.parseColor("#66000000"));
                        ConstraintLayout constraintLayout = (ConstraintLayout) this.f9839d.element.findViewById(R.id.clMix);
                        s.g(constraintLayout, "panel.clMix");
                        constraintLayout.setVisibility(0);
                        VdsAgent.onSetViewVisibility(constraintLayout, 0);
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) this.f9839d.element.findViewById(R.id.clTemperature);
                        s.g(constraintLayout2, "panel.clTemperature");
                        constraintLayout2.setVisibility(0);
                        VdsAgent.onSetViewVisibility(constraintLayout2, 0);
                        int i3 = R.id.clTexture;
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) this.f9839d.element.findViewById(i3);
                        s.g(constraintLayout3, "panel.clTexture");
                        boolean z = true;
                        if (constraintLayout3.getVisibility() == 4) {
                            ConstraintLayout constraintLayout4 = (ConstraintLayout) this.f9839d.element.findViewById(i3);
                            s.g(constraintLayout4, "panel.clTexture");
                            constraintLayout4.setVisibility(0);
                            VdsAgent.onSetViewVisibility(constraintLayout4, 0);
                        }
                        ((FilterPanelItemView) this.b.v0().a(R.id.filterItemView)).setBackground(((ConstraintLayout) this.f9839d.element.findViewById(i3)).getBackground());
                        FilterEntry value = this.b.b.y().getValue();
                        String itemId = value == null ? null : value.getItemId();
                        if (itemId == null || (skyParamsRecord = this.b.b.G().get(itemId)) == null) {
                            return;
                        }
                        skyParamsRecord.setTransparent(i2);
                        ConstraintLayout x0 = this.b.x0();
                        ImageView imageView2 = x0 != null ? (ImageView) x0.findViewById(R.id.imgSkyChangeReset) : null;
                        if (imageView2 == null) {
                            return;
                        }
                        if (skyParamsRecord.isDefault() && !this.b.M0()) {
                            z = false;
                        }
                        int i4 = z ? 0 : 8;
                        imageView2.setVisibility(i4);
                        VdsAgent.onSetViewVisibility(imageView2, i4);
                    }

                    @Override // us.pinguo.ui.widget.h
                    public void c(int i2) {
                        if (!this.a) {
                            this.a = true;
                            this.b.b.h0(true);
                        }
                        ((TextView) this.c.findViewById(R.id.txtTransparentValue)).setText(String.valueOf(i2));
                        this.b.b.f(i2 / 100.0f);
                        ((FilterPanelItemView) this.b.v0().a(R.id.filterItemView)).setBackground(null);
                        ImageView imageView = (ImageView) this.f9839d.element.findViewById(R.id.imgSkyChangeReset);
                        s.g(imageView, "panel.imgSkyChangeReset");
                        imageView.setVisibility(4);
                        VdsAgent.onSetViewVisibility(imageView, 4);
                        ImageView imageView2 = (ImageView) this.f9839d.element.findViewById(R.id.imgSkyChangeMirror);
                        s.g(imageView2, "panel.imgSkyChangeMirror");
                        imageView2.setVisibility(4);
                        VdsAgent.onSetViewVisibility(imageView2, 4);
                        this.c.setBackground(null);
                        ConstraintLayout constraintLayout = (ConstraintLayout) this.f9839d.element.findViewById(R.id.clMix);
                        s.g(constraintLayout, "panel.clMix");
                        constraintLayout.setVisibility(4);
                        VdsAgent.onSetViewVisibility(constraintLayout, 4);
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) this.f9839d.element.findViewById(R.id.clTemperature);
                        s.g(constraintLayout2, "panel.clTemperature");
                        constraintLayout2.setVisibility(4);
                        VdsAgent.onSetViewVisibility(constraintLayout2, 4);
                        int i3 = R.id.clTexture;
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) this.f9839d.element.findViewById(i3);
                        s.g(constraintLayout3, "panel.clTexture");
                        if (constraintLayout3.getVisibility() == 0) {
                            ConstraintLayout constraintLayout4 = (ConstraintLayout) this.f9839d.element.findViewById(i3);
                            s.g(constraintLayout4, "panel.clTexture");
                            constraintLayout4.setVisibility(4);
                            VdsAgent.onSetViewVisibility(constraintLayout4, 4);
                        }
                    }

                    @Override // us.pinguo.ui.widget.h
                    public void k(float f2) {
                        h.a.a(this, f2);
                    }
                }

                /* compiled from: FilterController.kt */
                /* renamed from: us.pinguo.common.filter.controller.FilterController$1$1$1$b */
                /* loaded from: classes4.dex */
                public static final class b implements us.pinguo.ui.widget.h {
                    private boolean a;
                    final /* synthetic */ FilterController b;
                    final /* synthetic */ ConstraintLayout c;

                    /* renamed from: d */
                    final /* synthetic */ Ref$ObjectRef<ConstraintLayout> f9840d;

                    b(FilterController filterController, ConstraintLayout constraintLayout, Ref$ObjectRef<ConstraintLayout> ref$ObjectRef) {
                        this.b = filterController;
                        this.c = constraintLayout;
                        this.f9840d = ref$ObjectRef;
                    }

                    @Override // us.pinguo.ui.widget.h
                    public void b(int i2) {
                        SkyParamsRecord skyParamsRecord;
                        this.a = false;
                        this.b.b.h0(false);
                        ImageView imageView = (ImageView) this.f9840d.element.findViewById(R.id.imgSkyChangeMirror);
                        s.g(imageView, "panel.imgSkyChangeMirror");
                        imageView.setVisibility(0);
                        VdsAgent.onSetViewVisibility(imageView, 0);
                        ConstraintLayout constraintLayout = (ConstraintLayout) this.f9840d.element.findViewById(R.id.clTransparent);
                        s.g(constraintLayout, "panel.clTransparent");
                        constraintLayout.setVisibility(0);
                        VdsAgent.onSetViewVisibility(constraintLayout, 0);
                        this.c.setBackgroundColor(Color.parseColor("#66000000"));
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) this.f9840d.element.findViewById(R.id.clTemperature);
                        s.g(constraintLayout2, "panel.clTemperature");
                        constraintLayout2.setVisibility(0);
                        VdsAgent.onSetViewVisibility(constraintLayout2, 0);
                        int i3 = R.id.clTexture;
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) this.f9840d.element.findViewById(i3);
                        s.g(constraintLayout3, "panel.clTexture");
                        boolean z = true;
                        if (constraintLayout3.getVisibility() == 4) {
                            ConstraintLayout constraintLayout4 = (ConstraintLayout) this.f9840d.element.findViewById(i3);
                            s.g(constraintLayout4, "panel.clTexture");
                            constraintLayout4.setVisibility(0);
                            VdsAgent.onSetViewVisibility(constraintLayout4, 0);
                        }
                        ((FilterPanelItemView) this.b.v0().a(R.id.filterItemView)).setBackground(((ConstraintLayout) this.f9840d.element.findViewById(i3)).getBackground());
                        FilterEntry value = this.b.b.y().getValue();
                        String itemId = value == null ? null : value.getItemId();
                        if (itemId == null || (skyParamsRecord = this.b.b.G().get(itemId)) == null) {
                            return;
                        }
                        skyParamsRecord.setMix(i2);
                        ConstraintLayout x0 = this.b.x0();
                        ImageView imageView2 = x0 != null ? (ImageView) x0.findViewById(R.id.imgSkyChangeReset) : null;
                        if (imageView2 == null) {
                            return;
                        }
                        if (skyParamsRecord.isDefault() && !this.b.M0()) {
                            z = false;
                        }
                        int i4 = z ? 0 : 8;
                        imageView2.setVisibility(i4);
                        VdsAgent.onSetViewVisibility(imageView2, i4);
                    }

                    @Override // us.pinguo.ui.widget.h
                    public void c(int i2) {
                        if (!this.a) {
                            this.a = true;
                            this.b.b.h0(true);
                        }
                        ((TextView) this.c.findViewById(R.id.txtMixValue)).setText(String.valueOf(i2));
                        this.b.b.d(i2 / 100.0f);
                        ((FilterPanelItemView) this.b.v0().a(R.id.filterItemView)).setBackground(null);
                        ImageView imageView = (ImageView) this.f9840d.element.findViewById(R.id.imgSkyChangeReset);
                        s.g(imageView, "panel.imgSkyChangeReset");
                        imageView.setVisibility(4);
                        VdsAgent.onSetViewVisibility(imageView, 4);
                        ImageView imageView2 = (ImageView) this.f9840d.element.findViewById(R.id.imgSkyChangeMirror);
                        s.g(imageView2, "panel.imgSkyChangeMirror");
                        imageView2.setVisibility(4);
                        VdsAgent.onSetViewVisibility(imageView2, 4);
                        ConstraintLayout constraintLayout = (ConstraintLayout) this.f9840d.element.findViewById(R.id.clTransparent);
                        s.g(constraintLayout, "panel.clTransparent");
                        constraintLayout.setVisibility(4);
                        VdsAgent.onSetViewVisibility(constraintLayout, 4);
                        this.c.setBackground(null);
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) this.f9840d.element.findViewById(R.id.clTemperature);
                        s.g(constraintLayout2, "panel.clTemperature");
                        constraintLayout2.setVisibility(4);
                        VdsAgent.onSetViewVisibility(constraintLayout2, 4);
                        int i3 = R.id.clTexture;
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) this.f9840d.element.findViewById(i3);
                        s.g(constraintLayout3, "panel.clTexture");
                        if (constraintLayout3.getVisibility() == 0) {
                            ConstraintLayout constraintLayout4 = (ConstraintLayout) this.f9840d.element.findViewById(i3);
                            s.g(constraintLayout4, "panel.clTexture");
                            constraintLayout4.setVisibility(4);
                            VdsAgent.onSetViewVisibility(constraintLayout4, 4);
                        }
                    }

                    @Override // us.pinguo.ui.widget.h
                    public void k(float f2) {
                        h.a.a(this, f2);
                    }
                }

                /* compiled from: FilterController.kt */
                /* renamed from: us.pinguo.common.filter.controller.FilterController$1$1$1$c */
                /* loaded from: classes4.dex */
                public static final class c implements us.pinguo.ui.widget.h {
                    private boolean a;
                    final /* synthetic */ FilterController b;
                    final /* synthetic */ ConstraintLayout c;

                    /* renamed from: d */
                    final /* synthetic */ Ref$ObjectRef<ConstraintLayout> f9841d;

                    c(FilterController filterController, ConstraintLayout constraintLayout, Ref$ObjectRef<ConstraintLayout> ref$ObjectRef) {
                        this.b = filterController;
                        this.c = constraintLayout;
                        this.f9841d = ref$ObjectRef;
                    }

                    @Override // us.pinguo.ui.widget.h
                    public void b(int i2) {
                        SkyParamsRecord skyParamsRecord;
                        this.a = false;
                        this.b.b.h0(false);
                        ImageView imageView = (ImageView) this.f9841d.element.findViewById(R.id.imgSkyChangeMirror);
                        s.g(imageView, "panel.imgSkyChangeMirror");
                        imageView.setVisibility(0);
                        VdsAgent.onSetViewVisibility(imageView, 0);
                        ConstraintLayout constraintLayout = (ConstraintLayout) this.f9841d.element.findViewById(R.id.clTransparent);
                        s.g(constraintLayout, "panel.clTransparent");
                        constraintLayout.setVisibility(0);
                        VdsAgent.onSetViewVisibility(constraintLayout, 0);
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) this.f9841d.element.findViewById(R.id.clMix);
                        s.g(constraintLayout2, "panel.clMix");
                        constraintLayout2.setVisibility(0);
                        VdsAgent.onSetViewVisibility(constraintLayout2, 0);
                        this.c.setBackgroundColor(Color.parseColor("#66000000"));
                        int i3 = R.id.clTexture;
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) this.f9841d.element.findViewById(i3);
                        s.g(constraintLayout3, "panel.clTexture");
                        boolean z = true;
                        if (constraintLayout3.getVisibility() == 4) {
                            ConstraintLayout constraintLayout4 = (ConstraintLayout) this.f9841d.element.findViewById(i3);
                            s.g(constraintLayout4, "panel.clTexture");
                            constraintLayout4.setVisibility(0);
                            VdsAgent.onSetViewVisibility(constraintLayout4, 0);
                        }
                        ((FilterPanelItemView) this.b.v0().a(R.id.filterItemView)).setBackground(((ConstraintLayout) this.f9841d.element.findViewById(i3)).getBackground());
                        FilterEntry value = this.b.b.y().getValue();
                        String itemId = value == null ? null : value.getItemId();
                        if (itemId == null || (skyParamsRecord = this.b.b.G().get(itemId)) == null) {
                            return;
                        }
                        skyParamsRecord.setTemperature(i2);
                        ConstraintLayout x0 = this.b.x0();
                        ImageView imageView2 = x0 != null ? (ImageView) x0.findViewById(R.id.imgSkyChangeReset) : null;
                        if (imageView2 == null) {
                            return;
                        }
                        if (skyParamsRecord.isDefault() && !this.b.M0()) {
                            z = false;
                        }
                        int i4 = z ? 0 : 8;
                        imageView2.setVisibility(i4);
                        VdsAgent.onSetViewVisibility(imageView2, i4);
                    }

                    @Override // us.pinguo.ui.widget.h
                    public void c(int i2) {
                        if (!this.a) {
                            this.a = true;
                            this.b.b.h0(true);
                        }
                        ((TextView) this.c.findViewById(R.id.txtTemperatureValue)).setText(String.valueOf(i2));
                        this.b.b.g(i2 / 100.0f);
                        ((FilterPanelItemView) this.b.v0().a(R.id.filterItemView)).setBackground(null);
                        ImageView imageView = (ImageView) this.f9841d.element.findViewById(R.id.imgSkyChangeReset);
                        s.g(imageView, "panel.imgSkyChangeReset");
                        imageView.setVisibility(4);
                        VdsAgent.onSetViewVisibility(imageView, 4);
                        ImageView imageView2 = (ImageView) this.f9841d.element.findViewById(R.id.imgSkyChangeMirror);
                        s.g(imageView2, "panel.imgSkyChangeMirror");
                        imageView2.setVisibility(4);
                        VdsAgent.onSetViewVisibility(imageView2, 4);
                        ConstraintLayout constraintLayout = (ConstraintLayout) this.f9841d.element.findViewById(R.id.clTransparent);
                        s.g(constraintLayout, "panel.clTransparent");
                        constraintLayout.setVisibility(4);
                        VdsAgent.onSetViewVisibility(constraintLayout, 4);
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) this.f9841d.element.findViewById(R.id.clMix);
                        s.g(constraintLayout2, "panel.clMix");
                        constraintLayout2.setVisibility(4);
                        VdsAgent.onSetViewVisibility(constraintLayout2, 4);
                        this.c.setBackground(null);
                        int i3 = R.id.clTexture;
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) this.f9841d.element.findViewById(i3);
                        s.g(constraintLayout3, "panel.clTexture");
                        if (constraintLayout3.getVisibility() == 0) {
                            ConstraintLayout constraintLayout4 = (ConstraintLayout) this.f9841d.element.findViewById(i3);
                            s.g(constraintLayout4, "panel.clTexture");
                            constraintLayout4.setVisibility(4);
                            VdsAgent.onSetViewVisibility(constraintLayout4, 4);
                        }
                    }

                    @Override // us.pinguo.ui.widget.h
                    public void k(float f2) {
                        h.a.a(this, f2);
                    }
                }

                /* compiled from: FilterController.kt */
                /* renamed from: us.pinguo.common.filter.controller.FilterController$1$1$1$d */
                /* loaded from: classes4.dex */
                public static final class d implements us.pinguo.ui.widget.h {
                    private boolean a;
                    final /* synthetic */ FilterController b;
                    final /* synthetic */ ConstraintLayout c;

                    /* renamed from: d */
                    final /* synthetic */ Ref$ObjectRef<ConstraintLayout> f9842d;

                    d(FilterController filterController, ConstraintLayout constraintLayout, Ref$ObjectRef<ConstraintLayout> ref$ObjectRef) {
                        this.b = filterController;
                        this.c = constraintLayout;
                        this.f9842d = ref$ObjectRef;
                    }

                    @Override // us.pinguo.ui.widget.h
                    public void b(int i2) {
                        SkyParamsRecord skyParamsRecord;
                        this.a = false;
                        this.b.b.h0(false);
                        ImageView imageView = (ImageView) this.f9842d.element.findViewById(R.id.imgSkyChangeMirror);
                        s.g(imageView, "panel.imgSkyChangeMirror");
                        imageView.setVisibility(0);
                        VdsAgent.onSetViewVisibility(imageView, 0);
                        ConstraintLayout constraintLayout = (ConstraintLayout) this.f9842d.element.findViewById(R.id.clTransparent);
                        s.g(constraintLayout, "panel.clTransparent");
                        constraintLayout.setVisibility(0);
                        VdsAgent.onSetViewVisibility(constraintLayout, 0);
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) this.f9842d.element.findViewById(R.id.clMix);
                        s.g(constraintLayout2, "panel.clMix");
                        constraintLayout2.setVisibility(0);
                        VdsAgent.onSetViewVisibility(constraintLayout2, 0);
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) this.f9842d.element.findViewById(R.id.clTemperature);
                        s.g(constraintLayout3, "panel.clTemperature");
                        constraintLayout3.setVisibility(0);
                        VdsAgent.onSetViewVisibility(constraintLayout3, 0);
                        this.c.setBackgroundColor(Color.parseColor("#66000000"));
                        ((FilterPanelItemView) this.b.v0().a(R.id.filterItemView)).setBackground(this.c.getBackground());
                        FilterEntry value = this.b.b.y().getValue();
                        String itemId = value == null ? null : value.getItemId();
                        if (itemId == null || (skyParamsRecord = this.b.b.G().get(itemId)) == null) {
                            return;
                        }
                        skyParamsRecord.setTexture(i2);
                        ConstraintLayout x0 = this.b.x0();
                        ImageView imageView2 = x0 != null ? (ImageView) x0.findViewById(R.id.imgSkyChangeReset) : null;
                        if (imageView2 == null) {
                            return;
                        }
                        int i3 = !skyParamsRecord.isDefault() || this.b.M0() ? 0 : 8;
                        imageView2.setVisibility(i3);
                        VdsAgent.onSetViewVisibility(imageView2, i3);
                    }

                    @Override // us.pinguo.ui.widget.h
                    public void c(int i2) {
                        if (!this.a) {
                            this.a = true;
                            this.b.b.h0(true);
                        }
                        ((TextView) this.c.findViewById(R.id.txtTextureValue)).setText(String.valueOf(i2));
                        this.b.A(i2);
                        ((FilterPanelItemView) this.b.v0().a(R.id.filterItemView)).setBackground(null);
                        ImageView imageView = (ImageView) this.f9842d.element.findViewById(R.id.imgSkyChangeReset);
                        s.g(imageView, "panel.imgSkyChangeReset");
                        imageView.setVisibility(4);
                        VdsAgent.onSetViewVisibility(imageView, 4);
                        ImageView imageView2 = (ImageView) this.f9842d.element.findViewById(R.id.imgSkyChangeMirror);
                        s.g(imageView2, "panel.imgSkyChangeMirror");
                        imageView2.setVisibility(4);
                        VdsAgent.onSetViewVisibility(imageView2, 4);
                        ConstraintLayout constraintLayout = (ConstraintLayout) this.f9842d.element.findViewById(R.id.clTransparent);
                        s.g(constraintLayout, "panel.clTransparent");
                        constraintLayout.setVisibility(4);
                        VdsAgent.onSetViewVisibility(constraintLayout, 4);
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) this.f9842d.element.findViewById(R.id.clMix);
                        s.g(constraintLayout2, "panel.clMix");
                        constraintLayout2.setVisibility(4);
                        VdsAgent.onSetViewVisibility(constraintLayout2, 4);
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) this.f9842d.element.findViewById(R.id.clTemperature);
                        s.g(constraintLayout3, "panel.clTemperature");
                        constraintLayout3.setVisibility(4);
                        VdsAgent.onSetViewVisibility(constraintLayout3, 4);
                        this.c.setBackground(null);
                    }

                    @Override // us.pinguo.ui.widget.h
                    public void k(float f2) {
                        h.a.a(this, f2);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C03761(FilterController filterController, String str, boolean z, Continuation<? super C03761> continuation) {
                    super(2, continuation);
                    this.this$0 = filterController;
                    this.$filterId = str;
                    this.$textureVisible = z;
                }

                /* renamed from: invokeSuspend$lambda-4 */
                public static final void m74invokeSuspend$lambda4(FilterController filterController, View view) {
                    VdsAgent.lambdaOnClick(view);
                    filterController.e1();
                }

                /* renamed from: invokeSuspend$lambda-5 */
                public static final void m75invokeSuspend$lambda5(FilterController filterController, View view) {
                    VdsAgent.lambdaOnClick(view);
                    filterController.X0();
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<u> create(Object obj, Continuation<?> continuation) {
                    return new C03761(this.this$0, this.$filterId, this.$textureVisible, continuation);
                }

                @Override // kotlin.jvm.b.p
                public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
                    return ((C03761) create(m0Var, continuation)).invokeSuspend(u.a);
                }

                /* JADX WARN: Type inference failed for: r4v1, types: [T, androidx.constraintlayout.widget.ConstraintLayout] */
                /* JADX WARN: Type inference failed for: r4v37, types: [T, androidx.constraintlayout.widget.ConstraintLayout] */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        kotlin.j.b(obj);
                        if (!this.this$0.c && !this.this$0.b.M().get()) {
                            FilterPanelItemView filterPanelItemView = (FilterPanelItemView) this.this$0.v0().a(R.id.filterItemView);
                            s.g(filterPanelItemView, "filterPanelView.filterItemView");
                            filterPanelItemView.setVisibility(0);
                            VdsAgent.onSetViewVisibility(filterPanelItemView, 0);
                        } else {
                            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                            ?? x0 = this.this$0.x0();
                            ref$ObjectRef.element = x0;
                            if (x0 == 0) {
                                if (!this.this$0.c) {
                                    Context context = this.this$0.v0().getContext();
                                    s.g(context, "filterPanelView.context");
                                    d0.a(context);
                                }
                                View inflate = ((ViewStub) this.this$0.v0().a(R.id.stubSkyChangeAdjust)).inflate();
                                Objects.requireNonNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
                                ?? r4 = (ConstraintLayout) inflate;
                                ref$ObjectRef.element = r4;
                                this.this$0.k1((ConstraintLayout) r4);
                                SkyParamsRecord skyParamsRecord = this.this$0.b.G().get(this.$filterId);
                                ConstraintLayout constraintLayout = (ConstraintLayout) ((ConstraintLayout) ref$ObjectRef.element).findViewById(R.id.clTransparent);
                                FilterController filterController = this.this$0;
                                int transparent = skyParamsRecord == null ? 50 : skyParamsRecord.getTransparent();
                                ((TextView) constraintLayout.findViewById(R.id.txtTransparentValue)).setText(String.valueOf(transparent));
                                int i2 = R.id.sbTransparent;
                                StickySeekBar stickySeekBar = (StickySeekBar) constraintLayout.findViewById(i2);
                                s.g(stickySeekBar, "cl.sbTransparent");
                                StickySeekBar.setValues$default(stickySeekBar, 0, 100, transparent, null, 8, null);
                                ((StickySeekBar) constraintLayout.findViewById(i2)).setDotColor(-1);
                                ((StickySeekBar) constraintLayout.findViewById(i2)).setTrackListener(new a(filterController, constraintLayout, ref$ObjectRef));
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ((ConstraintLayout) ref$ObjectRef.element).findViewById(R.id.clMix);
                                FilterController filterController2 = this.this$0;
                                int mix = skyParamsRecord == null ? 50 : skyParamsRecord.getMix();
                                ((TextView) constraintLayout2.findViewById(R.id.txtMixValue)).setText(String.valueOf(mix));
                                int i3 = R.id.sbMix;
                                StickySeekBar stickySeekBar2 = (StickySeekBar) constraintLayout2.findViewById(i3);
                                s.g(stickySeekBar2, "cl.sbMix");
                                StickySeekBar.setValues$default(stickySeekBar2, 0, 100, mix, null, 8, null);
                                ((StickySeekBar) constraintLayout2.findViewById(i3)).setDotColor(-1);
                                ((StickySeekBar) constraintLayout2.findViewById(i3)).setTrackListener(new b(filterController2, constraintLayout2, ref$ObjectRef));
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ((ConstraintLayout) ref$ObjectRef.element).findViewById(R.id.clTemperature);
                                FilterController filterController3 = this.this$0;
                                int temperature = skyParamsRecord == null ? 50 : skyParamsRecord.getTemperature();
                                ((TextView) constraintLayout3.findViewById(R.id.txtTemperatureValue)).setText(String.valueOf(temperature));
                                int i4 = R.id.sbTemperature;
                                ((StickySeekBar) constraintLayout3.findViewById(i4)).setValues(-100, 100, temperature, Boxing.boxInt(skyParamsRecord != null ? skyParamsRecord.getDefaultTemperature() : 50));
                                ((StickySeekBar) constraintLayout3.findViewById(i4)).setDotColor(-1);
                                ((StickySeekBar) constraintLayout3.findViewById(i4)).setTrackColor(Color.parseColor("#c0d1ff"), Color.parseColor("#ffff56"));
                                ((StickySeekBar) constraintLayout3.findViewById(i4)).setTrackListener(new c(filterController3, constraintLayout3, ref$ObjectRef));
                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ((ConstraintLayout) ref$ObjectRef.element).findViewById(R.id.clTexture);
                                FilterController filterController4 = this.this$0;
                                boolean z = this.$textureVisible;
                                int texture = skyParamsRecord == null ? 80 : skyParamsRecord.getTexture();
                                ((TextView) constraintLayout4.findViewById(R.id.txtTextureValue)).setText(String.valueOf(texture));
                                int i5 = R.id.sbTexture;
                                StickySeekBar stickySeekBar3 = (StickySeekBar) constraintLayout4.findViewById(i5);
                                s.g(stickySeekBar3, "cl.sbTexture");
                                StickySeekBar.setValues$default(stickySeekBar3, 0, 100, texture, null, 8, null);
                                ((StickySeekBar) constraintLayout4.findViewById(i5)).setDotColor(-1);
                                ((StickySeekBar) constraintLayout4.findViewById(i5)).setTrackListener(new d(filterController4, constraintLayout4, ref$ObjectRef));
                                filterController4.n1(z);
                                int i6 = R.id.imgSkyChangeReset;
                                final FilterController filterController5 = this.this$0;
                                ((ImageView) ((ConstraintLayout) ref$ObjectRef.element).findViewById(i6)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.common.filter.controller.c
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        FilterController.AnonymousClass1.C03751.C03761.m74invokeSuspend$lambda4(FilterController.this, view);
                                    }
                                });
                                ImageView imageView = (ImageView) ((ConstraintLayout) ref$ObjectRef.element).findViewById(i6);
                                s.g(imageView, "panel.imgSkyChangeReset");
                                int i7 = this.this$0.M0() ? 0 : 8;
                                imageView.setVisibility(i7);
                                VdsAgent.onSetViewVisibility(imageView, i7);
                                final FilterController filterController6 = this.this$0;
                                ((ImageView) ((ConstraintLayout) ref$ObjectRef.element).findViewById(R.id.imgSkyChangeMirror)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.common.filter.controller.b
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        FilterController.AnonymousClass1.C03751.C03761.m75invokeSuspend$lambda5(FilterController.this, view);
                                    }
                                });
                                this.this$0.G0();
                            }
                            if (this.this$0.y0()) {
                                T t = ref$ObjectRef.element;
                                View view = (View) t;
                                int i8 = (((View) t).getVisibility() == 0) ^ true ? 0 : 8;
                                view.setVisibility(i8);
                                VdsAgent.onSetViewVisibility(view, i8);
                            }
                            FilterPanelView v0 = this.this$0.v0();
                            int i9 = R.id.filterItemView;
                            if (((FilterPanelItemView) v0.a(i9)).g()) {
                                FilterPanelItemView filterPanelItemView2 = (FilterPanelItemView) this.this$0.v0().a(i9);
                                s.g(filterPanelItemView2, "filterPanelView.filterItemView");
                                int i10 = (((View) ref$ObjectRef.element).getVisibility() == 0) ^ true ? 0 : 8;
                                filterPanelItemView2.setVisibility(i10);
                                VdsAgent.onSetViewVisibility(filterPanelItemView2, i10);
                            } else {
                                if (((View) ref$ObjectRef.element).getVisibility() == 0) {
                                    FilterPanelItemView filterPanelItemView3 = (FilterPanelItemView) this.this$0.v0().a(i9);
                                    s.g(filterPanelItemView3, "filterPanelView.filterItemView");
                                    filterPanelItemView3.setVisibility(0);
                                    VdsAgent.onSetViewVisibility(filterPanelItemView3, 0);
                                    ((FilterPanelItemView) this.this$0.v0().a(i9)).setBackground(((ConstraintLayout) ((ConstraintLayout) ref$ObjectRef.element).findViewById(R.id.clTexture)).getBackground());
                                } else {
                                    FilterPanelItemView filterPanelItemView4 = (FilterPanelItemView) this.this$0.v0().a(i9);
                                    s.g(filterPanelItemView4, "filterPanelView.filterItemView");
                                    filterPanelItemView4.setVisibility(0);
                                    VdsAgent.onSetViewVisibility(filterPanelItemView4, 0);
                                    ((FilterPanelItemView) this.this$0.v0().a(i9)).setBackground(null);
                                }
                            }
                        }
                        return u.a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* compiled from: FilterController.kt */
            @DebugMetadata(c = "us.pinguo.common.filter.controller.FilterController$1$1$2", f = "FilterController.kt", i = {}, l = {309}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: us.pinguo.common.filter.controller.FilterController$1$1$2 */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass2 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
                int label;
                final /* synthetic */ FilterController this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(FilterController filterController, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.this$0 = filterController;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<u> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(this.this$0, continuation);
                }

                @Override // kotlin.jvm.b.p
                public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
                    return ((AnonymousClass2) create(m0Var, continuation)).invokeSuspend(u.a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended;
                    int i2;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i3 = this.label;
                    if (i3 == 0) {
                        kotlin.j.b(obj);
                        ConstraintLayout x0 = this.this$0.x0();
                        if (x0 != null) {
                            x0.setVisibility(8);
                            VdsAgent.onSetViewVisibility(x0, 8);
                        }
                        FilterPanelItemView filterPanelItemView = (FilterPanelItemView) this.this$0.v0().a(R.id.filterItemView);
                        s.g(filterPanelItemView, "filterPanelView.filterItemView");
                        filterPanelItemView.setVisibility(0);
                        VdsAgent.onSetViewVisibility(filterPanelItemView, 0);
                        CameraFilterModule cameraFilterModule = this.this$0.b;
                        this.label = 1;
                        obj = cameraFilterModule.Z(this.this$0.b.y().getValue(), this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        kotlin.j.b(obj);
                    }
                    if (((Boolean) obj).booleanValue()) {
                        FilterPanelView v0 = this.this$0.v0();
                        FilterPanelView v02 = this.this$0.v0();
                        int i4 = R.id.groupSeekBar;
                        Group group = (Group) v02.a(i4);
                        s.g(group, "filterPanelView.groupSeekBar");
                        v0.setSeekBarVisible(!(group.getVisibility() == 0));
                        Group group2 = (Group) this.this$0.v0().a(i4);
                        s.g(group2, "filterPanelView.groupSeekBar");
                        i2 = this.this$0.v0().x() ? 0 : 8;
                        group2.setVisibility(i2);
                        VdsAgent.onSetViewVisibility(group2, i2);
                    } else {
                        FilterPanelView v03 = this.this$0.v0();
                        FilterPanelView v04 = this.this$0.v0();
                        int i5 = R.id.filterSeekBar;
                        StickySeekBar stickySeekBar = (StickySeekBar) v04.a(i5);
                        s.g(stickySeekBar, "filterPanelView.filterSeekBar");
                        v03.setSeekBarVisible(!(stickySeekBar.getVisibility() == 0));
                        StickySeekBar stickySeekBar2 = (StickySeekBar) this.this$0.v0().a(i5);
                        s.g(stickySeekBar2, "filterPanelView.filterSeekBar");
                        i2 = this.this$0.v0().x() ? 0 : 8;
                        stickySeekBar2.setVisibility(i2);
                        VdsAgent.onSetViewVisibility(stickySeekBar2, i2);
                    }
                    return u.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03751(FilterController filterController, Continuation<? super C03751> continuation) {
                super(2, continuation);
                this.this$0 = filterController;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<u> create(Object obj, Continuation<?> continuation) {
                return new C03751(this.this$0, continuation);
            }

            @Override // kotlin.jvm.b.p
            public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
                return ((C03751) create(m0Var, continuation)).invokeSuspend(u.a);
            }

            /* JADX WARN: Removed duplicated region for block: B:74:0x00bb A[RETURN] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r13) {
                /*
                    r12 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r12.label
                    r2 = 3
                    r3 = 2
                    r4 = 1
                    r5 = 0
                    if (r1 == 0) goto L2c
                    if (r1 == r4) goto L28
                    if (r1 == r3) goto L1f
                    if (r1 != r2) goto L17
                    kotlin.j.b(r13)
                    goto Ld2
                L17:
                    java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r13.<init>(r0)
                    throw r13
                L1f:
                    java.lang.Object r1 = r12.L$0
                    java.lang.String r1 = (java.lang.String) r1
                    kotlin.j.b(r13)
                    goto L9e
                L28:
                    kotlin.j.b(r13)
                    goto L4e
                L2c:
                    kotlin.j.b(r13)
                    us.pinguo.common.filter.controller.FilterController r13 = r12.this$0
                    us.pinguo.common.filter.CameraFilterModule r13 = us.pinguo.common.filter.controller.FilterController.Z(r13)
                    us.pinguo.common.filter.controller.FilterController r1 = r12.this$0
                    us.pinguo.common.filter.CameraFilterModule r1 = us.pinguo.common.filter.controller.FilterController.Z(r1)
                    us.pinguo.repository2020.u r1 = r1.y()
                    java.lang.Object r1 = r1.getValue()
                    us.pinguo.repository2020.entity.FilterEntry r1 = (us.pinguo.repository2020.entity.FilterEntry) r1
                    r12.label = r4
                    java.lang.Object r13 = r13.W(r1, r12)
                    if (r13 != r0) goto L4e
                    return r0
                L4e:
                    java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
                    boolean r13 = kotlin.jvm.internal.s.c(r13, r1)
                    if (r13 == 0) goto Lbc
                    us.pinguo.common.filter.controller.FilterController r13 = r12.this$0
                    us.pinguo.common.filter.CameraFilterModule r13 = us.pinguo.common.filter.controller.FilterController.Z(r13)
                    us.pinguo.repository2020.u r13 = r13.y()
                    java.lang.Object r13 = r13.getValue()
                    us.pinguo.repository2020.entity.FilterEntry r13 = (us.pinguo.repository2020.entity.FilterEntry) r13
                    if (r13 != 0) goto L6c
                    r13 = r5
                    goto L70
                L6c:
                    java.lang.String r13 = r13.getPkgId()
                L70:
                    us.pinguo.common.filter.controller.FilterController r1 = r12.this$0
                    us.pinguo.common.filter.CameraFilterModule r1 = us.pinguo.common.filter.controller.FilterController.Z(r1)
                    us.pinguo.repository2020.u r1 = r1.y()
                    java.lang.Object r1 = r1.getValue()
                    us.pinguo.repository2020.entity.FilterEntry r1 = (us.pinguo.repository2020.entity.FilterEntry) r1
                    if (r1 != 0) goto L84
                    r1 = r5
                    goto L88
                L84:
                    java.lang.String r1 = r1.getItemId()
                L88:
                    if (r13 == 0) goto La5
                    if (r1 != 0) goto L8d
                    goto La5
                L8d:
                    us.pinguo.common.filter.controller.FilterController r4 = r12.this$0
                    us.pinguo.common.filter.CameraFilterModule r4 = us.pinguo.common.filter.controller.FilterController.Z(r4)
                    r12.L$0 = r1
                    r12.label = r3
                    java.lang.Object r13 = r4.V(r13, r1, r12)
                    if (r13 != r0) goto L9e
                    return r0
                L9e:
                    java.lang.Boolean r13 = (java.lang.Boolean) r13
                    boolean r13 = r13.booleanValue()
                    goto La6
                La5:
                    r13 = 0
                La6:
                    kotlinx.coroutines.g2 r3 = kotlinx.coroutines.z0.c()
                    us.pinguo.common.filter.controller.FilterController$1$1$1 r4 = new us.pinguo.common.filter.controller.FilterController$1$1$1
                    us.pinguo.common.filter.controller.FilterController r6 = r12.this$0
                    r4.<init>(r6, r1, r13, r5)
                    r12.L$0 = r5
                    r12.label = r2
                    java.lang.Object r13 = kotlinx.coroutines.j.g(r3, r4, r12)
                    if (r13 != r0) goto Ld2
                    return r0
                Lbc:
                    kotlinx.coroutines.g2 r13 = kotlinx.coroutines.z0.c()
                    kotlinx.coroutines.m0 r6 = kotlinx.coroutines.n0.a(r13)
                    r7 = 0
                    r8 = 0
                    us.pinguo.common.filter.controller.FilterController$1$1$2 r9 = new us.pinguo.common.filter.controller.FilterController$1$1$2
                    us.pinguo.common.filter.controller.FilterController r13 = r12.this$0
                    r9.<init>(r13, r5)
                    r10 = 3
                    r11 = 0
                    kotlinx.coroutines.j.d(r6, r7, r8, r9, r10, r11)
                Ld2:
                    kotlin.u r13 = kotlin.u.a
                    return r13
                */
                throw new UnsupportedOperationException("Method not decompiled: us.pinguo.common.filter.controller.FilterController.AnonymousClass1.C03751.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1() {
            super(2);
            FilterController.this = r1;
        }

        @Override // kotlin.jvm.b.p
        public /* bridge */ /* synthetic */ u invoke(PackageItem packageItem, Integer num) {
            invoke(packageItem, num.intValue());
            return u.a;
        }

        public final void invoke(PackageItem noName_0, int i2) {
            s.h(noName_0, "$noName_0");
            FilterController.this.v0().setFilterItemViewVisible(true);
            kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new C03751(FilterController.this, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FilterController.kt */
    /* renamed from: us.pinguo.common.filter.controller.FilterController$2 */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass2 extends Lambda implements p<FilterItem, Integer, u> {

        /* compiled from: FilterController.kt */
        @DebugMetadata(c = "us.pinguo.common.filter.controller.FilterController$2$1", f = "FilterController.kt", i = {}, l = {324, 325}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: us.pinguo.common.filter.controller.FilterController$2$1 */
        /* loaded from: classes4.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
            int label;
            final /* synthetic */ FilterController this$0;

            /* compiled from: FilterController.kt */
            @DebugMetadata(c = "us.pinguo.common.filter.controller.FilterController$2$1$1", f = "FilterController.kt", i = {}, l = {327}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: us.pinguo.common.filter.controller.FilterController$2$1$1 */
            /* loaded from: classes4.dex */
            public static final class C03771 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
                int label;
                final /* synthetic */ FilterController this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C03771(FilterController filterController, Continuation<? super C03771> continuation) {
                    super(2, continuation);
                    this.this$0 = filterController;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<u> create(Object obj, Continuation<?> continuation) {
                    return new C03771(this.this$0, continuation);
                }

                @Override // kotlin.jvm.b.p
                public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
                    return ((C03771) create(m0Var, continuation)).invokeSuspend(u.a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended;
                    int i2;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i3 = this.label;
                    if (i3 == 0) {
                        kotlin.j.b(obj);
                        CameraFilterModule cameraFilterModule = this.this$0.b;
                        this.label = 1;
                        obj = cameraFilterModule.Z(this.this$0.b.y().getValue(), this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        kotlin.j.b(obj);
                    }
                    if (((Boolean) obj).booleanValue()) {
                        FilterPanelView v0 = this.this$0.v0();
                        FilterPanelView v02 = this.this$0.v0();
                        int i4 = R.id.groupSeekBar;
                        Group group = (Group) v02.a(i4);
                        s.g(group, "filterPanelView.groupSeekBar");
                        v0.setSeekBarVisible(true ^ (group.getVisibility() == 0));
                        Group group2 = (Group) this.this$0.v0().a(i4);
                        s.g(group2, "filterPanelView.groupSeekBar");
                        i2 = this.this$0.v0().x() ? 0 : 8;
                        group2.setVisibility(i2);
                        VdsAgent.onSetViewVisibility(group2, i2);
                    } else {
                        FilterPanelView v03 = this.this$0.v0();
                        FilterPanelView v04 = this.this$0.v0();
                        int i5 = R.id.filterSeekBar;
                        StickySeekBar stickySeekBar = (StickySeekBar) v04.a(i5);
                        s.g(stickySeekBar, "filterPanelView.filterSeekBar");
                        v03.setSeekBarVisible(true ^ (stickySeekBar.getVisibility() == 0));
                        StickySeekBar stickySeekBar2 = (StickySeekBar) this.this$0.v0().a(i5);
                        s.g(stickySeekBar2, "filterPanelView.filterSeekBar");
                        i2 = this.this$0.v0().x() ? 0 : 8;
                        stickySeekBar2.setVisibility(i2);
                        VdsAgent.onSetViewVisibility(stickySeekBar2, i2);
                    }
                    return u.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(FilterController filterController, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = filterController;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<u> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.b.p
            public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
                return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(u.a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i2 = this.label;
                if (i2 == 0) {
                    kotlin.j.b(obj);
                    this.label = 1;
                    obj = this.this$0.b.W(this.this$0.b.y().getValue(), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.j.b(obj);
                    return u.a;
                } else {
                    kotlin.j.b(obj);
                }
                if (!s.c(obj, Boxing.boxBoolean(true))) {
                    g2 c = z0.c();
                    C03771 c03771 = new C03771(this.this$0, null);
                    this.label = 2;
                    if (kotlinx.coroutines.j.g(c, c03771, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return u.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2() {
            super(2);
            FilterController.this = r1;
        }

        @Override // kotlin.jvm.b.p
        public /* bridge */ /* synthetic */ u invoke(FilterItem filterItem, Integer num) {
            invoke(filterItem, num.intValue());
            return u.a;
        }

        public final void invoke(FilterItem noName_0, int i2) {
            s.h(noName_0, "$noName_0");
            kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new AnonymousClass1(FilterController.this, null), 3, null);
        }
    }

    /* compiled from: View.kt */
    /* loaded from: classes4.dex */
    public static final class a implements View.OnLayoutChangeListener {
        final /* synthetic */ ConstraintLayout a;
        final /* synthetic */ FilterController b;

        public a(ConstraintLayout constraintLayout, FilterController filterController) {
            this.a = constraintLayout;
            this.b = filterController;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            s.h(view, "view");
            view.removeOnLayoutChangeListener(this);
            ConstraintLayout constraintLayout = this.a;
            int i10 = R.id.clTransparent;
            int i11 = R.id.txtTransparent;
            int width = ((TextView) ((ConstraintLayout) constraintLayout.findViewById(i10)).findViewById(i11)).getWidth();
            ConstraintLayout constraintLayout2 = this.a;
            int i12 = R.id.clMix;
            int i13 = R.id.txtMix;
            int width2 = ((TextView) ((ConstraintLayout) constraintLayout2.findViewById(i12)).findViewById(i13)).getWidth();
            ConstraintLayout constraintLayout3 = this.a;
            int i14 = R.id.clTemperature;
            int i15 = R.id.txtTemperature;
            int width3 = ((TextView) ((ConstraintLayout) constraintLayout3.findViewById(i14)).findViewById(i15)).getWidth();
            ConstraintLayout constraintLayout4 = this.a;
            int i16 = R.id.clTexture;
            int i17 = R.id.txtTexture;
            int max = Math.max(Math.max(width, width2), Math.max(width3, ((AutofitTextView) ((ConstraintLayout) constraintLayout4.findViewById(i16)).findViewById(i17)).getWidth()));
            float b = us.pinguo.common.widget.i.a.b(50);
            float f2 = max;
            if (f2 > b) {
                int b2 = (int) (us.pinguo.common.widget.i.a.b(20) - ((f2 - b) * 0.5f));
                StickySeekBar stickySeekBar = (StickySeekBar) ((ConstraintLayout) this.a.findViewById(i10)).findViewById(R.id.sbTransparent);
                s.g(stickySeekBar, "panel.clTransparent.sbTransparent");
                ViewGroup.LayoutParams layoutParams = stickySeekBar.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.setMarginEnd(b2);
                stickySeekBar.setLayoutParams(layoutParams2);
                TextView textView = (TextView) ((ConstraintLayout) this.a.findViewById(i10)).findViewById(i11);
                s.g(textView, "panel.clTransparent.txtTransparent");
                ViewGroup.LayoutParams layoutParams3 = textView.getLayoutParams();
                Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
                layoutParams4.setMarginEnd(b2);
                textView.setLayoutParams(layoutParams4);
                StickySeekBar stickySeekBar2 = (StickySeekBar) ((ConstraintLayout) this.a.findViewById(i12)).findViewById(R.id.sbMix);
                s.g(stickySeekBar2, "panel.clMix.sbMix");
                ViewGroup.LayoutParams layoutParams5 = stickySeekBar2.getLayoutParams();
                Objects.requireNonNull(layoutParams5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) layoutParams5;
                layoutParams6.setMarginEnd(b2);
                stickySeekBar2.setLayoutParams(layoutParams6);
                TextView textView2 = (TextView) ((ConstraintLayout) this.a.findViewById(i12)).findViewById(i13);
                s.g(textView2, "panel.clMix.txtMix");
                ViewGroup.LayoutParams layoutParams7 = textView2.getLayoutParams();
                Objects.requireNonNull(layoutParams7, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) layoutParams7;
                layoutParams8.setMarginEnd(b2);
                textView2.setLayoutParams(layoutParams8);
                StickySeekBar stickySeekBar3 = (StickySeekBar) ((ConstraintLayout) this.a.findViewById(i14)).findViewById(R.id.sbTemperature);
                s.g(stickySeekBar3, "panel.clTemperature.sbTemperature");
                ViewGroup.LayoutParams layoutParams9 = stickySeekBar3.getLayoutParams();
                Objects.requireNonNull(layoutParams9, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams10 = (ConstraintLayout.LayoutParams) layoutParams9;
                layoutParams10.setMarginEnd(b2);
                stickySeekBar3.setLayoutParams(layoutParams10);
                TextView textView3 = (TextView) ((ConstraintLayout) this.a.findViewById(i14)).findViewById(i15);
                s.g(textView3, "panel.clTemperature.txtTemperature");
                ViewGroup.LayoutParams layoutParams11 = textView3.getLayoutParams();
                Objects.requireNonNull(layoutParams11, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams12 = (ConstraintLayout.LayoutParams) layoutParams11;
                layoutParams12.setMarginEnd(b2);
                textView3.setLayoutParams(layoutParams12);
                StickySeekBar stickySeekBar4 = (StickySeekBar) ((ConstraintLayout) this.a.findViewById(i16)).findViewById(R.id.sbTexture);
                s.g(stickySeekBar4, "panel.clTexture.sbTexture");
                ViewGroup.LayoutParams layoutParams13 = stickySeekBar4.getLayoutParams();
                Objects.requireNonNull(layoutParams13, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams14 = (ConstraintLayout.LayoutParams) layoutParams13;
                layoutParams14.setMarginEnd(b2);
                stickySeekBar4.setLayoutParams(layoutParams14);
                AutofitTextView autofitTextView = (AutofitTextView) ((ConstraintLayout) this.a.findViewById(i16)).findViewById(i17);
                s.g(autofitTextView, "panel.clTexture.txtTexture");
                ViewGroup.LayoutParams layoutParams15 = autofitTextView.getLayoutParams();
                Objects.requireNonNull(layoutParams15, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams16 = (ConstraintLayout.LayoutParams) layoutParams15;
                layoutParams16.setMarginEnd(b2);
                autofitTextView.setLayoutParams(layoutParams16);
            }
            if (this.b.c) {
                return;
            }
            Context context = this.a.getContext();
            s.g(context, "panel.context");
            d0.b(context);
        }
    }

    public FilterController(FilterPanelView filterPanelView, CameraFilterModule filterModule, boolean z) {
        s.h(filterPanelView, "filterPanelView");
        s.h(filterModule, "filterModule");
        this.a = filterPanelView;
        this.b = filterModule;
        this.c = z;
        Context context = filterPanelView.getContext();
        this.f9831e = context;
        this.f9836j = context.getResources().getDimensionPixelSize(R.dimen.filter_panel_body_padding_bottom);
        s.g(context, "context");
        this.f9837k = us.pinguo.util.g.a(context, 88.0f);
        Context context2 = filterPanelView.getContext();
        s.g(context2, "filterPanelView.context");
        this.f9838l = us.pinguo.util.g.a(context2, 44.0f);
        this.q = new HashSet<>();
        this.s = true;
        filterPanelView.setFilterPanelEvent(this);
        int i2 = R.id.packageListView;
        ((FilterPackageListView) filterPanelView.a(i2)).setOnPackageReClick(new AnonymousClass1());
        ((FilterPanelItemView) filterPanelView.a(R.id.filterItemView)).setOnFilterReClick(new AnonymousClass2());
        FilterPackageListView filterPackageListView = (FilterPackageListView) filterPanelView.a(i2);
        filterPackageListView.setOnPackageVisibleChanged(new FilterController$3$1(filterPackageListView, this));
        int i3 = R.id.selectorFilter;
        View a2 = filterPanelView.a(i3);
        Objects.requireNonNull(a2, "null cannot be cast to non-null type us.pinguo.common.widget.FilterLayerOpacityAdjustSelector");
        final FilterLayerOpacityAdjustSelector filterLayerOpacityAdjustSelector = (FilterLayerOpacityAdjustSelector) a2;
        View a3 = filterPanelView.a(R.id.selectorTemplate);
        Objects.requireNonNull(a3, "null cannot be cast to non-null type us.pinguo.common.widget.FilterLayerOpacityAdjustSelector");
        final FilterLayerOpacityAdjustSelector filterLayerOpacityAdjustSelector2 = (FilterLayerOpacityAdjustSelector) a3;
        filterPanelView.a(i3).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.common.filter.controller.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilterController.V(FilterController.this, filterLayerOpacityAdjustSelector, filterLayerOpacityAdjustSelector2, view);
            }
        });
        filterLayerOpacityAdjustSelector2.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.common.filter.controller.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilterController.W(FilterController.this, filterLayerOpacityAdjustSelector, filterLayerOpacityAdjustSelector2, view);
            }
        });
        String string = context.getResources().getString(R.string.filter);
        s.g(string, "context.resources.getString(R.string.filter)");
        filterLayerOpacityAdjustSelector.setText(string);
        String string2 = context.getResources().getString(R.string.filter_layer_adjust_template);
        s.g(string2, "context.resources.getStr…er_layer_adjust_template)");
        filterLayerOpacityAdjustSelector2.setText(string2);
        FilterLayerOpacityAdjustSelector.setIsSelected$default(filterLayerOpacityAdjustSelector, filterModule.P(), false, 2, null);
        FilterLayerOpacityAdjustSelector.setIsSelected$default(filterLayerOpacityAdjustSelector2, !filterModule.P(), false, 2, null);
    }

    public static /* synthetic */ void B0(FilterController filterController, FilterEntry filterEntry, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: gotoFilter");
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        filterController.A0(filterEntry, z);
    }

    public static final void C0(FilterEntry entry, FilterController this$0) {
        s.h(entry, "$entry");
        s.h(this$0, "this$0");
        if (s.c(Effect.EFFECT_FILTER_AUTO_KEY, entry.getItemId())) {
            this$0.a.V();
        } else {
            this$0.a.Y();
        }
    }

    public static final void D0(FilterController this$0, CategoryItem categoryItem, Ref$ObjectRef pkgItem, Ref$ObjectRef filterItem) {
        s.h(this$0, "this$0");
        s.h(pkgItem, "$pkgItem");
        s.h(filterItem, "$filterItem");
        this$0.a.s(categoryItem, (PackageItem) pkgItem.element, (FilterItem) filterItem.element);
    }

    public static final void E0(FilterController this$0, CategoryItem categoryItem, Ref$ObjectRef pkgItem, Ref$ObjectRef filterItem) {
        s.h(this$0, "this$0");
        s.h(pkgItem, "$pkgItem");
        s.h(filterItem, "$filterItem");
        this$0.a.s(categoryItem, (PackageItem) pkgItem.element, (FilterItem) filterItem.element);
    }

    private final void F0(Intent intent) {
        Object obj;
        Object obj2;
        boolean z;
        CategoryItem i2 = this.a.i();
        if (s.c("category_collect", i2 == null ? null : i2.getCategoryId())) {
            List<PackageItem> p = this.b.p(this.c);
            PackageItem k2 = this.a.k();
            if (p.isEmpty()) {
                this.b.c0();
                d1(this, false, 1, null);
                if (k2 == null) {
                    PackageItem o = this.a.o();
                    if (o != null) {
                        this.a.d(o.getCategoryId());
                        return;
                    }
                    PackageItem r = this.a.r();
                    if (r == null) {
                        return;
                    }
                    this.a.d(r.getCategoryId());
                    return;
                }
                PackageItem r2 = this.a.r();
                if (r2 == null) {
                    return;
                }
                if (r2.isDownloaded()) {
                    List<FilterItem> A = this.b.A(r2.getPackageId());
                    if (A == null) {
                        return;
                    }
                    FilterItem filterItem = (FilterItem) kotlin.collections.s.D(A, 0);
                    String filterId = filterItem == null ? null : filterItem.getFilterId();
                    if (filterId == null) {
                        return;
                    }
                    B0(this, new FilterEntry(r2.getCategoryId(), r2.getPackageId(), filterId), false, 2, null);
                    return;
                }
                this.a.d(r2.getCategoryId());
                this.a.M();
                k0(this, r2, null, 2, null);
                return;
            } else if (k2 != null) {
                int m = this.a.m();
                FilterItem l2 = this.a.l();
                this.a.d0(p);
                Iterator<T> it = p.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (s.c(((PackageItem) obj).getPackageId(), k2.getPackageId())) {
                        break;
                    }
                }
                PackageItem packageItem = (PackageItem) obj;
                if (packageItem == null) {
                    this.p = true;
                    this.a.e();
                    this.a.W(p.size());
                    return;
                }
                this.p = true;
                FilterPanelView.G(this.a, packageItem, false, null, 4, null);
                List<FilterItem> A2 = this.b.A(packageItem.getPackageId());
                if (A2 == null) {
                    return;
                }
                FilterPanelView.c0(this.a, 1, A2, 0, false, 12, null);
                Iterator<T> it2 = A2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it2.next();
                    FilterItem filterItem2 = (FilterItem) obj2;
                    if (s.c(filterItem2.getFilterId(), l2 == null ? null : l2.getFilterId()) && filterItem2.isCollect()) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                }
                FilterItem filterItem3 = (FilterItem) obj2;
                FilterPanelView.c0(this.a, 1, A2, 0, false, 12, null);
                ArrayList arrayList = new ArrayList();
                for (Object obj3 : A2) {
                    if (((FilterItem) obj3).isCollect()) {
                        arrayList.add(obj3);
                    }
                }
                if (filterItem3 != null) {
                    FilterPanelView.J(this.a, filterItem3, null, 2, null);
                    return;
                } else if (arrayList.size() == m) {
                    ((FilterPanelItemView) this.a.a(R.id.filterItemView)).c();
                    FilterPanelView.J(this.a, (FilterItem) kotlin.collections.s.D(arrayList, 0), null, 2, null);
                    return;
                } else {
                    ((FilterPanelItemView) this.a.a(R.id.filterItemView)).c();
                    this.a.I((FilterItem) kotlin.collections.s.D(arrayList, m), Integer.valueOf(m));
                    return;
                }
            } else {
                PackageItem o2 = this.a.o();
                if (o2 == null) {
                    d1(this, false, 1, null);
                    this.a.d0(p);
                    return;
                }
                List<FilterItem> A3 = this.b.A(o2.getPackageId());
                if (A3 == null) {
                    return;
                }
                d1(this, false, 1, null);
                FilterPanelView.c0(this.a, 0, A3, 0, false, 12, null);
                this.a.d0(p);
                return;
            }
        }
        this.b.c0();
        Serializable serializableExtra = intent.getSerializableExtra("delete_list");
        List<String> list = serializableExtra instanceof List ? (List) serializableExtra : null;
        PackageItem o3 = this.a.o();
        if (o3 == null) {
            d1(this, false, 1, null);
            return;
        }
        if (list == null || list.isEmpty()) {
            d1(this, false, 1, null);
            List<FilterItem> A4 = this.b.A(o3.getPackageId());
            if (A4 == null) {
                return;
            }
            FilterPanelView.c0(this.a, 0, A4, this.a.m(), false, 8, null);
            return;
        }
        this.b.m0(list);
        c1(true);
        if (list.contains(o3.getPackageId())) {
            h0();
            B0(this, FilterConstants.c(), false, 2, null);
        }
    }

    public final void G0() {
        ConstraintLayout constraintLayout = this.r;
        if (constraintLayout == null) {
            return;
        }
        if (ViewCompat.isLaidOut(constraintLayout) && !constraintLayout.isLayoutRequested()) {
            int i2 = R.id.clTransparent;
            int i3 = R.id.txtTransparent;
            int width = ((TextView) ((ConstraintLayout) constraintLayout.findViewById(i2)).findViewById(i3)).getWidth();
            int i4 = R.id.clMix;
            int i5 = R.id.txtMix;
            int width2 = ((TextView) ((ConstraintLayout) constraintLayout.findViewById(i4)).findViewById(i5)).getWidth();
            int i6 = R.id.clTemperature;
            int i7 = R.id.txtTemperature;
            int width3 = ((TextView) ((ConstraintLayout) constraintLayout.findViewById(i6)).findViewById(i7)).getWidth();
            int i8 = R.id.clTexture;
            int i9 = R.id.txtTexture;
            int max = Math.max(Math.max(width, width2), Math.max(width3, ((AutofitTextView) ((ConstraintLayout) constraintLayout.findViewById(i8)).findViewById(i9)).getWidth()));
            float b = us.pinguo.common.widget.i.a.b(50);
            float f2 = max;
            if (f2 > b) {
                int b2 = (int) (us.pinguo.common.widget.i.a.b(20) - ((f2 - b) * 0.5f));
                StickySeekBar stickySeekBar = (StickySeekBar) ((ConstraintLayout) constraintLayout.findViewById(i2)).findViewById(R.id.sbTransparent);
                s.g(stickySeekBar, "panel.clTransparent.sbTransparent");
                ViewGroup.LayoutParams layoutParams = stickySeekBar.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.setMarginEnd(b2);
                stickySeekBar.setLayoutParams(layoutParams2);
                TextView textView = (TextView) ((ConstraintLayout) constraintLayout.findViewById(i2)).findViewById(i3);
                s.g(textView, "panel.clTransparent.txtTransparent");
                ViewGroup.LayoutParams layoutParams3 = textView.getLayoutParams();
                Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
                layoutParams4.setMarginEnd(b2);
                textView.setLayoutParams(layoutParams4);
                StickySeekBar stickySeekBar2 = (StickySeekBar) ((ConstraintLayout) constraintLayout.findViewById(i4)).findViewById(R.id.sbMix);
                s.g(stickySeekBar2, "panel.clMix.sbMix");
                ViewGroup.LayoutParams layoutParams5 = stickySeekBar2.getLayoutParams();
                Objects.requireNonNull(layoutParams5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) layoutParams5;
                layoutParams6.setMarginEnd(b2);
                stickySeekBar2.setLayoutParams(layoutParams6);
                TextView textView2 = (TextView) ((ConstraintLayout) constraintLayout.findViewById(i4)).findViewById(i5);
                s.g(textView2, "panel.clMix.txtMix");
                ViewGroup.LayoutParams layoutParams7 = textView2.getLayoutParams();
                Objects.requireNonNull(layoutParams7, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) layoutParams7;
                layoutParams8.setMarginEnd(b2);
                textView2.setLayoutParams(layoutParams8);
                StickySeekBar stickySeekBar3 = (StickySeekBar) ((ConstraintLayout) constraintLayout.findViewById(i6)).findViewById(R.id.sbTemperature);
                s.g(stickySeekBar3, "panel.clTemperature.sbTemperature");
                ViewGroup.LayoutParams layoutParams9 = stickySeekBar3.getLayoutParams();
                Objects.requireNonNull(layoutParams9, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams10 = (ConstraintLayout.LayoutParams) layoutParams9;
                layoutParams10.setMarginEnd(b2);
                stickySeekBar3.setLayoutParams(layoutParams10);
                TextView textView3 = (TextView) ((ConstraintLayout) constraintLayout.findViewById(i6)).findViewById(i7);
                s.g(textView3, "panel.clTemperature.txtTemperature");
                ViewGroup.LayoutParams layoutParams11 = textView3.getLayoutParams();
                Objects.requireNonNull(layoutParams11, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams12 = (ConstraintLayout.LayoutParams) layoutParams11;
                layoutParams12.setMarginEnd(b2);
                textView3.setLayoutParams(layoutParams12);
                StickySeekBar stickySeekBar4 = (StickySeekBar) ((ConstraintLayout) constraintLayout.findViewById(i8)).findViewById(R.id.sbTexture);
                s.g(stickySeekBar4, "panel.clTexture.sbTexture");
                ViewGroup.LayoutParams layoutParams13 = stickySeekBar4.getLayoutParams();
                Objects.requireNonNull(layoutParams13, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams14 = (ConstraintLayout.LayoutParams) layoutParams13;
                layoutParams14.setMarginEnd(b2);
                stickySeekBar4.setLayoutParams(layoutParams14);
                AutofitTextView autofitTextView = (AutofitTextView) ((ConstraintLayout) constraintLayout.findViewById(i8)).findViewById(i9);
                s.g(autofitTextView, "panel.clTexture.txtTexture");
                ViewGroup.LayoutParams layoutParams15 = autofitTextView.getLayoutParams();
                Objects.requireNonNull(layoutParams15, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams16 = (ConstraintLayout.LayoutParams) layoutParams15;
                layoutParams16.setMarginEnd(b2);
                autofitTextView.setLayoutParams(layoutParams16);
            }
            if (this.c) {
                return;
            }
            Context context = constraintLayout.getContext();
            s.g(context, "panel.context");
            d0.b(context);
            return;
        }
        constraintLayout.addOnLayoutChangeListener(new a(constraintLayout, this));
    }

    public static /* synthetic */ void I0(FilterController filterController, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hide");
        }
        if ((i2 & 1) != 0) {
            z = true;
        }
        filterController.H0(z);
    }

    public static final void V(FilterController this$0, FilterLayerOpacityAdjustSelector selectorFilter, FilterLayerOpacityAdjustSelector selectorTemplate, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        s.h(selectorFilter, "$selectorFilter");
        s.h(selectorTemplate, "$selectorTemplate");
        kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new FilterController$4$1(this$0, selectorFilter, selectorTemplate, null), 3, null);
    }

    public static final void W(FilterController this$0, FilterLayerOpacityAdjustSelector selectorFilter, FilterLayerOpacityAdjustSelector selectorTemplate, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        s.h(selectorFilter, "$selectorFilter");
        s.h(selectorTemplate, "$selectorTemplate");
        this$0.b.g0(false);
        FilterLayerOpacityAdjustSelector.setIsSelected$default(selectorFilter, this$0.b.P(), false, 2, null);
        FilterLayerOpacityAdjustSelector.setIsSelected$default(selectorTemplate, !this$0.b.P(), false, 2, null);
        FilterPanelView filterPanelView = this$0.a;
        int i2 = R.id.filterSeekBar;
        StickySeekBar stickySeekBar = (StickySeekBar) filterPanelView.a(i2);
        Integer value = this$0.b.v().getValue();
        stickySeekBar.setProgress(value == null ? 100 : value.intValue());
        ((StickySeekBar) this$0.a.a(i2)).setDefaultProgress(100);
    }

    public final void X0() {
        SkyParamsRecord skyParamsRecord;
        ImageView imageView;
        FilterEntry value = this.b.y().getValue();
        String itemId = value == null ? null : value.getItemId();
        if (itemId == null || (skyParamsRecord = this.b.G().get(itemId)) == null) {
            return;
        }
        if (skyParamsRecord.getMirrored()) {
            skyParamsRecord.setMirrored(false);
            this.b.e(0);
            if (!skyParamsRecord.isDefault() || M0()) {
                return;
            }
            ConstraintLayout constraintLayout = this.r;
            imageView = constraintLayout != null ? (ImageView) constraintLayout.findViewById(R.id.imgSkyChangeReset) : null;
            if (imageView == null) {
                return;
            }
            imageView.setVisibility(8);
            VdsAgent.onSetViewVisibility(imageView, 8);
            return;
        }
        skyParamsRecord.setMirrored(true);
        this.b.e(1);
        ConstraintLayout constraintLayout2 = this.r;
        imageView = constraintLayout2 != null ? (ImageView) constraintLayout2.findViewById(R.id.imgSkyChangeReset) : null;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(0);
        VdsAgent.onSetViewVisibility(imageView, 0);
    }

    private final void Y0(PackageItem packageItem, String str) {
        FilterEntry value;
        int i2;
        List<FilterItem> A = this.b.A(packageItem.getPackageId());
        if (A == null || (value = this.b.y().getValue()) == null) {
            return;
        }
        int i3 = -1;
        if (s.c(packageItem.getPackageId(), value.getPkgId())) {
            Iterator<FilterItem> it = A.iterator();
            i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                } else if (s.c(it.next().getFilterId(), str)) {
                    break;
                } else {
                    i2++;
                }
            }
            Iterator<FilterItem> it2 = A.iterator();
            int i4 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    break;
                } else if (s.c(it2.next().getFilterId(), value.getItemId())) {
                    i3 = i4;
                    break;
                } else {
                    i4++;
                }
            }
            if (i2 > i3) {
                this.b.e0(ChangeStatus.CLICK_RIGHT);
            } else {
                this.b.e0(ChangeStatus.CLICK_LEFT);
            }
        } else {
            List<PackageItem> list = this.f9833g;
            if (list != null) {
                Iterator<PackageItem> it3 = list.iterator();
                i2 = 0;
                while (true) {
                    if (!it3.hasNext()) {
                        i2 = -1;
                        break;
                    }
                    PackageItem next = it3.next();
                    if (s.c(next.getPackageId(), packageItem.getPackageId()) && s.c(next.getCategoryId(), packageItem.getCategoryId())) {
                        break;
                    }
                    i2++;
                }
                Iterator<PackageItem> it4 = list.iterator();
                int i5 = 0;
                while (true) {
                    if (!it4.hasNext()) {
                        break;
                    }
                    PackageItem next2 = it4.next();
                    if (s.c(next2.getPackageId(), value.getPkgId()) && s.c(next2.getCategoryId(), value.getCategoryId())) {
                        i3 = i5;
                        break;
                    }
                    i5++;
                }
            } else {
                return;
            }
        }
        if (i2 > i3) {
            this.b.e0(ChangeStatus.CLICK_RIGHT);
        } else {
            this.b.e0(ChangeStatus.CLICK_LEFT);
        }
        CategoryItem i6 = this.a.i();
        FilterEntry filterEntry = new FilterEntry(s.c(i6 == null ? null : i6.getCategoryId(), "category_collect") ? "category_collect" : packageItem.getCategoryId(), packageItem.getPackageId(), str);
        if (!s.c(filterEntry, value) || this.m) {
            h1(false);
            this.b.y().setValue(filterEntry);
        }
    }

    public static final void a1(FilterController this$0, RecyclerView recyclerView, int i2) {
        s.h(this$0, "this$0");
        int i3 = ((us.pinguo.foundation.utils.n0.i() / 2) - recyclerView.getLeft()) - (this$0.f9831e.getResources().getDimensionPixelSize(R.dimen.filter_item_width) / 2);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        ScrollCenterLayoutManager scrollCenterLayoutManager = layoutManager instanceof ScrollCenterLayoutManager ? (ScrollCenterLayoutManager) layoutManager : null;
        if (scrollCenterLayoutManager == null) {
            return;
        }
        scrollCenterLayoutManager.scrollToPositionWithOffset(i2, i3);
    }

    public static /* synthetic */ void d1(FilterController filterController, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshData");
        }
        if ((i2 & 1) != 0) {
            z = false;
        }
        filterController.c1(z);
    }

    public final void g1(PackageItem packageItem, boolean z) {
        List<FilterItem> A = this.b.A(packageItem.getPackageId());
        if (A == null) {
            return;
        }
        int size = A.size();
        if (z) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : A) {
                if (((FilterItem) obj).isCollect()) {
                    arrayList.add(obj);
                }
            }
            A = arrayList;
        }
        FilterItem filterItem = (FilterItem) kotlin.collections.s.K(A);
        us.pinguo.foundation.statistics.h.b.N(this.b.x(), filterItem.getFilterId(), "slide");
        if (size != 1) {
            FilterPanelView.J(this.a, filterItem, null, 2, null);
        }
    }

    private final void i0(PackageItem packageItem, kotlin.jvm.b.l<? super PackageItem, u> lVar) {
        if (this.q.contains(packageItem.getPackageId())) {
            return;
        }
        this.n = packageItem;
        this.b.j(new q(this, lVar) { // from class: us.pinguo.common.filter.controller.FilterController$doDownload$1

            /* renamed from: k  reason: collision with root package name */
            final /* synthetic */ FilterController f9844k;

            /* renamed from: l  reason: collision with root package name */
            final /* synthetic */ kotlin.jvm.b.l<PackageItem, u> f9845l;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(PackageItem.this);
                this.f9844k = this;
                this.f9845l = lVar;
            }

            @Override // us.pinguo.repository2020.q
            public void i(int i2) {
                kotlinx.coroutines.l.d(n0.a(z0.c()), null, null, new FilterController$doDownload$1$installFinish$1(this.f9844k, PackageItem.this, i2, this.f9845l, null), 3, null);
            }

            @Override // us.pinguo.repository2020.q
            public void j(int i2) {
                kotlinx.coroutines.l.d(n0.a(z0.c()), null, null, new FilterController$doDownload$1$installProgress$1(this.f9844k, PackageItem.this, i2, null), 3, null);
            }

            @Override // us.pinguo.repository2020.q
            public void k() {
                kotlinx.coroutines.l.d(n0.a(z0.c()), null, null, new FilterController$doDownload$1$installStart$1(this.f9844k, PackageItem.this, null), 3, null);
            }
        });
    }

    private final void j0(PackageItem packageItem, kotlin.jvm.b.l<? super PackageItem, u> lVar) {
        PackageItem packageItem2 = this.n;
        if (s.c(packageItem2 == null ? null : packageItem2.getPackageId(), packageItem.getPackageId())) {
            return;
        }
        Context b = us.pinguo.foundation.e.b();
        s.g(b, "getAppContext()");
        if (!us.pinguo.util.q.h(b) && !m.a.C()) {
            s1(packageItem, lVar);
        } else {
            i0(packageItem, lVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void k0(FilterController filterController, PackageItem packageItem, kotlin.jvm.b.l lVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: downloadFilterPackage");
        }
        if ((i2 & 2) != 0) {
            lVar = null;
        }
        filterController.j0(packageItem, lVar);
    }

    public static /* synthetic */ void n0(FilterController filterController, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fadeIn");
        }
        if ((i2 & 1) != 0) {
            z = true;
        }
        filterController.m0(z);
    }

    public static /* synthetic */ void p0(FilterController filterController, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fadeOut");
        }
        if ((i2 & 1) != 0) {
            z = true;
        }
        filterController.o0(z);
    }

    public static final void q0(FilterController this$0) {
        s.h(this$0, "this$0");
        FilterPanelView filterPanelView = this$0.a;
        filterPanelView.setVisibility(8);
        VdsAgent.onSetViewVisibility(filterPanelView, 8);
    }

    public static /* synthetic */ void r1(FilterController filterController, boolean z, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
        }
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        filterController.q1(z, z2);
    }

    private final void s1(final PackageItem packageItem, final kotlin.jvm.b.l<? super PackageItem, u> lVar) {
        Activity activity;
        if (this.b.R() && (activity = (Activity) this.f9831e) != null) {
            d0.b(activity);
        }
        AlertDialog i2 = w.i(this.f9831e, R.string.filter_download_dialog_content, R.string.filter_download_dialog_bt_pos, R.string.filter_download_dialog_bt_neg, new DialogInterface.OnClickListener() { // from class: us.pinguo.common.filter.controller.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                FilterController.t1(FilterController.this, packageItem, lVar, dialogInterface, i3);
            }
        });
        if (this.b.R()) {
            i2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: us.pinguo.common.filter.controller.k
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    FilterController.u1(FilterController.this, dialogInterface);
                }
            });
        }
    }

    public static final void t1(FilterController this$0, PackageItem packageItem, kotlin.jvm.b.l lVar, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        s.h(this$0, "this$0");
        s.h(packageItem, "$packageItem");
        if (i2 == -1) {
            this$0.i0(packageItem, lVar);
            m.a.S(true);
        }
        dialogInterface.cancel();
    }

    public static final void u1(FilterController this$0, DialogInterface dialogInterface) {
        s.h(this$0, "this$0");
        Context context = this$0.f9831e;
        s.g(context, "context");
        d0.a(context);
    }

    private final void v1() {
        LifecycleOwner findViewTreeLifecycleOwner;
        LifecycleCoroutineScope lifecycleScope;
        if (o.b(o.a, "guide_displayed", false, null, 4, null) || (findViewTreeLifecycleOwner = ViewKt.findViewTreeLifecycleOwner(this.a)) == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(findViewTreeLifecycleOwner)) == null) {
            return;
        }
        kotlinx.coroutines.l.d(lifecycleScope, null, null, new FilterController$showFilterGuide$1(this, null), 3, null);
    }

    @Override // us.pinguo.common.filter.view.FilterPanelView.a
    public void A(int i2) {
        this.b.s().postValue(Integer.valueOf(i2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A0(final FilterEntry entry, boolean z) {
        Object obj;
        boolean z2;
        T t;
        Object obj2;
        final CategoryItem categoryItem;
        T t2;
        s.h(entry, "entry");
        List<PackageItem> list = this.f9833g;
        if (list == null || list.isEmpty()) {
            return;
        }
        String categoryId = entry.getCategoryId();
        if (s.c(entry.getPkgId(), "package_none_and_auto")) {
            if ((this.a.getVisibility() == 0) && z) {
                us.pinguo.foundation.ui.c.b(this.a, new Runnable() { // from class: us.pinguo.common.filter.controller.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        FilterController.C0(FilterEntry.this, this);
                    }
                });
                return;
            }
            return;
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        List<PackageItem> list2 = this.f9833g;
        if (list2 == null) {
            t = 0;
        } else {
            Iterator<T> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                PackageItem packageItem = (PackageItem) obj;
                if (!s.c(entry.getPkgId(), packageItem.getPackageId()) || s.c(packageItem.getCategoryId(), "my")) {
                    z2 = false;
                    continue;
                } else {
                    z2 = true;
                    continue;
                }
                if (z2) {
                    break;
                }
            }
            t = (PackageItem) obj;
        }
        ref$ObjectRef.element = t;
        if (categoryId == null || categoryId.length() == 0) {
            PackageItem packageItem2 = (PackageItem) ref$ObjectRef.element;
            categoryId = packageItem2 == null ? null : packageItem2.getCategoryId();
        }
        List<CategoryItem> list3 = this.f9832f;
        if (list3 == null) {
            categoryItem = null;
        } else {
            Iterator<T> it2 = list3.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it2.next();
                if (s.c(categoryId, ((CategoryItem) obj2).getCategoryId())) {
                    break;
                }
            }
            categoryItem = (CategoryItem) obj2;
        }
        String itemId = entry.getItemId();
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        if (itemId != null) {
            CameraFilterModule cameraFilterModule = this.b;
            PackageItem packageItem3 = (PackageItem) ref$ObjectRef.element;
            t2 = cameraFilterModule.z(packageItem3 == null ? null : packageItem3.getPackageId(), itemId);
        } else {
            t2 = 0;
        }
        ref$ObjectRef2.element = t2;
        CameraFilterModule cameraFilterModule2 = this.b;
        PackageItem packageItem4 = (PackageItem) ref$ObjectRef.element;
        boolean Q = cameraFilterModule2.Q(packageItem4 == null ? null : packageItem4.getPackageId());
        if (ref$ObjectRef2.element == 0) {
            CameraFilterModule cameraFilterModule3 = this.b;
            PackageItem packageItem5 = (PackageItem) ref$ObjectRef.element;
            List<FilterItem> A = cameraFilterModule3.A(packageItem5 == null ? null : packageItem5.getPackageId());
            ref$ObjectRef2.element = A != null ? (FilterItem) kotlin.collections.s.D(A, 0) : 0;
        }
        T t3 = ref$ObjectRef.element;
        if (t3 == 0) {
            if (this.a.getVisibility() == 0) {
                us.pinguo.foundation.ui.c.b(this.a, new Runnable() { // from class: us.pinguo.common.filter.controller.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        FilterController.D0(FilterController.this, categoryItem, ref$ObjectRef, ref$ObjectRef2);
                    }
                });
            }
        } else if (Q) {
            if (this.a.getVisibility() == 0) {
                us.pinguo.foundation.ui.c.b(this.a, new Runnable() { // from class: us.pinguo.common.filter.controller.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        FilterController.E0(FilterController.this, categoryItem, ref$ObjectRef, ref$ObjectRef2);
                    }
                });
            }
        } else {
            j0((PackageItem) t3, new FilterController$gotoFilter$4(this, ref$ObjectRef2, itemId, ref$ObjectRef, categoryItem));
        }
    }

    public final void A1(int i2) {
        this.a.g0(i2);
    }

    public final void B1(int i2) {
        this.a.h0(i2);
    }

    @Override // us.pinguo.common.filter.view.FilterPanelView.a
    public void C(CategoryItem categoryItem) {
        s.h(categoryItem, "categoryItem");
        if (s.c(categoryItem.getCategoryId(), "category_collect")) {
            List<PackageItem> p = this.b.p(this.c);
            if (p.isEmpty()) {
                k0.a.a(R.string.str_not_collected_yet);
            } else {
                this.a.d0(p);
            }
            us.pinguo.foundation.statistics.h.b.g0(this.b.x(), "favorite", "click_select");
            return;
        }
        if (this.p) {
            this.p = false;
            d1(this, false, 1, null);
        } else {
            List<PackageItem> list = this.f9833g;
            if (list != null) {
                v0().f0(list);
            }
        }
        us.pinguo.foundation.statistics.h.b.g0(this.b.x(), categoryItem.getCategoryId(), "click_select");
    }

    @Override // us.pinguo.common.h
    public int D() {
        return ((StickySeekBar) this.a.a(R.id.filterSeekBar)).getLayoutParams().height;
    }

    @Override // us.pinguo.common.g
    public boolean E(us.pinguo.common.d event) {
        s.h(event, "event");
        if ((event.c() == EventType.DOUBLE_CLICK || event.c() == EventType.TOUCH_UP || event.c() == EventType.BACK_PRESS) && K0()) {
            I0(this, false, 1, null);
            return true;
        }
        return false;
    }

    @Override // us.pinguo.common.h
    public int G() {
        return ((FilterPanelItemView) this.a.a(R.id.filterItemView)).getLayoutParams().height;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // us.pinguo.common.filter.view.FilterPanelView.a
    public void H(FilterItem filterItem) {
        boolean z;
        s.h(filterItem, "filterItem");
        FilterEntry value = this.b.y().getValue();
        PackageItem packageItem = null;
        String categoryId = value == null ? null : value.getCategoryId();
        List<PackageItem> list = this.f9833g;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                PackageItem packageItem2 = (PackageItem) next;
                if (s.c(packageItem2.getPackageId(), filterItem.getPackageId()) && (categoryId == null || s.c(packageItem2.getCategoryId(), categoryId) || s.c(categoryId, "category_collect"))) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    packageItem = next;
                    break;
                }
            }
            packageItem = packageItem;
        }
        if (packageItem == null) {
            return;
        }
        Y0(packageItem, filterItem.getFilterId());
        us.pinguo.foundation.statistics.h.b.N(this.b.x(), filterItem.getFilterId(), "click");
    }

    public void H0(boolean z) {
        if (K0()) {
            ConstraintLayout constraintLayout = this.r;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(4);
                VdsAgent.onSetViewVisibility(constraintLayout, 4);
            }
            this.b.G().clear();
            this.o = false;
            o0(z);
        }
    }

    @Override // us.pinguo.common.filter.view.FilterPanelView.a
    public void I(String str) {
        kotlin.jvm.b.l<? super String, u> lVar = this.f9830d;
        if (lVar == null) {
            return;
        }
        lVar.invoke(str);
    }

    @Override // us.pinguo.common.h
    public void J(boolean z) {
        int color = z ? this.f9831e.getResources().getColor(R.color.color_camera_theme_black) : -1;
        FilterPanelView filterPanelView = this.a;
        int i2 = R.id.filterSeekBar;
        ((StickySeekBar) filterPanelView.a(i2)).setMainColor(color);
        ((StickySeekBar) this.a.a(i2)).setIndicatorColor(color);
    }

    public final void J0() {
        ConstraintLayout constraintLayout = this.r;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
            VdsAgent.onSetViewVisibility(constraintLayout, 8);
        }
        ((FilterPanelItemView) this.a.a(R.id.filterItemView)).setBackground(null);
    }

    public final boolean K0() {
        return this.a.getVisibility() == 0;
    }

    public final boolean L0() {
        return this.o;
    }

    @Override // us.pinguo.common.filter.view.FilterPanelView.a
    public String M() {
        return this.b.x();
    }

    protected boolean M0() {
        return false;
    }

    public final void N0() {
        List<CategoryItem> list = this.f9832f;
        if (list == null || list.isEmpty() || list.size() <= 1) {
            return;
        }
        this.a.H(list.get(1));
        this.a.M();
    }

    @Override // us.pinguo.common.h
    public int O() {
        return h.a.i(this);
    }

    @Override // us.pinguo.common.filter.view.FilterPanelView.a
    public void T() {
        this.b.y().setValue(FilterConstants.f());
    }

    @Override // us.pinguo.common.filter.view.FilterPanelView.a
    public void U(boolean z, FilterItem filterItem) {
        List<PackageItem> list;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        PackageItem packageItem;
        Object obj6;
        PackageItem packageItem2;
        s.h(filterItem, "filterItem");
        if (z) {
            this.b.i(filterItem.getFilterId());
        } else {
            this.b.l0(filterItem.getFilterId());
        }
        CategoryItem i2 = this.a.i();
        Object obj7 = null;
        boolean c = s.c(i2 == null ? null : i2.getCategoryId(), "category_collect");
        List<FilterItem> A = this.b.A(filterItem.getPackageId());
        if (A != null) {
            if (c) {
                Iterator<T> it = A.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj4 = null;
                        break;
                    }
                    obj4 = it.next();
                    if (((FilterItem) obj4).isCollect()) {
                        break;
                    }
                }
                if (obj4 == null) {
                    List<PackageItem> list2 = this.f9833g;
                    if (list2 == null) {
                        packageItem2 = null;
                    } else {
                        Iterator<T> it2 = list2.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj6 = null;
                                break;
                            }
                            obj6 = it2.next();
                            if (s.c(((PackageItem) obj6).getPackageId(), filterItem.getPackageId())) {
                                break;
                            }
                        }
                        packageItem2 = (PackageItem) obj6;
                    }
                    if (packageItem2 == null) {
                        return;
                    }
                    c(packageItem2, false);
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj8 : A) {
                        if (((FilterItem) obj8).isCollect()) {
                            arrayList.add(obj8);
                        }
                    }
                    int size = arrayList.size();
                    int m = v0().m();
                    int i3 = m >= size ? 0 : m;
                    FilterPanelView.c0(v0(), c ? 1 : 0, A, i3, false, 8, null);
                    FilterItem filterItem2 = (FilterItem) arrayList.get(i3);
                    List<PackageItem> list3 = this.f9833g;
                    if (list3 == null) {
                        packageItem = null;
                    } else {
                        Iterator<T> it3 = list3.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                obj5 = null;
                                break;
                            }
                            obj5 = it3.next();
                            if (s.c(((PackageItem) obj5).getPackageId(), filterItem2.getPackageId())) {
                                break;
                            }
                        }
                        packageItem = (PackageItem) obj5;
                    }
                    if (packageItem == null) {
                        return;
                    }
                    Y0(packageItem, filterItem2.getFilterId());
                }
            } else {
                Iterator<T> it4 = A.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it4.next();
                    if (((FilterItem) obj).isCollect()) {
                        break;
                    }
                }
                if (obj == null) {
                    List<PackageItem> list4 = this.f9833g;
                    if (list4 != null) {
                        Iterator<T> it5 = list4.iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                obj3 = null;
                                break;
                            }
                            obj3 = it5.next();
                            if (s.c(((PackageItem) obj3).getPackageId(), filterItem.getPackageId())) {
                                break;
                            }
                        }
                        PackageItem packageItem3 = (PackageItem) obj3;
                        if (packageItem3 != null && packageItem3.isCollect()) {
                            packageItem3.setCollect(false);
                            v0().f0(list4);
                        }
                    }
                } else {
                    List<PackageItem> list5 = this.f9833g;
                    if (list5 != null) {
                        Iterator<T> it6 = list5.iterator();
                        while (true) {
                            if (!it6.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            obj2 = it6.next();
                            if (s.c(((PackageItem) obj2).getPackageId(), filterItem.getPackageId())) {
                                break;
                            }
                        }
                        PackageItem packageItem4 = (PackageItem) obj2;
                        if (packageItem4 != null && !packageItem4.isCollect()) {
                            packageItem4.setCollect(true);
                            v0().f0(list5);
                        }
                    }
                }
                FilterPanelView.c0(v0(), c ? 1 : 0, A, v0().m(), false, 8, null);
            }
        }
        if (c || (list = this.f9833g) == null) {
            return;
        }
        Iterator<T> it7 = list.iterator();
        while (true) {
            if (!it7.hasNext()) {
                break;
            }
            Object next = it7.next();
            if (s.c(((PackageItem) next).getPackageId(), filterItem.getPackageId())) {
                obj7 = next;
                break;
            }
        }
        PackageItem packageItem5 = (PackageItem) obj7;
        if (packageItem5 == null || packageItem5.isCollect() || !z) {
            return;
        }
        packageItem5.setCollect(true);
        v0().f0(list);
    }

    public final void Z0(String str, String str2, String str3, boolean z) {
        Object obj;
        PackageItem packageItem;
        List<PackageItem> list = this.f9833g;
        if (list == null) {
            packageItem = null;
        } else {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (s.c(((PackageItem) obj).getPackageId(), str2)) {
                    break;
                }
            }
            packageItem = (PackageItem) obj;
        }
        if (packageItem == null) {
            r1(this, false, false, 1, null);
            if (!s.c(str2, "package_none_and_auto")) {
                return;
            }
            A0(new FilterEntry(str, str2, str3), z);
        }
        r1(this, false, false, 1, null);
        A0(new FilterEntry(str, str2, str3), z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x004f, code lost:
        if (r11 == null) goto L32;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // us.pinguo.common.filter.view.FilterPanelView.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(us.pinguo.repository2020.entity.PackageItem r10, us.pinguo.repository2020.entity.FilterItem r11) {
        /*
            r9 = this;
            java.lang.String r0 = "packageItem"
            kotlin.jvm.internal.s.h(r10, r0)
            us.pinguo.common.filter.CameraFilterModule r0 = r9.b
            java.lang.String r1 = r10.getPackageId()
            java.util.List r4 = r0.A(r1)
            if (r4 != 0) goto L13
            goto Lb4
        L13:
            boolean r0 = r4.isEmpty()
            if (r0 == 0) goto L1a
            return
        L1a:
            us.pinguo.common.filter.view.FilterPanelView r0 = r9.v0()
            us.pinguo.repository2020.entity.CategoryItem r0 = r0.i()
            r1 = 0
            if (r0 != 0) goto L27
            r0 = r1
            goto L2b
        L27:
            java.lang.String r0 = r0.getCategoryId()
        L2b:
            java.lang.String r2 = "category_collect"
            boolean r3 = kotlin.jvm.internal.s.c(r0, r2)
            r0 = 1
            if (r3 != r0) goto L52
            java.util.Iterator r11 = r4.iterator()
        L38:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L4c
            java.lang.Object r0 = r11.next()
            r2 = r0
            us.pinguo.repository2020.entity.FilterItem r2 = (us.pinguo.repository2020.entity.FilterItem) r2
            boolean r2 = r2.isCollect()
            if (r2 == 0) goto L38
            r1 = r0
        L4c:
            r11 = r1
            us.pinguo.repository2020.entity.FilterItem r11 = (us.pinguo.repository2020.entity.FilterItem) r11
            if (r11 != 0) goto L5b
            goto Lb4
        L52:
            if (r11 != 0) goto L5b
            r11 = 0
            java.lang.Object r11 = r4.get(r11)
            us.pinguo.repository2020.entity.FilterItem r11 = (us.pinguo.repository2020.entity.FilterItem) r11
        L5b:
            us.pinguo.common.filter.view.FilterPanelView r2 = r9.v0()
            r5 = 0
            r6 = 0
            r7 = 12
            r8 = 0
            us.pinguo.common.filter.view.FilterPanelView.c0(r2, r3, r4, r5, r6, r7, r8)
            us.pinguo.common.filter.view.FilterPanelView r0 = r9.v0()
            int r1 = us.pinguo.commonui.R.id.filterItemView
            android.view.View r0 = r0.a(r1)
            us.pinguo.common.filter.view.FilterPanelItemView r0 = (us.pinguo.common.filter.view.FilterPanelItemView) r0
            us.pinguo.common.filter.FilterItemAdapter r0 = r0.f()
            if (r0 != 0) goto L7a
            goto Lad
        L7a:
            int r2 = r0.h(r11)
            int r3 = r0.i()
            r0.p(r2)
            r4 = -1
            if (r3 <= r4) goto L8b
            r0.notifyItemChanged(r3)
        L8b:
            r0.notifyItemChanged(r2)
            us.pinguo.common.filter.view.FilterPanelView r0 = r9.v0()
            android.view.View r0 = r0.a(r1)
            us.pinguo.common.filter.view.FilterPanelItemView r0 = (us.pinguo.common.filter.view.FilterPanelItemView) r0
            int r1 = us.pinguo.commonui.R.id.filterItemRecyclerView
            android.view.View r0 = r0.a(r1)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            java.lang.String r1 = "rv"
            kotlin.jvm.internal.s.g(r0, r1)
            us.pinguo.common.filter.controller.j r1 = new us.pinguo.common.filter.controller.j
            r1.<init>()
            us.pinguo.foundation.ui.c.b(r0, r1)
        Lad:
            java.lang.String r11 = r11.getFilterId()
            r9.Y0(r10, r11)
        Lb4:
            boolean r11 = r10.isFromEdit()
            if (r11 == 0) goto Lbd
            java.lang.String r11 = "edit_page"
            goto Lcc
        Lbd:
            androidx.databinding.ObservableBoolean r11 = r10.isAfterCapture()
            boolean r11 = r11.get()
            if (r11 == 0) goto Lca
            java.lang.String r11 = "picture_preview"
            goto Lcc
        Lca:
            java.lang.String r11 = "camera_page"
        Lcc:
            java.lang.String r0 = r10.getPackageId()
            java.lang.String r1 = "C360_None"
            boolean r1 = kotlin.jvm.internal.s.c(r0, r1)
            if (r1 == 0) goto Ldb
            java.lang.String r10 = "original"
            goto Lea
        Ldb:
            java.lang.String r1 = "C360_auto"
            boolean r0 = kotlin.jvm.internal.s.c(r0, r1)
            if (r0 == 0) goto Le6
            java.lang.String r10 = "auto"
            goto Lea
        Le6:
            java.lang.String r10 = r10.getPackageId()
        Lea:
            us.pinguo.foundation.statistics.i r0 = us.pinguo.foundation.statistics.h.b
            java.lang.String r1 = "click"
            r0.B(r11, r10, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.common.filter.controller.FilterController.a(us.pinguo.repository2020.entity.PackageItem, us.pinguo.repository2020.entity.FilterItem):void");
    }

    public final void b1(int i2, Intent intent) {
        Object obj;
        CategoryItem categoryItem;
        Object obj2;
        if (i2 == 0 || i2 != -1 || intent == null) {
            return;
        }
        if (intent.getBooleanExtra("is_collection_changed", false)) {
            F0(intent);
            return;
        }
        this.b.c0();
        if (intent.getBooleanExtra("need_refresh_list", false)) {
            PackageItem o = this.a.o();
            if (o == null) {
                c1(true);
                return;
            }
            List<FilterItem> A = this.b.A(o.getPackageId());
            if (A == null) {
                return;
            }
            int m = this.a.m();
            c1(true);
            B0(this, new FilterEntry(o.getCategoryId(), o.getPackageId(), A.get(m).getFilterId()), false, 2, null);
            return;
        }
        d1(this, false, 1, null);
        String stringExtra = intent.getStringExtra("category_id");
        String str = stringExtra == null ? "" : stringExtra;
        String stringExtra2 = intent.getStringExtra("filter_package_id");
        String str2 = stringExtra2 == null ? "" : stringExtra2;
        String stringExtra3 = intent.getStringExtra("filter_id");
        String str3 = stringExtra3 == null ? "" : stringExtra3;
        boolean z = TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3);
        List<CategoryItem> list = this.f9832f;
        if (list == null) {
            categoryItem = null;
        } else {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (s.c(((CategoryItem) obj).getCategoryId(), str)) {
                    break;
                }
            }
            categoryItem = (CategoryItem) obj;
        }
        List<CategoryItem> m2 = CameraFilterModule.m(this.b, this.c, false, 2, null);
        this.f9832f = m2;
        this.a.j0(m2);
        Iterator it2 = CameraFilterModule.C(this.b, m2, false, 2, null).iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it2.next();
            if (s.c(((PackageItem) obj2).getPackageId(), str2)) {
                break;
            }
        }
        PackageItem packageItem = (PackageItem) obj2;
        if (categoryItem == null || packageItem == null) {
            c1(true);
        }
        if (z) {
            return;
        }
        if (this.b.S(str2)) {
            kotlinx.coroutines.l.d(n0.a(z0.c()), null, null, new FilterController$onStoreActivityResult$1(this, str, str2, str3, null), 3, null);
            return;
        }
        h0();
        B0(this, new FilterEntry(str, str2, str3), false, 2, null);
    }

    @Override // us.pinguo.common.filter.view.FilterPanelView.a
    public void c(PackageItem packageItem, boolean z) {
        List<FilterItem> A;
        s.h(packageItem, "packageItem");
        if (packageItem.isDownloaded()) {
            if (packageItem.isCollect()) {
                if (z) {
                    return;
                }
                List<FilterItem> A2 = this.b.A(packageItem.getPackageId());
                if (A2 != null) {
                    for (FilterItem filterItem : A2) {
                        if (filterItem.isCollect()) {
                            this.b.l0(filterItem.getFilterId());
                        }
                    }
                }
            } else if (!z) {
                return;
            } else {
                List<FilterItem> A3 = this.b.A(packageItem.getPackageId());
                if (A3 != null) {
                    for (FilterItem filterItem2 : A3) {
                        if (!filterItem2.isCollect()) {
                            this.b.i(filterItem2.getFilterId());
                        }
                    }
                }
            }
            CategoryItem i2 = this.a.i();
            if (i2 == null) {
                return;
            }
            FilterEntry value = this.b.y().getValue();
            Object obj = null;
            PackageItem packageItem2 = null;
            if (s.c(i2.getCategoryId(), "category_collect")) {
                if (s.c(value == null ? null : value.getPkgId(), packageItem.getPackageId()) && s.c(value.getCategoryId(), "category_collect")) {
                    v0().setFilterItemViewVisible(false);
                    f1(false);
                    v0().e();
                }
                List<PackageItem> p = this.b.p(this.c);
                v0().d0(p);
                if (p.isEmpty()) {
                    PackageItem r = v0().r();
                    if (r == null) {
                        return;
                    }
                    if (r.isDownloaded()) {
                        List<FilterItem> A4 = this.b.A(r.getPackageId());
                        if (A4 == null) {
                            return;
                        }
                        FilterItem filterItem3 = (FilterItem) kotlin.collections.s.D(A4, 0);
                        String filterId = filterItem3 == null ? null : filterItem3.getFilterId();
                        if (filterId == null) {
                            return;
                        }
                        B0(this, new FilterEntry(r.getCategoryId(), r.getPackageId(), filterId), false, 2, null);
                    } else {
                        v0().d(r.getCategoryId());
                        v0().M();
                        k0(this, r, null, 2, null);
                    }
                } else {
                    v0().W(p.size());
                }
                List<PackageItem> list = this.f9833g;
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (s.c(((PackageItem) next).getPackageId(), packageItem.getPackageId())) {
                            obj = next;
                            break;
                        }
                    }
                    packageItem2 = (PackageItem) obj;
                }
                if (packageItem2 == null) {
                    return;
                }
                packageItem2.setCollect(!packageItem.isCollect());
                return;
            }
            List<PackageItem> list2 = this.f9833g;
            if (list2 != null) {
                ArrayList<PackageItem> arrayList = new ArrayList();
                for (Object obj2 : list2) {
                    if (s.c(((PackageItem) obj2).getPackageId(), packageItem.getPackageId())) {
                        arrayList.add(obj2);
                    }
                }
                for (PackageItem packageItem3 : arrayList) {
                    packageItem3.setCollect(z);
                }
                v0().f0(list2);
            }
            if (!s.c(value != null ? value.getPkgId() : null, packageItem.getPackageId()) || s.c(value.getCategoryId(), "category_collect") || (A = this.b.A(packageItem.getPackageId())) == null) {
                return;
            }
            v0().b0(0, A, v0().m(), false);
        }
    }

    public final void c1(boolean z) {
        List<CategoryItem> l2 = this.b.l(this.c, z);
        this.f9832f = l2;
        this.a.j0(l2);
        List<PackageItem> B = this.b.B(l2, z);
        this.f9833g = B;
        List<PackageItem> p = this.b.p(false);
        CategoryItem i2 = this.a.i();
        if (s.c("category_collect", i2 == null ? null : i2.getCategoryId())) {
            this.a.d0(p);
        } else {
            this.a.f0(B);
        }
    }

    public void e1() {
        SkyParamsRecord skyParamsRecord;
        FilterEntry value = this.b.y().getValue();
        String itemId = value == null ? null : value.getItemId();
        if (itemId == null || (skyParamsRecord = this.b.G().get(itemId)) == null) {
            return;
        }
        if (skyParamsRecord.getMirrored()) {
            this.b.e(0);
            skyParamsRecord.setMirrored(false);
        }
        ConstraintLayout constraintLayout = this.r;
        ImageView imageView = constraintLayout != null ? (ImageView) constraintLayout.findViewById(R.id.imgSkyChangeReset) : null;
        if (imageView != null) {
            imageView.setVisibility(8);
            VdsAgent.onSetViewVisibility(imageView, 8);
        }
        skyParamsRecord.setTransparent(skyParamsRecord.getDefaultTransparent());
        skyParamsRecord.setMix(skyParamsRecord.getDefaultMix());
        skyParamsRecord.setTemperature(skyParamsRecord.getDefaultTemperature());
        skyParamsRecord.setTexture(skyParamsRecord.getDefaultTexture());
        j1(skyParamsRecord.getTransparent(), skyParamsRecord.getMix(), skyParamsRecord.getDefaultTemperature(), skyParamsRecord.getTemperature(), skyParamsRecord.getTexture());
        m1(skyParamsRecord.getTransparent(), skyParamsRecord.getMix(), skyParamsRecord.getTemperature(), skyParamsRecord.getTexture());
    }

    public final void f1(boolean z) {
        kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new FilterController$seekbarEnable$1(this, this.b.y().getValue(), z, null), 3, null);
    }

    @Override // us.pinguo.common.h
    public void h(boolean z) {
        ((FilterPanelItemView) this.a.a(R.id.filterItemView)).setDark(z);
    }

    public final void h0() {
        h1(true);
        this.a.f();
    }

    public final void h1(boolean z) {
        this.m = z;
    }

    @Override // us.pinguo.common.h
    public void i(boolean z) {
        h.a.e(this, z);
    }

    public final void i1(kotlin.jvm.b.l<? super us.pinguo.common.filter.guide.c, u> lVar) {
        this.f9835i = lVar;
    }

    public final void j1(int i2, int i3, int i4, int i5, int i6) {
        SkyParamsRecord skyParamsRecord;
        ConstraintLayout constraintLayout = this.r;
        if (constraintLayout != null) {
            int i7 = R.id.clTransparent;
            ((StickySeekBar) ((ConstraintLayout) constraintLayout.findViewById(i7)).findViewById(R.id.sbTransparent)).setProgress(i2);
            ((TextView) ((ConstraintLayout) constraintLayout.findViewById(i7)).findViewById(R.id.txtTransparentValue)).setText(String.valueOf(i2));
            int i8 = R.id.clMix;
            ((StickySeekBar) ((ConstraintLayout) constraintLayout.findViewById(i8)).findViewById(R.id.sbMix)).setProgress(i3);
            ((TextView) ((ConstraintLayout) constraintLayout.findViewById(i8)).findViewById(R.id.txtMixValue)).setText(String.valueOf(i3));
            int i9 = R.id.clTemperature;
            int i10 = R.id.sbTemperature;
            ((StickySeekBar) ((ConstraintLayout) constraintLayout.findViewById(i9)).findViewById(i10)).setDefaultProgress(i4);
            ((StickySeekBar) ((ConstraintLayout) constraintLayout.findViewById(i9)).findViewById(i10)).setProgress(i5);
            ((TextView) ((ConstraintLayout) constraintLayout.findViewById(i9)).findViewById(R.id.txtTemperatureValue)).setText(String.valueOf(i5));
            int i11 = R.id.clTexture;
            ((StickySeekBar) ((ConstraintLayout) constraintLayout.findViewById(i11)).findViewById(R.id.sbTexture)).setProgress(i6);
            ((TextView) ((ConstraintLayout) constraintLayout.findViewById(i11)).findViewById(R.id.txtTextureValue)).setText(String.valueOf(i6));
            FilterEntry value = this.b.y().getValue();
            String itemId = value == null ? null : value.getItemId();
            if (itemId != null && (skyParamsRecord = this.b.G().get(itemId)) != null) {
                ImageView imgSkyChangeReset = (ImageView) constraintLayout.findViewById(R.id.imgSkyChangeReset);
                s.g(imgSkyChangeReset, "imgSkyChangeReset");
                int i12 = !skyParamsRecord.isDefault() || M0() ? 0 : 8;
                imgSkyChangeReset.setVisibility(i12);
                VdsAgent.onSetViewVisibility(imgSkyChangeReset, i12);
            }
        }
        A(i6);
    }

    protected final void k1(ConstraintLayout constraintLayout) {
        this.r = constraintLayout;
    }

    @Override // us.pinguo.common.filter.view.FilterPanelView.a
    public void l(PackageItem packageItem) {
        s.h(packageItem, "packageItem");
        k0(this, packageItem, null, 2, null);
    }

    public final void l0(boolean z) {
        this.a.g(z);
    }

    public final void l1(boolean z) {
        this.s = z;
    }

    public final void m0(boolean z) {
        if (K0()) {
            return;
        }
        FilterPanelView filterPanelView = this.a;
        filterPanelView.setVisibility(0);
        VdsAgent.onSetViewVisibility(filterPanelView, 0);
        if (z) {
            this.a.setAlpha(0.0f);
            ViewPropertyAnimator alpha = this.a.animate().alpha(1.0f);
            alpha.setDuration(130L);
            alpha.start();
            return;
        }
        this.a.setAlpha(1.0f);
    }

    public final void m1(int i2, int i3, int i4, int i5) {
        float f2 = 100;
        this.b.f(i2 / f2);
        this.b.d(i3 / f2);
        this.b.g(i4 / f2);
    }

    @Override // us.pinguo.common.filter.view.FilterPanelView.a
    public boolean n() {
        return this.b.p(this.c).isEmpty();
    }

    public final void n1(boolean z) {
        ConstraintLayout constraintLayout = this.r;
        ConstraintLayout constraintLayout2 = constraintLayout == null ? null : (ConstraintLayout) constraintLayout.findViewById(R.id.clTexture);
        if (constraintLayout2 == null) {
            return;
        }
        int i2 = z ? 0 : 8;
        constraintLayout2.setVisibility(i2);
        VdsAgent.onSetViewVisibility(constraintLayout2, i2);
    }

    public final void o0(boolean z) {
        if (z) {
            this.a.setAlpha(1.0f);
            ViewPropertyAnimator alpha = this.a.animate().alpha(0.0f);
            alpha.setDuration(130L);
            alpha.withEndAction(new Runnable() { // from class: us.pinguo.common.filter.controller.g
                @Override // java.lang.Runnable
                public final void run() {
                    FilterController.q0(FilterController.this);
                }
            });
            alpha.start();
            return;
        }
        FilterPanelView filterPanelView = this.a;
        filterPanelView.setVisibility(8);
        VdsAgent.onSetViewVisibility(filterPanelView, 8);
    }

    public final void o1(kotlin.jvm.b.l<? super String, u> lVar) {
        this.f9830d = lVar;
    }

    @Override // us.pinguo.common.h
    public void p(boolean z) {
        ((FilterPackageListView) this.a.a(R.id.packageListView)).setDark(z);
        ((FilterPanelTabView) this.a.a(R.id.filterTabView)).setDark(z);
    }

    public final void p1(boolean z) {
        this.t = z;
    }

    @Override // us.pinguo.common.filter.view.FilterPanelView.a
    public void q() {
        this.b.y().setValue(FilterConstants.c());
    }

    public void q1(boolean z, boolean z2) {
        if (K0()) {
            return;
        }
        this.o = true;
        m0(z);
        if (z2) {
            v1();
        }
    }

    @Override // us.pinguo.common.filter.view.FilterPanelView.a
    public void r(int i2) {
    }

    public final void r0(boolean z) {
        this.a.h(z);
    }

    @Override // us.pinguo.common.h
    public boolean s() {
        return K0();
    }

    /* JADX WARN: Removed duplicated region for block: B:146:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s0(boolean r20) {
        /*
            Method dump skipped, instructions count: 633
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.common.filter.controller.FilterController.s0(boolean):void");
    }

    public final View t0() {
        return this.a.j();
    }

    public int u0() {
        int n = this.a.n();
        if (n == 0) {
            return 1;
        }
        return n;
    }

    public final FilterPanelView v0() {
        return this.a;
    }

    @Override // us.pinguo.common.h
    public void w(int i2) {
        StickySeekBar stickySeekBar = (StickySeekBar) this.a.a(R.id.filterSeekBar);
        s.g(stickySeekBar, "filterPanelView.filterSeekBar");
        ViewGroup.LayoutParams layoutParams = stickySeekBar.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = i2;
        stickySeekBar.setLayoutParams(layoutParams2);
    }

    public final kotlin.jvm.b.l<us.pinguo.common.filter.guide.c, u> w0() {
        return this.f9835i;
    }

    public final boolean w1() {
        us.pinguo.common.filter.guide.c cVar = this.f9834h;
        if (cVar != null && cVar.b()) {
            cVar.a();
            return true;
        }
        return false;
    }

    @Override // us.pinguo.common.h
    public int x() {
        return this.f9837k + this.f9838l + this.f9836j;
    }

    public final ConstraintLayout x0() {
        return this.r;
    }

    public final void x1(int i2) {
        int i3 = i2 - this.f9837k;
        if (i3 > this.f9836j) {
            this.f9836j = i3;
        }
        ((FilterPackageListView) this.a.a(R.id.packageListView)).setPadding(0, 0, 0, this.f9836j);
    }

    public final boolean y0() {
        return this.s;
    }

    public final void y1() {
        RecyclerView recyclerView = (RecyclerView) this.a.a(R.id.filterPackageRecyclerView);
        s.g(recyclerView, "filterPanelView.filterPackageRecyclerView");
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.height = us.pinguo.common.widget.i.a.a(100);
        recyclerView.setLayoutParams(layoutParams2);
        RecyclerView recyclerView2 = (RecyclerView) this.a.a(R.id.filterCollectRecyclerView);
        s.g(recyclerView2, "filterPanelView.filterCollectRecyclerView");
        ViewGroup.LayoutParams layoutParams3 = recyclerView2.getLayoutParams();
        Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
        layoutParams4.height = us.pinguo.common.widget.i.a.a(100);
        recyclerView2.setLayoutParams(layoutParams4);
    }

    public final boolean z0() {
        return this.t;
    }

    public final void z1() {
        kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new FilterController$updateFilterSeekBar$1(this, null), 3, null);
    }

    public /* synthetic */ FilterController(FilterPanelView filterPanelView, CameraFilterModule cameraFilterModule, boolean z, int i2, kotlin.jvm.internal.o oVar) {
        this(filterPanelView, cameraFilterModule, (i2 & 4) != 0 ? false : z);
    }
}
