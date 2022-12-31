package us.pinguo.inspire.module.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import us.pinguo.inspire.widget.GuideDialog;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class ChallengeGuideDialog extends GuideDialog implements View.OnClickListener {
    private View mStartView;

    public ChallengeGuideDialog(Context context) {
        super(context);
        setContentView(onCreateView());
        init();
    }

    private void init() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.dimAmount = 0.8f;
        getWindow().setAttributes(attributes);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mStartView) {
            dismiss();
        }
    }

    @Nullable
    public View onCreateView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.challenge_guide_dialog, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.challenge_guide_ok);
        this.mStartView = findViewById;
        findViewById.setOnClickListener(this);
        return inflate;
    }
}
