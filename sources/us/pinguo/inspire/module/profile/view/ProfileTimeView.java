package us.pinguo.inspire.module.profile.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.connect.common.Constants;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import us.pinguo.common.network.common.header.PGTransHeader;
import us.pinguo.foundation.t.b.a;
import us.pinguo.inspire.util.p;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class ProfileTimeView extends View {
    private Rect mBunds;
    private int mDayColor;
    private int mDaySize;
    private String mDayText;
    private int mMonthColor;
    private int mMonthPaddingTop;
    private int mMonthSize;
    private String mMonthText;
    private Paint mPaint;
    private long mTime;
    private int mTimeColor;
    private int mTimePaddingTop;
    private int mTimeSize;
    private String mTimeText;

    public ProfileTimeView(Context context) {
        super(context);
        init(context);
    }

    private String[] getDateStr(long j2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-HH:mm", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        return simpleDateFormat.format(Long.valueOf(j2)).split(PGTransHeader.CONNECTOR);
    }

    private String getDay(String str) {
        return str.startsWith("0") ? str.replace("0", "") : str;
    }

    private String getMonth(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 1537:
                if (str.equals("01")) {
                    c = 0;
                    break;
                }
                break;
            case 1538:
                if (str.equals("02")) {
                    c = 1;
                    break;
                }
                break;
            case 1539:
                if (str.equals("03")) {
                    c = 2;
                    break;
                }
                break;
            case 1540:
                if (str.equals("04")) {
                    c = 3;
                    break;
                }
                break;
            case 1541:
                if (str.equals("05")) {
                    c = 4;
                    break;
                }
                break;
            case 1542:
                if (str.equals("06")) {
                    c = 5;
                    break;
                }
                break;
            case 1543:
                if (str.equals("07")) {
                    c = 6;
                    break;
                }
                break;
            case 1544:
                if (str.equals("08")) {
                    c = 7;
                    break;
                }
                break;
            case 1545:
                if (str.equals("09")) {
                    c = '\b';
                    break;
                }
                break;
            case 1567:
                if (str.equals(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ)) {
                    c = '\t';
                    break;
                }
                break;
            case 1568:
                if (str.equals(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE)) {
                    c = '\n';
                    break;
                }
                break;
            case 1569:
                if (str.equals(Constants.VIA_REPORT_TYPE_SET_AVATAR)) {
                    c = 11;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return "一月";
            case 1:
                return "二月";
            case 2:
                return "三月";
            case 3:
                return "四月";
            case 4:
                return "五月";
            case 5:
                return "六月";
            case 6:
                return "七月";
            case 7:
                return "八月";
            case '\b':
                return "九月";
            case '\t':
                return "十月";
            case '\n':
                return "十一月";
            case 11:
                return "十二月";
            default:
                return "";
        }
    }

    public String getTodayOrYesterdayTimeStr() {
        return isToday() ? "今天" : isYesterDayOrToday() ? "昨天" : "";
    }

    public void init(Context context) {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mBunds = new Rect();
        this.mTimePaddingTop = a.a(context, 10.0f);
        this.mMonthPaddingTop = a.a(context, 5.0f);
        this.mDaySize = a.a(context, 17.0f);
        this.mMonthSize = a.a(context, 14.0f);
        this.mTimeSize = a.a(context, 11.0f);
        this.mDayColor = context.getResources().getColor(R.color.date_day_color);
        this.mMonthColor = context.getResources().getColor(R.color.date_month_color);
        this.mTimeColor = context.getResources().getColor(R.color.date_hour_color);
    }

    public boolean isToday() {
        return p.g(this.mTime, System.currentTimeMillis());
    }

    public boolean isYesterDayOrToday() {
        return p.h(this.mTime, System.currentTimeMillis());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setColor(this.mDayColor);
        this.mPaint.setTextSize(this.mDaySize);
        Paint paint = this.mPaint;
        String str = this.mDayText;
        paint.getTextBounds(str, 0, str.length(), this.mBunds);
        int height = this.mBunds.height() + getPaddingTop();
        canvas.drawText(this.mDayText, (getWidth() / 2) - (this.mBunds.width() / 2), height, this.mPaint);
        if (!isYesterDayOrToday() && !isToday()) {
            this.mPaint.setColor(this.mMonthColor);
            this.mPaint.setTextSize(this.mMonthSize);
            Paint paint2 = this.mPaint;
            String str2 = this.mMonthText;
            paint2.getTextBounds(str2, 0, str2.length(), this.mBunds);
            height = this.mMonthPaddingTop + this.mBunds.height() + height;
            canvas.drawText(this.mMonthText, (getWidth() / 2) - (this.mBunds.width() / 2), height, this.mPaint);
        }
        this.mPaint.setColor(this.mTimeColor);
        this.mPaint.setTextSize(this.mTimeSize);
        Paint paint3 = this.mPaint;
        String str3 = this.mTimeText;
        paint3.getTextBounds(str3, 0, str3.length(), this.mBunds);
        canvas.drawText(this.mTimeText, (getWidth() / 2) - (this.mBunds.width() / 2), this.mBunds.height() + height + this.mTimePaddingTop, this.mPaint);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        setMeasuredDimension(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3));
    }

    public void setTime(long j2) {
        this.mTime = j2;
        String[] dateStr = getDateStr(j2);
        if (dateStr.length != 3) {
            return;
        }
        if (!isYesterDayOrToday() && !isToday()) {
            this.mDayText = getDay(dateStr[1]);
        } else {
            this.mDayText = getTodayOrYesterdayTimeStr();
        }
        this.mMonthText = getMonth(dateStr[0]);
        this.mTimeText = dateStr[2];
    }

    public ProfileTimeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ProfileTimeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context);
    }

    @TargetApi(21)
    public ProfileTimeView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        init(context);
    }
}
