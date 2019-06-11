package com.zjxjwxk.wechat.recorder.view;

/**
 * 录音完成之后的回调接口
 * @author zjxjwxk
 */
public interface AudioFinishedListener {
    void onFinish(float seconds, String filePath);
}
