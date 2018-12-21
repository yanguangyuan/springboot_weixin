package com.ygy.weixin.handler;

import org.springframework.stereotype.Component;
import org.weixin4j.model.message.OutputMessage;
import org.weixin4j.model.message.normal.*;
import org.weixin4j.model.message.output.TextOutputMessage;
import org.weixin4j.spi.INormalMessageHandler;

/**
 * project_name: springboot_weixin
 * describe: 微信普通消息处理
 *
 * @author : yanguangyuan
 * creat_date: 2018-12-18 13:15
 **/
@Component
public class NormalMessageHandler implements INormalMessageHandler {
    @Override
    public OutputMessage textTypeMsg(TextInputMessage textInputMessage) {
        return new TextOutputMessage("呵呵");
    }

    @Override
    public OutputMessage imageTypeMsg(ImageInputMessage imageInputMessage) {
        return null;
    }

    @Override
    public OutputMessage voiceTypeMsg(VoiceInputMessage voiceInputMessage) {
        return null;
    }

    @Override
    public OutputMessage videoTypeMsg(VideoInputMessage videoInputMessage) {
        return null;
    }

    @Override
    public OutputMessage shortvideoTypeMsg(ShortVideoInputMessage shortVideoInputMessage) {
        return null;
    }

    @Override
    public OutputMessage locationTypeMsg(LocationInputMessage locationInputMessage) {
        return null;
    }

    @Override
    public OutputMessage linkTypeMsg(LinkInputMessage linkInputMessage) {
        return null;
    }
}
