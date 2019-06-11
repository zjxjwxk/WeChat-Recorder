package com.zjxjwxk.wechat.recorder.model;

/**
 * Recorder 实体类
 * @author zjxjwxk
 */
public class Recorder {
    private float time;
    private String filePath;

    public Recorder(float time, String filePath) {
        this.time = time;
        this.filePath = filePath;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
