package com.timplifier.rickandmorty.common.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.setImage(url: String) =
    Glide.with(this).load(url).into(this)

fun ImageView.setCircularImage(url: String) =
    Glide.with(this).load(url).apply(RequestOptions.circleCropTransform()).into(this)