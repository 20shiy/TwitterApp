package com.codepath.apps.restclienttemplate.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import org.json.JSONArray
import org.json.JSONObject
import java.util.*
import kotlin.collections.ArrayList

@Parcelize
class Tweet(var tweetBody: String = "", var createdAt: String = "", var user: User ?= null) :
    Parcelable {


        companion object {
            fun fromJson(jsonObject: JSONObject): Tweet {
                val tweet = Tweet()
                tweet.tweetBody = jsonObject.getString("text")
                tweet.createdAt = jsonObject.getString("created_at")
                tweet.user = User.fromJson(jsonObject.getJSONObject("user"))
                return tweet
            }

            fun fromJsonArray(jsonArray: JSONArray): List<Tweet> {
                val tweets = ArrayList<Tweet>()
                for (i in 0 until jsonArray.length()) {
                    tweets.add(fromJson(jsonArray.getJSONObject(i)))
                }
                return tweets
            }
        }
    }