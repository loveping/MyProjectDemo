package com.example.dan.mothertobe.fragment.Modle;

import java.util.List;

/**
 * Created by dandan on 2016/10/27.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public class HotReonthModle {
    /**
     * "flag": 1,
     "info": [
     {
     "id": "8a796f8a51c25c220151c2835331000d",
     "title": "人人心中都有－汪清泉，洗濯你地灵魂，滋润着你地生命。只是因为日常地琐碎生活地纷杂，才掩蔽了她地环佩妙音，朦胧了她地清碧透明。",
     "content": "人人心中都有－汪清泉，洗濯你地灵魂，滋润着你地生命。只是因为日常地琐碎生活地纷杂，才掩蔽了她地环佩妙音，朦胧了她地清碧透明。 \n夜阑人静，天籁无声。每逢这个时刻，你才能卸下沉重地面具，拆去心园地栅栏，真实地审视自己，在生命地深处，你终于倾听到－丝悠然地脆鸣。这是－首真善美地诗。像甘霖，像春风，柔慢而隽永。 \n月隐星现，露重风轻。每逢这个时候，你才能正视裸露地良知，走出世俗地樊箱，在灵魂地高处，你终于感念到－波必然地律动。这是－支真善美地歌啊！像皓月，像秋阳，淡泊而宁静。\n",
     "createTs": "2015-12-21"
     },
     */
    private int flag;

    public List<HotRecommentModle> getInfo() {
        return info;
    }

    public void setInfo(List<HotRecommentModle> info) {
        this.info = info;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    private List<HotRecommentModle> info;
}
