package com.timplifier.rickandmorty.common.extensions

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T> Gson.fromJsonList(json: String?): T =
    fromJson(json, object : TypeToken<T>() {}.type)
