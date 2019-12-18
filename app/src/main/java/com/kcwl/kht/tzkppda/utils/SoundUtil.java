/**
 * FileName: SoundUtil
 * Author:baijie
 * Date: 2019/8/27 14:33
 * Description: 播放声音的工具类
 */
package com.kcwl.kht.tzkppda.utils;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

import com.kcwl.kht.tzkppda.R;

/**
 * @ClassName: SoundUtil
 * @Description: 播放声音的工具类
 * @Author: baijie
 * @Date: 2019/8/27 14:33
 */
public class SoundUtil
{
    /**
     * 播放声音
     */
    private SoundPool soundPool;
    /**
     * 声音Id
     */
    private int soundId;
    /**
     * 播放的声音ID
     */
    private int streamId;

    public SoundUtil(Context context)
    {
        initSoundPool(context);
    }

    private void initSoundPool(Context context)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            SoundPool.Builder spBuilder = new SoundPool.Builder();
            spBuilder.setMaxStreams(1);
            //AudioAttributes是一个封装音频各种属性的方法
            AudioAttributes.Builder attrBuilder = new AudioAttributes.Builder();
            //设置音频流的合适的属性
            attrBuilder.setLegacyStreamType(AudioManager.STREAM_MUSIC);
            //加载一个AudioAttributes
            spBuilder.setAudioAttributes(attrBuilder.build());
            soundPool = spBuilder.build();
            soundId = soundPool.load(context, R.raw.beepslow, 1);
        } else
        {
            soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        }
    }

    public void playSound()
    {
        //第一个参数soundID
        //第二个参数leftVolume为左侧音量值（范围= 0.0到1.0）
        //第三个参数rightVolume为右的音量值（范围= 0.0到1.0）
        //第四个参数priority 为流的优先级，值越大优先级高，影响当同时播放数量超出了最大支持数时SoundPool对该流的处理
        //第五个参数loop 为音频重复播放次数，0为值播放一次，-1为无限循环，其他值为播放loop+1次
        //第六个参数 rate为播放的速率，范围0.5-2.0(0.5为一半速率，1.0为正常速率，2.0为两倍速率)
        streamId = soundPool.play(soundId, 1, 1, 0, -1, 1);
    }

    public void stopSound()
    {
        if (soundPool != null)
        {
            soundPool.stop(streamId);
        }
    }
}