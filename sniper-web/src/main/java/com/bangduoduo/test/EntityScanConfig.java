package com.bangduoduo.test;

import com.bangduoduo.orm.EntityScanner;
import com.bangduoduo.orm.annotation.EntityScan;

@EntityScan("com.bangduoduo.test.doamin")
public class EntityScanConfig implements EntityScanner{
}
