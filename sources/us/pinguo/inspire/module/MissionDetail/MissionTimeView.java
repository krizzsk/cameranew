package us.pinguo.inspire.module.MissionDetail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class MissionTimeView extends RelativeLayout {
    private int mSeconds;
    private TextView mTextHour;
    private TextView mTextMils;
    private TextView mTextMinite;
    private OnTimeFinishListenner mTimeFinishListenner;

    /* loaded from: classes9.dex */
    public interface OnTimeFinishListenner {
        void onTimeFinish();
    }

    public MissionTimeView(Context context) {
        this(context, null);
    }

    static /* synthetic */ int access$010(MissionTimeView missionTimeView) {
        int i2 = missionTimeView.mSeconds;
        missionTimeView.mSeconds = i2 - 1;
        return i2;
    }

    public void init(View view) {
        this.mTextHour = (TextView) view.findViewById(R.id.time_view_hours);
        this.mTextMinite = (TextView) view.findViewById(R.id.time_view_minite);
        this.mTextMils = (TextView) view.findViewById(R.id.time_view_mils);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    public void setTimeFinishListenner(OnTimeFinishListenner onTimeFinishListenner) {
        this.mTimeFinishListenner = onTimeFinishListenner;
    }

    public void setTimeSeconds(int i2) {
        this.mSeconds = i2;
        postDelayed(new Runnable() { // from class: us.pinguo.inspire.module.MissionDetail.MissionTimeView.1
            @Override // java.lang.Runnable
            public void run() {
                if (MissionTimeView.this.mSeconds == 0) {
                    if (MissionTimeView.this.mTimeFinishListenner != null) {
                        MissionTimeView.this.mTimeFinishListenner.onTimeFinish();
                        return;
                    }
                    return;
                }
                MissionTimeView.access$010(MissionTimeView.this);
                int i3 = MissionTimeView.this.mSeconds / 3600;
                int i4 = (MissionTimeView.this.mSeconds / 60) - (i3 * 60);
                TextView textView = MissionTimeView.this.mTextHour;
                textView.setText(i3 + "");
                TextView textView2 = MissionTimeView.this.mTextMinite;
                textView2.setText(i4 + "");
                TextView textView3 = MissionTimeView.this.mTextMils;
                textView3.setText((MissionTimeView.this.mSeconds % 60) + "");
                MissionTimeView.this.postDelayed(this, 1000L);
            }
        }, 1000L);
    }

    public MissionTimeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MissionTimeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        View inflate = LayoutInflater.from(context).inflate(R.layout.time_view_layout, (ViewGroup) null);
        addView(inflate, -1, -1);
        init(inflate);
    }
}
