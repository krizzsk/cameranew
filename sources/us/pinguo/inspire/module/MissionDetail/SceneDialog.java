package us.pinguo.inspire.module.MissionDetail;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import us.pinguo.ui.R;
import us.pinguo.ui.widget.RoundRecImageView;
/* loaded from: classes9.dex */
public class SceneDialog extends Dialog implements View.OnClickListener {
    private String mBtnText;
    private boolean mIsShowBtn;
    private boolean mIsShowProgress;
    private OnSceneBtnClickListener mOnSceneBtnClickListener;
    private ProgressBar mProgressBar;
    private TextView mProgressText;
    private TextView mSceneBtn;
    private RoundRecImageView mSceneImageView;
    private String mSceneUrl;
    private TextView mTextTitle;
    private String mTitle;

    /* loaded from: classes9.dex */
    public interface OnSceneBtnClickListener {
        void onSceneBtnClick(SceneDialog sceneDialog);
    }

    public SceneDialog(Context context) {
        super(context, R.style.InspireDialog);
        this.mIsShowBtn = true;
        this.mIsShowProgress = false;
    }

    public void initView() {
        this.mTextTitle = (TextView) findViewById(vStudio.Android.Camera360.R.id.scene_title);
        this.mSceneImageView = (RoundRecImageView) findViewById(vStudio.Android.Camera360.R.id.scene_image);
        TextView textView = (TextView) findViewById(vStudio.Android.Camera360.R.id.btn_use_scene);
        this.mSceneBtn = textView;
        textView.setOnClickListener(this);
        findViewById(vStudio.Android.Camera360.R.id.btn_scene_close).setOnClickListener(this);
        this.mProgressBar = (ProgressBar) findViewById(vStudio.Android.Camera360.R.id.scene_progress);
        this.mProgressText = (TextView) findViewById(vStudio.Android.Camera360.R.id.progress_text_res_0x7d0601d7);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OnSceneBtnClickListener onSceneBtnClickListener;
        if (view.getId() == vStudio.Android.Camera360.R.id.btn_scene_close) {
            dismiss();
        } else if (view.getId() != vStudio.Android.Camera360.R.id.btn_use_scene || (onSceneBtnClickListener = this.mOnSceneBtnClickListener) == null) {
        } else {
            onSceneBtnClickListener.onSceneBtnClick(this);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(vStudio.Android.Camera360.R.layout.secne_dialog_layout);
        initView();
    }

    public void setBtnText(String str) {
        this.mBtnText = str;
        TextView textView = this.mSceneBtn;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setBtnVisibility(boolean z) {
        this.mIsShowBtn = z;
        TextView textView = this.mSceneBtn;
        if (textView != null) {
            if (z) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public void setMax(int i2) {
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setMax(i2);
        }
    }

    public void setOnSceneBtnClickListener(OnSceneBtnClickListener onSceneBtnClickListener) {
        this.mOnSceneBtnClickListener = onSceneBtnClickListener;
    }

    public void setProgress(int i2) {
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setProgress(i2);
        }
    }

    public void setProgressVisibility(boolean z) {
        this.mIsShowProgress = z;
        TextView textView = this.mProgressText;
        if (textView != null) {
            if (z) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            if (z) {
                progressBar.setVisibility(0);
            } else {
                progressBar.setVisibility(8);
            }
        }
    }

    public void setSceneUrl(String str) {
        this.mSceneUrl = str;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        this.mSceneBtn.setText(this.mBtnText);
        this.mTextTitle.setText(this.mTitle);
        this.mSceneImageView.setImageUri(this.mSceneUrl);
        setBtnVisibility(this.mIsShowBtn);
        setProgressVisibility(this.mIsShowProgress);
    }
}
