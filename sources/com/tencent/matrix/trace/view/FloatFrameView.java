package com.tencent.matrix.trace.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.R;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class FloatFrameView extends LinearLayout {
    public LineChartView chartView;
    public TextView extraInfoView;
    public TextView fpsView;
    public TextView levelFrozenView;
    public TextView levelHighView;
    public TextView levelMiddleView;
    public TextView levelNormalView;
    public TextView qiWangView;
    public TextView sceneView;
    public TextView sumLevelFrozenView;
    public TextView sumLevelHighView;
    public TextView sumLevelMiddleView;
    public TextView sumLevelNormalView;
    public TextView sumQiWangView;

    public FloatFrameView(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        LayoutInflater.from(context).inflate(R.layout.float_frame_view, this);
        this.fpsView = (TextView) findViewById(R.id.fps_view);
        this.extraInfoView = (TextView) findViewById(R.id.extra_info);
        this.sceneView = (TextView) findViewById(R.id.scene_view);
        this.extraInfoView.setText("{other info}");
        this.qiWangView = (TextView) findViewById(R.id.qi_wang_tv);
        this.levelFrozenView = (TextView) findViewById(R.id.level_frozen);
        this.levelHighView = (TextView) findViewById(R.id.level_high);
        this.levelMiddleView = (TextView) findViewById(R.id.level_middle);
        this.levelNormalView = (TextView) findViewById(R.id.level_normal);
        this.sumQiWangView = (TextView) findViewById(R.id.sum_qi_wang_tv);
        this.sumLevelFrozenView = (TextView) findViewById(R.id.sum_level_frozen);
        this.sumLevelHighView = (TextView) findViewById(R.id.sum_level_high);
        this.sumLevelMiddleView = (TextView) findViewById(R.id.sum_level_middle);
        this.sumLevelNormalView = (TextView) findViewById(R.id.sum_level_normal);
        this.chartView = (LineChartView) findViewById(R.id.chart);
    }

    public FloatFrameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    /* loaded from: classes3.dex */
    public static class LineChartView extends View {
        private static final int LINE_COUNT = 50;
        private int bestColor;
        private int frozenColor;
        private int grayColor;
        float height;
        private int highColor;
        private final Paint levelLinePaint;
        float lineContentWidth;
        float linePadding;
        float lineStrokeWidth;
        private final LinkedList<a> lines;
        private int middleColor;
        private Path middlePath;
        private float[] middleTip;
        private int normalColor;
        float padding;
        private final Paint paint;
        float textSize;
        private final Paint tipLinePaint;
        private final TextPaint tipPaint;
        private Path topPath;
        private float[] topTip;
        float width;

        /* loaded from: classes3.dex */
        class a {
            private float[] a;
            int b;
            int c;

            a(int i2, int i3) {
                this.a = r0;
                this.b = i2;
                this.c = i3;
                float[] fArr = {LineChartView.this.width, 0.0f, (((60 - i2) * LineChartView.this.lineContentWidth) / 60.0f) + (LineChartView.this.getWidth() - LineChartView.this.lineContentWidth)};
            }

            void b(Canvas canvas, int i2) {
                if (LineChartView.this.paint.getColor() != this.c) {
                    LineChartView.this.paint.setColor(this.c);
                }
                float[] fArr = this.a;
                LineChartView lineChartView = LineChartView.this;
                fArr[1] = (i2 + 1) * lineChartView.linePadding;
                fArr[3] = fArr[1];
                canvas.drawLine(fArr[0], fArr[1], fArr[2], fArr[3], lineChartView.paint);
            }
        }

        public LineChartView(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            this.topPath = new Path();
            this.middlePath = new Path();
            this.topTip = new float[2];
            this.middleTip = new float[2];
            this.bestColor = getContext().getResources().getColor(R.color.level_best_color);
            this.normalColor = getContext().getResources().getColor(R.color.level_normal_color);
            this.middleColor = getContext().getResources().getColor(R.color.level_middle_color);
            this.highColor = getContext().getResources().getColor(R.color.level_high_color);
            this.frozenColor = getContext().getResources().getColor(R.color.level_frozen_color);
            this.grayColor = getContext().getResources().getColor(R.color.dark_text);
            this.padding = dip2px(getContext(), 8.0f);
            this.paint = new Paint();
            TextPaint textPaint = new TextPaint(1);
            this.tipPaint = textPaint;
            float dip2px = dip2px(getContext(), 8.0f);
            this.textSize = dip2px;
            textPaint.setTextSize(dip2px);
            textPaint.setStrokeWidth(dip2px(getContext(), 1.0f));
            textPaint.setColor(this.grayColor);
            TextPaint textPaint2 = new TextPaint(1);
            this.levelLinePaint = textPaint2;
            textPaint2.setStrokeWidth(dip2px(getContext(), 1.0f));
            textPaint2.setStyle(Paint.Style.STROKE);
            textPaint2.setPathEffect(new DashPathEffect(new float[]{6.0f, 6.0f}, 0.0f));
            Paint paint = new Paint(textPaint);
            this.tipLinePaint = paint;
            paint.setStrokeWidth(dip2px(getContext(), 1.0f));
            paint.setColor(this.grayColor);
            paint.setStyle(Paint.Style.STROKE);
            paint.setPathEffect(new DashPathEffect(new float[]{6.0f, 6.0f}, 0.0f));
            this.lines = new LinkedList<>();
        }

        public static int dip2px(Context context, float f2) {
            return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
        }

        private int getColor(int i2) {
            if (i2 > 57) {
                return this.bestColor;
            }
            if (i2 > 51) {
                return this.normalColor;
            }
            if (i2 > 36) {
                return this.middleColor;
            }
            if (i2 > 18) {
                return this.highColor;
            }
            return this.frozenColor;
        }

        public void addFps(int i2, int i3) {
            a aVar = new a(i2, i3);
            if (this.lines.size() >= 50) {
                this.lines.removeLast();
            }
            this.lines.addFirst(aVar);
            invalidate();
        }

        @Override // android.view.View
        @SuppressLint({"DefaultLocale"})
        public void draw(Canvas canvas) {
            super.draw(canvas);
            Iterator<a> it = this.lines.iterator();
            int i2 = 0;
            int i3 = 1;
            while (it.hasNext()) {
                a next = it.next();
                i2 += next.b;
                next.b(canvas, i3);
                if (i3 % 25 == 0) {
                    Path path = new Path();
                    float f2 = next.a[1];
                    path.moveTo(0.0f, f2);
                    path.lineTo(getMeasuredHeight(), f2);
                    canvas.drawPath(path, this.tipLinePaint);
                    this.tipPaint.setColor(this.grayColor);
                    canvas.drawText((i3 / 5) + "s", 0.0f, this.textSize + f2, this.tipPaint);
                    if (i3 > 0) {
                        int i4 = i2 / i3;
                        this.tipPaint.setColor(getColor(i4));
                        canvas.drawText(i4 + "FPS", 0.0f, f2 - (this.textSize / 2.0f), this.tipPaint);
                    }
                }
                i3++;
            }
            this.tipPaint.setColor(this.grayColor);
            this.levelLinePaint.setColor(this.normalColor);
            canvas.drawPath(this.topPath, this.levelLinePaint);
            float[] fArr = this.topTip;
            float f3 = fArr[0];
            float f4 = this.textSize;
            canvas.drawText("50", f3 - (f4 / 2.0f), fArr[1] + f4, this.tipPaint);
            this.levelLinePaint.setColor(this.middleColor);
            canvas.drawPath(this.middlePath, this.levelLinePaint);
            float[] fArr2 = this.middleTip;
            float f5 = fArr2[0];
            float f6 = this.textSize;
            canvas.drawText("30", f5 - (f6 / 2.0f), fArr2[1] + f6, this.tipPaint);
        }

        @Override // android.view.View
        protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            if (z) {
                this.width = getMeasuredWidth();
                this.height = getMeasuredHeight();
                this.lineContentWidth = this.width - (this.padding * 3.0f);
                float dip2px = dip2px(getContext(), 1.0f);
                this.lineStrokeWidth = dip2px;
                this.paint.setStrokeWidth(dip2px);
                float f2 = this.lineStrokeWidth * 2.0f;
                this.linePadding = f2;
                float f3 = this.lineContentWidth;
                float f4 = f3 / 60.0f;
                float[] fArr = this.topTip;
                fArr[0] = (10.0f * f4) + (this.width - f3);
                fArr[1] = (f2 * 50.0f) + this.padding;
                this.topPath.moveTo(fArr[0], fArr[1]);
                this.topPath.lineTo(this.topTip[0], 0.0f);
                float[] fArr2 = this.middleTip;
                fArr2[0] = (f4 * 30.0f) + (this.width - this.lineContentWidth);
                fArr2[1] = (this.linePadding * 50.0f) + this.padding;
                this.middlePath.moveTo(fArr2[0], fArr2[1]);
                this.middlePath.lineTo(this.middleTip[0], 0.0f);
            }
        }

        public LineChartView(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }
    }
}
