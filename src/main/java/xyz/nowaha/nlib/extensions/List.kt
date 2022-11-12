package xyz.nowaha.nlib.extensions

fun <T> List<T>.getOr(index: Int, default: T): T = if (index < size) get(index) else default