package com.aldoapps.opmsclass.util

import java.util.*

object RandomUtil {
    fun getDuration() = Random().nextInt(3_000).toLong()
}