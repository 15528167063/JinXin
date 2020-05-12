/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.congda.tianjianxin.adapter;

import android.content.Context;


import com.congda.baselibrary.adapter.baseadapter.IMBaseRecycleViewAdapter_T;
import com.congda.baselibrary.adapter.baseadapter.IMBaseViewHolder;
import com.congda.tianjianxin.bean.RecycleDemoBean;

import java.util.ArrayList;
import java.util.List;


/**
 * 投注记录
 */
public class RecycleDemodapter extends IMBaseRecycleViewAdapter_T<RecycleDemoBean> {

    private Context context;

    private List<RecycleDemoBean> datas = new ArrayList<>();

    public RecycleDemodapter(Context context, int layoutId, List<RecycleDemoBean> datas) {
        super(context, layoutId, datas);
        this.context=context;
        this.datas=datas;
    }

    @Override
    protected void convert(IMBaseViewHolder holder, final int position, RecycleDemoBean bean) {

    }
}