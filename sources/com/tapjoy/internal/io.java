package com.tapjoy.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public final class io extends RelativeLayout {
    private hr a;
    private a b;
    private aa c;

    /* renamed from: d  reason: collision with root package name */
    private int f7716d;

    /* renamed from: e  reason: collision with root package name */
    private int f7717e;

    /* renamed from: f  reason: collision with root package name */
    private ia f7718f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList f7719g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList f7720h;

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void a(hz hzVar);
    }

    public io(Context context, hr hrVar, a aVar) {
        super(context);
        this.c = aa.a;
        this.f7716d = 0;
        this.f7717e = 0;
        this.f7718f = null;
        this.f7719g = null;
        this.f7720h = null;
        this.a = hrVar;
        this.b = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006c  */
    @Override // android.widget.RelativeLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.io.onMeasure(int, int):void");
    }

    @Override // android.view.View
    protected final void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (i2 == 0) {
            ArrayList arrayList = this.f7720h;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ig igVar = (ig) ((WeakReference) it.next()).get();
                    if (igVar != null) {
                        igVar.setVisibility(4);
                        igVar.b();
                    }
                }
            }
            ArrayList arrayList2 = this.f7719g;
            if (arrayList2 != null) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ig igVar2 = (ig) ((WeakReference) it2.next()).get();
                    if (igVar2 != null) {
                        igVar2.setVisibility(0);
                        igVar2.a();
                    }
                }
                return;
            }
            return;
        }
        ArrayList arrayList3 = this.f7719g;
        if (arrayList3 != null) {
            Iterator it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                ig igVar3 = (ig) ((WeakReference) it3.next()).get();
                if (igVar3 != null) {
                    igVar3.b();
                }
            }
        }
        ArrayList arrayList4 = this.f7720h;
        if (arrayList4 != null) {
            Iterator it4 = arrayList4.iterator();
            while (it4.hasNext()) {
                ig igVar4 = (ig) ((WeakReference) it4.next()).get();
                if (igVar4 != null) {
                    igVar4.b();
                }
            }
        }
    }

    private void a() {
        ig igVar;
        ig igVar2;
        Iterator it = this.a.a.iterator();
        ia iaVar = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ia iaVar2 = (ia) it.next();
            aa aaVar = iaVar2.a;
            if (aaVar == this.c) {
                iaVar = iaVar2;
                break;
            } else if (aaVar == aa.a) {
                iaVar = iaVar2;
            }
        }
        removeAllViews();
        ArrayList arrayList = this.f7719g;
        if (arrayList != null) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ig igVar3 = (ig) ((WeakReference) it2.next()).get();
                if (igVar3 != null) {
                    igVar3.c();
                }
            }
            this.f7719g.clear();
        }
        ArrayList arrayList2 = this.f7720h;
        if (arrayList2 != null) {
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                ig igVar4 = (ig) ((WeakReference) it3.next()).get();
                if (igVar4 != null) {
                    igVar4.c();
                }
            }
            this.f7720h.clear();
        }
        if (iaVar != null) {
            this.f7718f = iaVar;
            Context context = getContext();
            Iterator it4 = iaVar.c.iterator();
            while (it4.hasNext()) {
                final hz hzVar = (hz) it4.next();
                final RelativeLayout relativeLayout = new RelativeLayout(context);
                if (hzVar.f7665l.c != null) {
                    ig igVar5 = new ig(context);
                    igVar5.setScaleType(ImageView.ScaleType.FIT_XY);
                    hx hxVar = hzVar.f7665l;
                    igVar5.a(hxVar.f7654d, hxVar.c);
                    if (this.f7719g == null) {
                        this.f7719g = new ArrayList();
                    }
                    this.f7719g.add(new WeakReference(igVar5));
                    igVar = igVar5;
                } else {
                    igVar = null;
                }
                hx hxVar2 = hzVar.m;
                if (hxVar2 == null || hxVar2.c == null) {
                    igVar2 = null;
                } else {
                    ig igVar6 = new ig(context);
                    igVar6.setScaleType(ImageView.ScaleType.FIT_XY);
                    hx hxVar3 = hzVar.m;
                    igVar6.a(hxVar3.f7654d, hxVar3.c);
                    if (this.f7720h == null) {
                        this.f7720h = new ArrayList();
                    }
                    this.f7720h.add(new WeakReference(igVar6));
                    igVar2 = igVar6;
                }
                ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(0, 0);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                Bitmap bitmap = hzVar.f7665l.b;
                hx hxVar4 = hzVar.m;
                Bitmap bitmap2 = hxVar4 != null ? hxVar4.b : null;
                final BitmapDrawable bitmapDrawable = bitmap != null ? new BitmapDrawable((Resources) null, bitmap) : null;
                final BitmapDrawable bitmapDrawable2 = bitmap2 != null ? new BitmapDrawable((Resources) null, bitmap2) : null;
                if (bitmapDrawable != null) {
                    ab.a(relativeLayout, bitmapDrawable);
                }
                if (igVar != null) {
                    relativeLayout.addView(igVar, layoutParams2);
                    igVar.a();
                }
                if (igVar2 != null) {
                    relativeLayout.addView(igVar2, layoutParams2);
                    igVar2.setVisibility(4);
                }
                final ig igVar7 = igVar2;
                final ig igVar8 = igVar;
                relativeLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.tapjoy.internal.io.1
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        ig igVar9;
                        if (motionEvent.getAction() == 0) {
                            if (igVar7 != null || bitmapDrawable2 != null) {
                                ig igVar10 = igVar8;
                                if (igVar10 != null) {
                                    igVar10.b();
                                    igVar8.setVisibility(4);
                                }
                                ab.a(view, null);
                            }
                            BitmapDrawable bitmapDrawable3 = bitmapDrawable2;
                            if (bitmapDrawable3 != null) {
                                ab.a(view, bitmapDrawable3);
                            } else {
                                ig igVar11 = igVar7;
                                if (igVar11 != null) {
                                    igVar11.setVisibility(0);
                                    igVar7.a();
                                }
                            }
                        } else {
                            boolean z = true;
                            if (motionEvent.getAction() == 1) {
                                float x = motionEvent.getX();
                                float y = motionEvent.getY();
                                if (x >= 0.0f && x < view.getWidth() && y >= 0.0f && y < view.getHeight()) {
                                    z = false;
                                }
                                if (z) {
                                    BitmapDrawable bitmapDrawable4 = bitmapDrawable;
                                    if (bitmapDrawable4 != null) {
                                        ab.a(view, bitmapDrawable4);
                                    } else if (bitmapDrawable2 != null) {
                                        ab.a(view, null);
                                    }
                                }
                                ig igVar12 = igVar7;
                                if (igVar12 != null) {
                                    igVar12.b();
                                    igVar7.setVisibility(4);
                                }
                                if ((igVar7 != null || bitmapDrawable2 != null) && (igVar9 = igVar8) != null && z) {
                                    igVar9.setVisibility(0);
                                    igVar8.a();
                                }
                            }
                        }
                        return false;
                    }
                });
                relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tapjoy.internal.io.2
                    @Override // android.view.View.OnClickListener
                    @Instrumented
                    public final void onClick(View view) {
                        VdsAgent.onClick(this, view);
                        ig igVar9 = igVar7;
                        if (igVar9 != null) {
                            igVar9.b();
                            relativeLayout.removeView(igVar7);
                        }
                        ig igVar10 = igVar8;
                        if (igVar10 != null) {
                            igVar10.b();
                            relativeLayout.removeView(igVar8);
                        }
                        io.this.b.a(hzVar);
                    }
                });
                relativeLayout.setTag(hzVar);
                addView(relativeLayout, layoutParams);
            }
        }
    }
}
