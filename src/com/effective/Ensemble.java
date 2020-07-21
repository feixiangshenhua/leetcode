/**
 * Project Name: 邮乐支付系统
 * File Name: Ensemble
 * Package Name: com.effective
 * Date: 2019/11/11 18:02
 * Copyright (c) 2019, 上海邮乐网络技术有限公司
 * author：xiao.y
 */
package com.effective;

/**
 * ClassName: Ensemble <br>
 * Function: 通用枚举. <br>
 * Date: 2019/11/11 18:02 <br>
 */
public enum Ensemble {
    SOLO, DUET, TRIO, QUARTET;
    public int numberOfMusicians(){
        return ordinal() + 1;
    }
}
