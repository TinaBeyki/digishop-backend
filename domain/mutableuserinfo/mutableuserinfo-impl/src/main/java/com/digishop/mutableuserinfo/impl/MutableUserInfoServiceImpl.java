package com.digishop.mutableuserinfo.impl;

import org.springframework.stereotype.Service;

@Service
public class MutableUserInfoServiceImpl {

    private IMutableUserInfoRepository iMutableUserInfoRepository;

    private MutableUserInfoServiceImpl(IMutableUserInfoRepository iMutableUserInfoRepository) {
        this.iMutableUserInfoRepository = iMutableUserInfoRepository;
    }
    //------------------------------------------------------------------------------------------------------------------
}
