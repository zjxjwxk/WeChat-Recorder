package com.zjxjwxk.wechat.recorder.view;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zjxjwxk.wechat.recorder.R;

/**
 * 管理 Dialog
 * @author zjxjwxk
 */
public class DialogManager {
    private Context mContext;
    private ImageView mIcon;
    private ImageView mVoice;
    private TextView mTvLabel;
    private Dialog mDialog;

    DialogManager(Context context) {
        mContext = context;
    }

    /**
     * 显示 Dialog
     */
    void showDialog() {
        mDialog = new Dialog(mContext, R.style.Theme_AudioDialog);
        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_recorder, null);
        mDialog.setContentView(view);

        mIcon = mDialog.findViewById(R.id.iv_dialog_icon);
        mVoice = mDialog.findViewById(R.id.iv_dialog_voice);
        mTvLabel = mDialog.findViewById(R.id.tv_dialog_recorder_label);

        mDialog.show();
    }

    /**
     * 正在录音时的状态
     */
    public void recording(){
        if (mDialog != null && mDialog.isShowing()) {
            mIcon.setVisibility(View.VISIBLE);
            mVoice.setVisibility(View.VISIBLE);
            mTvLabel.setVisibility(View.VISIBLE);

            mIcon.setImageResource(R.drawable.recorder);
            mTvLabel.setText("手指上滑，取消发送");
        }
    }

    /**
     * 试图取消 Dialog
     */
    void wantToCancel() {
        if (mDialog != null && mDialog.isShowing()) {
            mIcon.setVisibility(View.VISIBLE);
            mVoice.setVisibility(View.GONE);
            mTvLabel.setVisibility(View.VISIBLE);

            mIcon.setImageResource(R.drawable.cancel);
            mTvLabel.setText("松开手指，取消发送");
        }
    }

    /**
     * 取消 Dialog
     */
    void dismissDialog() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
            mDialog = null;
        }
    }

    /**
     * 录音过短
     */
    void tooShort() {
        if (mDialog != null && mDialog.isShowing()) {
            mIcon.setVisibility(View.VISIBLE);
            mVoice.setVisibility(View.GONE);
            mTvLabel.setVisibility(View.VISIBLE);

            mIcon.setImageResource(R.drawable.voice_to_short);
            mTvLabel.setText("录音过短");
        }
    }

    /**
     * 根据音量变化更新图标
     */
    void updateVoice(int level) {
        if (mDialog != null && mDialog.isShowing()) {
            //利用方法名获取资源 id
            int resId = mContext.getResources().getIdentifier("v" + level, "drawable", mContext.getPackageName());
            mVoice.setImageResource(resId);
        }
    }
}
