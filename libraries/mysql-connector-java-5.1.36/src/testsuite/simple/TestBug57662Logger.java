Leave GetSystemMode : 查询当前系统模式
2015-09-30 21:28:59:933 Leave SRVGetCurRSSI : 查询当前网络RSSI取值
2015-09-30 21:28:59:933 Enter SRVGetCurPlmn : 查询当前网络选择模式及PLMN 
2015-09-30 21:29:00:027 Leave SRVGetCurPlmn : 查询当前网络选择模式及PLMN
2015-09-30 21:29:00:058 Enter SMSSendMsg : 发送短信 
2015-09-30 21:29:00:058 Enter SendPDUSM : 发送短消息 
2015-09-30 21:29:00:089 Enter GetWMSLocalCfg : 短消息参数查询的函数(只对本地进行操作，不查询短信中心的号码) 
2015-09-30 21:29:00:089 Leave GetWMSLocalCfg : 短消息参数查询的函数(只对本地进行操作，不查询短信中心的号码)
2015-09-30 21:29:01:727 Enter DomainChangedCallback : 服务域变化 
2015-09-30 21:29:03:553 Leave SendPDUSM : 发送短消息
2015-09-30 21:29:03:553 Leave SMSSendMsg : 发送短信
2015-09-30 21:29:03:553 Enter SRVGetCurPlmn : 查询当前网络选择模式及PLMN 
2015-09-30 21:29:03:584 Leave DomainChangedCallback : 服务域变化
2015-09-30 21:29:03:693 Leave SRVGetCurPlmn : 查询当前网络选择模式及PLMN
2015-09-30 21:29:06:775 Enter SMSGetMemInfo : 查询指定存储器类型短信容量的接口 
2015-09-30 21:29:06:783 Leave SMSGetMemInfo : 查询指定存储器类型短信容量的接口
                                                                                                                                                                                                                                                                                                                                                                                                                 sg instanceof ProfilerEvent) {
            this.hasNegativeDurations = ((ProfilerEvent) msg).getEventDuration() < 0;
        }
        super.logInternal(level, msg, exception);
    }
}
